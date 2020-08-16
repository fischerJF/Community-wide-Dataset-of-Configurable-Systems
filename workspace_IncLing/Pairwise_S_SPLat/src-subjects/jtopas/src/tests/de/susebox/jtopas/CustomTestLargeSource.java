/*
 * TestLargeSource.java: JUnit test for the StandardTokenizer
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
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import splat.JTopasVariables;
import de.susebox.java.lang.EnvironmentProvider;
import de.susebox.jtopas.CharArraySource;
import de.susebox.jtopas.CharSequenceTokenizerSource;
import de.susebox.jtopas.ReaderSource;
import de.susebox.jtopas.StandardTokenizer;
import de.susebox.jtopas.StandardTokenizerProperties;
import de.susebox.jtopas.Token;
import de.susebox.jtopas.Tokenizer;
import de.susebox.jtopas.TokenizerProperties;
import de.susebox.jtopas.TokenizerProperty;
import de.susebox.jtopas.TokenizerSource;
import de.susebox.jtopas.impl.SequenceStore;


//-----------------------------------------------------------------------------
// Class TestLargeSource
//

/**<p>
 * This test suite generates a huge file with a common mix of comments, special
 * sequences, keywords, separators etc. It is mainly designed for profiling
 * sessions to find the hot spots.
 *</p>
 *
 * @author  Heiko Blau
 */
public class CustomTestLargeSource {
	public static Token thetoken = null;
	public static int executionCount = 0;

	//---------------------------------------------------------------------------
	// properties
	//


	//---------------------------------------------------------------------------
	// main method
	//

	/**
	 * call this method to invoke the tests
	 */
	public static void main(String[] args) {
		splStart___();
		splBody___(args);
		splEnd___();				
	}

	private static void splEnd___() {
		//		System.out.println(splBuffer.toString());
	}

	private static void splStart___() {
		// TODO Auto-generated method stub
		EnvironmentProvider._defaultEnvironment = null;
		EnvironmentProvider._environmentMap     = null;
		EnvironmentProvider._syncMonitor        = new Object();
		SequenceStore.DIRECT_INDEX_COUNT = 256;
		splBuffer = new StringBuffer();
		
		executionCount++;
	}

	private static void splBody___(String[] args)
	{
		// Can we run Java 1.4 test cases?
		// boolean   charSequenceAvailable = true;

		try {
			Class.forName("java.lang.CharSequence");              // Java 1.4 or higher?
			//charSequenceAvailable = true;
		} catch (Throwable throwable) {      
			throwable.printStackTrace();
		}

		//<chpkim
		int splFlag = 0; 
		//		if(BLOCKCOMMENTS___)
		//		{
		//			splFlag |= Flags.F_RETURN_BLOCK_COMMENTS;
		//		}
		//		if(LINECOMMENTS___)
		//		{
		//			splFlag |= Flags.F_RETURN_LINE_COMMENTS;
		//		}
		//		if(COUNTLINES___)
		//		{
		//			splFlag |= Flags.F_COUNT_LINES;
		//		}
		//		if(IMAGEPARTS___)
		//		{
		//			splFlag |= Flags.F_RETURN_IMAGE_PARTS;
		//		}
		//		if(TOKENPOSONLY___)
		//		{
		//			splFlag |= Flags.F_TOKEN_POS_ONLY;
		//		}


		//long types =   (1 << Token.PATTERN) + (1 << Token.KEYWORD) + (1 << Token.SPECIAL_SEQUENCE) + (1 << Token.BLOCK_COMMENT) + (1 << Token.LINE_COMMENT) + (1 << Token.STRING);
		long types = (1 << Token.BLOCK_COMMENT) + (1 << Token.LINE_COMMENT) + (1 << Token.STRING); 
		CustomTestLargeSource ctls = new CustomTestLargeSource(splFlag, types);

		//		if(TESTFEATURE___)
		//		{
		//			System.out.println("blah...");
		//		}

		try {
			ctls.setUp();
			ctls.parseFile();
			ctls.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	//---------------------------------------------------------------------------
	// suite method
	//

	/**
	 * Implementation of the JUnit method <code>suite</code>. This one creates
	 * a large source file java style.
	 *
	 * @return a test suite

  public static Test suite() {
    // Can we run Java 1.4 test cases?
    boolean   charSequenceAvailable;

    try {
      Class.forName("java.lang.CharSequence");              // Java 1.4 or higher?
      charSequenceAvailable = true;
    } catch (Throwable throwable) {
      charSequenceAvailable = false;
    }

    // Construct the test suite
    TestSuite suite = new TestSuite(CustomTestLargeSource.class.getName());
    int[]     flags = { Flags.F_RETURN_WHITESPACES | Flags.F_TOKEN_POS_ONLY | Flags.F_COUNT_LINES,
                        Flags.F_RETURN_WHITESPACES | Flags.F_TOKEN_POS_ONLY,
                        Flags.F_RETURN_BLOCK_COMMENTS | Flags.F_RETURN_LINE_COMMENTS | Flags.F_TOKEN_POS_ONLY,
                        Flags.F_RETURN_BLOCK_COMMENTS | Flags.F_RETURN_LINE_COMMENTS,
                        Flags.F_RETURN_WHITESPACES,
                        Flags.F_RETURN_WHITESPACES | Flags.F_COUNT_LINES,
                        Flags.F_RETURN_WHITESPACES | Flags.F_TOKEN_POS_ONLY | Flags.F_KEEP_DATA,
                        Flags.F_RETURN_WHITESPACES | Flags.F_KEEP_DATA,
                        Flags.F_RETURN_BLOCK_COMMENTS | Flags.F_RETURN_LINE_COMMENTS | Flags.F_KEEP_DATA };

    long[]    types = { (1 << Token.PATTERN) + (1 << Token.KEYWORD) + (1 << Token.SPECIAL_SEQUENCE) + (1 << Token.BLOCK_COMMENT) + (1 << Token.LINE_COMMENT) + (1 << Token.STRING),
                        (1 << Token.KEYWORD) + (1 << Token.SPECIAL_SEQUENCE) + (1 << Token.BLOCK_COMMENT) + (1 << Token.LINE_COMMENT) + (1 << Token.STRING),
                        (1 << Token.SPECIAL_SEQUENCE) + (1 << Token.BLOCK_COMMENT) + (1 << Token.LINE_COMMENT) + (1 << Token.STRING) };

    for (int flagsIndex = 0; flagsIndex < flags.length; ++flagsIndex) {                        
      for (int typesIndex = 0; typesIndex < types.length; ++typesIndex) {                        
        suite.addTest(new CustomTestLargeSource("parseFile", flags[flagsIndex], types[typesIndex]));
        if (charSequenceAvailable) {
          suite.addTest(new CustomTestLargeSource("parseCharSequence", flags[flagsIndex], types[typesIndex]));
        }
      }
    }

    return suite;
  } */


	//---------------------------------------------------------------------------
	// Constructor
	//

	/**
	 * Default constructor.
	 */  
	public CustomTestLargeSource(int flags, long typeMask) {
		_flags    = flags;
		_typeMask = typeMask;
	}


	//---------------------------------------------------------------------------
	// Fixture setup and release
	//

	/**
	 * Sets up the fixture, for example, open a network connection.
	 * This method is called before a test is executed.
	 */
	protected void setUp() throws Exception {
		// create a temporary file that is removed on exit
		OutputStreamWriter  writer;

		_smallFile = File.createTempFile("jtopas" + executionCount, null); 
		_smallFile.deleteOnExit();

		// initializing the tokenizer properties
		_properties = new StandardTokenizerProperties(_flags);

		for (int index = 0; index < _javaProperties.length; ++index) {
			if ((_typeMask & (1 << _javaProperties[index].getType())) != 0) {
				_properties.addProperty(_javaProperties[index]);
			}
		}

		writer = new OutputStreamWriter(new FileOutputStream(_smallFile));
		for (int count = 0; count < JTopasVariables.SMALL_LOOPS; ++count) {
			writer.write(JTopasVariables.INPUT_PIECE);
		}
		writer.close();
	}


	/**
	 * Tears down the fixture, for example, close a network connection.
	 * This method is called after a test is executed.
	 */
	protected void tearDown() throws Exception {}


	//---------------------------------------------------------------------------
	// test cases
	//

	/**
	 * Tokenizing a large source
	 */
	public void parseFile() throws Throwable {
		tokenizeFile(_smallFile, true);
	}

	/**
	 * Tokenizing a large source through a {@link CharSequenceTokenizerSource}.
	 */
	public void parseCharSequence() throws Throwable {
		tokenizeFile( _smallFile, false);
	}


	//---------------------------------------------------------------------------
	// implementation
	//

	/**
	 * Removing a {@link TokenizerProperty} class.
	 */
	private void removeProperties(int propertyType) {
		Iterator iter = _properties.getProperties();

		while (iter.hasNext()) {
			TokenizerProperty prop = (TokenizerProperty)iter.next();

			if (prop.getType() == propertyType) {
				iter.remove();
			}
		}
	}

	/**
	 * Creating and tokenizing the source.
	 */
	private long tokenizeFile(File file, boolean useReaderSource) throws Throwable {
		TokenizerSource   source    = null;
		StandardTokenizer tokenizer = new StandardTokenizer(_properties);

		try {
			if (useReaderSource) {
				source = new ReaderSource(file);
			} else {
				source = new CharArraySource(readFile(file));
			}
			tokenizer.setSource(source);
			return tokenize(tokenizer);
		} finally {
			if (useReaderSource && source != null) {
				((ReaderSource)source).close();
			}
			tokenizer.close();
		}
	}

	/**
	 * Inner method for tokenizing
	 */
	private long tokenize(Tokenizer tokenizer) throws Throwable {

		// tokenizer loop
		while (tokenizer.hasMoreToken()) {
			Token token = tokenizer.nextToken();
			splPrint___("***************");
			splPrint___("Start pos: ");
			splPrint___(String.valueOf(token.getStartPosition()));
			splPrint___("Length: ");
			splPrint___(String.valueOf(token.getLength()));
			splPrint___("Image: ");
			splPrint___(token.getImage());

			if(JTopasVariables.getSINGLETON().isCOUNTLINES___())
			{
				splPrint___("Start line: ");
				splPrint___(String.valueOf(token.getStartLine()));
				splPrint___("Start column: ");
				splPrint___(String.valueOf(token.getStartColumn()));
			}			
			if(JTopasVariables.getSINGLETON().isIMAGEPARTS___())
			{
				splPrint___("Image parts:\n");
				for(int i = 0; i < token.getImageParts().length; i++)
				{
					splPrint___(String.valueOf(token.getImageParts()[i]));								
				} 
			}
		}

		// ready    
		return 0;
	}


	public static void splPrint___(String string) {
		//	splBuffer.append(string + "\n");
		//	System.out.println(string);
	}

	//---------------------------------------------------------------------------
	// utility methods
	//

	/**
	 * Read a file into a character buffer.
	 *
	 * @param file    the file to read
	 * @return the buffer with the read characters
	 */
	private char[] readFile(File file) throws Throwable {
		char[]      cbuf   = new char[(int)file.length()];
		int         chars  = 0;
		FileReader  reader = new FileReader(file);

		try {
			while (chars < cbuf.length) {
				int read = reader.read(cbuf, chars, cbuf.length - chars);

				if (read < 0) {
					throw new IOException("Unexpected EOF after " + chars + " characters. Expected " + cbuf.length + ".");
				}
				chars += read;
			}
		} finally {
			try { reader.close(); } catch (IOException ex) {}
		}
		return cbuf;
	}

	private static final String VERYSMALL_PIECE = 
		"/* perhaps */ a";

	//---------------------------------------------------------------------------
	// class constants
	//

	public static final String WITHOUT_COMMENTS_CODE_PIECE = 
		"package ours.my.subpackage;\n"
		+ "\n"
		+ "import java.util.*;\n"
		+ "import java.io.InputStream;\n"
		+ "import java.io.InputStreamReader;\n"
		+ "import java.io.OutputStream;\n"
		+ "import java.io.OutputStreamWriter;\n"
		+ "import java.net.URL;\n"
		+ "import java.net.URI;\n"
		+ "import javax.swing.*;\n"
		+ "\n"
		+ "\n"
		+ "public class MyTestClass implements Serializable {\n"
		+ "\n"		
		+ "   public static void main(String[] args) {\n"
		+ "     argStore = new ArrayList(32);\n"
		+ "\n"
		+ "     if (args != null && args.length > 0) {\n"
		+ "       if (args[0].equals(\"swingui\")) {\n"
		+ "         new junit.swingui.TestRunner().main(tests);\n"
		+ "       } else if (args[0].equals(\"awtui\")) {\n"
		+ "         new junit.awtui.TestRunner().main(tests);\n"
		+ "       } else {\n"
		+ "         new junit.textui.TestRunner().main(tests);\n"
		+ "       }\n"
		+ "     } else {\n"
		+ "       new junit.textui.TestRunner().main(tests);\n"
		+ "     }\n"
		+ "\n"
		+ "     double doubleValue = 0.0;\n"
		+ "     int    intValue    = 0;\n"
		+ "     String stringValue = null;\n"
		+ "\n"
		+ "     for (int index = 1; args != null && index < args.length; ++index) {\n"
		+ "       if (args[index].charAt(0) == '-') {\n"
		+ "         switch (args[index].charAt(1)) {\n"
		+ "         case 'd':\n"
		+ "           doubleValue = Double.valueOf(args[index].substring(2)).doubleValue();\n"
		+ "           break;\n"
		+ "         case 's':\n"
		+ "           stringValue = args[index].substring(2);\n"
		+ "           break;\n"
		+ "         case 'i':\n"
		+ "           intValue = Integer.valueOf(args[index].substring(2)).intValue();\n"
		+ "           break;\n"
		+ "         default:\n"
		+ "           stringValue = \"\";\n"
		+ "           doubleValue = 0.0;\n"
		+ "           intValue    = 0;\n"
		+ "         }\n"
		+ "\n"
		+ "       } else {\n"
		+ "         if ( ! argStore.contains(args[index])) {\n"
		+ "           argStore.add(args[index]);\n"
		+ "         } else {\n"
		+ "           System.out.println(\"Duplicate element \\\"\" + args[index] + \"\\\".\");\n"
		+ "         }\n"
		+ "       }\n"
		+ "     }\n"
		+ "   }\n"
		+ "\n"
		+ "   private ArrayList argStore = null;\n"
		+ "}\n"
		+ "\n"
		+ "\n";


	public static final String SOMECOMMENTS_PIECE = 
		"package ours.my.subpackage;\n"
		+ "\n"
		+ "import java.util.*;\n"
		+ "import java.io.InputStream;\n"
		+ "import java.io.InputStreamReader;\n"
		+ "import java.io.OutputStream;\n"
		+ "import java.io.OutputStreamWriter;\n"
		+ "import java.net.URL;\n"
		+ "import java.net.URI;\n"
		+ "import javax.swing.*;\n"
		+ "\n"
		+ "\n"
		+ "public class MyTestClass implements Serializable {\n"
		+ "\n"
		+ "   public static void main(String[] args) {\n"
		+ "     argStore = new ArrayList(32);\n"
		+ "\n"
		+ "     if (args != null && args.length > 0) {\n"
		+ "       if (args[0].equals(\"swingui\")) {\n"
		+ "         new junit.swingui.TestRunner().main(tests);\n"
		+ "       } else if (args[0].equals(\"awtui\")) {\n"
		+ "         new junit.awtui.TestRunner().main(tests);\n"
		+ "       } else {\n"
		+ "         new junit.textui.TestRunner().main(tests);\n"
		+ "       }\n"
		+ "     } else {\n"
		+ "       new junit.textui.TestRunner().main(tests);\n"
		+ "     }\n"
		+ "\n"
		+ "     // get all the other command line arguments\n"
		+ "     double doubleValue = 0.0;\n"
		+ "     int    intValue    = 0;\n"
		+ "     String stringValue = null;\n"
		+ "\n"
		+ "     for (int index = 1; args != null && index < args.length; ++index) {\n"
		+ "       if (args[index].charAt(0) == '-') {\n"
		+ "         switch (args[index].charAt(1)) {\n"
		+ "         case 'd':\n"
		+ "           doubleValue = Double.valueOf(args[index].substring(2)).doubleValue();\n"
		+ "           break;\n"
		+ "         case 's':\n"
		+ "           stringValue = args[index].substring(2);\n"
		+ "           break;\n"
		+ "         case 'i':\n"
		+ "           intValue = Integer.valueOf(args[index].substring(2)).intValue();\n"
		+ "           break;\n"
		+ "         default:\n"
		+ "           stringValue = \"\";\n"
		+ "           doubleValue = 0.0;\n"
		+ "           intValue    = 0;\n"
		+ "         }\n"
		+ "\n"
		+ "       } else {\n"
		+ "         // normal arguments\n"
		+ "         if ( ! argStore.contains(args[index])) {\n"
		+ "           argStore.add(args[index]);\n"
		+ "         } else {\n"
		+ "           System.out.println(\"Duplicate element \\\"\" + args[index] + \"\\\".\");\n"
		+ "           /* perhaps better use Environment.getEnvironment(this).out().println() */\n"
		+ "         }\n"
		+ "       }\n"
		+ "     }\n"
		+ "   }\n"
		+ "\n"
		+ "  /**\n"
		+ "   * The argument store.\n"
		+ "   */\n"
		+ "   private ArrayList argStore = null;\n"
		+ "}\n"
		+ "\n"
		+ "\n";

	// piece of code the temporary large file consists of
	public static final String ORIGINAL_CODE_PIECE = 
		"/**\n"
		+ " * A Java-like code example with lots of comments, strings, special\n"
		+ " * sequences etc.\n"
		+ " *<br>\n"
		+ " * Even some HTML tags like in real javadoc comments are present :-)\n"
		+ " * This piece of code is multiplied into a temporary file to get a really\n"
		+ " * huge source file (nothing that should happen in real life).\n"
		+ " */\n"
		+ "\n"
		+ "// package declaration\n"
		+ "package ours.my.subpackage;\n"
		+ "\n"
		+ "// imports\n"
		+ "import java.util.*;\n"
		+ "import java.io.InputStream;\n"
		+ "import java.io.InputStreamReader;\n"
		+ "import java.io.OutputStream;\n"
		+ "import java.io.OutputStreamWriter;\n"
		+ "import java.net.URL;\n"
		+ "import java.net.URI;\n"
		+ "import javax.swing.*;\n"
		+ "\n"
		+ "// class declaration\n"
		+ "\n"
		+ "/**\n"
		+ " * An example Java class probably not even syntactically ok.\n"
		+ " *\n"
		+ " * @see    OtherClass\n"
		+ " * @see    java.io.File\n"
		+ " * @author me\n"
		+ " */\n"
		+ "public class MyTestClass implements Serializable {\n"
		+ "\n"
		+ "  /**\n"
		+ "   * The usual main method.\n"
		+ "   *\n"
		+ "   * @param args the command line options and arguments\n"
		+ "   */\n"
		+ "   public static void main(String[] args) {\n"
		+ "     // create the argument store\n"
		+ "     argStore = new ArrayList(32);\n"
		+ "\n"
		+ "     // wich GUI should be used?\n"
		+ "     if (args != null && args.length > 0) {\n"
		+ "       if (args[0].equals(\"swingui\")) {\n"
		+ "         new junit.swingui.TestRunner().main(tests);\n"
		+ "       } else if (args[0].equals(\"awtui\")) {\n"
		+ "         new junit.awtui.TestRunner().main(tests);\n"
		+ "       } else {\n"
		+ "         new junit.textui.TestRunner().main(tests);\n"
		+ "       }\n"
		+ "     } else {\n"
		+ "       new junit.textui.TestRunner().main(tests);\n"
		+ "     }\n"
		+ "\n"
		+ "     // get all the other command line arguments\n"
		+ "     double doubleValue = 0.0;\n"
		+ "     int    intValue    = 0;\n"
		+ "     String stringValue = null;\n"
		+ "\n"
		+ "     for (int index = 1; args != null && index < args.length; ++index) {\n"
		+ "       if (args[index].charAt(0) == '-') {\n"
		+ "         // options\n"
		+ "         switch (args[index].charAt(1)) {\n"
		+ "         case 'd':\n"
		+ "           doubleValue = Double.valueOf(args[index].substring(2)).doubleValue();\n"
		+ "           break;\n"
		+ "         case 's':\n"
		+ "           stringValue = args[index].substring(2);\n"
		+ "           break;\n"
		+ "         case 'i':\n"
		+ "           intValue = Integer.valueOf(args[index].substring(2)).intValue();\n"
		+ "           break;\n"
		+ "         default:\n"
		+ "           stringValue = \"\";\n"
		+ "           doubleValue = 0.0;\n"
		+ "           intValue    = 0;\n"
		+ "         }\n"
		+ "\n"
		+ "       } else {\n"
		+ "         // normal arguments\n"
		+ "         if ( ! argStore.contains(args[index])) {\n"
		+ "           argStore.add(args[index]);\n"
		+ "         } else {\n"
		+ "           System.out.println(\"Duplicate element \\\"\" + args[index] + \"\\\".\");\n"
		+ "           /* perhaps better use Environment.getEnvironment(this).out().println() */\n"
		+ "         }\n"
		+ "       }\n"
		+ "     }\n"
		+ "   }\n"
		+ "\n"
		+ "  /**\n"
		+ "   * The argument store.\n"
		+ "   */\n"
		+ "   private ArrayList argStore = null;\n"
		+ "}\n"
		+ "\n"
		+ "\n";

	// piece of code the temporary large file consists of
	public static final String BLOCKCOMMENTS_CODE_PIECE = 
		"/**\n"
		+ " * A Java-like code example with lots of comments, strings, special\n"
		+ " * sequences etc.\n"
		+ " *<br>\n"
		+ " * Even some HTML tags like in real javadoc comments are present :-)\n"
		+ " * This piece of code is multiplied into a temporary file to get a really\n"
		+ " * huge source file (nothing that should happen in real life).\n"
		+ " */\n"
		+ "\n"
		+ "/* package declaration */\n"
		+ "package ours.my.subpackage;\n"
		+ "\n"
		+ "/* imports */\n"
		+ "import java.util.*;\n"
		+ "import java.io.InputStream;\n"
		+ "import java.io.InputStreamReader;\n"
		+ "import java.io.OutputStream;\n"
		+ "import java.io.OutputStreamWriter;\n"
		+ "import java.net.URL;\n"
		+ "import java.net.URI;\n"
		+ "import javax.swing.*;\n"
		+ "\n"
		+ "/* class declaration */\n"
		+ "\n"
		+ "/**\n"
		+ " * An example Java class probably not even syntactically ok.\n"
		+ " *\n"
		+ " * @see    OtherClass\n"
		+ " * @see    java.io.File\n"
		+ " * @author me\n"
		+ " */\n"
		+ "public class MyTestClass implements Serializable {\n"
		+ "\n"
		+ "  /**\n"
		+ "   * The usual main method.\n"
		+ "   *\n"
		+ "   * @param args the command line options and arguments\n"
		+ "   */\n"
		+ "   public static void main(String[] args) {\n"
		+ "     /* create the argument store */\n"
		+ "     argStore = new ArrayList(32);\n"
		+ "\n"
		+ "     /* wich GUI should be used? */\n"
		+ "     if (args != null && args.length > 0) {\n"
		+ "       if (args[0].equals(\"swingui\")) {\n"
		+ "         new junit.swingui.TestRunner().main(tests);\n"
		+ "       } else if (args[0].equals(\"awtui\")) {\n"
		+ "         new junit.awtui.TestRunner().main(tests);\n"
		+ "       } else {\n"
		+ "         new junit.textui.TestRunner().main(tests);\n"
		+ "       }\n"
		+ "     } else {\n"
		+ "       new junit.textui.TestRunner().main(tests);\n"
		+ "     }\n"
		+ "\n"
		+ "     /* get all the other command line arguments */\n"
		+ "     double doubleValue = 0.0;\n"
		+ "     int    intValue    = 0;\n"
		+ "     String stringValue = null;\n"
		+ "\n"
		+ "     for (int index = 1; args != null && index < args.length; ++index) {\n"
		+ "       if (args[index].charAt(0) == '-') {\n"
		+ "         /* options */\n"
		+ "         switch (args[index].charAt(1)) {\n"
		+ "         case 'd':\n"
		+ "           doubleValue = Double.valueOf(args[index].substring(2)).doubleValue();\n"
		+ "           break;\n"
		+ "         case 's':\n"
		+ "           stringValue = args[index].substring(2);\n"
		+ "           break;\n"
		+ "         case 'i':\n"
		+ "           intValue = Integer.valueOf(args[index].substring(2)).intValue();\n"
		+ "           break;\n"
		+ "         default:\n"
		+ "           stringValue = \"\";\n"
		+ "           doubleValue = 0.0;\n"
		+ "           intValue    = 0;\n"
		+ "         }\n"
		+ "\n"
		+ "       } else {\n"
		+ "         /* normal arguments */\n"
		+ "         if ( ! argStore.contains(args[index])) {\n"
		+ "           argStore.add(args[index]);\n"
		+ "         } else {\n"
		+ "           System.out.println(\"Duplicate element \\\"\" + args[index] + \"\\\".\");\n"
		+ "           /* perhaps better use Environment.getEnvironment(this).out().println() */\n"
		+ "         }\n"
		+ "       }\n"
		+ "     }\n"
		+ "   }\n"
		+ "\n"
		+ "  /**\n"
		+ "   * The argument store.\n"
		+ "   */\n"
		+ "   private ArrayList argStore = null;\n"
		+ "}\n"
		+ "\n"
		+ "\n";


	// expected token types (without whitespaces)
	private static final int EXPECTED_TOKEN[] = {
		Token.BLOCK_COMMENT,
		Token.LINE_COMMENT,     // "// package declaration\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "package ours.my.subpackage;\n"
		Token.LINE_COMMENT,     // "// imports\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "import java.util.*;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.InputStream;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.InputStreamReader;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.OutputStream;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.OutputStreamWriter;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.net.URL;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.net.URI;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "import javax.swing.*;\n"
		Token.LINE_COMMENT,     // "// class declaration\n"
		Token.BLOCK_COMMENT,
		Token.KEYWORD, Token.KEYWORD, Token.NORMAL, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "public class MyTestClass implementes Serializable {\n"
		Token.BLOCK_COMMENT,
		Token.KEYWORD, Token.KEYWORD, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "   public static void main(String[] args) {\n"
		Token.LINE_COMMENT,     // "// create the argument store\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "     argStore = new ArrayList(32);\n"
		Token.LINE_COMMENT,     // " // wich GUI should be used?\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "     if (args != null && args.length > 0) {\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "       if (args[0].equals(\"swingui\")) {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.swingui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "       } else if (args[0].equals(\"awtui\")) {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.awtui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE,  // "       } else {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.textui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE,   // "       }\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE,  // "     } else {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "       new junit.textui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE,   // "     }\n"
		Token.LINE_COMMENT,     // "     // get all the other command line arguments\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE,   // "     double doubleValue = 0.0;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE,   // "     int    intValue    = 0;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE,   // "     String stringValue = null;\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, //"     for (int index = 1; args != null && index < args.length; ++index) {\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   //  "       if (args[index].charAt(0) == '-') {\n"
		Token.LINE_COMMENT,     // "         // options\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "         switch (args[index].charAt(1)) {\n"
		Token.KEYWORD, Token.STRING, Token.SEPARATOR, // "         case 'd':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "           doubleValue = Double.valueOf(args[index].substring(2)).doubleValue();\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.KEYWORD, Token.STRING, Token.SEPARATOR, // "         case 's':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "           stringValue = args[index].substring(2);\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.KEYWORD, Token.STRING, Token.SEPARATOR, // "         case 'i':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "           intValue = Integer.valueOf(args[index].substring(2)).intValue();\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.KEYWORD, Token.SEPARATOR, // "         default:\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE,   // "           stringValue = \"\";\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE,  // "           doubleValue = 0.0;\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.PATTERN, Token.SPECIAL_SEQUENCE,  // "           intValue    = 0;\n"
		Token.SPECIAL_SEQUENCE, // "         }\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, // "       } else {\n"
		Token.LINE_COMMENT,     // "         // normal arguments\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         if ( ! argStore.contains(args[index])) {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "           argStore.add(args[index]);\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, // "         } else {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "           System.out.println(\"Duplicate element \\\" + args[index] + \"\\\".\");\n"
		Token.BLOCK_COMMENT,      // "           /* perhaps better use Environment.getEnvironment(this).out().println() */\n"
		Token.SPECIAL_SEQUENCE,   // "         }\n"
		Token.SPECIAL_SEQUENCE,   // "       }\n"
		Token.SPECIAL_SEQUENCE,   // "     }\n"
		Token.SPECIAL_SEQUENCE,   // "   }\n"
		Token.BLOCK_COMMENT, 
		Token.KEYWORD, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, // "   private ArrayList argStore = null;\n"
		Token.SPECIAL_SEQUENCE    // "}\n"
	};

	// expected token types (without whitespaces) when no pattern matching is performed
	private static final int EXPECTED_TOKEN_WITHOUT_PATTERN[] = {
		Token.BLOCK_COMMENT,
		Token.LINE_COMMENT,     // "// package declaration\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "package ours.my.subpackage;\n"
		Token.LINE_COMMENT,     // "// imports\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "import java.util.*;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.InputStream;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.InputStreamReader;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.OutputStream;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.OutputStreamWriter;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.net.URL;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.net.URI;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "import javax.swing.*;\n"
		Token.LINE_COMMENT,     // "// class declaration\n"
		Token.BLOCK_COMMENT,
		Token.KEYWORD, Token.KEYWORD, Token.NORMAL, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "public class MyTestClass implementes Serializable {\n"
		Token.BLOCK_COMMENT,
		Token.KEYWORD, Token.KEYWORD, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "   public static void main(String[] args) {\n"
		Token.LINE_COMMENT,     // "// create the argument store\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "     argStore = new ArrayList(32);\n"
		Token.LINE_COMMENT,     // " // wich GUI should be used?\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "     if (args != null && args.length > 0) {\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "       if (args[0].equals(\"swingui\")) {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.swingui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "       } else if (args[0].equals(\"awtui\")) {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.awtui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE,  // "       } else {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.textui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE,   // "       }\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE,  // "     } else {\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "       new junit.textui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE,   // "     }\n"
		Token.LINE_COMMENT,     // "     // get all the other command line arguments\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,   // "     double doubleValue = 0.0;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,   // "     int    intValue    = 0;\n"
		Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE,   // "     String stringValue = null;\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, //"     for (int index = 1; args != null && index < args.length; ++index) {\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   //  "       if (args[index].charAt(0) == '-') {\n"
		Token.LINE_COMMENT,     // "         // options\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "         switch (args[index].charAt(1)) {\n"
		Token.KEYWORD, Token.STRING, Token.SEPARATOR, // "         case 'd':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "           doubleValue = Double.valueOf(args[index].substring(2)).doubleValue();\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.KEYWORD, Token.STRING, Token.SEPARATOR, // "         case 's':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "           stringValue = args[index].substring(2);\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.KEYWORD, Token.STRING, Token.SEPARATOR, // "         case 'i':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "           intValue = Integer.valueOf(args[index].substring(2)).intValue();\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.KEYWORD, Token.SEPARATOR, // "         default:\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE,   // "           stringValue = \"\";\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "           doubleValue = 0.0;\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "           intValue    = 0;\n"
		Token.SPECIAL_SEQUENCE, // "         }\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, // "       } else {\n"
		Token.LINE_COMMENT,     // "         // normal arguments\n"
		Token.KEYWORD, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         if ( ! argStore.contains(args[index])) {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "           argStore.add(args[index]);\n"
		Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, // "         } else {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "           System.out.println(\"Duplicate element \\\" + args[index] + \"\\\".\");\n"
		Token.BLOCK_COMMENT,      // "           /* perhaps better use Environment.getEnvironment(this).out().println() */\n"
		Token.SPECIAL_SEQUENCE,   // "         }\n"
		Token.SPECIAL_SEQUENCE,   // "       }\n"
		Token.SPECIAL_SEQUENCE,   // "     }\n"
		Token.SPECIAL_SEQUENCE,   // "   }\n"
		Token.BLOCK_COMMENT, 
		Token.KEYWORD, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.KEYWORD, Token.SPECIAL_SEQUENCE, // "   private ArrayList argStore = null;\n"
		Token.SPECIAL_SEQUENCE    // "}\n"
	};

	// expected token types (without whitespaces) when no pattern matching is performed
	private static final int EXPECTED_TOKEN_WITHOUT_PATTERN_AND_KEYWORDS[] = {
		Token.BLOCK_COMMENT,
		Token.LINE_COMMENT,     // "// package declaration\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "package ours.my.subpackage;\n"
		Token.LINE_COMMENT,     // "// imports\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "import java.util.*;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.InputStream;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.InputStreamReader;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.OutputStream;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.io.OutputStreamWriter;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.net.URL;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "import java.net.URI;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "import javax.swing.*;\n"
		Token.LINE_COMMENT,     // "// class declaration\n"
		Token.BLOCK_COMMENT,
		Token.NORMAL, Token.NORMAL, Token.NORMAL, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "public class MyTestClass implementes Serializable {\n"
		Token.BLOCK_COMMENT,
		Token.NORMAL, Token.NORMAL, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "   public static void main(String[] args) {\n"
		Token.LINE_COMMENT,     // "// create the argument store\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "     argStore = new ArrayList(32);\n"
		Token.LINE_COMMENT,     // " // wich GUI should be used?\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "     if (args != null && args.length > 0) {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "       if (args[0].equals(\"swingui\")) {\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.swingui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "       } else if (args[0].equals(\"awtui\")) {\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.awtui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "       } else {\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         new junit.textui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE,   // "       }\n"
		Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "     } else {\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "       new junit.textui.TestRunner().main(tests);\n"
		Token.SPECIAL_SEQUENCE,   // "     }\n"
		Token.LINE_COMMENT,     // "     // get all the other command line arguments\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,   // "     double doubleValue = 0.0;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,   // "     int    intValue    = 0;\n"
		Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,   // "     String stringValue = null;\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, //"     for (int index = 1; args != null && index < args.length; ++index) {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   //  "       if (args[index].charAt(0) == '-') {\n"
		Token.LINE_COMMENT,     // "         // options\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "         switch (args[index].charAt(1)) {\n"
		Token.NORMAL, Token.STRING, Token.SEPARATOR, // "         case 'd':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "           doubleValue = Double.valueOf(args[index].substring(2)).doubleValue();\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.NORMAL, Token.STRING, Token.SEPARATOR, // "         case 's':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "           stringValue = args[index].substring(2);\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.NORMAL, Token.STRING, Token.SEPARATOR, // "         case 'i':\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, // "           intValue = Integer.valueOf(args[index].substring(2)).intValue();\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE,        // "           break;\n"
		Token.NORMAL, Token.SEPARATOR, // "         default:\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE,   // "           stringValue = \"\";\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "           doubleValue = 0.0;\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE,  // "           intValue    = 0;\n"
		Token.SPECIAL_SEQUENCE, // "         }\n"
		Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, // "       } else {\n"
		Token.LINE_COMMENT,     // "         // normal arguments\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,  // "         if ( ! argStore.contains(args[index])) {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "           argStore.add(args[index]);\n"
		Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, // "         } else {\n"
		Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE, Token.STRING, Token.SPECIAL_SEQUENCE, Token.SPECIAL_SEQUENCE,   // "           System.out.println(\"Duplicate element \\\" + args[index] + \"\\\".\");\n"
		Token.BLOCK_COMMENT,      // "           /* perhaps better use Environment.getEnvironment(this).out().println() */\n"
		Token.SPECIAL_SEQUENCE,   // "         }\n"
		Token.SPECIAL_SEQUENCE,   // "       }\n"
		Token.SPECIAL_SEQUENCE,   // "     }\n"
		Token.SPECIAL_SEQUENCE,   // "   }\n"
		Token.BLOCK_COMMENT, 
		Token.NORMAL, Token.NORMAL, Token.NORMAL, Token.SPECIAL_SEQUENCE, Token.NORMAL, Token.SPECIAL_SEQUENCE, // "   private ArrayList argStore = null;\n"
		Token.SPECIAL_SEQUENCE    // "}\n"
	};

	// Tokenizer properties
	private static final Object JAVADOC_COMPANION         = new Object();
	private static final Object BLOCK_COMMENT_COMPANION   = new Object();
	private static final Object LINE_COMMENT_COMPANION    = new Object();
	private static final Object STRING_COMPANION          = new Object();
	private static final Object CHAR_COMPANION            = new Object();
	private static final Object BRACE_CLOSE_COMPANION     = new Object();
	private static final Object COLON_COMPANION           = new Object();
	private static final Object SEMICOLON_COMPANION       = new Object();
	private static final Object STAR_COMPANION            = new Object();

	// Properties
	static final TokenizerProperty[] _javaProperties = {
		new TokenizerProperty(Token.BLOCK_COMMENT, new String[] { "/**", "*/" },      JAVADOC_COMPANION),
		new TokenizerProperty(Token.BLOCK_COMMENT, new String[] { "/*", "*/" },       BLOCK_COMMENT_COMPANION),
		new TokenizerProperty(Token.LINE_COMMENT,  new String[] { "//" },             LINE_COMMENT_COMPANION),
		new TokenizerProperty(Token.STRING,        new String[] { "\"", "\"", "\\" }, STRING_COMPANION),
		new TokenizerProperty(Token.STRING,        new String[] { "'", "'", "\\" },   CHAR_COMPANION),
		new TokenizerProperty(Token.PATTERN,       new String[] { "[+\\-]?[0-9]+\\.?[0-9]*" } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "package"       } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "abstract"      } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "public"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "protected"     } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "private"       } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "class"         } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "final"         } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "static"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "interface"     } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "extends"       } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "implements"    } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "synchronized"  } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "null"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "this"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "super"         } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "new"           } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "void"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "byte"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "char"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "short"         } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "int"           } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "long"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "double"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "float"         } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "String"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "throws"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "static"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "import"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "package"       } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "if"            } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "else"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "for"           } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "while"         } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "switch"        } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "case"          } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "break"         } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "default"       } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "continue"      } ),
		new TokenizerProperty(Token.KEYWORD, new String[] { "goto"          } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "."   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ";"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ","   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "="   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "=="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "!="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ">"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "<"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ">="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "<="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "+="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "-="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "*="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "/="  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ">>=" } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "<<=" } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "+"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "-"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "*"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "/"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "++"  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "--"  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ">>"  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "<<"  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ">>>" } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "&"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "|"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "^"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "&&"  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "||"  } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "!"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "{"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "}"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "("   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { ")"   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "["   } ),
		new TokenizerProperty(Token.SPECIAL_SEQUENCE, new String[] { "]"   } )
	};

	//---------------------------------------------------------------------------
	// Members
	//
	private TokenizerProperties _properties = null;
	private int                 _flags      = 0;
	private long                _typeMask   = 0;

	//---------------------------------------------------------------------------
	// class members
	//
	private static File _smallFile = null;

	public static StringBuffer splBuffer;

	public static final boolean WHITESPACES = false;	
	public static final boolean KEEPDATA = false;	
}

