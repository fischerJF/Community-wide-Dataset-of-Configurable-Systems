package metricasFeatures;

public class M_Classes {

	public String nomeClasse;
	public int featManipuladas;
	public int pontosVariabilidade; 
	public int entrelacamento;
	
	public int Scattering; //classes
    public int constructors;
    public int methods;
    public int LOCs;
    public int VP ;
    public int Tangling;
    public int DT_Max;
    public int DT_Min=1000;
    public int NGOr_Max;
    public int NGXOr_Max;
    public int BF_Max_Branching;
    public int NO;
    public int NTop;
    public int NLeaf;
    
    public int quantFailures;
    public double porcfeature;
    
    public String nomeFeatures="";
    
    
    public CMF cmf_Final = new CMF();
	
}
