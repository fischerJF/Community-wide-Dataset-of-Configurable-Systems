package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import net.sf.zipme.ZipInputStream;

import org.junit.After;
import org.junit.Test;

import splat.ZipMeVariables;

public class ExtractTest extends ZipMeTest{

  @Test
  /*
   * Contains:
   * -net.sf.zipme.ZipInputStream.available()  
   * -net.sf.zipme.ZipInputStream.close() 
   * -net.sf.zipme.ZipInputStream.read(byte[], int, int)
   */
  public void basicsExtractTests() {
    
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);

    byte[] b = {1, 2, 3};
    ByteArrayInputStream in = new ByteArrayInputStream(b);
    ZipInputStream z = new ZipInputStream(in);
    
    try{
      assertEquals(z.entryAtEOF, false);
      assertEquals(z.available(),1);
      
      assertEquals(z.read(b, 0, 0), 0); 
      assertEquals(z.read(b, 0, 1), -1);
      
      z.close();
      assertEquals(z.entryAtEOF, true);
    }catch(IOException e){
      System.out.println(e);
    }  
    
  }
  
  @Test
  /*
   * Contains:
   * -net.sf.zipme.ZipInputStream.createZipEntry(String) 
   */
  public void createZipETest(){
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);

    byte[] b = {0 ,1 ,2 ,3};
    ByteArrayInputStream in = new ByteArrayInputStream(b);
    ZipInputStream z = new ZipInputStream(in);

    assertNotNull(z.createZipEntry("test"));
    
    
  }
  @After
  public void teardown(){
//    ZipMeVariables.getSINGLETON().restore();
  }
}
