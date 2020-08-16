package com.puppycrawl.tools.checkstyle.checks.imports.customimportorder;

import checks.imports.CustomImportOrderCheck;
import checks.imports.ImportOrderCheck;
import checks.imports.ImportOrderOption;

// every import from javadoc package has comment in brackets indicating presence of keywords
// Javadoc, Check, Tag. For example J_T = Javadoc, no Check, Tag
import checks.javadoc.JavadocNodeImpl; //warn, should be on THIRD-PARTY (J__)

// STANDARD - keyword Check

import checks.javadoc.AbstractJavadocCheck; // (JC_)
import checks.javadoc.AtclauseOrderCheck; // (_C_)
import checks.javadoc.JavadocTagContinuationIndentationCheck; // (JCT)

// SPECIAL_IMPORTS - keyword Tag

import checks.javadoc.InvalidJavadocTag; // (J_T)
//import com.puppycrawl.tools.checkstyle.checks.javadoc.TagParser; // (__T)
import checks.javadoc.WriteTagCheck; //warn, should be on STANDARD (_CT)

import com.puppycrawl.tools.*;
//import com.puppycrawl.tools.checkstyle.checks.javadoc.HtmlTag; //warn, should be on SPECIAL (__T)
import checks.javadoc.JavadocTag; //warn, should be on SPECIAL (J_T)
import checks.javadoc.JavadocMethodCheck; //warn, should be on STANDARD  (JC_)
import checks.javadoc.NonEmptyAtclauseDescriptionCheck; //warn, should be on STANDARD (_C_)

public class InputCustomImportOrder_OverlappingPatterns {
}
/*
test: testRulesOrder_ThirdBeforeSame()
configuration:
        checkConfig.addAttribute("customImportOrderRules",
                "THIRD_PARTY_PACKAGE###SAME_PACKAGE(3)###SPECIAL_IMPORTS");
        checkConfig.addAttribute("sortImportsInGroupAlphabetically", "true");
*/
