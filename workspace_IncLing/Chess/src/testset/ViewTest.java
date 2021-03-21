package testset;



import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import gui.MenuText;
import gui.View;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class ViewTest {

	private View view;
	private JFrame frame;
	@Before
	public void setUp() throws IllegalArgumentException, IllegalAccessException { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		view= new View(null);
		frame=	(JFrame) MemberModifier.field(View.class, "f").get(view);
		
		
	}
	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
	}
	

	@Test
	public void testSetCheck() throws IllegalArgumentException, IllegalAccessException {
		view.setCheck(true,true);
		JLabel label=	(JLabel) MemberModifier.field(View.class, "checkText").get(view);
		String s = "<html><font color = white> White King</font> in Check and Black King in Check</html>";
		
		view.setCheck(true,false);
		label=	(JLabel) MemberModifier.field(View.class, "checkText").get(view);
		s = "<html><font color = white> White King</font> in Check</html> ";
		assertEquals(label.getText(),s);
		
		view.setCheck(false,true);
		label=	(JLabel) MemberModifier.field(View.class, "checkText").get(view);
		s = "Black King in Check";
		assertEquals(label.getText(),s);
		
		view.setCheck(false,false);
		label=	(JLabel) MemberModifier.field(View.class, "checkText").get(view);
		s = " ";
		assertEquals(label.getText(),s);
		
	}
	

	@Test
	public void createMenuTest_OFFLINE_PLAYER() throws Exception {
//		Configuration.OFFLINE_PLAYER=true; 
		
		if(Configuration.OFFLINE_PLAYER)  {
//			view= new View(null);
		 
		   JPanel p= view.createMenu();
		   JPanel menu0= (JPanel) p.getComponent(1);
		
		   assertTrue(menu0.getComponent(0) instanceof MenuText);
		   
		   assertEquals(menu0.getComponent(0).getForeground(), Color.WHITE);
		   assertTrue(menu0.getComponent(0).getMouseListeners()!=null);

		
		 }
		
	}
	
}
