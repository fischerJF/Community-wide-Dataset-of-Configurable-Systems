package jogador;
import gui.*;
import piece.*;
import java.awt.Point;
import java.util.ArrayList;

public class Player{
	private ArrayList<Piece> playerPieces;
	private int team;
	private int pieces_killed;
	private int score;
	
	public Player(int team){
		this.team = team;
		score = 0;
		pieces_killed = 0;
		playerPieces = new ArrayList<Piece>();
	}

	public void addPiece(Piece p){
		playerPieces.add(p);
	}

	public void addPiece(int index, Piece p){
		playerPieces.add(index, p);
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
  
}
