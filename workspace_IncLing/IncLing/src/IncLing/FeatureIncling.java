package IncLing;

public class FeatureIncling {

	
	private String name;
	private String nameForGuidsl;
	private String state;
	
	FeatureIncling (){	}
	
	FeatureIncling(String name, String state){
		this.name=name;
		this.state=state;
		
		if(this.state.equals("0")){
			this.nameForGuidsl="-"+this.name+"___";
	      }else {
	    	  this.nameForGuidsl=this.name+"___";
	     }
	}
	public String getNameForGuidsl() {
		return nameForGuidsl;
	}
	public void setNameForGuidsl(String nameForGuidsl) {
		this.nameForGuidsl = nameForGuidsl;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	
	
	
}
