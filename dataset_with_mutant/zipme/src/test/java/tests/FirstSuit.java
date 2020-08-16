package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import net.sf.zipme.Deflater;
import net.sf.zipme.Deflater_deflate2;
import specifications.Configuration;

import org.junit.After;
import org.junit.Test;

public class FirstSuit extends ZipMeTest {

//	@Test
	/*
	 * This test includes the methods: net.sf.zipme.Deflater.deflate(byte[])
	 * net.sf.zipme.Deflater.deflate(byte[], int, int) net.sf.zipme.Deflater.end()
	 * net.sf.zipme.Deflater.finish() net.sf.zipme.Deflater.finished()
	 * net.sf.zipme.Deflater.getBytesWritten()
	 * 
	 */
	public void testDeflation() {
		// ZipMeVariables.getSINGLETON().setCOMPRESS___(true);

		if (Configuration.COMPRESS) {
			byte[] b = { 1, 2, 3 };
			Deflater d = new Deflater();

			assertEquals(d.state, 0x00);
			d.finish();
			assertEquals(d.state, 0x0C);

			assertNotSame(d.deflate(b), 0);
			assertEquals(d.getBytesWritten(), 3);

			assertNotSame(d.deflate(b), -1);
			assertTrue(d.finished());
			// REPAIR
			// if
			// (!ZipMeVariables.getSINGLETON().isDERIVATIVE_COMPRESS_ADLER32CHECKSUM___())
			// assertTrue(d.finished());
			// else assertFalse(d.finished());

			d.end();
			assertEquals(d.engine, null);
		}
	}

	// @Test
	// /*
	// * This test includes the methods:
	// * -net.sf.zipme.DeflaterEngine.getTotalIn()
	// * -net.sf.zipme.Deflater.needsInput()
	// * -net.sf.zipme.DeflaterEngine.needsInput()
	// * -net.sf.zipme.Deflater.reset()
	// * -net.sf.zipme.DeflaterEngine.reset()
	// * -net.sf.zipme.Deflater.setInput(byte[], int, int)
	// * -net.sf.zipme.Deflater.setInput(byte[])
	// * -net.sf.zipme.DeflaterEngine.setInput(byte[], int, int)
	// */
	// public void testDeflaterStates(){
	// ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
	//
	// byte[] b = {1, 2, 3};
	// Deflater d = new Deflater();
	//
	// assertEquals(d.engine.getTotalIn(), 0);
	// assertTrue(d.needsInput());
	//
	// d.engine.lookahead = 2;
	// d.reset();
	// assertEquals(d.engine.lookahead, 0);
	//
	// assertEquals(d.engine.blockStart, 1);
	// d.setDictionary(b);
	// assertEquals(d.state, 0x01);
	// assertEquals(d.engine.blockStart, 4);
	// d.reset();
	//
	// d.setInput(b);
	// assertEquals(d.engine.inputBuf, b);
	//
	// assertEquals(d.state, 0x00);
	// d.flush();
	// assertEquals(d.state, 0x04);
	//
	// }
	//
	// @Test
	// /*
	// * Contains:
	// * -net.sf.zipme.DeflaterEngine.getTotalIn()
	// * -net.sf.zipme.Deflater.setLevel(int)
	// * -net.sf.zipme.DeflaterEngine.setLevel(int)
	// * -net.sf.zipme.Deflater.setStrategy(int)
	// * -net.sf.zipme.DeflaterEngine.setStrategy(int)
	// */
	// public void SettingTests(){
	// ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
	// byte[] b = {1, 2, 3};
	// Deflater d = new Deflater();
	//
	//
	//
	// d.setLevel(5);
	// assertEquals(d.level, 5);
	// assertEquals(d.engine.goodLength, 8);
	//
	// assertEquals(d.engine.strategy, 0);
	// d.setStrategy(1);
	// assertEquals(d.engine.strategy, 1);
	// }
	//
	// @Test
	// /*
	// * Contains:
	// * -net.sf.zipme.Deflater_deflate2.Deflater_deflate2(Deflater, byte[], int,
	// int)
	// * -net.sf.zipme.Deflater_deflate2.execute()
	// * -
	// */
	// public void deflater2Test(){
	// ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
	//
	// byte[] b = {1, 2, 3};
	// Deflater d = new Deflater();
	//
	// Deflater_deflate2 d2 = new Deflater_deflate2(d, b, 1, 3);
	// assertEquals(d2.output, b);
	//
	// d2.execute();
	// assertEquals(d2.origLength, 3);
	//
	//
	//
	// }
	//
	// @Test
	// /*
	// * Contains:
	// * -net.sf.zipme.Deflater.hook24(int)
	// * -net.sf.zipme.Deflater.hook25()
	// */
	// public void deflaterHooks(){
	// ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
	//
	// Deflater d = new Deflater(-1, true);
	//
	// assertEquals(d.level, 6); //hook24 a result
	// assertEquals(d.engine.pending, d.pending); //hook25 state result
	//
	// }
	// @Test
	// /*
	// * Contains:
	// * -net.sf.zipme.DeflaterEngine.deflate(boolean, boolean)
	// * -net.sf.zipme.DeflaterEngine.deflateFast(boolean, boolean)
	// * -net.sf.zipme.DeflaterEngine.DeflateSlow(boolean, boolean)
	// * -net.sf.zipme.DeflaterEngine.deflateStored(boolean, boolean)
	// *
	// */
	// public void EngineDeflate(){
	// ZipMeVariables.getSINGLETON().setCOMPRESS___(true);
	//
	// Deflater d = new Deflater();
	//
	// d.engine.lookahead = 2;
	//
	// //Deflate Store
	// d.engine.comprFunc = 0;
	// d.engine.deflate(false, true);
	// assertEquals(d.engine.strstart , 3);
	//
	// //DeflateFast
	// d.engine.comprFunc = 1;
	// d.engine.deflate(true, false);
	// assertEquals(d.engine.blockStart, 3);
	//
	// //DeflateSlow
	// d.engine.strstart = 1;
	// d.engine.comprFunc = 2;
	// d.engine.deflate(true, false);
	// assertEquals(d.engine.blockStart, 1);
	//
	// }

	@After
	public void teardown() {
		// ZipMeVariables.getSINGLETON().restore();

	}
}
