package piece;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class Rook extends Piece {

	public enum Direction {
		Norte, Sul, Esquerda, Direita
	}

	public Rook(int x, int y, int time) {
		super(x, y, time);
		this.pt = PieceType.ROOK;
		this.setTeam(time);
		if(time == 0){}//Time debaixo
		else{} //Time de cima
	}

	public void updatePosition(ArrayList<Piece> friend, ArrayList<Piece> enemy) {
    validMoves.clear();
    Point start = getLocation();
    Point aux;
    //Sul
    for (int x = (int)start.getX() + 1; x < 8; x++) {
      aux = new Point( x, (int)start.getY() );
      if( contains(friend, aux) ) {
        break;
      }
      else if( contains(enemy, aux) ) {
        validMoves.add(aux);
        break;
      }
      else {
        validMoves.add(aux);
      }
    }
    //Norte
    for (int x = (int)start.getX() - 1; x >= 0; x--) {
      aux = new Point( x, (int)start.getY() );
      if( contains(friend, aux) ) {
        break;
      }
      else if( contains(enemy, aux) ) {
        validMoves.add(aux);
        break;
      }
      else {
        validMoves.add(aux);
      }
    }
    //Leste
    for (int y = (int)start.getY() + 1; y < 8; y++) {
      aux = new Point( (int)start.getX(), y );
      if( contains(friend, aux) ) {
        break;
      }
      else if( contains(enemy, aux) ) {
        validMoves.add(aux);
        break;
      }
      else {
        validMoves.add(aux);
      }
    }
    //Oeste
    for (int y = (int)start.getY() - 1; y >= 0; y--) {
      aux = new Point( (int)start.getX(), y );
      if( contains(friend, aux) ) {
        break;
      }
      else if( contains(enemy, aux) ) {
        validMoves.add(aux);
        break;
      }
      else {
        validMoves.add(aux);
      }
    }
	}

}
