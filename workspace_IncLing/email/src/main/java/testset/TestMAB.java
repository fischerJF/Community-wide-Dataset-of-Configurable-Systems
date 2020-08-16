package testset;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import EmailSystem.Client;
import EmailSystem.Email;
import email.Test_Actions;
import specifications.Configuration;

public class TestMAB  {

	@Before
	public void setup() {
		Test_Actions.setup();
	}

	@Test
	public void test01() {
		Client urubu = Client.createClient("urubu");
		Client picapau = Client.createClient("picapau");
		assertTrue(Client.sendEmail(urubu, "picapau", "abc", "you need 25c for a soda") instanceof Email);
	}

	@Test
	public void test02() {
//		Configuration.ADDRESSBOOK = true;
		if (Configuration.ADDRESSBOOK) {
			Client urubu = Client.createClient("urubu");
			Client picapau = Client.createClient("picapau");
			urubu.addAddressbookEntry("sucker", "picapau");
			assertFalse(urubu.getAddressBookReceiversForAlias("sucker").isEmpty());
		}
	}

	@Test
	public void test03() {
//
//		Configuration.ENCRYPT = true;
//		Configuration.DECRYPT = true;
//		Configuration.KEYS = true;

		if (Configuration.ENCRYPT && Configuration.DECRYPT && Configuration.KEYS) {

			Client urubu = Client.createClient("urubu");
			Client picapau = Client.createClient("picapau");

			urubu.addKeyringEntry(picapau, 1);
			urubu.setPrivateKey(3);

			picapau.addKeyringEntry(urubu, 3);
			picapau.setPrivateKey(1);

			Email email = Client.sendEmail(urubu, "picapau", "abc", "you should sign on this insurance policy");

			assertFalse(email.isEncrypted());
			assertTrue(email.isReadable());
		}
	}

	@Test
	public void test04() {

//		Configuration.ENCRYPT = true;
//		Configuration.DECRYPT = true;
//		Configuration.KEYS = true;

		if (Configuration.ENCRYPT && Configuration.DECRYPT && Configuration.KEYS) {
			Client urubu = Client.createClient("urubu");
			Client picapau = Client.createClient("picapau");

			urubu.setPrivateKey(3);

			assertTrue(urubu.getPrivateKey() == 3);
			Email email = Client.sendEmail(urubu, "picapau", "abc", "you should sign on this insurance policy");
			// Assert.assertTrue(email.isSigned());
			// Assert.assertEquals(email.getEmailSignKey(), 3);
			Assert.assertTrue(email.isReadable());
		}
	}
	//

	@Test
	public void test05() {
//		Configuration.FORWARD = true;
		if (Configuration.FORWARD) {
			Client urubu = Client.createClient("urubu");
			Client picapau = Client.createClient("picapau");
			Client chilly = Client.createClient("chilly");

			picapau.setForwardReceiver(chilly);
			Email email = Client.sendEmail(urubu, "picapau", "abc", "you should sign on this insurance policy");

			Assert.assertEquals("chilly", email.getEmailTo());
		}
	}
	
	

}
