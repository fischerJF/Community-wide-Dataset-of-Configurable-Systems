package paycard;
import specifications.Configuration;

public class LogRecord {
	/*@ public instance invariant
         !empty ==> (balance >= 0 && transactionId >= 0)); @*/

	/*@ public static invariant FM.FeatureModel.logging ==> (transactionCounter >= 0); @*/

	private  /*@spec_public@*/  static int transactionCounter = 0;

	private  /*@spec_public@*/  int balance = -1;

	private  /*@spec_public@*/  int transactionId = -1;

	private  /*@spec_public@*/  boolean empty = true;

	/*@  @*/
	public /*@pure@*/ LogRecord() {
		if (Configuration.logging) {		}
	}

	/*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @ requires FM.FeatureModel.logging;
	  @ public normal_behavior
 requires balance >= 0;
 assignable empty, this.balance, transactionId, transactionCounter;
 ensures this.balance == balance && 
 transactionId == \old(transactionCounter);
	  @*/
	public void setRecord(int balance) throws CardException {
	if(balance < 0){
	    throw new CardException();
	}
	this.empty = false;
	this.balance = balance;
	this.transactionId = transactionCounter++;
    }

	/*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @ requires FM.FeatureModel.logging;
	  @ public normal_behavior
 ensures \result == balance;
	  @*/
	public /*@pure@*/ int getBalance() {
	return balance;
    }

	/*@ 
	  @ requires FM.FeatureModel.paycard && (FM.FeatureModel.logging || !maximumrecord) && (FM.FeatureModel.paycard || !logging) && (FM.FeatureModel.paycard || !lockout);
	  @ requires FM.FeatureModel.logging;
	  @ public normal_behavior
 ensures \result == transactionId;
	  @*/
	public /*@pure@*/ int getTransactionId() {
	return transactionId;
    }


}
