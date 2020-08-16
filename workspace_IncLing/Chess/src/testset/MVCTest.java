package testset;


import org.powermock.api.support.membermodification.MemberModifier;

import MVC.MVC;
import gui.View;
import model.Model;
import static org.junit.Assert.assertTrue;
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


	@Test
	public void testMVC() throws IllegalArgumentException, IllegalAccessException {
		Model model=	(Model) MemberModifier.field(MVC.class, "m").get(mvc);
		assertTrue(model!=null);
		
		View view=	(View) MemberModifier.field(MVC.class, "v").get(mvc);
		assertTrue(view!=null);
	}
}
