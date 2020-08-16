package testset;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import EmailSystem.Client;
import EmailSystem.Email;
import email.PL_Interface_impl;
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


public class PL_Iinterface_implTest {

	
	private PL_Interface_impl pl;

	@Before
	public void setup() {
		pl= new PL_Interface_impl();
	}

	@Test
	public void test_1_addressBook_encrypt() throws Exception {
		Whitebox.invokeMethod(pl, "test_1_addressBook_encrypt");
	}
	
	@Test
	public void test_3_sign_verify() throws Exception {
		Whitebox.invokeMethod(pl, "test_3_sign_verify");
		
	}

	@Test
	public void test_6_encrypt_decrypt() throws Exception {
		Whitebox.invokeMethod(pl, "test_6_encrypt_decrypt");
		
	}
	
	@Test
	public void test_4_sign_forward() throws Exception {
		Whitebox.invokeMethod(pl, "test_4_sign_forward");
		
	}
	
	@Test
	public void test_7_encrypt_verify() throws Exception {
		Whitebox.invokeMethod(pl, "test_7_encrypt_verify");
		
	}
	
	@Test
	public void test_8_Encrypt_Autoresponder() throws Exception {
		Whitebox.invokeMethod(pl, "test_8_Encrypt_Autoresponder");

	}
	
	@Test
	public void test_9_Encrypt_Forward() throws Exception {
		Whitebox.invokeMethod(pl, "test_9_Encrypt_Forward");
		
	}
	
	@Test
	public void test_27_verify_forward() throws Exception {
		Whitebox.invokeMethod(pl, "test_27_verify_forward");
		
	}

	@Test
	public void test_11_decrypt_autoresponder() throws Exception {
		Whitebox.invokeMethod(pl, "test_11_decrypt_autoresponder");

	}
	@Test
	public void runRandomActionsTest() {
		pl.runRandomActions(1000);
	}
}