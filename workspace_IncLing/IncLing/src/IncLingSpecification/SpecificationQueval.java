package IncLingSpecification;


import IncLingSpecification.Specification;
import guidsl.Tool;

public class SpecificationQueval  extends Specification{
	public static boolean EXACT_MATCH_QUERY = true;
	public static boolean KNN_QUERY = false;
	public static boolean EPSILON_NN_QUERY = false;
	public static boolean RANGE_QUERY = false;
	public static boolean Dwarf = false;
	public static boolean Dwarf_Linearized_Small = false;
	public static boolean MyKDTree = false;
	public static boolean SeqScan = false;
	public static boolean RVariant = false;
	public static boolean GiSTII = false;
	public static boolean VA_SSA = false;
	public static boolean InsertHeuristics = false;
	public static boolean splitAlgos = false;
	public static boolean SplitSize = false;
	public static boolean RStarSplit = false;
	public static boolean LinearSplit = false;
	public static boolean QuadraticCostAlgorithm = false;
	
	public static boolean StupidSplitAlgo = false;
	public static boolean GuttmanInsert = false;
	public static boolean RStartInsert = false;
	public static boolean SS11 = false;
	public static boolean SS17 = false;
	public static boolean EucleadeanSqrd = false;
	public static boolean Manhatten = false;
	public static boolean BPD4 = false;
	public static boolean BPD6 = false;
	public static boolean BPD7 = false;

	private static SpecificationQueval SINGLETON;
    
	public static SpecificationQueval getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationQueval();
		}
		tool=t;
		return SINGLETON;
	}
		
	public static String setBase() {
		return (EXACT_MATCH_QUERY) ? "EXACT_MATCH_QUERY___" : "-EXACT_MATCH_QUERY___";
	}
	public static String setKNN_QUERY() {
		return (KNN_QUERY) ? "KNN_QUERY___" : "-KNN_QUERY___";
	}	
	public static String setEPSILON_NN_QUERY() {
		return (EPSILON_NN_QUERY) ? "EPSILON_NN_QUERY___" : "-EPSILON_NN_QUERY___";
	}
	
	public static String setRANGE_QUERY() {
		return (RANGE_QUERY) ? "RANGE_QUERY___" : "-RANGE_QUERY___";
	}
	public static String setDwarf() {
		return (Dwarf) ? "Dwarf___" : "-Dwarf___";
	}
	public static String setDwarf_Linearized_Small() {
		return (Dwarf_Linearized_Small) ? "Dwarf_Linearized_Small___" : "-Dwarf_Linearized_Small___";
	}
	public static String setMyKDTree() {
		return (MyKDTree) ? "MyKDTree___" : "-MyKDTree___";
	}
	public static String setSeqScan() {
		return (SeqScan) ? "SeqScan___" : "-SeqScan___";
	}
	public static String setRVariant() {
		return (RVariant) ? "RVariant___" : "-RVariant___";
	}
	public static String setGiSTII() {
		return (GiSTII) ? "GiSTII___" : "-GiSTII___";
	}
	public static String setVA_SSA() {
		return (VA_SSA) ? "VA_SSA___" : "-VA_SSA___";
	}
	public static String setInsertHeuristics() {
		return (InsertHeuristics) ? "InsertHeuristics___" : "-InsertHeuristics___";
	}
	public static String setsplitAlgos() {
		return (splitAlgos) ? "splitAlgos___" : "-splitAlgos___";
	}		
	public static String setSplitSize() {
		return (SplitSize) ? "SplitSize___" : "-SplitSize___";
	}	
	public static String setRStarSplit() {
		return (RStarSplit) ? "RStarSplit___" : "-RStarSplit___";
	}	
	public static String setLinearSplit() {
		return (LinearSplit) ? "LinearSplit___" : "-LinearSplit___";
	}	
	public static String setQuadraticCostAlgorithm() {
		return (QuadraticCostAlgorithm) ? "QuadraticCostAlgorithm___" : "-QuadraticCostAlgorithm___";
	}
	
	
	public static String setStupidSplitAlgo() {
		return (StupidSplitAlgo) ? "StupidSplitAlgo___" : "-StupidSplitAlgo___";
	}
	public static String setRStartInsert() {
		return (RStartInsert) ? "RStartInsert___" : "-RStartInsert___";
	}
	public static String setSS11() {
		return (SS11) ? "SS11___" : "-SS11___";
	}
	public static String setSS17() {
		return (SS17) ? "SS17___" : "-SS17___";
	}
	public static String setEucleadeanSqrd() {
		return (EucleadeanSqrd) ? "EucleadeanSqrd___" : "-EucleadeanSqrd___";
	}
	public static String setManhatten() {
		return (Manhatten) ? "Manhatten___" : "-Manhatten___";
	}
	public static String setBPD4() {
		return (BPD4) ? "BPD4___" : "-BPD4___";
	}
	
	public static String setBPD6() {
		return (BPD6) ? "BPD6___" : "-BPD6___";
	}
	public static String setBPD7() {
		return (BPD7) ? "BPD7___" : "-BPD7___";
	}
	
	public static void init(String... args) {
		int index = 0;
		EXACT_MATCH_QUERY = Boolean.valueOf(args[index++]);
		EPSILON_NN_QUERY = Boolean.valueOf(args[index++]);
		RANGE_QUERY = Boolean.valueOf(args[index++]);
		Dwarf = Boolean.valueOf(args[index++]);
		Dwarf_Linearized_Small = Boolean.valueOf(args[index++]);
		MyKDTree = Boolean.valueOf(args[index++]);
		SeqScan = Boolean.valueOf(args[index++]);
		RVariant = Boolean.valueOf(args[index++]);
		GiSTII = Boolean.valueOf(args[index++]);
		VA_SSA = Boolean.valueOf(args[index++]);
		InsertHeuristics = Boolean.valueOf(args[index++]);
		splitAlgos = Boolean.valueOf(args[index++]);
		SplitSize = Boolean.valueOf(args[index++]);
		RStarSplit = Boolean.valueOf(args[index++]);
		LinearSplit = Boolean.valueOf(args[index++]);
		QuadraticCostAlgorithm = Boolean.valueOf(args[index++]);

	}
	
	public boolean thereIsBase() {
    	return false;
    }
	


}
