package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.features.Logging;
import org.softlang.features.OrderedCut;
import org.softlang.features.Precedence;
import org.softlang.features.SimpleCut;

/**
 * Test cases related to observability
 */
public class TestObeservability extends CompaniesTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
		String strTestName = testName.getMethodName();
		if (strTestName.equals("testLogging")) {
//			CompaniesVariables.getSINGLETON().setLOGGING___(true);
//			CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
		} else  if (strTestName.equals("testPrecedence")) {
//			CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
//			CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(true);
		} else {
			System.err.printf("%s did not set default configuration",
					strTestName);
		}
	}

	private static CompanyImpl sampleCompany;

	@Before
	public void createSampleCompany() {
		sampleCompany = (CompanyImpl) TestBasics
				.createSampleCompany(new BeanFactory());
	}

	/**
	 * Test Logging feature
	 */
	@Test
	public void testLogging() {
		Logging log = new Logging();
		((CompanyImpl) sampleCompany).addObserver(log);
		SimpleCut cut = new SimpleCut();
		cut.postorder(sampleCompany);
		assertEquals(7, log.getSize());
	}

	/**
	 * Test Precedence feature
	 */
	@Test
	public void testPrecedence() {
		Precedence prec = new Precedence();
		((CompanyImpl) sampleCompany).addObserver(prec);
		OrderedCut cut = new OrderedCut();
		cut.postorder(sampleCompany);
	}
}
