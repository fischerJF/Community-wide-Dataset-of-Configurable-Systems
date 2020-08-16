package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import smashed_varexj.FinishTimeWorkSpace;
import smashed_varexj.Main;
import smashed_varexj.RegionWorkSpace;
import smashed_varexj.Vertex;
import smashed_varexj.WorkSpaceTranspose;
import specifications.Configuration;

public class ConnectedTests_Caio {
	

	@Test
	public void ConnectedRelated() {
//		Configuration.CONNECTED=true;
		if (Configuration.CONNECTED) {
			Vertex v1 = new Vertex();
			RegionWorkSpace r = new RegionWorkSpace();
			assertEquals(r.counter, 0);
			r.init_vertex(v1);
			assertEquals(v1.componentNumber, -1);
			r.postVisitAction(v1);
			assertEquals(v1.componentNumber, 0);
			/* Testing Display */
			 v1.display();
			    assertTrue(Main.testOps.contains("Vertex.display, CONNECTED was displayed!"));
		}
	}

	@Test
	public void StronglyConnected() {
		// Allocating variables
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();

		// v1.display();
		// assertTrue(Main.testOps.contains("Vertex.display, STRONGLYCONNECTED was
		// displayed!"));

		/* FinishTimeWorkSpace Tests */

//		    Configuration.STRONGLYCONNECTED=true;
		
		if (Configuration.STRONGLYCONNECTED) {
			FinishTimeWorkSpace f = new FinishTimeWorkSpace();
			assertEquals(f.FinishCounter, 1);
			f.preVisitAction(v1);
			assertEquals(f.FinishCounter, 2);
			f.postVisitAction(v1);
			assertNotSame(v1.finishTime, 0);

			/* WorkSpaceTranspose Tests */
			WorkSpaceTranspose w = new WorkSpaceTranspose();
			assertEquals(w.SCCCounter, 0);
			w.nextRegionAction(v2);
			System.err.println(w.SCCCounter);
			assertEquals(w.SCCCounter, 1);
			w.preVisitAction(v2);
			assertEquals(v2.strongComponentNumber, 1);
			
		}
	}

}
