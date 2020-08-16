package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import specifications.Configuration;


public abstract class CompaniesTest {

//	@Rule
//	public TestName testName = new TestName();
//	
//	@Rule
//  public Timeout globalTimeout = new Timeout(10000);

	@Before
	public void setup() {
		configure();
		
	}

	protected void configure() {
		//basic variable mandatory for all products
	  
//	  //[1,1,1,0,0,1,0,1,0,?]
//	  //[1,1,1,1,0,1,1,1,0,1]
//     CompaniesVariables.getSINGLETON().setACCESS_CONTROL___(true);
//     CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
//     CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(false);
//     CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(false);
//     CompaniesVariables.getSINGLETON().setGUI___(true);
//     CompaniesVariables.getSINGLETON().setLOGGING___(false);
//     CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
//     CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(false);
////     CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(falseCompaniesVariables.getSINGLETON().);
//	  
	}

	@After
	public void teardown() {
//		CompaniesVariables.getSINGLETON().reset();
	}

}