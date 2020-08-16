package testset;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import UnionFind.In;
import UnionFind.Stopwatch;
import specifications.Configuration;

public class InTest {

	In in;

	@Before
	public void setUp() {
		// Configuration.tests = true;
		if (Configuration.tests)
			in = new In();

	}

	@Test
	public void variablesTest() throws IllegalArgumentException, IllegalAccessException {
		if (Configuration.tests) {
			String charsetName = (String) MemberModifier.field(In.class, "charsetName").get(in);
			assertEquals(charsetName, "ISO-8859-1");
			Locale locale = (Locale) MemberModifier.field(In.class, "usLocale").get(in);
			assertEquals(locale.getCountry(), "US");
			assertEquals(locale.getLanguage(), "en");
		}
	}

	@Test
	public void InSocketTest() throws IllegalArgumentException, IllegalAccessException {
		if (Configuration.tests) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setErr(ps);

			in = new In(new Socket());
			String charsetName = (String) MemberModifier.field(In.class, "scanner").get(in);
			assertNull(charsetName);
			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());

			assertTrue(output.toString().contains("Could not open "));
		}
	}

	@Test
	public void InURL() throws IllegalArgumentException, IllegalAccessException, MalformedURLException {
		if (Configuration.tests) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setErr(ps);

			URL u = new URL("http://introcs");
			in = new In(u);
			String charsetName = (String) MemberModifier.field(In.class, "scanner").get(in);
			assertNull(charsetName);
			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());
			assertTrue(output.toString().contains("Could not open "));
		}
	}

	@Test
	public void InURL_2() throws IllegalArgumentException, IllegalAccessException, MalformedURLException {
		if (Configuration.tests) {
			URL url = new URL("http://introcs.cs.princeton.edu/stdlib/InTest.txt");
			in = new In(url);
			assertTrue(in.readAll().contains("The document has moved"));
		}
	}

	@Test
	public void InString() throws IllegalArgumentException, IllegalAccessException {
		if (Configuration.tests) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setErr(ps);

			in = new In("test");
			String charsetName = (String) MemberModifier.field(In.class, "scanner").get(in);
			assertNull(charsetName);
			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());
			assertTrue(output.toString().contains("Could not open "));
		}
	}

	@Test
	public void InFile() throws IllegalArgumentException, IllegalAccessException {
		if (Configuration.tests) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setErr(ps);

			File file = new File("test");
			in = new In(file);
			String charsetName = (String) MemberModifier.field(In.class, "scanner").get(in);
			assertNull(charsetName);
			String output = new String(stream.toByteArray());
			assertTrue(output.toString().contains("Could not open "));
		}
	}

	@Test
	public void existsTest() {
		if (Configuration.tests)
			assertTrue(in.exists());
	}

	@Test
	public void isEmptyTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");

			assertFalse(in.isEmpty());
		}
	}

	@Test
	public void hasNextLineTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");

			assertTrue(in.hasNextLine());
		}
	}

	@Test
	public void readStringTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");
			assertTrue(in.readString().contains("10"));
		}
	}

	@Test
	public void readLineTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");
			assertTrue(in.readLine().contains("10"));
		}
	}

	@Test
	public void readAllTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");
			assertTrue(in.readAll().contains("4 3"));
			in = new In("TestData/empty.txt");
			assertNull(in.readAll());
		}
	}

	@Test
	public void readDoubleTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");
			double d = 10.0;
			assertTrue(in.readDouble() == d);
		}
	}

	@Test
	public void readLongTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");
			long d = 10;
			assertTrue(in.readLong() == d);
		}
	}

	@Test
	public void readByteTest() {
		if (Configuration.tests) {
			In in = new In("TestData/tinyUF.txt");
			byte d = 10;
			assertTrue(in.readByte() == d);
		}
	}

	@Test
	public void readBooleanTest() {
		if (Configuration.tests) {
			In in = new In("TestData/boolean.txt");
			assertTrue(in.readBoolean());
			in.hasNextLine();
			assertFalse(in.readBoolean());
			in.hasNextLine();
			assertTrue(in.readBoolean());
			in.hasNextLine();
			assertFalse(in.readBoolean());
		}
	}

	@Test
	public void readIntsTest() {
		if (Configuration.tests) {
			In in = new In();
			int[] v = in.readInts("TestData/tinyUF.txt");
			assertTrue(v.length == 23);
		}
	}

	@Test
	public void readDoublesTest() {
		if (Configuration.tests) {
			In in = new In();
			double[] v = in.readDoubles("TestData/tinyUF.txt");
			System.out.println(v.length);
			assertTrue(v.length == 23);
		}
	}

	@Test
	public void readStringsTest() {
		if (Configuration.tests) {
			In in = new In();
			String[] v = in.readStrings("TestData/tinyUF.txt");
			System.out.println(v.length);
			assertTrue(v.length == 23);
		}
	}

	@Test
	public void mainTest() {
		if (Configuration.tests) {
			In in;
			String urlName = "http://introcs.cs.princeton.edu/stdlib/InTest.txt";

			// read from a URL
			System.out.println("readAll() from URL " + urlName);
			System.out.println("---------------------------------------------------------------------------");
			try {
				in = new In(urlName);
				System.out.println(in.readAll());
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();

			// read one line at a time from URL
			System.out.println("readLine() from URL " + urlName);
			System.out.println("---------------------------------------------------------------------------");
			try {
				in = new In(urlName);
				while (!in.isEmpty()) {
					String s = in.readLine();
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();

			// read one string at a time from URL
			System.out.println("readString() from URL " + urlName);
			System.out.println("---------------------------------------------------------------------------");
			try {
				in = new In(urlName);
				while (!in.isEmpty()) {
					String s = in.readString();
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();

			// read one line at a time from file in current directory
			System.out.println("readLine() from current directory");
			System.out.println("---------------------------------------------------------------------------");
			try {
				in = new In("./InTest.txt");
				while (!in.isEmpty()) {
					String s = in.readLine();
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();

			// read one line at a time from file using relative path
			System.out.println("readLine() from relative path");
			System.out.println("---------------------------------------------------------------------------");
			try {
				in = new In("../stdlib/InTest.txt");
				while (!in.isEmpty()) {
					String s = in.readLine();
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();

			// read one char at a time
			System.out.println("readChar() from file");
			System.out.println("---------------------------------------------------------------------------");
			try {
				in = new In("InTest.txt");
				while (!in.isEmpty()) {
					char c = in.readChar();
					System.out.print(c);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();
			System.out.println();

			// read one line at a time from absolute OS X / Linux path
			System.out.println("readLine() from absolute OS X / Linux path");
			System.out.println("---------------------------------------------------------------------------");
			in = new In("/n/fs/csweb/introcs/stdlib/InTest.txt");
			try {
				while (!in.isEmpty()) {
					String s = in.readLine();
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();

			// read one line at a time from absolute Windows path
			System.out.println("readLine() from absolute Windows path");
			System.out.println("---------------------------------------------------------------------------");
			try {
				in = new In("G:\\www\\introcs\\stdlib\\InTest.txt");
				while (!in.isEmpty()) {
					String s = in.readLine();
					System.out.println(s);
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println();
		}
	}

}
