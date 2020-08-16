package tests;

import java.util.Observer;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.softlang.company.Company;
import org.softlang.company.factory.BeanFactory;
import org.softlang.company.factory.PojoFactory;
import org.softlang.features.Logging;
import org.softlang.features.Precedence;
import org.softlang.features.TotalReducer;
import org.softlang.features.TotalWalker;
import org.softlang.proxy.AccessControl;
import org.softlang.swing.model.Model;

import splat.CompaniesVariables;

public class TestCombinations extends CompaniesTest {

  @Override
  protected void configure() {
    // set mandatory features
    super.configure();
    if (testName == null) {
      throw new RuntimeException();
    }
    String strTestName = testName.getMethodName();
    // if (strTestName.equals("cutWithAccessControl")) {
    // // [?, 1, 0, 1, ?, 0, 1, 0, 0, 1]
    // // CompaniesVariables.getSINGLETON().setTREE_STRUCTURE___(true);
    // CompaniesVariables.getSINGLETON().setLOGGING___(true);
    // CompaniesVariables.getSINGLETON().setCUT_WHATEVER___(false);
    // CompaniesVariables.getSINGLETON().setCUT_NO_DEPARTMENT___(true);
    // // CompaniesVariables.getSINGLETON().setCUT_NO_MANAGER___(true);
    // CompaniesVariables.getSINGLETON().setGUI___(false);
    // CompaniesVariables.getSINGLETON().setPRECEDENCE___(true);
    // CompaniesVariables.getSINGLETON().setTOTAL_WALKER___(false);
    // CompaniesVariables.getSINGLETON().setTOTAL_REDUCER___(false);
    // CompaniesVariables.getSINGLETON().setACCESS_CONTROL___(true);
    // System.out.println(CompaniesVariables.getSINGLETON().toString());
    // }
  }

  @Test
  public void cutWithPrecedence() {
    if (CompaniesVariables.getSINGLETON().isLOGGING___()) {
      if (CompaniesVariables.getSINGLETON().isCUT_NO_MANAGER___()) {
        Company c = TestBasics.createSampleCompany(new BeanFactory());
        Precedence p = new Precedence();
        addObserver(c, p);
        checkTotal(c, 399747);
        checkWithModel(c, 399747.0 / 2);
      }
    }
  }

  @Test
  public void cutWithLogging() {
    if (CompaniesVariables.getSINGLETON().isLOGGING___()) {
      Company c = TestBasics.createSampleCompany(new BeanFactory());
      Logging l = new Logging();
      addObserver(c, l);
      checkTotal(c, 399747);
      checkWithModel(c, 399747.0 / 2);
      Assert.assertEquals(l.getSize(), 7);
    }
  }

  @Test
  public void cutWithAccessControl() {
    if (CompaniesVariables.getSINGLETON().isACCESS_CONTROL___()) {
      Company c = TestBasics.createSampleCompany(new PojoFactory());
      AccessControl ac = new AccessControl();
      ac.disableReadAcccess();
      c = addAccessControl(ac, c);
      checkForDisabledReadAccess(c);
      ac.enableWriteAcccess();
      checkTotal(c, 399747);
      checkWithModel(c, 399747.0 / 2);
    }
  }

  private void checkForDisabledReadAccess(Company c) {
    try {
      if (CompaniesVariables.getSINGLETON().isTOTAL_WALKER___()) {
        TotalWalker tw = new TotalWalker();
        tw.postorder(c);
        Assert.assertTrue(false);
      } else if (CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___()) {
        TotalReducer reducer = new TotalReducer();
        reducer.reduce(c);
        Assert.assertTrue(false);
      }
    } catch (IllegalArgumentException e) {
      // expected assertion
    }
  }

  private void checkTotal(Company c, double expected) {
    if (CompaniesVariables.getSINGLETON().isTOTAL_WALKER___()) {
      TotalWalker tw = new TotalWalker();
      tw.postorder(c);
      double total = tw.getTotal();
      Assert.assertEquals(expected, total, 0.0001);
      // Assert.assertEquals(CompaniesVariables.getSINGLETON().isGUI___() ?
      // expected : 0, total,0.0001);
    } else if (CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___()) {
      TotalReducer reducer = new TotalReducer();
      double total = reducer.reduce(c);
      Assert.assertEquals(expected, total, 0.0001);
      // Assert.assertEquals(CompaniesVariables.getSINGLETON().isGUI___() ?
      // expected : 0, total,0.0001);
    }
  }

  private void checkWithModel(Company c, double expected) {
    // Assume.assumeTrue((CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___()
    // ^ CompaniesVariables.getSINGLETON().isTOTAL_WALKER___())
    // && (CompaniesVariables.getSINGLETON().isCUT_NO_DEPARTMENT___()
    // ^ CompaniesVariables.getSINGLETON().isCUT_NO_MANAGER___()
    // ^ CompaniesVariables.getSINGLETON().isCUT_WHATEVER___()));
    Model m = new Model(new BeanFactory());
    m.setCompany(c);
    m.setCurrentValue(c);
    m.cut();

    Double total = Double.parseDouble(m.getTotal());
    Assert.assertEquals(expected, total, 0.01);
    // Assert.assertEquals(CompaniesVariables.getSINGLETON().isGUI___() ?
    // expected : 0, total,0.01);
  }

  private Company addAccessControl(AccessControl ac, Company c) {
    return ac.deploy(c);
  }

  private Company addObserver(Company c, Observer obs) {
    Assert.assertTrue(c instanceof org.softlang.company.impl.bean.CompanyImpl);
    ((org.softlang.company.impl.bean.CompanyImpl) c).addObserver(obs);
    return c;
  }
}
