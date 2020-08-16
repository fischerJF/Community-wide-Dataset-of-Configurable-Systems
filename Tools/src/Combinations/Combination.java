package Combinations;

import java.util.ArrayList;

public class Combination {

	
	private ArrayList<FeatureCombination> listFeatures;
	
	
	public Combination(){
		listFeatures= new ArrayList<FeatureCombination>();
	}
	
	
	public ArrayList<FeatureCombination> getListFeatures() {
		return listFeatures;
	}
	


	public void setListFeatures(ArrayList<FeatureCombination> listFeatures) {
		this.listFeatures = listFeatures;
	}


	public void add(FeatureCombination f) {
		listFeatures.add(f);
	}
	
	
}
