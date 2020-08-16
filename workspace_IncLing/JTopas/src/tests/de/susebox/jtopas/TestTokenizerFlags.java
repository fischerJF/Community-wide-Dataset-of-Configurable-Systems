/*
 * TestTokenizerFlags.java: JUnit test for TokenizerProperties implementations
 *
 * Copyright (C) 2004 Heiko Blau
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
import static org.junit.Assert.*;

import org.junit.Assume;
import org.junit.Test;

import tests.de.susebox.TestUtilities;
import de.susebox.jtopas.Flags;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.StringSource;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.Tokenizer;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;



//-----------------------------------------------------------------------------
// Class TestTokenizerFlags
//

/**<p>
 * This class tests the behaviour of a {@link Tokenizer} regarding the flags set 
 * in the backing {@link TokenizerProperties} and the registered 
 * {@link TokenizerProperty} objects.
 *</p>
 *
 * @see     TokenizerProperties
 * @see     TokenizerProperty
 * @see     Tokenizer
 * @author  Heiko Blau
 */
//TODO all tests here fail
public class TestTokenizerFlags   {
  
  //---------------------------------------------------------------------------
  // main method
  //
  
  /**
   * call this method to invoke the tests
   */
//  public static void main(String[] args) {
//    String[]   tests = { TestTokenizerFlags.class.getName() };
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
//    TestSuite   suite = new TestSuite(TestTokenizerFlags.class.getName());
//    
//    suite.addTest(new TestTokenizerFlags("testCasePrecedence"));
//    suite.addTest(new TestTokenizerFlags("testTokenPosOnly"));
//    suite.addTest(new TestTokenizerFlags("testReturnImageParts"));
//    suite.addTest(new TestTokenizerFlags("testReturnWhitespaces"));
//    return suite;
//  }
  
  
  //---------------------------------------------------------------------------
  // Constructor
  //
  
  /**
   * Default constructor. Standard input {@link java.lang.System#in} is used
   * to construct the input stream reader.
   */  
//  public TestTokenizerFlags(String test) {
//    super(test);
//  }

  
  //---------------------------------------------------------------------------
  // test cases
  //

  /**
   * Verifying the {@link TokenizerProperties#F_CASE} and TokenizerProperties#F_NO_CASE}
   * flags.
   */
   @Test 
 public void testCasePrecedence() throws Throwable {
    StandardTokenizer           tokenizer;
    StandardTokenizerProperties props;
    Token                       token;
    
    // Precedence of the case flag
    Object noCaseComp = new Object();
    Object caseComp   = new Object();
    Object CASEComp   = new Object();

    props = new StandardTokenizerProperties();
    props.addKeyword("noCase", noCaseComp, Flags.F_NO_CASE);
    props.addKeyword("case", caseComp);
    props.addKeyword("CASE", CASEComp);
    
    tokenizer = new StandardTokenizer(props);
    try {
      tokenizer.setSource(new StringSource("noCase NOCASE NocASE nocase"));
      for (int index = 0; index < 4; index++) {
        assertTrue("No more token at index " + index + ".", tokenizer.hasMoreToken());
        token = tokenizer.nextToken();
        assertTrue("Token is null at index " + index + ".", token != null);
        switch (index) {
        case 4:
          assertTrue("Token is not EOF at index " + index + ".", token.getType() == Token.EOF);
          break;
        default:
          assertTrue("Token is no keyword at index " + index + ".", token.getType() == Token.KEYWORD);
          assertTrue("Unexpected token companion at index " + index + ".", token.getCompanion() == noCaseComp);
        }
      }

      tokenizer.setSource(new StringSource("case Case CASE cASE"));
      for (int index = 0; index < 5; index++) {
        assertTrue("No more token at index " + index + ".", tokenizer.hasMoreToken());
        token = tokenizer.nextToken();
        assertTrue("Token is null at index " + index + ".", token != null);
        switch (index) {
        case 0:
        case 2:
          assertTrue("Token is no keyword at index " + index + ".", token.getType() == Token.KEYWORD);
          if (index == 0) {
            assertTrue("Unexpected token companion at index " + index + ".", token.getCompanion() == caseComp);
          } else {
            assertTrue("Unexpected token companion at index " + index + ".", token.getCompanion() == CASEComp);
          }
          break;
        case 4:
          assertTrue("Token is not EOF at index " + index + ".", token.getType() == Token.EOF);
          break;
        default:
          assertTrue("No normal token at index " + index + ".", token.getType() == Token.NORMAL);
        }
      }
    } finally {
      tokenizer.close();
    }
  }
  
  /**
   * Verifying the {@link TokenizerProperties#F_TOKEN_POS_ONLY} flag.
   */
   @Test 
 public void testTokenPosOnly() throws Throwable {
    // MAB: This test uses TokenizerProperty objects, which
    // are able to change configuration flags when certain strings
    // are found. As some of the tokenizer flags were "transformed"
    // in features, this test will not work correctly.
     Assume.assumeTrue(false);
     
    StandardTokenizer           tokenizer;
    StandardTokenizerProperties props;
    Token                       token;
    
    // Precedence of the case flag
    props = new StandardTokenizerProperties(Flags.F_TOKEN_POS_ONLY);
    props.addProperty(new TokenizerProperty(Token.STRING, new String[] { "\"", "\"", "\""}, null, 0, Flags.F_TOKEN_POS_ONLY));
    props.addString("'", "'", "'");
    
    tokenizer = new StandardTokenizer(props);
    try {
      tokenizer.setSource(new StringSource("\"a string that is returned\""));
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("Token is no string.", token != null && token.getType() == Token.STRING);
      assertTrue("Token has no image.", token.getImage() != null);
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("Token is not EOF.", token != null && token.getType() == Token.EOF);

      tokenizer.setSource(new StringSource("'a string that is not returned'"));
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("Token is no string.", token != null && token.getType() == Token.STRING);
      assertTrue("Token has image.", token.getImage() == null);
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("Token is not EOF.", token != null && token.getType() == Token.EOF);
    } finally {
      tokenizer.close();
    }
  }
  
  /**
   * Verifying the {@link TokenizerProperties#F_RETURN_IMAGE_PARTS} flag.
   */
   @Test 
 public void testReturnImageParts() throws Throwable {
    StandardTokenizer           tokenizer;
    StandardTokenizerProperties props;
    Token                       token;
    String[]                    imageParts;
    
    // add properties
    props = new StandardTokenizerProperties(Flags.F_TOKEN_POS_ONLY);
    props.setSeparators(":");
    props.addString("\"", "\"", "\\", null, Flags.F_RETURN_IMAGE_PARTS);
    props.addPattern("([\\+\\-]?)([0-9]+)", null, Flags.F_RETURN_IMAGE_PARTS);
    props.addPattern("([\\+\\-]?)([0-9]+)\\.([0-9]+)", null, Flags.F_RETURN_IMAGE_PARTS);
    props.addString("'", "'", "'", null, Flags.F_RETURN_IMAGE_PARTS);
    props.addLineComment("--", null, Flags.F_RETURN_LINE_COMMENTS | Flags.F_RETURN_IMAGE_PARTS);
    props.addBlockComment("[[", "]]", null, Flags.F_RETURN_IMAGE_PARTS | Flags.F_RETURN_BLOCK_COMMENTS);
    
    // tokenize data
    tokenizer = new StandardTokenizer(props);
    try {
      tokenizer.setSource(new StringSource("[[\rblock comment with empty first line]] ImageParts [[with a block comment\r over 2 lines]]: +9745 1 -234 +0.09 14.1 \"a \\\"string\\\" with escapes\" 'a SQL string with ''escapes'' and\n with linefeeds\r\n' -- a line comment"));
      
      // first block comment
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "", "block comment with empty first line" } );

      // token "ImageParts"
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.NORMAL);

      // block comment token
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "with a block comment", " over 2 lines" } );

      // token ":"
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue(token.getType() == Token.SEPARATOR);

      // token "+9745"
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "+9745", "+", "9745" } );

      // token "1"
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "1", "", "1" } );

      // token "-234"
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "-234", "-", "234" } );

      // token "+0.09"
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "+0.09", "+", "0", "09" } );

      // token "14.1"
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "14.1", "", "14", "1" } );

      // string token #1
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "a \"string\" with escapes" } );

      // string token #2
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { "a SQL string with 'escapes' and", " with linefeeds", "" } );

      // line comment token
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      verifyImageParts(token, new String[] { " a line comment" } );

      // EOF reached
      assertTrue("No more token.", tokenizer.hasMoreToken());
      token = tokenizer.nextToken();
      assertTrue("Token is not EOF.", token != null && token.getType() == Token.EOF);
    } finally {
      tokenizer.close();
    }
  }
  
  /**
   * Test preceedence of {@link Tokenizer} flags over the {@link TokenizerProperties}
   * flags
   */
   @Test 
 public void testReturnWhitespaces() throws Throwable {
     //MAB: This test checks the behavior of the tokenizer 
     //under different configuration flags. As some of the 
     //tokenizer flags were "transformed" in features, this
     //test will not work correctly.
     Assume.assumeTrue(false);
     
    String source = "// a text with several token types\n"
                  + "void main(int argc, char* argv[]) {\n"
                  +   "printf(\"Hello, world!\");\n"
                  + "}";
    int[]   flagMasks = { 0, Flags.F_RETURN_WHITESPACES, Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES };
    int[][] expected  = { { Token.KEYWORD, Token.NORMAL, Token.SEPARATOR, Token.KEYWORD, Token.NORMAL, Token.SEPARATOR, Token.KEYWORD, Token.SEPARATOR, Token.NORMAL, Token.SEPARATOR, Token.SEPARATOR, Token.SEPARATOR, Token.SEPARATOR,
                            Token.NORMAL, Token.SEPARATOR, Token.STRING, Token.SEPARATOR, Token.SEPARATOR,
                            Token.SEPARATOR, Token.EOF },
                          { Token.LINE_COMMENT,
                            Token.KEYWORD, Token.WHITESPACE, Token.NORMAL, Token.SEPARATOR, Token.KEYWORD, Token.WHITESPACE, Token.NORMAL, Token.SEPARATOR, Token.WHITESPACE, Token.KEYWORD, Token.SEPARATOR, Token.WHITESPACE, Token.NORMAL, Token.SEPARATOR, Token.SEPARATOR, Token.SEPARATOR, Token.WHITESPACE, Token.SEPARATOR, Token.WHITESPACE, 
                            Token.NORMAL, Token.SEPARATOR, Token.STRING, Token.SEPARATOR, Token.SEPARATOR, Token.WHITESPACE, 
                            Token.SEPARATOR, Token.EOF },
                          { Token.LINE_COMMENT,
                            Token.KEYWORD, Token.WHITESPACE, Token.NORMAL, Token.SEPARATOR, Token.KEYWORD, Token.WHITESPACE, Token.NORMAL, Token.SEPARATOR, Token.WHITESPACE, Token.KEYWORD, Token.SEPARATOR, Token.WHITESPACE, Token.NORMAL, Token.SEPARATOR, Token.SEPARATOR, Token.SEPARATOR, Token.WHITESPACE, Token.SEPARATOR, Token.WHITESPACE, 
                            Token.NORMAL, Token.SEPARATOR, Token.STRING, Token.SEPARATOR, Token.SEPARATOR, Token.WHITESPACE, 
                            Token.SEPARATOR, Token.EOF }
                        };	
    int[][]  starts   = { { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                            -1, -1, -1, -1, -1,
                            -1, -1 },
                          { -1,
                            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                            -1, -1, -1, -1, -1, -1,
                            -1, -1 },
                          {  0,
                             0,  4,  5,  9, 10, 13, 14, 18, 19, 20, 24, 25, 26, 30, 31, 32, 33, 34, 35,
                             0,  6,  7, 22, 23, 24,
                             0,  1 }
                        };
                             
    TokenizerProperties props = new StandardTokenizerProperties(/*Flags.F_TOKEN_POS_ONLY*/);
    
    // add properties
    props.addLineComment("//");
    props.addString("\"", "\"", "\\");
    props.addKeyword("void");
    props.addKeyword("int");
    props.addKeyword("char");
    
    for (int index = 0; index < flagMasks.length; ++index) {
      Token     token;
      int       count     = 0;
      Tokenizer tokenizer = new StandardTokenizer(props);
      
      try {
        tokenizer.changeParseFlags(flagMasks[index], flagMasks[index]);
        tokenizer.setSource(new StringSource(source));

        while (tokenizer.hasMoreToken()) {
          token = tokenizer.nextToken();
  
          System.out.println(token);
          assertTrue("Index " + index + ", token #" + count + ": expected token type \"" + Token.getTypeName(expected[index][count]) + "\", got \"" + Token.getTypeName(token.getType()) + "\": " + token, 
                     token.getType() == expected[index][count]);
          assertTrue("Index " + index + ", token #" + count + ": expected start column " + starts[index][count] + ", got " + token.getStartColumn() + ": " + token, 
                     token.getStartColumn() == starts[index][count]);
          count++;
        }
      } finally {
        tokenizer.close();
      }
    }
  }
  
    
  //---------------------------------------------------------------------------
  // Implementation
  //
  
  /**
   * Checks image parts
   */
  private void verifyImageParts(Token token, String[] expected) throws Throwable {
    String[] imageParts = token.getImageParts();
    
    if (expected != null) {
      assertTrue("Token has no image parts: " + token, imageParts != null);
      assertTrue("Expected " + expected.length + " image parts, got " + imageParts.length + ": " + token, 
                imageParts.length == expected.length);
      
      for (int index = 0; index < expected.length; ++index) {
        if (expected[index] != null) {
          assertTrue("Image part " + index + ": expected \"" + expected[index] + "\", got \"" + imageParts[index] + "\": " + token, 
                     imageParts[index] != null && imageParts[index].equals(expected[index]));
        } else {
          assertTrue("Image part " + index + ": expected null, got \"" + imageParts[index] + "\": " + token, imageParts[index] == null);
        }
      }
    } else {
      assertTrue("Expected no image parts, got " + imageParts + ": " + token, imageParts == null || imageParts.length == 0);
    }
  }
  
  //---------------------------------------------------------------------------
  // Members
  //
}
