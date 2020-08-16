package splat;


import java.util.Map;

import entry.FeatureVar;

public class BankaccountVariables extends Variables {

	private static BankaccountVariables SINGLETON;

	public static BankaccountVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new BankaccountVariables();
		}
		return SINGLETON;
	}

	private BankaccountVariables() {
		this.BANKACCOUNT___ = new FeatureVar("BANKACCOUNT___");
		this.CREDITWORTHINESS___ = new FeatureVar("CREDITWORTHINESS___");
		this.DAILYLIMIT___ = new FeatureVar("DAILYLIMIT___");
		this.INTEREST___ = new FeatureVar("INTEREST___");
		this.INTERESTESTIMATION___ = new FeatureVar("INTERESTESTIMATION___");
		this.LOCK___ = new FeatureVar("LOCK___");
		this.LOGGING___ = new FeatureVar("LOGGING___");
		this.OVERDRAFT___ = new FeatureVar("OVERDRAFT___");
		this.TRANSACTION___ = new FeatureVar("TRANSACTION___");
		this.TRANSACTIONLOG___ = new FeatureVar("TRANSACTIONLOG___");
		restore();

		
	}

	private void init() {
		state.put(BANKACCOUNT___, "1");
		state.put(CREDITWORTHINESS___, "?");
		state.put(DAILYLIMIT___, "?");
		state.put(INTEREST___, "?");
		state.put(INTERESTESTIMATION___, "?");
		state.put(LOCK___, "?");
		state.put(LOGGING___, "?");
		state.put(OVERDRAFT___, "?");
		state.put(TRANSACTION___, "?");
		state.put(TRANSACTIONLOG___, "?");
	}

	@Override
	public void restore() {
		state.clear();
		init();
	}

	private FeatureVar BANKACCOUNT___, CREDITWORTHINESS___, DAILYLIMIT___,
			INTEREST___, INTERESTESTIMATION___, LOCK___, LOGGING___,
			OVERDRAFT___, TRANSACTION___, TRANSACTIONLOG___;

	// public boolean isDAILYLIMIT___() {
	// return get(VARS.DAILYLIMIT___).equals("1");
	// }

	public void setDAILYLIMIT___(boolean v) {
		state.put(DAILYLIMIT___, (v ? "1" : "0"));
	}

	public void setBANKACCOUNT___(boolean v) {
		state.put(BANKACCOUNT___, (v ? "1" : "0"));
	}

	public void setCREDITWORTHINESS___(boolean v) {
		state.put(CREDITWORTHINESS___, (v ? "1" : "0"));
	}

	public void setINTEREST___(boolean v) {
		state.put(INTEREST___, (v ? "1" : "0"));
	}

	public void setINTERESTESTIMATION___(boolean v) {
		state.put(INTERESTESTIMATION___, (v ? "1" : "0"));
	}

	public void setLOCK___(boolean v) {
		state.put(LOCK___, (v ? "1" : "0"));
	}

	public void setLOGGING___(boolean v) {
		state.put(LOGGING___, (v ? "1" : "0"));
	}

	public void setOVERDRAFT___(boolean v) {
		state.put(OVERDRAFT___, (v ? "1" : "0"));
	}

	public void setTRANSACTION___(boolean v) {
		state.put(TRANSACTION___, (v ? "1" : "0"));
	}

	public void setTRANSACTIONLOG___(boolean v) {
		state.put(TRANSACTIONLOG___, (v ? "1" : "0"));
	}

	public boolean isBANKACCOUNT___() {
		return notifyFeatureRead(BANKACCOUNT___).equals("1");
	}

	public boolean isCREDITWORTHINESS___() {

		return notifyFeatureRead(CREDITWORTHINESS___).equals("1");
	}

	public boolean isDAILYLIMIT___() {
		return notifyFeatureRead(DAILYLIMIT___).equals("1");
	}

	public boolean isINTEREST___() {
		return notifyFeatureRead(INTEREST___).equals("1");
	}

	public boolean isINTERESTESTIMATION___() {
		return notifyFeatureRead(INTERESTESTIMATION___).equals("1");
	}

	public boolean isLOCK___() {
		return notifyFeatureRead(LOCK___).equals("1");
	}

	public boolean isLOGGING___() {
		return notifyFeatureRead(LOGGING___).equals("1");
	}

	public boolean isOVERDRAFT___() {
		return notifyFeatureRead(OVERDRAFT___).equals("1");
	}

	public boolean isTRANSACTION___() {
		return notifyFeatureRead(TRANSACTION___).equals("1");
	}

	public boolean isTRANSACTIONLOG___() {
		return notifyFeatureRead(TRANSACTIONLOG___).equals("1");
	}

	private String notifyFeatureRead(FeatureVar fvar) {
		String tmp = state.get(fvar);
		if (tmp == "?") {
			/**
			 * only makes a choice if it is not already present in the map
			 */
			//tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
			//state.put(fvar, tmp);
		}
		// System.out.println(fvar.getName() + " = " + state.get(fvar));//remove
		return tmp;
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "companies";
	}

}
