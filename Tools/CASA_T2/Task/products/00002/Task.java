package tasks;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import specifications.Configuration;

public class Task implements Subject{

	private String name = "";
	private String notes = "";
	private double timeRequired;
	Vector observers = new Vector();

	public void createTask(String newName, String newNotes, String newTimeRequired) {
		name = newName;
		notes = newNotes;
		timeRequired = getTimeRequired(newTimeRequired);
	
			notifyObservers();
		
	}

	public String getName() {
		return name;
	}

	public String getNotes() {
		return notes;
	}

	public double getTimeRequired() {
		return timeRequired;
	}

	public void setName(String newName) {
		name = newName;
		
			notifyObservers();
		
	}

	public void setTimeRequired(String newTimeRequired) {
		timeRequired = getTimeRequired(newTimeRequired);
		
			notifyObservers();
		
	}

	public void setNotes(String newNotes) {
		notes = newNotes;
			notifyObservers();
		
	}

	protected double getTimeRequired(String newTimeRequired) {
		double time = 0.0;
		try {
			time = Double.parseDouble(newTimeRequired);
		}
		catch (NumberFormatException e) {}
		return time;
	}
	
	public String toString() {
		return getName();
	}

	public void addObserver(Observer o) {
		
			observers.add(o);
		
	}

	public void removeObserver(Observer o) {
		
			observers.remove(o);
		
	}

	public void notifyObservers() {
			for (Iterator i = observers.iterator() ; i.hasNext() ;)
	    	      ((Observer)i.next()).refresh(this);
		
	}

	
}
