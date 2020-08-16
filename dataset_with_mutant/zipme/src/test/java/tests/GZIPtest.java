package tests;

import static org.junit.Assert.*;

import java.io.IOException;

import net.sf.zipme.GZIPInputStream;
import specifications.Configuration;

import org.junit.After;
import org.junit.Test;

public class GZIPtest extends ZipMeTest {

	@Test
	/*
	 * Contains: -net.sf.zipme.GZIPInputStream.close()
	 * -net.sf.zipme.GZIPInputStream.GZIPInputStream(InputStream, int)
	 * -net.sf.zipme.GZIPInputStream.GZIPInputStream(InputStream)
	 * -net.sf.zipme.GZIPInputStream.readHeader()
	 */
	public void CrDstTest() {
		// ZipMeVariables.getSINGLETON().setGZIP___(true);
		if (Configuration.GZIP) {
			int[] b = { -1 };
			TestInputStream in = new TestInputStream(b);
			try {
				GZIPInputStream g = new GZIPInputStream(in);
				assertTrue(g.eos);

				assertNotSame(in.stream, null);
				g.close();
				assertEquals(in.stream, null);
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	@After
	public void teardown() {
		// ZipMeVariables.getSINGLETON().restore();
	}

}
