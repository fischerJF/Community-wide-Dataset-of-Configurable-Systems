/*
 * TestDifficultSituations.java: JUnit test for a Tokenizer
 *
 * Copyright (C) 2002 Heiko Blau
 *
 * This file belongs to the JTopas test suite.
 * The JTopas test suite is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation; either version 2.1 of the License, or (at your option) 
 * any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along 
 * with the JTopas test suite. If not, write to the
 *
 *   Free Software Foundation, Inc.
 *   59 Temple Place, Suite 330, 
 *   Boston, MA 02111-1307 
 *   USA
 *
 * or check the Internet: http://www.fsf.org
 *
 * The JTopas test suite uses the test framework JUnit by Kent Beck and Erich Gamma.
 * You should have received a copy of their JUnit licence agreement along with 
 * the JTopas test suite.
 *
 * We do NOT provide the JUnit archive junit.jar nessecary to compile and run 
 * our tests, since we assume, that You  either have it already or would like 
 * to get the current release Yourself. 
 * Please visit either:
 *   http://sourceforge.net/projects/junit
 * or
 *   http://junit.org
 * to obtain JUnit.
 *
 * Contact:
 *   email: heiko@susebox.de 
 */

package tests.de.susebox.jtopas;

//-----------------------------------------------------------------------------
// Imports
//
import static org.junit.Assert.assertTrue;

import java.io.StringReader;

import org.junit.Assume;
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
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.TokenizerSource;
import specifications.Configuration;



//-----------------------------------------------------------------------------
// Class TestDifficultSituations
//

/**<p>
 * The class contains a number of test cases that are supposed to be difficult
 * to handle for a {@link Tokenizer}, e.g. EOF conditions inside strings etc.
 *</p>
 *
 * @see     Tokenizer
 * @see     StandardTokenizer
 * @see     StandardTokenizerProperties
 * @author  Heiko Blau
 */
public class TestDifficultSituations   {
  
  //---------------------------------------------------------------------------
  // properties
  //

  
  //---------------------------------------------------------------------------
  // main method
  //
  
  /**
   * call this method to invoke the tests
   */
//  public static void main(String[] args) {
//    String[]   tests = { TestDifficultSituations.class.getName() };
//
//    TestUtilities.run(tests, args);
//  }
  

  //---------------------------------------------------------------------------
  // suite method
  //
  
  /**
   * Implementation of the JUnit method <code>suite</code>. For each set of test
   * properties one or more tests are instantiated.
   *
   * @return a test suite
   */
//  public static Test suite() {
//    TestSuite suite = new TestSuite(TestDifficultSituations.class.getName());
//    Class[]		sourceClasses 	 = { ReaderSource.class, StringSource.class };
//    
//    for (int sourceIndex = 0; sourceIndex < sourceClasses.length; ++sourceIndex) {
//      suite.addTest(new TestDifficultSituations("testSequencesAndSeparators", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testSmallSource", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testEmptySource", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testSimilarSpecialSequences", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testNonASCIICharacters", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testEOFInLineComment", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testEOFInBlockComment", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testEOFInString", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testStringEscapes1", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testStringEscapes2", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testNestedComments", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testReaderSwitching", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testDOSEOL", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testMACEOL", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testSpecialCalls", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testLineCounting", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testUncommonWhitespaces", sourceClasses[sourceIndex]));
//      suite.addTest(new TestDifficultSituations("testWhitespaceHandling", sourceClasses[sourceIndex]));
//    }
//    return suite;
//  }
  
  
  //---------------------------------------------------------------------------
  // Constructor
  //
  
  /**
   * Default constructor. Standard input {@link java.lang.System#in} is used
   * to construct the input stream reader.
   */  
//  public TestDifficultSituations(String test, Class sourceClass) {
//    super(test);
//    _sourceClass    = sourceClass;
//  }

  
  //---------------------------------------------------------------------------
  // Fixture setup and release
  //
  
  /**
   * Sets up the fixture, for example, open a network connection.
   * This method is called before a test is executed.
   */
//  protected void setUp() throws Exception {}

  
  /**
   * Tears down the fixture, for example, close a network connection.
   * This method is called after a test is executed.
   * @throws Throwable 
   */
//  protected void tearDown() throws Exception {}
  
  
  //---------------------------------------------------------------------------
  // test cases
  //
  
  @Test
  public void testSequencesAndSeparators1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testSequencesAndSeparators();
  }

  @Test
  public void testSequencesAndSeparators2() throws Throwable {
       _sourceClass = StringSource.class;
       testSequencesAndSeparators();
  }
        
  @Test
  public void testSmallSource1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testSmallSource();
  }

  @Test
  public void testSmallSource2() throws Throwable {
       _sourceClass = StringSource.class;
       testSmallSource();
  }
        
  @Test
  public void testEmptySource1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testEmptySource();
  }

  @Test
  public void testEmptySource2() throws Throwable {
       _sourceClass = StringSource.class;
       testEmptySource();
  }
        
  @Test
  public void testSimilarSpecialSequences1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testSimilarSpecialSequences();
  }

  @Test
  public void testSimilarSpecialSequences2() throws Throwable {
       _sourceClass = StringSource.class;
       testSimilarSpecialSequences();
  }
        
  @Test
  public void testNonASCIICharacters1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testNonASCIICharacters();
  }

  @Test
  public void testNonASCIICharacters2() throws Throwable {
       _sourceClass = StringSource.class;
       testNonASCIICharacters();
  }
        
  @Test
  public void testEOFInLineComment1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testEOFInLineComment();
  }

  @Test
  public void testEOFInLineComment2() throws Throwable {
       _sourceClass = StringSource.class;
       testEOFInLineComment();
  }
        
  @Test
  public void testEOFInBlockComment1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testEOFInBlockComment();
  }

  @Test
  public void testEOFInBlockComment2() throws Throwable {
       _sourceClass = StringSource.class;
       testEOFInBlockComment();
  }
        
  @Test
  public void testEOFInString1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testEOFInString();
  }

  @Test
  public void testEOFInString2() throws Throwable {
       _sourceClass = StringSource.class;
       testEOFInString();
  }
        
  @Test
  public void testStringEscapes11() throws Throwable {
       _sourceClass = ReaderSource.class;
       testStringEscapes1();
  }

  @Test
  public void testStringEscapes12() throws Throwable {
       _sourceClass = StringSource.class;
       testStringEscapes1();
  }
        
  @Test
  public void testStringEscapes21() throws Throwable {
       _sourceClass = ReaderSource.class;
       testStringEscapes2();
  }

  @Test
  public void testStringEscapes22() throws Throwable {
       _sourceClass = StringSource.class;
       testStringEscapes2();
  }
        
  @Test
  public void testNestedComments1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testNestedComments();
  }

  @Test
  public void testNestedComments2() throws Throwable {
       _sourceClass = StringSource.class;
       testNestedComments();
  }
        
  @Test
  public void testReaderSwitching1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testReaderSwitching();
  }

  @Test
  public void testReaderSwitching2() throws Throwable {
       _sourceClass = StringSource.class;
       testReaderSwitching();
  }
        
  @Test
  public void testDOSEOL1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testDOSEOL();
  }

  @Test
  public void testDOSEOL2() throws Throwable {
       _sourceClass = StringSource.class;
       testDOSEOL();
  }
        
  @Test
  public void testMACEOL1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testMACEOL();
  }

  @Test
  public void testMACEOL2() throws Throwable {
       _sourceClass = StringSource.class;
       testMACEOL();
  }
        
  @Test
  public void testSpecialCalls1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testSpecialCalls();
  }

  @Test
  public void testSpecialCalls2() throws Throwable {
       _sourceClass = StringSource.class;
       testSpecialCalls();
  }
        
  @Test
  public void testLineCounting1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testLineCounting();
  }

  @Test
  public void testLineCounting2() throws Throwable {
       _sourceClass = StringSource.class;
       testLineCounting();
  }
        
  @Test
  public void testUncommonWhitespaces1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testUncommonWhitespaces();
  }

  @Test
  public void testUncommonWhitespaces2() throws Throwable {
       _sourceClass = StringSource.class;
       testUncommonWhitespaces();
  }
        
  @Test
  public void testWhitespaceHandling1() throws Throwable {
       _sourceClass = ReaderSource.class;
       testWhitespaceHandling();
  }

  @Test
  public void testWhitespaceHandling2() throws Throwable {
       _sourceClass = StringSource.class;
       testWhitespaceHandling();
  }

  // various constants
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
    
 public void testSimilarSpecialSequences() throws Throwable {
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
          System.out.println(token.getImage());
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
    
 public void testNonASCIICharacters() throws Throwable {
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
          System.out.println(token.getImage());
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
   * Test the case of an completely empty data source. This is always a good
   * candidate for failures :-)
   */
    
 public void testEmptySource() throws Throwable {
    TokenizerSource     source    = getSource("");
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES);
      props.addLineComment("//");
      tokenizer.setSource(source);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
      assertTrue( ! tokenizer.hasMoreToken());
    } finally {
      tokenizer.close();
    }
  }

  
  /**
   * Test small sources.
   */
    
 public void testSmallSource() throws Throwable {
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
    
 public void testEOFInLineComment() throws Throwable {
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
    
 public void testEOFInBlockComment() throws Throwable {
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
   * Test the case, when a block comment is not terminated. That means EOF
   * occurs unexpectedly in a block comment.
   */
    
 public void testEOFInString() throws Throwable {
    Assume.assumeFalse(Configuration.LINECOMMENTS);
    TokenizerSource     source    = getSource("-- end of file in String\n\"Thats the string, but rather unterminated |-(");
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.addLineComment("--");
      props.addString("\"", "\"", "\"");
      tokenizer.setSource(source);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.STRING);
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }
  
  /**
   * Test various calls to methods with a special contract.
   */
    
 public void testSpecialCalls() throws Throwable {
    TokenizerSource     source    = getSource("A simple text");
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token     = null;

    try {
      tokenizer.setSource(source);

      try {
        tokenizer.currentToken();
        assertTrue("Tokenizer should have thrown an exception here.", false);
      } catch (TokenizerException ex) {};
      try {
        tokenizer.currentImage();
        assertTrue("Tokenizer should have thrown an exception here.", false);
      } catch (TokenizerException ex) {};

      while (tokenizer.hasMoreToken()) {
        Token newToken = tokenizer.nextToken();
        assertTrue( ! tokenizer.currentToken().equals(token));
        assertTrue(tokenizer.currentToken() != null);
        assertTrue(tokenizer.currentToken().equals(newToken));
        assertTrue(tokenizer.currentToken().equals(tokenizer.currentToken()));
        if (newToken.getType() != Token.EOF) {
          assertTrue(tokenizer.currentImage() != null);
          assertTrue(tokenizer.currentImage().equals(tokenizer.currentImage()));
        } else {
          assertTrue( ! tokenizer.hasMoreToken());
        }
        token = newToken;
      }
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }
  
  /**
   * Test various situations of string escapes, if the escape character is the
   * backslash (not equal to the string character).
   * This test takes a number of lines each with a string including escapes in
   * it. It passes if the right number of strings is returned and also the line
   * counting is ok.
   */
    
 public void testStringEscapes1() throws Throwable {
    TokenizerSource     source    = getSource(
      "\"String escape \\\" in the middle\"\n"
    + "\"String escape on end \\\"\"\n"
    + "\"\\\" String escape on begin\"\n"
    + "\"Two string escapes \\\"\\\" after each other\"\n"
    + "\"Two string escapes on end \\\"\\\"\"\n");
    
    int                 lines     = 5;
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
      props.addString("\"", "\"", "\\");
      tokenizer.setSource(source);

      for (int line = 0; line < lines; ++line) {
        assertTrue("(1) No more token at line " + line, tokenizer.hasMoreToken());
        token = tokenizer.nextToken();
        assertTrue("String not recognized at line " + line, token.getType() == Token.STRING);
        assertTrue("(2) No more token at line " + line, tokenizer.hasMoreToken());
        token = tokenizer.nextToken();
        assertTrue("Newline not recognized as whitespace at line " + line, token.getType() == Token.WHITESPACE);
      }
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.EOF);
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  /**
   * Test various situations of string escapes, if the escape character is equal
   * to the string character).
   * This test takes a number of lines each with a string including escapes in
   * it. It passes if the right number of strings is returned and also the line
   * counting is ok.
   */
    
 public void testStringEscapes2() throws Throwable {
    Assume.assumeFalse(Configuration.IMAGEPARTS);
   
    TokenizerSource    source    = getSource(
      "'String escape '' in the middle'\n"
    + "'String escape on end '''\n"
    + "''' String escape on begin'\n"
    + "'Two string escapes '''' after each other'\n"
    + "'Two string escapes on end '''''\n");
    
    int                 lines     = 5;
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
      props.addString("'", "'", "'");
      tokenizer.setSource(source);

      for (int line = 0; line < lines; ++line) {
        assertTrue("(1) No more token at line " + line, tokenizer.hasMoreToken());
        token = tokenizer.nextToken();
        assertTrue("String not recognized at line " + line, token.getType() == Token.STRING);
        assertTrue("(2) No more token at line " + line, tokenizer.hasMoreToken());
        token = tokenizer.nextToken();
        assertTrue("Newline not recognized as whitespace at line " + line, token.getType() == Token.WHITESPACE);
      }
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
    
 public void testNestedComments() throws Throwable {
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
   * Test reader switching
   */
    
 public void testReaderSwitching() throws Throwable {
    TokenizerSource     source1 = getSource("0/2 4/6 8/10");
    TokenizerSource     source2 = getSource("0/2 4/6 8/10");
    TokenizerSource     source3 = getSource("0/2 4/6 8/10");
    TokenizerSource[]   sources = { source1, source2, source3 };
    
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      for (int sourceIndex = 0; sourceIndex < sources.length; ++sourceIndex) {
        tokenizer.setSource(sources[sourceIndex]);
        for (int ii = 0; ii <= 8; ii += 4) {
          assertTrue(tokenizer.hasMoreToken());
          token = tokenizer.nextToken();
          assertTrue("Wrong start position " + token.getStartPosition(), token.getStartPosition() == ii);
          assertTrue("Wrong type " + token.getType(), token.getType() == Token.NORMAL);
          assertTrue("Token not recognized as literal", tokenizer.currentImage().equals(Integer.toString(ii)));
          assertTrue(tokenizer.hasMoreToken());
          token = tokenizer.nextToken();
          assertTrue("Wrong start position " + token.getStartPosition(), token.getStartPosition() == ii + 1);
          assertTrue("Wrong type " + token.getType(), token.getType() == Token.SEPARATOR);
          assertTrue("Separator not recognized as literal", tokenizer.currentImage().equals("/"));
          assertTrue(tokenizer.hasMoreToken());
          token = tokenizer.nextToken();
          assertTrue("Wrong start position " + token.getStartPosition(), token.getStartPosition() == ii + 2);
          assertTrue("Wrong type " + token.getType(), token.getType() == Token.NORMAL);
          assertTrue("Token not recognized as literal", tokenizer.currentImage().equals(Integer.toString(ii + 2)));
        }
      }
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }


  /**
   * Line counting and line comments in DOS files
   */
    
 public void testDOSEOL() throws Throwable {
    TokenizerSource     source    = getSource(
      "// line comment with DOS line ending\r\n"
    + "void main(int argc)\r\n"
    + "{\r\n"
    + "  // another line comment\r\n"
    + "  /* a block comment\r\n"
    + "     with more than one line\r\n" 
    + "  */\r\n"
    + "}\r\n");
    
    int                 lines     = 8;
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
      props.addString("\"", "\"", "\\");
      tokenizer.setSource(source);

      // zero line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(1) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(2) start line wrong", token.getStartLine() == 0);
      assertTrue("(3) start column wrong", token.getStartColumn() == 0);
      assertTrue("(4) end line wrong", token.getEndLine() == 1);
      assertTrue("(5) end column wrong", token.getEndColumn() == 0);

      // first line: void
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(10) token \"void\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("void"));
      assertTrue("(11) start line wrong", token.getStartLine() == 1);
      assertTrue("(12) start column wrong", token.getStartColumn() == 0);
      assertTrue("(13) end line wrong", token.getEndLine() == 1);
      assertTrue("(14) end column wrong", token.getEndColumn() == 4);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(15) whitespace not recognized", token.getType() == Token.WHITESPACE);

      // first line: main
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(20) token \"main\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("main"));
      assertTrue("(21) start line wrong", token.getStartLine() == 1);
      assertTrue("(22) start column wrong", token.getStartColumn() == 5);
      assertTrue("(23) end line wrong", token.getEndLine() == 1);
      assertTrue("(24) end column wrong", token.getEndColumn() == 9);

      // first line: (
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(30) token \"(\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals("("));
      assertTrue("(31) start line wrong", token.getStartLine() == 1);
      assertTrue("(32) start column wrong", token.getStartColumn() == 9);
      assertTrue("(33) end line wrong", token.getEndLine() == 1);
      assertTrue("(34) end column wrong", token.getEndColumn() == 10);

      // first line: int
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(40) token \"int\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("int"));
      assertTrue("(41) start line wrong", token.getStartLine() == 1);
      assertTrue("(42) start column wrong", token.getStartColumn() == 10);
      assertTrue("(43) end line wrong", token.getEndLine() == 1);
      assertTrue("(44) end column wrong", token.getEndColumn() == 13);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(45) whitespace not recognized", token.getType() == Token.WHITESPACE);

      // first line: argc
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(50) token \"argc\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("argc"));
      assertTrue("(51) start line wrong", token.getStartLine() == 1);
      assertTrue("(52) start column wrong", token.getStartColumn() == 14);
      assertTrue("(53) end line wrong", token.getEndLine() == 1);
      assertTrue("(54) end column wrong", token.getEndColumn() == 18);

      // first line: )
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(60) token \")\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals(")"));
      assertTrue("(61) start line wrong", token.getStartLine() == 1);
      assertTrue("(62) start column wrong", token.getStartColumn() == 18);
      assertTrue("(63) end line wrong", token.getEndLine() == 1);
      assertTrue("(64) end column wrong", token.getEndColumn() == 19);

      // first line: EOL
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(60) token \"\\r\\n\" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r\n"));
      assertTrue("(61) start line wrong", token.getStartLine() == 1);
      assertTrue("(62) start column wrong", token.getStartColumn() == 19);
      assertTrue("(63) end line wrong", token.getEndLine() == 2);
      assertTrue("(64) end column wrong", token.getEndColumn() == 0);
      assertTrue("(65) wrong length", token.getLength() == 2);

      // second line: {
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(70) token \"{\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals("{"));
      assertTrue("(71) start line wrong", token.getStartLine() == 2);
      assertTrue("(72) start column wrong", token.getStartColumn() == 0);
      assertTrue("(73) end line wrong", token.getEndLine() == 2);
      assertTrue("(74) end column wrong", token.getEndColumn() == 1);

      // second/third line: EOL + whitespaces
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(80) token \"\\r\\n  \" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r\n  "));
      assertTrue("(81) start line wrong", token.getStartLine() == 2);
      assertTrue("(82) start column wrong", token.getStartColumn() == 1);
      assertTrue("(83) end line wrong", token.getEndLine() == 3);
      assertTrue("(84) end column wrong", token.getEndColumn() == 2);
      assertTrue("(85) wrong length", token.getLength() == 4);

      // third line: line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(91) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(92) start line wrong", token.getStartLine() == 3);
      assertTrue("(93) start column wrong", token.getStartColumn() == 2);
      assertTrue("(94) end line wrong", token.getEndLine() == 4);
      assertTrue("(95) end column wrong", token.getEndColumn() == 0);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(96) whitespace not recognized", token.getType() == Token.WHITESPACE);

      // forth line: block comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(101) block comment not recognized", token.getType() == Token.BLOCK_COMMENT);
      assertTrue("(102) start line wrong", token.getStartLine() == 4);
      assertTrue("(103) start column wrong", token.getStartColumn() == 2);
      assertTrue("(104) end line wrong", token.getEndLine() == 6);
      assertTrue("(105) end column wrong", token.getEndColumn() == 4);

      // 6th line: EOL
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(110) token \"\\r\\n\" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r\n"));
      assertTrue("(111) start line wrong", token.getStartLine() == 6);
      assertTrue("(112) start column wrong", token.getStartColumn() == 4);
      assertTrue("(113) end line wrong", token.getEndLine() == 7);
      assertTrue("(114) end column wrong", token.getEndColumn() == 0);
      assertTrue("(115) wrong length", token.getLength() == 2);

      // 7th line: }
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(120) token \"}\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals("}"));
      assertTrue("(121) start line wrong", token.getStartLine() == 7);
      assertTrue("(122) start column wrong", token.getStartColumn() == 0);
      assertTrue("(123) end line wrong", token.getEndLine() == 7);
      assertTrue("(124) end column wrong", token.getEndColumn() == 1);

      // 7th line: EOL
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(130) token \"\\r\\n\" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r\n"));
      assertTrue("(131) start line wrong", token.getStartLine() == 7);
      assertTrue("(132) start column wrong", token.getStartColumn() == 1);
      assertTrue("(133) end line wrong", token.getEndLine() == 8);
      assertTrue("(134) end column wrong", token.getEndColumn() == 0);
      assertTrue("(135) wrong length", token.getLength() == 2);
      
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  /**
   * Line counting and line comments in MAC files
   */
    
 public void testMACEOL() throws Throwable {
    TokenizerSource     source    = getSource(
      "// line comment with DOS line ending\r"
    + "void main(int argc)\r"
    + "{\r"
    + "  // another line comment\r"
    + "  /* a block comment\r"
    + "     with more than one line\r" 
    + "  */\r"
    + "}\r");
    
    int                 lines     = 8;
    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    Token               token;

    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
      props.addString("\"", "\"", "\\");
      tokenizer.setSource(source);

      // zero line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(1) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(2) start line wrong", token.getStartLine() == 0);
      assertTrue("(3) start column wrong", token.getStartColumn() == 0);
      assertTrue("(4) end line wrong", token.getEndLine() == 1);
      assertTrue("(5) end column wrong", token.getEndColumn() == 0);

      // first line: void
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(10) token \"void\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("void"));
      assertTrue("(11) start line wrong", token.getStartLine() == 1);
      assertTrue("(12) start column wrong", token.getStartColumn() == 0);
      assertTrue("(13) end line wrong", token.getEndLine() == 1);
      assertTrue("(14) end column wrong", token.getEndColumn() == 4);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(15) whitespace not recognized", token.getType() == Token.WHITESPACE);

      // first line: main
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(20) token \"main\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("main"));
      assertTrue("(21) start line wrong", token.getStartLine() == 1);
      assertTrue("(22) start column wrong", token.getStartColumn() == 5);
      assertTrue("(23) end line wrong", token.getEndLine() == 1);
      assertTrue("(24) end column wrong", token.getEndColumn() == 9);

      // first line: (
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(30) token \"(\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals("("));
      assertTrue("(31) start line wrong", token.getStartLine() == 1);
      assertTrue("(32) start column wrong", token.getStartColumn() == 9);
      assertTrue("(33) end line wrong", token.getEndLine() == 1);
      assertTrue("(34) end column wrong", token.getEndColumn() == 10);

      // first line: int
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(40) token \"int\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("int"));
      assertTrue("(41) start line wrong", token.getStartLine() == 1);
      assertTrue("(42) start column wrong", token.getStartColumn() == 10);
      assertTrue("(43) end line wrong", token.getEndLine() == 1);
      assertTrue("(44) end column wrong", token.getEndColumn() == 13);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(45) whitespace not recognized", token.getType() == Token.WHITESPACE);

      // first line: argc
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(50) token \"argc\" not recognized.", token.getType() == Token.NORMAL && token.getImage().equals("argc"));
      assertTrue("(51) start line wrong", token.getStartLine() == 1);
      assertTrue("(52) start column wrong", token.getStartColumn() == 14);
      assertTrue("(53) end line wrong", token.getEndLine() == 1);
      assertTrue("(54) end column wrong", token.getEndColumn() == 18);

      // first line: )
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(60) token \")\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals(")"));
      assertTrue("(61) start line wrong", token.getStartLine() == 1);
      assertTrue("(62) start column wrong", token.getStartColumn() == 18);
      assertTrue("(63) end line wrong", token.getEndLine() == 1);
      assertTrue("(64) end column wrong", token.getEndColumn() == 19);

      // first line: EOL
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(60) token \"\\r\" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r"));
      assertTrue("(61) start line wrong", token.getStartLine() == 1);
      assertTrue("(62) start column wrong", token.getStartColumn() == 19);
      assertTrue("(63) end line wrong", token.getEndLine() == 2);
      assertTrue("(64) end column wrong", token.getEndColumn() == 0);
      assertTrue("(65) wrong length", token.getLength() == 1);

      // second line: {
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(70) token \"{\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals("{"));
      assertTrue("(71) start line wrong", token.getStartLine() == 2);
      assertTrue("(72) start column wrong", token.getStartColumn() == 0);
      assertTrue("(73) end line wrong", token.getEndLine() == 2);
      assertTrue("(74) end column wrong", token.getEndColumn() == 1);

      // second/third line: EOL + whitespaces
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(80) token \"\\r  \" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r  "));
      assertTrue("(81) start line wrong", token.getStartLine() == 2);
      assertTrue("(82) start column wrong", token.getStartColumn() == 1);
      assertTrue("(83) end line wrong", token.getEndLine() == 3);
      assertTrue("(84) end column wrong", token.getEndColumn() == 2);
      assertTrue("(85) wrong length", token.getLength() == 3);

      // third line: line comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(91) line comment not recognized", token.getType() == Token.LINE_COMMENT);
      assertTrue("(92) start line wrong", token.getStartLine() == 3);
      assertTrue("(93) start column wrong", token.getStartColumn() == 2);
      assertTrue("(94) end line wrong", token.getEndLine() == 4);
      assertTrue("(95) end column wrong", token.getEndColumn() == 0);

      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(96) whitespace not recognized", token.getType() == Token.WHITESPACE);

      // forth line: block comment
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(101) block comment not recognized", token.getType() == Token.BLOCK_COMMENT);
      assertTrue("(102) start line wrong", token.getStartLine() == 4);
      assertTrue("(103) start column wrong", token.getStartColumn() == 2);
      assertTrue("(104) end line wrong", token.getEndLine() == 6);
      assertTrue("(105) end column wrong", token.getEndColumn() == 4);

      // 6th line: EOL
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(110) token \"\\r\" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r"));
      assertTrue("(111) start line wrong", token.getStartLine() == 6);
      assertTrue("(112) start column wrong", token.getStartColumn() == 4);
      assertTrue("(113) end line wrong", token.getEndLine() == 7);
      assertTrue("(114) end column wrong", token.getEndColumn() == 0);
      assertTrue("(115) wrong length", token.getLength() == 1);

      // 7th line: }
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(120) token \"}\" not recognized.", token.getType() == Token.SEPARATOR && token.getImage().equals("}"));
      assertTrue("(121) start line wrong", token.getStartLine() == 7);
      assertTrue("(122) start column wrong", token.getStartColumn() == 0);
      assertTrue("(123) end line wrong", token.getEndLine() == 7);
      assertTrue("(124) end column wrong", token.getEndColumn() == 1);

      // 7th line: EOL
      assertTrue(tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("(130) token \"\\r\" not recognized.", token.getType() == Token.WHITESPACE && token.getImage().equals("\r"));
      assertTrue("(131) start line wrong", token.getStartLine() == 7);
      assertTrue("(132) start column wrong", token.getStartColumn() == 1);
      assertTrue("(133) end line wrong", token.getEndLine() == 8);
      assertTrue("(134) end column wrong", token.getEndColumn() == 0);
      assertTrue("(135) wrong length", token.getLength() == 1);

    } finally {
      // Cleanup
      tokenizer.close();
    }
  }

  /**
   * Line counting with setReadPosition
   */
    
 public void testLineCounting() throws Throwable {
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
   * Test the uncommon whitespaces. Note that the \r\n-combination is only treated
   * as one newline only, if both characters fall into one token.
   */
    
 public void testUncommonWhitespaces() throws Throwable {
    String              data = 
      "This  text  has  spaces\r"
    + "and newlines. Depending on the flags\n"
    + "the spaces are considered as special sequences\r\n"
    + "or real\twhitespaces.\n\n"
    + "/** also included\r"
    + "* are line and block comments\r"
    + "*/\n"
    + "here comes // the line comment\n"
    + "// and another\n";

    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    String[]            ws        = { "\r\n", " \t", " \t\n", " \t\r", " \n", " \r", "\t\r", "\t\n" };
    int[]               wsCount   = { 5,      18,    22,      20,      21,    19,    3,      5      };
    int[]               seqCount  = { 21,     7,     2,       5,       3,     6,     25,     22     };
    int[]               lineCount = { 10,     11,    11,      11,      11,    11,    11,     11     };
    TokenizerProperty   spaceProp = new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { " "  } );
    TokenizerProperty   tabProp   = new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "\t" } );
    TokenizerProperty   lfProp    = new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "\n" } );
    TokenizerProperty   crProp    = new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "\r" } );
    
    try {
      props.setParseFlags(Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES);
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
      props.addProperty(spaceProp);
      props.addProperty(tabProp);
      props.addProperty(lfProp);
      props.addProperty(crProp);
      
      for (int ii = 0; ii < ws.length; ++ii) {                                      
        int seqCounter = 0;
        int wsCounter  = 0;

        props.setWhitespaces(ws[ii]);
        tokenizer.setSource(getSource(data));

        System.out.println("Loop " + ii);
        while (tokenizer.hasMoreToken()) {
          Token token = tokenizer.nextToken();

          System.out.println(token.toString());
          switch (token.getType()) {
          case Token.SPECIAL_SEQUENCE:
            seqCounter++;
            break;
          case Token.WHITESPACE:
            wsCounter++;
            break;
          case Token.EOF:
            assertTrue("Loop " + ii + ": Expected " + lineCount[ii] + " lines, got " + token.getEndLine(), 
                        lineCount[ii] == token.getEndLine());
            break;
          }
        }
        assertTrue("Loop " + ii + ": Expected " + wsCount[ii] + " whitespaces, got " + wsCounter, 
                   wsCount[ii] == wsCounter);
        assertTrue("Loop " + ii + ": Expected " + seqCount[ii] + " special sequences, got " + seqCounter, 
                   seqCount[ii] == seqCounter);
      }
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }
    
  /**
   * Test the various whitespace flags
   */
    
 public void testWhitespaceHandling() throws Throwable {
   //MAB: This test checks the behavior of the tokenizer 
   //under different configuration flags. As some of the 
   //tokenizer flags were "transformed" in features, this
   //test will not work correctly.
   Assume.assumeTrue(false);
    String              data = 
      "/* this is a block comment "
    + "  followed by a newline (whitespace) sequence */\r\n"
    + "// a line comment\r\n"
    + "// another line comment\r\n"
    + "  /* whitespaces with a block comment in between */   \n"
    + "// a EOF-terminated line comment";

    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    int[]               flags     = { Flags.F_RETURN_BLOCK_COMMENTS,
                                      Flags.F_RETURN_LINE_COMMENTS,  
                                      Flags.F_RETURN_BLOCK_COMMENTS + Flags.F_RETURN_LINE_COMMENTS,  
                                      Flags.F_RETURN_WHITESPACES,
                                      Flags.F_RETURN_LINE_COMMENTS + Flags.F_RETURN_SIMPLE_WHITESPACES,
                                      Flags.F_RETURN_BLOCK_COMMENTS + Flags.F_RETURN_SIMPLE_WHITESPACES,
                                      Flags.F_RETURN_SIMPLE_WHITESPACES,
                                      0
                                    };
    boolean[]           propsFlag = { true, false };                                  

    try {
      props.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
      props.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
    
      for (int ii = 0; ii < propsFlag.length; ++ii) {                                      
        for (int kk = 0; kk < flags.length; ++kk) {                                      
          if (propsFlag[ii]) {
            props.setParseFlags(flags[kk]);
          } else {
            tokenizer.changeParseFlags(flags[kk], Flags.F_RETURN_WHITESPACES);
          }
          
          tokenizer.setSource(getSource(data));

          System.out.println("Loop " + ii + "/" + kk);
          while (tokenizer.hasMoreToken()) {
            Token token = tokenizer.nextToken();

            System.out.println(token.toString());
            switch (token.getType()) {
            case Token.BLOCK_COMMENT:
              assertTrue("Tokenizer returned a block comment without the flag set: " + tokenizer.currentImage(),
                        (flags[kk] & Flags.F_RETURN_BLOCK_COMMENTS) != 0);
              break;
            case Token.LINE_COMMENT:
              assertTrue("Tokenizer returned a line comment without the flag set: " + tokenizer.currentImage(),
                        (flags[kk] & Flags.F_RETURN_LINE_COMMENTS) != 0);
              break;
            case Token.WHITESPACE:
              assertTrue("Tokenizer returned a simple whitespace sequence without the flag set: " + tokenizer.currentImage(),
                        (flags[kk] & Flags.F_RETURN_SIMPLE_WHITESPACES) != 0);
              break;
            }
          }
        }
      }
    } finally {
      // Cleanup
      tokenizer.close();
    }
  }
  
  /**
   * Check mixed special sequences and separators
   */
    
 public void testSequencesAndSeparators() throws Throwable {
    String  data      = "(...::==:=: =====>==<=..()>>>>> >> >>>>)";
    int[]   expected  = { Token.SEPARATOR,          // ( 
                          Token.SPECIAL_SEQUENCE,   // ..
                          Token.SEPARATOR,          // .
                          Token.SEPARATOR,          // :
                          Token.SPECIAL_SEQUENCE,   // :=
                          Token.SEPARATOR,          // =
                          Token.SPECIAL_SEQUENCE,   // :=
                          Token.SEPARATOR,          // :
                          Token.SPECIAL_SEQUENCE,   // ==
                          Token.SPECIAL_SEQUENCE,   // ==
                          Token.SEPARATOR,          // =
                          Token.SPECIAL_SEQUENCE,   // >=
                          Token.SEPARATOR,          // =
                          Token.SPECIAL_SEQUENCE,   // <=
                          Token.SPECIAL_SEQUENCE,   // ..
                          Token.SPECIAL_SEQUENCE,   // ()
                          Token.SPECIAL_SEQUENCE,   // >>>
                          Token.SPECIAL_SEQUENCE,   // >>
                          Token.SPECIAL_SEQUENCE,   // >>
                          Token.SPECIAL_SEQUENCE,   // >>>
                          Token.SEPARATOR,          // >
                          Token.SEPARATOR,          // )
                          Token.EOF };

    TokenizerProperties props     = new StandardTokenizerProperties();
    Tokenizer           tokenizer = getTokenizer(props);
    int                 count     = 0;

    try {
      props.addSpecialSequence(":=");
      props.addSpecialSequence(">=");
      props.addSpecialSequence("<=");
      props.addSpecialSequence("==");
      props.addSpecialSequence("..");
      props.addSpecialSequence("()");
      props.addSpecialSequence("..");
      props.addSpecialSequence(">>>");
      props.addSpecialSequence(">>");
      
      tokenizer.setSource(getSource(data));

      while (tokenizer.hasMoreToken()) {
        Token token = tokenizer.nextToken();

        System.out.println(token.getImage());
        assertTrue("Token #" + (count + 1) + ": expected type " + Token.getTypeName(expected[count]) + ", got " + Token.getTypeName(token.getType()),
                    token.getType() == expected[count]);
        count++;
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
  
  
  //---------------------------------------------------------------------------
  // Members
  //
  private Class _sourceClass;
}  

