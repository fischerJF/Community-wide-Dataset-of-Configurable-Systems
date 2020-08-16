package splat;

import java.util.Map;

import entry.FeatureVar;



public class QuevalVariables extends Variables {

  private static QuevalVariables SINGLETON;

  public static QuevalVariables getSINGLETON() {
    if (SINGLETON == null) {
      SINGLETON = new QuevalVariables();
    }
    return SINGLETON;
  }

  private QuevalVariables() {
	  this.EXACT_MATCH_QUERY___ = new FeatureVar("EXACT_MATCH_QUERY___");
	  this.KNN_QUERY___ = new FeatureVar("KNN_QUERY___");
	  this.EPSILON_NN_QUERY___ = new FeatureVar("EPSILON_NN_QUERY___");
	  this.RANGE_QUERY___ = new FeatureVar("RANGE_QUERY___");
	  this.DWARF___ = new FeatureVar("DWARF___");
	  this.DWARF_LINEARIZED_SMALL___ = new FeatureVar("DWARF_LINEARIZED_SMALL___");
	  this.MYKDTREE___ = new FeatureVar("MYKDTREE___");
	  this.SEQSCAN___ = new FeatureVar("SEQSCAN___");
	  this.RVARIANT___ = new FeatureVar("RVARIANT___");
	  this.GISTII___ = new FeatureVar("GISTII___");
	  this.VA_SSA___ = new FeatureVar("VA_SSA___");
	  this.INSERTHEURISTICS___ = new FeatureVar("INSERTHEURISTICS___");
	  this.SPLITSIZE___ = new FeatureVar("SPLITSIZE___");
	  this.RSTARSPLIT___ = new FeatureVar("RSTARSPLIT___");
	  this.LINEARSPLIT___ = new FeatureVar("LINEARSPLIT___");
	  this.QUADRATICCOSTALGORITHM___ = new FeatureVar("QUADRATICCOSTALGORITHM___");
	  this.STUPIDSPLITALGO___ = new FeatureVar("STUPIDSPLITALGO___");
    
	  this.GUTTMANINSERT___ = new FeatureVar("GUTTMANINSERT___");
      this.RSTARTINSERT___ = new FeatureVar("RSTARTINSERT___");
      this.SS11___ = new FeatureVar("SS11___");
      this.SS17___ = new FeatureVar("SS17___");
      this.EUCLEADEANSQRD___ = new FeatureVar("EUCLEADEANSQRD___");
      this.MANHATTEN___ = new FeatureVar("MANHATTEN___");
      this.BPD4___ = new FeatureVar("BPD4___");
      this.BPD6___ = new FeatureVar("BPD6___");
      this.BPD7___ = new FeatureVar("BPD7___");
    
	restore();

	
  }
  
  private void init(){
    state.put(EXACT_MATCH_QUERY___, "1");
    state.put(KNN_QUERY___, "?");
    state.put(EPSILON_NN_QUERY___, "?");
    state.put(RANGE_QUERY___, "?");
    state.put(DWARF___, "?");
    state.put(DWARF_LINEARIZED_SMALL___, "?");
    state.put(MYKDTREE___, "?");
    state.put(SEQSCAN___, "?");
    state.put(RVARIANT___, "?");
    state.put(GISTII___, "?");
    state.put(VA_SSA___, "?");
    state.put(INSERTHEURISTICS___, "?");
    state.put(SPLITSIZE___, "?");
    state.put(RSTARSPLIT___, "?");
    state.put(LINEARSPLIT___, "?");
    state.put(QUADRATICCOSTALGORITHM___, "?");
    state.put(STUPIDSPLITALGO___, "?");
	
	state.put(GUTTMANINSERT___, "?");
	state.put(RSTARTINSERT___, "?");
	state.put(SS11___, "?");
	state.put(SS17___, "?");
	state.put(EUCLEADEANSQRD___, "?");
	state.put(MANHATTEN___, "?");
	state.put(BPD4___, "?");
	state.put(BPD6___, "?");
	state.put(BPD7___, "?");
	
	
	
  }

  @Override
  public void restore() {
    state.clear();
    init();
  }

  private FeatureVar 
    EXACT_MATCH_QUERY___,
    KNN_QUERY___, 
    EPSILON_NN_QUERY___,
    RANGE_QUERY___, 
    DWARF___,
    DWARF_LINEARIZED_SMALL___, 
    MYKDTREE___,
    SEQSCAN___, 
    RVARIANT___,
    GISTII___, 
    VA_SSA___,
    INSERTHEURISTICS___, 
    SPLITSIZE___,
    RSTARSPLIT___, 
    LINEARSPLIT___,
    QUADRATICCOSTALGORITHM___, 
    STUPIDSPLITALGO___,
	GUTTMANINSERT___,
	RSTARTINSERT___,
	SS11___,
	SS17___,
	EUCLEADEANSQRD___,
	MANHATTEN___,
	BPD4___,
	BPD6___,
    BPD7___;
	
  public void setEXACT_MATCH_QUERY___(boolean v) {
    if (v) {
      state.put(EXACT_MATCH_QUERY___, "1");
    } else {
      state.put(EXACT_MATCH_QUERY___, "0");
    }
  }

  public boolean isEXACT_MATCH_QUERY___() {
    return notifyFeatureRead(EXACT_MATCH_QUERY___).equals("1");
  }

  public void setKNN_QUERY___(boolean v) {
	  state.put(KNN_QUERY___, (v ? "1" : "0"));
  }

  public boolean isKNN_QUERY___() {
    return notifyFeatureRead(KNN_QUERY___).equals("1");
  }

  public void setEPSILON_NN_QUERY___(boolean v) {
	  state.put(EPSILON_NN_QUERY___, (v ? "1" : "0"));
  }

  public boolean isEPSILON_NN_QUERY___() {
    return notifyFeatureRead(EPSILON_NN_QUERY___).equals("1");
  }

  public void setRANGE_QUERY___(boolean v) {
	  state.put(RANGE_QUERY___, (v ? "1" : "0"));
  }

  public boolean isRANGE_QUERY___() {
    return notifyFeatureRead(RANGE_QUERY___).equals("1");
  }

  public void setDwarf___(boolean v) {
	  state.put(DWARF___, (v ? "1" : "0"));
  }

  public boolean isDwarf___() {
    return notifyFeatureRead(DWARF___).equals("1");
  }

  public void setDwarf_Linearized_Small___(boolean v) {
	  state.put(DWARF_LINEARIZED_SMALL___, (v ? "1" : "0"));
  }

  public boolean isDwarf_Linearized_Small___() {
    return notifyFeatureRead(DWARF_LINEARIZED_SMALL___).equals("1");
  }

  public void setMyKDTree___(boolean v) {
	  state.put(MYKDTREE___, (v ? "1" : "0"));
  }

  public boolean isMyKDTree___() {
    return notifyFeatureRead(MYKDTREE___).equals("1");
  }


  public void setSeqScan___(boolean v) {
	  state.put(SEQSCAN___, (v ? "1" : "0"));
  }

  public boolean isSeqScan___() {
    return notifyFeatureRead(SEQSCAN___).equals("1");
  }

  public void setRVariant___(boolean v) {
	  state.put(RVARIANT___, (v ? "1" : "0"));
  }

  public boolean isRVariant___() {
    return notifyFeatureRead(RVARIANT___).equals("1");
  }

  public void setGiSTII___(boolean v) {
	  state.put(GISTII___, (v ? "1" : "0"));
  }

  public boolean isGiSTII___() {
    return notifyFeatureRead(GISTII___).equals("1");
  }

  public void setVA_SSA___(boolean v) {
	  state.put(VA_SSA___, (v ? "1" : "0"));
  }

  public boolean isVA_SSA___() {
    return notifyFeatureRead(VA_SSA___).equals("1");
  }

  public void setInsertHeuristics___(boolean v) {
	  state.put(INSERTHEURISTICS___, (v ? "1" : "0"));
  }

  public boolean isInsertHeuristics___() {
    return notifyFeatureRead(INSERTHEURISTICS___).equals("1");
  }

  public void setSplitSize___(boolean v) {
	  state.put(SPLITSIZE___, (v ? "1" : "0"));
  }

  public boolean isSplitSize___() {
    return notifyFeatureRead(SPLITSIZE___).equals("1");
  }



  public void setRStarSplit___(boolean v) {
	  state.put(RSTARSPLIT___, (v ? "1" : "0"));
  }

  public boolean isRStarSplit___() {
    return notifyFeatureRead(RSTARSPLIT___).equals("1");
  }

  public void setLinearSplit___(boolean v) {
	  state.put(LINEARSPLIT___, (v ? "1" : "0"));
  }

  public boolean isLinearSplit___() {
    return notifyFeatureRead(LINEARSPLIT___).equals("1");
  }

  public void setQuadraticCostAlgorithm___(boolean v) {
	  state.put(KNN_QUERY___, (v ? "1" : "0"));
  }

  public boolean isQuadraticCostAlgorithm___() {
    return notifyFeatureRead(QUADRATICCOSTALGORITHM___).equals("1");
  }

  public void setStupidSplitAlgo___(boolean v) {
	  state.put(STUPIDSPLITALGO___, (v ? "1" : "0"));
  }

  public boolean isStupidSplitAlgo___() {
    return notifyFeatureRead(STUPIDSPLITALGO___).equals("1");
  }



  
 public void setGuttmanInsert___(boolean v) {
	  state.put(GUTTMANINSERT___, (v ? "1" : "0"));
  }

  public boolean isGuttmanInsert___() {
    return notifyFeatureRead(GUTTMANINSERT___).equals("1");
  }

  public void setRStartInsert___(boolean v) {
	  state.put(RSTARTINSERT___, (v ? "1" : "0"));
  }

  public boolean isRStartInsert___() {
    return notifyFeatureRead(RSTARTINSERT___).equals("1");
  }
  
  public void setSS11___(boolean v) {
	  state.put(SS11___, (v ? "1" : "0"));
  }

  public boolean isSS11___() {
    return notifyFeatureRead(SS11___).equals("1");
  }
  public void setSS17___(boolean v) {
	  state.put(SS17___, (v ? "1" : "0"));
  }

  public boolean isSS17___() {
    return notifyFeatureRead(SS17___).equals("1");
  }
  public void setEucleadeanSqrd___(boolean v) {
	  state.put(EUCLEADEANSQRD___, (v ? "1" : "0"));
  }

  public boolean isSEucleadeanSqrd___() {
    return notifyFeatureRead(EUCLEADEANSQRD___).equals("1");
  }
  public void setManhatten___(boolean v) {
	  state.put(MANHATTEN___, (v ? "1" : "0"));
  }

  public boolean isManhatten___() {
    return notifyFeatureRead(MANHATTEN___).equals("1");
  }
  public void setBPD4___(boolean v) {
	  state.put(BPD4___, (v ? "1" : "0"));
  }

  public boolean isBPD4___() {
    return notifyFeatureRead(BPD4___).equals("1");
  }
  public void setBPD6___(boolean v) {
	  state.put(BPD6___, (v ? "1" : "0"));
  }

  public boolean isBPD6___() {
    return notifyFeatureRead(BPD6___).equals("1");
  }
  public void setBPD7___(boolean v) {
	  state.put(BPD7___, (v ? "1" : "0"));
  }

  public boolean isBPD7___() {
    return notifyFeatureRead(BPD7___).equals("1");
  }
  
  
  
  private String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
    //  tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
      //state.put(fvar, tmp);
    }
    return tmp;
  }

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "notepad";
	}

}
