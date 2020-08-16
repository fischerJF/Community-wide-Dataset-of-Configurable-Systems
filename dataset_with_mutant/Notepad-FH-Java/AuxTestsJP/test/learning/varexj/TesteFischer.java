package learning.varexj;

import org.junit.Test;

import gov.nasa.jpf.util.test.TestJPF;

public class TesteFischer extends TestJPF{

	
@Test
public void allTest(){
	
	if (verifyNoPropertyViolation(VarexJConstants.JPF_CONFIGURATION)) {
		MyMutationClassTest m = new MyMutationClassTest();
		m.testExceptionIsThrown();
		m.testMultiply();
	}
		
}

}
