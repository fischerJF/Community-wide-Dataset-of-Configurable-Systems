package tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.softlang.company.factory.PojoFactory;
import org.softlang.swing.model.Model;

import splat.CompaniesVariables;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  NestedIfBugTest.TestBug.class
})
public class NestedIfBugTest {
  

  /**
   * The TOTAL_REDUCER and TOTAL_WALKER features are supposed to be mutually
   * exclusive. However, an invalid product like ?,?,1,1,1,1,?,1,1,? can pass in
   * this test, and a valid product (ex: ?,?,?,?,?,1,?,0,1,?) fails.
   * 
   * Check the first and second "if" condition in the Model.getTotal() method
   * to see why this is happening. 
   * 
   * @author mateus
   * 
   */
  
  public static class TestBug extends CompaniesTest{ 
    
    @Test
    public void test() {
      if (CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___() ||
          CompaniesVariables.getSINGLETON().isTOTAL_WALKER___()) {
        Model m = new Model(new PojoFactory());
        m.setCurrentValue(m.getCompany());
//        Assert.assertNotEquals(m.getTotal(), "");
      }
    }
  }
  
}
