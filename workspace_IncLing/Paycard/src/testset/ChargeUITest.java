package testset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import paycard.ChargeUI;
import paycard.IssueCardUI;
import specifications.Configuration;
import static org.junit.Assert.assertTrue;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;

public class ChargeUITest {

	private FrameFixture demo;
	private ChargeUI gui;

	public void start(int n) throws IllegalArgumentException, IllegalAccessException {
		
		gui = new ChargeUI(n,100);
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
	public void ChargeUITest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start(1);
			int limit = (int) MemberModifier.field(ChargeUI.class, "limit").get(gui);
			assertEquals(limit,1000);
			tearDown();
			start(2);
			limit = (int) MemberModifier.field(ChargeUI.class, "limit").get(gui);
			assertEquals(limit,100);
			tearDown();		
			start(3);
			limit = (int) MemberModifier.field(ChargeUI.class, "limit").get(gui);
            assertEquals(limit,100);
		}
	}
	
	@Test
	public void initGuiTest() throws Exception {
		
//		Configuration.paycard = true;
		if (Configuration.paycard) {
			start(1);
		gui.initGUI();
		JFrame frame = (JFrame) MemberModifier.field(ChargeUI.class, "frame").get(gui);

		assertTrue(frame.getBounds().getX() == 100);
		assertTrue(frame.getBounds().getY() == 100);
		assertTrue(frame.getBounds().getWidth() == 550);
		assertTrue(frame.getBounds().getHeight() == 350);
		assertTrue(frame.isResizable());
		assertTrue(frame.isVisible());
		assertTrue(frame.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE);

		JButton jButton1 = (JButton) MemberModifier.field(ChargeUI.class, "jButton1").get(gui);
		assertEquals(jButton1.getText(),"charge");
		assertEquals(jButton1.getName(),"charge");
		assertTrue(jButton1.getComponentListeners()!=null);

		JButton jButton2 = (JButton) MemberModifier.field(ChargeUI.class, "jButton2").get(gui);
		assertEquals(jButton2.getText(),"Quit");
		assertEquals(jButton2.getName(),"quit");
		assertTrue(jButton2.getComponentListeners()!=null);

		JButton jButton3 = (JButton) MemberModifier.field(ChargeUI.class, "jButton3").get(gui);
		assertEquals(jButton3.getText(),"check valid");
		assertEquals(jButton3.getName(),"check");
		assertTrue(jButton3.getComponentListeners()!=null);

		JRootPane root= (JRootPane) frame.getComponent(0);
		assertEquals(root.getComponentCount(),2);
		assertTrue(root.getComponent(0) instanceof JPanel);
		JPanel panel= (JPanel) frame.getContentPane();
		assertTrue(panel.getComponent(0) instanceof JPanel);
		assertTrue(panel.getComponent(1) instanceof JPanel);
		assertTrue(panel.getComponent(2) instanceof JPanel);
		assertTrue(panel.getComponent(3) instanceof JPanel);
		
		JPanel jPanel1 = (JPanel) MemberModifier.field(ChargeUI.class, "jPanel1").get(gui);
		assertTrue(jPanel1.getLayout() != null);
		assertTrue(jPanel1.getLayout() instanceof BorderLayout);
		assertTrue(jPanel1.getLayout() != null);
		assertEquals(jPanel1.getComponentCount(),4);
		assertTrue(jPanel1.getComponent(1) instanceof JPanel);	
		assertTrue(jPanel1.getComponent(3) instanceof JScrollPane);	
		assertTrue(jPanel1.getComponent(2) instanceof JLabel);	
		assertTrue(jPanel1.getComponent(0) instanceof JScrollPane);	
		
		JPanel jPanel2 = (JPanel) MemberModifier.field(ChargeUI.class, "jPanel2").get(gui);
		assertTrue(jPanel2.getLayout() != null);
		assertTrue(jPanel2.getLayout() instanceof GridLayout);
		assertTrue(jPanel2.getLayout() != null);
		assertEquals(jPanel2.getComponentCount(),3);
		assertTrue(jPanel2.getComponent(0) instanceof JButton);	
		assertTrue(jPanel2.getComponent(1) instanceof JButton);	
		assertTrue(jPanel2.getComponent(2) instanceof JButton);	
		
		JPanel jPanel3 = (JPanel) MemberModifier.field(ChargeUI.class, "jPanel3").get(gui);
		assertTrue(jPanel3.getLayout() != null);
		assertTrue(jPanel3.getLayout() instanceof GridLayout);
		assertTrue(jPanel3.getLayout() != null);
		assertEquals(jPanel3.getComponentCount(),2);
		assertTrue(jPanel3.getComponent(0) instanceof JLabel);	
		assertTrue(jPanel3.getComponent(1) instanceof JTextField);	
		
		JTextField jTextField1 = (JTextField) MemberModifier.field(ChargeUI.class, "jTextField1").get(gui);
		assertEquals(jTextField1.getText(),"");
		assertEquals(jTextField1.getName(),"input");
		
		JTextArea jTextArea1 = (JTextArea) MemberModifier.field(ChargeUI.class, "jTextArea1").get(gui);
		assertFalse(jTextArea1.isEditable());
		
		JLabel jLabel2 = (JLabel) MemberModifier.field(ChargeUI.class, "jLabel2").get(gui);
		assertTrue(jLabel2.getText().contains("Limit of paycard is"));
		assertEquals(jLabel2.getFont().getSize(), 14);
		assertEquals(jLabel2.getFont().getFontName(), "SansSerif.bold");
		assertEquals(jLabel2.getFont().getStyle(), Font.BOLD);

		}
	}


}
