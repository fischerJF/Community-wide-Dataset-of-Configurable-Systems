/*
 * TestTokenizerSource.java: JUnit test for a Tokenizer
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

import java.io.StringReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import de.susebox.jtopas.CharArraySource;
import de.susebox.jtopas.Flags;
import de.susebox.jtopas.ReaderSource;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.StringSource;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.Tokenizer;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerSource;



//-----------------------------------------------------------------------------
// Class TestTokenizerSource
//

/**<p>
 * The class contains a number of test cases that are supposed to be difficult
 * to handle for a {@link Tokenizer}, e.g. EOF conditions inside strings etc.
 *</p>
 *
 * @see     TokenizerSource
 * @author  Heiko Blau
 */
public class TestTokenizerSource   {
  
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
//    String[]   tests = { TestTokenizerSource.class.getName() };
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
//    TestSuite   suite = new TestSuite(TestTokenizerSource.class.getName());
//  
//    suite.addTest(new TestTokenizerSource("testEmptySource"));
//    suite.addTest(new TestTokenizerSource("testSmallBuffer"));
//    suite.addTest(new TestTokenizerSource("testLargeBuffer"));
//    suite.addTest(new TestTokenizerSource("testSpeed"));
//    suite.addTest(new TestTokenizerSource("testSimilarResults"));
//    suite.addTest(new TestTokenizerSource("testLargeSource"));
//    return suite;
//  }
  
  
  //---------------------------------------------------------------------------
  // Constructor
  //
  
  /**
   * Default constructor. Standard input {@link java.lang.System#in} is used
   * to construct the input stream reader.
   */  
//  public TestTokenizerSource(String test) {
//    super(test);
//  }

  
  //---------------------------------------------------------------------------
  // Fixture setup and release
  //
  
  /**
   * Sets up the fixture, for example, open a network connection.
   * This method is called before a test is executed.
   */
  protected void setUp() throws Exception {}

  
  /**
   * Tears down the fixture, for example, close a network connection.
   * This method is called after a test is executed.
   */
  protected void tearDown() throws Exception {}
  
  
  //---------------------------------------------------------------------------
  // test cases
  //

  /**
   * Test empty data sources
   */
   @Test 
 public void testEmptySource() throws Throwable {
    TokenizerSource[] source  = { null, null, null, null, null, null };
    char[]            cbuf    = new char[8129];
    int               count;
    
    source[0] = new CharArraySource(null);
    source[1] = new ReaderSource((java.io.InputStream)null);
    source[2] = new StringSource(null);
    source[3] = new CharArraySource(new char[0]);
    source[4] = new ReaderSource(new StringReader(""));
    source[5] = new StringSource("");
    for (int index = 0; index < source.length; ++index) {
      count = source[index].read(cbuf, 0, cbuf.length);
      assertTrue(source[index].getClass().getName() + ": expected -1, got " + count, count == -1);
    }
  }
  
  /**
   * Test a buffer that is smaller than the available data
   */
   @Test 
 public void testSmallBuffer() throws Throwable {
    TokenizerSource[] source  = { null, null, null };
    char[]            cbuf    = new char[1];
    char[]            text    = new char[DATA.length()];
    int               count;
    
    DATA.getChars(0, DATA.length(), text, 0);
    source[0] = new CharArraySource(text);
    source[1] = new ReaderSource(new StringReader(DATA));
    source[2] = new StringSource(DATA);
    for (int index = 0; index < source.length; ++index) {
      for (int readIndex = 0; readIndex < DATA.length(); ++readIndex) {
        count = source[index].read(cbuf, 0, cbuf.length);
        assertTrue(source[index].getClass().getName() + ": expected 1, got " + count, count == 1);
      }
      count = source[index].read(cbuf, 0, cbuf.length);
      assertTrue(source[index].getClass().getName() + ": expected -1, got " + count, count == -1);
    }
  }
  
  /**
   * Test a buffer that is larger than the available data
   */
   @Test 
 public void testLargeBuffer() throws Throwable {
    TokenizerSource[] source  = { null, null, null };
    char[]            cbuf    = new char[8192];
    char[]            text    = new char[DATA.length()];
    int               count;
    
    DATA.getChars(0, DATA.length(), text, 0);
    source[0] = new CharArraySource(text);
    source[1] = new ReaderSource(new StringReader(DATA));
    source[2] = new StringSource(DATA);
    for (int index = 0; index < source.length; ++index) {
      count = source[index].read(cbuf, 0, cbuf.length);
      assertTrue(source[index].getClass().getName() + ": expected " + DATA.length() + ", got " + count, count == DATA.length());
      count = source[index].read(cbuf, 0, cbuf.length);
      assertTrue(source[index].getClass().getName() + ": expected -1, got " + count, count == -1);
    }
  }
  
  /**
   * Test speed
   */
   @Test 
 public void testSpeed() throws Throwable {
    // construct a really huge string
    TokenizerSource source;
    char[]          buffer;
    String          text   = expandData(20000);
    char[]          cbuf   = new char[text.length()];

    text.getChars(0, text.length(), cbuf, 0);

    for (int bufferSize = 8; bufferSize < 0x20000; bufferSize *= 2) {
      System.out.println("Buffer size " + bufferSize + ":");
      buffer = new char[bufferSize];
      
      // CharArraySource
      readSource(new CharArraySource(cbuf), buffer);

      // ReaderSource
      readSource(new ReaderSource(new StringReader(text)), buffer);

      // StringSource
      readSource(new StringSource(text), buffer);
    }
  }
  
  /**
   * Test similar special sequences.
   */
   @Test 
 public void testSimilarResults() throws Throwable {
    // construct a really huge string
    String text = expandData(1000);

    // initialize the properties
    TokenizerProperties props     = new StandardTokenizerProperties();
    StandardTokenizer   tokenizer = new StandardTokenizer();
    TokenizerSource     source;
    long                startTime;

    props.addSpecialSequence(ORIG_SMILEY,       ORIG_SMILEY);
    props.addSpecialSequence(FRIGHTENED_SMIKEY, FRIGHTENED_SMIKEY);
    props.addSpecialSequence(WINKING_SMILEY,    WINKING_SMILEY);
    props.addString("\"", "\"", "\\");
    props.addString("'", "'", "\\");
    
    try {
      tokenizer.setTokenizerProperties(props);
  
      // CharArraySource
      char[] cbuf = new char[text.length()];

      text.getChars(0, text.length(), cbuf, 0);
  
      // tokenize several times to avoid JIT or hotspot optimization effects
      int   loopCount   = 100;
      int   loops       = 0;
      long  timeTotal1  = 0;
      long  timeTotal2  = 0;
      long  timeTotal3  = 0;
      
      while (loops++ < loopCount) {
        tokenizer.setSource(new CharArraySource(cbuf));

        startTime  = System.currentTimeMillis();
        List list1 = tokenize(tokenizer);
        long time1 = System.currentTimeMillis() - startTime;
        System.out.println("Loop #" + loops + ": CharArraySource needed " + time1  + "ms for " + list1.size() + " token.");
        timeTotal1 += time1;

        // ReaderSource
        tokenizer.setSource(new ReaderSource(new StringReader(text)));

        startTime = System.currentTimeMillis();
        List list2 = tokenize(tokenizer);
        long time2 = System.currentTimeMillis() - startTime;
        System.out.println("Loop #" + loops + ": ReaderSource needed " + time2 + "ms for " + list2.size() + " token.");
        timeTotal2 += time2;

        // StringSource
        tokenizer.setSource(new StringSource(text));

        startTime = System.currentTimeMillis();
        List list3 = tokenize(tokenizer);
        long time3 = System.currentTimeMillis() - startTime;
        System.out.println("Loop #" + loops + ": StringSource needed " + time3 + "ms for " + list3.size() + " token.");
        timeTotal3 += time3;

        System.out.println("CharArraySource has " + list1.size() + " token.");
        System.out.println("ReaderSource has "    + list2.size() + " token.");
        System.out.println("StringSource has "    + list3.size() + " token.");
        
        // any list shorter than the others?
        assertTrue("CharArraySource token count differs from ReaderSource token count.", list1.size() == list2.size());
        assertTrue("CharArraySource token count differs from StringSource token count.", list1.size() == list3.size());

        // check token list only once
        if (loops == loopCount) {
          System.out.println("CharArraySource total time: " + timeTotal1 + "ms.");
          System.out.println("ReaderSource total time: "    + timeTotal2 + "ms.");
          System.out.println("StringSource total time: "    + timeTotal3 + "ms.");

          Iterator iter1 = list1.iterator();
          Iterator iter2 = list2.iterator();
          Iterator iter3 = list3.iterator();
          int      index = 0;
          while (iter1.hasNext()) {
            // compare token
            Token token1 = (Token)iter1.next();
            Token token2 = (Token)iter2.next();
            Token token3 = (Token)iter3.next();

            assertTrue("Token mismatch at position " + index + ": CharArraySource \"" + token1 + "\", ReaderSource \"" + token2 + "\"",
                      token1.equals(token2));
            assertTrue("Token mismatch at position " + index + ": CharArraySource \"" + token1 + "\", StringSource \"" + token3 + "\"",
                      token1.equals(token3));
            index++;
          }
        }
      }
    } finally {
      tokenizer.close();
    }
  }
  

  /**
   * Test similar special sequences.
   */
   @Ignore //failing for default configuration
   @Test //TODO failing test
 public void testLargeSource() throws Throwable {
    // construct a large data source
    String        dataItem  = "/*\n"
                            + "* This is a Java style data item.\n"
                            + "* It is concatenated \"multible\" times to get a real\n"
                            + "* big chunk of data.\n"
                            + "* With such a lot of characters the speed of the tokenizers\n"
                            + "* can be compared.\n"
                            + "*/\n" 
                            + "package org.muppets.gonzo;\n\n"
                            + "/**\n"
                            + "* This is a class comment :-)\n"
                            + "*/\n"
                            + "public class Gonzo extends Serializable {\n\n"
                            + "  /** The standard constructor */\n"
                            + "  public Gonzo() {\n"
                            + "    // nothing todo here\n"
                            + "  }\n\n"
                            + "  /** a method */\n"
                            + "  public String toString() {\n"
                            + "    return \"This is Gonzo\";\n"
                            + "  }\n\n"
                            + "}\n\n\n";
    int           tokenCountPerItem = 35;
    int           tokenCount        = 0;
    int           maxSize           = 0x80000;
    StringBuffer  data              = new StringBuffer(maxSize);
    
    while (data.length() < maxSize) {
      data.append(dataItem);
      tokenCount += tokenCountPerItem;
    }
    tokenCount++;   // EOF token
    
    // Set up the Properties
    TokenizerProperties props = new StandardTokenizerProperties();

    props.setParseFlags(Flags.F_RETURN_BLOCK_COMMENTS + Flags.F_RETURN_LINE_COMMENTS + Flags.F_TOKEN_POS_ONLY);
    props.addBlockComment("/*", "*/");
    props.addBlockComment("/**", "*/");
    props.addLineComment("//");
    props.addString("\"", "\"", "\\");
    props.addString("'", "'", "\\");
    props.addKeyword("package");
    props.addKeyword("public");
    props.addKeyword("class");
    props.addKeyword("extends");
    props.addKeyword("return");
    props.addKeyword("if");
    props.addKeyword("then");
    props.addKeyword("while");
    props.addKeyword("for");
    props.addKeyword("int");
    props.addKeyword("char");
    props.addSpecialSequence("(");
    props.addSpecialSequence(")");
    props.addSpecialSequence(";");
    props.addSpecialSequence("==");
    props.addSpecialSequence("!=");
    props.addSpecialSequence("<=");
    props.addSpecialSequence(">=");

    // create the tokenizers.
    // NOTE: the sources have a special structure that is required for the
    // analysis below
    Tokenizer tokenizer  = new StandardTokenizer(props);
    Object[]  sources    = new Object[] { new StringSource(data.toString())
                                        , new ReaderSource(new StringReader(data.toString()))
                                        , new StringSource(data.toString().substring(0, data.toString().length() / 2))
                                        , new ReaderSource(new StringReader(data.toString().substring(0, data.toString().length() / 2)))
                                        , new StringSource(data.toString().substring(0, data.toString().length() / 5))
                                        , new ReaderSource(new StringReader(data.toString().substring(0, data.toString().length() / 5)))
                                        , new StringSource(data.toString().substring(0, data.toString().length() / 20))
                                        , new ReaderSource(new StringReader(data.toString().substring(0, data.toString().length() / 20))) };
    Object[]	tokenLists = new Object[] { null
                                        , null
                                        , null
                                        , null 
                                        , null
                                        , null 
                                        , null
                                        , null };

    try {
      for (int index = 0; index < sources.length; ++index) {
        long        start     = System.currentTimeMillis();
      
        System.out.println(sources[index].getClass().getName() + ": running ...");
        tokenizer.setSource((TokenizerSource)sources[index]);
        
        tokenLists[index] = tokenize(tokenizer);

        System.out.println(sources[index].getClass().getName() + ": " + (System.currentTimeMillis() - start) + "ms.");
      }
    } finally {
      tokenizer.close();
    }
    
    // check the results
    for (int index = 0; index < sources.length; ++index) {
      List tokenList  = (List)tokenLists[index];
      
      System.out.println(sources[index].getClass().getName() + " has " + tokenList.size() + " token.");
      
      // only the first 2 data sources have the full token count
      if (index < 2) {
        assertTrue("Expected " + tokenCount + " token, got " + tokenList.size(), tokenCount == tokenList.size());
      }
      
      // compare two lists with the same amount of data 
      if (index % 2 == 1) {
        List      tokenList0 = (List)tokenLists[index - 1];
        Iterator  iter0      = tokenList0.iterator();
        Iterator  iter       = tokenList.iterator();
        int       tokenIndex = 0;
        
        while (iter.hasNext()) {
          Token token0 = (Token)iter0.next();
          Token token  = (Token)iter.next();
          
          assertTrue("Token #" + tokenIndex + "differs:\n" + token0 + "\n" + token, token0.equals(token));
          tokenIndex++;
        }
      }
    }
  }

  
  //---------------------------------------------------------------------------
  // helpers
  //
  
  /**
   * This method returns a {@link java.util.List} of Token.
   */
  private List tokenize(Tokenizer tokenizer) throws Throwable {
    List          list    = new LinkedList();
    //File          file    = File.createTempFile(tokenizer.getSource().getClass().getName(), null);
    //PrintWriter   writer  = new PrintWriter(file.getAbsolutePath());

    try {
      while (tokenizer.hasMoreToken()) {
        Token   token = tokenizer.nextToken();

        // writer.println(token);
        list.add(token);
      }
    } finally {
      // writer.close();
    }
    return list;
  }

  /**
   * Expand some text
   */
  private String expandData(int factor) {
    StringBuffer  expandedData = new StringBuffer(DATA.length() * factor);
    
    for (int ii = 0; ii < factor; ++ii) {
      expandedData.append(DATA);
    }
    return expandedData.toString();
  }

  /**
   * Read the full source
   */
  private void readSource(TokenizerSource source, char[] buffer) throws Throwable {
    long  startTime = System.currentTimeMillis();
    int   chars;
    
    while ((chars = source.read(buffer, 0, buffer.length)) > 0);
    System.out.println(source.getClass().getName() + " needed " + (System.currentTimeMillis() - startTime) + "ms.");
  }


  //---------------------------------------------------------------------------
  // members
  //
  
  // various constants
  private static final String ORIG_SMILEY       = ":-)";
  private static final String FRIGHTENED_SMIKEY = "=8-[";
  private static final String WINKING_SMILEY    = ".-\\";

  // Text data for the tests
  private static final String DATA  =  
      "this is a simple text with a lot of perfectly normal\n"
    + "token. And a few separators (brackets are some, for instance)\n"
    + "as well.     There could\talso be some\ttabs (\"\\t\")\n"
    + "in between. And 'some strings' :-).\n"
    + "And the smileys (;-), =8-[, .-\\ etc.) should be regarded as\n"
    + "'special sequences'.\n\n";
}  

