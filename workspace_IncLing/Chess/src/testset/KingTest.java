package testset;


import org.powermock.api.support.membermodification.MemberModifier;
import piece.King;
import piece.Piece;
import piece.PieceType;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class KingTest {

	private King king;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		king= new King(3,4,0);
	}


	@Test
	public void testBishop() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(King.class, "pt").set(king , PieceType.KING);
		assertEquals(king.getType(),PieceType.KING);
		assertEquals(king.getTeam(),0);
		assertEquals(king.getLocX(),3);
		assertEquals(king.getLocY(),4);
		king.setTeam(1);
		assertEquals(1, king.getTeam());
	}
	
	@Test
	public void testUpdatePosition() {
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		king.updatePosition(friend, enemy);
        assertTrue(king.validMoves.get(0).getX()==2 && king.validMoves.get(0).getY()==4);
		assertTrue(king.validMoves.get(1).getX()==3 && king.validMoves.get(1).getY()==5);
		assertTrue(king.validMoves.get(2).getX()==3 && king.validMoves.get(2).getY()==3);
		assertTrue(king.validMoves.get(3).getX()==2 && king.validMoves.get(3).getY()==5);
		assertTrue(king.validMoves.get(4).getX()==2 && king.validMoves.get(4).getY()==3);
		assertTrue(king.validMoves.get(5).getX()==4 && king.validMoves.get(5).getY()==5);
		assertTrue(king.validMoves.get(6).getX()==4 && king.validMoves.get(6).getY()==3);
		}
}
