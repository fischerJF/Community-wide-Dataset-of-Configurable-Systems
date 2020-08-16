/*
 * TestTokenizerCleanup.java: JUnit test for the StandardTokenizer
 *
 * Copyright (C) 2003 Heiko Blau
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
import java.io.StringReader;
import java.text.MessageFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.susebox.jtopas.Flags;
import de.susebox.jtopas.ReaderSource;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Tokenizer;
import de.susebox.jtopas.TokenizerProperties;



//-----------------------------------------------------------------------------
// Class TestTokenizerCleanup
//

/**<p>
 * This test suite checks memory usage, registration end other things related
 * to cleanup operations of a {@link Tokenizer}.
 *</p>
 *
 * @see     Tokenizer
 * @author  Heiko Blau
 */
public class TestTokenizerCleanup   {
  
  //---------------------------------------------------------------------------
  // main method
  //
  
  /**
   * call this method to invoke the tests
   */
//  public static void main(String[] args) {
//    String[]   tests = { TestTokenizerCleanup.class.getName() };
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
//    TestSuite   suite = new TestSuite(TestTokenizerCleanup.class.getName());
//
//    suite.addTest(new TestTokenizerCleanup("testMemoryUsage"));
//    return suite;
//  }
  
  
  //---------------------------------------------------------------------------
  // Constructor
  //
  
  /**
   * Default constructor. Standard input {@link java.lang.System#in} is used
   * to construct the input stream reader.
   */  
//  public TestTokenizerCleanup(String test) {
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
    // empty properties
    _properties = new StandardTokenizerProperties();

    _properties.setParseFlags(Flags.F_KEEP_DATA | Flags.F_RETURN_WHITESPACES);
    
    // create a large source
    String  source =    "This is just a source with lots of data:\n"
                      + "when it is multiplied, see below!\n\n"
                      + "There is >>nothing<< special here, since only the\n"
                      + "memory usage is of interest.\n";
    StringBuffer  buffer = new StringBuffer(1024);
    
    while (buffer.length() < 1024) {
      buffer.append(source);
    }
    _source = buffer.toString();
  }

  
	/**
	 * Tears down the fixture, for example, close a network connection.
	 * This method is called after a test is executed.
	 */
  @After
	public void tearDown() throws Exception {
    _properties = null;
	}
  
  //---------------------------------------------------------------------------
  // test cases
  //
  
  
  /**
   * The method creates a huge amount of tokenizers and dismisses them again.
   * Memory usage should be fairly constant.
   */
   @Test 
 public void testMemoryUsage() throws Throwable {
    long    start             = System.currentTimeMillis();
    Runtime runtime           = Runtime.getRuntime();
    double  totalMemoryStart  = runtime.totalMemory();
    double  freeMemoryStart   = runtime.freeMemory();
    int     currIndex         = 0;
    
    System.out.println( MessageFormat.format("Total/free memory on start (MB): {0}/{1}",
                        new Object[] { new Double(totalMemoryStart / (1024 * 1024)),
                                       new Double(freeMemoryStart / (1024 * 1024)) } )); 

    for (int counter = 0; counter < 1000; ++counter) {
      double totalMemory = runtime.totalMemory();
      double freeMemory  = runtime.freeMemory();

      System.out.println( MessageFormat.format("{2}: Total/free memory before tokenizing (MB): {0}/{1}",
                          new Object[] { new Double(totalMemory / (1024 * 1024)),
                                         new Double(freeMemory / (1024 * 1024)),
                                         new Long(System.currentTimeMillis()) } )); 
      
      // create tokenizer and parse the source
      Tokenizer tokenizer = new StandardTokenizer(_properties);

      try {
        tokenizer.setSource(new ReaderSource(new StringReader(_source)));
        
        while (tokenizer.hasMoreToken()) {
          tokenizer.nextToken();
          tokenizer.currentImage();
        }
        System.out.println( MessageFormat.format("{2}: Total/free memory after tokenizing (MB): {0}/{1}",
                            new Object[] { new Double(totalMemory / (1024 * 1024)),
                                           new Double(freeMemory / (1024 * 1024)),
                                           new Long(System.currentTimeMillis()) } )); 
      } finally {
        // close the tokenizer and see what happens to memory
        tokenizer.close();
        totalMemory = runtime.totalMemory();
        freeMemory  = runtime.freeMemory();
        System.out.println( MessageFormat.format("{2}: Total/free memory after closing (MB): {0}/{1}",
                            new Object[] { new Double(totalMemory / (1024 * 1024)),
                                           new Double(freeMemory / (1024 * 1024)),
                                           new Long(System.currentTimeMillis()) } )); 
        
        // try to close it a few times
        for (int ii = 0; ii < 5; ++ii) {
          tokenizer.close();
        }
                                           
        // dont block the system :-)
        synchronized(this) {
          try {
            wait(10);
          } catch (InterruptedException ex) {}
        }
      }
    }

    long diff = System.currentTimeMillis() - start;
    System.out.println("Finished after " + diff + " milliseconds");
  }
  
  
  //---------------------------------------------------------------------------
  // Members
  //
  protected volatile TokenizerProperties  _properties = null;
  protected volatile String               _source     = null;
}
