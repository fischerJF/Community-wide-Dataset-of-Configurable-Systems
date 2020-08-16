package splat;

import java.util.Map;

import entry.FeatureVar;


public class inclingPaperVariables extends Variables{

	private static inclingPaperVariables SINGLETON;

	public static inclingPaperVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new inclingPaperVariables();
		}
		return SINGLETON;
	}
	
	private inclingPaperVariables() {
		//(G;E;D;U; A;N;C)
//		this.G = new FeatureVar("G___");
//		this.E = new FeatureVar("E___");
//		this.D = new FeatureVar("D___");
//		this.U = new FeatureVar("U___");
		this.A = new FeatureVar("A___");
		this.B = new FeatureVar("B___");
//		this.N = new FeatureVar("N___");
		this.C = new FeatureVar("C___");
    restore();
    

	try {
		//guidsl = loadGUIDSL(this);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	
  private void init() {
//    state.put(G, "1");
//    state.put(E, "?");
//    state.put(D, "?");
//    state.put(U, "?");
	  state.put(A, "?");
      state.put(B, "?");
//    state.put(N, "?");
    state.put(C, "?");
  }
  
	@Override
  public void restore() {
    state.clear();
    init();
  }
  
	public static int FLOORS = 100;
	

//	private FeatureVar G, E, D, U, A, N, C;
	private FeatureVar A,B,C;
  
  
  private String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
  //    tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
      //state.put(fvar, tmp);
    }
    return tmp;
  }

//	public boolean isG() {
//	  return notifyFeatureRead(G).equals("1");
//	}
//
//	public boolean isE() {
//	  return notifyFeatureRead(E).equals("1");
//	}
//
//	public boolean isD() {
//	  return notifyFeatureRead(D).equals("1");
//	}
//
//	public boolean isU() {
//	  return notifyFeatureRead(U).equals("1");
//	}

  public boolean isA() {
	  return notifyFeatureRead(A).equals("1");
  }
	public boolean isB() {
	  return notifyFeatureRead(B).equals("1");
	}

//	public boolean isN() {
//	  return notifyFeatureRead(N).equals("1");
//	}
	public boolean isC() {
		  return notifyFeatureRead(C).equals("1");
		}
//	//(G;E;D;U; A;N;C)
//	public void setG(boolean v) {
//		state.put(G, (v ? "1" : "0"));
//	}
//
//	public void setE(boolean v) {
//		state.put(E, (v ? "1" : "0"));
//	}
//
//	public void setD(boolean v) {
//		state.put(D, (v ? "1" : "0"));
//	}
//
//	public void setU(boolean v) {
//		state.put(U, (v ? "1" : "0"));
//	}

	public void setA(boolean v) {
		state.put(A, (v ? "1" : "0"));
	}
	public void setB(boolean v) {
		state.put(B, (v ? "1" : "0"));
	}

//	public void setN(boolean v) {
//		state.put(N, (v ? "1" : "0"));
//	}
	public void setC(boolean v) {
		state.put(C, (v ? "1" : "0"));
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "elevator";
	}

}
