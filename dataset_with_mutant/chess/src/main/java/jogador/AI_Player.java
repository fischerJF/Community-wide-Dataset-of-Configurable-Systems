package jogador;
import gui.*;
import piece.*;
import specifications.Configuration;

import java.awt.Point;
import java.util.ArrayList;

public class AI_Player {
	private ArrayList<Piece> playerPieces;
	private int team;
	private int pieces_killed;
	private int score;
	private int[][] positionWeight;
	private int[] pieceScore;

	public AI_Player(int team) {
		if(Configuration.AI_PLAYER) {
			this.team = team;
			score = 0;
			pieces_killed = 0;
			playerPieces = new ArrayList<Piece>();
			setPositionWeight();
		}

	}

	public void addPiece(int index, Piece p){
		playerPieces.add(index, p);
	}

	public void addPiece(Piece p){
		playerPieces.add(p);
	}

	public void removePiece(Piece p){
		for(int i = 0; i < playerPieces.size(); i++){
			Piece player_pieces = playerPieces.get(i);
			if(player_pieces.getLocX() == p.getLocX() && player_pieces.getLocY() == p.getLocY()){
				playerPieces.remove(i);
				return;
			}
		}
	}

	public void setTeam(int team){
		this.team = team;
	}

	public int getTeam(){
		return this.team;
	}

	public ArrayList<Piece> getPlayerPieces(){
		return playerPieces;
	}

	public void setPiecesKilled(){
		pieces_killed++;
	}

	public void setScore(){
		score++;
	}

	public int getScore(){
		return score;
	}

	private void setPositionWeight(){
		positionWeight = new int[8][8];
		int [][]positionWeightAux =
		{	{1,1,1,1,1,1,1,1}
		,	{2,2,2,2,2,2,2,2}
		,	{2,3,3,3,3,3,3,2}
		,	{2,3,4,5,5,4,3,2}
		,	{2,3,3,5,5,4,3,2}
		,	{2,2,3,3,3,3,2,2}
		,	{2,2,2,2,2,2,2,2}
		,	{1,1,1,1,1,1,1,1}
		};
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				positionWeight[i][j] = positionWeightAux[i][j];
			}
		}
	}

	public int[][] getPositionWeight(){
		return positionWeight;
	}

	public int getPieceScore(PieceType piece_type){
		switch(piece_type){
			case PAWN: return 10;
			case KNIGHT: return 30;
			case BISHOP: return 40;
			case ROOK: return 50;
			case QUEEN: return 90;
			case KING: return 99999;
			default: return 0;
		}
	}
}
