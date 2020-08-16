package testset;


import org.powermock.api.support.membermodification.MemberModifier;
import piece.Piece;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.awt.Point;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;
import org.powermock.reflect.Whitebox;

public class PieceTest {

	private Piece piece;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		piece= new Piece(3,4,0);
	}


	@Test
	public void testPiece() throws IllegalArgumentException, IllegalAccessException {
	    Piece p1 =new Piece();
		assertEquals(p1.getTeam(),-1);
		assertEquals(MemberModifier.field(Piece.class, "validMoves").get(p1), null);
		assertEquals(MemberModifier.field(Piece.class, "location").get(p1), null);
		assertEquals(MemberModifier.field(Piece.class, "icon").get(p1), null);
	}
	@Test
	public void testPiece_() throws IllegalArgumentException, IllegalAccessException {
		Piece p1 =new Piece(piece);
		piece.setLocation(0, 0);
		ArrayList<Point> aux = new ArrayList<Point>();
		p1.validMoves=aux;
		
		assertEquals(piece.getLocation(), p1.getLocation());
		assertEquals(piece.getTeam(), p1.getTeam());
		assertEquals(piece.validMoves, p1.validMoves);
	}
	@Test
	public void testDeletePiece() throws IllegalArgumentException, IllegalAccessException {
	    piece.deletePiece(0, 0);
		assertEquals(MemberModifier.field(Piece.class, "icon").get(piece), null);
		assertEquals(piece.getTeam(), -1);
		Point p = new Point(0,0);
		assertTrue(piece.getLocation().getX()== p.getX());
		assertTrue(piece.getLocation().getY()== p.getY());
		
	}
	@Test
	public void testSetFirstMove() throws IllegalArgumentException, IllegalAccessException {
		piece.setFirstMove(true);
		assertEquals(MemberModifier.field(Piece.class, "firstMove").get(piece), true);
	}
	
	@Test
	public void containsTest() throws Exception {
		Piece p1 =new Piece(piece);
		piece.setLocation(0, 0);
		ArrayList<Piece> aux = new ArrayList<Piece>();
		
		Point p= (Point) MemberModifier.field(Piece.class, "location").get(piece);
		Point p2= new Point(90,90);
		for (int i = 0; i < 10; i++) {
			aux.add(piece);
		}
		boolean b= (boolean) Whitebox.invokeMethod(piece, "contains", aux,p);
		boolean b2= (boolean) Whitebox.invokeMethod(piece, "contains", aux,p2);
		assertTrue(b);
		assertFalse(b2);
		
	}
}
