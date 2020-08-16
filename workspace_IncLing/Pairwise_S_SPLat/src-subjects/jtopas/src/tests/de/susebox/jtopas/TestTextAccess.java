/*
 * TestTextAccess.java: JUnit test for the InputStreamTokenizer
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
import static org.junit.Assert.*;

import java.io.Reader;
import java.io.StringReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.susebox.jtopas.AbstractTokenizer;
import de.susebox.jtopas.Flags;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.Tokenizer;
import de.susebox.jtopas.TokenizerProperties;



//-----------------------------------------------------------------------------
// Class TestTextAccess
//

/**<p>
 * This class tests the input data access of a {@link Tokenizer} and the setting
 * of the read position. 
 *</p>
 *
 * @see     Tokenizer
 * @see     AbstractTokenizer
 * @author  Heiko Blau
 */
public class TestTextAccess   {
  
  //---------------------------------------------------------------------------
  // main method
  //
  
  /**
   * call this method to invoke the tests
   */
//  public static void main(String[] args) {
//    String[]   tests = { TestTextAccess.class.getName() };
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
//    TestSuite   suite = new TestSuite(TestTextAccess.class.getName());
//    
//    suite.addTest(new TestTextAccess("testGetText"));
//    suite.addTest(new TestTextAccess("testSetReadPos"));
//    return suite;
//  }
  
  
  //---------------------------------------------------------------------------
  // Constructor
  //
  
  /**
   * Default constructor. Standard input {@link java.lang.System#in} is used
   * to construct the input stream reader.
   */  
//  public TestTextAccess(String test) {
//    super(test);
//  }

  
  //---------------------------------------------------------------------------
  // Fixture setup and release
  //
  
	/**
	 * Sets up the fixture, for example, open a network connection.
	 * This method is called before a test is executed.
	 */
  @Before
  public void setUp() throws Exception {
    _properties = new StandardTokenizerProperties();
    _tokenizer  = new StandardTokenizer(_properties);
    
    _properties.setParseFlags(_properties.getParseFlags() 
                            | Flags.F_KEEP_DATA 
                            | Flags.F_RETURN_WHITESPACES);
    _properties.addString("'", "'", "\\");
    _properties.addString("\"", "\"", "\\");
	}

  
	/**
	 * Tears down the fixture, for example, close a network connection.
	 * This method is called after a test is executed.
	 */
  @After
	public void tearDown() throws Exception {
    _tokenizer.close();
  }
  
  
  //---------------------------------------------------------------------------
  // test cases
  //

  /**
   * Testing various direct text access things. Moreover, the determination of
   * the read position is tested.
   */
   @Test 
 public void testGetText() throws Throwable {
    String  text   = "A text to parse.";
    Reader  reader = new StringReader(text);

    // setting the input stream
    _tokenizer.setSource(reader);
    _tokenizer.readMore();
    
    // checking ranges and positions
    int startPos = _tokenizer.getRangeStart();
    int readPos  = _tokenizer.getReadPosition();
    
    assertTrue("Current read position " + readPos + " differs from range start + " + startPos + ".", 
               startPos == readPos);
    assertTrue("Current range " + _tokenizer.currentlyAvailable() + " differs from text length " + text.length() + ".", 
               _tokenizer.currentlyAvailable() == text.length());
    
    // Check the moving of the read position
    while (_tokenizer.hasMoreToken()) {
      Token token = _tokenizer.nextToken();
    
      assertTrue("Current read position did not move by length of token " + token.getLength() 
                  + ". Moved by " + (_tokenizer.getReadPosition() - readPos) + ".",
                 _tokenizer.getReadPosition() - readPos == token.getLength());
      readPos = _tokenizer.getReadPosition();
    }
    
    // retrieving text
    String  readText = _tokenizer.getText(0, text.length());
    assertTrue("Retrieved different text \"" + readText + "\".", readText.equals(text));
    
    // retrieving text piecewise
    for (int pos = 0; pos < text.length(); ++pos) {
      for (int len = 0; len < _tokenizer.currentlyAvailable() - pos; ++len) {
        readText = _tokenizer.getText(pos, len);
        assertTrue("Expected \"" + text.substring(pos, pos + len) + "\", found \"" + readText + "\".",
                  readText.equals(text.substring(pos, pos + len)));
      }
    }

    // retrieving text characters
    for (int pos = 0; pos < text.length(); ++pos) {
      char ch = _tokenizer.getChar(pos);
      
      assertTrue("Expected '" + text.charAt(pos) + "', found '" + ch + "'.",
                 ch == text.charAt(pos));
    }
  }
  
  
  /**
   * Testing various direct text access things. Moreover, the determination of
   * the read position is tested.
   */
   @Test 
 public void testSetReadPos() throws Throwable {
    String  text   = "A text to parse.";
    Reader  reader = new StringReader(text);

    // setting the input stream
    _tokenizer.setSource(reader);
    _tokenizer.readMore();
    
    // Check relative setting of the read position
    while (_tokenizer.hasMoreToken()) {
      Token   token = _tokenizer.nextToken();
      String  image = _tokenizer.currentImage();
      int     retry = 0;
      
      if (token.getType() == Token.EOF) {
        break;
      }
      while (retry++ < 10) {
        Token token2;
        
        _tokenizer.setReadPositionRelative( - token.getLength());
        assertTrue("Should have another token.", _tokenizer.hasMoreToken());
        token2 = _tokenizer.nextToken();
        assertTrue("Retrieved unexpected token \"" + _tokenizer.currentImage() + "\" instead of \"" + image + "\".",
                   token.equals(token2));
      }
    }

    // Check absolute setting of the read position
    _tokenizer.setReadPositionAbsolute(0);
    assertTrue(_tokenizer.getReadPosition() == 0);
    
    while (_tokenizer.hasMoreToken()) {
      Token   token    = _tokenizer.nextToken();
      String  image    = _tokenizer.currentImage();
      int     startPos = token.getStartPosition();
      int     retry    = 0;
      
      if (token.getType() == Token.EOF) {
        break;
      }
      while (retry++ < 10) {
        Token token2;
        
        _tokenizer.setReadPositionAbsolute(startPos);
        assertTrue("Should have another token.", _tokenizer.hasMoreToken());
        token2 = _tokenizer.nextToken();
        assertTrue("Retrieved unexpected token \"" + _tokenizer.currentImage() + "\" instead of \"" + image + "\".",
                   token.equals(token2));
      }
    }
  }
  
  
  //---------------------------------------------------------------------------
  // Members
  //
  private StandardTokenizer   _tokenizer  = null;
  private TokenizerProperties _properties = null;
}
