package metricasFeatures_4;

import java.util.ArrayList;

public class Feature {

	
	public String nome;
	
	public int quantidade;
	public int LOC_InsideFeatures;
	
	ArrayList<CMF> classManiFeat = new ArrayList<CMF>();
    public int classes;
    public int constructors;
    public int methods;
    public int LOCs;
    public int occurrences;
    public int otherFeatures;
    public int FDT;
    public int quantFailures;
    public double porcfeature;
	
	public Feature(String nome,
			ArrayList<CMF> classManiFeat,  
			int classes,
			int constructors,
			int methods,
			int LOCs,
			int occurrences,
			int otherFeatures,
			int FDT,
			int quantFailures,
			double porcfeature) {
		
		
		this.nome =nome;
		this.classManiFeat=classManiFeat;
		this.classes=classes;
		this.constructors=constructors;
		this.methods=methods;
		this.LOCs=LOCs;
		this.occurrences=occurrences;
		this.otherFeatures=otherFeatures;
		this.FDT=FDT;
		this.quantFailures=quantFailures;
		this.porcfeature=porcfeature;
	}
	
	public Feature(String nome) {
		this.nome=nome;
	}
}
