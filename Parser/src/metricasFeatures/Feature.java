package metricasFeatures;

import java.util.ArrayList;

public class Feature {

	public String nome;

	public int quantidade;

	ArrayList<CMF> classManiFeat = new ArrayList<CMF>();
	public int classes;
	public int constructors;
	public int methods;
	public int LOCs;
	public int occurrences;
	public int otherFeatures;
	public int DT_Max;
	public int NGOr_Max;
	public int NGXOr_Max;
	public int BF_Max_Branching;
	public int NO;
	public int NTop;
	public int NLeaf;
	public int quantFailures;
	
	   	public double porcfeature;

	   	public Feature(String nome, 
	   			int classes, 
	   			int constructors, 
	   			int methods, 
	   			int LOCs, 
	   			int occurrences, 
	   			int otherFeatures, 
	   			int FDT,
	   			int NGOr_Max,
	   			int NGXOr_Max,
	   			int BF_Max_Branching,
	   			int NO,
	   			int NTop,
	   	        int NLeaf
	   			
	   			) {

			this.nome = nome;
			this.classes = classes;
			this.constructors = constructors;
			this.methods = methods;
			this.LOCs = LOCs;
			this.occurrences = occurrences;
			this.otherFeatures = otherFeatures;
			this.DT_Max = FDT;
			this.NGOr_Max= NGOr_Max;
			this.NGXOr_Max= NGXOr_Max;
			this.BF_Max_Branching=BF_Max_Branching;
			this.NO= NO;
			this.NTop=NTop;
			this.NLeaf=NLeaf;
		}   	
	   	
	   	
	public Feature(String nome, int classes, int constructors, int methods, int LOCs, int occurrences, int otherFeatures, int FDT) {

		this.nome = nome;
		this.classes = classes;
		this.constructors = constructors;
		this.methods = methods;
		this.LOCs = LOCs;
		this.occurrences = occurrences;
		this.otherFeatures = otherFeatures;
		this.DT_Max = FDT;
	}

	public Feature(String nome, ArrayList<CMF> classManiFeat, int classes, int constructors, int methods, int LOCs,
			int occurrences, int otherFeatures, int FDT, int quantFailures, double porcfeature) {

		this.nome = nome;
		this.classManiFeat = classManiFeat;
		this.classes = classes;
		this.constructors = constructors;
		this.methods = methods;
		this.LOCs = LOCs;
		this.occurrences = occurrences;
		this.otherFeatures = otherFeatures;
		this.DT_Max = FDT;
		this.quantFailures = quantFailures;
		this.porcfeature = porcfeature;
	}

	public Feature(String nome) {
		this.nome = nome;
	}
}
