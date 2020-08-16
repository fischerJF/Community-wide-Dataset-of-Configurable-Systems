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
import smashed_varexj.CycleWorkSpace;
import smashed_varexj.Graph;
import smashed_varexj.JavaUtility;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class CycleWorkSpaceTest {

	private CycleWorkSpace cws;
	
	@Before
	public void setUp() {
		cws=new CycleWorkSpace();
	}

	@Test
	public void CycleWorkSpaceTest() {
//		Configuration.CYCLE=true;
		if (Configuration.CYCLE) {
			cws=new CycleWorkSpace();
			assertEquals(cws.AnyCycles,false);
			assertEquals(cws.counter,0);
		}
		else {
			assertEquals(cws.AnyCycles,false);
			assertEquals(cws.counter,0);
		}
	}
	@Test
	public void init_vertex() {
		if (Configuration.CYCLE) {
			Vertex v1 = new Vertex();
			v1.name = "v1";
			cws.init_vertex(v1);
			assertEquals(v1.VertexCycle,Integer.MAX_VALUE);
			assertEquals(v1.VertexColor,0);
			
		}
	}
	@Test
	public void preVisitActionTest() {
//		Configuration.CYCLE=true;
		if (Configuration.CYCLE) {
			cws=new CycleWorkSpace();

			Vertex v1 = new Vertex();
			v1.name = "v1";
			v1.visited=false;
			cws.preVisitAction(v1);
			System.out.println(v1.VertexCycle);
			assertEquals(v1.VertexCycle,0);
			assertEquals(v1.VertexColor,1);

		}
	}
	@Test
	public void postVisitActionTest() {
		//Configuration.CYCLE=true;
		if (Configuration.CYCLE) {
			Vertex v1 = new Vertex();
			v1.name = "v1";
			cws.counter=1;
			cws.postVisitAction(v1);
			assertEquals(v1.VertexColor,2);
			assertEquals(cws.counter,0);

		}
	}
	@Test
	public void checkNeighborActionTest() {
		//Configuration.UNDIRECTED=true;
		//Configuration.DIRECTED=false;
		//Configuration.CYCLE=true;
		if (Configuration.CYCLE &&Configuration.UNDIRECTED &&!Configuration.DIRECTED  ) {
			Vertex v1 = new Vertex();
			v1.VertexColor=1;
			v1.VertexCycle=1;
			Vertex v2 = new Vertex();
			v2.VertexColor=1;
			v2.VertexCycle=1;
			cws.checkNeighborAction(v1,v2);
			
			assertTrue(cws.AnyCycles);
		}
	}
}
