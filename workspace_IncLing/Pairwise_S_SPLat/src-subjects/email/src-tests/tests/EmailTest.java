package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import splat.EmailVariables;

public abstract class EmailTest {

	@Rule
	public TestName testName = new TestName();
	
//	@Rule
//  public Timeout globalTimeout = new Timeout(30000);

	@Before
	public void setup() {
		configure();
	}

	protected void configure() {
		EmailVariables.getSINGLETON().setBASE___(true);
	}

	@After
	public void teardown() {
//		EmailVariables.getSINGLETON().reset();
	}

}