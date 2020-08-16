package piece;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class King extends Piece{

	public King(int x, int y, int time){
		super(x, y, time);
		this.setTeam(time);
		this.pt = PieceType.KING;
	}

  public void updatePosition(ArrayList<Piece> friends, ArrayList<Piece> enemy){
    validMoves.clear();
    Point start = this.getLocation();
    Point aux;
    int newX;
    int newY;

    // Norte
    newX = (int)start.getX() - 1;
    newY = (int)start.getY();
    aux  = new Point(newX, newY);
    if( newX >= 0 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }

    // Sul
    newX = (int)start.getX() + 1;
    newY = (int)start.getY();
    aux  = new Point(newX, newY);
    if( newX < 8 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }

    // Leste
    newX = (int)start.getX();
    newY = (int)start.getY() + 1;
    aux  = new Point(newX, newY);
    if( newY < 8 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }

    // Oeste
    newX = (int)start.getX();
    newY = (int)start.getY() - 1;
    aux  = new Point(newX, newY);
    if( newY >= 0 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }

    // Nordeste
    newX = (int)start.getX() - 1;
    newY = (int)start.getY() + 1;
    aux  = new Point(newX, newY);
    if( newX >= 0 && newY < 8 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }

    // Noroeste
    newX = (int)start.getX() - 1;
    newY = (int)start.getY() - 1;
    aux  = new Point(newX, newY);
    if( newX >= 0 && newY >= 0 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }

    // Sudeste
    newX = (int)start.getX() + 1;
    newY = (int)start.getY() + 1;
    aux  = new Point(newX, newY);
    if( newX < 8 && newY < 8 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }

    // Sudoeste
    newX = (int)start.getX() + 1;
    newY = (int)start.getY() - 1;
    aux  = new Point(newX, newY);
    if( newX < 8 && newY >= 0 ) {
      if( contains(friends, aux) ) {
      }
      else if ( contains(enemy, aux) ) {
        validMoves.add(aux);
      }
      else {
        validMoves.add(aux);
      }
    }
    return;

  }
}
