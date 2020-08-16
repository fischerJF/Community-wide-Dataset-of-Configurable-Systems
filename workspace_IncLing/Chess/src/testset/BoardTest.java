package testset;



import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import MVC.MVC;
import jogador.Player;
import model.Board;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Piece;
import piece.PieceType;
import piece.Rook;
import piece.Space;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;


import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;


public class BoardTest {

	private Board board;
	
	@Before
	public void setUp() { 
//		Configuration.AI_PLAYER=true;
//		Configuration.OFFLINE_PLAYER=true;
//		Configuration.ONLINE_PLAYER=true;
//		
		board= new Board();
	}

	@Test
	public void testPieceExists() {
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				assertTrue(board.pieceExists(x,y));
			}
		}
	}
	
//	@Test
	public void testCheckKings() throws IllegalArgumentException, IllegalAccessException  {
			
		assertTrue(board.checkKings());
		ArrayList<Piece> p = new ArrayList<Piece>();
		ArrayList<Piece> p2 = new ArrayList<Piece>();
		Player j0_mock = PowerMockito.mock(Player.class);
		Player j1_mock = PowerMockito.mock(Player.class);
		PowerMockito.when(j0_mock.getPlayerPieces()).thenReturn(p);
		PowerMockito.when(j1_mock.getPlayerPieces()).thenReturn(p2);
		
		MemberModifier.field(Board.class, "j0").set(board , j0_mock);
		MemberModifier.field(Board.class, "j1").set(board , j1_mock);
		assertFalse(board.checkKings());
		
	}
	//@Test
	public void testCheckKings_() throws IllegalArgumentException, IllegalAccessException  {
		Configuration.OFFLINE_PLAYER=true;
		assertTrue(board.checkKings());
		ArrayList<Piece> p = new ArrayList<Piece>();
		Player j0_mock = PowerMockito.mock(Player.class);
		PowerMockito.when(j0_mock.getPlayerPieces()).thenReturn(p);
		MemberModifier.field(Board.class, "j0").set(board , j0_mock);
		
		
		assertTrue(board.checkKings());
		
	}
	
	@Test
	public void testBoard() {
	
		if(Configuration.AI_PLAYER) {
			board=new Board(1);
			assertTrue(board.getAI()!=null);
			
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					assertTrue(board.pieceExists(x,y));
				}
			}
		}
		if(Configuration.OFFLINE_PLAYER || Configuration.ONLINE_PLAYER) {
			board=new Board(0);
			assertTrue(board.getJ0()!=null && board.getJ1()!=null);
		}
	}
	@Test
	public void testGetType() {
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				if(x==0 || x==1) {
					assertTrue(board.getType(x,y)!= null);
				}
			}
		}
	}
	@Test
	public void testChangePosition() throws Exception {
       if(Configuration.ONLINE_PLAYER|| Configuration.OFFLINE_PLAYER) {
		Piece p = new Rook(3,4,1);
		int x=p.getLocX();
		int y=p.getLocY();
		
		
		board.changePosition(1, 4, p);
		assertTrue(board.getType(1,4)==p.getType());
		assertTrue(board.getPiece(1, 4)!=null);
		assertTrue(board.getPiece(x, y)==null);
	
		boolean aux=false;
		for(int i=0; i<p.validMoves.size(); i++) {
			if(p.validMoves.get(i).getX()==3 &&
					p.validMoves.get(i).getY()==4) {
				aux=true;
			}
		}
		assertTrue(aux);
       }
	}
	
	@Test
	public void testAddPiece() throws Exception {
		Piece piece; 
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				piece = new Piece(x,y,0);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y);
				assertEquals(board.getPiece(x, y),piece);
			}
		}
		System.out.println();
	}
	@Test
	public void testAddPieceWithIndex() throws Exception {
		Piece piece; 
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				piece = new Piece(x,y,0);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y,0);
				assertEquals(board.getPiece(x, y),piece);
			}
		}
	}
	@Test
	public void testRemovePiece() throws Exception{
		Piece piece; 
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				piece = new Piece(x,y,0);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y,0);
			}
		}
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				board.removePiece(x, y);
				assertEquals(board.getPiece(x, y),null);
			}
		}
		if(Configuration.AI_PLAYER) {
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					piece = new Piece(x,y,1);
					Whitebox.invokeMethod(board, "addPiece", piece, x, y,0);
				}
			}
			for(int x=0; x<8; x++) {
				for(int y=0; y<8; y++) {
					board.removePiece(x, y);
					assertEquals(board.getPiece(x, y),null);
				}
			}
		}
	}
	
	@Test
	public void testIsPlayerPiece() throws Exception {
		Piece piece; 
		for(int x=0; x<7; x++) {
			for(int y=0; y<7; y++) {
				piece = new Piece(x,y,0);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y,0);
			}
		}
		assertTrue(board.isPlayerPiece(1, 1, 0));
		assertFalse(board.isPlayerPiece(1, 1, 1));
		assertFalse(board.isPlayerPiece(7, 7, 1));
		
		Board c = new Board();
		piece = new Piece(1,1,0);
		
		Whitebox.invokeMethod(c, "addPiece", piece, 1, 1,0);
		assertFalse(c.isPlayerPiece(2, 2, 0));
		
	}
	@Test
	public void testGetTeam() throws Exception {
		Piece piece; 
		for(int x=0; x<7; x++) {
			for(int y=0; y<7; y++) {
				piece = new Piece(x,y,0);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y,0);
				assertEquals(board.getTeam(x, y),0);			}
		}
	}
	
	@Test
	public void testGetBestPiece() throws IllegalArgumentException, IllegalAccessException {
		Piece piece= new Piece(1,1,0);
		MemberModifier.field(Board.class, "bestPiece").set(board , piece);
		assertEquals(board.getBestPiece(),piece);
	}
	@Test
	public void testGetBestX() throws IllegalArgumentException, IllegalAccessException {
		
		MemberModifier.field(Board.class, "bestMoveX").set(board , 1);
		assertEquals(board.getBestX(),1);
	}
	@Test
	public void testGetBestY() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Board.class, "bestMoveY").set(board , 2);
		assertEquals(board.getBestY(),2);
	}
	@Test
	public void testWhiteKingCheck() throws Exception {
		if(Configuration.AI_PLAYER) {
		Piece piece = new Piece(2,2,0);
		piece.setType(PieceType.KING);
		Whitebox.invokeMethod(board, "addPiece", piece, 2, 2,0);
		assertEquals(board.getType(2, 2), PieceType.KING);
		assertTrue(board.whiteKingCheck(false));
		
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				piece = new Piece(x,y,0);
				piece.setType(PieceType.KNIGHT);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y,0);
			}
		}
		assertFalse(board.whiteKingCheck(false));
		}
	}
	@Test
	public void testBlackKingCheck() throws Exception {
		if(Configuration.AI_PLAYER && Configuration.OFFLINE_PLAYER ) {
			Piece piece ; 
			
			for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				piece = new Piece(x,y,1);
				piece.setType(PieceType.KING);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y,1);
			}
		}
		assertTrue(board.blackKingCheck());
		for(int x=0; x<8; x++) {
			for(int y=0; y<8; y++) {
				piece = new Piece(x,y,1);
				piece.setType(PieceType.KNIGHT);
				Whitebox.invokeMethod(board, "addPiece", piece, x, y,1);
		     }
	     }
		assertFalse(board.blackKingCheck());
		}
	}
	@Test
	public void testIsValid() throws Exception {
		
		
		if(Configuration.OFFLINE_PLAYER || Configuration.ONLINE_PLAYER) {
		Piece piece ; 
		piece = new Rook(3,4,0);
		piece.setType(PieceType.ROOK);
		
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		piece.updatePosition(friend, enemy);
		Whitebox.invokeMethod(board, "addPiece", piece, 3, 4,0);
		assertTrue(board.isValid(4, 4, piece));
		assertTrue(board.isValid(5, 4, piece));
		assertFalse(board.isValid(0, 0, piece));
		}
	}
	@Test
	public void testIsValid_() throws Exception, IllegalArgumentException, IllegalAccessException  {
		Piece piece ; 
		piece = new Pawn(3,4,0);
		piece.setType(PieceType.PAWN);
		
		ArrayList<Piece> friend = new ArrayList<Piece>();
		friend.add(new Piece(0,0,0));
		ArrayList<Piece> enemy = new ArrayList<Piece>();
		friend.add(new Piece(4,4,0));
		piece.updatePosition(friend, enemy);
		Whitebox.invokeMethod(board, "addPiece", piece, 3, 4,0);
		assertTrue(board.isValid(2, 4, piece));
		boolean b=(Boolean) MemberModifier.field(Pawn.class, "firstMove").get(piece);
		assertFalse(b);
		
	}
	@Test
	public void testBestMove() throws Exception, IllegalArgumentException, IllegalAccessException  {
      
//		Configuration.AI_PLAYER=true;
		if(Configuration.AI_PLAYER) {
			Piece piece;
			piece = new Pawn(3, 4, 1);
			piece.setType(PieceType.PAWN);
			board = new Board(1);

			ArrayList<Piece> friend = new ArrayList<Piece>();
			friend.add(new Piece(0, 0, 1));
			ArrayList<Piece> enemy = new ArrayList<Piece>();
			friend.add(new Piece(4, 4, 1));
			piece.updatePosition(friend, enemy);
			Whitebox.invokeMethod(board, "addPiece", piece, 3, 4, 1);
			board.bestMove(3, 4);
			assertTrue(board.getBestX() != 0 && board.getBestY() != 0);
	   //	   assertTrue(board.isValid(2, 4, piece));
//	   boolean b=(Boolean) MemberModifier.field(Pawn.class, "firstMove").get(piece);
//	   assertFalse(b);
		}
	  
	}
	
	@Test
	public void testWhite_check_mate() throws Exception {
		
		
		if(	Configuration.OFFLINE_PLAYER &&Configuration.AI_PLAYER) {
		Piece piece;
		 
		 piece = new King(0, 1, 0);
		 Whitebox.invokeMethod(board, "addPiece", piece, 0, 1, 0);
		 
		 piece = new Rook(0, 6, 1);
		 Whitebox.invokeMethod(board, "addPiece", piece, 0, 6, 1);
		 
		 piece = new Pawn(1, 0, 0);
		 Whitebox.invokeMethod(board, "addPiece", piece, 1, 0, 0);
		 
		 piece = new Pawn(1, 2, 0);
		 Whitebox.invokeMethod(board, "addPiece", piece, 1, 2, 0);
		 
		 piece = new Pawn(3, 1, 0);
		 Whitebox.invokeMethod(board, "addPiece", piece, 3, 1, 0);
		 
		 piece = new Bishop(4, 4, 1);
		 Whitebox.invokeMethod(board, "addPiece", piece, 4, 4, 1);
		 
		 Space[][] space=null;
		 space=(Space[][]) MemberModifier.field(Board.class, "board").get(board);
		 
		assertTrue(board.white_check_mate(false));
		}
	}
	
	@Test
	public void testBlack_check_mate1() throws Exception {
		Piece piece;
		
		piece = new King(7, 5, 1);
		Whitebox.invokeMethod(board, "addPiece", piece, 7, 5, 1);
		
		piece = new Knight(6, 5, 0);
		Whitebox.invokeMethod(board, "addPiece", piece, 0, 6, 0);
		
		piece = new King(5, 4, 1);
		Whitebox.invokeMethod(board, "addPiece", piece, 5, 4, 1);
		
		Space[][] space=null;
		space=(Space[][]) MemberModifier.field(Board.class, "board").get(board);
		
		assertTrue(board.black_check_mate());
	}
	@Test
	public void testBlack_check_mate2() throws Exception {
		Piece piece;
		
		piece = new Rook(6, 7, 0);
		Whitebox.invokeMethod(board, "addPiece", piece, 6, 7, 0);
		
		piece = new King(2, 5, 0);
		Whitebox.invokeMethod(board, "addPiece", piece, 2, 5, 0);
		
		piece = new King(2, 7, 1);
		Whitebox.invokeMethod(board, "addPiece", piece, 2, 7, 1);
		
		Space[][] space=null;
		space=(Space[][]) MemberModifier.field(Board.class, "board").get(board);
		
		assertTrue(board.black_check_mate());
	}
	
	@Test
	public void testBlack_check_mate3() throws Exception {
		Piece piece;
		
		piece = new King(7, 7, 0);
		Whitebox.invokeMethod(board, "addPiece", piece, 7, 7, 0);
		
		piece = new King(6, 2, 1);
		Whitebox.invokeMethod(board, "addPiece", piece, 6, 2, 1);
		
		piece = new King(4, 2, 1);
		Whitebox.invokeMethod(board, "addPiece", piece, 4, 2, 1);
		
		piece = new King(3, 4, 1);
		Whitebox.invokeMethod(board, "addPiece", piece, 3, 4, 1);
		
		Space[][] space=null;
		space=(Space[][]) MemberModifier.field(Board.class, "board").get(board);
		
		
		assertTrue(board.black_check_mate());
	}
	
	
	@Test
	public void testBuildWhite() throws Exception {
		Whitebox.invokeMethod(board, "buildWhite");
		Space[][] space=null;
		space=(Space[][]) MemberModifier.field(Board.class, "board").get(board);
		assertEquals(space[7][0].getPiece().getType(), PieceType.ROOK);
		
		Player p = (Player) MemberModifier.field(Board.class, "j0").get(board);
		assertEquals(p.getPlayerPieces().get(8).getType(), PieceType.ROOK);
		assertEquals(p.getPlayerPieces().get(8).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(8).getLocY(), 0);
		
		assertEquals(space[7][7].getPiece().getType(), PieceType.ROOK);
		assertEquals(p.getPlayerPieces().get(9).getType(), PieceType.ROOK);
		assertEquals(p.getPlayerPieces().get(9).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(9).getLocY(), 7);
		
		assertEquals(space[7][1].getPiece().getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(10).getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(10).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(10).getLocY(), 1);
		
		assertEquals(space[7][6].getPiece().getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(11).getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(11).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(11).getLocY(), 6);
	
		assertEquals(space[7][2].getPiece().getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(12).getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(12).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(12).getLocY(), 2);

		assertEquals(space[7][5].getPiece().getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(13).getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(13).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(13).getLocY(), 5);

		assertEquals(space[7][3].getPiece().getType(), PieceType.QUEEN);
		assertEquals(p.getPlayerPieces().get(14).getType(), PieceType.QUEEN);
		assertEquals(p.getPlayerPieces().get(14).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(14).getLocY(), 3);

		
		assertEquals(space[7][4].getPiece().getType(), PieceType.KING);
		assertEquals(p.getPlayerPieces().get(15).getType(), PieceType.KING);
		assertEquals(p.getPlayerPieces().get(15).getLocX(), 7);
		assertEquals(p.getPlayerPieces().get(15).getLocY(), 4);
		
		for(int i = 0; i < 8; i++){
			assertEquals(space[6][i].getPiece().getType(), PieceType.PAWN);
			assertEquals(p.getPlayerPieces().get(i).getType(), PieceType.PAWN);
			assertEquals(p.getPlayerPieces().get(i).getLocX(), 6);
			assertEquals(p.getPlayerPieces().get(i).getLocY(), i);
		}
		
	}
	
	@Test
	public void testBuildBlack()throws Exception {
		Whitebox.invokeMethod(board, "buildWhite");
		Space[][] space=null;
		
		Player p = (Player) MemberModifier.field(Board.class, "j1").get(board);

		space=(Space[][]) MemberModifier.field(Board.class, "board").get(board);
	
		assertEquals(space[0][0].getPiece().getType(), PieceType.ROOK);
		assertEquals(p.getPlayerPieces().get(8).getType(), PieceType.ROOK);
		assertEquals(p.getPlayerPieces().get(8).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(8).getLocY(), 0);
		
		
		assertEquals(space[0][7].getPiece().getType(), PieceType.ROOK);
		assertEquals(p.getPlayerPieces().get(9).getType(), PieceType.ROOK);
		assertEquals(p.getPlayerPieces().get(9).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(9).getLocY(), 7);
		
		assertEquals(space[0][1].getPiece().getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(10).getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(10).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(10).getLocY(), 1);
		
		
		assertEquals(space[0][6].getPiece().getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(11).getType(), PieceType.KNIGHT);
		assertEquals(p.getPlayerPieces().get(11).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(11).getLocY(), 6);
		
		assertEquals(space[0][2].getPiece().getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(12).getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(12).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(12).getLocY(), 2);

		
		assertEquals(space[0][5].getPiece().getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(13).getType(), PieceType.BISHOP);
		assertEquals(p.getPlayerPieces().get(13).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(13).getLocY(), 5);

		assertEquals(space[0][3].getPiece().getType(), PieceType.QUEEN);
		assertEquals(p.getPlayerPieces().get(14).getType(), PieceType.QUEEN);
		assertEquals(p.getPlayerPieces().get(14).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(14).getLocY(), 3);

		assertEquals(space[0][4].getPiece().getType(), PieceType.KING);
		assertEquals(p.getPlayerPieces().get(15).getType(), PieceType.KING);
		assertEquals(p.getPlayerPieces().get(15).getLocX(), 0);
		assertEquals(p.getPlayerPieces().get(15).getLocY(), 4);
		
		for(int i = 0; i < 8; i++){
			assertEquals(space[1][i].getPiece().getType(), PieceType.PAWN);
			assertEquals(p.getPlayerPieces().get(i).getType(), PieceType.PAWN);
			assertEquals(p.getPlayerPieces().get(i).getLocX(), 1);
			assertEquals(p.getPlayerPieces().get(i).getLocY(), i);
		}
	}

}
