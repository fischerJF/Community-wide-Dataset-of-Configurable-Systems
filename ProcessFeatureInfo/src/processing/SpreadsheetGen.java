package processing;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.expr.ConditionalExpr;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.UnaryExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.IfStmt;

/**
 * @author jpaulo
 */
public class SpreadsheetGen {

	static String localPathToGitProject = ""; //TODO include path
	static final String workspaceIncLing = "workspace_IncLing/";
	static final String workspaceMutants = "dataset_with_mutant/";
	
	static String currentSystem;
	static String currentFeature;
	
	static Map<String, FeatureEntry> allFeaturesInfo = new LinkedHashMap<>();

	static String[] pathsToSource = {
			workspaceIncLing + "argouml-spl-master/src/argouml-app/src/", // 2 ArgoUML sources
			workspaceIncLing + "argouml-spl-master/src/argouml-core-model-mdr/src/",

			workspaceMutants + "ATM/src/main/java/",
			
			workspaceMutants + "bankaccount/src/main/java/",

			workspaceMutants + "checkstyle/src/main/java/",
			
			workspaceMutants + "chess/src/main/java/",
			
			workspaceMutants + "companies/src/main/java/",
			
			workspaceMutants + "Elevator/src/main/java/",

			workspaceMutants + "email/src/main/java/",
			
			workspaceMutants + "FeatureAMP1/src/main/java/",
			
			workspaceMutants + "FeatureAMP2/src/main/java/",
			
			workspaceMutants + "FeatureAMP3/src/main/java/",
			
			workspaceMutants + "FeatureAMP4/src/main/java/",

			workspaceMutants + "FeatureAMP5/src/main/java/",
			
			workspaceMutants + "FeatureAMP6/src/main/java/",
			
			workspaceMutants + "FeatureAMP7/src/main/java/",
			
			workspaceMutants + "FeatureAMP8/src/main/java/",
			
			workspaceMutants + "FeatureAMP9/src/main/java/",
			
			workspaceMutants + "GPL/src/main/java/",
			
			workspaceMutants + "jtopas/src/main/java/",
			
			workspaceMutants + "MinePump/src/main/java/",
			
			workspaceMutants + "Notepad-FH-Java/src/main/java/",

			workspaceMutants + "Paycard/src/main/java/",
			
			workspaceMutants + "Prop4J-SPL/src/main/java/",
			
			workspaceMutants + "Set/src/main/java/",
			
			workspaceMutants + "sudoku/src/main/",
			
			workspaceIncLing + "Task/src/tasks/",
			
			workspaceMutants + "Telecom/src/main/java/",
			
			workspaceMutants + "UnionFind/src/main/java/",
			
			workspaceMutants + "vending/src/main/java/",
			
			workspaceMutants + "zipme/src/main/java/"
	};

	public static void main(String[] args) {

		for (String pathToSource : pathsToSource) {
			processSystem(pathToSource);
		}
		
		IO.generateSpreadsheet(allFeaturesInfo);
	}

	public static void processSystem(String pathToSource) {
		
		int index1 = pathToSource.indexOf('/') + 1;
		int index2 = pathToSource.indexOf('/', index1 + 1);
		currentSystem = pathToSource.substring(index1, index2);
		System.out.println("\n\n#### System " + currentSystem + " ####\n");

		List<File> javaFiles = IO.allJavaFilesIn(localPathToGitProject + pathToSource);
		for (File javaFile : javaFiles) {
			System.out.println("*** " + javaFile + " ***");
			processSystemClass(javaFile);
			System.out.println();
		}
	}

	public static void processSystemClass(File inputFile) {
		
		CompilationUnit inputAST = IO.getCompilationUnitFromFile(inputFile);

		List<FieldAccessExpr> featureAccesses = inputAST.findAll(FieldAccessExpr.class,
				x -> x.getScope().toString().equals("Configuration") ||
						x.getScope().toString().equals("specifications.Configuration"));

		for (FieldAccessExpr featureAccess : featureAccesses) {
			System.out.println("* " + featureAccess + ":");

			Node parent = featureAccess.getParentNode().get(); 
			if (parent instanceof UnaryExpr) {
				UnaryExpr ue = (UnaryExpr)parent;
				if (ue.getOperator().equals(UnaryExpr.Operator.LOGICAL_COMPLEMENT)) {
					System.out.println("Negation: " + parent);
					FeatureEntry general = retrieveFeatureEntry();
					general.incrementOccurrences();
					continue;
				}
				else {
					System.err.println("TODO check: not a logical complement");
				}
			}

			Optional<IfStmt> tempIf = featureAccess.findAncestor(IfStmt.class);
			Optional<ConditionalExpr> tempCond = featureAccess.findAncestor(ConditionalExpr.class);
			
			currentFeature = featureAccess.getNameAsString();
			int beginLine = 0;
			int endLine = 0;
			FeatureInfoAux featureInfo = null;

			if (tempCond.isPresent()) {

				//TODO check FeatureAMP6 class FeatureAmp lines 93 and 94 -> nested conditional
				//TODO try field declaration, variable declaration expression, assign expression/statement
//				VariableDeclarator condExprParent = tempCond.get().findAncestor(VariableDeclarator.class).get();
//				System.out.println(condExprParent);
//				beginLine = condExprParent.getBegin().get().line;
//				endLine = condExprParent.getEnd().get().line;
//				featureInfo = handleOperationAndClassInfo(condExprParent);

				beginLine = tempCond.get().getBegin().get().line;
				endLine = tempCond.get().getEnd().get().line;
				featureInfo = handleOperationAndClassInfo(tempCond.get());
			}
			else if (tempIf.isPresent()) {
				IfStmt parentIf = tempIf.get();
				System.out.println(parentIf);
				
				List<FieldAccessExpr> featureAccessesIf = parentIf.findAll(FieldAccessExpr.class,
						x -> (x.getScope().toString().equals("Configuration") ||
								x.getScope().toString().equals("specifications.Configuration"))
								&& !x.getNameAsString().equals(currentFeature));
				if (!featureAccessesIf.isEmpty()) {
					retrieveFeatureEntry().updateOtherFeatures(1);
					System.out.println(">> occurrences of other feature(s) in the above if\n");
				}

				// lines
				// TODO check if statements with comments (e.g. GoNamespaceToDiagram.getRuleName in ArgoUML)
				beginLine = parentIf.getBegin().get().line;
				endLine = parentIf.getEnd().get().line;
				
				if (parentIf.getElseStmt().isPresent()) {
					System.out.println("Has else and does not end at line " + endLine + ".");
					endLine = parentIf.getElseStmt().get().getBegin().get().line;
				}

				featureInfo = handleOperationAndClassInfo(parentIf);
			}
			else {
				System.out.println(">>> TODO check: no if/conditional statement at line "
						+ parent.getBegin().get().line);
				System.out.println(parent);
				continue;
			}
			
			int qtdLines = endLine - beginLine + 1;
			System.out.println(qtdLines + " lines: from " + beginLine + " to " + endLine);
			System.out.println();
			
			updateInfo(featureInfo, qtdLines);
		}
	}

	private static FeatureEntry retrieveFeatureEntry() {

		String key = currentSystem + "." + currentFeature;
		FeatureEntry general = allFeaturesInfo.get(key);
		
		if (general == null) {
			general = new FeatureEntry(currentSystem, currentFeature);
			allFeaturesInfo.put(key, general);
		}

		return general;
	}
	
	private static void updateInfo(FeatureInfoAux info, int qtdLines) {

		FeatureEntry general = retrieveFeatureEntry();

		general.updateClasses(info.classs);
		general.updateConstructors(info.constructor);
		general.updateMethods(info.method);
		general.updateBlocks(info.block);
		general.updateLOCs(qtdLines);
		general.incrementOccurrences();
	}

	private static FeatureInfoAux handleOperationAndClassInfo(Node parentNode) {

		FeatureInfoAux info = new FeatureInfoAux();
		@SuppressWarnings("rawtypes")
		Optional<TypeDeclaration> opClass = parentNode.findAncestor(TypeDeclaration.class);
		Optional<ConstructorDeclaration> opConstructor = parentNode.findAncestor(ConstructorDeclaration.class);
		Optional<MethodDeclaration> opMethod = parentNode.findAncestor(MethodDeclaration.class);
		
		if (opClass.isPresent()) {
			TypeDeclaration<?> aClass = opClass.get();
			String pkg = aClass.findCompilationUnit().get().getPackageDeclaration().get().getNameAsString();
			info.classs = pkg + "." + aClass.getNameAsString();

			System.out.println("- Class info:");
			System.out.println(pkg + "." + aClass.getNameAsString());
			System.out.println("Nested: " + aClass.isNestedType()); // TODO verify this
		}
		else {
			System.err.println(">>> TODO check: no class/interface/enum");
		}

		if (opMethod.isPresent()) {
			String method = opMethod.get().getDeclarationAsString(); 
			info.method = info.classs + "." + method;
			System.out.println("- Method: " + opMethod.get().getDeclarationAsString());
		}
		else if (opConstructor.isPresent()) {
			info.constructor = opConstructor.get().getDeclarationAsString();
			System.out.println("- Constructor: " + opConstructor.get().getDeclarationAsString());
		}
		else {
			Optional<BlockStmt> optional = parentNode.findAncestor(BlockStmt.class);

			if (optional.isPresent()) {
				BlockStmt block = optional.get();
				info.block = info.classs + "." + block.getBegin().get().line;
				System.out.println("- Block start: " + info.block);
			}
			else {
				System.out.println(">>> TODO check: no constructor/method/block statement at line "
						+ parentNode.getBegin().get().line);
			}
		}

		return info;
	}
}
