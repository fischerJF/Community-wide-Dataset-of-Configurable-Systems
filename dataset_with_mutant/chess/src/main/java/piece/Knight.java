package piece;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class Knight extends Piece{
	
	public Knight(int x, int y, int time){
		super(x, y, time);
		this.setTeam(time);
		this.pt = PieceType.KNIGHT;
		if(time == 0){}//Time debaixo
		else{} //Time de cima
	}

	public void updatePosition(ArrayList<Piece> friend, ArrayList<Piece> enemy){
		validMoves.clear();
		Point p = this.getLocation();
		Point aux = new Point((int)p.getX(), (int)p.getY());
		// oo
		//  o
		//  o
		int auxX = (int)p.getX() + 2;
		int auxY = (int)p.getY() - 1;
		aux.setLocation(auxX,auxY);
		if(auxX < 8 && auxY >= 0 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX,auxY));
		}
		// oo
		// o
		// o
		auxX = (int)p.getX() + 2;
		auxY = (int)p.getY() + 1;
		aux.setLocation(auxX,auxY);
		if(auxX < 8 && auxY < 8 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX,auxY));
		}
		// o
		// o
		// oo
		auxX = (int)p.getX() - 2;
		auxY = (int)p.getY() + 1;
		aux.setLocation(auxX,auxY);
		if(auxX >= 0 && auxY < 8 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX,auxY));
		}
		//  o
		//  o
		// oo
		auxX = (int)p.getX() - 2;
		auxY = (int)p.getY() - 1;
		aux.setLocation(auxX,auxY);
		if(auxX >= 0 && auxY >= 0 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX,auxY));
		}
		// o
		// ooo
		auxX = (int)p.getX() + 1;
		auxY = (int)p.getY() - 2;
		aux.setLocation(auxX,auxY);
		if(auxX < 8 && auxY >= 0 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX,auxY));
		}
		// ooo
		// o
		auxX = (int)p.getX() - 1;
		auxY = (int)p.getY() - 2;
		aux.setLocation(auxX,auxY);
		if(auxX >= 0 && auxY >= 0 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX, auxY));
		}
		//   o
		// ooo
		auxX = (int)p.getX() + 1;
		auxY = (int)p.getY() + 2;
		aux.setLocation(auxX,auxY);
		if(auxX < 8 && auxY < 8 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX,auxY));
		}
		// ooo
		//   o
		auxX= (int)p.getX() - 1;
		auxY= (int)p.getY() + 2;
		aux.setLocation(auxX,auxY);
		if(auxX >= 0 && auxY < 8 && !this.contains(friend,aux)){
			validMoves.add(new Point(auxX,auxY));
		}
	}
}