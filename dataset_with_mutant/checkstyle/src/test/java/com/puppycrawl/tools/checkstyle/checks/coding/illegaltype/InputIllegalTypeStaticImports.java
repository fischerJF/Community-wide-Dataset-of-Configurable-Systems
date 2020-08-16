package com.puppycrawl.tools.checkstyle.checks.coding.illegaltype;

import static utils.CheckUtil.isElseIf;

import com.puppycrawl.tools.checkstyle.checks.coding.illegaltype.InputIllegalType.SomeStaticClass;

import static utils.CheckUtil.*;
//import static illegaltype.InputIllegalType.SomeStaticClass;
import api.DetailAST;
//configuration: "illegalClassNames": SomeStaticClass
public class InputIllegalTypeStaticImports
{
     private boolean foo(DetailAST ast) {
         return isElseIf(ast);
     }
     SomeStaticClass staticClass; //WARNING
     private static SomeStaticClass foo1() { return null;}
     private static void foo2(SomeStaticClass s) {}
}
