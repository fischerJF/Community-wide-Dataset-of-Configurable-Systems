package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.Timeout;

import splat.SudokuVariables;

public abstract class SudokuTest {

  @Rule
  public TestName testName = new TestName();
  
//  @Rule
//  public Timeout globalTimeout = new Timeout(5000);


  @Before
  public void setup() {
    configure();
  }

  protected void configure() {
    SudokuVariables.getSINGLETON().setBASE___(true);
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