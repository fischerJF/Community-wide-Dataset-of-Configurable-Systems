package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.softlang.company.Company;
import org.softlang.company.Employee;
import org.softlang.company.factory.Factory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.features.SimpleCut;
import org.softlang.features.TotalReducer;
import org.softlang.proxy.AccessControl;

public class TestProxying extends CompaniesTest {

  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String strTestName = testName.getMethodName();
    if (strTestName.equals("testTotal")
        || strTestName.equals("testEmployeeAccessControl")
        || strTestName.equals("testTotalException")) {
      // CompaniesVariables.getSINGLETON().setACCESS_CONTROL___(true);
      // CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
    } else if (strTestName.equals("testCut")) {
      // CompaniesVariables.getSINGLETON().setACCESS_CONTROL___(true);
      // CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(true);
      // CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
    } else if (strTestName.equals("testCutException")) {
      // CompaniesVariables.getSINGLETON().setACCESS_CONTROL___(true);
      // CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(true);
    } else {
      System.err.printf("%s did not set default configuration", strTestName);
    }

  }

  @Test
  public void testTotal() {
    // Assume.assumeTrue(CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___());
    Company sampleCompany = TestBasics.createSampleCompany(new PojoFactory());
    AccessControl ac = new AccessControl();
    ac.disableWriteAcccess();
    sampleCompany = ac.deploy(sampleCompany);
    TotalReducer reducer = new TotalReducer();
    assertEquals(399747, reducer.reduce(sampleCompany), 0);
  }

//  @Test
//  public void testEmployeeAccessControl() {
//    AccessControl ac = new AccessControl();
//    ac.disableWriteAcccess();
//    Factory f = new PojoFactory();
//    Employee ralf = f.mkEmployee();
//    ralf.setName("Ralf");
//    ralf.setAddress("Koblenz");
//    ralf.setSalary(1234);
//    Employee e = ac.deploy(ralf);
//    assertEquals(1234, e.getSalary(), 0);
//  }

  @Test(expected = IllegalArgumentException.class)
  public void testTotalException() {
    // Assume.assumeTrue(
    // (CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___()
    // ^ CompaniesVariables.getSINGLETON().isTOTAL_WALKER___()));
    Company sampleCompany = TestBasics.createSampleCompany(new PojoFactory());
    AccessControl ac = new AccessControl();
    ac.disableReadAcccess();
    sampleCompany = ac.deploy(sampleCompany);
    TotalReducer reducer = new TotalReducer();
    reducer.reduce(sampleCompany);
  }

//  @Test
//  public void testCut() {
//    // Assume.assumeTrue(CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___());
//    Company sampleCompany = TestBasics.createSampleCompany(new PojoFactory());
//    AccessControl ac = new AccessControl();
//    sampleCompany = ac.deploy(sampleCompany);
//    org.softlang.features.TotalReducer total = new org.softlang.features.TotalReducer();
//    org.softlang.features.SimpleCut cut = new org.softlang.features.SimpleCut();
//    double before = total.reduce(sampleCompany);
//    cut.postorder(sampleCompany);
//    double after = total.reduce(sampleCompany);
//    assertEquals(before / 2.0d, after, 0);
//  }

  @Test(expected = IllegalArgumentException.class)
  public void testCutException() {
    // Assume.assumeTrue(
    // (CompaniesVariables.getSINGLETON().isCUT_NO_DEPARTMENT___()
    // ^ CompaniesVariables.getSINGLETON().isCUT_NO_MANAGER___()
    // ^ CompaniesVariables.getSINGLETON().isCUT_WHATEVER___()));
    Company sampleCompany = TestBasics.createSampleCompany(new PojoFactory());
    AccessControl ac = new AccessControl();
    ac.disableWriteAcccess();
    sampleCompany = ac.deploy(sampleCompany);
    SimpleCut cut = new SimpleCut();
    cut.postorder(sampleCompany);
  }
}
