/*
 * TestEmbeddedTokenizer.java: JUnit test for the StandardTokenizer
 *
 * Copyright (C) 2001 Heiko Blau
 *
 * This file belongs to the Susebox Java core test suite.
 * The Susebox Java core test suite is free software; you can redistribute it 
 * and/or modify it under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation; either version 2.1 of the License, 
 * or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or 
 * FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along 
 * with the Susebox Java core test suite. If not, write to the
 *
 *   Free Software Foundation, Inc.
 *   59 Temple Place, Suite 330, 
 *   Boston, MA 02111-1307 
 *   USA
 *
 * or check the Internet: http://www.fsf.org
 *
 * The Susebox Java core test suite uses the test framework JUnit by Kent Beck 
 * and Erich Gamma. You should have received a copy of their JUnit licence 
 * agreement along with the Susebox Java test suite.
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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

import org.junit.Ignore;
import org.junit.Test;

import de.susebox.java.lang.ExtRuntimeException;
import de.susebox.jtopas.Flags;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.TokenizerProperties;



//-----------------------------------------------------------------------------
// Class TestEmbeddedTokenizer
//

/**<p>
 * This unit test checks the embedded-tokenizer feature of the class {@link StandardTokenizer}.
 * With this technique it is possible to parse multipart documents like HTML with
 * embedded CSS and script parts, Java and javadoc comments etc.
 *</p><p>
 * This test suite works with a test configuration file. This file contains some
 * sets of properties, each set for one or more different test runs.
 *</p><p>
 * The properties are defined as class constants. In the configuration file, a 
 * property consists of the property name and a number identifying the property
 * set. 
 *</p>
 *
 * @see     StandardTokenizer
 * @author  Heiko Blau
 */
public class TestEmbeddedTokenizer   {
  
  //---------------------------------------------------------------------------
  // properties
  //

  /**
   * The name of the test configuration file. This file will be read by 
   * {@link java.lang.Class#getResourceAsStream}.
   */
  public static final String CONFIG_FILE = "TestEmbeddedTokenizer.conf";
  
  /**
   * Property for the test {@link #testEmbeddedTokenizer}
   */
  public static final String PROP_PATH = "Path";
  
  /**
   * Property for the test {@link #testJavaTokenizer}
   */
  public static final String PROP_JAVAPATH = "JavaPath";
  
  
  //---------------------------------------------------------------------------
  // main method
  //
  
  /**
   * call this method to invoke the tests.
   *
   * @param args  unused
   */
//  public static void main(String[] args) {
//    String[]   tests = { TestEmbeddedTokenizer.class.getName() };
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
//    TestSuite   suite = new TestSuite(TestEmbeddedTokenizer.class.getName());
//    Properties  props = new Properties();
//    int         count = 1;
//    String      path;
//    URL         url;
//    
//    try {
//      props.load(TestEmbeddedTokenizer.class.getResourceAsStream(CONFIG_FILE));
//    } catch (Exception ex) {
//      throw new ExtRuntimeException(ex);
//    }
//
//    // test on HTML files
//    while ((path = props.getProperty(PROP_PATH + count)) != null) {
//      if ((url = TestEmbeddedTokenizer.class.getResource(path)) != null) {
//        path = url.getFile();
//      }
//      suite.addTest(new TestEmbeddedTokenizer("testEmbeddedTokenizer", path));
//      count++;
//    }
//
//    // tests on Java files
//    count = 1;
//    while ((path = props.getProperty(PROP_JAVAPATH + count)) != null) {
//      if ((url = TestEmbeddedTokenizer.class.getResource(path)) != null) {
//        path = url.getFile();
//      }
//      suite.addTest(new TestEmbeddedTokenizer("testJavaTokenizer", path));
//      count++;
//    }
//    return suite;
//  }
  
  //FIXME change this in your machine! 
  private static final String PROJECT_LOCATION = "/home/mateus/workspace/spl-test-amplification/src-subjects-splat/jtopas/"; 

  @Ignore //failing test with fefault configurations
  @Test
  public void testEmbedded1() throws Throwable {
    _path = PROJECT_LOCATION + "README.html";
    InputStream  stream = new FileInputStream(_path);
    _reader = new InputStreamReader(stream);
    testEmbeddedTokenizer();
    _reader.close();
  }
  
  @Ignore //failing test with fefault configurations
  @Test
  public void testJavaTok1() throws Throwable {
    _path = PROJECT_LOCATION + "src/tests/de/susebox/jtopas/TestEmbeddedTokenizer.java";
    InputStream  stream = new FileInputStream(_path);
    _reader = new InputStreamReader(stream);
    testJavaTokenizer();
    _reader.close();
  }
  
  //---------------------------------------------------------------------------
  // Constructor
  //
  
  /**
   * Initializing the instance with the test file path
   *
   * @param test  which test method should be invoked
   * @param path  name of test configuration file  
   */  
//  public TestEmbeddedTokenizer(String test, String path) {
//    super(test);
//    _path = path;
//  }

  
  //---------------------------------------------------------------------------
  // Fixture setup and release
  //
  
  /**
   * Sets up the fixture, for example, open a network connection.
   * This method is called before a test is executed.
   *
   * @throws Exception for anything that might go wrong
   */
//  protected void setUp() throws Exception {
//    InputStream  stream = new FileInputStream(_path);
//    _reader = new InputStreamReader(stream);
//  }

  
  /**
   * Tears down the fixture, for example, close a network connection.
   * This method is called after a test is executed.
   *
   * @throws Exception for anything that might go wrong
   */
//  protected void tearDown() throws Exception {
//    _reader.close();
//  }
  
  //---------------------------------------------------------------------------
  // test cases
  //
  
  
  /**
   * This method reads the given stream as a Java source. It extracts javadoc
   * comments and source code.
   * There should be a class or interface name in every Java source. The opening
   * and closing brackets should match etc.
   *
   * @throws Throwable   for anything that might go wrong
   * @see   #testEmbeddedTokenizer
   */
 public void testJavaTokenizer() throws Throwable {
    long                        start         = System.currentTimeMillis();
    StandardTokenizerProperties javaProps     = new StandardTokenizerProperties();
    StandardTokenizerProperties docProps      = new StandardTokenizerProperties();
    StandardTokenizer           javaTokenizer = new StandardTokenizer(javaProps);
    StandardTokenizer           docTokenizer  = new StandardTokenizer(docProps);
    StandardTokenizer           currTokenizer = javaTokenizer;
    Object                      openBlock     = new Object();
    Object                      closeBlock    = new Object();
    Object                      atSign        = new Object();
    int                         blockBalance  = 0;
    Token                       token;
    int                         lastStartLineNo = -1;
    int                         lastStartColNo  = -1;

    javaProps.setParseFlags(Flags.F_TOKEN_POS_ONLY | Flags.F_KEEP_DATA | Flags.F_COUNT_LINES);
    docProps.setParseFlags(Flags.F_NO_CASE);
    
    javaProps.addSpecialSequence("/**", docTokenizer);
    javaProps.addSpecialSequence("{", openBlock);
    javaProps.addSpecialSequence("}", closeBlock);
    javaProps.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
    javaProps.addLineComment(TokenizerProperties.DEFAULT_LINE_COMMENT);
    javaProps.addString(TokenizerProperties.DEFAULT_STRING_START, TokenizerProperties.DEFAULT_STRING_END, TokenizerProperties.DEFAULT_STRING_ESCAPE);
    javaProps.addString("'", "'", "\\");
    docProps.addSpecialSequence("*/", javaTokenizer);
    docProps.addSpecialSequence("@", atSign);
    docProps.addKeyword("param");
    docProps.addKeyword("return");
    docProps.addKeyword("throws");
    docProps.addKeyword("author");
    docProps.addKeyword("version");
    docProps.addKeyword("link");
    docProps.addKeyword("see");
    docProps.addKeyword("deprecated");
    
    javaTokenizer.setSource(_reader);
    javaTokenizer.addTokenizer(docTokenizer);

    System.out.println("\nStart parsing \"" + _path + "\"");
    while (currTokenizer.hasMoreToken()) {
      token = currTokenizer.nextToken();
      
      // Line counting test
      assertTrue(token.getStartLine() >= lastStartLineNo);
      if (token.getStartLine() == lastStartLineNo) {
        assertTrue(token.getStartColumn() >= lastStartColNo);
        if (token.getEndLine() == lastStartLineNo) {
          assertTrue(token.getEndColumn() == token.getStartColumn() + token.getLength());
        }
      }
      lastStartLineNo = token.getStartLine();
      lastStartColNo  = token.getStartColumn();
      
      // tokenizer switching
      switch (token.getType()) {
        case Token.SPECIAL_SEQUENCE:
          if (token.getCompanion() instanceof StandardTokenizer) {
            StandardTokenizer tokenizer = (StandardTokenizer)token.getCompanion();
            
            currTokenizer.switchTo(tokenizer);
            currTokenizer = tokenizer;
          } else if (token.getCompanion() == openBlock) {
            blockBalance++;
          } else if (token.getCompanion() == closeBlock) {
            blockBalance--;
          } else if (token.getCompanion() == atSign) {
            token = currTokenizer.nextToken();
            assertTrue("Expected keyword after @ sign in javadoc comment, but found \"" + currTokenizer.currentImage(),
                      token.getType() == Token.KEYWORD);
          }
          break;
      }
    }
    
    // some checks
    assertTrue("Braces should be balanced in Java file \"" 
              + _path + "\", but detected inbalance " + blockBalance,
              blockBalance == 0);

    // print elapsed time
    long diff = System.currentTimeMillis() - start;
    System.out.println("Finished after " + diff + " milliseconds");
  }
    

  
  /**
   * The method takes the HTML file given in the constructor, and parses with
   * the main HTML tokenizer and two embedded tokenizers for JavaScript and
   * CSS.
   *
   * @throws Throwable   for anything that might go wrong
   * @see   #testEmbeddedTokenizer
   */
 public void testEmbeddedTokenizer() throws Throwable {
    long                        start         = System.currentTimeMillis();
    StandardTokenizerProperties htmlProps     = new StandardTokenizerProperties();
    StandardTokenizerProperties jsProps       = new StandardTokenizerProperties();
    StandardTokenizerProperties cssProps      = new StandardTokenizerProperties();
    StandardTokenizer           htmlTokenizer = new StandardTokenizer(htmlProps);
    StandardTokenizer           jsTokenizer   = new StandardTokenizer(jsProps);
    StandardTokenizer           cssTokenizer  = new StandardTokenizer(cssProps);
    String                      keywordLang   = new String("LANGUAGE");
    Object                      endOfEmbedded = new Object();
    Object                      startOfTag    = new Object();
    Object                      endOfTag      = new Object();
    Object                      endOfScript   = new Object();
    Token                       token;
    int                         lastStartLineNo = -1;
    int                         lastStartColNo  = -1;

    htmlProps.setParseFlags(Flags.F_TOKEN_POS_ONLY 
                          | Flags.F_KEEP_DATA 
                          | Flags.F_COUNT_LINES);
    cssProps.setParseFlags (Flags.F_TOKEN_POS_ONLY | Flags.F_NO_CASE);
    jsProps.setParseFlags  (Flags.F_TOKEN_POS_ONLY);
    
    htmlProps.addKeyword("SCRIPT", jsTokenizer);
    htmlProps.addKeyword("LANGUAGE", keywordLang);
    htmlProps.addKeyword("STYLE", cssTokenizer);
    htmlProps.addSpecialSequence("<", startOfTag);
    htmlProps.addSpecialSequence(">", endOfTag);
    htmlProps.addBlockComment("<!--", "-->");
    htmlProps.addString(TokenizerProperties.DEFAULT_STRING_START, TokenizerProperties.DEFAULT_STRING_END, TokenizerProperties.DEFAULT_STRING_ESCAPE);
    htmlProps.setSeparators(TokenizerProperties.DEFAULT_SEPARATORS);
    
    jsProps.addBlockComment(TokenizerProperties.DEFAULT_BLOCK_COMMENT_START, TokenizerProperties.DEFAULT_BLOCK_COMMENT_END);
    jsProps.addSpecialSequence("<!--");
    jsProps.addSpecialSequence("-->", endOfEmbedded);
    jsProps.setSeparators(TokenizerProperties.DEFAULT_SEPARATORS);
    
    cssProps.addSpecialSequence("<!--");
    cssProps.addSpecialSequence("-->", endOfEmbedded);
    
    htmlTokenizer.setSource(_reader);
    htmlTokenizer.addTokenizer(jsTokenizer);
    htmlTokenizer.addTokenizer(cssTokenizer);

    System.out.println("\nStart parsing \"" + _path + "\"");
    while (htmlTokenizer.hasMoreToken()) {
      token = htmlTokenizer.nextToken();
      
      // Line counting test
      assertTrue(token.getStartLine() >= lastStartLineNo);
      if (token.getStartLine() == lastStartLineNo) {
        assertTrue(token.getStartColumn() >= lastStartColNo);
        if (token.getEndLine() == lastStartLineNo) {
          assertTrue(token.getEndColumn() == token.getStartColumn() + token.getLength());
        }
      }
      lastStartLineNo = token.getStartLine();
      lastStartColNo  = token.getStartColumn();
      
      // Tokenizer switching
      switch (token.getType()) {
      case Token.SPECIAL_SEQUENCE:
        
        // dealing with JavaScript
        if (token.getCompanion() == startOfTag) {
          token = htmlTokenizer.nextToken();
          if (token.getType() == Token.KEYWORD && token.getCompanion() == jsTokenizer) {
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected \"" + keywordLang + "\".",
                      token.getCompanion() == keywordLang);       // see above; should be the LANGUAGE token
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected \"=\".",
                      htmlTokenizer.currentImage().equals("="));  // see above; should be "="
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected string.",
                      token.getType() == Token.STRING);           // see above; should be "JavaScript"
            
            // exclude JavaScript-Includes
            token = htmlTokenizer.nextToken();
            if (token.getCompanion() == endOfTag) {
              htmlTokenizer.switchTo(jsTokenizer);

              // continuing with JavaScriptTokenizer
              while (jsTokenizer.hasMoreToken()) {
                token = jsTokenizer.nextToken();
                if (token.getType() == Token.SPECIAL_SEQUENCE && token.getCompanion() == endOfEmbedded) {
                  jsTokenizer.switchTo(htmlTokenizer);
                  break;
                }
              }
              
              // now we should find the end-of script tag
              token = htmlTokenizer.nextToken();
              assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected start of tag.",
                        token.getCompanion() == startOfTag);
              token = htmlTokenizer.nextToken();
              assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected \"/\".",
                        htmlTokenizer.currentImage().equals("/"));
              token = htmlTokenizer.nextToken();
              assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected script.",
                        token.getCompanion() == jsTokenizer);
              token = htmlTokenizer.nextToken();
              assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected end of tag.",
                        token.getCompanion() == endOfTag);
            }
            
          // dealing with Cascading Style Sheets (CSS
          } else if (token.getType() == Token.KEYWORD && token.getCompanion() == jsTokenizer) {
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected end of tag.",
                      token.getCompanion() == endOfTag);   // should be the end of tag
            
            htmlTokenizer.switchTo(cssTokenizer);
            while (cssTokenizer.hasMoreToken()) {
              token = cssTokenizer.nextToken();
              if (token.getType() == Token.SPECIAL_SEQUENCE && token.getCompanion() == endOfEmbedded) {
                jsTokenizer.switchTo(htmlTokenizer);
                break;
              }
            }
            
            // now we should find the end-of-style tag
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected start of tag.",
                      token.getCompanion() == startOfTag);
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected \"/\".",
                      htmlTokenizer.currentImage().equals("/"));
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected script.",
                      token.getCompanion() == cssTokenizer);
            token = htmlTokenizer.nextToken();
            assertTrue("Found token \"" + htmlTokenizer.currentImage() + "\". Expected end of tag.",
                      token.getCompanion() == endOfTag);
          }
        }
        break;
      }
    }

    long diff = System.currentTimeMillis() - start;
    System.out.println("Finished after " + diff + " milliseconds");
  }
  
  
  //---------------------------------------------------------------------------
  // Members
  //
  protected InputStreamReader _reader = null;
  protected String            _path   = null;
}
