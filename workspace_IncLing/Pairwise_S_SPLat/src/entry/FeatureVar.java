package entry;

import backtracker.ChoiceGenerator;
import backtracker.IntervalChoiceGenerator;

public class FeatureVar implements Entry{
	
	private String name;
	private ChoiceGenerator choice; 
//	private String state;
	
	public FeatureVar(String name){
		this.name = name;
		this.choice = new IntervalChoiceGenerator(0, 1);
	}
	
	public String getName(){
		return this.name;
	}
	
	public ChoiceGenerator getChoice() {
		return choice;
	}

	public void setChoice(ChoiceGenerator choice) {
		this.choice = choice;
	}
	
	public void resetChoice(){
		this.choice = new IntervalChoiceGenerator(0, 1);
	}
	
	public String toString(){
//		return this.name;
		return name + "[" + choice + "]";
//		return name + "[" + choice.getState() + "]";
	}
	
	public FeatureVar clone(){
		FeatureVar clone = new FeatureVar(name);
		clone.choice = choice.clone();
		return clone;
	}
	
	@Override
	public boolean equals(Object aThat){
	  if ( this == aThat ) 
		  return true;
	  if (aThat instanceof FeatureVar){
		  FeatureVar that = (FeatureVar)aThat;
		  if(this.name.equals(that.getName()))
			  return true;
		  else
			  return false;
	  }
	  return false;
	}

}
