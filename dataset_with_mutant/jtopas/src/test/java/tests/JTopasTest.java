package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import specifications.Configuration;



public abstract class JTopasTest {
  
//  @Rule 
//  public TestName testName = new TestName();
  
//  @Rule
//  public Timeout globalTimeout = new Timeout(15000);


  @Before
  public void setup() {
        configure();
  }
  
  protected void configure() {
    Configuration.BASE=true;
  }
  
  @After
  public void teardown() {
//    JTopasVariables.getSINGLETON().reset();
//    System.out.println(JTopasVariables.getSINGLETON().toString());
  }
  
}