package testset;


import org.powermock.api.support.membermodification.MemberModifier;

import piece.Piece;
import piece.PieceType;
import piece.Rook;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class RookTest {

	private Rook rook;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		rook= new Rook(3,4,0);
	}


	@Test
	public void testRook() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Rook.class, "pt").set(rook , PieceType.ROOK);
		assertEquals(rook.getType(),PieceType.ROOK);
		assertEquals(rook.getTeam(),0);
		assertEquals(rook.getLocX(),3);
		assertEquals(rook.getLocY(),4);
		rook.setTeam(1);
		assertEquals(1, rook.getTeam());
	}
	
	@Test
	public void testUpdatePosition() {
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		rook.updatePosition(friend, enemy);
		assertTrue(rook.validMoves.get(0).getX()==2 && rook.validMoves.get(0).getY()==4);
		assertTrue(rook.validMoves.get(1).getX()==1 && rook.validMoves.get(1).getY()==4);
		assertTrue(rook.validMoves.get(2).getX()==0 && rook.validMoves.get(2).getY()==4);
		assertTrue(rook.validMoves.get(3).getX()==3 && rook.validMoves.get(3).getY()==5);
		assertTrue(rook.validMoves.get(4).getX()==3 && rook.validMoves.get(4).getY()==6);
		assertTrue(rook.validMoves.get(5).getX()==3 && rook.validMoves.get(5).getY()==7);
		assertTrue(rook.validMoves.get(6).getX()==3 && rook.validMoves.get(6).getY()==3);
		assertTrue(rook.validMoves.get(7).getX()==3 && rook.validMoves.get(7).getY()==2);
		assertTrue(rook.validMoves.get(8).getX()==3 && rook.validMoves.get(8).getY()==1);
		assertTrue(rook.validMoves.get(9).getX()==3 && rook.validMoves.get(9).getY()==0);
	}
	
	
}
