package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.company.impl.bean.EmployeeImpl;
import org.softlang.features.Logging;
import org.softlang.features.Precedence;

import splat.CompaniesVariables;

public class Pilot_CommandLine extends CompaniesTest {

  @Before
  public void setup() {
//    CompaniesVariables.getSINGLETON().setGUI___(false);
//    CompaniesVariables.getSINGLETON().setLOGGING___(true);
  }

  @Test
  public void test5() {
    // Create company

    // CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);

    CompanyImpl samplecomp = new CompanyImpl();
    Logging l = new Logging();

    samplecomp.addObserver(l);
    samplecomp.setName("company1");

    assertEquals(samplecomp.str, "LINE NO:34 at method:Logging.update"); // CHECKS

    samplecomp.str = "";
    samplecomp.deleteObserver(l);

    samplecomp.setName("company2");
    assertFalse(samplecomp.str.equals("LINE NO:34 at method:Logging.update"));
  }

  @Test
  public void test6PreTrue() {
    CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);

    EmployeeImpl sampleEmp = new EmployeeImpl();
    sampleEmp.setName("Divya");
    sampleEmp.setAddress("Austin,TX");
    sampleEmp.setManager(true);
    sampleEmp.setSalary(10);

    Logging l = new Logging();
    sampleEmp.addObserver(l);
    sampleEmp.setSalary(50);

    assertEquals(10, (int) sampleEmp.getOldSalary());
    assertEquals(sampleEmp.str, "LINE NO:34 at method:Logging.update"); // checks
                                                                        // notifyobservers
                                                                        // of
                                                                        // setSalary
    assertEquals(50, (int) sampleEmp.getSalary());
    assertEquals("Divya", sampleEmp.getName());// checks if the name of the
                                               // company were changed
    assertEquals("Austin,TX", sampleEmp.getAddress());

    assertEquals(true, sampleEmp.getManager());

    // assertEquals(sampleCompany.companyStr,"LINE NUM:54at METHOD NAME:addObserver");
  }

  @Test
  public void test6() {

    EmployeeImpl sampleEmp = new EmployeeImpl();
    sampleEmp.setName("Divya");
    sampleEmp.setAddress("Austin,TX");
    sampleEmp.setManager(true);
    sampleEmp.setSalary(10);

    Logging l = new Logging();
    sampleEmp.addObserver(l);
    sampleEmp.setSalary(50);

    assertEquals(sampleEmp.str, "LINE NO:34 at method:Logging.update"); // checks
                                                                        // notifyobservers
                                                                        // of
                                                                        // setSalary
    assertEquals(50, (int) sampleEmp.getSalary());
    assertEquals("Divya", sampleEmp.getName());// checks if the name of the
                                               // company were changed
    assertEquals("Austin,TX", sampleEmp.getAddress());

    assertEquals(true, sampleEmp.getManager());

    // assertEquals(sampleCompany.companyStr,"LINE NUM:54at METHOD NAME:addObserver");
  }

  @Test
  public void test7() {
    CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);

    // Create company
    CompanyImpl sampleCompany = new CompanyImpl();
    Logging log = new Logging();
    sampleCompany.addObserver(log);
    Precedence pre = new Precedence();
    sampleCompany.addObserver(pre);
    // / assertTrue(sampleCompany.observerAdded);//checks if observers were
    // added to the subunits
    assertEquals(2, sampleCompany.countObservers());// checks if observers were
                                                    // added to sampleCompany
  }

  @After
  public void teardown() {
    //System.out.println(CompaniesVariables.getSINGLETON().toString());
//    CompaniesVariables.getSINGLETON().restore();
  }

}
