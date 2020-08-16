package IncLing;

import java.util.ArrayList;

public class SPL {

	private ArrayList<Feature> mandatoryFeatureList = new ArrayList<Feature>();
	private ArrayList<Feature> othersFeatureList = new ArrayList<Feature>();


	
	public ArrayList<Feature> getMantatoryFeatureList() {
		return mandatoryFeatureList;
	}

	public ArrayList<Feature> getOthersFeatureList() {
		return othersFeatureList;
	}

	public void addMandatoryFeature(Feature f){
		mandatoryFeatureList.add(f);
	}

	public void addOthersFeature(Feature f){
		othersFeatureList.add(f);
	}
}
