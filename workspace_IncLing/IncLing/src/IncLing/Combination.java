package IncLing;

import java.util.ArrayList;

public class Combination {

	
	private ArrayList<FeatureIncling> listFeatures;
	
	
	Combination(){
		listFeatures= new ArrayList<FeatureIncling>();
	}
	
	
	public ArrayList<FeatureIncling> getListFeatures() {
		return listFeatures;
	}
	


	public void setListFeatures(ArrayList<FeatureIncling> listFeatures) {
		this.listFeatures = listFeatures;
	}


	public void add(FeatureIncling f) {
		listFeatures.add(f);
	}
	
	
}
