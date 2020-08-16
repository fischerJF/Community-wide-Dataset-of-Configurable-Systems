package testset;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import EmailSystem.Client;
import EmailSystem.Email;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;


public class EmailTest {

//	@Rule
//	public TestName testName = new TestName();

	private Email email;

	@Before
	public void setup() throws IllegalArgumentException, IllegalAccessException {
		email = new Email(10);

		Configuration.base = true;
		MemberModifier.field(Email.class, "emailCounter").set(email,1);
	}
	@Test
	public void printMail__before__encryptTest() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		
		Email email_ = new Email(0);
		MemberModifier.field(Email.class, "emailCounter").set(email_,1);
		Client c = Client.createClient("client Test");
		Email test = Whitebox.invokeMethod(email_, "createEmail", c, "client__", "test", "email system test");
		Whitebox.invokeMethod(email_, "printMail__before__encrypt", test);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
    
        
		assertTrue(output.toString().contains("ID:  1"));
//		assertTrue(output.toString().contains("FROM: 0"));
		assertTrue(output.toString().contains("TO: client__"));
		assertTrue(output.toString().contains("SUBJECT: test"));
		assertTrue(output.toString().contains("IS_READABLE true"));
		assertTrue(output.toString().contains("BODY: email system test"));
	}

	
	@Test
	public void emailTest() throws Exception {
		int test = (int) MemberModifier.field(Email.class, "id").get(email);
		assertEquals(test, 10);
		int id = Whitebox.invokeMethod(email, "getId");

		assertEquals(id, 10);
	}

	@Test
	public void isEmailWasEncryptedTest() {
		email.setEmailWasEncrypted(true);
		assertTrue(email.isEmailWasEncrypted());
	}

	@Test
	public void isSignatureVerifiedTest() throws Exception {
		Whitebox.invokeMethod(email, "setIsSignatureVerified", true);
		assertTrue(email.isSignatureVerified());
	}

	@Test
	public void isSignedTest() throws Exception {
		Whitebox.invokeMethod(email, "setEmailIsSigned", true);
		assertTrue(email.isSigned());
	}

	@Test
	public void setEmailIsSignedTrue() throws Exception {
		Whitebox.invokeMethod(email, "setEmailSignKey", 10);
		assertEquals(email.getEmailSignKey(), 10);

	}

	@Test
	public void isEncryptedTest() throws Exception {
		Whitebox.invokeMethod(email, "setEmailIsEncrypted", true);
		assertTrue(email.isEncrypted());
	}

	@Test
	public void setEmailEncryptionKey() throws Exception {
		Whitebox.invokeMethod(email, "setEmailEncryptionKey", 20);
		int test = Whitebox.invokeMethod(email, "getEmailEncryptionKey");
		assertEquals(test, 20);
	}

	@Test
	public void getEmailBody() throws Exception {
		Whitebox.invokeMethod(email, "setEmailBody", "email test");
		String test = Whitebox.invokeMethod(email, "getEmailBody");
		assertEquals(test, "email test");
	}

	@Test
	public void setEmailFromTest() throws Exception {
		Client c = Client.createClient("client A");
		Whitebox.invokeMethod(email, "setEmailFrom", c);
		Client test = (Client) MemberModifier.field(Email.class, "from").get(email);

		assertEquals(c, test);
		assertEquals(c, Whitebox.invokeMethod(email, "getEmailFrom"));
	}

	@Test
	public void setEmailSubject() throws Exception {
		Whitebox.invokeMethod(email, "setEmailSubject", "client A");
		String test = Whitebox.invokeMethod(email, "getEmailSubject");
		assertEquals("client A", test);
	}

	@Test
	public void getEmailToTest() throws Exception {
		Whitebox.invokeMethod(email, "setEmailTo", "client B");
		String test = Whitebox.invokeMethod(email, "getEmailTo");
		assertEquals("client B", test);
	}

	@Test
	public void createEmailTest() throws Exception {
		email = new Email(10);
		Client client = Client.createClient("client A");
		Email e = Whitebox.invokeMethod(email, "createEmail", client, "clientB@gmail.com", "test", "email system test");
		int emailCounter = (int) MemberModifier.field(Email.class, "emailCounter").get(email);
	    assertEquals(emailCounter, 2);
		assertEquals(client, Whitebox.invokeMethod(e, "getEmailFrom"));
		assertEquals(e.getEmailTo(), "clientB@gmail.com");
		assertEquals("test", Whitebox.invokeMethod(e, "getEmailSubject"));
		assertEquals("email system test", Whitebox.invokeMethod(e, "getEmailBody"));
	}

	@Test
	public void isReadable__before__encryptTest() throws Exception {
		boolean test = (boolean) Whitebox.invokeMethod(email, "isReadable__before__encrypt");
		assertTrue(test);
	}

	@Test
	public void isReadable__role__encryptTest() throws Exception {
		MemberModifier.field(Email.class, "isEncrypted").set(email, false);
		boolean test = (boolean) Whitebox.invokeMethod(email, "isReadable__role__encrypt");
		assertTrue(test);

		MemberModifier.field(Email.class, "isEncrypted").set(email, true);
		test = (boolean) Whitebox.invokeMethod(email, "isReadable__role__encrypt");
		assertFalse(test);
	}

	@Test
	public void isReadableTest() throws Exception {
//		Configuration.ENCRYPT = true;
		if (Configuration.ENCRYPT) {
			MemberModifier.field(Email.class, "isEncrypted").set(email, false);
			assertTrue(email.isReadable());
			MemberModifier.field(Email.class, "isEncrypted").set(email, true);
			assertFalse(email.isReadable());
		}

//		Configuration.ENCRYPT = false;
		if (!Configuration.ENCRYPT) {
			boolean test = (boolean) Whitebox.invokeMethod(email, "isReadable");
			assertTrue(test);
		}
	}

	@Test
	public void printMail__before__signTest() throws Exception {
//		Configuration.ENCRYPT = true;
		if (Configuration.ENCRYPT) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			email = new Email(10);
			Client c = Client.createClient("client A");
			Email email_ = Whitebox.invokeMethod(email, "createEmail", c, "clientB@gmail.com", "test",
					"email system test");
			Whitebox.invokeMethod(email, "printMail__before__sign", email_);
           
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertTrue(output.toString().contains("ID:  1"));
//			assertTrue(os.toString().contains("FROM: 0"));
			assertTrue(output.toString().contains("TO: clientB@gmail.com"));
			assertTrue(output.toString().contains("SUBJECT: test"));
			assertTrue(output.toString().contains("IS_READABLE true"));
			assertTrue(output.toString().contains("BODY: email system test"));
			assertTrue(output.toString().contains("ENCRYPTED false"));

		}
	}
	
	@Test
	public void printMail__before__verifyTest() throws Exception {
//		Configuration.SIGN = true;
		if (Configuration.SIGN) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			email = new Email(10);
			Client c = Client.createClient("client A");
			Email email_ = Whitebox.invokeMethod(email, "createEmail", c, "clientB@gmail.com", "test",
					"email system test");
			Whitebox.invokeMethod(email, "printMail__role__sign", email_);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertTrue(output.toString().contains("SIGNED false"));
			assertTrue(output.toString().contains("SIGNATURE 0"));
		}
	}

	@Test
	public void printMail__role__verifyTest() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		email = new Email(10);
		Client c = Client.createClient("client A");
		Email email_ = Whitebox.invokeMethod(email, "createEmail", c, "clientB@gmail.com", "test",
				"email system test");
		Whitebox.invokeMethod(email, "printMail__role__verify", email_);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());

		assertTrue(output.toString().contains("SIGNATURE VERIFIED false"));
	}
	
    @Test
	public void printMail__role__encryptTest() throws Exception {
	
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
     
		email = new Email(10);
		Client c = Client.createClient("client A");
		Email email_ = Whitebox.invokeMethod(email, "createEmail", c, "clientB@gmail.com", "test",
				"email system test");
		Whitebox.invokeMethod(email, "printMail__role__encrypt", email_);
		
        System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
        assertTrue(output.toString().contains("ENCRYPTED false"));
	}

	@Test (expected = Error.class)
	public void cloneEmailTest() throws Exception{
		email = new Email(10);
		Client c = Client.createClient("client A");
		Email email_ = Whitebox.invokeMethod(email, "createEmail", c, "clientB@gmail.com", "test",
				"email system test");
		Whitebox.invokeMethod(email, "cloneEmail", email_);
	}
}