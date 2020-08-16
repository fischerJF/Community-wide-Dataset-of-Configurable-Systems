package testset;



import org.powermock.api.support.membermodification.MemberModifier;
import jogador.AI_Player;
import piece.Piece;
import piece.PieceType;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class AI_PlayerTest {

	private AI_Player player;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
		player = new AI_Player(2);
	}
	@Test
	public void testSetTeam() {
		if(Configuration.AI_PLAYER) {
		player.setTeam(0);
		assertEquals(player.getTeam(),0);
		}
	}
	@Test
	public void testPiecesKilled() throws IllegalArgumentException, IllegalAccessException {
		if(Configuration.AI_PLAYER) {
		player.setPiecesKilled();
		assertEquals(MemberModifier.field(AI_Player.class, "pieces_killed").get(player),1);
		}
	}
	@Test
	public void testSetScore() {
		if(Configuration.AI_PLAYER) {
		player.setScore();
		assertEquals(player.getScore(),1);
		}
	}

	@Test
	public void testAddPiece() throws Exception {
		if(Configuration.AI_PLAYER) {
		ArrayList<Piece> aux = new ArrayList<Piece>();
		
		Piece piece= new Piece();
		player.addPiece(piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(AI_Player.class, "playerPieces").get(player);
		assertEquals(aux.get(0), piece);
		}
	}
	@Test
	public void testRemovePiece() throws Exception {
		if(Configuration.AI_PLAYER) {
		ArrayList<Piece> aux = new ArrayList<Piece>();
		
		Piece piece= new Piece(3,3,0);
		player.addPiece(piece);
		player.removePiece(piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(AI_Player.class, "playerPieces").get(player);
		assertEquals(aux.size(),0);
		}
	}
	
	@Test
	public void testRemovePiece_() throws Exception {
		if(Configuration.AI_PLAYER) {
		ArrayList<Piece> aux = new ArrayList<Piece>();

		Piece piece= new Piece(3,3,0);
		
		player.removePiece(piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(AI_Player.class, "playerPieces").get(player);
		assertEquals(aux.size(),0);
		}
	}
	@Test
	public void testAddPiece_() throws Exception {
		if(Configuration.AI_PLAYER) {
		ArrayList<Piece> aux = new ArrayList<Piece>();
		
		Piece piece= new Piece();
		player.addPiece(0,piece);
		
		aux=(ArrayList<Piece>) MemberModifier.field(AI_Player.class, "playerPieces").get(player);
		assertEquals(aux.get(0), piece);
		}
	}
	
	@Test
	public void testGetPieceScore() {
		assertEquals(player.getPieceScore(PieceType.PAWN),10);
		assertEquals(player.getPieceScore(PieceType.KNIGHT),30);
		assertEquals(player.getPieceScore(PieceType.BISHOP),40);
		assertEquals(player.getPieceScore(PieceType.ROOK),50);
		assertEquals(player.getPieceScore(PieceType.QUEEN),90);
		assertEquals(player.getPieceScore(PieceType.KING),99999);
		
		
	}
    
	@Test
	public void testGetPositionWeight() {
		if(Configuration.AI_PLAYER) {
		int[][] positionWeight;
		positionWeight=player.getPositionWeight();
		int cont=0;
		for(int x=0; x<8; x++) {
			assertEquals(positionWeight[0][x],1);
			assertEquals(positionWeight[1][x],2);
			assertEquals(positionWeight[6][x],2);
			assertEquals(positionWeight[7][x],1);
			if(x==0 || x==7) {
				assertEquals(positionWeight[2][x],2);
			}else {
				assertEquals(positionWeight[2][x],3);
			}
			if( (x>=0 && x<=1) || (x>=6 && x<=7) ) {
				assertEquals(positionWeight[5][x],2);
			}else {
				assertEquals(positionWeight[5][x],3);
			}
			if(x==0) {
				cont=2;
			}else if(x<=3) {
				cont++;
			}else if(x!=4) {
				cont--;
			}
			assertEquals(positionWeight[3][x],cont);
			if(x==2) {
				assertEquals(positionWeight[4][x],3);
			}else {
				assertEquals(positionWeight[4][x],cont);
			}
		}
	}
		}
}
