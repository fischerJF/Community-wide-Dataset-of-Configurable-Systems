package testset;



import org.powermock.api.support.membermodification.MemberModifier;
import piece.Bishop;
import piece.Piece;
import piece.PieceType;
import piece.Rook;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class BishopTest {

	private Bishop bishop;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		bishop= new Bishop(3,4,0);
	}


	@Test
	public void testBishop() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Rook.class, "pt").set(bishop , PieceType.BISHOP);
		assertEquals(bishop.getType(),PieceType.BISHOP);
		assertEquals(bishop.getTeam(),0);
		assertEquals(bishop.getLocX(),3);
		assertEquals(bishop.getLocY(),4);
		bishop.setTeam(1);
		assertEquals(1, bishop.getTeam());
	}
	
	@Test
	public void testUpdatePosition() {
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		bishop.updatePosition(friend, enemy);

        assertTrue(bishop.validMoves.get(0).getX()==2 && bishop.validMoves.get(0).getY()==5);
		assertTrue(bishop.validMoves.get(1).getX()==1 && bishop.validMoves.get(1).getY()==6);
		assertTrue(bishop.validMoves.get(2).getX()==0 && bishop.validMoves.get(2).getY()==7);
		assertTrue(bishop.validMoves.get(3).getX()==2 && bishop.validMoves.get(3).getY()==3);
		assertTrue(bishop.validMoves.get(4).getX()==1 && bishop.validMoves.get(4).getY()==2);
		assertTrue(bishop.validMoves.get(5).getX()==0 && bishop.validMoves.get(5).getY()==1);
		assertTrue(bishop.validMoves.get(6).getX()==4 && bishop.validMoves.get(6).getY()==5);
		assertTrue(bishop.validMoves.get(7).getX()==5 && bishop.validMoves.get(7).getY()==6);
		assertTrue(bishop.validMoves.get(8).getX()==6 && bishop.validMoves.get(8).getY()==7);
		assertTrue(bishop.validMoves.get(9).getX()==4 && bishop.validMoves.get(9).getY()==3);
		assertTrue(bishop.validMoves.get(10).getX()==5 && bishop.validMoves.get(10).getY()==2);
		assertTrue(bishop.validMoves.get(11).getX()==6 && bishop.validMoves.get(11).getY()==1);
		assertTrue(bishop.validMoves.get(12).getX()==7 && bishop.validMoves.get(12).getY()==0);
	}
}
