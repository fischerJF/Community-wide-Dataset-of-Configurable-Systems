package piece;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class Pawn extends Piece{

	public Pawn(int x, int y, int time){
		super(x, y, time);
		this.pt = PieceType.PAWN;
		this.setTeam(time);
		firstMove = true;
	}

	public void updatePosition(ArrayList<Piece> friend, ArrayList<Piece> enemy){
		validMoves.clear();
		if(this.getTeam() == 1){
			//black pieces
			Point pt = this.getLocation();
			if(firstMove){
				Point aux = new Point((int)pt.getX()+2, (int)pt.getY());
				if(!this.contains(enemy, aux) && !this.contains(friend,aux)){
					validMoves.add(aux);
				}
			}
			int auxX = (int)pt.getX()+1;
			int auxY = (int)pt.getY();
			Point aux = new Point(auxX, auxY);
			if(auxX < 8 && !this.contains(enemy, aux) && !this.contains(friend,aux)){
				//square directly downward
				validMoves.add(new Point(auxX, auxY));
			}
			auxY -= 1; //left square downward
			aux.setLocation(auxX,auxY);
			if(auxY >= 0 && auxX < 8 && this.contains(enemy, aux)){
				validMoves.add(new Point(auxX, auxY));
			}
			auxY += 2; //right square downward
			aux.setLocation(auxX, auxY);
			if(auxY < 8 && auxX < 8 && this.contains(enemy, aux)){
				validMoves.add(new Point(auxX, auxY));
			}

		}
		else{
			//white pieces
			Point pt = this.getLocation();
			if(firstMove){
				Point aux = new Point((int)pt.getX()-2, (int)pt.getY());
				if(!this.contains(enemy, aux) && !this.contains(friend,aux)){
					validMoves.add(aux);
				}
			}
			int auxX = (int)pt.getX()-1;
			int auxY = (int)pt.getY();
			Point aux = new Point(auxX, auxY);
			if(auxX >= 0 && !this.contains(enemy,aux) && !this.contains(friend,aux)){
				//square directly forward
				validMoves.add(new Point(auxX, auxY));
			}
			auxY -= 1; //left square forward
			aux.setLocation(auxX,auxY);
			if(auxY >= 0 && auxX >= 0 && this.contains(enemy, aux)){
				validMoves.add(new Point(auxX, auxY));
			}
			auxY += 2; //right square forward
			aux.setLocation(auxX, auxY);
			if(auxY < 8 && auxX >= 0 && this.contains(enemy, aux)){
				validMoves.add(new Point(auxX, auxY));
			}
		}
	}
}
