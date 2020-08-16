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
import smashed_varexj.NetworkGenerator;
import smashed_varexj.TreeGenerator;
import smashed_varexj.Vertex;
import smashed_varexj.Graph;
import smashed_varexj.JavaUtility;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class NetworkGeneratorTest {

	private NetworkGenerator ng;
	
	@Before
	public void setUp() {
		ng=new NetworkGenerator();
	}

	@Test
	public void getNetworkTest() {
		Object[] obj=ng.getNetwork(1,2);
		assertTrue(obj[0].toString().contains("1 2"));
		assertTrue(obj[0].toString().contains("2 4"));
		assertTrue(obj[0].toString().contains("1 3"));
		assertTrue(obj[0].toString().contains("3 4"));

		assertTrue(obj[1].toString().contains("4"));
		assertTrue(obj[2].toString().contains("4"));
	}
}
