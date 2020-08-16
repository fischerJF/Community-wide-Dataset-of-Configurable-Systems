package testset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import paycard.ChargeUI;
import paycard.IssueCardUI;
import paycard.PayCard;
import specifications.Configuration;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;

public class PaycardUserInterfaceTest {

	private FrameFixture demo;
	private ChargeUI gui;

	public void start(int n) throws IllegalArgumentException, IllegalAccessException {

		gui = new ChargeUI(n,10000);
		gui.initGUI();
		JFrame frame = (JFrame) MemberModifier.field(ChargeUI.class, "frame").get(gui);
		demo = new FrameFixture(frame);
	}

	@After
	public void tearDown() {
	if(demo!=null)
		demo.cleanUp();
	}

	@Test
	public void AmountToChargeTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start(1);
			demo.textBox("input").enterText("100");
			demo.button("charge").click();
			JTextArea jTextArea1 = (JTextArea) MemberModifier.field(ChargeUI.class, "jTextArea1").get(gui);
			assertTrue(jTextArea1.getText().contains("Current balance on card is 100"));
		}
	}
	@Test
	public void AmountToCharge_USER_DEFINEDTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start(3);
			demo.textBox("input").enterText("100000");
			demo.button("charge").click();
			JTextArea jTextArea1 = (JTextArea) MemberModifier.field(ChargeUI.class, "jTextArea1").get(gui);
			assertTrue(jTextArea1.getText().contains("Current balance on card is 0"));
		}
	}
	@Test
	public void AmountToCharge_USER_DEFINEDTest2() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start(3);
			demo.textBox("input").enterText("100");
			demo.button("charge").click();
			JTextArea jTextArea1 = (JTextArea) MemberModifier.field(ChargeUI.class, "jTextArea1").get(gui);
			assertTrue(jTextArea1.getText().contains("Current balance on card is 100"));
		}
	}
	@Test
	public void AmountToCharge_JUNIORTest2() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start(2);
			demo.textBox("input").enterText("200");
			demo.button("charge").click();
			JTextArea jTextArea1 = (JTextArea) MemberModifier.field(ChargeUI.class, "jTextArea1").get(gui);
			assertTrue(jTextArea1.getText().contains("Current balance on card is 0"));
			}
	}
	@Test
	public void checkTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start(1);
			demo.button("check").click();
			JTextArea jTextArea1 = (JTextArea) MemberModifier.field(ChargeUI.class, "jTextArea1").get(gui);
			assertTrue(jTextArea1.getText().contains("The card is valid"));
		}
	}
	@Test
	public void checkNotvalidTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
//		Configuration.lockout = false;
		if (Configuration.paycard) {
			start(1);
			PayCard paycard=  (PayCard) MemberModifier.field(ChargeUI.class, "paycard").get(gui);

			MemberModifier.field(PayCard.class, "unsuccessfulOperations").set(paycard,4);
			demo.button("check").click();

			JTextArea jTextArea1 = (JTextArea) MemberModifier.field(ChargeUI.class, "jTextArea1").get(gui);
			assertTrue(jTextArea1.getText().contains("The card is not valid"));
		}
	}
}
