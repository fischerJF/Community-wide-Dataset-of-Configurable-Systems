package TestSpecifications;

import specifications.Configuration;

public class SpecificationManager {

	public static void setupSpecifications__before__encrypt() {
	}

	public static void setupSpecifications__role__encrypt() {
		spec1_8 = new Specification1_8();
		spec9 = new Specification9();
		spec6 = new Specification6();
		setupSpecifications__before__encrypt();
	}

	public static void setupSpecifications__before__autoresponder() {
		if (Configuration.ENCRYPT) {
			setupSpecifications__role__encrypt();
		} else {
			setupSpecifications__before__encrypt();
		}
	}

	public static void setupSpecifications__role__autoresponder() {
		spec11 = new Specification11();
		setupSpecifications__before__autoresponder();
	}

	public static void setupSpecifications__before__sign() {
		if (Configuration.AUTORESPONDER) {
			setupSpecifications__role__autoresponder();
		} else {
			setupSpecifications__before__autoresponder();
		}
	}

	public static void setupSpecifications__role__sign() {
		spec3 = new Specification3();
		spec4 = new Specification4();
		setupSpecifications__before__sign();
	}

	public static void setupSpecifications__before__verify() {
		if (Configuration.SIGN) {
			setupSpecifications__role__sign();
		} else {
			setupSpecifications__before__sign();
		}
	}

	public static void setupSpecifications__role__verify() {
		spec7 = new Specification7();
		spec27 = new Specification27();
		setupSpecifications__before__verify();
	}

	public static void setupSpecifications() {
		if (Configuration.VERIFY) {
			setupSpecifications__role__verify();
		} else {
			setupSpecifications__before__verify();
		}
	}

	/**
	 * -1 : all Specifications of enabled Features -2 : no Specifications else :
	 * only specification with given number
	 * 
	 * @param specificationID
	 * @return
	 */
	public static boolean checkSpecification(int id) {
		if (singleSpecification == -2)
			return false;
		else if (singleSpecification == -1)
			return true;
		else
			return singleSpecification == id;
	}

	private static int singleSpecification = -10000;

	public static void checkOnlySpecification(int scenario) {
		singleSpecification = scenario;
	}

	public static Specification1_8 spec1_8;

	public static Specification9 spec9;

	public static Specification6 spec6;

	public static Specification11 spec11;

	public static Specification3 spec3;

	public static Specification4 spec4;

	public static Specification7 spec7;

	public static Specification27 spec27;

}
