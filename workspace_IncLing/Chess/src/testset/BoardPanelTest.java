package testset;


import org.powermock.reflect.Whitebox;
import gui.BoardPanel;
import static org.junit.Assert.assertTrue;
import java.awt.Color;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class BoardPanelTest {

	private BoardPanel boardPanel;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
	}


	@Test
	public void testMVC() throws Exception {
		Color c= new Color(0);
		
//		Whitebox.invokeMethod(board, "addPiece", piece, 7, 7, 0);
		boardPanel= Whitebox.invokeConstructor(BoardPanel.class, c,1,2);
//		Model model=	(Model) MemberModifier.field(MVC.class, "m").get(mvc);
		boardPanel.setRelativeX(2);
		boardPanel.setRelativeY(4);
		assertTrue(boardPanel.getRelativeX()==2);
		assertTrue(boardPanel.getRelativeY()==4);
//		System.out.println(boardPanel.getAlignmentX());
//		System.out.println(boardPanel.getAlignmentY());
		
	}
}
