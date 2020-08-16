package com.puppycrawl.tools.checkstyle.checks.sizes.methodlength;

import api.DetailAST;
import api.TokenTypes;

public class InputMethodLengthComments {
    public void visitToken(DetailAST ast) {

        final DetailAST openingBrace = ast.findFirstToken(TokenTypes.SLIST);

        if (openingBrace != null) {
            final DetailAST closingBrace =
                    openingBrace.findFirstToken(TokenTypes.RCURLY);
        }

    }

    public DetailAST visit(DetailAST ast) {
        final DetailAST openingBrace = ast.findFirstToken(TokenTypes.SLIST);
        DetailAST closingBrace = null;

        if (openingBrace != null) {
            closingBrace = openingBrace.findFirstToken(TokenTypes.RCURLY);
        }
        return closingBrace;
    }
}
