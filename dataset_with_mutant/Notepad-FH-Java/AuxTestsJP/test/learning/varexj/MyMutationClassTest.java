package learning.varexj;

import org.junit.Test;

import gov.nasa.jpf.util.test.TestJPF;

public class MyMutationClassTest extends TestJPF {

	MyMutantClass tester = new MyMutantClass(); 
	
@Test
public void allTest(){
	
	if (verifyNoPropertyViolation(VarexJConstants.JPF_CONFIGURATION)) {
		
		testExceptionIsThrown();
		testMultiply();
	}
		
}
	
//	@Test(expected = IllegalArgumentException.class)
	public void testExceptionIsThrown() {
		if (verifyNoPropertyViolation(VarexJConstants.JPF_CONFIGURATION)) {
			try {
				tester.multiply(1000, 5);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testMultiply() {
		if (verifyNoPropertyViolation(VarexJConstants.JPF_CONFIGURATION)) {
			try {
				assertEquals("10 x 5 must be 50.", 50, tester.multiply(10, 5));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
