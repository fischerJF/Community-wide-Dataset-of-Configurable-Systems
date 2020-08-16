package testset;


import org.powermock.api.support.membermodification.MemberModifier;

import piece.Piece;
import piece.PieceType;
import piece.Queen;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class QueenTest {

	private Queen queen;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		queen= new Queen(3,4,0);
	}


	@Test
	public void testBishop() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Queen.class, "pt").set(queen , PieceType.QUEEN);
		assertEquals(queen.getType(),PieceType.QUEEN);
		assertEquals(queen.getTeam(),0);
		assertEquals(queen.getLocX(),3);
		assertEquals(queen.getLocY(),4);
		queen.setTeam(1);
		assertEquals(1, queen.getTeam());

	}
	
	@Test
	public void testUpdatePosition() {
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		queen.updatePosition(friend, enemy);

		for (int i = 0; i < queen.validMoves.size(); i++) {
			System.err.println(queen.validMoves.get(i).getX()+"   "+ queen.validMoves.get(i).getY());
		}
		
        assertTrue(queen.validMoves.get(0).getX()==3 && queen.validMoves.get(0).getY()==3);
		assertTrue(queen.validMoves.get(1).getX()==3 && queen.validMoves.get(1).getY()==2);
		assertTrue(queen.validMoves.get(2).getX()==3 && queen.validMoves.get(2).getY()==1);
		assertTrue(queen.validMoves.get(3).getX()==3 && queen.validMoves.get(3).getY()==0);
		assertTrue(queen.validMoves.get(4).getX()==3 && queen.validMoves.get(4).getY()==5);
		assertTrue(queen.validMoves.get(5).getX()==3 && queen.validMoves.get(5).getY()==6);
		assertTrue(queen.validMoves.get(6).getX()==3 && queen.validMoves.get(6).getY()==7);
		assertTrue(queen.validMoves.get(7).getX()==2 && queen.validMoves.get(7).getY()==4);
		assertTrue(queen.validMoves.get(8).getX()==1 && queen.validMoves.get(8).getY()==4);
		assertTrue(queen.validMoves.get(9).getX()==0 && queen.validMoves.get(9).getY()==4);
		assertTrue(queen.validMoves.get(10).getX()==4 && queen.validMoves.get(10).getY()==3);
		assertTrue(queen.validMoves.get(11).getX()==5 && queen.validMoves.get(11).getY()==2);
		assertTrue(queen.validMoves.get(12).getX()==6 && queen.validMoves.get(12).getY()==1);
		assertTrue(queen.validMoves.get(13).getX()==7 && queen.validMoves.get(13).getY()==0);
		assertTrue(queen.validMoves.get(14).getX()==2 && queen.validMoves.get(14).getY()==3);
		assertTrue(queen.validMoves.get(15).getX()==1 && queen.validMoves.get(15).getY()==2);
		assertTrue(queen.validMoves.get(16).getX()==0 && queen.validMoves.get(16).getY()==1);
		assertTrue(queen.validMoves.get(17).getX()==4 && queen.validMoves.get(17).getY()==5);
		assertTrue(queen.validMoves.get(18).getX()==5 && queen.validMoves.get(18).getY()==6);
		assertTrue(queen.validMoves.get(19).getX()==6 && queen.validMoves.get(19).getY()==7);
		assertTrue(queen.validMoves.get(20).getX()==2 && queen.validMoves.get(20).getY()==5);
		assertTrue(queen.validMoves.get(21).getX()==1 && queen.validMoves.get(21).getY()==6);
		assertTrue(queen.validMoves.get(22).getX()==0 && queen.validMoves.get(22).getY()==7);

		assertFalse(queen.validMoves.size()>23);
	}
	
	@Test
	public void testUpdatePosition_2() {
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		friend.add(new Piece(2,3,0));
		friend.add(new Piece(4,3,0));
		friend.add(new Piece(4,5,0));
		friend.add(new Piece(2,3,0));
		friend.add(new Piece(2,5,0));
		friend.add(new Piece(3,3,0));
		friend.add(new Piece(3,5,0));
		friend.add(new Piece(4,4,0));
		friend.add(new Piece(2,4,0));
		
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		
		queen.updatePosition(friend, enemy);
		
		for (int i = 0; i < queen.validMoves.size(); i++) {
			System.err.println(queen.validMoves.get(i).getX()+"   "+ queen.validMoves.get(i).getY());
		}
		assertTrue(queen.validMoves.size()==0);
	}
	@Test
	public void testUpdatePosition_West() {
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		friend.add(new Piece(3,3,0));
		
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		
		queen.updatePosition(friend, enemy);

		for (int i = 0; i < queen.validMoves.size(); i++) {
			System.err.println(queen.validMoves.get(i).getX()+"   "+ queen.validMoves.get(i).getY());
		}
	
		assertFalse(queen.validMoves.get(0).getX()==3 && queen.validMoves.get(0).getY()==2);
		assertFalse(queen.validMoves.get(0).getX()==3 && queen.validMoves.get(0).getY()==1);
		assertFalse(queen.validMoves.get(0).getX()==3 && queen.validMoves.get(0).getY()==0);
		
	}
	
}
