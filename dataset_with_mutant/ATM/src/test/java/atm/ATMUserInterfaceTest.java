package atm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atm.ATM;
import atm.ATMUserInterface;
import atm.Logger;
import specifications.Configuration;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;

public class ATMUserInterfaceTest {

	private FrameFixture demo;
	private ATM atm;
	private ATMUserInterface userInterface;

	public void setUp() {
		atm = new ATM();
		atm.run();
		userInterface = new ATMUserInterface(atm);
		demo = new FrameFixture(userInterface);
	}

	@After
	public void tearDown() {
		demo.cleanUp();
	}

	@Test
	public void testToMakeLogging() {
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE) {
			setUp();

			demo.textBox("loggin").enterText("4555");
			demo.textBox("password").enterText("11111");
			demo.button("btLogin").click();
			demo.optionPane().requireInformationMessage()
					.requireMessage("Invalid account number or PIN. Please try again.");
			demo.optionPane().button().click();
			
			demo.textBox("loggin").enterText("12345");
			demo.textBox("password").enterText("54321");
			demo.button("btLogin").click();
			demo.optionPane().requireInformationMessage().requireMessage("You are connected");
			demo.optionPane().button().click();
			demo.button("Logout").click();
			demo.optionPane().button().click();
			assertTrue(true);
		}
	}

	@Test
	public void testToMakeLogout() {
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE) {
//			setUp();
			
			startATMdoingLogging();
			demo.button("Logout").click();
			// demo.optionPane().requireInformationMessage().requireMessage("Thank you!
			// Goodbye!");
			demo.optionPane().button().click();
		}
	}

	@Test
	public void testBalance() {
		Configuration.BALANCE_INQUIRY = true;
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE && Configuration.BALANCE_INQUIRY) {
			startATMdoingLogging();
			demo.button("btBalance").click();
			assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == 1200);
		}
	}

	@Test
	public void testWhithDraw() {
		Configuration.WITHDRAWING = true;
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE && Configuration.WITHDRAWING) {
			
			startATMdoingLogging();
			demo.button("btWithdraw").click();
			demo.button("bt20").click();
			assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == 1180);

			demo.button("btWithdraw").click();
			demo.button("bt40").click();
			assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == 1140);

			demo.button("btWithdraw").click();
			demo.button("bt60").click();
			assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == 1080);

			demo.button("btWithdraw").click();
			demo.button("bt100").click();
			assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == 980);

			demo.button("btWithdraw").click();
			demo.button("bt200").click();
			assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == 780);
		}
	}

	@Test
	public void testWhithDrawAllValue() {
		Configuration.WITHDRAWING_ALL_VALUES = true;
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE && Configuration.WITHDRAWING_ALL_VALUES) {
			
			startATMdoingLogging();
			String temp = "";
			int aux = 1200;
			for (int i = 100; aux > i; i += 100) {
				temp = i + "";
				aux -= i;
				demo.button("btWithdraw").click();
				demo.textBox("jTFWithdraw").deleteText();
				demo.textBox("jTFWithdraw").enterText(temp);
				demo.button("btWithdrawAllValue").click();
				assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == aux);
			}
		}
	}

	@Test
	public void testDeposit() {
		Configuration.DEPOSITING = true;
		Configuration.USER_INTERFACE = true;

		if (Configuration.USER_INTERFACE && Configuration.DEPOSITING) {
			
			startATMdoingLogging();
			String temp = "";
			int aux = 1200;

			for (int i = 100; i < 3000; i += 100) {
				temp = i + "";
				aux += i;
				demo.button("btDeposit").click();
				demo.textBox("jTFDeposit").deleteText();
				demo.textBox("jTFDeposit").enterText(temp);
				demo.button("btSubmitDeposit").click();
				assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == aux);
			}
		}
	}

	@Test
	public void testTotalDeposit() {
		Configuration.ADMIN_CONTROL = true;
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE && Configuration.ADMIN_CONTROL) {
			
			startATMdoingLogging();
			
			demo.button("btDeposit").click();
			demo.textBox("jTFDeposit").deleteText();
			demo.textBox("jTFDeposit").enterText("1000");
			demo.button("btSubmitDeposit").click();
			assertTrue(atm.getCurrentTransaction().getBankDatabase().getTotalBalance(12345) == 2200);

		}
	}

//	@Test
	public void testLogger() {
		Configuration.USER_INTERFACE = true;
		Configuration.LOGGING=true;
		if (Configuration.USER_INTERFACE && Configuration.LOGGING) {
			
			
			Logger.resetLog();
			startATMdoingLogging();
			demo.button("btLog").click();
			assertEquals("\nUser: 12345", Logger.returnLogs());

			demo.button("btBalance").click();
			demo.button("btLog").click();
			assertEquals("\nUser: 12345\nUser balance: 1000.0, 1200.0", Logger.returnLogs());
		}
	}

	@Test
	public void testgGetCurrentAccountNumber() {
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE) {
			
			startATMdoingLogging();
			assertEquals(atm.getCurrentAccountNumber(), 12345);
		}
	}

	@Test
	public void testIsUserExited() {
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE) {
			
			startATMdoingLogging();
			assertFalse(atm.isUserExited());
		}
	}

	@Test
	public void testDepositUserAuthenticatedFalse() {
		Configuration.DEPOSITING = true;
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE && Configuration.DEPOSITING) {
			
			startATMdoingLogging();
			demo.button("Logout").click();
			demo.optionPane().button().click();
			demo.button("btDeposit").click();
			demo.optionPane().requireErrorMessage().requireMessage("You are not connected!");
		}

	}

	@Test
	public void testWithdrawUserAuthenticatedFalse() {
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE && Configuration.DEPOSITING) {
			
			startATMdoingLogging();
			demo.button("Logout").click();
			demo.optionPane().button().click();
			demo.button("btWithdraw").click();
			demo.optionPane().requireErrorMessage().requireMessage("You are not connected!");
		}

	}

	private void startATMdoingLogging() {
		Configuration.USER_INTERFACE = true;
		if (Configuration.USER_INTERFACE) {
			setUp();
			
			demo.textBox("loggin").enterText("12345");
			demo.textBox("password").enterText("54321");
			demo.button("btLogin").click();
			demo.optionPane().requireInformationMessage().requireMessage("You are connected");
			demo.optionPane().button().click();
		}
	}

}
