package tests;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import splat.EmailVariables;
import email.EmailSystem.Client;
import email.EmailSystem.Email;
import email.defpackage.Test_Actions;

public class TestMAB extends EmailTest{

  //set
  @Before
  public void setup() {
    Test_Actions.setup();
  }
  
//  @Test
//  public void test01() {
//    Client urubu = Client.createClient("urubu");
//    Client picapau = Client.createClient("picapau");
//    Client.sendEmail(urubu, "picapau", "abc", "you need 25c for a soda");
//  }
//  
  @Test
  public void test02() {
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isADDRESSBOOK___());
    
    Client urubu = Client.createClient("urubu");
    Client picapau = Client.createClient("picapau");
    urubu.addAddressbookEntry("sucker", "picapau");
    Client.sendEmail(urubu, "sucker", "abc", "you need 25c for a soda");
  }
  
  @Test
  public void test03() {
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isENCRYPT___());
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isDECRYPT___());
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isKEYS___());
    
    Client urubu = Client.createClient("urubu");
    Client picapau = Client.createClient("picapau");
    
    urubu.addKeyringEntry(picapau, 1);
    urubu.setPrivateKey(3);
    
    picapau.addKeyringEntry(urubu, 3);
    picapau.setPrivateKey(1);
    
    Email email = Client.sendEmail(urubu, "picapau", "abc", "you should sign on this insurance policy");
    Assert.assertTrue(email.isEmailWasEncrypted());
    Assert.assertFalse(email.isEncrypted());
    Assert.assertTrue(email.isReadable());
  }
  
  @Test
  public void test04() {
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isSIGN___());
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isVERIFY___());
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isKEYS___());
    
    Client urubu = Client.createClient("urubu");
    Client picapau = Client.createClient("picapau");
    
    urubu.setPrivateKey(3);
    
    Email email = Client.sendEmail(urubu, "picapau", "abc", "you should sign on this insurance policy");
    Assert.assertTrue(email.isSigned());
    Assert.assertEquals(email.getEmailSignKey(),3);
    Assert.assertTrue(email.isReadable());
  }
  
  @Test
  public void test05() {
//    Assume.assumeTrue(EmailVariables.getSINGLETON().isFORWARD___());
    Client urubu = Client.createClient("urubu");
    Client picapau = Client.createClient("picapau");
    Client chilly = Client.createClient("chilly");
    
    picapau.setForwardReceiver(chilly);
    Email email = Client.sendEmail(urubu, "picapau", "abc", "you should sign on this insurance policy");
    Assert.assertEquals("chilly",email.getEmailTo());
  }
}
