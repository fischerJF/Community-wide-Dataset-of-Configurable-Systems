package tests;

import static org.junit.Assert.assertEquals;
import net.sf.zipme.Deflater;
import net.sf.zipme.Deflater_deflate2;
import specifications.Configuration;

import org.junit.After;
import org.junit.Test;


public class CompressAdlerCSTests extends ZipMeTest{

  @Test
  /*
   * Contains:
   *  -net.sf.zipme.Deflater.getAdler()                                              
   *  -net.sf.zipme.Deflater_deflate2.hook22()                                         
   *  -net.sf.zipme.Deflater_deflate2.hook23()                                        
   *  -net.sf.zipme.DeflaterEngine.getAdler()                                       
   *  -net.sf.zipme.DeflaterEngine.hook26()                                             
   *  -net.sf.zipme.DeflaterEngine.hook27()                                           
   *  -net.sf.zipme.DeflaterEngine.hook28(int)                                         
   *  -net.sf.zipme.DeflaterEngine.hook29(byte[], int, int)                            
   *  -net.sf.zipme.DeflaterEngine.resetAdler()                                       
   */
  public void test1() {
    //Features
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_ADLER32CHECKSUM___(true);
//    ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
//    ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);
    
//	  Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM=true;
//	  Configuration.COMPRESS=true; 
//	  Configuration.ADLER32CHECKSUM=true;
//	  
    if(Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM && Configuration.COMPRESS && Configuration.ADLER32CHECKSUM) {
    //Variables
    byte[] b ={0};
    Deflater d = new Deflater();
    Deflater_deflate2 d2 = new Deflater_deflate2(d, b, 0, 1);
    
    assertEquals(d.getAdler(), 1); //Default starting adler checksum value == 1

    d.engine.adler.checksum = 2;
    assertEquals(d.engine.getAdler(), 2);
    d2.hook22();
    assertEquals(d2.chksum, 2);
    assertEquals(d.engine.adler.checksum, 1); //resetAdler in hook22()
    
    d2.hook23();
    assertEquals(d2.adler, 1);
    
    d.engine.adler = null;
    d.engine.hook26();
    assertEquals(d.engine.adler.checksum, 1);
    
    d.engine.adler.checksum = 23;
    d.engine.hook27();
    assertEquals(d.engine.adler.checksum, 1);
    
    d.engine.inputBuf = b;
    d.engine.hook28(1);
    assertEquals(d.engine.adler.checksum, 65537);
    
    d.engine.adler.checksum = 1;
    d.engine.hook29(b, 0, 1);
    assertEquals(d.engine.adler.checksum, 65537);
    }
    }
  
  @After
  public void teardown(){
//    ZipMeVariables.getSINGLETON().restore();
  }

}
