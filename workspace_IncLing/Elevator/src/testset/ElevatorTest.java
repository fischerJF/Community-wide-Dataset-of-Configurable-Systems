package testset;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;
import static org.mockito.Matchers.anyObject;
import elevatorsystem.Elevator;
import elevatorsystem.Environment;
import elevatorsystem.Person;
import elevatorsystem.Elevator.Direction;
import elevatorsystem.Elevator.DoorState;
import specifications.Configuration;

public class ElevatorTest {

	private Elevator e;
	
	private Environment env;
	
	private Person p1;
	private Person p2;
	private Person p3;
	private Person p4; 

	@Before
	public void setUp(){
		env = new Environment(5);
		e=new Elevator(env, 4, false);
		p1 = new  Person("Maria", 60, 1, 2, env);
		p2= new Person("Paulo", 40, 1, 2, env);
		p3 = new Person("John", 80, 1, 3, env);
		p4 = new Person("Pedro", 90, 1, 4, env);
	}
	
	@Test
	public void testisBlocked() {
		Environment env = new Environment(5);
		e = new Elevator(env, 4, false);

		if (!Configuration.overloaded) {
			assertFalse(e.isBlocked());
		}

	}

	@Test
	public void testEnterElevator() {
		Environment env = new Environment(5);
		e = new Elevator(env, 4, false);
		e.enterElevator(new Person("Paulo", 40, 1, 4, env));
		assertTrue(e.floorButtons[4]);

	}

	@Test
	public void testEnterElevatorWeight() {
		
		if (Configuration.weight) {
			e.enterElevator(p1);
			e.enterElevator(p2);
			e.enterElevator(p3);
			e.enterElevator(p4);
			assertEquals(270, e.weight);			
		} 
		assertTrue(true);
		
	}
	
	@Test
	public void testLeaveElevator(){
	    e.enterElevator(p1);
	    e.enterElevator(p2);
	    e.enterElevator(p3);
		
	    assertTrue(e.leaveElevator(p1));
		assertTrue(e.leaveElevator(p2));
		assertTrue(e.leaveElevator(p3));
		assertFalse(e.leaveElevator(p4));
	}
	
	@Test
	public void testLeaveElevatorForWeight(){
			
		e.enterElevator(p1);
		e.enterElevator(p2);
		e.enterElevator(p3);
		e.enterElevator(p4);
		
		e.leaveElevator(p1);
		e.leaveElevator(p2);
		e.leaveElevator(p3);
		e.leaveElevator(p4);
		
		if(Configuration.weight){
			assertEquals(0, e.weight);
		}
			assertTrue(true);
		
		
	}
	
	@Test
	public void testLeaveElevatorForEmpty(){
		e.enterElevator(p1);
		e.enterElevator(p2);
		e.enterElevator(p3);
		e.enterElevator(p4);
		
		e.leaveElevator(p1);
		e.leaveElevator(p2);
		e.leaveElevator(p3);
		e.leaveElevator(p4);
		if(Configuration.empty){
		 for (boolean b : e.floorButtons) {
			if(b){
				assertTrue(false);
			}
		}
			assertTrue(true);
		}
		assertTrue(true);
	}
	
	@Test
	public void isBlockedTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.overloaded=true;
		if (Configuration.overloaded) {
			MemberModifier.field(Elevator.class, "blocked").set(e, true);
			assertTrue(e.isBlocked());
		}
//		Configuration.overloaded=true;
		if (!Configuration.overloaded) {
			assertFalse(e.isBlocked());
		}
	}
	
	@Test
	public void enterElevator() {
//		Configuration.weight=true;
		if (Configuration.weight) {
			e.enterElevator(p1);
			assertEquals(e.weight,60);
		}
		
//		Configuration.weight=false;
		if (!Configuration.weight) {
			e=new Elevator(env, 4, false);
			e.enterElevator(p1);
			assertEquals(e.weight,0);
		}

	}
	
	@Test
	public void leaveElevatorTest1() {
		e=new Elevator(env, 4, false);
		assertFalse(e.leaveElevator(p1));
		
	}
	@Test
	public void leaveElevatorTest2() {
		e.enterElevator(p1);
//		Configuration.weight=false;
//		Configuration.empty=false;
		if (!Configuration.weight && !Configuration.empty) {
			assertTrue(e.leaveElevator(p1));	
		}
	}
	@Test
	public void leaveElevatorTest3() {
	
//		Configuration.weight=true;
//		Configuration.empty=false;
		if (Configuration.weight && !Configuration.empty) {
			e.enterElevator(p1);
			assertEquals(e.weight,60);
			assertTrue(e.leaveElevator(p1));
			assertEquals(e.weight,0);
		}
	}
	@Test
	public void leaveElevatorTest4() {
		e.enterElevator(p1);
//		Configuration.weight=false;
//		Configuration.empty=true;
		if (!Configuration.weight && Configuration.empty) {
			assertTrue(e.leaveElevator(p1));
			for (int i = 0; i < e.floorButtons.length; i++) {
				if(e.floorButtons[i])
					assertTrue(false);
			}
			assertTrue(true);
		}
	}
	
	@Test
	public void getEnvTest() {
	
		assertEquals(e.getEnv(),env);
		
	}
		
	@Test
	public void isToString() {
		System.err.println(e.toString());
		assertEquals(e.toString(),"Elevator [_] at 4 heading DOWN weight; 0");
	}
	@Test
	public void isExecutiveFloor() {
		assertTrue(e.isExecutiveFloor(4));
		assertFalse(e.isExecutiveFloor(3));
	}
	@Test
	public void isExecutiveFloorCallingTest() {
		env = new Environment(1);
		e=new Elevator(env, 0, false);
		assertFalse(e.isExecutiveFloorCalling());
	}
	@Test
	public void anyStopRequestedTest() throws Exception {
		boolean b= (boolean) Whitebox.invokeMethod(e, "anyStopRequested");
		assertTrue(b);
	}
	@Test
	public void anyStopRequestedTest2() throws Exception {
		env = new Environment(0);
		e=new Elevator(env, 0, false);
		boolean b= (boolean) Whitebox.invokeMethod(e, "anyStopRequested");
	    assertFalse(b);
	}
	@Test
	public void isAnyLiftButtonPressed() throws Exception {
		env = new Environment(0);
		e=new Elevator(env, 0, false);
		boolean b= (boolean) Whitebox.invokeMethod(e, "isAnyLiftButtonPressed");
		assertFalse(b);
	}
	@Test
	public void isAnyLiftButtonPressed1() throws Exception {
		env = new Environment(4);
		e=new Elevator(env, 4, false);
		e.pressInLiftFloorButton(3); 
		boolean b= (boolean) Whitebox.invokeMethod(e, "isAnyLiftButtonPressed");
        assertTrue(b);
	}
	
	@Test
	public void stopRequestedInDirection() throws Exception {
			MemberModifier.field(Elevator.class, "currentFloorID").set(e,1);
			e.pressInLiftFloorButton(1); 
			boolean b= (boolean) Whitebox.invokeMethod(e, "stopRequestedInDirection",Direction.UP,false, false);
			assertFalse(b);
	}
	@Test
	public void isIdleTest() {
		e.pressInLiftFloorButton(1); 
		assertFalse(e.isIdle());
	}
	
	@Test
	public void timeShiftTest_BlockedTrue() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.overloaded=true;
		if (Configuration.overloaded) {
			 MemberModifier.field(Elevator.class, "doors").set(e, DoorState.OPEN);
	         e.weight=200;
	         e.timeShift();
	         boolean test=(boolean)  MemberModifier.field(Elevator.class, "blocked").get(e);
	         assertTrue(test);
		}
	}
	@Test
	public void timeShiftTest_BlockedFalse() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.overloaded=true;
		if (Configuration.overloaded) {
			 MemberModifier.field(Elevator.class, "doors").set(e, DoorState.OPEN);
	         e.weight=10;
	         e.timeShift();
	         boolean test=(boolean)  MemberModifier.field(Elevator.class, "blocked").get(e);
	         assertFalse(test);
		}
	}
	@Test
	public void timeShiftTest() throws Exception {
		
//		Configuration.overloaded=false;
//		Configuration.executivefloor=false;
//		Configuration.twothirdsfull=false;
		
		if (!Configuration.overloaded) {
		
          e.enterElevator(p1);
          e.enterElevator(p2);
          e.enterElevator(p3);
          e.enterElevator(p4);
          MemberModifier.field(Elevator.class, "currentFloorID").set(e, 2);
          e.timeShift();
          boolean test=(boolean)  MemberModifier.field(Person.class, "destinationReached").get(p1);
          assertTrue(test);
          
          e.enterElevator(p2);
          MemberModifier.field(Elevator.class, "currentFloorID").set(e, 2);
          e.timeShift();
          test=(boolean)  MemberModifier.field(Person.class, "destinationReached").get(p2);
          assertTrue(test);
       
          e.enterElevator(p3);
          MemberModifier.field(Elevator.class, "currentFloorID").set(e, 3);
          e.timeShift();
          test=(boolean)  MemberModifier.field(Person.class, "destinationReached").get(p3);
          assertTrue(test);
          
          e.enterElevator(p4);
          MemberModifier.field(Elevator.class, "currentFloorID").set(e, 4);
          e.timeShift();
          test=(boolean)  MemberModifier.field(Person.class, "destinationReached").get(p4);
          assertTrue(test);
            
		}
	}
	
	@Test
	public void TimeShiftTest() throws IllegalArgumentException, IllegalAccessException{
		
//		Configuration.overloaded=false;
//		Configuration.executivefloor=true;
//		Configuration.twothirdsfull=false;
		
		if (!Configuration.overloaded && Configuration.executivefloor && !Configuration.overloaded ) {
			e.enterElevator(p1);
			
			MemberModifier.field(Elevator.class, "currentFloorID").set(e, 1);
			MemberModifier.field(Elevator.class, "executiveFloor").set(e,2);
			env.getFloor(2).callElevator();  
			
			e.timeShift();
			Object obj = (Object) MemberModifier.field(Elevator.class, "currentHeading").get(e);
			
			assertEquals(obj.toString(), "UP");
			
		}
	}
	@Test
	public void TimeShiftTest_2() throws IllegalArgumentException, IllegalAccessException{
	
//		Configuration.overloaded=false;
//		Configuration.executivefloor=false;
//		Configuration.twothirdsfull=true;
		
		if (!Configuration.overloaded && !Configuration.executivefloor && Configuration.twothirdsfull ) {
	      e.enterElevator(p1);
         
          MemberModifier.field(Elevator.class, "currentFloorID").set(e, 1);
          MemberModifier.field(Elevator.class, "executiveFloor").set(e,2);
         // env.getFloor(2).callElevator();  
          e.weight=1000;
          e.floorButtons[2]=false;
          e.timeShift();
          Object obj = (Object) MemberModifier.field(Elevator.class, "currentHeading").get(e);

          assertEquals(obj.toString(), "DOWN");
        
       }
	}
	
	@Test
	public void anyStopRequestedTest_2() throws Exception {
		for (int x=0; x<e.floorButtons.length; x++) {
		    	e.floorButtons[x]=true;
		}
		boolean b= (boolean) Whitebox.invokeMethod(e, "anyStopRequested");
	    assertTrue(b);
	}
	
	@Test
	public void stopRequestedInDirection_2() throws Exception {
//		Configuration.executivefloor=false;
//		Configuration.twothirdsfull=true;
		if (!Configuration.executivefloor && Configuration.twothirdsfull) {
			   e.weight=1000;
			   Object obj=null;
			   for (int x=0; x<e.floorButtons.length; x++) {
			    	e.floorButtons[x]=true;
			}
			   boolean b= (boolean) Whitebox.invokeMethod(e, "stopRequestedInDirection",obj, true, true);
			    assertTrue(b);
		}
	}
	
	@Test
    public void isBlockedTest2() {
//		Configuration.overloaded=false;
		if (!Configuration.overloaded) {
			assertFalse(e.isBlocked());
		}
		 
	  }
	
	@Test 
	public void currentHeadingTest() throws IllegalArgumentException, IllegalAccessException {
		System.err.println(e.getCurrentDirection());
		e.getCurrentDirection().reverse();
		Object obj = (Object) MemberModifier.field(Elevator.class, "currentHeading").get(e);
		assertEquals(obj.toString(),"DOWN");
		Object test = e.getCurrentDirection();
		MemberModifier.field(Elevator.class, "currentHeading").set(e, e.getCurrentDirection().reverse());

		System.err.println(e.getCurrentDirection());
		assertEquals(e.getCurrentDirection().reverse(),test);
	}
	
	@Test
	public void getCurrentFloorIDTest() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Elevator.class, "currentFloorID").set(e,1);
		assertEquals(e.getCurrentFloorID(),1);
	}
	@Test
	public void  areDoorsOpenTest() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Elevator.class, "doors").set(e, DoorState.OPEN);
		assertTrue(e.areDoorsOpen());
		
		MemberModifier.field(Elevator.class, "doors").set(e, DoorState.CLOSE);
		assertFalse(e.areDoorsOpen());
	}
	
}
