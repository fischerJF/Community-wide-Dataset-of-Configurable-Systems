package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.softlang.command.CutCompany;
import org.softlang.company.Company;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.features.TotalReducer;

import specifications.Configuration;

public class TestUndo extends CompaniesTest {

	// @Override
	// protected void configure() {
	// // set mandatory features
	// super.configure();
	// if (testName == null) {
	// throw new RuntimeException();
	// }
	// String strTestName = testName.getMethodName();
	// if (strTestName.equals("testUndoPojo")
	// || strTestName.equals("testUndoBean")) {
	// // CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
	// // CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
	// } else {
	// System.err.printf("%s did not set default configuration", strTestName);
	// }
	// }

	// @Test
	public void testUndoPojo() {
		// Assume.assumeTrue(CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___());
//		Configuration.TOTAL_REDUCER = true;
//		Configuration.CUT_NO_DEPARTMENT = true;
		if (Configuration.TOTAL_REDUCER && Configuration.CUT_NO_DEPARTMENT) {
			Company sampleCompany = TestBasics.createSampleCompany(new PojoFactory());
			TotalReducer total = new TotalReducer();
			double before = total.reduce(sampleCompany);
			assertEquals(399747, before, 0);
			CutCompany cut = new CutCompany(sampleCompany);
			assertEquals(before, total.reduce(sampleCompany), 0);
			cut.execute();
			assertEquals(before / 2.0, total.reduce(sampleCompany), 0);
			cut.undo();
			assertEquals(before, total.reduce(sampleCompany), 0);
		}
	}

//	@Test
	public void testUndoBean() {
//		Configuration.TOTAL_REDUCER = true;
//		Configuration.CUT_NO_DEPARTMENT = true;
		if (Configuration.TOTAL_REDUCER && Configuration.CUT_NO_DEPARTMENT) {
			Company sampleCompany = TestBasics.createSampleCompany(new BeanFactory());
			TotalReducer total = new TotalReducer();
			double before = total.reduce(sampleCompany);
			assertEquals(399747, before, 0);
			CutCompany cut = new CutCompany(sampleCompany);
			assertEquals(before, total.reduce(sampleCompany), 0);
			cut.execute();
			assertEquals(before / 2.0, total.reduce(sampleCompany), 0);
			cut.undo();
			assertEquals(before, total.reduce(sampleCompany), 0);
		}
	}

}
