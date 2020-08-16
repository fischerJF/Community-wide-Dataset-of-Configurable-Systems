package testset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import elevatorsystem.Actions;
import elevatorsystem.Elevator;
import elevatorsystem.Environment;
import elevatorsystem.Person;
import specifications.Configuration;

public class MainTest {

	private Elevator e;
	private Environment env;
	private Person p1;
	private Actions a;

	@Before
	public void setUp() {
	}

	/*
	 * @Test public void mutantForFeatureInteraction() {
	 * 
	 * env = new Environment(5); e = new Elevator(env, 4, false); a = new
	 * Actions(env, e); p1 = a.bobCall();
	 * 
	 * if (Configuration.overloaded && Configuration.twothirdsfull) { // mutante
	 * boolean b[] = new boolean[1]; e.floorButtons = b; // fim mutante
	 * 
	 * }
	 * 
	 * while (env.getFloor(p1.getOrigin()).hasCall()) e.timeShift();
	 * 
	 * e.timeShift(); a.bobCall(); assertTrue(e.leaveElevator(p1));
	 * 
	 * }
	 */

	@Test
	public void mutantFor_1_overloadedt_twothirdsfull() {

		this.initializationOfTheVariabilityTest();

		if ((!Configuration.weight) && (!Configuration.empty) && (Configuration.twothirdsfull)
				&& (!Configuration.executivefloor) && (Configuration.overloaded)) {
			// mutante
//			boolean b[] = new boolean[1];
//		     e.floorButtons = b;
			// fim mutante
		     //fail();
		}

		this.elevatorManipulationForVariabilityTesting();

		assertTrue(e.leaveElevator(p1));

	}

	@Test
	public void mutantFor_2_weight_empty() {

		this.initializationOfTheVariabilityTest();

		if ((Configuration.weight)&&
				(Configuration.empty)&&	
			    (!Configuration.twothirdsfull) &&
			    (!Configuration.executivefloor) &&
			    (!Configuration.overloaded)){
			
			// mutante
//			boolean b[] = new boolean[1];
//			e.floorButtons = b;
			// fim mutante
		}

		this.elevatorManipulationForVariabilityTesting();

		assertTrue(e.leaveElevator(p1));

	}

	@Test
	public void mutantFor_3_twothirdsfull_executivefloor() {

		this.initializationOfTheVariabilityTest();

		if ((!Configuration.weight) && (!Configuration.empty) && (Configuration.twothirdsfull)
				&& (Configuration.executivefloor) && (!Configuration.overloaded)) {
			// mutante
			boolean b[] = new boolean[1];
			e.floorButtons = b;
			// fim mutante
		}

		this.elevatorManipulationForVariabilityTesting();

		assertTrue(e.leaveElevator(p1));

	}

	@Test
	public void mutantFor_4_executivefloor_overloaded() {

		this.initializationOfTheVariabilityTest();

		if ((!Configuration.weight) && (!Configuration.empty) && (!Configuration.twothirdsfull)
				&& (Configuration.executivefloor) && (Configuration.overloaded)) {

			// mutante
//			boolean b[] = new boolean[1];
//			e.floorButtons = b;
//			// fim mutante
		}

		this.elevatorManipulationForVariabilityTesting();

		assertTrue(e.leaveElevator(p1));

	}

	@Test
	public void mutantFor_5_weight_twothirdsfull() {

		this.initializationOfTheVariabilityTest();

		if ((Configuration.weight) && (!Configuration.empty) && (Configuration.twothirdsfull)
				&& (!Configuration.executivefloor) && (!Configuration.overloaded)) {

			// mutante
//			boolean b[] = new boolean[1];
//			e.floorButtons = b;
			// fim mutante
		}

		this.elevatorManipulationForVariabilityTesting();

		assertTrue(e.leaveElevator(p1));

	}

	@Test
	public void mutantFor_6_empty_executivefloor() {

		this.initializationOfTheVariabilityTest();

		if ((!Configuration.weight)&&
			(Configuration.empty)&&	
		    (!Configuration.twothirdsfull) &&
		    (Configuration.executivefloor) &&
		    (!Configuration.overloaded)){
			
			// mutante
//			boolean b[] = new boolean[1];
//			e.floorButtons = b;
			// fim mutante
		}

		this.elevatorManipulationForVariabilityTesting();

		assertTrue(e.leaveElevator(p1));

	}

	private void initializationOfTheVariabilityTest() {
		env = new Environment(5);
		e = new Elevator(env, 4, false);
		a = new Actions(env, e);
		p1 = a.bobCall();

	}

	private void elevatorManipulationForVariabilityTesting() {
		while (env.getFloor(p1.getOrigin()).hasCall())
			e.timeShift();

		e.timeShift();
		a.bobCall();
	}

}
