package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationBankaccount  extends Specification{
	public static boolean bankaccount = true;
	  public static boolean interest = false;
	  public static boolean creditworthiness = false;
	  public static boolean dailylimit = false;
	  public static boolean interestestimation = false;
	  public static boolean lock = false;
	  public static boolean logging = false;
	  public static boolean overdraft = false;
	  public static boolean transaction = false;
	  public static boolean transactionlog = false;
	  
	private static SpecificationBankaccount SINGLETON;
    
	public static SpecificationBankaccount getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationBankaccount();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static boolean runTest( SATtest t, boolean compat ) {
	    return (tool.modelDebug(t, makeCnfFile ))? true: false;
	  }

	 public static String setbankaccount() {
		    return (bankaccount) ? "bankaccount___" : "-bankaccount___";
		  }

		  public static String setinterest() {
		    return (interest) ? "interest___" : "-interest___";
		  }

		  public static String setcreditworthiness() {
		    return (creditworthiness) ? "creditworthiness___" : "-creditworthiness___";
		  }

		  public static String setdailylimit() {
		    return (dailylimit) ? "dailylimit___"
		        : "-dailylimit___";
		  }

		  public static String setinterestestimation() {
		    return (interestestimation) ? "interestestimation___" : "-interestestimation___";
		  }

		  public static String setlock() {
		    return (lock) ? "lock___" : "-lock___";
		  }

		  public static String setlogging() {
		    return (logging) ? "logging___" : "-logging___";
		  }

		  public static String setoverdraft() {
		    return (overdraft) ? "overdraft___" : "-overdraft___";
		  }

		  public static String settransaction() {
		    return (transaction) ? "transaction___" : "-transaction___";
		  }

		  public static String settransactionlog() {
		    return (transactionlog) ? "transactionlog___" : "-transactionlog___";
		  }

		  public boolean thereIsBase() {
		    	return false;
		    }

		  public static void init(String... args) {
		    int index = 0;
		    bankaccount = Boolean.valueOf(args[index++]);
		    interest = Boolean.valueOf(args[index++]);
		    creditworthiness = Boolean.valueOf(args[index++]);
		    dailylimit = Boolean.valueOf(args[index++]);
		    interestestimation = Boolean.valueOf(args[index++]);
		    lock = Boolean.valueOf(args[index++]);
		    logging = Boolean.valueOf(args[index++]);
		    overdraft = Boolean.valueOf(args[index++]);
		    transaction = Boolean.valueOf(args[index++]);
		    transactionlog = Boolean.valueOf(args[index++]);

		  }

}
