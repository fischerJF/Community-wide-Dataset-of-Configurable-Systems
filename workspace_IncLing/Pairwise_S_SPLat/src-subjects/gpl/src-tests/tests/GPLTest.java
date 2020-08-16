package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import smashed.Main;
import splat.GPLVariables;

public abstract class GPLTest {

  @Rule
  public TestName testName = new TestName();

//  @Rule
//  public Timeout globalTimeout = new Timeout(5000);

  @Before
  public void setup() {
    configure();
  }

  protected void configure() {
//     GPLVariables.getSINGLETON().setBASE___(true);
    // GPLVariables.getSINGLETON().setDIRECTED___(false);
    // GPLVariables.getSINGLETON().setUNDIRECTED___(false);
    // GPLVariables.getSINGLETON().setWEIGHTED___(false);
    // GPLVariables.getSINGLETON().setSEARCH___(false);
    // GPLVariables.getSINGLETON().setBFS___(false);
    // GPLVariables.getSINGLETON().setNUMBER___(false);
    // GPLVariables.getSINGLETON().setCONNECTED___(false);
    // GPLVariables.getSINGLETON().setSTRONGLYCONNECTED___(false);
    // GPLVariables.getSINGLETON().setCYCLE___(false);
    // GPLVariables.getSINGLETON().setMSTPRIM___(false);
    // GPLVariables.getSINGLETON().setMSTKRUSKAL___(false);
    // GPLVariables.getSINGLETON().setSHORTEST___(false);
  }

  @After
  public void teardown() {
//    System.out.println(GPLVariables.getSINGLETON().toString());
//    GPLVariables.getSINGLETON().restore();
    Main.testOps.clear();
  }

}