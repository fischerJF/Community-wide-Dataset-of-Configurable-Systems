package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sf.zipme.Adler32;
import net.sf.zipme.Deflater;
import net.sf.zipme.GZIPInputStream;
import net.sf.zipme.ZipArchive;
import net.sf.zipme.ZipEntry;
import net.sf.zipme.ZipException;
import net.sf.zipme.ZipInputStream;
import net.sf.zipme.ZipOutputStream;
import specifications.Configuration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Example_Paulo extends ZipMeTest{
  
  //gets the project path
  static String homeDir;
  static {
    try {
      homeDir = (new File(".")).getCanonicalPath();
    } catch (IOException e) {
      e.printStackTrace();
    }
  };

  @Before
  public void setup(){
    
  }
  
  /**
   * This test covers the 2 methods which access ARCHIVECHECK___
   * Satisfies: requirement1, requirement2, and requirement3.
   */
 // @Test
  public void testARCHIVECHECK() throws ZipException, IOException {
    FileInputStream zipFile = new FileInputStream(new File(homeDir + "/files/file.gz"));
    ZipArchive zipArchive = new ZipArchive(zipFile);
    
    //checkZipArchive() checks if the file is valid
    //ZipArchive calls hook1() that calls checkZipArchive()
    //If the test reaches this point with ARCHIVECHECK disabled and 
    // an invalid file, the size() will return 0;
    assertFalse(zipArchive.size() > 0);
  }
  
  /**
   * This test covers the 1 method that accesses DERIVATIVE_COMPRESS_CRC___ 
   * Satisfies: requirement1 for method hook41(), requirement2, and requirement3.
   */
 // @Test
  public void testDERIVATIVE_COMPRESS_CRC() throws IOException{
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_CRC___(true);
    
//	  Configuration.CRC=true;
//	  Configuration.DERIVATIVE_COMPRESS_CRC=true;
	  
//    if(Configuration.CRC && Configuration.DERIVATIVE_COMPRESS_CRC ) {
    ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(new File(
        homeDir + "/files/src.zip")));
    zout.crc.update(1);
    ZipEntry ze = new ZipEntry("C://");
    zout.putNextEntry(ze);
    
    //This happens because the test does not reach 
    //hook41() that resets the crc value, because 
    //DERIVATIVE_COMPRESS_CRC___ is disabled.
    assertFalse(zout.crc.crc == 0);
//    }
  }
  
  @Test
  public void testCOMPRESS__() throws IOException{
//    ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
//	  Configuration.COMPRESS=true;
    if(Configuration.COMPRESS) {
    Deflater deflater = new Deflater();
    byte[] buffer = new byte[32];
    int output = deflater.deflate(buffer);
    assertTrue(output != -1);
    }
  }
  
//  @Test
//  public void testGZIP__() throws IOException{
////    ZipMeVariables.getSINGLETON().setGZIP___(true);
//    GZIPInputStream is = new GZIPInputStream(new FileInputStream(new File (homeDir + "/files/src.zip")));
//    assertFalse(is.len > 0);
//  }
  
  @Test
  public void testEXTRACT__() throws IOException{
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);
//	  Configuration.EXTRACT=true;
    if(Configuration.EXTRACT) {
    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File (homeDir + "/files/src.zip")));
    assertTrue(zis.available() == 1);
    }
  }
  
  //@Test
  public void testCRC() throws IOException{
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//	  Configuration.CRC=true;
//    if(Configuration.CRC) {
    ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(new File(
        homeDir + "/files/src.zip")));
    zout.crc.update(1);
    ZipEntry ze = new ZipEntry("C://");
    zout.putNextEntry(ze);
    
    //This happens because the test does not reach 
    //hook41() that resets the crc value, because 
    //DERIVATIVE_COMPRESS_CRC___ is disabled.
    assertFalse(zout.crc.crc == 0);
//    }
  }
  
  @Test
  public void testADLER32CHECKSUM___() throws IOException{
//    ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);
//	  Configuration.ADLER32CHECKSUM=true;
    if(Configuration.ADLER32CHECKSUM) {
    Adler32 adler = new Adler32();
    byte[] buffer = new byte[32];
    adler.update(buffer);
    assertTrue(adler.getValue() != -1);
    }
  }
  
  @Test
  public void testDERIVATIVE_COMPRESS_ADLER32CHECKSUM___() throws IOException{
//    ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_ADLER32CHECKSUM___(true);
//	  Configuration.ADLER32CHECKSUM=true;
//	  Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM=true;
    if(Configuration.ADLER32CHECKSUM && Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM) {
    Adler32 adler = new Adler32();
    byte[] buffer = new byte[32];
    adler.update(buffer);
    assertTrue(adler.getValue() != -1);
    }
  }
  
//  @Test
//  public void testDERIVATIVE_COMPRESS_GZIP___() throws IOException{
////    ZipMeVariables.getSINGLETON().setGZIP___(true);
////    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIP___(true);
//    GZIPInputStream is = new GZIPInputStream(new FileInputStream(new File (homeDir + "/files/src.zip")));
//    assertFalse(is.len > 0);
//  }
  
  @Test
  public void testDERIVATIVE_GZIPCRC___() throws IOException{
//    ZipMeVariables.getSINGLETON().setGZIP___(true);
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_GZIPCRC___(true);
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);
//	  Configuration.GZIP=true;
//	  Configuration.CRC=true;
//	  Configuration.DERIVATIVE_GZIPCRC=true;
//	  Configuration.EXTRACT=true;
  if(Configuration.GZIP && Configuration.CRC && Configuration.DERIVATIVE_GZIPCRC &&  Configuration.EXTRACT) {  
    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File (homeDir + "/files/src.zip")));
    zis.hook();
    assertTrue(zis.available() == 1);
  }
  }
  
  //@Test
  public void testDERIVATIVE_COMPRESS_GZIPCRC___() throws IOException{
//    ZipMeVariables.getSINGLETON().setGZIP___(true);
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIPCRC___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_GZIPCRC___(true);
//	  Configuration.GZIP=true;
//	  Configuration.CRC=true;
//	  Configuration.DERIVATIVE_COMPRESS_GZIPCRC=true;
//	  Configuration.DERIVATIVE_GZIPCRC=true;
//	  
//    if(Configuration.GZIP && Configuration.CRC && Configuration.DERIVATIVE_COMPRESS_GZIPCRC && Configuration.DERIVATIVE_GZIPCRC) {
    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File (homeDir + "/files/src.zip")));
    zis.hook();
    assertTrue(zis.available() == -1);
    assertTrue(zis.crc.crc == 0);
//    }
  }
  
 // @Test
  public void testDERIVATIVE_EXTRACT_CRC___() throws IOException{
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_EXTRACT_CRC___(true);
//	  Configuration.CRC=true;
//	  Configuration.EXTRACT=true;
//	  Configuration.DERIVATIVE_EXTRACT_CRC=true;
//    if(Configuration.CRC && Configuration.EXTRACT && Configuration.DERIVATIVE_EXTRACT_CRC) {
    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File (homeDir + "/files/file.gz")));
    ZipEntry ze = zis.getNextEntry();
    assertTrue(ze != null);
//    }
  }
  

  @After
  public void tearDown(){
//    ZipMeVariables.getSINGLETON().restore();
  }
}
