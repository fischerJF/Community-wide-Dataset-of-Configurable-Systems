package email.verificationClasses;

import gov.nasa.jpf.jvm.Verify;

public class SPLModelChecker {
	public static boolean getBoolean() {
		//return(new java.util.Random()).nextBoolean();
		return Verify.getBoolean(false); //verify true first
		
		//return Verify.getBoolean();
		//return getBoolean2(true);
	}
/*	public static boolean getBoolean2(boolean x) {
		return x;
	}*/

	public static int getIntMinMax(int min, int max) {
		//return(new java.util.Random()).nextInt(max - min + 1)+min;
		return Verify.getInt(min, max);
	}
	
}
