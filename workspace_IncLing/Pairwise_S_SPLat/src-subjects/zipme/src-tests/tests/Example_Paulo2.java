package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import net.sf.zipme.Adler32;
import net.sf.zipme.Deflater;
import net.sf.zipme.DeflaterOutputStream;
import net.sf.zipme.GZIPInputStream;
import net.sf.zipme.GZIPOutputStream;
import net.sf.zipme.ZipArchive;
import net.sf.zipme.ZipEntry;
import net.sf.zipme.ZipException;
import net.sf.zipme.ZipInputStream;
import net.sf.zipme.ZipOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import splat.ZipMeVariables;

public class Example_Paulo2 extends ZipMeTest {

  // gets the project path
  static String homeDir;
  static {
    try {
      homeDir = (new File(".")).getCanonicalPath();
    } catch (IOException e) {
      e.printStackTrace();
    }
  };

  @Before
  public void setup() {

  }

  /**
   * This test covers the 2 methods which access ARCHIVECHECK___ Satisfies:
   * requirement1, requirement2, and requirement3.
   */
  @Test
  public void testARCHIVECHECK() throws ZipException, IOException {
    // REPAIR
    // ZipMeVariables.getSINGLETON().setARCHIVECHECK___(false);
    FileInputStream zipFile = new FileInputStream(new File(homeDir
        + "/files/file.gz"));
    ZipArchive zipArchive = new ZipArchive(zipFile);

    // checkZipArchive() checks if the file is valid
    // ZipArchive calls hook1() that calls checkZipArchive()
    // If the test reaches this point with ARCHIVECHECK disabled and
    // an invalid file, the size() will return 0;
    assertFalse(zipArchive.size() > 0);
  }

  /**
   * This test covers the 1 method that accesses DERIVATIVE_COMPRESS_CRC___
   * Satisfies: requirement1 for method hook41(), requirement2, and
   * requirement3.
   */
  @Test
  public void testDERIVATIVE_COMPRESS_CRC() throws IOException {
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_CRC___(true);
    ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(new File(
        homeDir + "/files/src.zip")));
    zout.crc.update(1);
    ZipEntry ze = new ZipEntry("C://");
    zout.putNextEntry(ze);
    zout.hook41();
    assertTrue(zout.crc.crc == 0);

    zout.write(new byte[32], 0, 31);
    assertTrue(zout.size == 31);
    zout.closeEntry();
    assertTrue(ze.getCrc() == zout.crc.crc);

  }

  @Test
  public void testCOMPRESS__() throws IOException {
//    ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
    DeflaterOutputStream dos = new DeflaterOutputStream(new FileOutputStream(
        new File(homeDir + "/files/src.zip")));
    dos.deflate();
    Deflater deflater = new Deflater();
    byte[] buffer = new byte[32];
    int output = deflater.deflate(buffer);
    dos.write(new byte[32]);
    deflater.flush();
    boolean finished = deflater.finished();
    assertFalse(finished);
    deflater.finish();
    finished = deflater.finished();
    assertTrue(output != -1);
    finished = deflater.finished();
  }

//  @Test
//  public void testGZIP__() throws IOException {
////    ZipMeVariables.getSINGLETON().setGZIP___(true);
//    GZIPInputStream is = new GZIPInputStream(new FileInputStream(new File(
//        homeDir + "/files/src.zip")));
//    assertFalse(is.len > 0);
//    int answer = is.read();
//    is.close();
//    assertTrue(answer == -1);
//  }

  @Test
  public void testEXTRACT__() throws IOException {
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);
    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(
        homeDir + "/files/src.zip")));
    assertTrue(zis.available() == 1);
    int answer = zis.read();
    assertTrue(answer == -1);
    zis.close();
  }

  @Test
  public void testCRC() throws IOException {
//    ZipMeVariables.getSINGLETON().setCRC___(true);
    ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(new File(
        homeDir + "/files/src.zip")));
    zout.crc.update(1);
    ZipEntry ze = new ZipEntry("C://");
    zout.putNextEntry(ze);

    // This happens because the test does not reach
    // hook41() that resets the crc value, because
    // DERIVATIVE_COMPRESS_CRC___ is disabled.
    assertFalse(zout.crc.crc == 0);
    // REPAIR
    // if(!ZipMeVariables.getSINGLETON().isDERIVATIVE_COMPRESS_CRC___())
    // assertFalse(zout.crc.crc == 0);
  }

  @Test
  public void testADLER32CHECKSUM___() throws IOException {
//    ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);
    Adler32 adler = new Adler32();
    byte[] buffer = new byte[32];
    adler.update(buffer);
    assertTrue(adler.getValue() != -1);
  }

  @Test
  public void testDERIVATIVE_COMPRESS_ADLER32CHECKSUM___() throws IOException {
//    ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_ADLER32CHECKSUM___(
//        true);
    Adler32 adler = new Adler32();
    byte[] buffer = new byte[32];
    adler.update(buffer);
    assertTrue(adler.getValue() != -1);
  }

//  @Test
//  public void testDERIVATIVE_COMPRESS_GZIP___() throws IOException {
////    ZipMeVariables.getSINGLETON().setGZIP___(true);
////    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIP___(true);
//    GZIPOutputStream os = new GZIPOutputStream(new FileOutputStream(new File(
//        homeDir + "/files/file.gz")));
//    byte[] b1 = os.buf;
//    assertTrue(os.buf.length > 0);
//    os.close();
//    byte[] b2 = os.buf;
//    assertTrue(b1.equals(b2));
//  }

  @Test
  public void testDERIVATIVE_GZIPCRC___() throws IOException {
//    ZipMeVariables.getSINGLETON().setGZIP___(true);
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_GZIPCRC___(true);
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);

    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(
        homeDir + "/files/src.zip")));
    zis.hook();
    assertTrue(zis.available() == 1);
  }

  @Test
  public void testDERIVATIVE_COMPRESS_GZIPCRC___() throws IOException {
//    ZipMeVariables.getSINGLETON().setGZIP___(true);
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIPCRC___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_GZIPCRC___(true);
    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(
        homeDir + "/files/src.zip")));
    zis.hook();
    assertTrue(zis.available() == -1);
    // REPAIR
    // if (!ZipMeVariables.getSINGLETON().isEXTRACT___())
    // assertTrue(zis.available() == -1);
    // else assertFalse(zis.available() == -1);
    assertTrue(zis.crc.crc == 0);
  }

  @Test
  public void testDERIVATIVE_EXTRACT_CRC___() throws IOException {
//    ZipMeVariables.getSINGLETON().setCRC___(true);
//    ZipMeVariables.getSINGLETON().setEXTRACT___(true);
//    ZipMeVariables.getSINGLETON().setDERIVATIVE_EXTRACT_CRC___(true);
//    ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
    ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File(
        homeDir + "/files/Teste.txt.zip")));
    zos.putNextEntry(new ZipEntry(homeDir + "/files/Teste.txt.zip"));
    zos.write(new byte[32]);
    ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(
        homeDir + "/files/Teste.txt.zip")));
    ZipEntry ze = zis.getNextEntry();
    assertTrue(ze != null);
    zis.available();
    zos.close();
  }

  @After
  public void tearDown() {
    // ZipMeVariables.getSINGLETON().restore();
  }
}
