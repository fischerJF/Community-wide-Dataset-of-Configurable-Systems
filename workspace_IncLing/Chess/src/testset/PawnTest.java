package testset;


import org.powermock.api.support.membermodification.MemberModifier;

import piece.Pawn;
import piece.Piece;
import piece.PieceType;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class PawnTest {

	private Pawn pawn;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		pawn= new Pawn(3,4,0);
	}


	@Test
	public void testPawn() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Pawn.class, "pt").set(pawn , PieceType.PAWN);
		assertEquals(pawn.getType(),PieceType.PAWN);
		assertEquals(pawn.getTeam(),0);
		assertEquals(pawn.getLocX(),3);
		assertEquals(pawn.getLocY(),4);
		assertEquals(0, pawn.getTeam());
		pawn.setTeam(1);
		assertEquals(1, pawn.getTeam());
	}
	
	@Test
	public void testUpdatePosition() throws IllegalArgumentException, IllegalAccessException{
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		pawn.updatePosition(friend, enemy);

		assertTrue(pawn.validMoves.get(0).getX()==1 && pawn.validMoves.get(0).getY()==4);
	    assertTrue(pawn.validMoves.get(1).getX()==2 && pawn.validMoves.get(1).getY()==4);
	    
	    MemberModifier.field(Pawn.class, "firstMove").set(pawn , false);
	    System.out.println();
	    Boolean  test= (Boolean) MemberModifier.field(Pawn.class, "firstMove").get(pawn);
	    assertFalse(test);
	    pawn.updatePosition(friend, enemy);
	    assertFalse(pawn.validMoves.get(0).getX()==1 && pawn.validMoves.get(0).getY()==4);
	    assertTrue(pawn.validMoves.get(0).getX()==2 && pawn.validMoves.get(0).getY()==4);
		    
		}
	@Test
	public void testUpdatePosition_time1() throws IllegalArgumentException, IllegalAccessException{
		pawn= new Pawn(3,4,1);
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,1));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(0,1,1));
		pawn.updatePosition(friend, enemy);
		
		assertTrue(pawn.validMoves.get(0).getX()==5 && pawn.validMoves.get(0).getY()==4);
		assertTrue(pawn.validMoves.get(1).getX()==4 && pawn.validMoves.get(1).getY()==4);
		
		MemberModifier.field(Pawn.class, "firstMove").set(pawn , false);
		Boolean  test= (Boolean) MemberModifier.field(Pawn.class, "firstMove").get(pawn);
		assertFalse(test);
		pawn.updatePosition(friend, enemy);
		assertFalse(pawn.validMoves.get(0).getX()==5 && pawn.validMoves.get(0).getY()==4);
		assertTrue(pawn.validMoves.get(0).getX()==4 && pawn.validMoves.get(0).getY()==4);
		
	}
	@Test
	public void testUpdatePosition_time1_() throws IllegalArgumentException, IllegalAccessException{
		pawn= new Pawn(3,4,1);
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,1));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,1));
		pawn.updatePosition(friend, enemy);

		assertTrue(pawn.validMoves.get(0).getX()==5 && pawn.validMoves.get(0).getY()==4);
	    assertTrue(pawn.validMoves.size()==1);
	    
	    MemberModifier.field(Pawn.class, "firstMove").set(pawn , false);
	    Boolean  test= (Boolean) MemberModifier.field(Pawn.class, "firstMove").get(pawn);
	    assertFalse(test);
	    pawn.updatePosition(friend, enemy);
	    assertTrue(pawn.validMoves.size()==0);
		    
		}
}
