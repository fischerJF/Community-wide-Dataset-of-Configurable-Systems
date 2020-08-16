package learning.varexj;

import gov.nasa.jpf.annotation.Conditional;

public class MyMutantClass {

	/* contitional mutants */
	
	@Conditional
	public static boolean mut1 = false; 

	@Conditional
	public static boolean mut2 = false; 

//	@Conditional
	public static boolean mut3 = false; 

	/* end contitional mutants */

	/**
	 * Needed to run VarexJ directly.
	 * If not present, error message below is printed:
	 * [SEVERE] no static entry method: com.vogella.junit.first.MyClass.main([Ljava/lang/String;)V
	 */
	public static void main(String[] args) {
		MyMutantClass mc = new MyMutantClass();
		int out = mc.multiply(50, 7);
//		if (out == 350) {
//		}
	}
	
	/**
	 * target method for running test with VarexJ
	 */
	public int multiply(int x, int y) {
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Running MyMutantClass.multiply(int, int)");

		if (mut3) { // MUTATION 03
			if (x <= 999) {
				throw new IllegalArgumentException("X should be less than 1000");
			}
		}
		else { // NO MUTATION
			if (x > 999) {
				throw new IllegalArgumentException("X should be less than 1000");
			}
		}
		
		if (mut1) { // MUTATION 01
			return x / y;
		}
		else if (mut2) { // MUTATION 02
			return x + y;
		}
		else { // NO MUTATION
			return x * y;
		}
	}
}