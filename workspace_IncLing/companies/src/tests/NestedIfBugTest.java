package tests;

import static org.junit.Assert.assertNotEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.softlang.company.factory.PojoFactory;
import org.softlang.swing.model.Model;

import specifications.Configuration;

@RunWith(Suite.class)
@Suite.SuiteClasses({ NestedIfBugTest.TestBug.class })
public class NestedIfBugTest {

	/**
	 * The TOTAL_REDUCER and TOTAL_WALKER features are supposed to be mutually
	 * exclusive. However, an invalid product like ?,?,1,1,1,1,?,1,1,? can pass in
	 * this test, and a valid product (ex: ?,?,?,?,?,1,?,0,1,?) fails.
	 * 
	 * Check the first and second "if" condition in the Model.getTotal() method to
	 * see why this is happening.
	 * 
	 * @author mateus
	 * 
	 */

	public static class TestBug extends CompaniesTest {

		@Test
		public void test() {
//			Configuration.TOTAL_REDUCER = true;
//			Configuration.TOTAL_WALKER = true;
			if (Configuration.TOTAL_REDUCER || Configuration.TOTAL_WALKER) {
				Model m = new Model(new PojoFactory());
				m.setCurrentValue(m.getCompany());
				assertNotEquals(m.getTotal(), "");
			}
		}
	}

}
