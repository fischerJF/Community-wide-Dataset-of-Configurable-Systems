package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import splat.JTopasVariables;


public abstract class JTopasTest {
  
  @Rule 
  public TestName testName = new TestName();
  
//  @Rule
//  public Timeout globalTimeout = new Timeout(15000);


  @Before
  public void setup() {
        configure();
  }
  
  protected void configure() {
    JTopasVariables.getSINGLETON().setBASE___(true);
  }
  
  @After
  public void teardown() {
//    JTopasVariables.getSINGLETON().reset();
//    System.out.println(JTopasVariables.getSINGLETON().toString());
  }
  
}