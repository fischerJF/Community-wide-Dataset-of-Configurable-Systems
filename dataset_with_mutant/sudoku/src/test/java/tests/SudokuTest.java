package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;

import specifications.Configuration;

public abstract class SudokuTest {

 // @Rule
  //public TestName testName = new TestName();
  
//  @Rule
//  public Timeout globalTimeout = new Timeout(5000);


  @Before
  public void setup() {
    configure();
  }

  protected void configure() {
    Configuration.BASE=true;
  }

  @After
  public void tearDown() throws FileNotFoundException{
//    SudokuVariables.getSingleton().restore();
    File f = new File("state1.txt");
    PrintWriter writer = new PrintWriter(f);
    writer.print("");
    writer.close();
  }

}