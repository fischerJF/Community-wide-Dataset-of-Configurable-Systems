package testset;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import desktopsearcher.Commandline;
import desktopsearcher.MrPinkMain;
import specifications.Configuration;

public class TestCommandLineExample_Mateus extends DesktopSearcherTest{

	static String homeDir;
	static {
		try {
			homeDir = (new File(".")).getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};

	PrintStream out;
	static final String OUTPUT_PATH = homeDir + "out.txt";
	static final String VALID_INDEX_COMMAND = "index " + homeDir + "/files";

	@Before
	public void setup() throws IOException {
		configure();
		writeOutput();
	}

	@Test
	public void testIndexNoFile() throws IOException {
//		DesktopSearcherVariables.getSINGLETON().setCOMMAND_LINE(true);
		specifications.Configuration.COMMAND_LINE=true;
		if(specifications.Configuration.COMMAND_LINE) {
		MrPinkMain mpm = new MrPinkMain();
		Commandline cmd = new Commandline(mpm);

		assertNotSame(-1, cmd.parseCommand(VALID_INDEX_COMMAND));
//		assertTrue(getOutput().contains("0 documents have been indexed."));
		}
	}

	@Test
	public void testIndexTxt() throws IOException {
//		DesktopSearcherVariables.getSINGLETON().setCOMMAND_LINE(true);
//		DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//		// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
//		DesktopSearcherVariables.getSINGLETON().setTXT(true);

		
		if(Configuration.COMMAND_LINE &&
				Configuration.USER_INTERFACE &&
				Configuration.LINUX &&
				Configuration.TXT) {
		MrPinkMain mpm = new MrPinkMain();
		Commandline cmd = new Commandline(mpm);

		assertNotSame(-1, cmd.parseCommand("i files"));
		assertTrue(getOutput().contains(" documents have been indexed."));

		assertNotSame(-1, cmd.parseCommand("s org"));
		List<String> out = getOutput();

		List<String> expected = Arrays.asList("-> title file3 ",
				"-> title file4 ", "-> title file5 ", "-> title file1 ");

		// List<String> expected = Arrays.asList(
		// "-> doc #4 (Tue Feb 18 00:13:22 BRT 2014)",
		// "-> title file3 ",
		// "-> doc #3 (Tue Feb 18 00:14:52 BRT 2014)",
		// "-> title file4 ",
		// "-> doc #1 (Tue Feb 18 00:13:50 BRT 2014)",
		// "-> title file5 ",
		// "-> doc #2 (Tue Feb 18 00:11:24 BRT 2014)",
		// "-> title file1 ");

		checkOutput(out, expected);
     }
	}

	@Test
	public void testIndexHtml() throws IOException {
//		DesktopSearcherVariables.getSINGLETON().setCOMMAND_LINE(true);
//		DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//		// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
//		DesktopSearcherVariables.getSINGLETON().setHTML(true);
		Configuration.USER_INTERFACE =true;
		Configuration.LINUX =true;
		Configuration.HTML =true;
Configuration.COMMAND_LINE=true;
		if(Configuration.USER_INTERFACE &&
		Configuration.LINUX &&
		Configuration.HTML &&
Configuration.COMMAND_LINE) {

		MrPinkMain mpm = new MrPinkMain();
		Commandline cmd = new Commandline(mpm);

		assertNotSame(-1, cmd.parseCommand("i files"));
		assertTrue(getOutput().contains("3 documents have been indexed."));

		assertNotSame(-1, cmd.parseCommand("s feature"));
		List<String> out = getOutput();

		List<String> expected = Arrays.asList("-> doc #0", "-> title",
				"-> path " + homeDir + "/files/file1.html", "-> doc #1",
				"-> title", "-> path " + homeDir + "/files/file2.html");

		// List<String> expected = Arrays.asList(
		// "-> doc #1 (Tue Feb 18 12:00:44 BRT 2014)",
		// "-> title",
		// "-> doc #0 (Tue Feb 18 12:01:40 BRT 2014)",
		// "-> title");

		//checkOutput(out, expected);
		}
	}

	public void checkOutput(List<String> out, List<String> expected) {
		for (String s : expected) {
			boolean f = false;
			for (String e : out) {
				f = e.contains(s);

				if (f) {
					break;
				}
			}
			if (!f)
				assertTrue(s, f);
		}
	}

	@Test
	public void testIndexLatex() throws IOException {
//		DesktopSearcherVariables.getSINGLETON().setCOMMAND_LINE(true);
//		DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
//		// DesktopSearcherVariables.getSINGLETON().setLINUX(true);
//		DesktopSearcherVariables.getSINGLETON().setLATEX(true);
		Configuration.COMMAND_LINE=true;
		   Configuration.USER_INTERFACE=true;
		   Configuration.LINUX=true;
		   Configuration.LATEX=true;
		if(Configuration.COMMAND_LINE &&
		   Configuration.USER_INTERFACE &&
		   Configuration.LINUX &&
		   Configuration.LATEX) {
		MrPinkMain mpm = new MrPinkMain();
		Commandline cmd = new Commandline(mpm);

		assertNotSame(-1, cmd.parseCommand("i files"));
//		assertTrue(getOutput().contains("2 documents have been indexed."));

		assertNotSame(-1, cmd.parseCommand("s SPL"));
		List<String> out = getOutput();

		List<String> expected = Arrays.asList(
		// "-> doc #0 (Tue Feb 18 11:51:28 BRT 2014)",
				"-> title Unbenanntes Dokument");

		checkOutput(out, expected);
		}
	}

	@After
	public void teardown() {
//		DesktopSearcherVariables.getSINGLETON().restore();
		 deleteDirectory(new File(homeDir + "/index"));
	}

	private void writeOutput() throws FileNotFoundException {
		out = new PrintStream(new FileOutputStream(OUTPUT_PATH));
		System.setOut(out);
	}

	private List<String> getOutput() throws IOException {
		List<String> content = new ArrayList<String>();
		FileReader fr = new FileReader(OUTPUT_PATH);
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while (line != null) {
			content.add(line);
			line = br.readLine();
		}
		br.close();
		fr.close();

		return content;
	}


}
