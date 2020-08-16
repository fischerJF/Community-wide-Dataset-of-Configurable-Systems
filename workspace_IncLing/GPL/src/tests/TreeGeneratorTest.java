package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
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

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class TreeGeneratorTest {

	private TreeGenerator tg;
	@Before
	public void setUp() {
		tg=new TreeGenerator();
	}

	@Test
	public void processNode_depthIsNotAcceptedTest() {
		TreeGenerator tg=new TreeGenerator();
		tg.processNode(0, 5);
		assertEquals(tg.edgeCount, 0);
		assertEquals(tg.nodeCount, 0);
		assertEquals(tg.str, "");
	}
	
	@Test
	public void processNodeTest() {
		tg.processNode(0, 3);
		assertEquals(tg.edgeCount,4);
		assertEquals(tg.nodeCount,4);
		assertTrue(tg.str.contains("0 1"));
		assertTrue(tg.str.contains("0 2"));
		assertTrue(tg.str.contains("0 3"));
		assertTrue(tg.str.contains("0 4"));
	}
	
	@After
	public void reset() {
		TreeGenerator.nodeCount = 0;
		TreeGenerator.edgeCount = 0;
		TreeGenerator.str = "";
	}

}
