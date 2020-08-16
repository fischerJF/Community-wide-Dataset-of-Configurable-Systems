package elevatorsystem;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	private final int thisFloorID;

	private boolean elevatorCall = false;

	private List<Person> waiting = new ArrayList<>();

	public Floor(int id) {
		thisFloorID = id;
	}

	public int getFloorID() {
		return this.thisFloorID;
	}

	public void callElevator() {
		elevatorCall = true;
	}

	public void reset() {
		elevatorCall = false;
	}

	public boolean hasCall() {
		return elevatorCall;
	}

	public void processWaitingPersons(Elevator e) {
		for (Person p : waiting) {
			e.enterElevator(p);
		}
		waiting.clear();
		reset();
	}

	public void addWaitingPerson(Person person) {
		waiting.add(person);
		callElevator();
	}
	
	
	
	public List<Person> getWaiting(){
		return waiting;
	}

	public boolean isElevatorCall() {
		return elevatorCall;
	}
	
}
