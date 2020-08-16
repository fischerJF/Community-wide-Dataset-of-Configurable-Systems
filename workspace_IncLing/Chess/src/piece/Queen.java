package piece;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class Queen extends Piece{


	public Queen(int x, int y, int time){
		super(x, y, time);
		this.setTeam(time);
		this.pt = PieceType.QUEEN;
	}

  public void updatePosition(ArrayList<Piece> friend, ArrayList<Piece> enemy){
    validMoves.clear();
    Point p = this.getLocation();
    Point aux = new Point((int)p.getX(), (int)p.getY());
    int auxX = (int)p.getX();
    int auxY = (int)p.getY();
    //Oeste
    for(int i = auxY-1; i >= 0; i--){
      aux.setLocation(auxX,i);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(auxX,i));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(auxX,i));
    }

    //Leste
    for(int i = auxY+1; i < 8; i++){
      aux.setLocation(auxX,i);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(auxX,i));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(auxX,i));
    }

    //Norte
    for(int i = auxX+1; i < 8; i++){
      aux.setLocation(i,auxY);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(i,auxY));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(i,auxY));
    }

    //Sul
    for(int i = auxX-1; i >= 0; i--){
      aux.setLocation(i,auxY);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(i,auxY));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(i,auxY));
    }

    //Sudoeste
    int i = auxX + 1; // linha
    int j = auxY - 1; // coluna
    for(; i < 8 && j >= 0; i++, j--){
      aux.setLocation(i,j);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(i,j));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(i,j));
    }

    //Noroeste
    i = auxX - 1; // linha
    j = auxY - 1; // coluna
    for(; i >= 0 && j >= 0; i--, j--){
      aux.setLocation(i,j);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(i,j));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(i,j));
    }

    //Sudeste
    i = auxX + 1; // linha
    j = auxY + 1; // coluna
    for(; i < 8 && j < 8; i++, j++){
      aux.setLocation(i,j);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(i,j));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(i,j));
    }

    //Nordeste
    i = auxX - 1; // linha
    j = auxY + 1; // coluna
    for(; i >= 0 && j < 8; i--, j++){
      aux.setLocation(i,j);
      if(this.contains(enemy,aux)){
        validMoves.add(new Point(i,j));
        break;
      }
      else if(this.contains(friend,aux)){
        break;
      }
      else
        validMoves.add(new Point(i,j));
    }
  }

}
