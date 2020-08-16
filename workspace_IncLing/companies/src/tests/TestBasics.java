package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.features.SimpleCut;
import org.softlang.features.TotalReducer;
import org.softlang.features.TotalWalker;

import specifications.Configuration;

/**
 * Test/demonstrate basic operations for totaling and cutting salaries.
 */
public class TestBasics extends CompaniesTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		// if (testName == null) {
		// throw new RuntimeException();
		// }
		// String strTestName = testName.getMethodName();
		// if (strTestName.equals("testCutPojo") || strTestName.equals("testCutBean")) {
		//// CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
		//// CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
		// } else if (strTestName.equals("testTotalPojo")
		// || strTestName.equals("testTotalBean")) {
		// // it works with no feature enabled
		// } else {
		// System.err.printf("%s did not set default configuration", strTestName);
		// }
	}

	@Test
	public void testCutPojo() {
		// Assume.assumeTrue(CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___());

//		Configuration.TOTAL_REDUCER = true;
//		Configuration.CUT_WHATEVER = true;
		if (Configuration.TOTAL_REDUCER && Configuration.CUT_WHATEVER) {
			Company sampleCompany = createSampleCompany(new PojoFactory());
			TotalReducer total = new TotalReducer();
			SimpleCut cut = new SimpleCut();
			double before = total.reduce(sampleCompany);
			cut.postorder(sampleCompany);
			double after = total.reduce(sampleCompany);
			assertEquals(before / 2.0d, after, 0);
		}
	}

	@Test
	public void testCutBean() {
		// Assume.assumeTrue(CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___());
//		Configuration.TOTAL_REDUCER = true;
//		Configuration.CUT_WHATEVER = true;
		if (Configuration.TOTAL_REDUCER && Configuration.CUT_WHATEVER) {
			Company sampleCompany = createSampleCompany(new BeanFactory());
			TotalReducer total = new TotalReducer();
			SimpleCut cut = new SimpleCut();
			double before = total.reduce(sampleCompany);
			cut.postorder(sampleCompany);
			double after = total.reduce(sampleCompany);
			assertEquals(before / 2.0d, after, 0);
		}
	}

	@Test
	public void testTotalPojo() {
		Company sampleCompany = createSampleCompany(new PojoFactory());
//		Configuration.TOTAL_REDUCER=true;
		if (Configuration.TOTAL_REDUCER) {
			TotalReducer reducer = new TotalReducer();
			assertEquals(399747, reducer.reduce(sampleCompany), 0);
			reducer.reduce(sampleCompany);
		}
//		Configuration.TOTAL_WALKER=true;
		if (Configuration.TOTAL_WALKER) {
			TotalWalker walker = new TotalWalker();
			walker.preorder(sampleCompany);
			assertEquals(399747, walker.getTotal(), 0);
			walker.getTotal();
		}
	}

	// @Override
	// protected void configure() {
	// // set mandatory features
	// super.configure();
	// if (testName == null) {
	// throw new RuntimeException();
	// }
	// String strTestName = testName.getMethodName();
	// if (strTestName.equals("testCutPojo") || strTestName.equals("testCutBean"))
	// {
	//// CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
	//// CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
	// } else if (strTestName.equals("testTotalPojo")
	// || strTestName.equals("testTotalBean")) {
	// // it works with no feature enabled
	// } else {
	// System.err.printf("%s did not set default configuration", strTestName);
	// }
	// }

	// @Test
	public void testTotalBean() {
		Company sampleCompany = createSampleCompany(new BeanFactory());
//		Configuration.TOTAL_REDUCER=true;
//		Configuration.TOTAL_WALKER=true;
		 if (Configuration.TOTAL_REDUCER) {
		 TotalReducer reducer = new TotalReducer();
		 assertEquals(399747, reducer.reduce(sampleCompany), 0);
//		 assertEquals(CompaniesVariables.getSINGLETON().isGUI___() ? 399747 :
//		 0,
//		 reducer.reduce(sampleCompany), 0);
//		
		 reducer.reduce(sampleCompany);
		 }

		 if (Configuration.TOTAL_WALKER) {
		 TotalWalker walker = new TotalWalker();
		 walker.preorder(sampleCompany);
		 assertEquals(399747, walker.getTotal(), 0);
//		 assertEquals(CompaniesVariables.getSINGLETON().isGUI___() ? 399747 :
//		 0,
		 // walker.getTotal(), 0);
		 }
	}

	static Company createSampleCompany(Factory f) {

		// Create company
		Company sampleCompany = f.mkCompany();
		sampleCompany.setName("meganalysis");

		// Create all employees
		Employee craig = f.mkEmployee();
		craig.setName("Craig");
		craig.setAddress("Redmond");
		craig.setSalary(123456);
		craig.setManager(true);

		Employee erik = f.mkEmployee();
		erik.setName("Erik");
		erik.setAddress("Utrecht");
		erik.setSalary(12345);

		Employee ralf = f.mkEmployee();
		ralf.setName("Ralf");
		ralf.setAddress("Koblenz");
		ralf.setSalary(1234);

		Employee ray = f.mkEmployee();
		ray.setName("Ray");
		ray.setAddress("Redmond");
		ray.setSalary(234567);
		ray.setManager(true);

		Employee klaus = f.mkEmployee();
		klaus.setName("Klaus");
		klaus.setAddress("Boston");
		klaus.setSalary(23456);
		klaus.setManager(true);

		Employee karl = f.mkEmployee();
		karl.setName("Karl");
		karl.setAddress("Riga");
		karl.setSalary(2345);
		karl.setManager(true);

		Employee joe = f.mkEmployee();
		joe.setName("Joe");
		joe.setAddress("Wifi City");
		joe.setSalary(2344);

		// Create research department
		Department research = f.mkDepartment();
		research.setName("Research");
		research.add(craig);
		research.add(erik);
		research.add(ralf);
		sampleCompany.add(research);

		// Create development department
		Department development = f.mkDepartment();
		development.setName("Development");
		development.add(ray);
		sampleCompany.add(development);

		// Create sub-department dev1
		Department dev1 = f.mkDepartment();
		dev1.setName("Dev1");
		dev1.add(klaus);
		development.add(dev1);

		// Create sub-department dev11
		Department dev11 = f.mkDepartment();
		dev11.setName("Dev1.1");
		dev11.add(karl);
		dev11.add(joe);
		dev1.add(dev11);

		return sampleCompany;
	}

}
