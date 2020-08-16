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


public class ClientTest {

	
	private Client client;

	@Before
	public void setup() {
		client= Client.createClient("client A");
		Configuration.base = true;
	}

	@Test
	public void setAutoResponseTest() {
		client.setAutoResponse(true);
		assertTrue(client.isAutoResponse());
	}
	
	//@Test
	public void autoRespondTest() throws Exception {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		Email email= new Email(1);
		Email email_ = Whitebox.invokeMethod(email, "createEmail", client, "clientB@gmail.com", "test",
				"email system test");
		Whitebox.invokeMethod(client, "autoRespond", client, email_);
		assertTrue(os.toString().contains("sending autoresponse\n"));
		System.err.println(client.toString());
		assertEquals(client.toString(),"client A");
		Client client_=  Whitebox.invokeMethod(client, "getClientById", 1);
		assertEquals(client_.toString(), "bob");
	}
	
	@Test
	public void getClientById() throws Exception {
		Client[] clients = (Client[]) MemberModifier.field(Client.class, "clients").get(client);
		assertEquals(clients.length, 100);
		client.resetClients();
		
		Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		Whitebox.invokeMethod(client, "deliver", clientB, email);
		
		Client c= Whitebox.invokeMethod(client, "getClientById", 1);
		assertEquals(clientB, c);
	}
	@Test
	public void toStringTest() {
		Client clientB= Client.createClient("client b");
		assertEquals(clientB.toString(),"client b");
	}
	
	@Test 
	public void getClienteByAdressTest() {
		client.resetClients();
		
		assertEquals(client.getClientByAdress("clientB@gmail.com"), null);
	}
	@Test
	public void deliver() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);

        Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		
		Whitebox.invokeMethod(client, "deliver", clientB, email);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(output.toString(),"mail delivered\n\r\n");
	}
	@Test
	public void incoming__before__autoresponderTest() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		Whitebox.invokeMethod(client, "incoming__before__autoresponder", clientB, email);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(output.toString(),"mail delivered\n\r\n");
	}
	@Test
	public void  incoming__role__autoresponderTest() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);

		Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		Whitebox.invokeMethod(client, "incoming__role__autoresponder", clientB, email);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(output.toString(),"mail delivered\n\r\n");

	}
	
	@Test
	public void incoming__before__verifyTest() throws Exception {
//		Configuration.FORWARD=false;
		if (!Configuration.FORWARD) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
		Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		Whitebox.invokeMethod(client, "incoming__before__verify", clientB, email);
		
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
        assertEquals(output.toString(),"mail delivered\n\r\n");
		}
	}
	@Test
	public void  incoming__role__verifyTest() throws Exception {
//		Configuration.FORWARD=false;
		if (!Configuration.FORWARD) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
		Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		Whitebox.invokeMethod(client, "incoming__role__verify", clientB, email);
		
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(output.toString(),"mail delivered\n\r\n");
		}
		
	}
	@Test
	public void incoming__before__forwardTest() throws Exception {
//		Configuration.AUTORESPONDER=true;
		if (Configuration.AUTORESPONDER) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
		
			Client clientB= Client.createClient("client b");
			Email email= new Email(1);
			Whitebox.invokeMethod(client, "incoming__before__forward", clientB, email);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertEquals(output.toString(),"mail delivered\n\r\n");
			
		}
	}
	
	@Test
	public void incoming__before__decryptTest() throws Exception {
//		Configuration.VERIFY=true;
		if (Configuration.VERIFY) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			Client clientB= Client.createClient("client b");
			Email email= new Email(1);
			Whitebox.invokeMethod(client, "incoming__before__decrypt", clientB, email);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertEquals(output.toString(),"mail delivered\n\r\n");
		}
	}
	@Test
	public void incomingTest() throws Exception {
		
//		Configuration.DECRYPT=true;
		if (Configuration.DECRYPT) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			Client clientB= Client.createClient("client b");
			Email email= new Email(1);
			Whitebox.invokeMethod(client, "incoming", clientB, email);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertEquals(output.toString(),"mail delivered\n\r\n");
		}
	}
	
	@Test
	public void mailTest() throws Exception {
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		Whitebox.invokeMethod(client, "mail", clientB, email);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(output.toString(),"mail sent\r\n");
	}
	
	@Test
	public void outgoing__before__encryptTest() throws Exception {
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		Client clientB= Client.createClient("client b");
		Email email= new Email(1);
		Whitebox.invokeMethod(client, "outgoing__before__encrypt", clientB, email);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertEquals(output.toString(),"mail sent\r\n");
	}
	@Test
	public void outgoing__before__addressbookTest() throws Exception {
//		Configuration.ENCRYPT=false;
		if (!Configuration.ENCRYPT) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			Client clientB= Client.createClient("client b");
			Email email= new Email(1);
			Whitebox.invokeMethod(client, "outgoing__before__addressbook", clientB, email);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertEquals(output.toString(),"mail sent\r\n");
		}
		}
	@Test
	public void sendEmailTest() throws Exception {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
	    Email email= new Email(1);
		Client c = Client.createClient("client BB");
		Whitebox.invokeMethod(email, "createEmail", c, "clientB@gmail.com", "test",
				"email system test");

		
		client.sendEmail(client, "client BB", "test", "body test");
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
        assertTrue(output.toString().contains("mail sent"));
	}
	@Test
	public void outgoingTest() throws Exception {
//		Configuration.SIGN=false;
		if (!Configuration.SIGN) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			Client clientB= Client.createClient("client b");
			Email email= new Email(1);
			Whitebox.invokeMethod(client, "outgoing", clientB, email);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertEquals(output.toString(),"mail sent\r\n");

		}
	}
	@Test
	public void outgoingTest2() throws Exception {
//		Configuration.SIGN=true;
		if (Configuration.SIGN) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			Client clientB= Client.createClient("client b");
			Email email= new Email(1);
			Whitebox.invokeMethod(client, "outgoing", clientB, email);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertEquals(output.toString(),"mail sent\r\n");
		}
		}
	
	
}