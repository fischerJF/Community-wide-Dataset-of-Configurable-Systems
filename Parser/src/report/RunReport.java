package report;

import java.util.List;

import metricasFeatures.M_Classes;


public class RunReport  {

	M_Classes metrica;
	Record record;
	
	public RunReport(M_Classes c, Record record) {
		metrica=c;
		this.record=record;
	}
	
	
	public void runReport() {
	 
		Report report= new Report();
		report.nomeClasse=metrica.nomeClasse;
		
//		 report.cbo=""+metrica.cmf_Final.cbo;
//		 report.wmc=""+metrica.cmf_Final.wmc;
//		 report.dit=""+metrica.cmf_Final.dit;
//		 report.noc=""+metrica.cmf_Final.noc;
//		 report.rfc=""+metrica.cmf_Final.rfc;
//		 report.lcom=""+metrica.cmf_Final.lcom;
//		 report.nom=""+metrica.cmf_Final.nom;
//		 report.nopm=""+metrica.cmf_Final.nopm;
//		 report.nosm=""+metrica.cmf_Final.nosm;
//		 report.nof=""+metrica.cmf_Final.nof;
//		 report.nopf=""+metrica.cmf_Final.nopf;
//		 report.nosf=""+metrica.cmf_Final.nosf;
//		 report.nosi=""+metrica.cmf_Final.nosi;
//		 report.loc=""+metrica.cmf_Final.loc;
		
		report.featManipuladas=""+metrica.featManipuladas;
		report.pontosVariabilidade=""+metrica.pontosVariabilidade;
		report.entrelacamento=""+metrica.entrelacamento;
		report.classes=""+metrica.Scattering;
		report.constructors=""+metrica.constructors;
		report.methods=""+metrica.methods;
		report.LOCs=""+metrica.LOCs;
		report.occurrences=""+metrica.VP;
		report.FDT=""+metrica.DT_Max;
		report.quantFailures=""+metrica.quantFailures;
		report.porcfeature=""+metrica.porcfeature;
		
		report.Scattering=""+metrica.Scattering;
		report.VP=""+ metrica.VP;
		report.Tangling=""+ metrica.Tangling;
		report.DT_Max=""+ metrica.DT_Max;
		
		if(metrica.DT_Min!=1000)
			report.DT_Min=""+metrica.DT_Min;
		else
			report.DT_Min="0";
		
		
		report.NGOr_Max=""+metrica.NGOr_Max;
		report.NGXOr_Max=""+ metrica.NGXOr_Max;
		report.BF_Max_Branching=""+metrica.BF_Max_Branching;
		report.NO=""+metrica.NO;
		report.NTop=""+metrica.NTop;
		report.NLeaf=""+metrica.NLeaf;
		report.NVCF="X";
		report.NTF=""+metrica.featManipuladas;
		report.nomeFeature=""+metrica.nomeFeatures;
		
		
				
		record.report.add(report);
}

	
}
