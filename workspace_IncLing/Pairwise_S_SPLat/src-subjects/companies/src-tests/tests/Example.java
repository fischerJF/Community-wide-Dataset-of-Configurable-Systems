package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.softlang.company.impl.bean.CompanyImpl;
import org.softlang.features.Logging;
import org.softlang.features.Precedence;

import splat.CompaniesVariables;

public class Example extends CompaniesTest{
  
  @Test
  public void test_LOGGING_PRECEDENCE_bean_ComponentImpl_setName() {
    CompaniesVariables.getSINGLETON().setLOGGING___(true);
    // Create company
    CompanyImpl sampleCompany = new CompanyImpl();
    sampleCompany.setName("Company1");
    assertEquals("Company1", sampleCompany.getName());//checks if the name of the company was changed
  }
  
  @Test
  public void test_LOGGING_PRECEDENCE_bean_ComponentImpl_addObserver() {
    CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
    // Create company
    CompanyImpl sampleCompany = new CompanyImpl();
    Logging log = new Logging();
    sampleCompany.addObserver(log);
    Precedence pre = new Precedence();
    sampleCompany.addObserver(pre);
    assertEquals(2, sampleCompany.countObservers());//checks if observers were added to sampleCompany
  }
  
  @After
  public void teardown(){
//    CompaniesVariables.getSINGLETON().restore();
  }

}
