package IncLing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLingSpecification.Specification;
import sampling.Pairwise;
import sampling.Pairwise.Requirement;
import splat.GPLVariables;
import splat.Variables;

public class IncLingAdapter {

	

	public IncLingAdapter() {
		
	}

	
	public ArrayList<Combination> callPairWise(Variables vars) {

		ArrayList<Combination> features = new ArrayList<Combination>();
		Combination combination;
		
		Pairwise pw = new Pairwise(vars);
		FeatureIncling featureA;
		FeatureIncling featureB;
		for ( Requirement r : pw.requirements) {
			System.out.println(r.index_1+ ":  "+r.val_1+ " | "+r.index_2+ ":  "+r.val_2 );
			combination = new Combination();
			featureA = new FeatureIncling();
			
			featureA.setName(r.index_1.substring (0, r.index_1.length() - 3));
			featureA.setState(r.val_1 );
			if(featureA.getState().equals("0")){
					featureA.setNameForGuidsl("-"+r.index_1);
			}else {
					featureA.setNameForGuidsl(r.index_1);
			}
			combination.add(featureA);
			
			featureB = new FeatureIncling();
			featureB.setName(r.index_2.substring (0, r.index_2.length() - 3));
			featureB.setState(r.val_2 );
			if(featureB.getState().equals("0")){
				featureB.setNameForGuidsl("-"+r.index_2);
		    } else {
				featureB.setNameForGuidsl(r.index_2);
		    }
			combination.add(featureB);
			features.add(combination);
		}
		return features;
		
	}

}
