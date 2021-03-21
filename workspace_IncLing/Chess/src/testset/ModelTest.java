package testset;


import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import MVC.MVC;
import gui.RoundState;
import gui.View;
import model.Model;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

import org.junit.After;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;
import piece.Rook;

public class ModelTest {

	private Model model;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		MVC mvc = new MVC();
		model= model.getInstance();
	}
	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
		JFrame f=	(JFrame) MemberModifier.field(View.class, "f").get(model.v);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.dispose();
	}

	@Test
	public void testSetMode() throws Exception {
		Whitebox.invokeMethod(model, "setMode", 1);
		int i=	(Integer) MemberModifier.field(Model.class, "mode").get(model);
		assertTrue(i==1);
			
	}
	@Test
	public void testNextRound()throws Exception {
		model.nextRound();
		int i=	(Integer) MemberModifier.field(Model.class, "currentTurn").get(model);
//		assertTrue(i==1);
	}
	
	@Test
	public void getInstanceTest () throws Exception {
      assertTrue(model.getInstance() instanceof Model);
	}
	
	@Test
	public void getPieceTest() {
		model.buildTabuleiro();
		assertTrue(model.getPiece(0, 0) instanceof Rook);
	}
	
	@Test 
	public void changePositionTest() {
		model.buildTabuleiro();
		Rook rook= new Rook(0,0,0);
		model.changePosition(1, 1, rook);
		
		assertEquals(rook.getLocX(),1);
		assertEquals(rook.getLocY(),1);
	}
	
	@Test 
	public void clickedPanelTest() throws IllegalArgumentException, IllegalAccessException {
		model.buildTabuleiro();
		   
		RoundState i=	(RoundState) MemberModifier.field(Model.class, "rs").get(model);
		assertEquals(i, RoundState.NOCLICK);
		MemberModifier.field(Model.class, "currentTurn").set(model, 0);
		MemberModifier.field(Model.class, "multiplayer").set(model, true);
		MemberModifier.field(Model.class, "isHost").set(model, true);
		model.clickedPanel(6,0);
		i=	(RoundState) MemberModifier.field(Model.class, "rs").get(model);
		assertEquals(i, RoundState.FIRSTCLICK);

	}
	@Test 
	public void clickedPanel_2Test() throws IllegalArgumentException, IllegalAccessException {
		model.buildTabuleiro();
		
		model.clickedPanel(1,0);
		RoundState i=	(RoundState) MemberModifier.field(Model.class, "rs").get(model);
		int currentTurn=	(int) MemberModifier.field(Model.class, "currentTurn").get(model);
	    assertEquals(i, RoundState.NOCLICK);
	    System.out.println(currentTurn);

	}

	@Test 
	public void clickedPanel_3Test() throws IllegalArgumentException, IllegalAccessException {
		model.buildTabuleiro();
		
		MemberModifier.field(Model.class, "rs").set(model, RoundState.FIRSTCLICK);
		
		model.clickedPanel(0,0);
		RoundState i=	(RoundState) MemberModifier.field(Model.class, "rs").get(model);
		assertEquals(i, RoundState.NOCLICK);
	}
	@Test 
	public void clickedPanel_4Test() throws IllegalArgumentException, IllegalAccessException {
		model.buildTabuleiro();
	
		MemberModifier.field(Model.class, "rs").set(model, RoundState.FIRSTCLICK);
		MemberModifier.field(Model.class, "currentTurn").set(model, 1);
		MemberModifier.field(Model.class, "multiplayer").set(model, true);
		MemberModifier.field(Model.class, "isHost").set(model, false);
		
		model.clickedPanel(1,0);
		RoundState i=	(RoundState) MemberModifier.field(Model.class, "rs").get(model);
		assertEquals(i, RoundState.FIRSTCLICK);
	}

	@Test
	public void sendMoveTest() {
		model.buildTabuleiro();
//		model.sendMove(1, 1);
	}
	
}
