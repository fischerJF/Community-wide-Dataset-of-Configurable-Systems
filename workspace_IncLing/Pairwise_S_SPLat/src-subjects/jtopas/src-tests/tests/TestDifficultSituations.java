package tests;

import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.BeforeClass;
import org.junit.Test;

import de.susebox.jtopas.Flags;
import de.susebox.jtopas.ReaderSource;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.StringSource;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.Tokenizer;
import de.susebox.jtopas.TokenizerException;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerSource;

public class TestDifficultSituations extends JTopasTest{
  
  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
  
  }
  
  private static Class[] sourceClasses;
  private Class _sourceClass;
 
  @BeforeClass
  public static void init(){
    sourceClasses  = new Class[]{ ReaderSource.class, StringSource.class };
  }
  
//various constants
 private static final String PLUS              = "+";
 private static final String DOUBLE_PLUS       = "++";
 private static final String TRIPLE_PLUS       = "+++";
 private static final String PLUS_EQUAL        = "+=";
 private static final String PLUS_MINUS        = "+-";
 private static final String HTML_OPEN         = "<";
 private static final String HTML_COMMENT1     = "<!";
 private static final String HTML_COMMENT2     = "<!--";
 private static final String HTML_HEAD         = "<head>";
 private static final String HTML_HEADER       = "<h>";
 private static final String HTML_HT           = "<ht>";
 private static final String HTML_CLOSE        = ">";
 private static final String MINUS             = "-";
 private static final String DOUBLE_MINUS      = "--";
 private static final String HTML_COMMENT_END  = "-->";
 private static final String HTML_HEAD_END     = "</head>";
 private static final String HTML_HEADER_END   = "</h>";
 private static final String SHIFT_LEFT        = "<<";
 private static final String SHIFT_RIGHT       = ">>";
 private static final String COLON             = ".";
 private static final String EURO              = "���";
 private static final String DOUBLE_EURO       = "������";
 private static final String EUROURO           = "���uro";
 private static final String AE                = "��";
 private static final String OERE              = "��";
 private static final String BUG               = "��";
 private static final String DOUBLE_BUG        = "����";
  
  /**
   * Test similar special sequences.
   */
  @Test
  public void testNonASCIICharacters1() throws Throwable {
    _sourceClass = sourceClasses[0];
    
    TokenizerSource source = getSource("1��� is an �� to much. Or��take��this: ������ or ���uro and ����.");
    
    String[] expectedToken = {
      EURO, AE, OERE, BUG, DOUBLE_EURO, EUROURO, DOUBLE_BUG
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);

    try {
      props.addSpecialSequence(EURO,          EURO);
      props.addSpecialSequence(DOUBLE_EURO,   DOUBLE_EURO);
      props.addSpecialSequence(EUROURO,       EUROURO);
      props.addSpecialSequence(AE,            AE);
      props.addSpecialSequence(OERE,          OERE);
      props.addSpecialSequence(BUG,           BUG);
      props.addSpecialSequence(DOUBLE_BUG,    DOUBLE_BUG);
      tokenizer.setSource(source);

      // start tokenizing
      int index = 0;

      while (tokenizer.hasMoreToken()) {
        Token   token = tokenizer.nextToken();
        boolean isOK;

        switch (token.getType()) {
        case Token.NORMAL:
//          System.out.println(token.getImage());
          break;
        case Token.SPECIAL_SEQUENCE:
          assertTrue( "Index " + index + ": expected \"" + expectedToken[index] + "\", got \"" + token.getImage() + "\".", 
                      expectedToken[index].equals(token.getImage()));
          index++;
          break;
        }
      }
    } finally {
      tokenizer.close();
    }
  }

 
  
  /**
   * Test small sources.
   */
  @Test
  public void testSmallSource1() throws Throwable {
    _sourceClass = sourceClasses[0];
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES);
      props.addLineComment("//");
      props.addSpecialSequence(PLUS,          PLUS);
      props.addSpecialSequence(DOUBLE_PLUS,   DOUBLE_PLUS);
      props.addSpecialSequence(MINUS,         MINUS);
      props.addSpecialSequence(DOUBLE_MINUS,  DOUBLE_MINUS);

      // a single character
      char[]  contents = new char[8192];
      int     bytes;
      
      tokenizer.setSource(getSource("A"));

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.NORMAL);
      assertTrue(token.getImage().equals("A"));
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
      assertTrue( ! tokenizer.hasMoreToken());

      // a single special sequence
      tokenizer.setSource(getSource("++"));

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.SPECIAL_SEQUENCE);
      assertTrue(token.getCompanion() == DOUBLE_PLUS);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
      assertTrue( ! tokenizer.hasMoreToken());

      // an empty line comment
      tokenizer.setSource(getSource("//"));

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.LINE_COMMENT);
      assertTrue(token.getImage().equals("//"));
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
      assertTrue( ! tokenizer.hasMoreToken());

    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  
  /**
   * Test the case, when a line comment is not terminated by a newline character.
   * This happens when the last line of a file is a line comment without a 
   * newline on its end.
   * This is a rather common situation.
   */
  @Test
  public void testEOFInLineComment1() throws Throwable {
    _sourceClass = sourceClasses[0];
    
    TokenizerSource     source    = getSource("// end of file occurs in line comment.");
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES);
      props.addLineComment("//");
      tokenizer.setSource(source);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.LINE_COMMENT);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  /**
   * Test the case, when a block comment is not terminated. That means EOF
   * occurs unexpectedly in a block comment.
   */
  @Test
  public void testEOFInBlockComment1() throws Throwable {
    _sourceClass = sourceClasses[0];
    
    TokenizerSource     source    = getSource("/* end of file occurs\nin a block comment.");
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES);
      props.addBlockComment("/*", "*/");
      tokenizer.setSource(source);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.BLOCK_COMMENT);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  /**
   * Test nested comments.
   */
  @Test
  public void testNestedComments1() throws Throwable {
    _sourceClass = sourceClasses[0];
    
    TokenizerSource     source    = getSource(
      "// line comment including // line comment sequence\n"
    + "/* block comment with\n"
    + "  /* a nested block\n"
    + "     comment\n"
    + "  */\n"
    + "  normal token or not ?\n" 
    + "*/\n"
    + "// line comment with /* block comment */\n"
    + "'a string with // line comment'\n"
    + "'a string with /* block comment */'\n");
    
    int                 lines     = 10;
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES 
                        | Flags.F_COUNT_LINES
                        | Flags.F_ALLOW_NESTED_COMMENTS);
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
      props.addString("'", "'", "'");
      tokenizer.setSource(source);

      // first line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(1) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(2) wrong start position  " + token.getStartPosition(), token.getStartPosition() == 0);
      assertTrue("(3) wrong start line " + token.getStartLine(), token.getStartLine() == 0);
      assertTrue("(4) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(5) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine() + 1);
      assertTrue("(6) wrong end column" + token.getEndColumn(), token.getEndColumn() == 0);

      // block comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(10) block comment not recognized", token.getType() == Token.BLOCK_COMMENT);
      assertTrue("(11) wrong start line " + token.getStartLine(), token.getStartLine() == 1);
      assertTrue("(12) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(13) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine() + 5);
      assertTrue("(14) wrong end column" + token.getEndColumn(), token.getEndColumn() == 2);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(15) newline behind block comment not recognized as whitespace", token.getType() == Token.WHITESPACE);
      assertTrue("(16) newline behind block comment not recognized as literal", tokenizer.currentImage().equals("\n"));

      // second line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(21) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(22) wrong start line " + token.getStartLine(), token.getStartLine() == 7);
      assertTrue("(23) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine() + 1);

      // string 1
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(31) string not recognized", token.getType() == Token.STRING);
      assertTrue("(32) wrong start line " + token.getStartLine(), token.getStartLine() == 8);
      assertTrue("(33) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(34) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine());
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(35) newline behind string not recognized as whitespace", token.getType() == Token.WHITESPACE);
      assertTrue("(36) newline behind string not recognized as literal", tokenizer.currentImage().equals("\n"));

      // string 2
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(41) string not recognized", token.getType() == Token.STRING);
      assertTrue("(42) wrong start line " + token.getStartLine(), token.getStartLine() == 9);
      assertTrue("(43) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(44) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine());
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(45) newline behind string not recognized as whitespace", token.getType() == Token.WHITESPACE);
      assertTrue("(46) newline behind string not recognized as literal", tokenizer.currentImage().equals("\n"));

      // EOF should be reached here
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);

    } finally {
      // Cleanup
      tokenizer.close();
    }
  }
  
  /**
   * Line counting with setReadPosition
   */
  @Test
  public void testLineCounting1() throws Throwable {
    _sourceClass = sourceClasses[0];
    
    TokenizerSource source = getSource(
      "01234 67 9\r\n"
    + "0 2 4 6 8\r"
    + " 1 3 5 7 9\n"
    + "01 34 67 9\n"
    + "/* block comment\n"
    + "   in three lines\r\n"
    + "*/\n"
    + "// line comment 1\r"
    + "// line comment 2\r\n"
    + "// line comment 3\n"
    + "abc // line comment 1\r"
    + "01 34 67 // line comment 2\r\n"
    + "/* block comment */ // line comment 3\n");
    
    int[] expectedLines = {
      0, 0, 0,
      1, 1, 1, 1, 1,
      2, 2, 2, 2, 2,
      3, 3, 3, 3,
      4,
      7,
      8,
      9,
      10, 10,
      11, 11, 11, 11,
      12, 12
    };
    int[] expectedColumns = {
      0, 6, 9,
      0, 2, 4, 6, 8,
      1, 3, 5, 7, 9,
      0, 3, 6, 9,
      0,
      0,
      0,
      0,
      0, 4,
      0, 3, 6, 9,
      0, 20
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token1;
    Token               token2;
    int                 line      = 0;
    int                 column    = 0;
    int                 index     = 0;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
      tokenizer.setSource(source);

      while (tokenizer.hasMoreToken()) {
        token1 = tokenizer.nextToken();
        assertTrue("Wrong line/column " + token1.getStartLine() + "/" + token1.getStartColumn(),
                   token1.getStartLine() == line && token1.getStartColumn() == column);

        tokenizer.setReadPositionRelative(-token1.getLength());
        token2 = tokenizer.nextToken();
        assertTrue("Wrong line/column " + token2.getStartLine() + "/" + token2.getStartColumn(),
                   token2.getStartLine() == line && token2.getStartColumn() == column);

        assertTrue("Token mismatch:\n  " + token1 + "\n  " + token2, token1.equals(token2));

        line    = token1.getEndLine();
        column  = token1.getEndColumn();

        // cross check the line and columns
        if (token1.getType() != Token.WHITESPACE && token1.getType() != Token.EOF) {
          assertTrue("Expected line " + expectedLines[index] + ", found " + token1.getStartLine(),
                      token1.getStartLine() == expectedLines[index]);
          assertTrue("Expected column " + expectedColumns[index] + ", found " + token1.getStartColumn(),
                      token1.getStartColumn() == expectedColumns[index]);
          index++;
        }
      }
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  /**
   * Test similar special sequences.
   */
  @Test
  public void testSimilarSpecialSequences1() throws Throwable {
    _sourceClass = sourceClasses[0];
    TokenizerSource source = getSource( "lots+of++special+=sequences+in+++a+-row\n"
                                      + "with <HEAD>HTML-tags-in-between</head>\n"
                                      + "like <h>headings</h><open and close> tags\n"
                                      + "and <!even--comments-->+<!--in<ht>many+=forms-->>\n"
                                      + "some<<as>>operators.\n"
                                      + "+++++<<<>>>.\n"
                                      );
    String[] expectedToken = {
      PLUS, DOUBLE_PLUS, PLUS_EQUAL, PLUS, TRIPLE_PLUS, PLUS_MINUS,     // "lots+of++special+=sequences+in+++a+-row\n"
      HTML_HEAD, MINUS, MINUS, MINUS, HTML_HEAD_END,                    // "with <HEAD>HTML-tags-in-between</head>\n"
      HTML_HEADER, HTML_HEADER_END, HTML_OPEN, HTML_CLOSE,              // "like <h>headings</h><open and close> tags\n"
      HTML_COMMENT1, DOUBLE_MINUS, HTML_COMMENT_END, PLUS, 
      HTML_COMMENT2, HTML_HT, PLUS_EQUAL, HTML_COMMENT_END, HTML_CLOSE, // "and <!even--comments-->+<!--in<ht>many+=forms-->>\n"
      SHIFT_LEFT, SHIFT_RIGHT, COLON,                                   // "some<<as>>operators."
      TRIPLE_PLUS, DOUBLE_PLUS, SHIFT_LEFT, HTML_OPEN, SHIFT_RIGHT, 
      HTML_CLOSE, COLON                                                 // "+++++<<<>>>.\n"
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);

    try {
      props.addSpecialSequence(COLON,             COLON);
      props.addSpecialSequence(PLUS,              PLUS);
      props.addSpecialSequence(DOUBLE_PLUS,       DOUBLE_PLUS);
      props.addSpecialSequence(TRIPLE_PLUS,       TRIPLE_PLUS);
      props.addSpecialSequence(PLUS_EQUAL,        PLUS_EQUAL);
      props.addSpecialSequence(PLUS_MINUS,        PLUS_MINUS);
      props.addSpecialSequence(SHIFT_LEFT,        SHIFT_LEFT);
      props.addSpecialSequence(HTML_OPEN,         HTML_OPEN,        Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_COMMENT1,     HTML_COMMENT1,    Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_COMMENT2,     HTML_COMMENT2,    Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEAD,         HTML_HEAD,        Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEADER,       HTML_HEADER,      Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HT,           HTML_HT,          Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_CLOSE,        HTML_CLOSE,       Flags.F_NO_CASE);
      props.addSpecialSequence(SHIFT_RIGHT,       SHIFT_RIGHT);
      props.addSpecialSequence(MINUS,             MINUS);
      props.addSpecialSequence(DOUBLE_MINUS,      DOUBLE_MINUS);
      props.addSpecialSequence(HTML_COMMENT_END,  HTML_COMMENT_END, Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEAD_END,     HTML_HEAD_END,    Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEADER_END,   HTML_HEADER_END,  Flags.F_NO_CASE);
      tokenizer.setSource(source);

      // start tokenizing
      int index = 0;

      while (tokenizer.hasMoreToken()) {
        Token   token = tokenizer.nextToken();
        boolean isOK;

        switch (token.getType()) {
        case Token.NORMAL:
//          System.out.println(token.getImage());
          break;
        case Token.SPECIAL_SEQUENCE:
          if (props.isFlagSet(props.getSpecialSequence(token.getImage()), Flags.F_NO_CASE)) {
            isOK = expectedToken[index].equalsIgnoreCase(token.getImage());
          } else {
            isOK = expectedToken[index].equals(token.getImage());
          }
          assertTrue("Index " + index + ": expected \"" + expectedToken[index] + "\", got \"" + token.getImage() + "\".", isOK);
          index++;
          break;
        }
      }
    } finally {
      tokenizer.close();
    }
  }

  /**
   * Test similar special sequences.
   */
  @Test
  public void testNonASCIICharacters2() throws Throwable {
    _sourceClass = sourceClasses[1];
    
    TokenizerSource source = getSource("1��� is an �� to much. Or��take��this: ������ or ���uro and ����.");
    
    String[] expectedToken = {
      EURO, AE, OERE, BUG, DOUBLE_EURO, EUROURO, DOUBLE_BUG
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);

    try {
      props.addSpecialSequence(EURO,          EURO);
      props.addSpecialSequence(DOUBLE_EURO,   DOUBLE_EURO);
      props.addSpecialSequence(EUROURO,       EUROURO);
      props.addSpecialSequence(AE,            AE);
      props.addSpecialSequence(OERE,          OERE);
      props.addSpecialSequence(BUG,           BUG);
      props.addSpecialSequence(DOUBLE_BUG,    DOUBLE_BUG);
      tokenizer.setSource(source);

      // start tokenizing
      int index = 0;

      while (tokenizer.hasMoreToken()) {
        Token   token = tokenizer.nextToken();
        boolean isOK;

        switch (token.getType()) {
        case Token.NORMAL:
//          System.out.println(token.getImage());
          break;
        case Token.SPECIAL_SEQUENCE:
          assertTrue( "Index " + index + ": expected \"" + expectedToken[index] + "\", got \"" + token.getImage() + "\".", 
                      expectedToken[index].equals(token.getImage()));
          index++;
          break;
        }
      }
    } finally {
      tokenizer.close();
    }
  }

  
  /**
   * Test small sources.
   */
  @Test
  public void testSmallSource2() throws Throwable {
    _sourceClass = sourceClasses[1];
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES);
      props.addLineComment("//");
      props.addSpecialSequence(PLUS,          PLUS);
      props.addSpecialSequence(DOUBLE_PLUS,   DOUBLE_PLUS);
      props.addSpecialSequence(MINUS,         MINUS);
      props.addSpecialSequence(DOUBLE_MINUS,  DOUBLE_MINUS);

      // a single character
      char[]  contents = new char[8192];
      int     bytes;
      
      tokenizer.setSource(getSource("A"));

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.NORMAL);
      assertTrue(token.getImage().equals("A"));
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
      assertTrue( ! tokenizer.hasMoreToken());

      // a single special sequence
      tokenizer.setSource(getSource("++"));

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.SPECIAL_SEQUENCE);
      assertTrue(token.getCompanion() == DOUBLE_PLUS);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
      assertTrue( ! tokenizer.hasMoreToken());

      // an empty line comment
      tokenizer.setSource(getSource("//"));

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.LINE_COMMENT);
      assertTrue(token.getImage().equals("//"));
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
      assertTrue( ! tokenizer.hasMoreToken());

    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  
  /**
   * Test the case, when a line comment is not terminated by a newline character.
   * This happens when the last line of a file is a line comment without a 
   * newline on its end.
   * This is a rather common situation.
   */
  @Test
  public void testEOFInLineComment2() throws Throwable {
    _sourceClass = sourceClasses[1];
    
    TokenizerSource     source    = getSource("// end of file occurs in line comment.");
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES);
      props.addLineComment("//");
      tokenizer.setSource(source);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.LINE_COMMENT);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  /**
   * Test the case, when a block comment is not terminated. That means EOF
   * occurs unexpectedly in a block comment.
   */
  @Test
  public void testEOFInBlockComment2() throws Throwable {
    _sourceClass = sourceClasses[1];
    
    TokenizerSource     source    = getSource("/* end of file occurs\nin a block comment.");
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES);
      props.addBlockComment("/*", "*/");
      tokenizer.setSource(source);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.BLOCK_COMMENT);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

//  /**
//   * Test various situations of string escapes, if the escape character is the
//   * backslash (not equal to the string character).
//   * This test takes a number of lines each with a string including escapes in
//   * it. It passes if the right number of strings is returned and also the line
//   * counting is ok.
//   */
//  @Test
//  public void testStringEscapes1_2() throws Throwable {
//    _sourceClass = sourceClasses[1];
//    
//    TokenizerSource     source    = getSource(
//      "\"String escape \\\" in the middle\"\n"
//    + "\"String escape on end \\\"\"\n"
//    + "\"\\\" String escape on begin\"\n"
//    + "\"Two string escapes \\\"\\\" after each other\"\n"
//    + "\"Two string escapes on end \\\"\\\"\"\n");
//    
//    int                 lines     = 5;
//    TokenizerProperties props     = new StandardTokenizerProperties();
//    Tokenizer           tokenizer = getTokenizer(props);
//    Token               token;
//
//    try {
//      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
//      props.addString("\"", "\"", "\\");
//      tokenizer.setSource(source);
//
//      for (int line = 0; line < lines; ++line) {
//        assertTrue("(1) No more token at line " + line, tokenizer.hasMoreToken());
//        token = tokenizer.nextToken();
//        assertTrue("String not recognized at line " + line, token.getType() == Token.STRING);
//        assertTrue("(2) No more token at line " + line, tokenizer.hasMoreToken());
//        token = tokenizer.nextToken();
//        assertTrue("Newline not recognized as whitespace at line " + line, token.getType() == Token.WHITESPACE);
//      }
//      assertTrue(tokenizer.hasMoreToken());
//      token = tokenizer.nextToken();
//      assertTrue(token.getType() == Token.EOF);
//    } finally {
//      // Cleanup
//      tokenizer.close();
//    }
//  }


  /**
   * Test nested comments.
   */
  @Test
  public void testNestedComments2() throws Throwable {
    _sourceClass = sourceClasses[1];
    
    TokenizerSource     source    = getSource(
      "// line comment including // line comment sequence\n"
    + "/* block comment with\n"
    + "  /* a nested block\n"
    + "     comment\n"
    + "  */\n"
    + "  normal token or not ?\n" 
    + "*/\n"
    + "// line comment with /* block comment */\n"
    + "'a string with // line comment'\n"
    + "'a string with /* block comment */'\n");
    
    int                 lines     = 10;
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES 
                        | Flags.F_COUNT_LINES
                        | Flags.F_ALLOW_NESTED_COMMENTS);
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
      props.addString("'", "'", "'");
      tokenizer.setSource(source);

      // first line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(1) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(2) wrong start position  " + token.getStartPosition(), token.getStartPosition() == 0);
      assertTrue("(3) wrong start line " + token.getStartLine(), token.getStartLine() == 0);
      assertTrue("(4) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(5) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine() + 1);
      assertTrue("(6) wrong end column" + token.getEndColumn(), token.getEndColumn() == 0);

      // block comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(10) block comment not recognized", token.getType() == Token.BLOCK_COMMENT);
      assertTrue("(11) wrong start line " + token.getStartLine(), token.getStartLine() == 1);
      assertTrue("(12) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(13) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine() + 5);
      assertTrue("(14) wrong end column" + token.getEndColumn(), token.getEndColumn() == 2);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(15) newline behind block comment not recognized as whitespace", token.getType() == Token.WHITESPACE);
      assertTrue("(16) newline behind block comment not recognized as literal", tokenizer.currentImage().equals("\n"));

      // second line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(21) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(22) wrong start line " + token.getStartLine(), token.getStartLine() == 7);
      assertTrue("(23) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine() + 1);

      // string 1
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(31) string not recognized", token.getType() == Token.STRING);
      assertTrue("(32) wrong start line " + token.getStartLine(), token.getStartLine() == 8);
      assertTrue("(33) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(34) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine());
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(35) newline behind string not recognized as whitespace", token.getType() == Token.WHITESPACE);
      assertTrue("(36) newline behind string not recognized as literal", tokenizer.currentImage().equals("\n"));

      // string 2
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(41) string not recognized", token.getType() == Token.STRING);
      assertTrue("(42) wrong start line " + token.getStartLine(), token.getStartLine() == 9);
      assertTrue("(43) wrong start column" + token.getStartColumn(), token.getStartColumn() == 0);
      assertTrue("(44) wrong end line " + token.getEndLine(), token.getEndLine() == token.getStartLine());
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(45) newline behind string not recognized as whitespace", token.getType() == Token.WHITESPACE);
      assertTrue("(46) newline behind string not recognized as literal", tokenizer.currentImage().equals("\n"));

      // EOF should be reached here
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);

    } finally {
      // Cleanup
      tokenizer.close();
    }
  }
  
  


  /**
   * Line counting with setReadPosition
   */
  @Test
  public void testLineCounting2() throws Throwable {
    _sourceClass = sourceClasses[1];
    
    TokenizerSource source = getSource(
      "01234 67 9\r\n"
    + "0 2 4 6 8\r"
    + " 1 3 5 7 9\n"
    + "01 34 67 9\n"
    + "/* block comment\n"
    + "   in three lines\r\n"
    + "*/\n"
    + "// line comment 1\r"
    + "// line comment 2\r\n"
    + "// line comment 3\n"
    + "abc // line comment 1\r"
    + "01 34 67 // line comment 2\r\n"
    + "/* block comment */ // line comment 3\n");
    
    int[] expectedLines = {
      0, 0, 0,
      1, 1, 1, 1, 1,
      2, 2, 2, 2, 2,
      3, 3, 3, 3,
      4,
      7,
      8,
      9,
      10, 10,
      11, 11, 11, 11,
      12, 12
    };
    int[] expectedColumns = {
      0, 6, 9,
      0, 2, 4, 6, 8,
      1, 3, 5, 7, 9,
      0, 3, 6, 9,
      0,
      0,
      0,
      0,
      0, 4,
      0, 3, 6, 9,
      0, 20
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token1;
    Token               token2;
    int                 line      = 0;
    int                 column    = 0;
    int                 index     = 0;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
      tokenizer.setSource(source);

      while (tokenizer.hasMoreToken()) {
        token1 = tokenizer.nextToken();
        assertTrue("Wrong line/column " + token1.getStartLine() + "/" + token1.getStartColumn(),
                   token1.getStartLine() == line && token1.getStartColumn() == column);

        tokenizer.setReadPositionRelative(-token1.getLength());
        token2 = tokenizer.nextToken();
        assertTrue("Wrong line/column " + token2.getStartLine() + "/" + token2.getStartColumn(),
                   token2.getStartLine() == line && token2.getStartColumn() == column);

        assertTrue("Token mismatch:\n  " + token1 + "\n  " + token2, token1.equals(token2));

        line    = token1.getEndLine();
        column  = token1.getEndColumn();

        // cross check the line and columns
        if (token1.getType() != Token.WHITESPACE && token1.getType() != Token.EOF) {
          assertTrue("Expected line " + expectedLines[index] + ", found " + token1.getStartLine(),
                      token1.getStartLine() == expectedLines[index]);
          assertTrue("Expected column " + expectedColumns[index] + ", found " + token1.getStartColumn(),
                      token1.getStartColumn() == expectedColumns[index]);
          index++;
        }
      }
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }



  
  /**
   * Test similar special sequences.
   */
  @Test
  public void testSimilarSpecialSequences2() throws Throwable {
    _sourceClass = sourceClasses[1];
    TokenizerSource source = getSource( "lots+of++special+=sequences+in+++a+-row\n"
                                      + "with <HEAD>HTML-tags-in-between</head>\n"
                                      + "like <h>headings</h><open and close> tags\n"
                                      + "and <!even--comments-->+<!--in<ht>many+=forms-->>\n"
                                      + "some<<as>>operators.\n"
                                      + "+++++<<<>>>.\n"
                                      );
    String[] expectedToken = {
      PLUS, DOUBLE_PLUS, PLUS_EQUAL, PLUS, TRIPLE_PLUS, PLUS_MINUS,     // "lots+of++special+=sequences+in+++a+-row\n"
      HTML_HEAD, MINUS, MINUS, MINUS, HTML_HEAD_END,                    // "with <HEAD>HTML-tags-in-between</head>\n"
      HTML_HEADER, HTML_HEADER_END, HTML_OPEN, HTML_CLOSE,              // "like <h>headings</h><open and close> tags\n"
      HTML_COMMENT1, DOUBLE_MINUS, HTML_COMMENT_END, PLUS, 
      HTML_COMMENT2, HTML_HT, PLUS_EQUAL, HTML_COMMENT_END, HTML_CLOSE, // "and <!even--comments-->+<!--in<ht>many+=forms-->>\n"
      SHIFT_LEFT, SHIFT_RIGHT, COLON,                                   // "some<<as>>operators."
      TRIPLE_PLUS, DOUBLE_PLUS, SHIFT_LEFT, HTML_OPEN, SHIFT_RIGHT, 
      HTML_CLOSE, COLON                                                 // "+++++<<<>>>.\n"
    };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);

    try {
      props.addSpecialSequence(COLON,             COLON);
      props.addSpecialSequence(PLUS,              PLUS);
      props.addSpecialSequence(DOUBLE_PLUS,       DOUBLE_PLUS);
      props.addSpecialSequence(TRIPLE_PLUS,       TRIPLE_PLUS);
      props.addSpecialSequence(PLUS_EQUAL,        PLUS_EQUAL);
      props.addSpecialSequence(PLUS_MINUS,        PLUS_MINUS);
      props.addSpecialSequence(SHIFT_LEFT,        SHIFT_LEFT);
      props.addSpecialSequence(HTML_OPEN,         HTML_OPEN,        Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_COMMENT1,     HTML_COMMENT1,    Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_COMMENT2,     HTML_COMMENT2,    Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEAD,         HTML_HEAD,        Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEADER,       HTML_HEADER,      Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HT,           HTML_HT,          Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_CLOSE,        HTML_CLOSE,       Flags.F_NO_CASE);
      props.addSpecialSequence(SHIFT_RIGHT,       SHIFT_RIGHT);
      props.addSpecialSequence(MINUS,             MINUS);
      props.addSpecialSequence(DOUBLE_MINUS,      DOUBLE_MINUS);
      props.addSpecialSequence(HTML_COMMENT_END,  HTML_COMMENT_END, Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEAD_END,     HTML_HEAD_END,    Flags.F_NO_CASE);
      props.addSpecialSequence(HTML_HEADER_END,   HTML_HEADER_END,  Flags.F_NO_CASE);
      tokenizer.setSource(source);

      // start tokenizing
      int index = 0;

      while (tokenizer.hasMoreToken()) {
        Token   token = tokenizer.nextToken();
        boolean isOK;

        switch (token.getType()) {
        case Token.NORMAL:
//          System.out.println(token.getImage());
          break;
        case Token.SPECIAL_SEQUENCE:
          if (props.isFlagSet(props.getSpecialSequence(token.getImage()), Flags.F_NO_CASE)) {
            isOK = expectedToken[index].equalsIgnoreCase(token.getImage());
          } else {
            isOK = expectedToken[index].equals(token.getImage());
          }
          assertTrue("Index " + index + ": expected \"" + expectedToken[index] + "\", got \"" + token.getImage() + "\".", isOK);
          index++;
          break;
        }
      }
    } finally {
      tokenizer.close();
    }
  }

  
  
//---------------------------------------------------------------------------
  // Implementation
  //
  
  /**
   * Get the {@link TokenizerSource}.
   */
  private TokenizerSource getSource(String data) {
    try {
      return (TokenizerSource)_sourceClass.getConstructor( new Class[] { String.class } ).newInstance(new Object[] { data } );
    } catch (Throwable ex) {
      return new ReaderSource(new StringReader(data));
    }
  }
  
  /**
   * Get the {@link Tokenizer} instance according to the class passed to the
   * constructor.
   */
  private Tokenizer getTokenizer(TokenizerProperties props) throws Throwable {
    return new StandardTokenizer(props);
  }

}
