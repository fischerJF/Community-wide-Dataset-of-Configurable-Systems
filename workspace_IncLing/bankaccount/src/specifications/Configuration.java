package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration  {

	public static boolean bankaccount;
    public static boolean creditworthiness;
    public static boolean dailylimit;
    public static boolean interest;
    public static boolean interestestimation;
    public static boolean lock;
    public static boolean logging;
    public static boolean overdraft;
    public static boolean transaction;
    public static boolean transactionlog;

	public boolean validate;
	public static Tool tool = new Tool("modified-model.m" );
	public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

    public static boolean valid() {
        return bankaccount && (!dailylimit || bankaccount) && (!interest || bankaccount) && (!overdraft || bankaccount) && (!creditworthiness || bankaccount) && (!lock || bankaccount) && (!logging || bankaccount) && (!interestestimation || interest) && (!transaction || lock) && (!transactionlog || logging) && (!logging || !transaction || transactionlog) && (!transactionlog || logging) && (!transactionlog || transaction);
    }
	public static boolean validProduct() {
		
		SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
		t.add(setBANKACCOUNT());
		t.add(setCREDITWORTHINESS());
		t.add(setDAILYLIMIT());
		t.add(setINTEREST());
		t.add(setINTERESTESTIMATION());
		t.add(setLOCK());
		t.add(setLOGGING());
		t.add(setOVERDRAFT());
	    t.add(setTRANSACTION());
	    t.add(setTRANSACTIONLOG());
	    
	     return runTest( t, makeCnfFile ); 
	}	
	public static boolean runTest( SATtest t, boolean compat ) {
		
		return (tool.modelDebug(t, makeCnfFile ))? true: false;
	}
	public static String setBANKACCOUNT() {
		return (bankaccount) ? "BANKACCOUNT___" : "-BANKACCOUNT___";
	}
	public static String setCREDITWORTHINESS() {
		return (creditworthiness) ? "CREDITWORTHINESS___" : "-CREDITWORTHINESS___";
	}	
	public static String setDAILYLIMIT() {
		return (dailylimit) ? "DAILYLIMIT___" : "-DAILYLIMIT___";
	}	
	public static String setINTEREST() {
		return (interest) ? "INTEREST___" : "-INTEREST___";
	}
	public static String setINTERESTESTIMATION() {
		return (interestestimation) ? "INTERESTESTIMATION___" : "-INTERESTESTIMATION___";
	}
	public static String setLOCK() {
		return (lock) ? "LOCK___" : "-LOCK___";
	}
	public static String setLOGGING() {
		return (logging) ? "LOGGING___" : "-LOGGING___";
	}
	public static String setOVERDRAFT() {
		return (overdraft) ? "OVERDRAFT___" : "-OVERDRAFT___";
	}
	public static String setTRANSACTION() {
		return (transaction) ? "TRANSACTION___" : "-TRANSACTION___";
	}
	public static String setTRANSACTIONLOG() {
		return (transactionlog) ? "TRANSACTIONLOG___" : "-TRANSACTIONLOG___";
	}
	
	public static void init(String... args) {
		int index = 0;
		bankaccount = Boolean.valueOf(args[index++]);		
		creditworthiness  = Boolean.valueOf(args[index++]);
		dailylimit = Boolean.valueOf(args[index++]);
		interest = Boolean.valueOf(args[index++]);
		interestestimation = Boolean.valueOf(args[index++]);
		lock = Boolean.valueOf(args[index++]);
		logging = Boolean.valueOf(args[index++]);
		overdraft  = Boolean.valueOf(args[index++]);
		transaction  = Boolean.valueOf(args[index++]);
		transactionlog  = Boolean.valueOf(args[index++]);
		
	}
	
	public static void productPrint() {
		System.out.println( 
				"conf:"+
						"TRANSACTIONLOG:"+ Configuration.transactionlog+
						" TRANSACTION:"+ Configuration.transaction+
						" OVERDRAFT:"+ Configuration.overdraft+
						" LOGGING:"+ Configuration.logging+
						" LOCK:"+ Configuration.lock+
						" INTERESTESTIMATION:"+ Configuration.interestestimation+
						" INTEREST:"+ Configuration.interest+
						" DAILYLIMIT:"+ Configuration.dailylimit+
						" CREDITWORTHINESS:"+ Configuration.creditworthiness+
						" BANKACCOUNT:"+ Configuration.bankaccount
				);
	}
	public static String returnProduct() {
		return "TRANSACTIONLOG:"+ Configuration.transactionlog+
				" TRANSACTION:"+ Configuration.transaction+
				" OVERDRAFT:"+ Configuration.overdraft+
				" LOGGING:"+ Configuration.logging+
				" LOCK:"+ Configuration.lock+
				" INTERESTESTIMATION:"+ Configuration.interestestimation+
				" INTEREST:"+ Configuration.interest+
				" DAILYLIMIT:"+ Configuration.dailylimit+
				" CREDITWORTHINESS:"+ Configuration.creditworthiness+
			    " BANKACCOUNT:"+ Configuration.bankaccount
				;
	}

}