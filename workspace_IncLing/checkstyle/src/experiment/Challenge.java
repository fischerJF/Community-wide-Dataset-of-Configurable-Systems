package experiment;

import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.annotation.AnnotationLocationCheckTest;
import testset.annotation.AnnotationUseStyleCheckTest;
import testset.annotation.MissingDeprecatedCheckTest;
import testset.annotation.MissingOverrideCheckTest;
import testset.annotation.PackageAnnotationCheckTest;
import testset.annotation.SuppressWarningsCheckTest;
import testset.api.AbstractFileSetCheckTest;
import testset.api.AbstractViolationReporterTest;
import testset.api.AutomaticBeanTest;
import testset.api.DetailASTTest;
import testset.api.FileTextTest;
import testset.api.FilterSetTest;
import testset.api.FullIdentTest;
import testset.api.JavadocTokenTypesTest;
import testset.api.LineColumnTest;
import testset.api.ScopeTest;
import testset.api.SeverityLevelCounterTest;
import testset.api.SeverityLevelTest;
import testset.blocks.AvoidNestedBlocksCheckTest;
import testset.blocks.EmptyBlockCheckTest;
import testset.blocks.EmptyCatchBlockCheckTest;
import testset.blocks.LeftCurlyCheckTest;
import testset.blocks.NeedBracesCheckTest;
import testset.blocks.RightCurlyCheckTest;
import testset.checks.ArrayTypeStyleCheckTest;
import testset.checks.AvoidEscapedUnicodeCharactersCheckTest;
import testset.checks.DescendantTokenCheckTest;
import testset.checks.FinalParametersCheckTest;
import testset.checks.NewlineAtEndOfFileCheckTest;
import testset.checks.OuterTypeFilenameCheckTest;
import testset.checks.TodoCommentCheckTest;
import testset.checks.TrailingCommentCheckTest;
import testset.checks.TranslationCheckTest;
import testset.checks.UncommentedMainCheckTest;
import testset.checks.UniquePropertiesCheckTest;
import testset.checks.UpperEllCheckTest;
import testset.checkstyle.AuditEventDefaultFormatterTest;
import testset.checkstyle.CheckerTest;
import testset.checkstyle.DefaultConfigurationTest;
import testset.checkstyle.DefaultLoggerTest;
import testset.checkstyle.PackageObjectFactoryTest;
import testset.checkstyle.PropertiesExpanderTest;
import testset.checkstyle.TreeWalkerTest;
import testset.checkstyle.XMLLoggerTest;
import testset.coding.ArrayTrailingCommaCheckTest;
import testset.coding.AvoidInlineConditionalsCheckTest;
import testset.coding.CovariantEqualsCheckTest;
import testset.coding.DeclarationOrderCheckTest;
import testset.coding.DefaultComesLastCheckTest;
import testset.coding.EmptyStatementCheckTest;
import testset.coding.EqualsAvoidNullCheckTest;
import testset.coding.EqualsHashCodeCheckTest;
import testset.coding.FallThroughCheckTest;
import testset.coding.FinalLocalVariableCheckTest;
import testset.coding.HiddenFieldCheckTest;
import testset.coding.IllegalCatchCheckTest;
import testset.coding.IllegalInstantiationCheckTest;
import testset.coding.IllegalThrowsCheckTest;
import testset.coding.IllegalTokenCheckTest;
import testset.coding.IllegalTokenTextCheckTest;
import testset.coding.IllegalTypeCheckTest;
import testset.coding.InnerAssignmentCheckTest;
import testset.coding.MagicNumberCheckTest;
import testset.coding.MissingCtorCheckTest;
import testset.coding.MissingSwitchDefaultCheckTest;
import testset.coding.ModifiedControlVariableCheckTest;
import testset.coding.MultipleStringLiteralsCheckTest;
import testset.coding.MultipleVariableDeclarationsCheckTest;
import testset.coding.NestedForDepthCheckTest;
import testset.coding.NestedIfDepthCheckTest;
import testset.coding.NestedTryDepthCheckTest;
import testset.coding.NoCloneCheckTest;
import testset.coding.NoFinalizerCheckTest;
import testset.coding.OneStatementPerLineCheckTest;
import testset.coding.OverloadMethodsDeclarationOrderCheckTest;
import testset.coding.PackageDeclarationCheckTest;
import testset.coding.ParameterAssignmentCheckTest;
import testset.coding.RequireThisCheckTest;
import testset.coding.ReturnCountCheckTest;
import testset.coding.SimplifyBooleanExpressionCheckTest;
import testset.coding.SimplifyBooleanReturnCheckTest;
import testset.coding.StringLiteralEqualityCheckTest;
import testset.coding.SuperCloneCheckTest;
import testset.coding.SuperFinalizeCheckTest;
import testset.coding.UnnecessaryParenthesesCheckTest;
import testset.coding.VariableDeclarationUsageDistanceCheckTest;
import testset.design.DesignForExtensionCheckTest;
import testset.design.FinalClassCheckTest;
import testset.design.HideUtilityClassConstructorCheckTest;
import testset.design.InnerTypeLastCheckTest;
import testset.design.InterfaceIsTypeCheckTest;
import testset.design.MutableExceptionCheckTest;
import testset.design.OneTopLevelClassCheckTest;
import testset.design.ThrowsCountCheckTest;
import testset.design.VisibilityModifierCheckTest;
import testset.filters.SeverityMatchFilterTest;
import testset.filters.SuppressElementTest;
import testset.grammars.GeneratedJavaTokenTypesTest;
import testset.header.RegexpHeaderCheckTest;
import testset.imports.AvoidStarImportCheckTest;
import testset.imports.AvoidStaticImportCheckTest;
import testset.imports.IllegalImportCheckTest;
import testset.imports.ImportControlCheckTest;
import testset.imports.UnusedImportsCheckTest;
import testset.metrics.BooleanExpressionComplexityCheckTest;
import testset.metrics.ClassDataAbstractionCouplingCheckTest;
import testset.metrics.ClassFanOutComplexityCheckTest;
import testset.metrics.CyclomaticComplexityCheckTest;
import testset.metrics.NPathComplexityCheckTest;
import testset.modifier.ModifierOrderCheckTest;
import testset.modifier.RedundantModifierCheckTest;
import testset.naming.AbbreviationAsWordInNameCheckTest;
import testset.naming.AbstractClassNameCheckTest;
import testset.naming.ClassTypeParameterNameCheckTest;
import testset.naming.ConstantNameCheckTest;
import testset.naming.InterfaceTypeParameterNameCheckTest;
import testset.naming.LocalFinalVariableNameCheckTest;
import testset.naming.MemberNameCheckTest;
import testset.naming.MethodNameCheckTest;
import testset.naming.MethodTypeParameterNameCheckTest;
import testset.naming.PackageNameCheckTest;
import testset.naming.ParameterNameCheckTest;
import testset.naming.StaticVariableNameCheckTest;
import testset.regexp.RegexpMultilineCheckTest;
import testset.regexp.RegexpSinglelineCheckTest;
import testset.sizes.AnonInnerLengthCheckTest;
import testset.sizes.ExecutableStatementCountCheckTest;
import testset.sizes.FileLengthCheckTest;
import testset.sizes.LineLengthCheckTest;
import testset.sizes.MethodCountCheckTest;
import testset.sizes.MethodLengthCheckTest;
import testset.sizes.OuterTypeNumberCheckTest;
import testset.sizes.ParameterNumberCheckTest;
import testset.whitespace.EmptyForInitializerPadCheckTest;
import testset.whitespace.EmptyForIteratorPadCheckTest;
import testset.whitespace.EmptyLineSeparatorCheckTest;
import testset.whitespace.GenericWhitespaceCheckTest;
import testset.whitespace.MethodParamPadCheckTest;
import testset.whitespace.NoLineWrapCheckTest;
import testset.whitespace.NoWhitespaceAfterCheckTest;
import testset.whitespace.NoWhitespaceBeforeCheckTest;
import testset.whitespace.SeparatorWrapCheckTest;
import testset.whitespace.TypecastParenPadCheckTest;
import testset.whitespace.WhitespaceAroundCheckTest;

public class Challenge {

	public void executeJunitTestCase(ProductGeneration tools) {
		int count = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("ArrayTypeStyle")) {
					Configuration.ArrayTypeStyle = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AvoidEscapedUnicodeCharacters")) {
					Configuration.AvoidEscapedUnicodeCharacters = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("FinalParameters")) {
					Configuration.FinalParameters = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NewlineAtEndOfFile")) {
					Configuration.NewlineAtEndOfFile = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("OuterTypeFilename")) {
					Configuration.OuterTypeFilename = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("Regexp")) {
					Configuration.Regexp = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RegexpignoreComments")) {
					Configuration.RegexpignoreComments = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RegexpillegalPattern")) {
					Configuration.RegexpillegalPattern = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RegexpcheckForDuplicates")) {
					Configuration.RegexpcheckForDuplicates = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("TodoComment")) {
					Configuration.TodoComment = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("TrailingComment")) {
					Configuration.TrailingComment = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("Translation")) {
					Configuration.Translation = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("UncommentedMain")) {
					Configuration.UncommentedMain = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("UpperEll")) {
					Configuration.UpperEll = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AnnotationUseStyle")) {
					Configuration.AnnotationUseStyle = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AnnotationLocation")) {
					Configuration.AnnotationLocation = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MissingDeprecated")) {
					Configuration.MissingDeprecated = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MissingOverride")) {
					Configuration.MissingOverride = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("PackageAnnotation")) {
					Configuration.PackageAnnotation = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SuppressWarnings")) {
					Configuration.SuppressWarnings = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AvoidNestedBlocks")) {
					Configuration.AvoidNestedBlocks = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EmptyBlock")) {
					Configuration.EmptyBlock = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EmptyCatchBlock")) {
					Configuration.EmptyCatchBlock = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("LeftCurly")) {
					Configuration.LeftCurly = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NeedBraces")) {
					Configuration.NeedBraces = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NeedBracesAllowSingleLineIf")) {
					Configuration.NeedBracesAllowSingleLineIf = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RightCurly")) {
					Configuration.RightCurly = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ArrayTrailingComma")) {
					Configuration.ArrayTrailingComma = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AvoidInlineConditionals")) {
					Configuration.AvoidInlineConditionals = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("CovariantEquals")) {
					Configuration.CovariantEquals = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("DeclarationOrder")) {
					Configuration.DeclarationOrder = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("DefaultComesLast")) {
					Configuration.DefaultComesLast = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EmptyStatement")) {
					Configuration.EmptyStatement = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EqualsAvoidNull")) {
					Configuration.EqualsAvoidNull = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EqualsHashCode")) {
					Configuration.EqualsHashCode = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ExplicitInitialization")) {
					Configuration.ExplicitInitialization = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("FallThrough")) {
					Configuration.FallThrough = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("FinalLocalVariable")) {
					Configuration.FinalLocalVariable = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("HiddenField")) {
					Configuration.HiddenField = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IllegalCatch")) {
					Configuration.IllegalCatch = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IllegalInstantiation")) {
					Configuration.IllegalInstantiation = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IllegalThrows")) {
					Configuration.IllegalThrows = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IllegalToken")) {
					Configuration.IllegalToken = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("TW")) {
					Configuration.TW = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RegexpMultiline")) {
					Configuration.RegexpMultiline = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RegexpSingleline")) {
					Configuration.RegexpSingleline = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RegexpSinglelineJava")) {
					Configuration.RegexpSinglelineJava = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("HeaderCheck")) {
					Configuration.HeaderCheck = (f.getState().equals("0") ? false : true);

				}

				else if (f.getName().equals("RegexpHeaderCheck")) {
					Configuration.RegexpHeaderCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AvoidStarImportCheck")) {
					Configuration.AvoidStarImportCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("CustomImportOrder")) {
					Configuration.CustomImportOrder = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IllegalImport")) {
					Configuration.IllegalImport = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ImportControl")) {
					Configuration.ImportControl = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ImportOrder")) {
					Configuration.ImportOrder = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RedundantImport")) {
					Configuration.RedundantImport = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("UnusedImports")) {
					Configuration.UnusedImports = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("BooleanExpressionComplexity")) {
					Configuration.BooleanExpressionComplexity = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ClassDataAbstractionCouplingCheck")) {
					Configuration.ClassDataAbstractionCouplingCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ClassFanOutComplexityCheck")) {
					Configuration.ClassFanOutComplexityCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("CyclomaticComplexity")) {
					Configuration.CyclomaticComplexity = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("JavaNCSS")) {
					Configuration.JavaNCSS = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NPathComplexity")) {
					Configuration.NPathComplexity = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ModifierOrder")) {
					Configuration.ModifierOrder = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RedundantModifier")) {
					Configuration.RedundantModifier = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("DesignForExtension")) {
					Configuration.DesignForExtension = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("HideUtilityClassConstructor")) {
					Configuration.HideUtilityClassConstructor = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("InnerTypeLast")) {
					Configuration.InnerTypeLast = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("InterfaceIsType")) {
					Configuration.InterfaceIsType = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("OneTopLevelClass")) {
					Configuration.OneTopLevelClass = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ThrowsCount")) {
					Configuration.ThrowsCount = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("VisibilityModifier")) {
					Configuration.VisibilityModifier = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IllegalTypeCheck")) {
					Configuration.IllegalTypeCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("InnerAssignment")) {
					Configuration.InnerAssignment = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MagicNumber")) {
					Configuration.MagicNumber = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MissingCtor")) {
					Configuration.MissingCtor = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MissingSwitchDefault")) {
					Configuration.MissingSwitchDefault = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ModifiedControlVariable")) {
					Configuration.ModifiedControlVariable = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MultipleStringLiterals")) {
					Configuration.MultipleStringLiterals = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MultipleVariableDeclarations")) {
					Configuration.MultipleVariableDeclarations = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NestedForDepth")) {
					Configuration.NestedForDepth = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("FinalClass")) {
					Configuration.FinalClass = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MutableExceptionCheck")) {
					Configuration.MutableExceptionCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IllegalTokenTextCheck")) {
					Configuration.IllegalTokenTextCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("Indentation")) {
					Configuration.Indentation = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("IndentationForceStrictCondition;")) {
					Configuration.IndentationForceStrictCondition = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NestedIfDepth")) {
					Configuration.NestedIfDepth = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NestedTryDepth")) {
					Configuration.NestedTryDepth = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NoClone")) {
					Configuration.NoClone = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NoFinalizer")) {
					Configuration.NoFinalizer = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("OneStatementPerLine")) {
					Configuration.OneStatementPerLine = (f.getState().equals("0") ? false : true);

				}

				else if (f.getName().equals("OverloadMethodsDeclarationOrder")) {
					Configuration.OverloadMethodsDeclarationOrder = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("PackageDeclaration")) {
					Configuration.PackageDeclaration = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ParameterAssignment")) {
					Configuration.ParameterAssignment = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("RequireThis")) {
					Configuration.RequireThis = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ReturnCountCheck")) {
					Configuration.ReturnCountCheck = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SimplifyBooleanExpression")) {

					Configuration.SimplifyBooleanExpression = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SimplifyBooleanReturn")) {
					Configuration.SimplifyBooleanReturn = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("StringLiteralEquality")) {
					Configuration.StringLiteralEquality = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SuperClone")) {
					Configuration.SuperClone = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SuperFinalize")) {
					Configuration.SuperFinalize = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("UnnecessaryParentheses")) {
					Configuration.UnnecessaryParentheses = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("VariableDeclarationUsageDistance")) {
					Configuration.VariableDeclarationUsageDistance = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AtclauseOrder")) {
					Configuration.AtclauseOrder = (f.getState().equals("0") ? false : true);

				}

				else if (f.getName().equals("JavadocMethod")) {
					Configuration.JavadocMethod = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("JavadocPackage")) {
					Configuration.JavadocPackage = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("JavadocParagraph")) {
					Configuration.JavadocParagraph = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("JavadocStyle")) {
					Configuration.JavadocStyle = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("JavadocTagContinuationIndentation")) {
					Configuration.JavadocTagContinuationIndentation = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("JavadocType")) {
					Configuration.JavadocType = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("JavadocVariable")) {
					Configuration.JavadocVariable = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NonEmptyAtclauseDescription")) {
					Configuration.NonEmptyAtclauseDescription = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SingleLineJavadoc")) {
					Configuration.SingleLineJavadoc = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SummaryJavadoc")) {
					Configuration.SummaryJavadoc = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WriteTag")) {
					Configuration.WriteTag = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AbbreviationAsWordInName")) {
					Configuration.AbbreviationAsWordInName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AbbreviationAsWordInNameignoreFinal")) {
					Configuration.AbbreviationAsWordInNameignoreFinal = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AbbreviationAsWordInNameignoreStatic")) {
					Configuration.AbbreviationAsWordInNameignoreStatic = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AbbreviationAsWordInNameignoreOverriddenMethods")) {
					Configuration.AbbreviationAsWordInNameignoreOverriddenMethods = (f.getState().equals("0") ? false
							: true);
				}

				else if (f.getName().equals("AbstractClassName")) {
					Configuration.AbstractClassName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AbstractClassNameignoreModifier")) {
					Configuration.AbstractClassNameignoreModifier = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AbstractClassNameignoreName")) {
					Configuration.AbstractClassNameignoreName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ClassTypeParameterName")) {
					Configuration.ClassTypeParameterName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ConstantName")) {
					Configuration.ConstantName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("InterfaceTypeParameterName")) {
					Configuration.InterfaceTypeParameterName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("LocalFinalVariableName")) {
					Configuration.LocalFinalVariableName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("LocalVariableName")) {
					Configuration.LocalVariableName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("LocalVariableNameallowOneCharVarInForLoop")) {
					Configuration.LocalVariableNameallowOneCharVarInForLoop = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MemberName")) {
					Configuration.MemberName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MethodName")) {
					Configuration.MethodName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MethodNameallowClassName")) {
					Configuration.MethodNameallowClassName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MethodTypeParameterName")) {
					Configuration.MethodTypeParameterName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("PackageName")) {
					Configuration.PackageName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ParameterName")) {
					Configuration.ParameterName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("StaticVariableName")) {
					Configuration.StaticVariableName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("TypeName")) {
					Configuration.TypeName = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("AnonInnerLength")) {
					Configuration.AnonInnerLength = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ExecutableStatementCount")) {
					Configuration.ExecutableStatementCount = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("FileLength")) {
					Configuration.FileLength = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("LineLength")) {
					Configuration.LineLength = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MethodCount")) {
					Configuration.MethodCount = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MethodLength")) {
					Configuration.MethodLength = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("OuterTypeNumber")) {
					Configuration.OuterTypeNumber = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ParameterNumber")) {
					Configuration.ParameterNumber = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EmptyForIteratorPad")) {
					Configuration.EmptyForIteratorPad = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EmptyLineSeparator")) {
					Configuration.EmptyLineSeparator = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("EmptyLineSeparatorallowNoEmptyLineBetweenFields")) {
					Configuration.EmptyLineSeparatorallowNoEmptyLineBetweenFields = (f.getState().equals("0") ? false
							: true);
				}

				else if (f.getName().equals("EmptyLineSeparatorallowMultipleEmptyLines")) {
					Configuration.EmptyLineSeparatorallowMultipleEmptyLines = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("FileTabCharacter")) {
					Configuration.FileTabCharacter = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("GenericWhitespace")) {
					Configuration.GenericWhitespace = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("MethodParamPad")) {
					Configuration.MethodParamPad = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NoLineWrap")) {
					Configuration.NoLineWrap = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NoWhitespaceAfter")) {
					Configuration.NoWhitespaceAfter = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("NoWhitespaceBefore")) {
					Configuration.NoWhitespaceBefore = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("OperatorWrap")) {
					Configuration.OperatorWrap = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("ParenPad")) {
					Configuration.ParenPad = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("SeparatorWrap")) {
					Configuration.SeparatorWrap = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("TypecastParenPad")) {
					Configuration.TypecastParenPad = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WhitespaceAfter")) {
					Configuration.WhitespaceAfter = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WhitespaceAround")) {
					Configuration.WhitespaceAround = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WhitespaceAroundAllowEmptyCtors")) {
					Configuration.WhitespaceAroundAllowEmptyCtors = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WhitespaceAroundAllowEmptyMethods")) {
					Configuration.WhitespaceAroundAllowEmptyMethods = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WhitespaceAroundAllowEmptyTypes")) {
					Configuration.WhitespaceAroundAllowEmptyTypes = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WhitespaceAroundAllowEmptyLoops")) {
					Configuration.WhitespaceAroundAllowEmptyLoops = (f.getState().equals("0") ? false : true);
				}

				else if (f.getName().equals("WhitespaceAroundIgnoreEnhancedForColon")) {
					Configuration.WhitespaceAroundIgnoreEnhancedForColon = (f.getState().equals("0") ? false : true);

				}

			}

			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				count++;
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						// annotation
						AnnotationLocationCheckTest.class, AnnotationUseStyleCheckTest.class,
						MissingDeprecatedCheckTest.class, MissingOverrideCheckTest.class,
						PackageAnnotationCheckTest.class, SuppressWarningsCheckTest.class,

						// api
						AbstractFileSetCheckTest.class, AbstractViolationReporterTest.class, AutomaticBeanTest.class,
						DetailASTTest.class, FileTextTest.class, FilterSetTest.class, FullIdentTest.class,
						JavadocTokenTypesTest.class, LineColumnTest.class, ScopeTest.class,
						SeverityLevelCounterTest.class, SeverityLevelTest.class,

						// blocks
						AvoidNestedBlocksCheckTest.class, EmptyBlockCheckTest.class, EmptyCatchBlockCheckTest.class,
						LeftCurlyCheckTest.class, NeedBracesCheckTest.class, RightCurlyCheckTest.class,

						// checks
						ArrayTypeStyleCheckTest.class, AvoidEscapedUnicodeCharactersCheckTest.class,
						DescendantTokenCheckTest.class, FinalParametersCheckTest.class,
						NewlineAtEndOfFileCheckTest.class, OuterTypeFilenameCheckTest.class, TodoCommentCheckTest.class,
						TrailingCommentCheckTest.class, TranslationCheckTest.class, UncommentedMainCheckTest.class,
						UniquePropertiesCheckTest.class, UpperEllCheckTest.class,

						// checkstyle
						AuditEventDefaultFormatterTest.class, CheckerTest.class, DefaultConfigurationTest.class,
						DefaultLoggerTest.class, PackageObjectFactoryTest.class, PropertiesExpanderTest.class,
						TreeWalkerTest.class, XMLLoggerTest.class,

						// coding
						ArrayTrailingCommaCheckTest.class, AvoidInlineConditionalsCheckTest.class,
						CovariantEqualsCheckTest.class, DeclarationOrderCheckTest.class,
						DefaultComesLastCheckTest.class, EmptyStatementCheckTest.class, EqualsAvoidNullCheckTest.class,
						EqualsHashCodeCheckTest.class, FallThroughCheckTest.class, FinalLocalVariableCheckTest.class,
						HiddenFieldCheckTest.class, IllegalCatchCheckTest.class, IllegalInstantiationCheckTest.class,
						IllegalThrowsCheckTest.class, IllegalTokenCheckTest.class, IllegalTokenTextCheckTest.class,
						IllegalTypeCheckTest.class, InnerAssignmentCheckTest.class, MagicNumberCheckTest.class,
						MissingCtorCheckTest.class, MissingSwitchDefaultCheckTest.class,
						ModifiedControlVariableCheckTest.class, MultipleStringLiteralsCheckTest.class,
						MultipleVariableDeclarationsCheckTest.class, NestedForDepthCheckTest.class,
						NestedIfDepthCheckTest.class, NestedTryDepthCheckTest.class, NoCloneCheckTest.class,
						NoFinalizerCheckTest.class, OneStatementPerLineCheckTest.class,
						OverloadMethodsDeclarationOrderCheckTest.class, PackageDeclarationCheckTest.class,
						ParameterAssignmentCheckTest.class, RequireThisCheckTest.class, ReturnCountCheckTest.class,
						SimplifyBooleanExpressionCheckTest.class, SimplifyBooleanReturnCheckTest.class,
						StringLiteralEqualityCheckTest.class, SuperCloneCheckTest.class, SuperFinalizeCheckTest.class,
						UnnecessaryParenthesesCheckTest.class, VariableDeclarationUsageDistanceCheckTest.class,

						// design
						DesignForExtensionCheckTest.class, FinalClassCheckTest.class,
						HideUtilityClassConstructorCheckTest.class, InnerTypeLastCheckTest.class,
						InterfaceIsTypeCheckTest.class, MutableExceptionCheckTest.class,
						OneTopLevelClassCheckTest.class, ThrowsCountCheckTest.class, VisibilityModifierCheckTest.class,

						// filters
						SeverityMatchFilterTest.class, SuppressElementTest.class,

						// grammars
						GeneratedJavaTokenTypesTest.class,

						// header
						RegexpHeaderCheckTest.class,

						// imports
						AvoidStarImportCheckTest.class, AvoidStaticImportCheckTest.class, IllegalImportCheckTest.class,
						ImportControlCheckTest.class, UnusedImportsCheckTest.class,

						// identation
						BooleanExpressionComplexityCheckTest.class, ClassDataAbstractionCouplingCheckTest.class,
						ClassFanOutComplexityCheckTest.class, CyclomaticComplexityCheckTest.class,

						// NCSSCheckTest.class,
						NPathComplexityCheckTest.class, ModifierOrderCheckTest.class, RedundantModifierCheckTest.class,
						AbbreviationAsWordInNameCheckTest.class, AbstractClassNameCheckTest.class,
						ClassTypeParameterNameCheckTest.class, ConstantNameCheckTest.class,
						InterfaceTypeParameterNameCheckTest.class, LocalFinalVariableNameCheckTest.class,
						MemberNameCheckTest.class, MethodNameCheckTest.class, MethodTypeParameterNameCheckTest.class,
						PackageNameCheckTest.class, ParameterNameCheckTest.class, StaticVariableNameCheckTest.class,
						RegexpMultilineCheckTest.class, RegexpSinglelineCheckTest.class, AnonInnerLengthCheckTest.class,
						ExecutableStatementCountCheckTest.class, FileLengthCheckTest.class, LineLengthCheckTest.class,
						MethodCountCheckTest.class, MethodLengthCheckTest.class, OuterTypeNumberCheckTest.class,
						ParameterNumberCheckTest.class,

						// whitespace
						EmptyForInitializerPadCheckTest.class, EmptyForIteratorPadCheckTest.class,
						EmptyLineSeparatorCheckTest.class, GenericWhitespaceCheckTest.class,
						MethodParamPadCheckTest.class, NoLineWrapCheckTest.class, NoWhitespaceAfterCheckTest.class,
						NoWhitespaceBeforeCheckTest.class, SeparatorWrapCheckTest.class,
						TypecastParenPadCheckTest.class, WhitespaceAroundCheckTest.class);
				Configuration.productPrint();
				System.out.println("\n\n ----------------------- \n\n");
			} else {
				System.err.println("****** Invalid ******");
			}
		}
		try {
			record.record2();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Configurations count:" + count);

	}

	public void run(TargetSystem tg, String path) {
		ProductGeneration products = new ProductGeneration();
		products.run(tg, path);
		executeJunitTestCase(products);
	}

	public static void main(String[] args) {
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 10;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		Challenge challenge = new Challenge();
		while (index < totalExecution) {

			/** all_valid_conf **/
			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/All_valid_conf/checkstyle/products";

			challenge.run(TargetSystem.CHECKSTYLE, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (s): " + (average / 1000) + average
				+ " number of times performed:" + index);

	}
}