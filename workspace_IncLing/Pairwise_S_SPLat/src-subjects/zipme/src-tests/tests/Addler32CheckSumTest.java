package tests;

import static org.junit.Assert.assertEquals;
import net.sf.zipme.Adler32;
import net.sf.zipme.DataFormatException;
import net.sf.zipme.Inflater;

import org.junit.After;
import org.junit.Test;

import splat.ZipMeVariables;

public class Addler32CheckSumTest extends ZipMeTest{

  @Test
  /*
   *Contains:
   * -net.sf.zipme.Adler32.Adler32()                                                  
   * -net.sf.zipme.Adler32.getValue()                                                 
   * -net.sf.zipme.Adler32.reset()                                                    
   * -net.sf.zipme.Adler32.update(byte[], int, int)                                   
   * -net.sf.zipme.Adler32.update(byte[])                                             
   * -net.sf.zipme.Adler32.update(int)                                                
   */
  public void adler32Tests() {
    //Setting features
//    ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);
    //Test Variables
    Adler32 a;
    byte[] b = {0};    //byte[] with length == 0
    
    //Testing Methods
    a = new Adler32();            //Constructor activates reset()
    assertEquals(a.checksum, 1);  //Reset starts checksum as 1
    
    a.update(0);                     //Using simple update parameters to help testing:
    assertEquals(a.checksum, 65537); //As a.checksum == 1 and the parameter(bval) == 0
                                     //the result is : (1 << 16) + 1 = 65536 + 1
    
    a.reset();                        //Returning checksum to 1   
    assertEquals(a.checksum, 1);      //Better safe than sorry
    a.update(b);                      //New update method needs a byte[] type input
                                //As we used a single byte array with the same value as before
    assertEquals(a.checksum, 65537);  //We expect the same result
    
    assertEquals(a.getValue(), 65537);//Returns a.checksum
  }
  
  
  @Test
  /*
   * Contains:
   * -net.sf.zipme.Inflater.end()                                                             
   * -net.sf.zipme.Inflater.hook32()                                                  
   * -net.sf.zipme.Inflater.hook33(byte[], int, int)  4
   */                                
  public void InflaterAdlerTests(){
    //Setting features
//    ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);
    //Test Variables 
    byte[] b = {0};

    Inflater i = new Inflater(true);
    assertEquals(i.adler.checksum, 1);//hook32 reference in constructor resets checksum to 1
    try {
      i.hook33(b, 0, 1);              //Reference of adler32.update, using same parameters
    } catch (DataFormatException e) {
      e.printStackTrace();
    }
    assertEquals(i.adler.checksum, 65537);//Same results as addler32 tests
    
    i.end();                      //end makes adler == null
    assertEquals(i.adler, null);
  }
  

  @After
  public void teardown(){
//    ZipMeVariables.getSINGLETON().restore();
  }
}
