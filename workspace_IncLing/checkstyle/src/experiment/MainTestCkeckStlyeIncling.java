package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.SpecificationCheckStyle;

import specifications.Configuration;
import splat.CheckStlyeVariables;
import splat.GPLVariables;
import testset.TestAll;


public class MainTestCkeckStlyeIncling {
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
				
				
				
				if (f.getName().equals("ArrayTypeStyle")) {
				Configuration.ArrayTypeStyle= (f.getState().equals("0") ? false : true);
				}		
						
				else if (f.getName().equals("AvoidEscapedUnicodeCharacters")) {
				Configuration.AvoidEscapedUnicodeCharacters= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("FinalParameters")) {
				Configuration.FinalParameters= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NewlineAtEndOfFile")) {
				Configuration.NewlineAtEndOfFile= (f.getState().equals("0") ? false : true);
				}		
						
					
				else if (f.getName().equals("OuterTypeFilename")) {
				Configuration.OuterTypeFilename=	(f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("Regexp")) {
				Configuration.Regexp= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("RegexpignoreComments")) {
				Configuration.RegexpignoreComments= (f.getState().equals("0") ? false : true);
				}		
				
				else  if (f.getName().equals("RegexpillegalPattern")) {
				Configuration.RegexpillegalPattern= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("RegexpcheckForDuplicates")) {
				Configuration.RegexpcheckForDuplicates= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("TodoComment")) {
				Configuration.TodoComment= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("TrailingComment")) {
				Configuration.TrailingComment= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("Translation")) {
				Configuration.Translation= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("UncommentedMain")) {
				Configuration.UncommentedMain= (f.getState().equals("0") ? false : true);
				}		
						
				else if (f.getName().equals("UpperEll")) {
				Configuration.UpperEll= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AnnotationUseStyle")) {
				Configuration.AnnotationUseStyle= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AnnotationLocation")) {
				Configuration.AnnotationLocation= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("MissingDeprecated")) {
				Configuration.MissingDeprecated= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MissingOverride")) {
				Configuration.MissingOverride= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("PackageAnnotation")) {
				Configuration.PackageAnnotation= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("SuppressWarnings")) {
				Configuration.SuppressWarnings= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AvoidNestedBlocks")) {
				Configuration.AvoidNestedBlocks= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("EmptyBlock")) {
				Configuration.EmptyBlock= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("EmptyCatchBlock")) {
				Configuration.EmptyCatchBlock= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("LeftCurly")) {
				Configuration.LeftCurly= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NeedBraces")) {
				Configuration.NeedBraces= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NeedBracesAllowSingleLineIf")) {
				Configuration.NeedBracesAllowSingleLineIf= (f.getState().equals("0") ? false : true);
				}		
						
						
				else  if (f.getName().equals("RightCurly")) {
				Configuration.RightCurly= (f.getState().equals("0") ? false : true);
				}		
						
						
						
				else if (f.getName().equals("ArrayTrailingComma")) {
				Configuration.ArrayTrailingComma= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AvoidInlineConditionals")) {
				Configuration.AvoidInlineConditionals= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("CovariantEquals")) {
				Configuration.CovariantEquals= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("DeclarationOrder")) {
				Configuration.DeclarationOrder= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("DefaultComesLast")) {
				Configuration.DefaultComesLast= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("EmptyStatement")) {
				Configuration.EmptyStatement= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("EqualsAvoidNull")) {
				Configuration.EqualsAvoidNull= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("EqualsHashCode")) {
				Configuration.EqualsHashCode= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ExplicitInitialization")) {
				Configuration.ExplicitInitialization= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("FallThrough")) {
				Configuration.FallThrough= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("FinalLocalVariable")) {
				Configuration.FinalLocalVariable= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("HiddenField")) {
				Configuration.HiddenField= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 		if (f.getName().equals("IllegalCatch")) {
				Configuration.IllegalCatch= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("IllegalInstantiation")) {
				Configuration.IllegalInstantiation= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("IllegalThrows")) {
				Configuration.IllegalThrows= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("IllegalToken")) {
				Configuration.IllegalToken= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("TW")) {
				Configuration.TW= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("RegexpMultiline")) {
				Configuration.RegexpMultiline= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("RegexpSingleline")) {
				Configuration.RegexpSingleline= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("RegexpSinglelineJava")) {
				Configuration.RegexpSinglelineJava= (f.getState().equals("0") ? false : true);
				}	
						
				else if (f.getName().equals("HeaderCheck")) {
				Configuration.HeaderCheck	= (f.getState().equals("0") ? false : true);
					
				}	
				
				else if (f.getName().equals("RegexpHeaderCheck")) {
				Configuration.RegexpHeaderCheck	= (f.getState().equals("0") ? false : true);
				}	
				
				else if (f.getName().equals("AvoidStarImportCheck")) {	
				Configuration.AvoidStarImportCheck	= (f.getState().equals("0") ? false : true);
				}	
						
				else if (f.getName().equals("CustomImportOrder")) {
				Configuration.CustomImportOrder= (f.getState().equals("0") ? false : true);
				}		
						
					
				else if (f.getName().equals("IllegalImport")) {
				Configuration.IllegalImport	= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ImportControl")) {
				Configuration.ImportControl= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ImportOrder")) {
				Configuration.ImportOrder= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("RedundantImport")) {
				Configuration.RedundantImport= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("UnusedImports")) {
				Configuration.UnusedImports= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("BooleanExpressionComplexity")) {
				Configuration.BooleanExpressionComplexity= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ClassDataAbstractionCouplingCheck")) {
				Configuration.ClassDataAbstractionCouplingCheck= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ClassFanOutComplexityCheck")) {
				Configuration.ClassFanOutComplexityCheck= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("CyclomaticComplexity")) {
				Configuration.CyclomaticComplexity= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("JavaNCSS")) {
				Configuration.JavaNCSS= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NPathComplexity")) {
				Configuration.NPathComplexity= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ModifierOrder")) {
				Configuration.ModifierOrder= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("RedundantModifier")) {
				Configuration.RedundantModifier= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("DesignForExtension")) {
				Configuration.DesignForExtension= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("HideUtilityClassConstructor")) {
				Configuration.HideUtilityClassConstructor= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("InnerTypeLast")) {
				Configuration.InnerTypeLast= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("InterfaceIsType")) {
				Configuration.InterfaceIsType= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("OneTopLevelClass")) {
				Configuration.OneTopLevelClass= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ThrowsCount")) {
				Configuration.ThrowsCount= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("VisibilityModifier")) {
				Configuration.VisibilityModifier= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("IllegalTypeCheck")) {
				Configuration.IllegalTypeCheck= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("InnerAssignment")) {
				Configuration.InnerAssignment= (f.getState().equals("0") ? false : true);
				}		
						
				else if (f.getName().equals("MagicNumber")) {
				Configuration.MagicNumber= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MissingCtor")) {
				Configuration.MissingCtor= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MissingSwitchDefault")) {
				Configuration.MissingSwitchDefault= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ModifiedControlVariable")) {
				Configuration.ModifiedControlVariable= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("MultipleStringLiterals")) {
				Configuration.MultipleStringLiterals= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MultipleVariableDeclarations")) {
				Configuration.MultipleVariableDeclarations= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NestedForDepth")) {
				Configuration.NestedForDepth= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("FinalClass")) {
				Configuration.FinalClass= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MutableExceptionCheck")) {
				Configuration.MutableExceptionCheck= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("IllegalTokenTextCheck")) {
				Configuration.IllegalTokenTextCheck= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("Indentation")) {
				Configuration.Indentation= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("IndentationForceStrictCondition;")) {
				Configuration.IndentationForceStrictCondition= (f.getState().equals("0") ? false : true);
				}		
						
				else 	if (f.getName().equals("NestedIfDepth")) {
				Configuration.NestedIfDepth= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NestedTryDepth")) {
				Configuration.NestedTryDepth= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NoClone")) {
				Configuration.NoClone= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NoFinalizer")) {
				Configuration.NoFinalizer= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("OneStatementPerLine")) {
				Configuration.OneStatementPerLine= (f.getState().equals("0") ? false : true);
					
				}	
						
				else 	if (f.getName().equals("OverloadMethodsDeclarationOrder")) {	
				Configuration.OverloadMethodsDeclarationOrder= (f.getState().equals("0") ? false : true);
				}
				else if (f.getName().equals("PackageDeclaration")) {
				Configuration.PackageDeclaration	= (f.getState().equals("0") ? false : true);
				}		
						
					
				else 	if (f.getName().equals("ParameterAssignment")) {
				Configuration.ParameterAssignment= (f.getState().equals("0") ? false : true);	
				}		
						
					
				else if (f.getName().equals("RequireThis")) {
				Configuration.RequireThis	= (f.getState().equals("0") ? false : true);
				}		
						
				else if (f.getName().equals("ReturnCountCheck")) {
				Configuration.ReturnCountCheck	= (f.getState().equals("0") ? false : true);
				}		
						
				else 	if (f.getName().equals("SimplifyBooleanExpression")) {
						                                
				Configuration.SimplifyBooleanExpression = (f.getState().equals("0") ? false : true);
				}
						
						
				else 	if (f.getName().equals("SimplifyBooleanReturn")) {
				Configuration.SimplifyBooleanReturn= (f.getState().equals("0") ? false : true);
				}	
						
						
				else if (f.getName().equals("StringLiteralEquality")) {
				Configuration.StringLiteralEquality= (f.getState().equals("0") ? false : true);
				}	
						
						
				else 	if (f.getName().equals("SuperClone")) {
				Configuration.SuperClone= (f.getState().equals("0") ? false : true);
				}	
						
						
				else 	if (f.getName().equals("SuperFinalize")) {
				Configuration.SuperFinalize= (f.getState().equals("0") ? false : true);
				}
				
				else 	if (f.getName().equals("UnnecessaryParentheses")) {
				Configuration.UnnecessaryParentheses= (f.getState().equals("0") ? false : true);	
				}		
				
				else if (f.getName().equals("VariableDeclarationUsageDistance")) {	
				Configuration.VariableDeclarationUsageDistance= (f.getState().equals("0") ? false : true);	
				}		
					
				else if (f.getName().equals("AtclauseOrder")) {	
				Configuration.AtclauseOrder	= (f.getState().equals("0") ? false : true);
					
				}		
					
				else 	if (f.getName().equals("JavadocMethod")) {
				Configuration.JavadocMethod	= (f.getState().equals("0") ? false : true);
				}		
					
					
				else 	if (f.getName().equals("JavadocPackage")) {
				Configuration.JavadocPackage= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("JavadocParagraph")) {
				Configuration.JavadocParagraph= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("JavadocStyle")) {
				Configuration.JavadocStyle= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("JavadocTagContinuationIndentation")) {
				Configuration.JavadocTagContinuationIndentation= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("JavadocType")) {
				Configuration.JavadocType= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("JavadocVariable")) {
				Configuration.JavadocVariable= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NonEmptyAtclauseDescription")) {
				Configuration.NonEmptyAtclauseDescription= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("SingleLineJavadoc")) {
				Configuration.SingleLineJavadoc= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("SummaryJavadoc")) {
				Configuration.SummaryJavadoc= (f.getState().equals("0") ? false : true);
				}		
						
						
						
				else if (f.getName().equals("WriteTag")) {
				Configuration.WriteTag= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AbbreviationAsWordInName")) {
				Configuration.AbbreviationAsWordInName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AbbreviationAsWordInNameignoreFinal")) {
				Configuration.AbbreviationAsWordInNameignoreFinal= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AbbreviationAsWordInNameignoreStatic")) {
				Configuration.AbbreviationAsWordInNameignoreStatic= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("AbbreviationAsWordInNameignoreOverriddenMethods")) {
				Configuration.AbbreviationAsWordInNameignoreOverriddenMethods= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AbstractClassName")) {
				Configuration.AbstractClassName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AbstractClassNameignoreModifier")) {
				Configuration.AbstractClassNameignoreModifier= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("AbstractClassNameignoreName")) {
				Configuration.AbstractClassNameignoreName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("ClassTypeParameterName")) {
				Configuration.ClassTypeParameterName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("ConstantName")) {
				Configuration.ConstantName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("InterfaceTypeParameterName")) {
				Configuration.InterfaceTypeParameterName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("LocalFinalVariableName")) {
				Configuration.LocalFinalVariableName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("LocalVariableName")) {
				Configuration.LocalVariableName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("LocalVariableNameallowOneCharVarInForLoop")) {
				Configuration.LocalVariableNameallowOneCharVarInForLoop= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MemberName")) {
				Configuration.MemberName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MethodName")) {
				Configuration.MethodName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MethodNameallowClassName")) {
				Configuration.MethodNameallowClassName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MethodTypeParameterName")) {
				Configuration.MethodTypeParameterName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("PackageName")) {
				Configuration.PackageName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ParameterName")) {
				Configuration.ParameterName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("StaticVariableName")) {
				Configuration.StaticVariableName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("TypeName")) {
				Configuration.TypeName= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("AnonInnerLength")) {
				Configuration.AnonInnerLength= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("ExecutableStatementCount")) {
				Configuration.ExecutableStatementCount= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("FileLength")) {
				Configuration.FileLength= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("LineLength")) {
				Configuration.LineLength= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MethodCount")) {
				Configuration.MethodCount= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MethodLength")) {
				Configuration.MethodLength= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("OuterTypeNumber")) {
				Configuration.OuterTypeNumber= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ParameterNumber")) {
				Configuration.ParameterNumber= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("EmptyForIteratorPad")) {
				Configuration.EmptyForIteratorPad= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("EmptyLineSeparator")) {
				Configuration.EmptyLineSeparator= (f.getState().equals("0") ? false : true);
				}		
						
				else if (f.getName().equals("EmptyLineSeparatorallowNoEmptyLineBetweenFields")) {
				Configuration.EmptyLineSeparatorallowNoEmptyLineBetweenFields= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("EmptyLineSeparatorallowMultipleEmptyLines")) {
				Configuration.EmptyLineSeparatorallowMultipleEmptyLines= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("FileTabCharacter")) {
				Configuration.FileTabCharacter= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("GenericWhitespace")) {
				Configuration.GenericWhitespace= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("MethodParamPad")) {
				Configuration.MethodParamPad= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NoLineWrap")) {
				Configuration.NoLineWrap= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NoWhitespaceAfter")) {
				Configuration.NoWhitespaceAfter= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("NoWhitespaceBefore")) {
				Configuration.NoWhitespaceBefore= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("OperatorWrap")) {
				Configuration.OperatorWrap= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("ParenPad")) {
				Configuration.ParenPad= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("SeparatorWrap")) {
				Configuration.SeparatorWrap= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("TypecastParenPad")) {
				Configuration.TypecastParenPad= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("WhitespaceAfter")) {
				Configuration.WhitespaceAfter= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("WhitespaceAround")) {
				Configuration.WhitespaceAround= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("WhitespaceAroundAllowEmptyCtors")) {
				Configuration.WhitespaceAroundAllowEmptyCtors= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("WhitespaceAroundAllowEmptyMethods")) {
				Configuration.WhitespaceAroundAllowEmptyMethods= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("WhitespaceAroundAllowEmptyTypes")) {
				Configuration.WhitespaceAroundAllowEmptyTypes= (f.getState().equals("0") ? false : true);
				}		
						
						
				else if (f.getName().equals("WhitespaceAroundAllowEmptyLoops")) {
				Configuration.WhitespaceAroundAllowEmptyLoops= (f.getState().equals("0") ? false : true);
				}		
						
						
				else 	if (f.getName().equals("WhitespaceAroundIgnoreEnhancedForColon")) {
				Configuration.WhitespaceAroundIgnoreEnhancedForColon= (f.getState().equals("0") ? false : true);
						
				}
				
			  }
			Configuration.productPrint();
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
						TestAll.class
						);
				/* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();

featureName.add("WRITETAG");
featureName.add("WHITESPACEAROUNDIGNOREENHANCEDFORCOLON");
featureName.add("WHITESPACEAROUNDALLOWEMPTYTYPES");
featureName.add("WHITESPACEAROUNDALLOWEMPTYMETHODS");
featureName.add("WHITESPACEAROUNDALLOWEMPTYLOOPS");
featureName.add("WHITESPACEAROUNDALLOWEMPTYCTORS");
featureName.add("WHITESPACEAROUND");
featureName.add("WHITESPACEAFTER");
featureName.add("VISIBILITYMODIFIER");
featureName.add("VARIABLEDECLARATIONUSAGEDISTANCE");
featureName.add("UPPERELL");
featureName.add("UNUSEDIMPORTS");
featureName.add("UNNECESSARYPARENTHESES");
featureName.add("UNCOMMENTEDMAIN");
featureName.add("TYPECASTPARENPAD");
featureName.add("TYPENAME");
featureName.add("TRANSLATION");
featureName.add("TRAILINGCOMMENT");
featureName.add("TODOCOMMENT");
featureName.add("THROWSCOUNT");
featureName.add("TW");
featureName.add("SUPPRESSWARNINGS");
featureName.add("SUPERFINALIZE");
featureName.add("SUPERCLONE");
featureName.add("SUMMARYJAVADOC");
featureName.add("STRINGLITERALEQUALITY");
featureName.add("STATICVARIABLENAME");
featureName.add("SINGLELINEJAVADOC");
featureName.add("SIMPLIFYBOOLEANRETURN");
featureName.add("SIMPLIFYBOOLEANEXPRESSION");
featureName.add("SEPARATORWRAP");
featureName.add("RIGHTCURLY");
featureName.add("RETURNCOUNTCHECK");
featureName.add("REQUIRETHIS");
featureName.add("REGEXPILLEGALPATTERN");
featureName.add("REGEXPIGNORECOMMENTS");
featureName.add("REGEXPCHECKFORDUPLICATES");
featureName.add("REGEXPSINGLELINEJAVA");
featureName.add("REGEXPSINGLELINE");
featureName.add("REGEXPMULTILINE");
featureName.add("REGEXPHEADERCHECK");
featureName.add("REGEXP");
featureName.add("REDUNDANTMODIFIER");
featureName.add("REDUNDANTIMPORT");
featureName.add("PARENPAD");
featureName.add("PARAMETERNUMBER");
featureName.add("PARAMETERNAME");
featureName.add("PARAMETERASSIGNMENT");
featureName.add("PACKAGENAME");
featureName.add("PACKAGEDECLARATION");
featureName.add("PACKAGEANNOTATION");
featureName.add("OVERLOADMETHODSDECLARATIONORDER");
featureName.add("OUTERTYPENUMBER");
featureName.add("OUTERTYPEFILENAME");
featureName.add("OPERATORWRAP");
featureName.add("ONETOPLEVELCLASS");
featureName.add("ONESTATEMENTPERLINE");
featureName.add("NONEMPTYATCLAUSEDESCRIPTION");
featureName.add("NOWHITESPACEBEFORE");
featureName.add("NOWHITESPACEAFTER");
featureName.add("NOLINEWRAP");
featureName.add("NOFINALIZER");
featureName.add("NOCLONE");
featureName.add("NEWLINEATENDOFFILE");
featureName.add("NESTEDTRYDEPTH");
featureName.add("NESTEDIFDEPTH");
featureName.add("NESTEDFORDEPTH");
featureName.add("NEEDBRACESALLOWSINGLELINEIF");
featureName.add("NEEDBRACES");
featureName.add("NPATHCOMPLEXITY");
featureName.add("MUTABLEEXCEPTIONCHECK");
featureName.add("MULTIPLEVARIABLEDECLARATIONS");
featureName.add("MULTIPLESTRINGLITERALS");
featureName.add("MODIFIERORDER");
featureName.add("MODIFIEDCONTROLVARIABLE");
featureName.add("MISSINGSWITCHDEFAULT");
featureName.add("MISSINGOVERRIDE");
featureName.add("MISSINGDEPRECATED");
featureName.add("MISSINGCTOR");
featureName.add("METHODTYPEPARAMETERNAME");
featureName.add("METHODPARAMPAD");
featureName.add("METHODNAMEALLOWCLASSNAME");
featureName.add("METHODNAME");
featureName.add("METHODLENGTH");
featureName.add("METHODCOUNT");
featureName.add("MEMBERNAME");
featureName.add("MAGICNUMBER");
featureName.add("LOCALVARIABLENAMEALLOWONECHARVARINFORLOOP");
featureName.add("LOCALVARIABLENAME");
featureName.add("LOCALFINALVARIABLENAME");
featureName.add("LINELENGTH");
featureName.add("LEFTCURLY");
featureName.add("JAVADOCVARIABLE");
featureName.add("JAVADOCTYPE");
featureName.add("JAVADOCTAGCONTINUATIONINDENTATION");
featureName.add("JAVADOCSTYLE");
featureName.add("JAVADOCPARAGRAPH");
featureName.add("JAVADOCPACKAGE");
featureName.add("JAVADOCMETHOD");
featureName.add("JAVANCSS");
featureName.add("INTERFACETYPEPARAMETERNAME");
featureName.add("INTERFACEISTYPE");
featureName.add("INNERTYPELAST");
featureName.add("INNERASSIGNMENT");
featureName.add("INDENTATIONFORCESTRICTCONDITION");
featureName.add("INDENTATION");
featureName.add("IMPORTORDER");
featureName.add("IMPORTCONTROL");
featureName.add("ILLEGALTYPECHECK");
featureName.add("ILLEGALTOKENTEXTCHECK");
featureName.add("ILLEGALTOKEN");
featureName.add("ILLEGALTHROWS");
featureName.add("ILLEGALINSTANTIATION");
featureName.add("ILLEGALIMPORT");
featureName.add("ILLEGALCATCH");
featureName.add("HIDEUTILITYCLASSCONSTRUCTOR");
featureName.add("HIDDENFIELD");
featureName.add("HEADERCHECK");
featureName.add("GENERICWHITESPACE");
featureName.add("FINALPARAMETERS");
featureName.add("FINALLOCALVARIABLE");
featureName.add("FINALCLASS");
featureName.add("FILETABCHARACTER");
featureName.add("FILELENGTH");
featureName.add("FALLTHROUGH");
featureName.add("EXPLICITINITIALIZATION");
featureName.add("EXECUTABLESTATEMENTCOUNT");
featureName.add("EQUALSHASHCODE");
featureName.add("EQUALSAVOIDNULL");
featureName.add("EMPTYSTATEMENT");
featureName.add("EMPTYLINESEPARATORALLOWNOEMPTYLINEBETWEENFIELDS");
featureName.add("EMPTYLINESEPARATORALLOWMULTIPLEEMPTYLINES");
featureName.add("EMPTYLINESEPARATOR");
featureName.add("EMPTYFORITERATORPAD");
featureName.add("EMPTYCATCHBLOCK");
featureName.add("EMPTYBLOCK");
featureName.add("DESIGNFOREXTENSION");
featureName.add("DEFAULTCOMESLAST");
featureName.add("DECLARATIONORDER");
featureName.add("CYCLOMATICCOMPLEXITY");
featureName.add("CUSTOMIMPORTORDER");
featureName.add("COVARIANTEQUALS");
featureName.add("CONSTANTNAME");
featureName.add("CLASSTYPEPARAMETERNAME");
featureName.add("CLASSFANOUTCOMPLEXITYCHECK");
featureName.add("CLASSDATAABSTRACTIONCOUPLINGCHECK");
featureName.add("BOOLEANEXPRESSIONCOMPLEXITY");
featureName.add("AVOIDSTARIMPORTCHECK");
featureName.add("AVOIDNESTEDBLOCKS");
featureName.add("AVOIDINLINECONDITIONALS");
featureName.add("AVOIDESCAPEDUNICODECHARACTERS");
featureName.add("ATCLAUSEORDER");
featureName.add("ARRAYTYPESTYLE");
featureName.add("ARRAYTRAILINGCOMMA");
featureName.add("ANONINNERLENGTH");
featureName.add("ANNOTATIONUSESTYLE");
featureName.add("ANNOTATIONLOCATION");
featureName.add("ABSTRACTCLASSNAMEIGNORENAME");
featureName.add("ABSTRACTCLASSNAMEIGNOREMODIFIER");
featureName.add("ABSTRACTCLASSNAME");
featureName.add("ABBREVIATIONASWORDINNAMEIGNORESTATIC");
featureName.add("ABBREVIATIONASWORDINNAMEIGNOREOVERRIDDENMETHODS");
featureName.add("ABBREVIATIONASWORDINNAMEIGNOREFINAL");
featureName.add("ABBREVIATIONASWORDINNAME");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationCheckStyle.getSINGLETON(Configuration.tool), CheckStlyeVariables.getSINGLETON());
        executeJunitTestCase(incling);
	}


	public static void main(String[] args) {
		MainTestCkeckStlyeIncling run = new MainTestCkeckStlyeIncling();
		run.expRun();
		
		
 }
}