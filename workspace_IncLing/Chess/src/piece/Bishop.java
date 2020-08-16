package piece;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class Bishop extends Piece{

	public enum Direction{
		Nordeste, Sudeste, Noroeste, Sudoeste
	}

	public Bishop(int x, int y, int time){
		super(x, y, time);
		this.setTeam(time);
		this.pt = PieceType.BISHOP;
	}

  public void updatePosition(ArrayList<Piece> friend, ArrayList<Piece> enemy){
    validMoves.clear();
    Point start = getLocation();
    Point aux;
    int x, y;
    // Nordeste
    x = (int)start.getX() - 1;
    y = (int)start.getY() + 1;
    for (;x >= 0 && y < 8; x--, y++) {
      aux = new Point( x, y );
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
    // Noroeste
    x = (int)start.getX() - 1;
    y = (int)start.getY() - 1;
    for (;x >= 0 && y >= 0; x--, y--) {
      aux = new Point( x, y );
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
    // Sudeste
    x = (int)start.getX() + 1;
    y = (int)start.getY() + 1;
    for (;x < 8 && y < 8; x++, y++) {
      aux = new Point( x, y );
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
    // Sudoeste
    x = (int)start.getX() + 1;
    y = (int)start.getY() - 1;
    for (;x < 8 && y >= 0; x++, y--) {
      aux = new Point( x, y );
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
