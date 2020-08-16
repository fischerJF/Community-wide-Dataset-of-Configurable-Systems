package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.io.IOException;
import java.io.OutputStream;

import net.sf.zipme.GZIPOutputStream;
import net.sf.zipme.GZIPOutputStream_hook22;
import net.sf.zipme.ZipArchive;
import net.sf.zipme.ZipEntry;
import net.sf.zipme.ZipException;
import net.sf.zipme.ZipOutputStream;
import specifications.Configuration;

import org.junit.After;
import org.junit.Test;

import com.sun.xml.messaging.saaj.util.ByteOutputStream;

public class LitleFeatures extends ZipMeTest {

	//@Test(expected = ZipException.class)
	public void ArchiveCheckTest() throws ZipException {
		// ZipMeVariables.getSINGLETON().setARCHIVECHECK___(true);
//		Configuration.ARCHIVECHECK=true;
		if (Configuration.ARCHIVECHECK) {
			byte[] b = { 0, 1, 2, 3 };

			ZipArchive z = new ZipArchive(b);
		}
	}

	// @Test
	/*
	 * Contains: -net.sf.zipme.CRC32.getValue() -net.sf.zipme.CRC32.reset()
	 * -net.sf.zipme.CRC32.make_crc_table() -net.sf.zipme.CRC32.update(byte[], int,
	 * int) -net.sf.zipme.ZipOutputStream.hook41()
	 * -net.sf.zipme.ZipOutputStream.hook42()
	 * -net.sf.zipme.ZipOutputStream.hook43(byte[], int, int)
	 */
	public void DerivativeCompCRCTest() {
		// ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_CRC___(true); //Main
		// // Feature
		// ZipMeVariables.getSINGLETON().setCRC___(true); //Feature Needed to test
		// // reset() and update()
		// ZipMeVariables.getSINGLETON().setCOMPRESS___(true); //Feature needed to
		// // initialize ZipEntry
		//
		// ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_ADLER32CHECKSUM___(true);
		// ZipMeVariables.getSINGLETON().setADLER32CHECKSUM___(true);

//		if (Configuration.DERIVATIVE_COMPRESS_CRC && Configuration.CRC && Configuration.COMPRESS
//				&& Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM && Configuration.ADLER32CHECKSUM) {
			OutputStream o = new ByteOutputStream();
			ZipOutputStream z = new ZipOutputStream(o);
			ZipEntry ze = new ZipEntry("test");
			byte[] b = { 7 };

			z.crc.crc = 21;
			try {
				z.putNextEntry(ze);
				assertEquals(z.crc.getValue(), 0);
				z.crc.crc = 30;
				assertEquals(z.curEntry.getCrc(), -1);
				z.hook42();
				assertEquals(z.curEntry.getCrc(), 30);
				z.crc.crc = 29;
				z.hook43(b, 0, 1);
				assertNotSame(z.crc.getValue(), 29);
				z.hook41();
				assertEquals(z.crc.getValue(), 0);
			} catch (Exception e) {
				System.out.println(e);
			}
//		}
	}

	@Test
	/*
	 * Contains: -net.sf.zipme.GZIPOutputStream.hook()
	 * -net.sf.zipme.GZIPOutputStream.hook31(byte[], int, int)
	 * -net.sf.zipme.GZIPOutputStream_hook22.execute()
	 * 
	 * -net.sf.zipme.GZIPOutputStream_hook22.GZIPOutputStream_hook22(
	 * GZIPOutputStream , byte[])
	 */
	public void GZIPCRCderivativeTest() {
		// Features
		// ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIPCRC___(true);
		// ZipMeVariables.getSINGLETON().setCRC___(true);
		// ZipMeVariables.getSINGLETON().setDERIVATIVE_COMPRESS_GZIP___(true);

		if (Configuration.DERIVATIVE_COMPRESS_GZIPCRC && Configuration.CRC && Configuration.DERIVATIVE_COMPRESS_GZIP) {
			// Setting Variables
			byte[] b = { 1, 2, 3, 4, 5 };
			ByteOutputStream out = new ByteOutputStream();
			GZIPOutputStream gz;

			try {
				gz = new GZIPOutputStream(out);
			} catch (IOException e) {
				gz = null;
				e.printStackTrace();
			}

			// Tests hook()
			gz.hook();
			assertNotSame(gz.crc, null);

			// Tests hook22 related methods
			GZIPOutputStream_hook22 h = new GZIPOutputStream_hook22(gz, b);
			assertEquals(gz, h._this);
			assertEquals(h.gzipFooter, b);
			h.execute();
			assertEquals(h.crcval, gz.crc.crc);

			// Tests hook31()
			try {
				gz.crc.crc = 2;
				gz.hook31(b, 0, 1);
				assertNotSame(gz.crc.getValue(), 2); // Value changed, as expected
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// @Test
	// public void CRCupdates() {
	// // ZipMeVariables.getSINGLETON().setCRC___(true);
	//
	// byte[] b = { 1 };
	// OutputStream o = new ByteOutputStream();
	// ZipOutputStream z = new ZipOutputStream(o);
	//
	// z.crc.crc = 3;
	// z.crc.update(0);
	// assertNotSame(z.crc.getValue(), 3);
	// z.crc.crc = 2;
	// z.crc.update(b);
	// assertNotSame(z.crc.getValue(), 2);
	// }

	@After
	public void teardown() {
		// ZipMeVariables.getSINGLETON().restore();
		// doReset(Class.forName("net.sf.zipme.CRC32"));
		// call resetFunction
		// List<Class<?>> classes = ClassFinder.find("net");
		// for (Class<?> clazz : classes) {
		// ResetFunction.doReset(clazz);
		// }
		// Runtime r = Runtime.getRuntime();
		// r.gc();
		// final String className = CRC32.class.getPackage().getName() + ".CRC32";
		// URL url =
		// CRC32.class.getProtectionDomain().getCodeSource().getLocation();
		// try {
		// LoadAndUnloadMain.loadUnload(className, url);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

}
