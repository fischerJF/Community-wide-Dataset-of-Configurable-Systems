//package testset;
//
//
//import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//
//import checkstyle.PackageNamesLoader;
//import testset.annotation.AnnotationLocationCheckTest;
//import testset.annotation.AnnotationUseStyleCheckTest;
//import testset.annotation.MissingDeprecatedCheckTest;
//import testset.annotation.MissingOverrideCheckTest;
//import testset.annotation.PackageAnnotationCheckTest;
//import testset.annotation.SuppressWarningsCheckTest;
//import testset.api.AbstractFileSetCheckTest;
//import testset.api.AbstractViolationReporterTest;
//import testset.api.AutomaticBeanTest;
//import testset.api.DetailASTTest;
//import testset.api.FileContentsTest;
//import testset.api.FileSetCheckTest;
//import testset.api.FileTextTest;
//import testset.api.FilterSetTest;
//import testset.api.FullIdentTest;
//import testset.api.JavadocTokenTypesTest;
//import testset.api.LineColumnTest;
//import testset.api.LocalizedMessageTest;
//import testset.api.ScopeTest;
//import testset.api.SeverityLevelCounterTest;
//import testset.api.SeverityLevelTest;
//import testset.api.TokenTypesTest;
//import testset.blocks.AvoidNestedBlocksCheckTest;
//import testset.blocks.EmptyBlockCheckTest;
//import testset.blocks.EmptyCatchBlockCheckTest;
//import testset.blocks.LeftCurlyCheckTest;
//import testset.blocks.NeedBracesCheckTest;
//import testset.blocks.RightCurlyCheckTest;
//import testset.checks.ArrayTypeStyleCheckTest;
//import testset.checks.AvoidEscapedUnicodeCharactersCheckTest;
//import testset.checks.DescendantTokenCheckTest;
//import testset.checks.FinalParametersCheckTest;
//import testset.checks.NewlineAtEndOfFileCheckTest;
//import testset.checks.OuterTypeFilenameCheckTest;
////import testset.checks.SuppressWarningsHolderTest;
//import testset.checks.TodoCommentCheckTest;
//import testset.checks.TrailingCommentCheckTest;
//import testset.checks.TranslationCheckTest;
//import testset.checks.UncommentedMainCheckTest;
//import testset.checks.UniquePropertiesCheckTest;
//import testset.checks.UpperEllCheckTest;
//import testset.checkstyle.AbstractModuleTestSupport;
//import testset.checkstyle.AbstractPathTestSupport;
//import testset.checkstyle.AbstractTreeTestSupport;
//import testset.checkstyle.AbstractXmlTestSupport;
//import testset.checkstyle.AstTreeStringPrinterTest;
//import testset.checkstyle.AuditEventDefaultFormatterTest;
//import testset.checkstyle.CheckerTest;
////import testset.checkstyle.ConfigurationLoaderTest;
//import testset.checkstyle.DefaultConfigurationTest;
//import testset.checkstyle.DefaultLoggerTest;
//import testset.checkstyle.JavadocDetailNodeParserTest;
////import testset.checkstyle.PackageNamesLoaderTest;
//import testset.checkstyle.PackageObjectFactoryTest;
//import testset.checkstyle.PropertiesExpanderTest;
//import testset.checkstyle.TreeWalkerTest;
//import testset.checkstyle.XMLLoggerTest;
//import testset.coding.*;
//import testset.design.*;
////import testset.filters.*;
//import testset.grammars.GeneratedJavaTokenTypesTest;
////import testset.header.HeaderCheckTest;
////import testset.header.RegexpHeaderCheckTest;
//
////import testset.imports.*;
//import testset.indentation.*;
//import testset.internal.testmodules.*;
//import testset.internal.utils.AllChecksTest;
//import testset.internal.utils.AllTestsTest;
////import testset.metrics.BooleanExpressionComplexityCheckTest;
////import testset.metrics.ClassDataAbstractionCouplingCheckTest;
////import testset.metrics.ClassFanOutComplexityCheckTest;
////import testset.metrics.CyclomaticComplexityCheckTest;
//import testset.metrics.NPathComplexityCheckTest;
//import testset.modifier.ClassMemberImpliedModifierCheckTest;
//import testset.modifier.InterfaceMemberImpliedModifierCheckTest;
//import testset.modifier.ModifierOrderCheckTest;
//import testset.modifier.RedundantModifierCheckTest;
////import testset.naming.*;
//import testset.regexp.RegexpMultilineCheckTest;
//import testset.regexp.RegexpOnFilenameCheckTest;
//import testset.regexp.RegexpSinglelineCheckTest;
//import testset.sizes.AnonInnerLengthCheckTest;
//import testset.sizes.ExecutableStatementCountCheckTest;
//import testset.sizes.FileLengthCheckTest;
//import testset.sizes.LineLengthCheckTest;
//import testset.sizes.MethodCountCheckTest;
//import testset.sizes.MethodLengthCheckTest;
//import testset.sizes.OuterTypeNumberCheckTest;
////import testset.sizes.ParameterNumberCheckTest;
////import testset.whitespace.*;
//
//
//@RunWith(Suite.class)
//@Suite.SuiteClasses({
//
//	//annotation
//	AnnotationLocationCheckTest.class,
//	AnnotationUseStyleCheckTest.class,
//	MissingDeprecatedCheckTest.class,
//	MissingOverrideCheckTest.class,
//	PackageAnnotationCheckTest.class,
//	SuppressWarningsCheckTest.class,
//	
//	//api
////	AbstractFileSetCheckTest.class,
//	AbstractViolationReporterTest.class,
//	AutomaticBeanTest.class,
//	DetailASTTest.class,
////	FileContentsTest.class,
////	FileSetCheckTest.class,
////	FileTextTest.class,
////	FilterSetTest.class,
////	FullIdentTest.class,
////	JavadocTokenTypesTest.class,
////	LineColumnTest.class,
////	LocalizedMessageTest.class,
////	ScopeTest.class,
////	SeverityLevelCounterTest.class,
////	SeverityLevelTest.class,
////	TokenTypesTest.class,
//	
//	//blocks
////	AvoidNestedBlocksCheckTest.class,
////	EmptyBlockCheckTest.class,
////	EmptyCatchBlockCheckTest.class,
////	LeftCurlyCheckTest.class,
////	NeedBracesCheckTest.class,
////	RightCurlyCheckTest.class,
//	
//	//checks
////	ArrayTypeStyleCheckTest.class,
////	AvoidEscapedUnicodeCharactersCheckTest.class,
////	DescendantTokenCheckTest.class,
////	FinalParametersCheckTest.class,
//////	NewlineAtEndOfFileCheckTest.class,
////	OuterTypeFilenameCheckTest.class,
//////	SuppressWarningsHolderTest.class,
////	TodoCommentCheckTest.class,
////	TrailingCommentCheckTest.class,
////	TranslationCheckTest.class,
////	UncommentedMainCheckTest.class,
////	UniquePropertiesCheckTest.class,
////	UpperEllCheckTest.class,
//	
//	//checkstyle
////	AbstractModuleTestSupport.class,
////	AbstractPathTestSupport.class,
////	AbstractTreeTestSupport.class,
////	AbstractXmlTestSupport.class,
////	AstTreeStringPrinterTest.class,
////	AuditEventDefaultFormatterTest.class,
////	CheckerTest.class,
////	ConfigurationLoaderTest.class,
////	DefaultConfigurationTest.class,
////	DefaultLoggerTest.class,
////	JavadocDetailNodeParserTest.class,
//	//MainTest.class,
////	PackageNamesLoaderTest.class,
////	PackageObjectFactoryTest.class,
////	PropertiesExpanderTest.class,
//	//PropertyCacheFileTest.class,
////	TreeWalkerTest.class,
////	XMLLoggerTest.class,
//	//coding
//	
//
//
////ArrayTrailingCommaCheckTest.class,
////AvoidInlineConditionalsCheckTest.class,
////CovariantEqualsCheckTest.class,
////DeclarationOrderCheckTest.class,
////DefaultComesLastCheckTest.class,
////EmptyStatementCheckTest.class,
////EqualsAvoidNullCheckTest.class,
////EqualsHashCodeCheckTest.class,
////FallThroughCheckTest.class,
////FinalLocalVariableCheckTest.class,
////HiddenFieldCheckTest.class,
////IllegalCatchCheckTest.class,
////IllegalInstantiationCheckTest.class,
////IllegalThrowsCheckTest.class,
////IllegalTokenCheckTest.class,
////IllegalTokenTextCheckTest.class,
////IllegalTypeCheckTest.class,
////InnerAssignmentCheckTest.class,
////MagicNumberCheckTest.class,
////MissingCtorCheckTest.class,
////MissingSwitchDefaultCheckTest.class,
////ModifiedControlVariableCheckTest.class,
////MultipleStringLiteralsCheckTest.class,
////MultipleVariableDeclarationsCheckTest.class,
////NestedForDepthCheckTest.class,
////NestedIfDepthCheckTest.class,
////NestedTryDepthCheckTest.class,
////NoCloneCheckTest.class,
////NoFinalizerCheckTest.class,
////OneStatementPerLineCheckTest.class,
////OverloadMethodsDeclarationOrderCheckTest.class,
////PackageDeclarationCheckTest.class,
////ParameterAssignmentCheckTest.class,
////RequireThisCheckTest.class,
////ReturnCountCheckTest.class,
////SimplifyBooleanExpressionCheckTest.class,
////SimplifyBooleanReturnCheckTest.class,
////StringLiteralEqualityCheckTest.class,
////SuperCloneCheckTest.class,
////SuperFinalizeCheckTest.class,
////UnnecessaryParenthesesCheckTest.class,
////VariableDeclarationUsageDistanceCheckTest.class,
////
//////design
////
////DesignForExtensionCheckTest.class,		
////FinalClassCheckTest.class,		
////HideUtilityClassConstructorCheckTest.class,		
////InnerTypeLastCheckTest.class,		
////InterfaceIsTypeCheckTest.class,	
////MutableExceptionCheckTest.class,
////OneTopLevelClassCheckTest.class,
////ThrowsCountCheckTest.class,		
////VisibilityModifierCheckTest.class,		
////
//
////filters
//
////CsvFilterTest.class,
////IntMatchFilterTest.class,
////IntRangeFilterTest.class,
////SeverityMatchFilterTest.class,
////SuppressElementTest.class,
////SuppressionCommentFilterTest.class,
////SuppressionFilterTest.class,
////SuppressionsLoaderTest.class,
////SuppressionXpathFilterTest.class,
////SuppressWarningsFilterTest.class,
////SuppressWithNearbyCommentFilterTest.class,
//
////grammars
//
////GeneratedJavaTokenTypesTest.class,
//
////header
////HeaderCheckTest.class,
////RegexpHeaderCheckTest.class,
//
////imports
////AccessResultTest.class,
////AvoidStarImportCheckTest.class,
////AvoidStaticImportCheckTest.class,
////ClassImportRuleTest.class,
////CustomImportOrderCheckTest.class,
////FileImportControlTest.class,
////IllegalImportCheckTest.class,
////ImportControlCheckTest.class,
////ImportControlLoaderTest.class,
////ImportOrderCheckTest.class,
////PkgImportControlTest.class,
////PkgImportRuleTest.class,
////RedundantImportCheckTest.class,
////UnusedImportsCheckTest.class,
//
////identation
//
////CommentsIndentationCheckTest.class,
////IndentationCheckTest.class,
////LineSetTest.class,
//
////CheckerStub.class,
////DebugAuditAdapter.class,
////DebugFilter.class,
////TestBeforeExecutionFileFilter.class,
////TestFileSetCheck.class,
////TestLoggingReporter.class,
////TestRootModuleChecker.class,
//
////AllChecksTest.class,
////AllTestsTest.class,
//
//
////BooleanExpressionComplexityCheckTest.class,
////ClassDataAbstractionCouplingCheckTest.class,
////ClassFanOutComplexityCheckTest.class,
////CyclomaticComplexityCheckTest.class,
////NCSSCheckTest.class,
////NPathComplexityCheckTest.class,
//
//
////ClassMemberImpliedModifierCheckTest.class,
////InterfaceMemberImpliedModifierCheckTest.class,
////ModifierOrderCheckTest.class,
////RedundantModifierCheckTest.class,
//
///*AbbreviationAsWordInNameCheckTest.class,
//AbstractClassNameCheckTest.class,
//ClassTypeParameterNameCheckTest.class,
//ConstantNameCheckTest.class,
//InterfaceTypeParameterNameCheckTest.class,
////LambdaParameterNameCheckTest.class,
//LocalFinalVariableNameCheckTest.class,
////LocalVariableNameCheckTest.class,
//MemberNameCheckTest.class,
//MethodNameCheckTest.class,
//MethodTypeParameterNameCheckTest.class,
//PackageNameCheckTest.class,
//ParameterNameCheckTest.class,
//StaticVariableNameCheckTest.class,
////TypeNameCheckTest.class,*/
//
////RegexpMultilineCheckTest.class,
////RegexpOnFilenameCheckTest.class,
////RegexpSinglelineCheckTest.class,
//	
////AnonInnerLengthCheckTest.class,
///*ExecutableStatementCountCheckTest.class,
////FileLengthCheckTest.class,
////LineLengthCheckTest.class,
////MethodCountCheckTest.class,
////MethodLengthCheckTest.class,
////OuterTypeNumberCheckTest.class,
////ParameterNumberCheckTest.class,
///*
//	
//EmptyForInitializerPadCheckTest.class,
//EmptyForIteratorPadCheckTest.class,
//EmptyLineSeparatorCheckTest.class,
////FileTabCharacterCheckTest.class,
//GenericWhitespaceCheckTest.class,
//MethodParamPadCheckTest.class,
//NoLineWrapCheckTest.class,
//NoWhitespaceAfterCheckTest.class,
//NoWhitespaceBeforeCheckTest.class,
////OperatorWrapCheckTest.class,
////ParenPadCheckTest.class,
//SeparatorWrapCheckTest.class,
////SingleSpaceSeparatorCheckTest.class,
//TypecastParenPadCheckTest.class,
////WhitespaceAfterCheckTest.class,
//WhitespaceAroundCheckTest.class,*/
//	
//
//
//
//})
//
//public class TestAll { }