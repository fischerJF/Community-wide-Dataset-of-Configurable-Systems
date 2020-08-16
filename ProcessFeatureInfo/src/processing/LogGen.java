package processing;

import java.io.File;
import java.util.List;
import java.util.Optional;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.stmt.IfStmt;

@Deprecated // just a backup of a previous version of SpreadsheetGen
public class LogGen {

	static String localPathToGitProject = "";
	static final String pathToRootSource = "vamos2020/workspace_IncLing/";

	static String[] pathsToSource = {
			//"argouml-spl-master/src/?/",
			"ATM/src/atm/",
			"bankaccount/src/bankaccount/",
			//"checkstyle/src/?/",
			//"Chess/src/?/",
			//"companies/src/?/",
			"Elevator/src/elevatorsystem/",
			"email/src/main/java/email/",
			"FeatureAMP1/src/featureAmp/",
			//"FeatureAMP2/src/?/",
			"FeatureAMP3/src/featureamp/",
			"FeatureAMP4/src/featureAMP/",
			//"FeatureAMP5/src/?/",
			//"FeatureAMP6/src/featureamp/", what else???
			//"FeatureAMP7/src/?/",
			//"FeatureAMP8/src/?/",
			//"FeatureAMP9/src/?/",
			//"GPL/src/?/",
			"JTopas/src/de/susebox/jtopas/",
			"MinePump/src/MinePumpSystem/",
			//"Notepad/src/?/",
			"Paycard/src/paycard/",
			"Prop4J-SPL/src/main/java/Prop4J/",
			"Set/src/Set/",
			"sudoku/src/main/",
			"Task/src/tasks/",
			"Telecon/src/telecom/",
			"UnionFind/src/UnionFind/",
			"vending/src/vending/",
			"zipme/src/net/sf/zipme/"
	};

	public static void main(String[] args) {

//		String configurationFileName = "specifications/Configuration.java";
//		processConfigurationClass();
//		String pathToSource = "Elevator/src/elevatorsystem/Elevator.java";
//		CompilationUnit c = IO.getCompilationUnitFromFile(new File(localPathToGitProject + pathToRootSource + pathToSource));
		
		for (String pathToSource : pathsToSource) {
			processSystem(pathToSource);
		}
	}
	
	public static void processSystem(String pathToSource) {
		
		System.out.println("\n\n#### System " + pathToSource + " ####\n");
		
		List<File> javaFiles = IO.allJavaFilesIn(localPathToGitProject + pathToRootSource + pathToSource);
		for (File javaFile : javaFiles) {
			System.out.println("*** " + javaFile + " ***");
			processSystemClass(javaFile);
			System.out.println();
		}
	}

	public static void processConfigurationClass(String configurationFileName) {
		
		File configFile = new File(localPathToGitProject + pathToRootSource + configurationFileName);
		CompilationUnit configAST = IO.getCompilationUnitFromFile(configFile);
		
		// finding configuration attributes
		configAST.findAll(FieldDeclaration.class, x -> x.isPublic() && x.isStatic()).stream()
				.map(x -> x.getVariable(0))
				.forEach( x -> System.out.println(x.getType() + " " + x) );
		
		System.out.println();
	}

	public static void processSystemClass(File inputFile) {
		
		CompilationUnit inputAST = IO.getCompilationUnitFromFile(inputFile);

		List<FieldAccessExpr> featureAccesses = inputAST.findAll(FieldAccessExpr.class,
				x -> x.getScope().toString().equals("Configuration") ||
						x.getScope().toString().equals("specifications.Configuration"));

		for (FieldAccessExpr featureAccess : featureAccesses) {
			System.out.println("* " + featureAccess + ":");

			boolean negation = false;
			Node parent = featureAccess.getParentNode().get(); 
			if (parent instanceof UnaryExpr) {
				UnaryExpr ue = (UnaryExpr)parent;
				if (ue.getOperator().equals(UnaryExpr.Operator.LOGICAL_COMPLEMENT)) {
					negation = true; //TODO
					System.out.println("Negation: " + parent);
					continue;
				}
				else {
					System.err.println("TODO check: not a logical complement");
				}
			}

			Optional<IfStmt> tempIf = featureAccess.findAncestor(IfStmt.class);
			Optional<ConditionalExpr> tempCond = featureAccess.findAncestor(ConditionalExpr.class);

			if (tempCond.isPresent()) {

				VariableDeclarator condExprParent = tempCond.get().findAncestor(VariableDeclarator.class).get();
				//TODO try field declaration, variable declaration expression, assign expression/statement
				System.out.println(condExprParent);

				int beginLine = condExprParent.getBegin().get().line;
				int endLine = condExprParent.getEnd().get().line;

				int qtdLines = endLine - beginLine + 1;
				System.out.println(qtdLines + " lines: from " + beginLine + " to " + endLine);
				
				handleOperationAndClassInfo(condExprParent);
			}
			else if (tempIf.isPresent()) {
				IfStmt parentIf = tempIf.get();
				System.out.println(parentIf);

				// lines
				int beginLine = parentIf.getBegin().get().line;
				int endLine = parentIf.getEnd().get().line;
				
				if (parentIf.getElseStmt().isPresent()) {
					System.out.println("Has else and does not end at line " + endLine + ".");
					endLine = parentIf.getElseStmt().get().getBegin().get().line;
				}

				int qtdLines = endLine - beginLine + 1;
				System.out.println(qtdLines + " lines: from " + beginLine + " to " + endLine);
				
				handleOperationAndClassInfo(parentIf);
			}
			else {
				System.err.println(">>> TODO check: no if and conditional statement at line "
						+ parent.getBegin().get().line);
				System.out.println(parent);
			}
			System.out.println();
		}
	}
	
	private static void handleOperationAndClassInfo(Node parentNode) {

		Optional<MethodDeclaration> opMethod = parentNode.findAncestor(MethodDeclaration.class);
		Optional<ConstructorDeclaration> opConstructor = parentNode.findAncestor(ConstructorDeclaration.class);
		@SuppressWarnings("rawtypes")
		Optional<TypeDeclaration> opClass = parentNode.findAncestor(TypeDeclaration.class);

		if (opMethod.isPresent()) {
			System.out.println("- Method: " + opMethod.get().getDeclarationAsString());
		}
		else if (opConstructor.isPresent()) {
			System.out.println("- Constructor: " + opConstructor.get().getDeclarationAsString());
		}
		else {
			System.out.println(">>> TODO check: no method/constructor (maybe block)");
		}

		if (opClass.isPresent()) {
			TypeDeclaration<?> aClass = opClass.get();
			System.out.println("- Class info:");
			System.out.println(aClass.findCompilationUnit().get().getPackageDeclaration().get().getNameAsString());
			System.out.println(aClass.getNameAsString());
			System.out.println("Nested: " + aClass.isNestedType()); // TODO verify this
		}
		else {
			System.err.println(">>> TODO check: no class/interface/enum");
		}

		System.out.println();
	}
}
