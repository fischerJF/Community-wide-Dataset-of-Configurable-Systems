package email;
import java.util.List;
import java.util.Vector;

import TestSpecifications.SpecificationManager;
import specifications.Configuration;

public  class  PL_Interface_impl  implements PL_Interface {

	public static void main(String[] args) {
		Configuration.VERIFY=true;
		try {
		//	(new PL_Interface_impl()).start(1,-1);
//			System.out.println("no Exception");
		} catch (Throwable e) {
			//System.out.println("Caught Exception: " + e.getClass() + " " + e.getMessage());
			e.printStackTrace();
		}
		(new PL_Interface_impl()).runRandomActions(1000);
	
	}


	public void start(int specification, int variation) {
		if (variation==-1) {
			if (specification==1) {
				test_1_addressBook_encrypt();
			} else if (specification==3) {
				test_3_sign_verify();
			} else if (specification==4) {
				test_4_sign_forward();
			} else if (specification==6) {
				test_6_encrypt_decrypt();
			} else if (specification==7) {
				test_7_encrypt_verify();
			} else if (specification==8) {
				test_8_Encrypt_Autoresponder();
			} else if (specification==9) {
				test_9_Encrypt_Forward();
			} else if (specification==11) {
				test_11_decrypt_autoresponder();
			} else if (specification==27) {
				test_27_verify_forward();
			}
			if (Test_Actions.executedUnimplementedAction) {
//				System.out.println("Executed an unimplemented action!!");
			}
		} else {
			assert false;
			//runRandomActions(variation);
		}
		//Scenario.test();
	}


	public void checkOnlySpecification(int specID) {
		SpecificationManager.checkOnlySpecification(specID);
	}


	public List<String> getExecutedActions() {
		return Test_Actions.actionHistory;
	}


	public boolean isAbortedRun() {
		return Scenario.abortedRun;
	}



	public void runRandomActions(int maxLength) {
		Test_Actions.setup();
		int counter = 0;
		List<String> methodsToCall = new Vector<String>();

		// Only generate the method call sequence the first time
//		if(!new File(RunSPL.getLoopFilePath()).exists())
//		{		
			while (counter++ < maxLength) {
				int action = (int)(Math.random()*13); // Verify.getInt(0, 13);
				String methodName = null;

				switch (action) {
				case 0:
					methodName = "bobKeyAdd";
					break;
				case 1:
					methodName = "bobKeyAddChuck";
					break;
				case 2:
					methodName = "bobKeyChange";
					break;
				case 3:
					methodName = "bobSetAddressBook";
					break;
				case 4:
					methodName = "chuckKeyAdd";
					break;
				case 5:
					methodName = "rjhDeletePrivateKey";
					break;
				case 6:
					methodName = "rjhEnableForwarding";
					break;
				case 7:
					methodName = "rjhKeyAdd";
					break;
				case 8:
					methodName = "rjhKeyAddChuck";
					break;
				case 9:
					methodName = "rjhKeyChange";
					break;
				case 10:
					methodName = "rjhSetAutoRespond";
					break;
				case 11:
					methodName = "bobToAlias";
					break;
				case 12:
					methodName = "bobToRjh";
					break;
				case 13:
					methodName = "rjhToBob";
					break;
				default:
					throw new InternalError("Missed a case!");
				}
				methodsToCall.add(methodName);
			}
			StringBuffer methodsToCallStr = new StringBuffer();
			int scale = 10000;
			for(int i = 0; i < scale; i++)
			{
				for(String m: methodsToCall)
					methodsToCallStr.append(m + "\n");
			}
//			JavaUtility.INSTANCE.writeToFile(RunSPL.getLoopFilePath(), methodsToCallStr.toString());
//		}
//		else
//		{		
//			for(String m: JavaUtility.INSTANCE.getFileContents(RunSPL.getLoopFilePath()).split("\\n"))
//				methodsToCall.add(m);			
//		}

		for(String m: methodsToCall)
		{
			try
			{
				Test_Actions.class.getMethod(m, (Class[])null).invoke(null, (Object[])null);
				System.out.println("random method: " + m);

				if (Test_Actions.executedUnimplementedAction) {
					//"invalid" path
					System.out.println("returning from random action");
					//	break;
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	} 


	static void test_1_addressBook_encrypt() {
		Test_Actions.setup();
		Test_Actions.bobKeyAdd();
		Test_Actions.bobSetAddressBook();
		Test_Actions.bobToAlias();
	}


	static void test_3_sign_verify() {
		Test_Actions.setup();
		Test_Actions.rjhKeyAdd();
		Test_Actions.bobKeyChange();
		Test_Actions.bobToRjh();
	}


	static void test_4_sign_forward() {
		Test_Actions.setup();
		Test_Actions.rjhDeletePrivateKey();
		Test_Actions.rjhKeyAdd();
		Test_Actions.chuckKeyAdd();
		Test_Actions.rjhEnableForwarding();
		Test_Actions.bobToRjh();
	}


	static void test_6_encrypt_decrypt() {
		Test_Actions.setup();
		Test_Actions.bobKeyAdd();
		Test_Actions.rjhKeyChange();
		Test_Actions.bobToRjh();
	}


	static void test_7_encrypt_verify() {
		Test_Actions.setup();
		Test_Actions.bobKeyAdd();
		// rjhKeyAdd();
		Test_Actions.rjhKeyChange();
		Test_Actions.bobToRjh();
	}


	static void test_8_Encrypt_Autoresponder() {
		Test_Actions.setup();
		Test_Actions.bobKeyAdd();
		Test_Actions.rjhSetAutoRespond();
		Test_Actions.bobToRjh();
	}


	static void test_9_Encrypt_Forward() {
		Test_Actions.setup();
		Test_Actions.bobKeyAdd();
		Test_Actions.rjhEnableForwarding();
		Test_Actions.bobToRjh();
	}


	static void test_11_decrypt_autoresponder() {
		Test_Actions.setup();
		Test_Actions.bobKeyAdd();
		Test_Actions.rjhSetAutoRespond();
		Test_Actions.rjhKeyChange();
		Test_Actions.bobToRjh();
	}


	static void test_27_verify_forward() {
		Test_Actions.setup();
		Test_Actions.rjhDeletePrivateKey();
		Test_Actions.rjhKeyAdd();
		Test_Actions.rjhEnableForwarding();
		Test_Actions.bobToRjh();
	}


}
