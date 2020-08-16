package testset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import paycard.IssueCardUI;
import specifications.Configuration;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;

public class PaycardUserInterfaceTest2 {

	private FrameFixture demo;
	private IssueCardUI gui;

	public void start() throws IllegalArgumentException, IllegalAccessException {

		gui = new IssueCardUI();
		gui.initGUI();
		JFrame frame = (JFrame) MemberModifier.field(IssueCardUI.class, "frame").get(gui);

		demo = new FrameFixture(frame);
	}

	@After
	public void tearDown() {
		if(demo!=null)
		demo.cleanUp();
	}

	@Test
	public void issueTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start();
			demo.radioButton("standard").click();
			demo.radioButton("junior").click();
			demo.radioButton("user_defined").click();
			demo.button("issue").click();
		}
	}
}
