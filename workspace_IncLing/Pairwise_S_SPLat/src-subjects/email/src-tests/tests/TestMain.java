package tests;

import gov.nasa.jpf.jvm.Verify;

import org.junit.Assert;
import org.junit.Test;

import email.EmailSystem.Client;
import email.defpackage.PL_Interface;
import email.defpackage.PL_Interface_impl;

public class TestMain extends EmailTest {

	@Override
	protected void configure() {
		// set mandatory features
		super.configure();
		if (testName == null) {
			throw new RuntimeException();
		}
		String strTestName = testName.getMethodName();
//		if (strTestName.equals("testBestScenario")
//				|| strTestName.equals("testAverageScenario")
//				|| strTestName.equals("testWorstScenario")
//				|| strTestName.equals("testSignVerify")
//				|| strTestName.equals("testSignForward")
//				|| strTestName.equals("testEncryptVerify")
//				|| strTestName.equals("testEncryptAutoresponder")
//				|| strTestName.equals("testEncryptForward")
//				|| strTestName.equals("testDecryptAutoresponder")
//				|| strTestName.equals("testEncryptDecrypt")
//				) {
//			// it works with just BASE___ feature enabled
//		} else {
//			System.err.printf("%s did not set default configuration",
//					strTestName);
//		}
	}

	@Test
	public void testBestScenario() {
		Client sender = Client.createClient("mysender");
		int recipientsCount = 500;
		for (int i = 0; i < recipientsCount; i++) {
			Client c = Client.createClient("myreceiver" + i);
			c.setPrivateKey(i);
			sender.addKeyringEntry(c, i);
		}
		String recipientAddr = "myreceiver"
				+ String.valueOf(recipientsCount - 1);
		Client recipient = Client.getClientByAdress(recipientAddr);
		int pubkey = sender.getKeyringPublicKeyByClient(recipient);
		Assert.assertTrue(pubkey < recipientsCount);
	}

	@Test
	public void testAverageScenario() {
		testEMAIL(1);
	}

	@Test
	public void testWorstScenario() {
		testEMAIL(27);
	}

	@Test
	public void testSignVerify() {
		testEMAIL(3);
	}

	@Test
	public void testSignForward() {
		testEMAIL(4);
	}

	@Test
	public void testEncryptDecrypt() {
		testEMAIL(6);
	}

	@Test
	public void testEncryptVerify() {
		testEMAIL(7);
	}

	@Test
	public void testEncryptAutoresponder() {
		testEMAIL(8);
	}

	@Test
	public void testEncryptForward() {
		testEMAIL(9);
	}

	@Test
	public void testDecryptAutoresponder() {
		testEMAIL(11);
	}

	private void testEMAIL(int specification) {
		PL_Interface interf = new PL_Interface_impl();
		try {
				// start program
				interf.start(specification, -1);
				if (interf.isAbortedRun() == true) {
					Verify.incrementCounter(2);
				}
		} catch (Throwable e) {
				e.printStackTrace();
		}
	}

}
