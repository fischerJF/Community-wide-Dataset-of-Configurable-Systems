package model;
import gui.*;
import jogador.*;
import piece.*;
import specifications.Configuration;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class Board{
	Player j0;
	Player j1;
	AI_Player AI;
	int mode;
	Memento m;
	private int bestMoveX = 0, bestMoveY = 0;
	private Piece bestPiece = null;

	private Piece lastPieceMoved;
	private Piece lastPieceTaken;
	private Point lastPoint;

	// Point
	protected Space[][] board;

	public Board(){
		board = new Space[8][8];
		buildBoard();
	}

  public boolean checkKings() {
    ArrayList<Piece> check;
    check = j0.getPlayerPieces();
    for (int i = 0; i < check.size(); i++) {
      if( check.get(i).getType() == PieceType.KING ) {
        return true;
      }
    }
    check = j1.getPlayerPieces();
    for (int i = 0; i < check.size(); i++) {
      if( check.get(i).getType() == PieceType.KING ) {
        return true;
      }
    }
    return false;

  }

	public Board(int x){
		board = new Space[8][8];
		buildBoard(x);
		setMode(x);
		lastPieceTaken = null;
		lastPieceMoved = null;
		lastPoint = null;
	}


	public void buildBoard(){
		j0 = new Player(0);
		j1 = new Player(1);
		buildWhite();
		buildBlack();
		buildMiddle();
		updateValidMove();
	}

	public void buildBoard(int x){
		if(x == 0){
			buildSingle();
			buildWhite();
			buildBlack();
			buildMiddle();
			updateValidMove();
		}
		else if(x == 1){
			if(Configuration.AI_PLAYER) {
				buildAI();
			}
			buildWhite();
			if(Configuration.AI_PLAYER) {
				buildAIPieces();
			}
			buildMiddle();
			if(Configuration.AI_PLAYER) {
				AIupdateValidMove();
			}
		}
	}

	private void setMode(int mode){
		this.mode = mode;
	}

	public void buildSingle(){
	 if(Configuration.OFFLINE_PLAYER || Configuration.ONLINE_PLAYER) {
		j0 = new Player(0);
		j1 = new Player(1);
	 }
	}

	public void buildAI(){
		j0 = new Player(0);
		if(Configuration.AI_PLAYER) {
			AI = new AI_Player(1);
		}
	}

	private void buildAIPieces(){
		for(int i = 0; i < 8; i++){
			board[1][i] = new Space(new Pawn(1,i,1));
			AI.addPiece(board[1][i].getPiece());
		}

		board[0][0] = new Space(new Rook(0,0,1));
		board[0][7] = new Space(new Rook(0,7,1));
		AI.addPiece(board[0][0].getPiece());
		AI.addPiece(board[0][7].getPiece());

		board[0][1] = new Space(new Knight(0,1,1));
		board[0][6] = new Space(new Knight(0,6,1));
		AI.addPiece(board[0][1].getPiece());
		AI.addPiece(board[0][6].getPiece());

		board[0][2] = new Space(new Bishop(0,2,1));
		board[0][5] = new Space(new Bishop(0,5,1));
		AI.addPiece(board[0][2].getPiece());
		AI.addPiece(board[0][5].getPiece());

		board[0][3] = new Space(new Queen(0,3,1));
		board[0][4] = new Space(new King(0,4,1));
		AI.addPiece(board[0][3].getPiece());
		AI.addPiece(board[0][4].getPiece());
	}

	private void buildMiddle(){
		for(int i = 2; i < 6; i ++){
			for(int j = 0; j < 8; j++){
				board[i][j] = new Space();
			}
		}
	}

	private void buildWhite(){
		for(int i = 0; i < 8; i++){
			board[6][i] = new Space(new Pawn(6,i,0));
			j0.addPiece(board[6][i].getPiece());
		}
		board[7][0] = new Space(new Rook(7,0,0));
		board[7][7] = new Space(new Rook(7,7,0));
		j0.addPiece(board[7][0].getPiece());
		j0.addPiece(board[7][7].getPiece());

		board[7][1] = new Space(new Knight(7,1,0));
		board[7][6] = new Space(new Knight(7,6,0));
		j0.addPiece(board[7][1].getPiece());
		j0.addPiece(board[7][6].getPiece());

		board[7][2] = new Space(new Bishop(7,2,0));
		board[7][5] = new Space(new Bishop(7,5,0));
		j0.addPiece(board[7][2].getPiece());
		j0.addPiece(board[7][5].getPiece());

		board[7][3] = new Space(new Queen(7,3,0));
		board[7][4] = new Space(new King(7,4,0));
		j0.addPiece(board[7][3].getPiece());
		j0.addPiece(board[7][4].getPiece());
	}

	private void buildBlack(){
		for(int i = 0; i < 8; i++){
			board[1][i] = new Space(new Pawn(1,i,1));
			j1.addPiece(board[1][i].getPiece());
		}

		board[0][0] = new Space(new Rook(0,0,1));
		board[0][7] = new Space(new Rook(0,7,1));
		j1.addPiece(board[0][0].getPiece());
		j1.addPiece(board[0][7].getPiece());

		board[0][1] = new Space(new Knight(0,1,1));
		board[0][6] = new Space(new Knight(0,6,1));
		j1.addPiece(board[0][1].getPiece());
		j1.addPiece(board[0][6].getPiece());

		board[0][2] = new Space(new Bishop(0,2,1));
		board[0][5] = new Space(new Bishop(0,5,1));
		j1.addPiece(board[0][2].getPiece());
		j1.addPiece(board[0][5].getPiece());

		board[0][3] = new Space(new Queen(0,3,1));
		board[0][4] = new Space(new King(0,4,1));
		j1.addPiece(board[0][3].getPiece());
		j1.addPiece(board[0][4].getPiece());
	}

	public void changePosition(int x, int y, Piece p){
		
		lastPoint = null;
		lastPieceTaken = null;
		lastPieceMoved = p;
		int x1 = p.getLocX();
		int y1 = p.getLocY();
		lastPoint = new Point(x1, y1);
		if(board[x][y].getPiece()!=null){
			lastPieceTaken = board[x][y].getPiece();
		}
		m = new Memento(lastPieceMoved, lastPieceTaken, lastPoint);
		removePiece(x,y);
		board[x][y].setPiece(p);
		board[x1][y1].setPiece(null);
		p.setLocation(x,y);
		if(mode == 1){
			AIupdateValidMove();
		}
		else{
			updateValidMove();
		}
	}

	private void undoMove(int index){
		lastPieceMoved = m.getPieceMovedSaved();
		lastPieceTaken = m.getPieceTakenSaved();
		lastPoint = m.getPointSaved();
		removePiece((int)lastPieceMoved.getLocation().getX(), (int)lastPieceMoved.getLocation().getY());
		if(lastPieceTaken!=null){//se movimento comeu alguma peca
			addPiece(lastPieceTaken, (int)lastPieceMoved.getLocation().getX(), (int)lastPieceMoved.getLocation().getY());
		}
		addPiece(lastPieceMoved, (int)lastPoint.getX(), (int)lastPoint.getY(), index);

		if(mode == 1 && Configuration.AI_PLAYER)
			AIupdateValidMove();
		else{
			updateValidMove();
		}
	}

	private void addPiece(Piece piece, int x, int y, int index)
	{
		board[x][y].setPiece(piece);
		piece.setLocation(x,y);
		if(mode == 1){
			if (piece.getTeam()== 1 && Configuration.AI_PLAYER){
				AI.addPiece(index, piece);
			}
			else if(Configuration.OFFLINE_PLAYER ||Configuration.ONLINE_PLAYER ){
				j0.addPiece(index, piece);
			}
		}
		else{
			if(piece.getTeam()== 1){
				j1.addPiece(index, piece);
			}
			else{
				j0.addPiece(index, piece);
			}
		}
		if(mode == 0){
			updateValidMove();
		}
		else{
			if(Configuration.AI_PLAYER) {
				AIupdateValidMove();
			}
		}
	}

	private void addPiece(Piece piece, int x, int y){
		board[x][y].setPiece(piece);
		piece.setLocation(x,y);
		if(mode == 1 ){
			if (piece.getTeam()== 1 && Configuration.AI_PLAYER){
				AI.addPiece(piece);
			}
			else if(Configuration.OFFLINE_PLAYER ||Configuration.ONLINE_PLAYER ){
				j0.addPiece(piece);
			}
		}
		else{
			if(piece.getTeam()== 1){
				j1.addPiece(piece);
			}
			else{
				j0.addPiece(piece);
			}
		}
		if(mode == 0){
			updateValidMove();
		}
		else{
			if(Configuration.AI_PLAYER) {
				AIupdateValidMove();
			}
		}
	}

	private void AIupdateValidMove(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				Piece p = board[i][j].getPiece();
				if(p != null){
					if(p.getTeam() == 0 && (Configuration.OFFLINE_PLAYER ||Configuration.ONLINE_PLAYER) ){
						p.updatePosition(j0.getPlayerPieces(), AI.getPlayerPieces());
					}
					else if(Configuration.AI_PLAYER)
						p.updatePosition(AI.getPlayerPieces(), j0.getPlayerPieces());
				}
			}
		}
	}

	private void updateValidMove(){
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				Piece p = board[i][j].getPiece();
				if(p != null){
					if(p.getTeam() == 0 && (Configuration.OFFLINE_PLAYER ||Configuration.ONLINE_PLAYER) ){
						p.updatePosition(j0.getPlayerPieces(), j1.getPlayerPieces());
					}
					else if(Configuration.AI_PLAYER )
						p.updatePosition(j1.getPlayerPieces(), j0.getPlayerPieces());
				}
			}
		}
	}


	public void removePiece(int x, int y)
	{
		Piece piece = board[x][y].getPiece();
		if (piece == null)
			return;
		if (piece.getTeam()== 0 && (Configuration.OFFLINE_PLAYER ||Configuration.ONLINE_PLAYER) )
			j0.removePiece(piece);
		else if(mode == 1 && Configuration.AI_PLAYER){
			AI.removePiece(piece);
		}
		else if(Configuration.OFFLINE_PLAYER ||Configuration.ONLINE_PLAYER){
			j1.removePiece(piece);
		}
		board[x][y].setPiece(null);
		if(mode == 1 && Configuration.AI_PLAYER){
			AIupdateValidMove();
		}
		else{
			updateValidMove();
		}
	}


	public boolean isValid(int newX, int newY, Piece p){
		ArrayList<Point> validMoves = p.validMoves;
		if(validMoves.contains(new Point(newX,newY))){
			if(p.getType() == PieceType.PAWN)
				p.setFirstMove(false);
			return true;
		}
		else return false;
	}
	public boolean pieceExists(int x, int y){
		if (board[x][y] == null)
			return false;
		else
			return true;
	}
	public boolean isPlayerPiece(int x, int y,int p){
		if(board[x][y].getPiece() != null){
			if(board[x][y].getPiece().getTeam() == p){
				return true;
			}
			return false;
		}
		else{
			return false;
		}
	}
	public PieceType getType(int x, int y){
		return board[x][y].getPiece().getType();
	}
	public int getTeam(int x, int y){
		return board[x][y].getPiece().getTeam();
	}
	public Piece getPiece(int x, int y) {
		return board[x][y].getPiece();
	}

	public boolean white_check_mate(boolean isAI){
		ArrayList<Piece> friend = null;
		ArrayList<Piece> enemy = null;
		int check_cont = 0;
		int flag_move_check = 0;
		int indice_king = 0;
		friend = j0.getPlayerPieces();
		if(isAI && Configuration.AI_PLAYER){
			enemy = AI.getPlayerPieces();
		}
		else{
			enemy = j1.getPlayerPieces();
			
		}
		for(int i = 0; i < friend.size(); i++){
			for(int j = 0; j < friend.get(i).validMoves.size(); j++){
				if( friend.get(i).getType() == PieceType.KING ){
					indice_king = i;
					break;
				}
			}
		}

		for(int j = 0; j < friend.get(indice_king).validMoves.size(); j++){
			int newX = (int)friend.get(indice_king).validMoves.get(j).getX();
			int newY = (int)friend.get(indice_king).validMoves.get(j).getY();
			changePosition(newX, newY, friend.get(indice_king));
			for(int m = 0; m < enemy.size(); m++){
				for(int n = 0; n < enemy.get(m).validMoves.size(); n++){
					int newXp = (int)enemy.get(m).validMoves.get(n).getX();
					int newYp = (int)enemy.get(m).validMoves.get(n).getY();
					if(newX == newXp && newY == newYp){
						check_cont++;
						flag_move_check = 1;
						break;
					}
				}
				if(flag_move_check == 1){
					flag_move_check = 0;
					break;
				}
			}
			undoMove(indice_king);
		}
		if(check_cont >= (friend.get(indice_king).validMoves.size()-1)){
			return true;	
		}
		else{
			return false;
		}
	}

	public boolean black_check_mate(){
		ArrayList<Piece> friend = null;
		ArrayList<Piece> enemy = null;
		int check_cont = 0;
		int flag_move_check = 0;
		int indice_king = 0;
		enemy = j0.getPlayerPieces();
		friend = j1.getPlayerPieces();
		for(int i = 0; i < friend.size(); i++){
			for(int j = 0; j < friend.get(i).validMoves.size(); j++){
				if( friend.get(i).getType() == PieceType.KING ){
					indice_king = i;
					break;
				}
			}
		}

		for(int j = 0; j < friend.get(indice_king).validMoves.size(); j++){
			int newX = (int)friend.get(indice_king).validMoves.get(j).getX();
			int newY = (int)friend.get(indice_king).validMoves.get(j).getY();
			changePosition(newX, newY, friend.get(indice_king));
			for(int m = 0; m < enemy.size(); m++){
				for(int n = 0; n < enemy.get(m).validMoves.size(); n++){
					int newXp = (int)enemy.get(m).validMoves.get(n).getX();
					int newYp = (int)enemy.get(m).validMoves.get(n).getY();
					if(newX == newXp && newY == newYp){
						check_cont++;
						flag_move_check = 1;
						break;
					}
				}
				if(flag_move_check == 1){
					flag_move_check = 0;
					break;
				}
			}
			undoMove(indice_king);
		}
		if(check_cont >= (friend.get(indice_king).validMoves.size()-1)){
			return true;	
		}
		else{
			return false;
		}
	}

	public void bestMove(int x, int y){
		int[][] positionWeight = AI.getPositionWeight();
		ArrayList<Piece> AI_pieces = AI.getPlayerPieces();
		ArrayList<Piece> j0_pieces = j0.getPlayerPieces();
		int newWhiteScore = -90;//Jogador
		int flag_piece = 0;
		int maxWhiteScore = -9999;

		int newBlackScore = -90;//AI
		int maxBlackScore = -9999;

		int blackX = 0, blackY = 0;
		Piece blackPiece = null;

		int whiteX = 0, whiteY = 0;

		int totalScore = 0;
		int bestMoveX = 0;
		int bestMoveY = 0;
		Piece bestPiece = null;

		for(int i = 0; i < AI_pieces.size(); i++){
				for(int j = 0; j < AI_pieces.get(i).validMoves.size(); j++){
					int newX = (int)AI_pieces.get(i).validMoves.get(j).getX();
					int newY = (int)AI_pieces.get(i).validMoves.get(j).getY();
					if(board[newX][newY].getPiece() != null){
						flag_piece = 1;
						newBlackScore += AI.getPieceScore(board[newX][newY].getPiece().getType());
					}
					newBlackScore += positionWeight[newX][newY];
					if(newBlackScore > maxBlackScore){
						maxBlackScore = newBlackScore;
						blackX = newX;
						blackY = newY;
						blackPiece = AI_pieces.get(i);
					}
					else if( newBlackScore == maxBlackScore && flag_piece == 1){
						maxBlackScore = newBlackScore;
						blackX = newX;
						blackY = newY;
						blackPiece = AI_pieces.get(i);
					}
					changePosition(newX, newY, AI_pieces.get(i));
					for(int m = 0; m < j0_pieces.size(); m++){
						for(int n = 0; n < j0_pieces.get(m).validMoves.size(); n++){
							int newXp = (int)j0_pieces.get(m).validMoves.get(n).getX();
							int newYp = (int)j0_pieces.get(m).validMoves.get(n).getY();
							if(board[newXp][newYp].getPiece() != null && board[newXp][newYp].getPiece().getTeam() == 1){
								newWhiteScore += AI.getPieceScore(board[newXp][newYp].getPiece().getType());
							}
							newWhiteScore += positionWeight[newXp][newYp];
							if(newWhiteScore > maxWhiteScore){
								maxWhiteScore = newWhiteScore;
								whiteX = newXp;
								whiteY = newYp;
							}
							newWhiteScore = -90;
						}
					}
					if(totalScore <= (maxBlackScore - maxWhiteScore)){
						totalScore = maxBlackScore - maxWhiteScore;
						bestMoveX = blackX;
						bestMoveY = blackY;
						bestPiece = blackPiece;
					}
					undoMove(i);
					//newWhiteScore = 0;
					newBlackScore = -90;
				}
				flag_piece = 0;
				maxWhiteScore = -9999;
				maxBlackScore = -9999;
		}
		if(bestPiece == null){
			Random rand = new Random();
			int n = rand.nextInt((AI_pieces.size()-1) + 0);
			while(AI_pieces.get(n).validMoves.size() == 0){
				n = rand.nextInt(AI_pieces.size());
			}
			bestPiece = AI_pieces.get(n);
			bestMoveX = (int)AI_pieces.get(n).validMoves.get(0).getX();
			bestMoveY = (int)AI_pieces.get(n).validMoves.get(0).getY();
		}
		if(bestPiece.getType() == PieceType.PAWN)
				bestPiece.setFirstMove(false);
		this.bestMoveX = bestMoveX;
		this.bestMoveY = bestMoveY;
		this.bestPiece = bestPiece;
	}

	public Piece getBestPiece(){
		return this.bestPiece;
	}

	public int getBestX(){
		return this.bestMoveX;
	}

	public int getBestY(){
		return this.bestMoveY;
	}

	public static class Memento{
		private Piece lastPieceMoved2;
		private Piece lastPieceTaken2;
		private Point lastPoint2;
		public Memento(Piece lastPieceMoved, Piece lastPieceTaken, Point lastPoint){
			lastPieceMoved2 = lastPieceMoved;
			lastPieceTaken2 = lastPieceTaken;
			lastPoint2 = lastPoint;
		}

		protected Point getPointSaved(){
			return this.lastPoint2;
		}  
		protected Piece getPieceTakenSaved(){
			return this.lastPieceTaken2;
		}
		protected Piece getPieceMovedSaved(){
			return this.lastPieceMoved2;
		}
	}
	public boolean whiteKingCheck(boolean isAI){
		ArrayList<Piece> pieces;
		if(isAI){
			pieces = AI.getPlayerPieces();
		}
		else{
		 	pieces = j1.getPlayerPieces();
		}
		for(Piece pEval : pieces){
			ArrayList<Point> moves = pEval.validMoves;
			for(Point p : moves){
				Piece kingAux = board[(int)p.getX()][(int)p.getY()].getPiece();
				if(kingAux != null){
					if(kingAux.getType() == PieceType.KING && kingAux.getTeam() == 0){
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean blackKingCheck(){
		ArrayList<Piece> pieces = j0.getPlayerPieces();
		for(Piece pEval : pieces){
			ArrayList<Point> moves = pEval.validMoves;
			for(Point p : moves){
				Piece kingAux = board[(int)p.getX()][(int)p.getY()].getPiece();
				if(kingAux != null){
					if(kingAux.getType() == PieceType.KING && kingAux.getTeam() == 1){
						return true;
					}
				}
			}
		}
		return false;
	}
	public Player getJ0() {
		return j0;
	}
	public Player getJ1() {
		return j1;
	}
	public AI_Player getAI() {
		return AI;
	}
}




