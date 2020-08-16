package tests;

import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import net.test.GZIPTest;
import net.test.ZipMETest;

public abstract class ZipMeTest {

//  @Rule
//  public TestName testName = new TestName();

  // @Rule
  // public Timeout globalTimeout = new Timeout(5000);

  @Before
  public void setup() throws FileNotFoundException {
    configure();
  }

  protected void configure() {
    // 1,1,1,1,?,1,0,0,1,1,1,1,?,F
    // ZipMeVariables.getSINGLETON().setBASE___(true);
    // ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
    // ZipMeVariables.getSINGLETON().setGZIP___(true);
    // ZipMeVariables.getSINGLETON().setEXTRACT___(true);
    // // ZipMeVariables.getSINGLETON().setARCHIVECHECK___(true);
    // ZipMeVariables.getSINGLETON().setCRC___(true);
    // ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(false);
    // ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_ADLER32CHECKSUM___(false);
    // ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_CRC___(true);
    // ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIP___(true);
    // ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIPCRC___(true);
    // ZipMeVariables.getSINGLETON().setDERIVATIVE_EXTRACT_CRC___(true);
    // // ZipMeVariables.getSINGLETON().setDERIVATIVE_GZIPCRC___(true);
  }

  @After
  public void teardown() throws IllegalArgumentException, IllegalAccessException {
    // ZipMeVariables.getSINGLETON().restore();
    ZipMETest.cleanup();
    GZIPTest.cleanup();
  }

}