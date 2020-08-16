package testset;


import org.powermock.api.support.membermodification.MemberModifier;
import piece.Knight;
import piece.Piece;
import piece.PieceType;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class KnightTest {

	private Knight knight;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		knight= new Knight(3,4,0);
	}


	@Test
	public void testBishop() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Knight.class, "pt").set(knight , PieceType.KNIGHT);
		assertEquals(knight.getType(),PieceType.KNIGHT);
		assertEquals(knight.getTeam(),0);
		assertEquals(knight.getLocX(),3);
		assertEquals(knight.getLocY(),4);
		knight.setTeam(1);
		assertEquals(1, knight.getTeam());
	}
	
	@Test
	public void testUpdatePosition() {
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		knight.updatePosition(friend, enemy);
		System.out.println(knight.validMoves);

	    assertTrue(knight.validMoves.get(0).getX()==5 && knight.validMoves.get(0).getY()==3);
		assertTrue(knight.validMoves.get(1).getX()==5 && knight.validMoves.get(1).getY()==5);
		assertTrue(knight.validMoves.get(2).getX()==1 && knight.validMoves.get(2).getY()==5);
		assertTrue(knight.validMoves.get(3).getX()==1 && knight.validMoves.get(3).getY()==3);
		assertTrue(knight.validMoves.get(4).getX()==4 && knight.validMoves.get(4).getY()==2);
		assertTrue(knight.validMoves.get(5).getX()==2 && knight.validMoves.get(5).getY()==2);
		assertTrue(knight.validMoves.get(6).getX()==4 && knight.validMoves.get(6).getY()==6);
		assertTrue(knight.validMoves.get(7).getX()==2 && knight.validMoves.get(7).getY()==6);
		}
}
