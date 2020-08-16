package testset;


import org.powermock.api.support.membermodification.MemberModifier;
import jogador.Player;
import piece.Piece;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class PlayerTest {

	private Player player;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		player = new Player(0);
	}
	@Test
	public void testSetTeam() {
		player.setTeam(0);
		assertEquals(player.getTeam(),0);
	}
	@Test
	public void testPiecesKilled() throws IllegalArgumentException, IllegalAccessException {
		player.setPiecesKilled();
		assertEquals(MemberModifier.field(Player.class, "pieces_killed").get(player),1);
	}
	@Test
	public void testSetScore() {
		player.setScore();
		assertEquals(player.getScore(),1);
	}

	@Test
	public void testAddPiece() throws Exception {
		ArrayList<Piece> aux = new ArrayList<Piece>();
		
		Piece piece= new Piece();
		player.addPiece(piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(Player.class, "playerPieces").get(player);
		assertEquals(aux.get(0), piece);
	}
	@Test
	public void testAddPiece_() throws Exception {
		ArrayList<Piece> aux = new ArrayList<Piece>();
		
		Piece piece= new Piece();
		player.addPiece(0,piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(Player.class, "playerPieces").get(player);
		assertEquals(aux.get(0), piece);
	}
	@Test
	public void testRemovePiece() throws Exception {
		ArrayList<Piece> aux = new ArrayList<Piece>();
		
		Piece piece= new Piece(3,3,0);
		player.addPiece(piece);
		player.removePiece(piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(Player.class, "playerPieces").get(player);
		assertEquals(aux.size(),0);
	}
	
	@Test
	public void testRemovePiece_() throws Exception {
		ArrayList<Piece> aux = new ArrayList<Piece>();

		Piece piece= new Piece(3,3,0);
		
		player.removePiece(piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(Player.class, "playerPieces").get(player);
		assertEquals(aux.size(),0);
	}
	

}
