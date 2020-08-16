package elevatorsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import specifications.Configuration;
import specifications.SpecificationException;

public class Elevator {

	private static final int MAX_WEIGHT = 100;

	Environment env;

	int currentFloorID;

	public int weight;

	int executiveFloor = 4;

	private boolean blocked = false;

	public enum Direction {
		UP {
			@Override
			public Direction reverse() {
				return DOWN;
			}
		},
		DOWN {
			@Override
			public Direction reverse() {
				return UP;
			}
		};
		public abstract Direction reverse();
	}

	Direction currentHeading;

	private List<Person> persons = new ArrayList<>();

	public enum DoorState {
		OPEN, CLOSE
	}

	DoorState doors;

	 public boolean[] floorButtons;

	public Elevator(Environment env, int floor, boolean headingUp) {
		this.currentHeading = headingUp ? Direction.UP : Direction.DOWN;
		this.currentFloorID = floor;
		this.doors = DoorState.OPEN;
		this.env = env;
		this.floorButtons = new boolean[env.floors.length];
	}

	public boolean isBlocked() {
		if (Configuration.overloaded) {
			return blocked;
		} else {
			return false;
		}
	}

	public void enterElevator(Person p) {
		persons.add(p);
		p.enterElevator(this);

		if (Configuration.weight) {
			weight += p.getWeight();
		}
	}

	public boolean leaveElevator(Person p) {
		if (persons.contains(p)) {
			persons.remove(p);
			p.leaveElevator();

			if (Configuration.weight) {
				weight -= p.getWeight();
			}
			if (Configuration.empty) {
				if (this.persons.isEmpty())
					Arrays.fill(this.floorButtons, false);
			}
			return true;
		}
		return false;
	}

	/**
	 * Activates the button for the given floor in the lift.
	 * 
	 * @param floorID
	 */
	public void pressInLiftFloorButton(int floorID) {
		floorButtons[floorID] = true;
	}

	private void resetFloorButton(int floorID) {
		floorButtons[floorID] = false;
	}

	public int getCurrentFloorID() {
		return currentFloorID;
	}

	public boolean areDoorsOpen() {
		return doors == DoorState.OPEN;
	}

	public void timeShift() {
		checkBeforeTimeShift();
		try {
			if (Configuration.overloaded) {
				if (areDoorsOpen() && weight > MAX_WEIGHT) {
					blocked = true;
					return;
				} else {
					blocked = false;
				}
			}

			if (stopRequestedAtCurrentFloor()) {
				doors = DoorState.OPEN;
				for (Person p : new ArrayList<>(persons)) {
					if (p.getDestination() == currentFloorID) {
						leaveElevator(p);
					}
				}
				env.getFloor(currentFloorID).processWaitingPersons(this);
				resetFloorButton(currentFloorID);
			} else {
				if (doors == DoorState.OPEN) {
					doors = DoorState.CLOSE;
				}
				if (stopRequestedInDirection(currentHeading, true, true)) {
					continueInDirection(currentHeading);
				} else if (stopRequestedInDirection(currentHeading.reverse(), true, true)) {
					continueInDirection(currentHeading.reverse());
				} else {
					continueInDirection(currentHeading);
				}
			}
		/*} finally {
			checkAfterTimeShift();
		}*/
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private Direction expectedDirection = null;

	private void checkBeforeTimeShift() {
		expectedDirection = null;
		if (getCurrentDirection() == Direction.UP) {
			for (int i = getCurrentFloorID() + 1; i < env.floors.length; i++) {
				if (buttonForFloorIsPressed(i)) {
					expectedDirection = Direction.UP;
					break;
				}
			}
		} else {
			for (int i = getCurrentFloorID() - 1; i >= 0; i--) {
				if (buttonForFloorIsPressed(i)) {
					expectedDirection = Direction.DOWN;
					break;
				}
			}
		}
	}

	private void checkAfterTimeShift() {
		if (expectedDirection != null) {
			if (expectedDirection != getCurrentDirection()) {
				throw new SpecificationException("Spec3", "Elevator changed directions even though there were still calls in the old direction.");
			}
		}
	}

	private boolean stopRequestedAtCurrentFloor() {
		if (Configuration.executivefloor) {
			if (isExecutiveFloorCalling() && !isExecutiveFloor(currentFloorID)) {
				return false;
			}
		}
		if (Configuration.twothirdsfull) {
			if (weight > MAX_WEIGHT * 2 / 3) {
				return floorButtons[currentFloorID] == true;
			}
		}
		return env.getFloor(currentFloorID).hasCall() || floorButtons[currentFloorID] == true;
	}

	private void continueInDirection(Direction dir) {
		currentHeading = dir;
		if (currentHeading == Direction.UP) {
			if (env.isTopFloor(currentFloorID)) {
				currentHeading = currentHeading.reverse();
			}
		} else {
			if (currentFloorID == 0) {
				currentHeading = currentHeading.reverse();
			}
		}
		if (currentHeading == Direction.UP) {
			currentFloorID = currentFloorID + 1;
		} else {
			currentFloorID = currentFloorID - 1;
		}
	}

	private boolean isAnyLiftButtonPressed() {
		for (int i = 0; i < this.floorButtons.length; i++) {
			if (floorButtons[i])
				return true;
		}
		return false;
	}

	private boolean stopRequestedInDirection(Direction dir, boolean respectFloorCalls, boolean respectInLiftCalls) {
		if (Configuration.executivefloor) {
			if (isExecutiveFloorCalling()) {
				return (this.currentFloorID < executiveFloor) == (dir == Direction.UP);
			}
		}
		if (Configuration.twothirdsfull) {
			if (weight > MAX_WEIGHT * 2 / 3 && isAnyLiftButtonPressed()) {
				respectFloorCalls = false;
			}
		}
		Floor[] floors = env.getFloors();
		if (dir == Direction.UP) {
			if (env.isTopFloor(currentFloorID))
				return false;
			for (int i = currentFloorID + 1; i < floors.length; i++) {
				if (respectFloorCalls && floors[i].hasCall())
					return true;
				if (respectInLiftCalls && this.floorButtons[i])
					return true;
			}
			return false;
		} else {
			if (currentFloorID == 0)
				return false;
			for (int i = currentFloorID - 1; i >= 0; i--) {
				if (respectFloorCalls && floors[i].hasCall())
					return true;
				if (respectInLiftCalls && this.floorButtons[i])
					return true;
			}
			return false;
		}
	}

	private boolean anyStopRequested() {
		Floor[] floors = env.getFloors();
		for (int i = 0; i < floors.length; i++) {
			if (floors[i].hasCall())
				return true;
			else if (this.floorButtons[i])
				return true;
		}
		return false;
	}

	public boolean buttonForFloorIsPressed(int floorID) {
		return this.floorButtons[floorID];
	}

	public Direction getCurrentDirection() {
		return currentHeading;
	}

	public Environment getEnv() {
		return env;
	}

	public boolean isEmpty() {
		return this.persons.isEmpty();
	}

	public boolean isIdle() {
		return !anyStopRequested();
	}

	@Override
	public String toString() {
		return "Elevator " + (areDoorsOpen() ? "[_]" : "[] ") + " at " + currentFloorID + " heading " + currentHeading  + " weight; "+ weight;
	}

	public boolean isExecutiveFloor(int floorID) {
		return floorID == executiveFloor;
	}

	public boolean isExecutiveFloorCalling() {
		for (Floor f : env.floors)
			if (f.getFloorID() == executiveFloor && f.hasCall())
				return true;
		return false;
	}

}
