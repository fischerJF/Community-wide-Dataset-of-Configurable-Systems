package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import smashed_varexj.Main;
import smashed_varexj.TreeGenerator;
import smashed_varexj.Vertex;
import smashed_varexj.Graph;
import smashed_varexj.JavaUtility;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class JavaUtilityTest {

	private JavaUtility ju;
	@Before
	public void setUp() {
		ju=new JavaUtility();
	}

	@Test
	public void processNode_depthIsNotAcceptedTest() throws IOException {
		String fileName="files/javaUtilityTest.txt";
		ju.writeToFile(fileName, "test\nJavaUtilityTest");
		
		assertEquals(getDataFile(fileName).get(0), "test");
		assertEquals(getDataFile(fileName).get(1), "JavaUtilityTest");
	}
	
	@Test
	public void writeToFile_FileTest() throws IOException {
		String fileName="files/javaUtilityTest.txt";
		File file= new File(fileName);
		ju.writeToFile(file,"test");
		assertEquals(getDataFile(fileName).get(0), "test");
	}
	@Test
	public void getFileContentsTest() throws IOException {
		String fileName="files/javaUtilityTest2.txt";
		String test=ju.getFileContents(fileName);
		System.err.println(test);
		assertEquals(test, "test\r\nJavaUtilityTest");
	}
	
	
	@SuppressWarnings("resource")
	public List<String> getDataFile(String file) {

		List<String> data = new ArrayList<String>();
		BufferedReader br;

		try {
			br = new BufferedReader(new FileReader(file));

			try {

				while (br.ready()) {
					String line = br.readLine();
					data.add(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return data;
	}
}
