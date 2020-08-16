package specifications;


import guidsl.Tool;

public class Configuration {



	public static Tool tool = new Tool( "modified-model.m" );
	public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

	public static boolean ArrayTypeStyle = false;
	public static boolean AvoidEscapedUnicodeCharacters = false;
	public static boolean FinalParameters = false;
	public static boolean NewlineAtEndOfFile = true;
	public static boolean OuterTypeFilename = true;
	public static boolean Regexp = true;
	public static boolean RegexpignoreComments = true;
	public static boolean RegexpillegalPattern = true;
	public static boolean RegexpcheckForDuplicates = true;
	public static boolean TodoComment = true;
	public static boolean TrailingComment = true;
	public static boolean Translation = true;
	public static boolean UncommentedMain = true;
	public static boolean UpperEll = true;
	public static boolean AnnotationLocation = true;
	public static boolean AnnotationUseStyle = true;
	public static boolean MissingDeprecated = true;
	public static boolean MissingOverride = true;
	public static boolean PackageAnnotation = true;
	public static boolean SuppressWarnings = true;
	public static boolean AvoidNestedBlocks = true;
	public static boolean EmptyBlock = true;
	public static boolean EmptyCatchBlock = true;
	public static boolean LeftCurly = true;
	public static boolean NeedBraces = true;
	public static boolean NeedBracesAllowSingleLineIf;
	public static boolean RightCurly = true;
	public static boolean ArrayTrailingComma = true;
	public static boolean AvoidInlineConditionals = true;
	public static boolean CovariantEquals = true;
	public static boolean DeclarationOrder = true;
	public static boolean DefaultComesLast = true;
	public static boolean EmptyStatement = true;
	public static boolean EqualsAvoidNull = true;
	public static boolean EqualsHashCode = true;
	public static boolean ExplicitInitialization = true;
	public static boolean FallThrough = true;
	public static boolean FinalLocalVariable = true;
	public static boolean HiddenField = true;
	public static boolean IllegalCatch = true;
	public static boolean IllegalInstantiation = true;
	public static boolean IllegalThrows = true;
	public static boolean IllegalToken = true;
    public static boolean TW = true;
    public static boolean RegexpMultiline = true;
    public static boolean RegexpSingleline = true;
    public static boolean RegexpSinglelineJava = true;
    public static boolean HeaderCheck = true;
    public static boolean RegexpHeaderCheck = true;
	public static boolean AvoidStarImportCheck = true;
	public static boolean CustomImportOrder = true;
	public static boolean IllegalImport = true;
	public static boolean ImportControl = true;
	public static boolean ImportOrder = true;
	public static boolean RedundantImport = true;
	public static boolean UnusedImports = true;
	public static boolean BooleanExpressionComplexity = true;
	public static boolean ClassDataAbstractionCouplingCheck = true;
	public static boolean ClassFanOutComplexityCheck = true;
	public static boolean CyclomaticComplexity = true;
	public static boolean JavaNCSS = true;
	public static boolean NPathComplexity = true;
	public static boolean ModifierOrder = true;
	public static boolean RedundantModifier = true;
	public static boolean DesignForExtension = true;
	public static boolean HideUtilityClassConstructor = true;
	public static boolean InnerTypeLast = true;
	public static boolean InterfaceIsType = true;
	public static boolean OneTopLevelClass = true;
	public static boolean ThrowsCount = true;
	public static boolean VisibilityModifier = true;
	public static boolean IllegalTypeCheck = true;
    public static boolean InnerAssignment = true;
    public static boolean MagicNumber = true;
    public static boolean MissingCtor = true;
    public static boolean MissingSwitchDefault = true;
    public static boolean ModifiedControlVariable = true;
    public static boolean MultipleStringLiterals = true;
    public static boolean MultipleVariableDeclarations = true;
    public static boolean NestedForDepth = true;
	public static boolean FinalClass = true;
	public static boolean MutableExceptionCheck = true;
    public static boolean IllegalTokenTextCheck = true;
    public static boolean Indentation = true;
    public static boolean IndentationForceStrictCondition;
    public static boolean NestedIfDepth = true;
    public static boolean NestedTryDepth = true;
    public static boolean NoClone = true;
    public static boolean NoFinalizer = true;
    public static boolean OneStatementPerLine = true;
    public static boolean OverloadMethodsDeclarationOrder = true;
    public static boolean PackageDeclaration = true;
    public static boolean ParameterAssignment = true;
    public static boolean RequireThis = true;
    public static boolean ReturnCountCheck = true;
    public static boolean SimplifyBooleanExpression = true;
    public static boolean SimplifyBooleanReturn = true;
    public static boolean StringLiteralEquality = true;
    public static boolean SuperClone = true;
    public static boolean SuperFinalize = true;
    public static boolean UnnecessaryParentheses = true;
    public static boolean VariableDeclarationUsageDistance = true;
    public static boolean AtclauseOrder = true;
    public static boolean JavadocMethod = true;
    public static boolean JavadocPackage = true;
    public static boolean JavadocParagraph = true;
    public static boolean JavadocStyle = true;
    public static boolean JavadocTagContinuationIndentation = true;
    public static boolean JavadocType = true;
    public static boolean JavadocVariable = true;
    public static boolean NonEmptyAtclauseDescription = true;
    public static boolean SingleLineJavadoc = true;
    public static boolean SummaryJavadoc = true;
    public static boolean WriteTag = true;
    public static boolean AbbreviationAsWordInName = true;
    public static boolean AbbreviationAsWordInNameignoreFinal = true;
    public static boolean AbbreviationAsWordInNameignoreStatic = true;
    public static boolean AbbreviationAsWordInNameignoreOverriddenMethods = true;
    public static boolean AbstractClassName = true;
    public static boolean AbstractClassNameignoreModifier = true;
    public static boolean AbstractClassNameignoreName = true;
    public static boolean ClassTypeParameterName = true;
    public static boolean ConstantName = true;
    public static boolean InterfaceTypeParameterName = true;
    public static boolean LocalFinalVariableName = true;
    public static boolean LocalVariableName = true;
    public static boolean LocalVariableNameallowOneCharVarInForLoop = true;
    public static boolean MemberName = true;
    public static boolean MethodName = true;
    public static boolean MethodNameallowClassName = true;
    public static boolean MethodTypeParameterName = true;
    public static boolean PackageName = true;
    public static boolean ParameterName = true;
    public static boolean StaticVariableName = true;
    public static boolean TypeName = true;
    public static boolean AnonInnerLength = true;
    public static boolean ExecutableStatementCount = true;
    public static boolean FileLength = true;
    public static boolean LineLength = true;
    public static boolean MethodCount = true;
    public static boolean MethodLength = true;
    public static boolean OuterTypeNumber = true;
    public static boolean ParameterNumber = true;
    public static boolean EmptyForIteratorPad = true;
    public static boolean EmptyLineSeparator = true;
    public static boolean EmptyLineSeparatorallowNoEmptyLineBetweenFields = false;
    public static boolean EmptyLineSeparatorallowMultipleEmptyLines = true;
    public static boolean FileTabCharacter = true;
    public static boolean GenericWhitespace = true;
    public static boolean MethodParamPad = true;
    public static boolean NoLineWrap = true;
    public static boolean NoWhitespaceAfter = true;
    public static boolean NoWhitespaceBefore = true;
    public static boolean OperatorWrap = true;
    public static boolean ParenPad = true;
    public static boolean SeparatorWrap = true;
    public static boolean TypecastParenPad = true;
    public static boolean WhitespaceAfter = true;
    public static boolean WhitespaceAround = true;
    public static boolean WhitespaceAroundAllowEmptyCtors = true;
    public static  boolean WhitespaceAroundAllowEmptyMethods = true;
    public static boolean WhitespaceAroundAllowEmptyTypes = true;
    public static  boolean WhitespaceAroundAllowEmptyLoops = true;
    public static boolean WhitespaceAroundIgnoreEnhancedForColon = true;



    public static String setARRAYTYPESTYLE() {
    return (ArrayTypeStyle) ? "ARRAYTYPESTYLE___" : "-ARRAYTYPESTYLE___" ;
    }
    public static String setAVOIDESCAPEDUNICODECHARACTERS() {
    return (AvoidEscapedUnicodeCharacters) ? "AVOIDESCAPEDUNICODECHARACTERS___" : "-AVOIDESCAPEDUNICODECHARACTERS___" ;
    }
    public static String setFINALPARAMETERS() {
    return (FinalParameters) ? "FINALPARAMETERS___" : "-FINALPARAMETERS___" ;
    }
    public static String setNEWLINEATENDOFFILE() {
    return (NewlineAtEndOfFile) ? "NEWLINEATENDOFFILE___" : "-NEWLINEATENDOFFILE___" ;
    }
    public static String setOUTERTYPEFILENAME() {
    return (OuterTypeFilename) ? "OUTERTYPEFILENAME___" : "-OUTERTYPEFILENAME___" ;
    }
    public static String setREGEXP() {
    return (Regexp) ? "REGEXP___" : "-REGEXP___" ;
    }
    public static String setREGEXPIGNORECOMMENTS() {
    return (RegexpignoreComments) ? "REGEXPIGNORECOMMENTS___" : "-REGEXPIGNORECOMMENTS___" ;
    }
    public static String setREGEXPILLEGALPATTERN() {
    return (RegexpillegalPattern) ? "REGEXPILLEGALPATTERN___" : "-REGEXPILLEGALPATTERN___" ;
    }
    public static String setREGEXPCHECKFORDUPLICATES() {
    return (RegexpcheckForDuplicates) ? "REGEXPCHECKFORDUPLICATES___" : "-REGEXPCHECKFORDUPLICATES___" ;
    }
    public static String setTODOCOMMENT() {
    return (TodoComment) ? "TODOCOMMENT___" : "-TODOCOMMENT___" ;
    }
    public static String setTRAILINGCOMMENT() {
    return (TrailingComment) ? "TRAILINGCOMMENT___" : "-TRAILINGCOMMENT___" ;
    }
    public static String setTRANSLATION() {
    return (Translation) ? "TRANSLATION___" : "-TRANSLATION___" ;
    }
    public static String setUNCOMMENTEDMAIN() {
    return (UncommentedMain) ? "UNCOMMENTEDMAIN___" : "-UNCOMMENTEDMAIN___" ;
    }
    public static String setUPPERELL() {
    return (UpperEll) ? "UPPERELL___" : "-UPPERELL___" ;
    }
    public static String setANNOTATIONLOCATION() {
    return (AnnotationLocation) ? "ANNOTATIONLOCATION___" : "-ANNOTATIONLOCATION___" ;
    }
    public static String setANNOTATIONUSESTYLE() {
    return (AnnotationUseStyle) ? "ANNOTATIONUSESTYLE___" : "-ANNOTATIONUSESTYLE___" ;
    }
    public static String setMISSINGDEPRECATED() {
    return (MissingDeprecated) ? "MISSINGDEPRECATED___" : "-MISSINGDEPRECATED___" ;
    }
    public static String setMISSINGOVERRIDE() {
    return (MissingOverride) ? "MISSINGOVERRIDE___" : "-MISSINGOVERRIDE___" ;
    }
    public static String setPACKAGEANNOTATION() {
    return (PackageAnnotation) ? "PACKAGEANNOTATION___" : "-PACKAGEANNOTATION___" ;
    }
    public static String setSUPPRESSWARNINGS() {
    return (SuppressWarnings) ? "SUPPRESSWARNINGS___" : "-SUPPRESSWARNINGS___" ;
    }
    public static String setAVOIDNESTEDBLOCKS() {
    return (AvoidNestedBlocks) ? "AVOIDNESTEDBLOCKS___" : "-AVOIDNESTEDBLOCKS___" ;
    }
    public static String setEMPTYBLOCK() {
    return (EmptyBlock) ? "EMPTYBLOCK___" : "-EMPTYBLOCK___" ;
    }
    public static String setEMPTYCATCHBLOCK() {
    return (EmptyCatchBlock) ? "EMPTYCATCHBLOCK___" : "-EMPTYCATCHBLOCK___" ;
    }
    public static String setLEFTCURLY() {
    return (LeftCurly) ? "LEFTCURLY___" : "-LEFTCURLY___" ;
    }
    public static String setNEEDBRACES() {
    return (NeedBraces) ? "NEEDBRACES___" : "-NEEDBRACES___" ;
    }
    public static String setNEEDBRACESALLOWSINGLELINEIF() {
    return (NeedBracesAllowSingleLineIf) ? "NEEDBRACESALLOWSINGLELINEIF___" : "-NEEDBRACESALLOWSINGLELINEIF___" ;
    }
    public static String setRIGHTCURLY() {
    return (RightCurly) ? "RIGHTCURLY___" : "-RIGHTCURLY___" ;
    }
    public static String setARRAYTRAILINGCOMMA() {
    return (ArrayTrailingComma) ? "ARRAYTRAILINGCOMMA___" : "-ARRAYTRAILINGCOMMA___" ;
    }
    public static String setAVOIDINLINECONDITIONALS() {
    return (AvoidInlineConditionals) ? "AVOIDINLINECONDITIONALS___" : "-AVOIDINLINECONDITIONALS___" ;
    }
    public static String setCOVARIANTEQUALS() {
    return (CovariantEquals) ? "COVARIANTEQUALS___" : "-COVARIANTEQUALS___" ;
    }
    public static String setDECLARATIONORDER() {
    return (DeclarationOrder) ? "DECLARATIONORDER___" : "-DECLARATIONORDER___" ;
    }
    public static String setDEFAULTCOMESLAST() {
    return (DefaultComesLast) ? "DEFAULTCOMESLAST___" : "-DEFAULTCOMESLAST___" ;
    }
    public static String setEMPTYSTATEMENT() {
    return (EmptyStatement) ? "EMPTYSTATEMENT___" : "-EMPTYSTATEMENT___" ;
    }
    public static String setEQUALSAVOIDNULL() {
    return (EqualsAvoidNull) ? "EQUALSAVOIDNULL___" : "-EQUALSAVOIDNULL___" ;
    }
    public static String setEQUALSHASHCODE() {
    return (EqualsHashCode) ? "EQUALSHASHCODE___" : "-EQUALSHASHCODE___" ;
    }
    public static String setEXPLICITINITIALIZATION() {
    return (ExplicitInitialization) ? "EXPLICITINITIALIZATION___" : "-EXPLICITINITIALIZATION___" ;
    }
    public static String setFALLTHROUGH() {
    return (FallThrough) ? "FALLTHROUGH___" : "-FALLTHROUGH___" ;
    }
    public static String setFINALLOCALVARIABLE() {
    return (FinalLocalVariable) ? "FINALLOCALVARIABLE___" : "-FINALLOCALVARIABLE___" ;
    }
    public static String setHIDDENFIELD() {
    return (HiddenField) ? "HIDDENFIELD___" : "-HIDDENFIELD___" ;
    }
    public static String setILLEGALCATCH() {
    return (IllegalCatch) ? "ILLEGALCATCH___" : "-ILLEGALCATCH___" ;
    }
    public static String setILLEGALINSTANTIATION() {
    return (IllegalInstantiation) ? "ILLEGALINSTANTIATION___" : "-ILLEGALINSTANTIATION___" ;
    }
    public static String setILLEGALTHROWS() {
    return (IllegalThrows) ? "ILLEGALTHROWS___" : "-ILLEGALTHROWS___" ;
    }
    public static String setILLEGALTOKEN() {
    return (IllegalToken) ? "ILLEGALTOKEN___" : "-ILLEGALTOKEN___" ;
    }
    public static String setTW() {
    return (TW) ? "TW___" : "-TW___" ;
    }
    public static String setREGEXPMULTILINE() {
    return (RegexpMultiline) ? "REGEXPMULTILINE___" : "-REGEXPMULTILINE___" ;
    }
    public static String setREGEXPSINGLELINE() {
    return (RegexpSingleline) ? "REGEXPSINGLELINE___" : "-REGEXPSINGLELINE___" ;
    }
    public static String setREGEXPSINGLELINEJAVA() {
    return (RegexpSinglelineJava) ? "REGEXPSINGLELINEJAVA___" : "-REGEXPSINGLELINEJAVA___" ;
    }
    public static String setHEADERCHECK() {
    return (HeaderCheck) ? "HEADERCHECK___" : "-HEADERCHECK___" ;
    }
    public static String setREGEXPHEADERCHECK() {
    return (RegexpHeaderCheck) ? "REGEXPHEADERCHECK___" : "-REGEXPHEADERCHECK___" ;
    }
    public static String setAVOIDSTARIMPORTCHECK() {
    return (AvoidStarImportCheck) ? "AVOIDSTARIMPORTCHECK___" : "-AVOIDSTARIMPORTCHECK___" ;
    }
    public static String setCUSTOMIMPORTORDER() {
    return (CustomImportOrder) ? "CUSTOMIMPORTORDER___" : "-CUSTOMIMPORTORDER___" ;
    }
    public static String setILLEGALIMPORT() {
    return (IllegalImport) ? "ILLEGALIMPORT___" : "-ILLEGALIMPORT___" ;
    }
    public static String setIMPORTCONTROL() {
    return (ImportControl) ? "IMPORTCONTROL___" : "-IMPORTCONTROL___" ;
    }
    public static String setIMPORTORDER() {
    return (ImportOrder) ? "IMPORTORDER___" : "-IMPORTORDER___" ;
    }
    public static String setREDUNDANTIMPORT() {
    return (RedundantImport) ? "REDUNDANTIMPORT___" : "-REDUNDANTIMPORT___" ;
    }
    public static String setUNUSEDIMPORTS() {
    return (UnusedImports) ? "UNUSEDIMPORTS___" : "-UNUSEDIMPORTS___" ;
    }
    public static String setBOOLEANEXPRESSIONCOMPLEXITY() {
    return (BooleanExpressionComplexity) ? "BOOLEANEXPRESSIONCOMPLEXITY___" : "-BOOLEANEXPRESSIONCOMPLEXITY___" ;
    }
    public static String setCLASSDATAABSTRACTIONCOUPLINGCHECK() {
    return (ClassDataAbstractionCouplingCheck) ? "CLASSDATAABSTRACTIONCOUPLINGCHECK___" : "-CLASSDATAABSTRACTIONCOUPLINGCHECK___" ;
    }
    public static String setCLASSFANOUTCOMPLEXITYCHECK() {
    return (ClassFanOutComplexityCheck) ? "CLASSFANOUTCOMPLEXITYCHECK___" : "-CLASSFANOUTCOMPLEXITYCHECK___" ;
    }
    public static String setCYCLOMATICCOMPLEXITY() {
    return (CyclomaticComplexity) ? "CYCLOMATICCOMPLEXITY___" : "-CYCLOMATICCOMPLEXITY___" ;
    }
    public static String setJAVANCSS() {
    return (JavaNCSS) ? "JAVANCSS___" : "-JAVANCSS___" ;
    }
    public static String setNPATHCOMPLEXITY() {
    return (NPathComplexity) ? "NPATHCOMPLEXITY___" : "-NPATHCOMPLEXITY___" ;
    }
    public static String setMODIFIERORDER() {
    return (ModifierOrder) ? "MODIFIERORDER___" : "-MODIFIERORDER___" ;
    }
    public static String setREDUNDANTMODIFIER() {
    return (RedundantModifier) ? "REDUNDANTMODIFIER___" : "-REDUNDANTMODIFIER___" ;
    }
    public static String setDESIGNFOREXTENSION() {
    return (DesignForExtension) ? "DESIGNFOREXTENSION___" : "-DESIGNFOREXTENSION___" ;
    }
    public static String setHIDEUTILITYCLASSCONSTRUCTOR() {
    return (HideUtilityClassConstructor) ? "HIDEUTILITYCLASSCONSTRUCTOR___" : "-HIDEUTILITYCLASSCONSTRUCTOR___" ;
    }
    public static String setINNERTYPELAST() {
    return (InnerTypeLast) ? "INNERTYPELAST___" : "-INNERTYPELAST___" ;
    }
    public static String setINTERFACEISTYPE() {
    return (InterfaceIsType) ? "INTERFACEISTYPE___" : "-INTERFACEISTYPE___" ;
    }
    public static String setONETOPLEVELCLASS() {
    return (OneTopLevelClass) ? "ONETOPLEVELCLASS___" : "-ONETOPLEVELCLASS___" ;
    }
    public static String setTHROWSCOUNT() {
    return (ThrowsCount) ? "THROWSCOUNT___" : "-THROWSCOUNT___" ;
    }
    public static String setVISIBILITYMODIFIER() {
    return (VisibilityModifier) ? "VISIBILITYMODIFIER___" : "-VISIBILITYMODIFIER___" ;
    }
    public static String setILLEGALTYPECHECK() {
    return (IllegalTypeCheck) ? "ILLEGALTYPECHECK___" : "-ILLEGALTYPECHECK___" ;
    }
    public static String setINNERASSIGNMENT() {
    return (InnerAssignment) ? "INNERASSIGNMENT___" : "-INNERASSIGNMENT___" ;
    }
    public static String setMAGICNUMBER() {
    return (MagicNumber) ? "MAGICNUMBER___" : "-MAGICNUMBER___" ;
    }
    public static String setMISSINGCTOR() {
    return (MissingCtor) ? "MISSINGCTOR___" : "-MISSINGCTOR___" ;
    }
    public static String setMISSINGSWITCHDEFAULT() {
    return (MissingSwitchDefault) ? "MISSINGSWITCHDEFAULT___" : "-MISSINGSWITCHDEFAULT___" ;
    }
    public static String setMODIFIEDCONTROLVARIABLE() {
    return (ModifiedControlVariable) ? "MODIFIEDCONTROLVARIABLE___" : "-MODIFIEDCONTROLVARIABLE___" ;
    }
    public static String setMULTIPLESTRINGLITERALS() {
    return (MultipleStringLiterals) ? "MULTIPLESTRINGLITERALS___" : "-MULTIPLESTRINGLITERALS___" ;
    }
    public static String setMULTIPLEVARIABLEDECLARATIONS() {
    return (MultipleVariableDeclarations) ? "MULTIPLEVARIABLEDECLARATIONS___" : "-MULTIPLEVARIABLEDECLARATIONS___" ;
    }
    public static String setNESTEDFORDEPTH() {
    return (NestedForDepth) ? "NESTEDFORDEPTH___" : "-NESTEDFORDEPTH___" ;
    }
    public static String setFINALCLASS() {
    return (FinalClass) ? "FINALCLASS___" : "-FINALCLASS___" ;
    }
    public static String setMUTABLEEXCEPTIONCHECK() {
    return (MutableExceptionCheck) ? "MUTABLEEXCEPTIONCHECK___" : "-MUTABLEEXCEPTIONCHECK___" ;
    }
    public static String setILLEGALTOKENTEXTCHECK() {
    return (IllegalTokenTextCheck) ? "ILLEGALTOKENTEXTCHECK___" : "-ILLEGALTOKENTEXTCHECK___" ;
    }
    public static String setINDENTATION() {
    return (Indentation) ? "INDENTATION___" : "-INDENTATION___" ;
    }
    public static String setINDENTATIONFORCESTRICTCONDITION() {
    return (IndentationForceStrictCondition) ? "INDENTATIONFORCESTRICTCONDITION___" : "-INDENTATIONFORCESTRICTCONDITION___" ;
    }
    public static String setNESTEDIFDEPTH() {
    return (NestedIfDepth) ? "NESTEDIFDEPTH___" : "-NESTEDIFDEPTH___" ;
    }
    public static String setNESTEDTRYDEPTH() {
    return (NestedTryDepth) ? "NESTEDTRYDEPTH___" : "-NESTEDTRYDEPTH___" ;
    }
    public static String setNOCLONE() {
    return (NoClone) ? "NOCLONE___" : "-NOCLONE___" ;
    }
    public static String setNOFINALIZER() {
    return (NoFinalizer) ? "NOFINALIZER___" : "-NOFINALIZER___" ;
    }
    public static String setONESTATEMENTPERLINE() {
    return (OneStatementPerLine) ? "ONESTATEMENTPERLINE___" : "-ONESTATEMENTPERLINE___" ;
    }
    public static String setOVERLOADMETHODSDECLARATIONORDER() {
    return (OverloadMethodsDeclarationOrder) ? "OVERLOADMETHODSDECLARATIONORDER___" : "-OVERLOADMETHODSDECLARATIONORDER___" ;
    }
    public static String setPACKAGEDECLARATION() {
    return (PackageDeclaration) ? "PACKAGEDECLARATION___" : "-PACKAGEDECLARATION___" ;
    }
    public static String setPARAMETERASSIGNMENT() {
    return (ParameterAssignment) ? "PARAMETERASSIGNMENT___" : "-PARAMETERASSIGNMENT___" ;
    }
    public static String setREQUIRETHIS() {
    return (RequireThis) ? "REQUIRETHIS___" : "-REQUIRETHIS___" ;
    }
    public static String setRETURNCOUNTCHECK() {
    return (ReturnCountCheck) ? "RETURNCOUNTCHECK___" : "-RETURNCOUNTCHECK___" ;
    }
    public static String setSIMPLIFYBOOLEANEXPRESSION() {
    return (SimplifyBooleanExpression) ? "SIMPLIFYBOOLEANEXPRESSION___" : "-SIMPLIFYBOOLEANEXPRESSION___" ;
    }
    public static String setSIMPLIFYBOOLEANRETURN() {
    return (SimplifyBooleanReturn) ? "SIMPLIFYBOOLEANRETURN___" : "-SIMPLIFYBOOLEANRETURN___" ;
    }
    public static String setSTRINGLITERALEQUALITY() {
    return (StringLiteralEquality) ? "STRINGLITERALEQUALITY___" : "-STRINGLITERALEQUALITY___" ;
    }
    public static String setSUPERCLONE() {
    return (SuperClone) ? "SUPERCLONE___" : "-SUPERCLONE___" ;
    }
    public static String setSUPERFINALIZE() {
    return (SuperFinalize) ? "SUPERFINALIZE___" : "-SUPERFINALIZE___" ;
    }
    public static String setUNNECESSARYPARENTHESES() {
    return (UnnecessaryParentheses) ? "UNNECESSARYPARENTHESES___" : "-UNNECESSARYPARENTHESES___" ;
    }
    public static String setVARIABLEDECLARATIONUSAGEDISTANCE() {
    return (VariableDeclarationUsageDistance) ? "VARIABLEDECLARATIONUSAGEDISTANCE___" : "-VARIABLEDECLARATIONUSAGEDISTANCE___" ;
    }
    public static String setATCLAUSEORDER() {
    return (AtclauseOrder) ? "ATCLAUSEORDER___" : "-ATCLAUSEORDER___" ;
    }
    public static String setJAVADOCMETHOD() {
    return (JavadocMethod) ? "JAVADOCMETHOD___" : "-JAVADOCMETHOD___" ;
    }
    public static String setJAVADOCPACKAGE() {
    return (JavadocPackage) ? "JAVADOCPACKAGE___" : "-JAVADOCPACKAGE___" ;
    }
    public static String setJAVADOCPARAGRAPH() {
    return (JavadocParagraph) ? "JAVADOCPARAGRAPH___" : "-JAVADOCPARAGRAPH___" ;
    }
    public static String setJAVADOCSTYLE() {
    return (JavadocStyle) ? "JAVADOCSTYLE___" : "-JAVADOCSTYLE___" ;
    }
    public static String setJAVADOCTAGCONTINUATIONINDENTATION() {
    return (JavadocTagContinuationIndentation) ? "JAVADOCTAGCONTINUATIONINDENTATION___" : "-JAVADOCTAGCONTINUATIONINDENTATION___" ;
    }
    public static String setJAVADOCTYPE() {
    return (JavadocType) ? "JAVADOCTYPE___" : "-JAVADOCTYPE___" ;
    }
    public static String setJAVADOCVARIABLE() {
    return (JavadocVariable) ? "JAVADOCVARIABLE___" : "-JAVADOCVARIABLE___" ;
    }
    public static String setNONEMPTYATCLAUSEDESCRIPTION() {
    return (NonEmptyAtclauseDescription) ? "NONEMPTYATCLAUSEDESCRIPTION___" : "-NONEMPTYATCLAUSEDESCRIPTION___" ;
    }
    public static String setSINGLELINEJAVADOC() {
    return (SingleLineJavadoc) ? "SINGLELINEJAVADOC___" : "-SINGLELINEJAVADOC___" ;
    }
    public static String setSUMMARYJAVADOC() {
    return (SummaryJavadoc) ? "SUMMARYJAVADOC___" : "-SUMMARYJAVADOC___" ;
    }
    public static String setWRITETAG() {
    return (WriteTag) ? "WRITETAG___" : "-WRITETAG___" ;
    }
    public static String setABBREVIATIONASWORDINNAME() {
    return (AbbreviationAsWordInName) ? "ABBREVIATIONASWORDINNAME___" : "-ABBREVIATIONASWORDINNAME___" ;
    }
    public static String setABBREVIATIONASWORDINNAMEIGNOREFINAL() {
    return (AbbreviationAsWordInNameignoreFinal) ? "ABBREVIATIONASWORDINNAMEIGNOREFINAL___" : "-ABBREVIATIONASWORDINNAMEIGNOREFINAL___" ;
    }
    public static String setABBREVIATIONASWORDINNAMEIGNORESTATIC() {
    return (AbbreviationAsWordInNameignoreStatic) ? "ABBREVIATIONASWORDINNAMEIGNORESTATIC___" : "-ABBREVIATIONASWORDINNAMEIGNORESTATIC___" ;
    }
    public static String setABBREVIATIONASWORDINNAMEIGNOREOVERRIDDENMETHODS() {
    return (AbbreviationAsWordInNameignoreOverriddenMethods) ? "ABBREVIATIONASWORDINNAMEIGNOREOVERRIDDENMETHODS___" : "-ABBREVIATIONASWORDINNAMEIGNOREOVERRIDDENMETHODS___" ;
    }
    public static String setABSTRACTCLASSNAME() {
    return (AbstractClassName) ? "ABSTRACTCLASSNAME___" : "-ABSTRACTCLASSNAME___" ;
    }
    public static String setABSTRACTCLASSNAMEIGNOREMODIFIER() {
    return (AbstractClassNameignoreModifier) ? "ABSTRACTCLASSNAMEIGNOREMODIFIER___" : "-ABSTRACTCLASSNAMEIGNOREMODIFIER___" ;
    }
    public static String setABSTRACTCLASSNAMEIGNORENAME() {
    return (AbstractClassNameignoreName) ? "ABSTRACTCLASSNAMEIGNORENAME___" : "-ABSTRACTCLASSNAMEIGNORENAME___" ;
    }
    public static String setCLASSTYPEPARAMETERNAME() {
    return (ClassTypeParameterName) ? "CLASSTYPEPARAMETERNAME___" : "-CLASSTYPEPARAMETERNAME___" ;
    }
    public static String setCONSTANTNAME() {
    return (ConstantName) ? "CONSTANTNAME___" : "-CONSTANTNAME___" ;
    }
    public static String setINTERFACETYPEPARAMETERNAME() {
    return (InterfaceTypeParameterName) ? "INTERFACETYPEPARAMETERNAME___" : "-INTERFACETYPEPARAMETERNAME___" ;
    }
    public static String setLOCALFINALVARIABLENAME() {
    return (LocalFinalVariableName) ? "LOCALFINALVARIABLENAME___" : "-LOCALFINALVARIABLENAME___" ;
    }
    public static String setLOCALVARIABLENAME() {
    return (LocalVariableName) ? "LOCALVARIABLENAME___" : "-LOCALVARIABLENAME___" ;
    }
    public static String setLOCALVARIABLENAMEALLOWONECHARVARINFORLOOP() {
    return (LocalVariableNameallowOneCharVarInForLoop) ? "LOCALVARIABLENAMEALLOWONECHARVARINFORLOOP___" : "-LOCALVARIABLENAMEALLOWONECHARVARINFORLOOP___" ;
    }
    public static String setMEMBERNAME() {
    return (MemberName) ? "MEMBERNAME___" : "-MEMBERNAME___" ;
    }
    public static String setMETHODNAME() {
    return (MethodName) ? "METHODNAME___" : "-METHODNAME___" ;
    }
    public static String setMETHODNAMEALLOWCLASSNAME() {
    return (MethodNameallowClassName) ? "METHODNAMEALLOWCLASSNAME___" : "-METHODNAMEALLOWCLASSNAME___" ;
    }
    public static String setMETHODTYPEPARAMETERNAME() {
    return (MethodTypeParameterName) ? "METHODTYPEPARAMETERNAME___" : "-METHODTYPEPARAMETERNAME___" ;
    }
    public static String setPACKAGENAME() {
    return (PackageName) ? "PACKAGENAME___" : "-PACKAGENAME___" ;
    }
    public static String setPARAMETERNAME() {
    return (ParameterName) ? "PARAMETERNAME___" : "-PARAMETERNAME___" ;
    }
    public static String setSTATICVARIABLENAME() {
    return (StaticVariableName) ? "STATICVARIABLENAME___" : "-STATICVARIABLENAME___" ;
    }
    public static String setTYPENAME() {
    return (TypeName) ? "TYPENAME___" : "-TYPENAME___" ;
    }
    public static String setANONINNERLENGTH() {
    return (AnonInnerLength) ? "ANONINNERLENGTH___" : "-ANONINNERLENGTH___" ;
    }
    public static String setEXECUTABLESTATEMENTCOUNT() {
    return (ExecutableStatementCount) ? "EXECUTABLESTATEMENTCOUNT___" : "-EXECUTABLESTATEMENTCOUNT___" ;
    }
    public static String setFILELENGTH() {
    return (FileLength) ? "FILELENGTH___" : "-FILELENGTH___" ;
    }
    public static String setLINELENGTH() {
    return (LineLength) ? "LINELENGTH___" : "-LINELENGTH___" ;
    }
    public static String setMETHODCOUNT() {
    return (MethodCount) ? "METHODCOUNT___" : "-METHODCOUNT___" ;
    }
    public static String setMETHODLENGTH() {
    return (MethodLength) ? "METHODLENGTH___" : "-METHODLENGTH___" ;
    }
    public static String setOUTERTYPENUMBER() {
    return (OuterTypeNumber) ? "OUTERTYPENUMBER___" : "-OUTERTYPENUMBER___" ;
    }
    public static String setPARAMETERNUMBER() {
    return (ParameterNumber) ? "PARAMETERNUMBER___" : "-PARAMETERNUMBER___" ;
    }
    public static String setEMPTYFORITERATORPAD() {
    return (EmptyForIteratorPad) ? "EMPTYFORITERATORPAD___" : "-EMPTYFORITERATORPAD___" ;
    }
    public static String setEMPTYLINESEPARATOR() {
    return (EmptyLineSeparator) ? "EMPTYLINESEPARATOR___" : "-EMPTYLINESEPARATOR___" ;
    }
    public static String setEMPTYLINESEPARATORALLOWNOEMPTYLINEBETWEENFIELDS() {
    return (EmptyLineSeparatorallowNoEmptyLineBetweenFields) ? "EMPTYLINESEPARATORALLOWNOEMPTYLINEBETWEENFIELDS___" : "-EMPTYLINESEPARATORALLOWNOEMPTYLINEBETWEENFIELDS___" ;
    }
    public static String setEMPTYLINESEPARATORALLOWMULTIPLEEMPTYLINES() {
    return (EmptyLineSeparatorallowMultipleEmptyLines) ? "EMPTYLINESEPARATORALLOWMULTIPLEEMPTYLINES___" : "-EMPTYLINESEPARATORALLOWMULTIPLEEMPTYLINES___" ;
    }
    public static String setFILETABCHARACTER() {
    return (FileTabCharacter) ? "FILETABCHARACTER___" : "-FILETABCHARACTER___" ;
    }
    public static String setGENERICWHITESPACE() {
    return (GenericWhitespace) ? "GENERICWHITESPACE___" : "-GENERICWHITESPACE___" ;
    }
    public static String setMETHODPARAMPAD() {
    return (MethodParamPad) ? "METHODPARAMPAD___" : "-METHODPARAMPAD___" ;
    }
    public static String setNOLINEWRAP() {
    return (NoLineWrap) ? "NOLINEWRAP___" : "-NOLINEWRAP___" ;
    }
    public static String setNOWHITESPACEAFTER() {
    return (NoWhitespaceAfter) ? "NOWHITESPACEAFTER___" : "-NOWHITESPACEAFTER___" ;
    }
    public static String setNOWHITESPACEBEFORE() {
    return (NoWhitespaceBefore) ? "NOWHITESPACEBEFORE___" : "-NOWHITESPACEBEFORE___" ;
    }
    public static String setOPERATORWRAP() {
    return (OperatorWrap) ? "OPERATORWRAP___" : "-OPERATORWRAP___" ;
    }
    public static String setPARENPAD() {
    return (ParenPad) ? "PARENPAD___" : "-PARENPAD___" ;
    }
    public static String setSEPARATORWRAP() {
    return (SeparatorWrap) ? "SEPARATORWRAP___" : "-SEPARATORWRAP___" ;
    }
    public static String setTYPECASTPARENPAD() {
    return (TypecastParenPad) ? "TYPECASTPARENPAD___" : "-TYPECASTPARENPAD___" ;
    }
    public static String setWHITESPACEAFTER() {
    return (WhitespaceAfter) ? "WHITESPACEAFTER___" : "-WHITESPACEAFTER___" ;
    }
    public static String setWHITESPACEAROUND() {
    return (WhitespaceAround) ? "WHITESPACEAROUND___" : "-WHITESPACEAROUND___" ;
    }
    public static String setWHITESPACEAROUNDALLOWEMPTYCTORS() {
    return (WhitespaceAroundAllowEmptyCtors) ? "WHITESPACEAROUNDALLOWEMPTYCTORS___" : "-WHITESPACEAROUNDALLOWEMPTYCTORS___" ;
    }
    public static String setWHITESPACEAROUNDALLOWEMPTYMETHODS() {
    return (WhitespaceAroundAllowEmptyMethods) ? "WHITESPACEAROUNDALLOWEMPTYMETHODS___" : "-WHITESPACEAROUNDALLOWEMPTYMETHODS___" ;
    }
    public static String setWHITESPACEAROUNDALLOWEMPTYTYPES() {
    return (WhitespaceAroundAllowEmptyTypes) ? "WHITESPACEAROUNDALLOWEMPTYTYPES___" : "-WHITESPACEAROUNDALLOWEMPTYTYPES___" ;
    }
    public static String setWHITESPACEAROUNDALLOWEMPTYLOOPS() {
    return (WhitespaceAroundAllowEmptyLoops) ? "WHITESPACEAROUNDALLOWEMPTYLOOPS___" : "-WHITESPACEAROUNDALLOWEMPTYLOOPS___" ;
    }
    public static String setWHITESPACEAROUNDIGNOREENHANCEDFORCOLON() {
    return (WhitespaceAroundIgnoreEnhancedForColon) ? "WHITESPACEAROUNDIGNOREENHANCEDFORCOLON___" : "-WHITESPACEAROUNDIGNOREENHANCEDFORCOLON___" ;
    }


    public static void productPrint() {
		System.out.println( 

"WRITETAG:"+Configuration.WriteTag+
"WHITESPACEAROUNDIGNOREENHANCEDFORCOLON:"+Configuration.WhitespaceAroundIgnoreEnhancedForColon+
"WHITESPACEAROUNDALLOWEMPTYTYPES:"+Configuration.WhitespaceAroundAllowEmptyTypes+
"WHITESPACEAROUNDALLOWEMPTYMETHODS:"+Configuration.WhitespaceAroundAllowEmptyMethods+
"WHITESPACEAROUNDALLOWEMPTYLOOPS:"+Configuration.WhitespaceAroundAllowEmptyLoops+
"WHITESPACEAROUNDALLOWEMPTYCTORS:"+Configuration.WhitespaceAroundAllowEmptyCtors+
"WHITESPACEAROUND:"+Configuration.WhitespaceAround+
"WHITESPACEAFTER:"+Configuration.WhitespaceAfter+
"VISIBILITYMODIFIER:"+Configuration.VisibilityModifier+
"VARIABLEDECLARATIONUSAGEDISTANCE:"+Configuration.VariableDeclarationUsageDistance+
"UPPERELL:"+Configuration.UpperEll+
"UNUSEDIMPORTS:"+Configuration.UnusedImports+
"UNNECESSARYPARENTHESES:"+Configuration.UnnecessaryParentheses+
"UNCOMMENTEDMAIN:"+Configuration.UncommentedMain+
"TYPECASTPARENPAD:"+Configuration.TypecastParenPad+
"TYPENAME:"+Configuration.TypeName+
"TRANSLATION:"+Configuration.Translation+
"TRAILINGCOMMENT:"+Configuration.TrailingComment+
"TODOCOMMENT:"+Configuration.TodoComment+
"THROWSCOUNT:"+Configuration.ThrowsCount+
"TW:"+Configuration.TW+
"SUPPRESSWARNINGS:"+Configuration.SuppressWarnings+
"SUPERFINALIZE:"+Configuration.SuperFinalize+
"SUPERCLONE:"+Configuration.SuperClone+
"SUMMARYJAVADOC:"+Configuration.SummaryJavadoc+
"STRINGLITERALEQUALITY:"+Configuration.StringLiteralEquality+
"STATICVARIABLENAME:"+Configuration.StaticVariableName+
"SINGLELINEJAVADOC:"+Configuration.SingleLineJavadoc+
"SIMPLIFYBOOLEANRETURN:"+Configuration.SimplifyBooleanReturn+
"SIMPLIFYBOOLEANEXPRESSION:"+Configuration.SimplifyBooleanExpression+
"SEPARATORWRAP:"+Configuration.SeparatorWrap+
"RIGHTCURLY:"+Configuration.RightCurly+
"RETURNCOUNTCHECK:"+Configuration.ReturnCountCheck+
"REQUIRETHIS:"+Configuration.RequireThis+
"REGEXPILLEGALPATTERN:"+Configuration.RegexpillegalPattern+
"REGEXPIGNORECOMMENTS:"+Configuration.RegexpignoreComments+
"REGEXPCHECKFORDUPLICATES:"+Configuration.RegexpcheckForDuplicates+
"REGEXPSINGLELINEJAVA:"+Configuration.RegexpSinglelineJava+
"REGEXPSINGLELINE:"+Configuration.RegexpSingleline+
"REGEXPMULTILINE:"+Configuration.RegexpMultiline+
"REGEXPHEADERCHECK:"+Configuration.RegexpHeaderCheck+
"REGEXP:"+Configuration.Regexp+
"REDUNDANTMODIFIER:"+Configuration.RedundantModifier+
"REDUNDANTIMPORT:"+Configuration.RedundantImport+
"PARENPAD:"+Configuration.ParenPad+
"PARAMETERNUMBER:"+Configuration.ParameterNumber+
"PARAMETERNAME:"+Configuration.ParameterName+
"PARAMETERASSIGNMENT:"+Configuration.ParameterAssignment+
"PACKAGENAME:"+Configuration.PackageName+
"PACKAGEDECLARATION:"+Configuration.PackageDeclaration+
"PACKAGEANNOTATION:"+Configuration.PackageAnnotation+
"OVERLOADMETHODSDECLARATIONORDER:"+Configuration.OverloadMethodsDeclarationOrder+
"OUTERTYPENUMBER:"+Configuration.OuterTypeNumber+
"OUTERTYPEFILENAME:"+Configuration.OuterTypeFilename+
"OPERATORWRAP:"+Configuration.OperatorWrap+
"ONETOPLEVELCLASS:"+Configuration.OneTopLevelClass+
"ONESTATEMENTPERLINE:"+Configuration.OneStatementPerLine+
"NONEMPTYATCLAUSEDESCRIPTION:"+Configuration.NonEmptyAtclauseDescription+
"NOWHITESPACEBEFORE:"+Configuration.NoWhitespaceBefore+
"NOWHITESPACEAFTER:"+Configuration.NoWhitespaceAfter+
"NOLINEWRAP:"+Configuration.NoLineWrap+
"NOFINALIZER:"+Configuration.NoFinalizer+
"NOCLONE:"+Configuration.NoClone+
"NEWLINEATENDOFFILE:"+Configuration.NewlineAtEndOfFile+
"NESTEDTRYDEPTH:"+Configuration.NestedTryDepth+
"NESTEDIFDEPTH:"+Configuration.NestedIfDepth+
"NESTEDFORDEPTH:"+Configuration.NestedForDepth+
"NEEDBRACESALLOWSINGLELINEIF:"+Configuration.NeedBracesAllowSingleLineIf+
"NEEDBRACES:"+Configuration.NeedBraces+
"NPATHCOMPLEXITY:"+Configuration.NPathComplexity+
"MUTABLEEXCEPTIONCHECK:"+Configuration.MutableExceptionCheck+
"MULTIPLEVARIABLEDECLARATIONS:"+Configuration.MultipleVariableDeclarations+
"MULTIPLESTRINGLITERALS:"+Configuration.MultipleStringLiterals+
"MODIFIERORDER:"+Configuration.ModifierOrder+
"MODIFIEDCONTROLVARIABLE:"+Configuration.ModifiedControlVariable+
"MISSINGSWITCHDEFAULT:"+Configuration.MissingSwitchDefault+
"MISSINGOVERRIDE:"+Configuration.MissingOverride+
"MISSINGDEPRECATED:"+Configuration.MissingDeprecated+
"MISSINGCTOR:"+Configuration.MissingCtor+
"METHODTYPEPARAMETERNAME:"+Configuration.MethodTypeParameterName+
"METHODPARAMPAD:"+Configuration.MethodParamPad+
"METHODNAMEALLOWCLASSNAME:"+Configuration.MethodNameallowClassName+
"METHODNAME:"+Configuration.MethodName+
"METHODLENGTH:"+Configuration.MethodLength+
"METHODCOUNT:"+Configuration.MethodCount+
"MEMBERNAME:"+Configuration.MemberName+
"MAGICNUMBER:"+Configuration.MagicNumber+
"LOCALVARIABLENAMEALLOWONECHARVARINFORLOOP:"+Configuration.LocalVariableNameallowOneCharVarInForLoop+
"LOCALVARIABLENAME:"+Configuration.LocalVariableName+
"LOCALFINALVARIABLENAME:"+Configuration.LocalFinalVariableName+
"LINELENGTH:"+Configuration.LineLength+
"LEFTCURLY:"+Configuration.LeftCurly+
"JAVADOCVARIABLE:"+Configuration.JavadocVariable+
"JAVADOCTYPE:"+Configuration.JavadocType+
"JAVADOCTAGCONTINUATIONINDENTATION:"+Configuration.JavadocTagContinuationIndentation+
"JAVADOCSTYLE:"+Configuration.JavadocStyle+
"JAVADOCPARAGRAPH:"+Configuration.JavadocParagraph+
"JAVADOCPACKAGE:"+Configuration.JavadocPackage+
"JAVADOCMETHOD:"+Configuration.JavadocMethod+
"JAVANCSS:"+Configuration.JavaNCSS+
"INTERFACETYPEPARAMETERNAME:"+Configuration.InterfaceTypeParameterName+
"INTERFACEISTYPE:"+Configuration.InterfaceIsType+
"INNERTYPELAST:"+Configuration.InnerTypeLast+
"INNERASSIGNMENT:"+Configuration.InnerAssignment+
"INDENTATIONFORCESTRICTCONDITION:"+Configuration.IndentationForceStrictCondition+
"INDENTATION:"+Configuration.Indentation+
"IMPORTORDER:"+Configuration.ImportOrder+
"IMPORTCONTROL:"+Configuration.ImportControl+
"ILLEGALTYPECHECK:"+Configuration.IllegalTypeCheck+
"ILLEGALTOKENTEXTCHECK:"+Configuration.IllegalTokenTextCheck+
"ILLEGALTOKEN:"+Configuration.IllegalToken+
"ILLEGALTHROWS:"+Configuration.IllegalThrows+
"ILLEGALINSTANTIATION:"+Configuration.IllegalInstantiation+
"ILLEGALIMPORT:"+Configuration.IllegalImport+
"ILLEGALCATCH:"+Configuration.IllegalCatch+
"HIDEUTILITYCLASSCONSTRUCTOR:"+Configuration.HideUtilityClassConstructor+
"HIDDENFIELD:"+Configuration.HiddenField+
"HEADERCHECK:"+Configuration.HeaderCheck+
"GENERICWHITESPACE:"+Configuration.GenericWhitespace+
"FINALPARAMETERS:"+Configuration.FinalParameters+
"FINALLOCALVARIABLE:"+Configuration.FinalLocalVariable+
"FINALCLASS:"+Configuration.FinalClass+
"FILETABCHARACTER:"+Configuration.FileTabCharacter+
"FILELENGTH:"+Configuration.FileLength+
"FALLTHROUGH:"+Configuration.FallThrough+
"EXPLICITINITIALIZATION:"+Configuration.ExplicitInitialization+
"EXECUTABLESTATEMENTCOUNT:"+Configuration.ExecutableStatementCount+
"EQUALSHASHCODE:"+Configuration.EqualsHashCode+
"EQUALSAVOIDNULL:"+Configuration.EqualsAvoidNull+
"EMPTYSTATEMENT:"+Configuration.EmptyStatement+
"EMPTYLINESEPARATORALLOWNOEMPTYLINEBETWEENFIELDS:"+Configuration.EmptyLineSeparatorallowNoEmptyLineBetweenFields+
"EMPTYLINESEPARATORALLOWMULTIPLEEMPTYLINES:"+Configuration.EmptyLineSeparatorallowMultipleEmptyLines+
"EMPTYLINESEPARATOR:"+Configuration.EmptyLineSeparator+
"EMPTYFORITERATORPAD:"+Configuration.EmptyForIteratorPad+
"EMPTYCATCHBLOCK:"+Configuration.EmptyCatchBlock+
"EMPTYBLOCK:"+Configuration.EmptyBlock+
"DESIGNFOREXTENSION:"+Configuration.DesignForExtension+
"DEFAULTCOMESLAST:"+Configuration.DefaultComesLast+
"DECLARATIONORDER:"+Configuration.DeclarationOrder+
"CYCLOMATICCOMPLEXITY:"+Configuration.CyclomaticComplexity+
"CUSTOMIMPORTORDER:"+Configuration.CustomImportOrder+
"COVARIANTEQUALS:"+Configuration.CovariantEquals+
"CONSTANTNAME:"+Configuration.ConstantName+
"CLASSTYPEPARAMETERNAME:"+Configuration.ClassTypeParameterName+
"CLASSFANOUTCOMPLEXITYCHECK:"+Configuration.ClassFanOutComplexityCheck+
"CLASSDATAABSTRACTIONCOUPLINGCHECK:"+Configuration.ClassDataAbstractionCouplingCheck+
"BOOLEANEXPRESSIONCOMPLEXITY:"+Configuration.BooleanExpressionComplexity+
"AVOIDSTARIMPORTCHECK:"+Configuration.AvoidStarImportCheck+
"AVOIDNESTEDBLOCKS:"+Configuration.AvoidNestedBlocks+
"AVOIDINLINECONDITIONALS:"+Configuration.AvoidInlineConditionals+
"AVOIDESCAPEDUNICODECHARACTERS:"+Configuration.AvoidEscapedUnicodeCharacters+
"ATCLAUSEORDER:"+Configuration.AtclauseOrder+
"ARRAYTYPESTYLE:"+Configuration.ArrayTypeStyle+
"ARRAYTRAILINGCOMMA:"+Configuration.ArrayTrailingComma+
"ANONINNERLENGTH:"+Configuration.AnonInnerLength+
"ANNOTATIONUSESTYLE:"+Configuration.AnnotationUseStyle+
"ANNOTATIONLOCATION:"+Configuration.AnnotationLocation+
"ABSTRACTCLASSNAMEIGNORENAME:"+Configuration.AbstractClassNameignoreName+
"ABSTRACTCLASSNAMEIGNOREMODIFIER:"+Configuration.AbstractClassNameignoreModifier+
"ABSTRACTCLASSNAME:"+Configuration.AbstractClassName+
"ABBREVIATIONASWORDINNAMEIGNORESTATIC:"+Configuration.AbbreviationAsWordInNameignoreStatic+
"ABBREVIATIONASWORDINNAMEIGNOREOVERRIDDENMETHODS:"+Configuration.AbbreviationAsWordInNameignoreOverriddenMethods+
"ABBREVIATIONASWORDINNAMEIGNOREFINAL:"+Configuration.AbbreviationAsWordInNameignoreFinal+
"ABBREVIATIONASWORDINNAME:"+Configuration.AbbreviationAsWordInName


		          );
   }
























































    
 	
	
}