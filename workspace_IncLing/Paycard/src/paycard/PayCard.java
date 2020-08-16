package paycard;
import specifications.Configuration;

public  class PayCard {
	/*@ public instance invariant FM.FeatureModel.paycard ==> (balance >= 0); @*/

	/*@ public instance invariant FM.FeatureModel.paycard ==> (limit > 0); @*/

	 /*@spec_public@*/  int limit=1000;

	 /*@spec_public@*/  int id;

	 /*@spec_public@*/  int balance=0;

	/*@  @*/
	public PayCard(int limit) {
		if (Configuration.paycard) {
		balance = 0;
		this.limit=limit;
	    		}
	}

	/*@  @*/
	public PayCard() {
		if (Configuration.paycard) {
		balance=0;
	    		}
	}

	/*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @ ensures \result.limit==100;
	  @*/
	public static PayCard createJuniorCard() {
	return new PayCard(100);
    }

	/*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @	public normal_behavior
 requires amount>0;
 {|
 requires amount + balance < limit && isValid() == true;
 ensures \result == true;
 ensures balance == amount + \old(balance);
 assignable balance;
 
 also
 
 requires amount + balance >= limit || isValid() == false;
 ensures \result == false;
 |}
 	
 also
 
 public exceptional_behavior
 requires amount <= 0;
	  @*/
	 private boolean  charge__wrappee__Paycard  (int amount) throws IllegalArgumentException {
	if (amount <= 0) {
	    throw new IllegalArgumentException();
	}
	if (this.balance+amount<this.limit && this.isValid()) {
	    this.balance=this.balance+amount;
	    return true;
	} else {
	    return false;
	}
    }

	/*@ also @*/ /*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @ requires FM.FeatureModel.lockout;
	  @ public normal_behavior
 requires amount>0;
 requires amount + balance >= limit || isValid() == false;
 ensures unsuccessfulOperations == \old(unsuccessfulOperations) + 1; 
 assignable unsuccessfulOperations;
	  @*/
	public boolean charge(int amount) throws IllegalArgumentException {
		if (Configuration.lockout)
			return charge__wrappee__Paycard(amount);
    	boolean success = charge__wrappee__Paycard(amount);
    	if (!success)
    		this.unsuccessfulOperations++;
	    return success;
    }

	/*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @	public normal_behavior
 requires amount>0;
 assignable \everything;
 ensures balance >= \old(balance);
	  @*/
	 private void  chargeAndRecord__wrappee__Paycard  (int amount) {
	    charge(amount);
    }

	/*@ 
	  @*/
	public void chargeAndRecord(int amount) {
		if (Configuration.logging) {
			chargeAndRecord__wrappee__Paycard(amount);
			return;
		}
	if (charge(amount)) {
	    try {
		log.addRecord(balance);
	    } catch (CardException e){
		throw new IllegalArgumentException();
	    }
	}
    }

	/*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @	public normal_behavior
 requires true;
 ensures true; 
 assignable \nothing;
	  @*/
	 private /*@pure@*/ boolean  isValid__wrappee__Paycard  () {
	    return true;
    }

	/*@ 
	  @*/
	public /*@pure@*/ boolean isValid() {
		if (Configuration.lockout)
			return isValid__wrappee__Paycard();
	if (unsuccessfulOperations<=3) {
	    return true;
	} else {
	    return false;
	}
    }

	/*@  @*/
	public String infoCardMsg() {
	return (" Current balance on card is " + balance);
    }

	 /*@spec_public@*/  protected LogFile log;

	/*@ public instance invariant FM.FeatureModel.lockout ==> (unsuccessfulOperations >= 0); @*/

	 /*@spec_public@*/  int unsuccessfulOperations = 0;


}
