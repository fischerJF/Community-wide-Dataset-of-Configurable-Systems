package tests;

import static org.junit.Assert.assertTrue;

import java.io.Reader;
import java.io.StringReader;

import org.junit.Assume;
import org.junit.Test;

import splat.JTopasVariables;
import de.susebox.jtopas.Flags;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.TokenizerProperties;

public class TestPatternMatching extends JTopasTest{
  
  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String strTestName = testName.getMethodName();
//    if (strTestName.equals("compareJTopasAgainstPattern")
//     || strTestName.equals("testNumberPattern")
//     || strTestName.equals("testPatternExt")
//     || strTestName.equals("testPatternTokenizer")
//     || strTestName.equals("testFreePattern")
//        ) {
//      // it works with just BASE___ feature enabled
//    } else {
//      System.err.printf("%s did not set default configuration", strTestName);
//    }
  }
  

  /**
   * Test the case, when a line comment is not terminated by a newline character.
   * This happens when the last line of a file is a line comment without a 
   * newline on its end.
   * This is a rather common situation.
   */
  @Test
  public void testNumberPattern() throws Throwable {
    Reader              reader    = new StringReader("0.95 123 -1 -123123.92382 0,32 +4,001 -123,213 -0");
    TokenizerProperties props     = new StandardTokenizerProperties();
    StandardTokenizer   tokenizer = new StandardTokenizer(props);

    props.removeSeparators(".\\-+,");
    props.addPattern("[+\\-]?[0-9]+\\.?[0-9]*");
    props.addPattern("[+\\-]?[0-9]+,?[0-9]*");
    tokenizer.setSource(reader);

    while (tokenizer.hasMoreToken()) {
      Token token = tokenizer.nextToken();
      
//      System.out.println(token);
      if (token.getType() != Token.EOF) {
        assertTrue("Wrong token type " + Token.getTypeName(token.getType()) + " for: " + token.getImage(), 
                    token.getType() == Token.PATTERN);
      }
    }
  }

  /**
   * Test the case, when a line comment is not terminated by a newline character.
   * This happens when the last line of a file is a line comment without a 
   * newline on its end.
   * This is a rather common situation.
   */
  @Test
  public void testPatternExt() throws Throwable {
    Assume.assumeFalse(JTopasVariables.getSINGLETON().isLINECOMMENTS___());
    
    Reader              reader    = new StringReader("// the main method\nvoid main100(100)\n{ int x1 = 0.95; int x2 = -1; int x3 = 3.0 -1.0; }");
    int[]               expected  = { Token.NORMAL, Token.NORMAL, Token.SEPARATOR, Token.PATTERN, Token.SEPARATOR, Token.SEPARATOR, 
                                      Token.NORMAL, Token.NORMAL, Token.SEPARATOR, Token.PATTERN, Token.SEPARATOR, 
                                      Token.NORMAL, Token.NORMAL, Token.SEPARATOR, Token.PATTERN, Token.SEPARATOR, 
                                      Token.NORMAL, Token.NORMAL, Token.SEPARATOR, Token.PATTERN, Token.PATTERN, Token.SEPARATOR, 
                                      Token.SEPARATOR, Token.EOF };
    TokenizerProperties props     = new StandardTokenizerProperties();
    StandardTokenizer   tokenizer = new StandardTokenizer(props);

    props.removeSeparators(".\\-");
    props.addLineComment("//");
    props.addPattern("[+\\-]?[0-9]+\\.?[0-9]*");
    tokenizer.setSource(reader);

    int index = 0;
    while (tokenizer.hasMoreToken()) {
      Token token = tokenizer.nextToken();
      
//      System.out.println(token);
      assertTrue("Wrong token type " + Token.getTypeName(token.getType()) + " for: " + token.getImage(), 
                  token.getType() == expected[index]);
      index++;
    }
  }

  /**
   * A tokenizer working almost completely with pattern and whitespaces
   */
  @Test
  public void testPatternTokenizer() throws Throwable {
    Reader reader = new StringReader(
        "// the main method\n" 
      + "void main(String[] argv)\n" 
      + "{\n"
      +   "int x1 = 0.95;     // 1. variable\n"
      +   "int x2 = -1;       // 2. variable\n"
      +   "int x3 = x1 - x2;  // 3. variable\n"
      +   "int x4 = +1.01;    // 4. variable\n"
      + "}\n");
    
    Object lineComment  = new String("<line comment>");
    Object identifier   = new String("<identifier>");
    Object number       = new String("<number>");
    Object separator    = new String("<separator>");
    
    Object[] expected = { 
      lineComment, 
      identifier, identifier, separator, identifier, separator, separator, identifier, separator,
      separator, 
      identifier, identifier, separator, number, separator, lineComment,
      identifier, identifier, separator, number, separator, lineComment,
      identifier, identifier, separator, identifier, separator, identifier, separator, lineComment,
      identifier, identifier, separator, number, separator, lineComment,
      separator
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    StandardTokenizer   tokenizer = new StandardTokenizer(props);

    props.addPattern("[+\\-]?[0-9]+\\.?[0-9]*", number);
    props.addPattern("[a-z][a-z0-9]*", identifier, Flags.F_NO_CASE);
    props.addPattern("//.*$", lineComment, Flags.F_FREE_PATTERN);
    props.addSpecialSequence("{", separator);
    props.addSpecialSequence("}", separator);
    props.addSpecialSequence("(", separator);
    props.addSpecialSequence(")", separator);
    props.addSpecialSequence("[", separator);
    props.addSpecialSequence("]", separator);
    props.addSpecialSequence("=", separator);
    props.addSpecialSequence(";", separator);
    props.addSpecialSequence("-", separator);
    tokenizer.setSource(reader);

    int index = 0;
    while (tokenizer.hasMoreToken()) {
      Token token = tokenizer.nextToken();
      
      if (token.getType() != Token.EOF) {
//        System.out.println(token);
        assertTrue("Wrong token companion: " + token.getCompanion() + " for: " + token.getImage(), 
                    token.getCompanion() == expected[index]);
      }
      index++;
    }
  }

  /**
   * A tokenizer working almost completely with pattern and whitespaces
   */
  @Test
  public void testFreePattern() throws Throwable {
    Reader reader = new StringReader(
        "// the main method\n" 
      + "void main(String[] argv)\n" 
      + "{\n"
      +   "int x1 =+1.01;\n"
      +   "int x2 =- 2.02;\n"
      +   "int x3 = + 2.02; // line comment\n"
      +   "int x4 = - 2.02+ 3.1232;\n"
      +   "fct(x1, x2, x3)// a call\n"
      + "}\n");
    
    Object lineComment  = new String("<line comment>");
    Object identifier   = new String("<identifier>");
    Object number       = new String("<number>");
    Object separator    = new String("<separator>");
    Object paraList     = new String("<parameter list>");
    
    Object[] expected = { 
      lineComment, 
      identifier, identifier, paraList,
      separator, 
      identifier, identifier, separator, number, separator,
      identifier, identifier, separator, number, separator,
      identifier, identifier, separator, number, separator, lineComment,
      identifier, identifier, separator, number, number, separator,
      identifier, paraList, lineComment,
      separator
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    StandardTokenizer   tokenizer = new StandardTokenizer(props);

    props.addPattern("[+\\-]?[ \t]*[0-9]+\\.?[0-9]*", number,      Flags.F_FREE_PATTERN);
    props.addPattern("[a-z][a-z0-9]*",                identifier,  Flags.F_NO_CASE);
    props.addPattern("//.*$",                         lineComment, Flags.F_FREE_PATTERN);
    props.addPattern("\\(.*\\)",                      paraList,    Flags.F_FREE_PATTERN);
    props.addSpecialSequence("{", separator);
    props.addSpecialSequence("}", separator);
    props.addSpecialSequence("(", separator);
    props.addSpecialSequence(")", separator);
    props.addSpecialSequence("[", separator);
    props.addSpecialSequence("]", separator);
    props.addSpecialSequence("=", separator);
    props.addSpecialSequence(";", separator);
    props.addSpecialSequence("-", separator);
    tokenizer.setSource(reader);

    int index = 0;
    while (tokenizer.hasMoreToken()) {
      Token token = tokenizer.nextToken();
      
      if (token.getType() != Token.EOF) {
//        System.out.println(token);
        assertTrue("Wrong token companion: " + token.getCompanion() + " for: " + token.getImage(), 
                    token.getCompanion() == expected[index]);
      }
      index++;
    }
  }

  /**
   * Comparing JTopas string and comment handling against regular expression
   * handling
   */
  @Test
  public void compareJTopasAgainstPattern() throws Throwable {
    String data = 
        "/* File: $FILENAME */\n"
      + "/**\n"
      + "* Starting with a Javadoc comment.\n" 
      + "* This comment describes the class below.\n" 
      + "*/\n"
      + "public class TestClass {\n" 
      + "  //-------------------------------------------------------------------\n" 
      + "  // Constants\n" 
      + "  //-------------------------------------------------------------------\n" 
      + "\n" 
      + "  /**\n" 
      + "  * A constant with its own comment\n" 
      + "  */\n" 
      + "  public static final String URL = \"http://jtopas.sourceforge.net/jtopas/index.html\";\n"
      + "\n" 
      + "  /**\n" 
      + "  * Another constant with its own comment\n" 
      + "  */\n" 
      + "  public static final String HELP =\n"
      + "     \"This is the help for JTopas.\"\n"
      + "   + \"You can obtain the software from \" + URL + \".\"\n"
      + "   + \"It is a realy easy to use library.\";\n"
      + "\n" 
      + "  /**\n" 
      + "  * The main method takes the usual array of arguments. It also accepts\n" 
      + "  * <code>null</code>.\n" 
      + "  *\n" 
      + "  * @param args the arguments to the main method.\n" 
      + "  */\n" 
      + "  public void main(String[] argv)\n" 
      + "  {\n"
      + "     // a loop over all arguments\n"
      + "     for (int ii = 0; ii < argv.length; ++ii) {\n"
      + "       char cc1 = 'A';\n"
      + "       char cc2 = 'B';\n"
      // + "       char cc3 = '\\'';\n"
      + "       System.out.println(\"String #\" + ii +\": \" + argv[ii] + \".\";\n"
      + "     }\n"
      + "     // ready message\n"
      + "     System.out.println(\"Ready printing Strings.\";\n"
      + "     /*\n"
      + "       here we add future extensions:\n"
      + "       for instance the exit call :-)\n"
      + "     */\n"
      + "  }\n"
      + "}\n";
    
    Object docComment   = new String("<doc comment>");
    Object blockComment = new String("<block comment>");
    Object lineComment  = new String("<line comment>");
    Object string       = new String("<string>");
    Object character    = new String("<character>");
    
    TokenizerProperties jtopasProps       = new StandardTokenizerProperties(Flags.F_RETURN_WHITESPACES | Flags.F_TOKEN_POS_ONLY);
    TokenizerProperties patternProps      = new StandardTokenizerProperties(Flags.F_RETURN_WHITESPACES | Flags.F_TOKEN_POS_ONLY);

    // patternProps.addPattern("/\\*\\*.*\\*/",            docComment,   Flags.F_FREE_PATTERN);
    patternProps.addPattern("/\\*.*?\\*/",                blockComment, Flags.F_FREE_PATTERN);
    patternProps.addPattern("//.*?$",                     lineComment,  Flags.F_FREE_PATTERN);
    patternProps.addPattern("\"[^$\"]*?\"",               string,       Flags.F_FREE_PATTERN);
    // patternProps.addPattern("\"[[^$\"]|[\\\\&&\"]]*?\"", string,       Flags.F_FREE_PATTERN);
    patternProps.addPattern("'.'",                        character,    Flags.F_FREE_PATTERN);
    // patternProps.addPattern("'[[^']|[\\\\&&']]+?'",       character,    Flags.F_FREE_PATTERN);
    
    // jtopasProps.addBlockComment("/**", "*/",            docComment);
    jtopasProps.addBlockComment("/*", "*/",             blockComment);
    jtopasProps.addLineComment("//",                    lineComment);
    jtopasProps.addString("\"", "\"", "\\",             string);
    jtopasProps.addString("'", "'", "\\",               character);

    tokenize(jtopasProps, data);
    tokenize(patternProps, data);
  }

  
  /**
   * Tokenize with the given tokenizer.
   */
  private void tokenize(TokenizerProperties props, String data) throws Throwable {
    long              startTime = System.currentTimeMillis();
    StandardTokenizer tokenizer = new StandardTokenizer(props);
    
    try {
      for (int ii = 0; ii < 100; ++ii) {
        Reader reader = new StringReader(data);

        try {
          tokenizer.setSource(reader);
          while (tokenizer.hasMoreToken()) {
            Token token = tokenizer.nextToken();
            // System.out.println( + ": " + tokenizer.currentImage());
          }
        } finally {
          reader.close();
        }
      }
    } finally {
      tokenizer.close();
    }
    
    // print elapsed time
    long diffTime = System.currentTimeMillis() - startTime;
//    System.out.println("  Finished after " + diffTime + " milliseconds.");
  }
}  

