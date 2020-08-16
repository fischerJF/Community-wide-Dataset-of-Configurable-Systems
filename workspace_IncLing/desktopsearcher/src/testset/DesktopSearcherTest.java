package testset;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

public abstract class DesktopSearcherTest {

//	@Rule
//	public TestName testName = new TestName();

//	@Rule
//	public Timeout globalTimeout = new Timeout(10000);

	protected void configure() {
		// DesktopSearcherVariables.getSINGLETON().setBASE(true);
		
		// [1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0]
		// DesktopSearcherVariables.getSINGLETON().setHTML(true);
		// DesktopSearcherVariables.getSINGLETON().setTXT(true);
		// DesktopSearcherVariables.getSINGLETON().setLATEX(false);
		// DesktopSearcherVariables.getSINGLETON().setUSER_INTERFACE(true);
		// DesktopSearcherVariables.getSINGLETON().setCOMMAND_LINE(false);
		// DesktopSearcherVariables.getSINGLETON().setGUI(true);
		// DesktopSearcherVariables.getSINGLETON().setGUI_PREFERENCES(true);
		// DesktopSearcherVariables.getSINGLETON().setQUERY_HISTORY(false);
		// DesktopSearcherVariables.getSINGLETON().setINDEX_HISTORY(false);
		// DesktopSearcherVariables.getSINGLETON().setSINGLE_DIRECTORY(false);
		// DesktopSearcherVariables.getSINGLETON().setMULTI_DIRECTORY(true);
		// DesktopSearcherVariables.getSINGLETON().setNORMAL_VIEW(false);
		// DesktopSearcherVariables.getSINGLETON().setTREE_VIEW(true);
		// DesktopSearcherVariables.getSINGLETON().setWINDOWS(true);
		// DesktopSearcherVariables.getSINGLETON().setLINUX(false);

	}

	@After
	public void teardown() {
		// System.out.println(DesktopSearcherVariables.getSINGLETON().toString());
	}

	public static String homeDir;
	static {
		try {
			homeDir = (new File(".")).getCanonicalPath();
		} catch (IOException e) {
			e.printStackTrace();
		}
	};

	static PrintStream out;

	public void writeOutput(String OUTPUT_PATH) throws FileNotFoundException {
		out = new PrintStream(new FileOutputStream(OUTPUT_PATH));
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
	}

	public List<String> getOutput(String OUTPUT_PATH) throws IOException {
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

	public boolean deleteDirectory(File directory) {
		if (directory.exists()) {
			File[] files = directory.listFiles();
			if (null != files) {
				for (int i = 0; i < files.length; i++) {
					if (files[i].isDirectory()) {
						deleteDirectory(files[i]);
					} else {
						files[i].delete();
					}
				}
			}
		}
		return (directory.delete());
	}

	public int getNumberMatchingDocs(String OUTPUT_PATH, String searchString)
			throws IOException {
		List<String> output = getOutput(OUTPUT_PATH);
		int numberOfMatchingDocuments = 0;
		for (String line : output) {
			if (line.contains("Searching for '" + searchString + "'...")) {
				numberOfMatchingDocuments = Integer
						.parseInt(line.split(" ")[4]);
			}
		}
		return numberOfMatchingDocuments;
	}

	public int getNumberFilesIndexed(String OUTPUT_PATH) throws IOException {
		List<String> output = getOutput(OUTPUT_PATH);
		int numberOfFilesIndexed = 0;
		for (String line : output) {
			if (line.contains("documents have been indexed.")) {
				numberOfFilesIndexed = Integer.parseInt(line.split(" ")[0]);
			}
		}
		return numberOfFilesIndexed;
	}

}