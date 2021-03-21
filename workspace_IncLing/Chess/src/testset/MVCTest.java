package testset;


import org.powermock.api.support.membermodification.MemberModifier;

import MVC.MVC;
import gui.View;
import model.Model;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class MVCTest {

	private MVC mvc;
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		mvc= new MVC();
	}
	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
	    
		View view=	(View) MemberModifier.field(MVC.class, "v").get(mvc);
		JFrame f=	(JFrame) MemberModifier.field(View.class, "f").get(view);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.dispose();
			
	}

	@Test
	public void testMVC() throws IllegalArgumentException, IllegalAccessException {
		Model model=	(Model) MemberModifier.field(MVC.class, "m").get(mvc);
		assertTrue(model!=null);
		
		View view=	(View) MemberModifier.field(MVC.class, "v").get(mvc);
		assertTrue(view!=null);
	}
}
