package testset;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import atm.ATM;
import atm.ATMUserInterface;
import atm.Screen;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class ATMUserInterfaceTest2 {

	private ATMUserInterface atm;
	private ATM a;

	@Before
	public void setUp() {
		a = new ATM();
		atm = new ATMUserInterface(a);
	}
   
//	@Test
	public void ATMUserInterfaceTest() {
		if (Configuration.USER_INTERFACE) {
			assertEquals(atm.getDefaultCloseOperation(), 3);
			assertEquals(atm.getWidth(), 900);
			assertEquals(atm.getHeight(), 800);
			assertFalse(atm.isResizable());
			assertTrue(atm.isVisible());
		}
	}

	@Test
	public void createMainPainelTest() throws Exception {
		JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createMainPainel");
		assertEquals(pn.getBackground(), Color.WHITE);
		assertTrue(pn.getComponent(0) instanceof JPanel);
		assertTrue(pn.getComponent(1) instanceof JScrollPane);
	}

	@Test
	public void createHeaderTest() throws Exception {
		Color c = new Color(0, 125, 0);
		JLabel lb = (JLabel) Whitebox.invokeMethod(atm, "createHeader");
		assertTrue(lb.getForeground() instanceof Color);
		System.out.println(lb.getFont());
		assertEquals(lb.getFont().getSize(), 30);
		assertEquals(lb.getFont().getStyle(), Font.BOLD);
		assertEquals(lb.getForeground().getRGB(), c.getRGB());

	}

	@Test
	public void createPanelLoginTest() throws Exception {
		JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createPanelLogin");
		Color WINDOWS_COLOR_TEXT = new Color(0, 125, 0);
		Color CAIXA_TEXTO_COR_FUNDO = new Color(185, 255, 185);
		assertFalse(pn.isOpaque());
		
		// Label
		assertEquals(pn.getComponent(0).getFont().getSize(), 15);
		assertEquals(pn.getComponent(0).getFont().getStyle(), Font.BOLD);
		assertTrue(pn.getComponent(0).getForeground() instanceof Color);
		JLabel label = (JLabel) pn.getComponent(0);
		assertEquals(label.getText(), "Enter your account number");
		assertTrue(pn.getComponent(0) instanceof JLabel);
		assertEquals(pn.getComponent(0).getForeground().getRGB(), WINDOWS_COLOR_TEXT.getRGB());

		// JTextField
		assertEquals(pn.getComponent(1).getFont().getSize(), 30);
		assertEquals(pn.getComponent(1).getFont().getStyle(), Font.BOLD);
		assertTrue(pn.getComponent(1).getForeground() instanceof Color);
		assertTrue(pn.getComponent(1).getBackground() instanceof Color);
		assertEquals(pn.getComponent(1).getName(), "loggin");
		assertTrue(pn.getComponent(1) instanceof JTextField);
		assertTrue(pn.getComponent(1).getBackground() instanceof Color);
		assertTrue(pn.getComponent(1).getForeground() instanceof Color);
		assertEquals(pn.getComponent(1).getForeground().getRGB(), WINDOWS_COLOR_TEXT.getRGB());
		assertEquals(pn.getComponent(1).getBackground().getRGB(), CAIXA_TEXTO_COR_FUNDO.getRGB());

		// JLabel
		assertTrue(pn.getComponent(2) instanceof JLabel);
		assertEquals(pn.getComponent(2).getFont().getSize(), 15);
		assertEquals(pn.getComponent(2).getFont().getStyle(), Font.BOLD);
		assertTrue(pn.getComponent(2).getForeground() instanceof Color);
		assertEquals(pn.getComponent(2).getForeground().getRGB(), WINDOWS_COLOR_TEXT.getRGB());

		// JTextField
		assertTrue(pn.getComponent(3) instanceof JTextField);
		assertEquals(pn.getComponent(3).getName(), "password");
		assertEquals(pn.getComponent(3).getFont().getSize(), 30);
		assertEquals(pn.getComponent(3).getFont().getStyle(), Font.BOLD);
		assertTrue(pn.getComponent(3).getBackground() instanceof Color);
		assertTrue(pn.getComponent(3).getForeground() instanceof Color);
		assertEquals(pn.getComponent(3).getBackground().getRGB(), CAIXA_TEXTO_COR_FUNDO.getRGB());
		assertEquals(pn.getComponent(3).getForeground().getRGB(), WINDOWS_COLOR_TEXT.getRGB());
		assertTrue(pn.getComponent(3).getComponentListeners()!=null);
		
		
		// JButton
		assertTrue(pn.getComponent(4) instanceof JButton);
		assertEquals(pn.getComponent(4).getFont().getSize(), 15);
		assertEquals(pn.getComponent(4).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(4).getBackground(), Color.WHITE);
		assertEquals(pn.getComponent(4).getName(), "btLogin");
		assertTrue(pn.getComponent(4).getComponentListeners()!=null);

		// JButton
		assertTrue(pn.getComponent(5) instanceof JButton);
		assertEquals(pn.getComponent(5).getName(), "Logout");
		assertEquals(pn.getComponent(5).getBackground(), Color.WHITE);
		assertTrue(pn.getComponent(5).getComponentListeners()!=null);

	}

	@Test
	public void createPanelMenu_BALANCE_INQUIRY_Test() throws Exception {
//		Configuration.BALANCE_INQUIRY = true;
//		Configuration.DEPOSITING = false;
//		Configuration.LOGGING = false;
//		Configuration.ADMIN_CONTROL = false;
		if (Configuration.BALANCE_INQUIRY && !Configuration.DEPOSITING && !Configuration.LOGGING
				&& !Configuration.ADMIN_CONTROL) {
			JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createPanelMenu");
			JPanel p = (JPanel) pn.getComponent(0);

			assertTrue(p.getComponent(0) instanceof JButton);
			assertEquals(p.getComponent(0).getFont().getSize(), 15);
			assertEquals(p.getComponent(0).getFont().getStyle(), Font.BOLD);
			assertEquals(p.getComponent(0).getBackground(), Color.WHITE);
			assertEquals(p.getComponent(0).getName(), "btBalance");
			assertTrue(p.getComponent(0).getComponentListeners()!=null);
			
		}
	}

	@Test
	public void createPanelVisible_Test() throws Exception {
	
			JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createPanelMenu");
			assertFalse(pn.getComponent(1).isVisible());
			assertFalse(pn.getComponent(2).isVisible());
	}
	@Test
	public void createPanelMenu_DEPOSITING_Test() throws Exception {
//		Configuration.BALANCE_INQUIRY = false;
//		Configuration.DEPOSITING = true;
//		Configuration.LOGGING = false;
//		Configuration.ADMIN_CONTROL = false;
//		Configuration.WITHDRAWING = false;
		if (!Configuration.WITHDRAWING && !Configuration.BALANCE_INQUIRY && Configuration.DEPOSITING
				&& !Configuration.LOGGING && !Configuration.ADMIN_CONTROL) {

			JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createPanelMenu");

			JPanel p = (JPanel) pn.getComponent(0);
			assertTrue(p.getComponent(0) instanceof JButton);
			assertEquals(p.getComponent(0).getFont().getSize(), 15);
			assertEquals(p.getComponent(0).getFont().getStyle(), Font.BOLD);
			assertEquals(p.getComponent(0).getBackground(), Color.WHITE);
			assertEquals(p.getComponent(0).getName(), "btDeposit");
			assertTrue(p.getComponent(0).getComponentListeners()!=null);
		}
	}

	@Test
	public void createPanelMenu_LOGGING_Test() throws Exception {
//		Configuration.BALANCE_INQUIRY = false;
//		Configuration.DEPOSITING = false;
//		Configuration.LOGGING = true;
//		Configuration.ADMIN_CONTROL = false;
//		Configuration.WITHDRAWING = false;
		if (!Configuration.WITHDRAWING && 
			!Configuration.BALANCE_INQUIRY && 
			!Configuration.DEPOSITING && 
			Configuration.LOGGING && 
			!Configuration.ADMIN_CONTROL) {

			JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createPanelMenu");
			JPanel p = (JPanel) pn.getComponent(0);

			assertTrue(p.getComponent(0) instanceof JButton);
			assertEquals(p.getComponent(0).getFont().getSize(), 15);
			assertEquals(p.getComponent(0).getFont().getStyle(), Font.BOLD);
			assertEquals(p.getComponent(0).getBackground(), Color.WHITE);
			assertEquals(p.getComponent(0).getName(), "btLog");
			assertTrue(p.getComponent(0).getComponentListeners()!=null);
			

		}
	}

	@Test
	public void createPanelMenu_WITHDRAWING_Test() throws Exception {
//		Configuration.BALANCE_INQUIRY = false;
//		Configuration.DEPOSITING = false;
//		Configuration.LOGGING = false;
//		Configuration.ADMIN_CONTROL = false;
//		Configuration.WITHDRAWING = true;
		if (Configuration.WITHDRAWING && !Configuration.BALANCE_INQUIRY && !Configuration.DEPOSITING
				&& !Configuration.LOGGING && !Configuration.ADMIN_CONTROL) {

			JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createPanelMenu");
			JPanel p = (JPanel) pn.getComponent(0);

			assertTrue(p.getComponent(0) instanceof JButton);
			assertEquals(p.getComponent(0).getFont().getSize(), 15);
			assertEquals(p.getComponent(0).getFont().getStyle(), Font.BOLD);
			assertEquals(p.getComponent(0).getBackground(), Color.WHITE);
			assertEquals(p.getComponent(0).getName(), "btWithdraw");
			assertTrue(p.getComponent(0).getComponentListeners()!=null);


		}
	}

	@Test
	public void createPanelMenu_ADMIN_CONTROL_Test() throws Exception {
//		Configuration.BALANCE_INQUIRY = false;
//		Configuration.DEPOSITING = false;
//		Configuration.LOGGING = false;
//		Configuration.ADMIN_CONTROL = true;
//		Configuration.WITHDRAWING = false;
		if (!Configuration.WITHDRAWING && !Configuration.BALANCE_INQUIRY && !Configuration.DEPOSITING
				&& !Configuration.LOGGING && Configuration.ADMIN_CONTROL) {

			JPanel pn = (JPanel) Whitebox.invokeMethod(atm, "createPanelMenu");
			JPanel p = (JPanel) pn.getComponent(0);

			assertTrue(p.getComponent(0) instanceof JButton);
			assertEquals(p.getComponent(0).getFont().getSize(), 15);
			assertEquals(p.getComponent(0).getFont().getStyle(), Font.BOLD);
			assertEquals(p.getComponent(0).getBackground(), Color.WHITE);
			assertTrue(p.getComponent(0).getMouseListeners()!=null);
			
			assertTrue(p.getComponent(1) instanceof JButton);
			assertEquals(p.getComponent(1).getFont().getSize(), 15);
			assertEquals(p.getComponent(1).getFont().getStyle(), Font.BOLD);
			assertEquals(p.getComponent(1).getBackground(), Color.WHITE);
			assertTrue(p.getComponent(1).getComponentListeners()!=null);
		
		}
	}

	@Test
	public void createWithDrawMenu() throws Exception {
		Color CAIXA_TEXTO_COR_FUNDO = new Color(185, 255, 185);
		Color WINDOWS_COLOR_TEXT = new Color(0, 125, 0);

		Whitebox.invokeMethod(atm, "createWithDrawMenu");
		JPanel pn = (JPanel) MemberModifier.field(ATMUserInterface.class, "pnMedium2").get(atm);
		assertFalse(pn.isOpaque());
		assertTrue(pn.getComponent(0) instanceof JTextField);
		assertEquals(pn.getComponent(0).getFont().getSize(), 30);
		assertTrue(pn.getComponent(0).getBackground() instanceof Color);
		assertTrue(pn.getComponent(0).getForeground() instanceof Color);
		assertEquals(pn.getComponent(0).getForeground().getRGB(), WINDOWS_COLOR_TEXT.getRGB());
		assertEquals(pn.getComponent(0).getBackground().getRGB(), CAIXA_TEXTO_COR_FUNDO.getRGB());

		assertEquals(pn.getComponent(0).getName(), "jTFDeposit");

		assertTrue(pn.getComponent(1) instanceof JButton);
		assertEquals(pn.getComponent(1).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(1).getFont().getSize(), 15);
		assertEquals(pn.getComponent(1).getBackground(), Color.WHITE);
		assertEquals(pn.getComponent(1).getName(), "btSubmitDeposit");
		assertTrue(pn.getComponent(1).getComponentListeners()!=null);
	
	}

	@Test
	public void dollarMenuTest() throws Exception {
		Whitebox.invokeMethod(atm, "dollarMenu");
		JPanel pn = (JPanel) MemberModifier.field(ATMUserInterface.class, "pnCore").get(atm);
		Color c = new Color(143, 188, 143);
		assertFalse(pn.isOpaque());
		assertTrue(pn.getComponent(0) instanceof JButton);
		assertEquals(pn.getComponent(0).getFont().getSize(), 15);
		assertEquals(pn.getComponent(0).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(0).getName(), "bt20");
		assertTrue(pn.getComponent(0).getBackground() instanceof Color);
		assertEquals(pn.getComponent(0).getBackground().getRGB(), c.getRGB());
		assertTrue(pn.getComponent(0).getComponentListeners()!=null);
		
		assertTrue(pn.getComponent(1) instanceof JButton);
		assertEquals(pn.getComponent(1).getFont().getSize(), 15);
		assertEquals(pn.getComponent(1).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(1).getName(), "bt40");
		assertTrue(pn.getComponent(1).getBackground() instanceof Color);
		assertEquals(pn.getComponent(1).getBackground().getRGB(), c.getRGB());
		assertTrue(pn.getComponent(1).getComponentListeners()!=null);
		
		assertTrue(pn.getComponent(2) instanceof JButton);
		assertEquals(pn.getComponent(2).getFont().getSize(), 15);
		assertEquals(pn.getComponent(2).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(2).getName(), "bt60");
		assertTrue(pn.getComponent(2).getBackground() instanceof Color);
		assertEquals(pn.getComponent(2).getBackground().getRGB(), c.getRGB());
		assertTrue(pn.getComponent(2).getComponentListeners()!=null);
		
		assertTrue(pn.getComponent(3) instanceof JButton);
		assertEquals(pn.getComponent(3).getFont().getSize(), 15);
		assertEquals(pn.getComponent(3).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(3).getBackground().getRGB(), c.getRGB());
		assertEquals(pn.getComponent(3).getName(), "bt80");
		assertTrue(pn.getComponent(3).getComponentListeners()!=null);

		assertTrue(pn.getComponent(4) instanceof JButton);
		assertEquals(pn.getComponent(4).getFont().getSize(), 15);
		assertEquals(pn.getComponent(4).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(4).getName(), "bt100");
		assertTrue(pn.getComponent(4).getBackground() instanceof Color);
		assertEquals(pn.getComponent(4).getBackground().getRGB(), c.getRGB());
		assertTrue(pn.getComponent(4).getComponentListeners()!=null);

		assertTrue(pn.getComponent(5) instanceof JButton);
		assertEquals(pn.getComponent(5).getFont().getSize(), 15);
		assertEquals(pn.getComponent(5).getFont().getStyle(), Font.BOLD);
		assertEquals(pn.getComponent(5).getName(), "bt200");
		assertTrue(pn.getComponent(5).getBackground() instanceof Color);
		assertEquals(pn.getComponent(5).getBackground().getRGB(), c.getRGB());
		assertTrue(pn.getComponent(5).getComponentListeners()!=null);

	}

	@Test
	public void dollarMenuTest_WITHDRAWING_ALL_VALUES_Test() throws Exception {
//		Configuration.WITHDRAWING_ALL_VALUES=true;
		if (Configuration.WITHDRAWING_ALL_VALUES) {
			Color CAIXA_TEXTO_COR_FUNDO = new Color(185, 255, 185);
			Color WINDOWS_COLOR_TEXT = new Color(0, 125, 0);
			Color c = new Color(143, 188, 143);
			
			Whitebox.invokeMethod(atm, "dollarMenu");
			
			JPanel p = (JPanel) MemberModifier.field(ATMUserInterface.class, "pnMedium").get(atm);
            
			JPanel pn= (JPanel) p.getComponent(1);
			
			 assertTrue(pn.getComponent(0) instanceof JTextField );
			 assertEquals(pn.getComponent(0).getFont().getSize(), 30);
  			 assertEquals(pn.getComponent(0).getFont().getStyle(), Font.BOLD);
			 assertEquals(pn.getComponent(0).getName(), "jTFWithdraw");
			 assertTrue(pn.getComponent(0).getBackground() instanceof Color);
			 assertEquals(pn.getComponent(0).getBackground().getRGB(), CAIXA_TEXTO_COR_FUNDO.getRGB());
			 assertEquals(pn.getComponent(0).getForeground().getRGB(), WINDOWS_COLOR_TEXT.getRGB());

			
			assertTrue(pn.getComponent(1) instanceof JButton );
			assertEquals(pn.getComponent(1).getFont().getSize(),15);
			assertEquals(pn.getComponent(1).getFont().getStyle(),Font.BOLD);
			assertEquals(pn.getComponent(1).getName(), "btWithdrawAllValue");
			assertTrue(pn.getComponent(1).getBackground() instanceof Color);
			assertEquals(pn.getComponent(1).getBackground().getRGB(),c.getRGB());
		   
		
		}
	}

	@Test
	public void createPanelMessageTest() throws Exception {
		JTextArea JTA = (JTextArea) Whitebox.invokeMethod(atm, "createPanelMessage");
		Color c = new Color(0, 125, 0);
		assertTrue(JTA instanceof JTextArea);
		assertEquals(JTA.getFont().getSize(), 16);
		assertEquals(JTA.getFont().getStyle(), Font.ITALIC);
		assertEquals(JTA.getName(), "textArea");
		assertEquals(JTA.getLineWrap(), true);
		assertEquals(JTA.getWrapStyleWord(), true);
		assertTrue(JTA.getLineWrap()); 
        assertTrue(JTA.getWrapStyleWord()); 
		
	}
	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
		Screen s=	(Screen) MemberModifier.field(ATM.class, "screen").get(a);
		ATMUserInterface f=	(ATMUserInterface) MemberModifier.field(Screen.class, "frame").get(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.dispose();
		
		atm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		atm.dispose();
	}
	
}
