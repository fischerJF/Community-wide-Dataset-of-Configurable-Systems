package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.impl.bean.EmployeeImpl;
import org.softlang.features.Logging;

import specifications.Configuration;

public class Pilot_REPAIR extends CompaniesTest {

	@Test
	public void test6() {
//		Configuration.LOGGING=true;
//		Configuration.PRECEDENCE=false;
		
		if (Configuration.LOGGING) {
			EmployeeImpl sampleEmp = new EmployeeImpl();
			sampleEmp.setName("Divya");
			sampleEmp.setAddress("Austin,TX");
			sampleEmp.setManager(true);
			sampleEmp.setSalary(10);
			Logging l = new Logging();
			sampleEmp.addObserver(l);
			sampleEmp.setSalary(50);
			 if (!Configuration.PRECEDENCE) {//REPAIR
				 assertEquals(-1, (int) sampleEmp.getOldSalary());
			 }
			assertEquals(sampleEmp.str, "LINE NO:34 at method:Logging.update"); // checks
																				// notifyobservers
																				// of
																				// setSalary
			assertEquals(50, (int) sampleEmp.getSalary());
			assertEquals("Divya", sampleEmp.getName());// checks if the name of the
														// company were changed
			assertEquals("Austin,TX", sampleEmp.getAddress());
			assertEquals(true, sampleEmp.getManager());
			// assertEquals(sampleCompany.companyStr,"LINE NUM:54at METHOD
			// NAME:addObserver");
		}
	}

}