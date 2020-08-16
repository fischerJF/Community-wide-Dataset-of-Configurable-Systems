package testset;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import paycard.IssueCardUI;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class IssueCardUITest {

	IssueCardUI gui;
	
	@Before
	public void setUp() {
	}

	@Test
	public void initGuiTest() throws Exception {
		
//		Configuration.paycard = true;
		if (Configuration.paycard) {
		gui = new IssueCardUI();
		gui.initGUI();
		JFrame frame = (JFrame) MemberModifier.field(IssueCardUI.class, "frame").get(gui);

		assertTrue(frame.getBounds().getX() == 100);
		assertTrue(frame.getBounds().getY() == 100);
		assertTrue(frame.getBounds().getWidth() == 550);
		assertTrue(frame.getBounds().getHeight() == 230);
		assertTrue(frame.getDefaultCloseOperation() == JFrame.EXIT_ON_CLOSE);
		assertTrue(frame.getContentPane() != null);
		assertTrue(frame.isVisible());
		JRootPane root= (JRootPane) frame.getComponent(0);
		assertEquals(root.getComponentCount(),2);
		assertTrue(root.getComponent(0) instanceof JPanel);
		JPanel panel= (JPanel) frame.getContentPane();
		assertTrue(panel.getComponent(0) instanceof JPanel);
		assertTrue(panel.getComponent(1) instanceof JPanel);
		assertTrue(panel.getComponent(2) instanceof JPanel);
		assertTrue(panel.getComponent(3) instanceof JPanel);
		
		JPanel jPanel1 = (JPanel) MemberModifier.field(IssueCardUI.class, "jPanel1").get(gui);
		assertTrue(jPanel1.getLayout() != null);
		assertTrue(jPanel1.getLayout() instanceof GridLayout);
		assertTrue(jPanel1.getLayout() != null);
		assertEquals(jPanel1.getComponentCount(),3);
		assertTrue(jPanel1.getComponent(0) instanceof JRadioButton);	
		assertTrue(jPanel1.getComponent(1) instanceof JRadioButton);	
		assertTrue(jPanel1.getComponent(2) instanceof JPanel);	
		
		JPanel jPanel2 = (JPanel) MemberModifier.field(IssueCardUI.class, "jPanel2").get(gui);
		assertTrue(jPanel2.getLayout() != null);
		assertTrue(jPanel2.getLayout() instanceof GridLayout);
		assertTrue(jPanel2.getLayout() != null);
		assertEquals(jPanel2.getComponentCount(),2);
		assertTrue(jPanel2.getComponent(0) instanceof JButton);	
		assertTrue(jPanel2.getComponent(1) instanceof JButton);	
		
		JPanel jPanel3 = (JPanel) MemberModifier.field(IssueCardUI.class, "jPanel3").get(gui);
		assertTrue(jPanel3.getLayout() != null);
		assertTrue(jPanel3.getLayout() instanceof GridLayout);
		assertTrue(jPanel3.getLayout() != null);
		assertEquals(jPanel3.getComponentCount(),3);
		assertTrue(jPanel3.getComponent(0) instanceof JRadioButton);	
		assertTrue(jPanel3.getComponent(1) instanceof JPanel);	
		assertTrue(jPanel3.getComponent(2) instanceof JPanel);	
		
		JPanel jPanel4 = (JPanel) MemberModifier.field(IssueCardUI.class, "jPanel4").get(gui);
		assertTrue(jPanel4.getLayout() != null);
		assertTrue(jPanel4.getLayout() instanceof BorderLayout);
		assertTrue(jPanel4.getLayout() != null);
		assertEquals(jPanel4.getComponentCount(),1);
		assertTrue(jPanel4.getComponent(0) instanceof JLabel);	
		
		JPanel jPanel5 = (JPanel) MemberModifier.field(IssueCardUI.class, "jPanel5").get(gui);
		assertTrue(jPanel5.getLayout() != null);
		assertTrue(jPanel5.getLayout() instanceof BorderLayout);
		assertTrue(jPanel5.getLayout() != null);
		assertEquals(jPanel5.getComponentCount(),3);
		assertTrue(jPanel5.getComponent(0) instanceof JPanel);	
		assertTrue(jPanel5.getComponent(1) instanceof JPanel);	
		assertTrue(jPanel5.getComponent(2) instanceof JTextField);	
		
		JRadioButton jRadioButton1 = (JRadioButton) MemberModifier.field(IssueCardUI.class, "jRadioButton1").get(gui);
		assertEquals(jRadioButton1.getText(),"Standard Paycard");
		assertEquals(jRadioButton1.getName(),"standard");
		assertTrue(jRadioButton1.isSelected());
		assertTrue(jRadioButton1.getComponentListeners()!=null);
		
		JRadioButton jRadioButton2 = (JRadioButton) MemberModifier.field(IssueCardUI.class, "jRadioButton2").get(gui);
		assertEquals(jRadioButton2.getText(),"Junior Paycard");
		assertEquals(jRadioButton2.getName(),"junior");

		assertTrue(jRadioButton2.getComponentListeners()!=null);

		JRadioButton jRadioButton3 = (JRadioButton) MemberModifier.field(IssueCardUI.class, "jRadioButton3").get(gui);
		assertEquals(jRadioButton3.getText(),"User Defined Paycard");
		assertTrue(jRadioButton3.getComponentListeners()!=null);
		assertEquals(jRadioButton3.getName(),"user_defined");
		
		JButton jButton1 = (JButton) MemberModifier.field(IssueCardUI.class, "jButton1").get(gui);
		assertEquals(jButton1.getText(),"Issue Paycard");
		assertEquals(jButton1.getName(),"issue");
		assertTrue(jButton1.getComponentListeners()!=null);

		JButton jButton2 = (JButton) MemberModifier.field(IssueCardUI.class, "jButton2").get(gui);
		assertEquals(jButton2.getText(),"Quit");
		assertEquals(jButton2.getName(),"quit");
		assertTrue(jButton2.getComponentListeners()!=null);

		JTextField jTextField = (JTextField) MemberModifier.field(IssueCardUI.class, "jTextField1").get(gui);
		System.out.println(jTextField.getMaximumSize());
		assertTrue(jTextField.getMaximumSize().getWidth()==200);
		assertTrue(jTextField.getMaximumSize().getHeight()==10);
		assertTrue(jTextField.getMinimumSize().getWidth()==200);
		assertTrue(jTextField.getMinimumSize().getHeight()==10);
		assertTrue(jTextField.getPreferredSize().getWidth()==200);
		assertTrue(jTextField.getPreferredSize().getHeight()==10);
		
		JLabel jLabel1 = (JLabel) MemberModifier.field(IssueCardUI.class, "jLabel1").get(gui);
		assertEquals(jLabel1.getText(),"Limit:  ");
		assertEquals(jLabel1.getToolTipText(),"Limit of the paycard");
		
		}
	}

}
