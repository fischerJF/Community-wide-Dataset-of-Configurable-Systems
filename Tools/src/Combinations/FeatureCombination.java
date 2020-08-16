package Combinations;

public class FeatureCombination {

	
	private String name;
	private String state;
	
	public FeatureCombination (){	}
	
	FeatureCombination(String name, String state){
		this.name=name;
		this.state=state;
		
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
