package metricasFeatures_4;

import java.util.Comparator;

public class ComparadorDeFeature implements Comparator<Feature> {
    public int compare(Feature f1, Feature f2) {
    	String l1 = f1.nome;
		String l2 = f2.nome;
		return l1.compareTo(l2);
    }
}
