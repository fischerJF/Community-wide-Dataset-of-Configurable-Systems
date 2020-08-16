package IncLing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FeatureRank {

	private ArrayList<FeatureHeuristic> rankList;

	public FeatureRank() {
		rankList = new ArrayList<FeatureHeuristic>();
	}

	public void add(FeatureHeuristic f) {
		rankList.add(f);
	}
	public ArrayList<FeatureHeuristic> getRankList() {
		return rankList;
	}

	public void updateRank(FeatureIncling f) {

		updateFrequency(f);
		updateSignum(f);

	}
	
	private void updateFrequency(FeatureIncling f) {
		if (!containsF(f)) {
			FeatureHeuristic freq = new FeatureHeuristic();
			freq.setFeatureName(f.getName());
			if (f.getState().equals("1")) {
			freq.setFrequency(1);
			}else {
			freq.setFrequency(0);
			}
				
			rankList.add(freq);
		} else {
			for (FeatureHeuristic frequency : rankList) {
				if (frequency.getFeatureName().equals(f.getName())) {
					if (f.getState().equals("1")) {
						frequency.setFrequency(frequency.getFrequency() + 1);
					}
				}
			}
		}
	}

	private void updateSignum(FeatureIncling f) {
		for (FeatureHeuristic frequency : rankList) {
			if (frequency.getFeatureName().equals(f.getName())) {
				if (f.getState().equals("1")) {
					frequency.setSignum(frequency.getSignum() + 1);
				} else {
					frequency.setSignum(frequency.getSignum() - 1);
				}

			}
		}
	}

	public boolean containsF(FeatureIncling f) {
		for (FeatureHeuristic frequency : rankList) {
			if (frequency.getFeatureName().equals(f.getName())) {
				return true;
			}
		}
		return false;
	}

	public void sort() {

		Collections.sort(rankList, Collections.reverseOrder(new Comparator<FeatureHeuristic>() {

			@Override
			public int compare(FeatureHeuristic f1, FeatureHeuristic f2) {
				return f1.getFrequency().compareTo(f2.getFrequency());
			}
		}));

//		for (FeatureHeuristic heuristic : rankList) {
//			System.out.println("name: "+heuristic.getFeatureName()+ " frequency: "+ heuristic.getFrequency()+ " signum: "+ heuristic.getSignum()  );
//		}
	}
	public void resetRank() {
		for (FeatureHeuristic feature : rankList) {
			feature.setSignum(0);
			feature.setFrequency(0);

			}
		}

	
	
}
