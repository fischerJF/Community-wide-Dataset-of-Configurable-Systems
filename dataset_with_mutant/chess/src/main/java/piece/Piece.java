package piece;
import java.util.ArrayList;
import java.awt.Point;
import javax.swing.JLabel;

public class Piece {
    protected Point location;
	protected PieceType pt;
	protected int team;
	public ArrayList<Point> validMoves;
	protected JLabel icon;
	protected boolean firstMove;

	public Piece(int x, int y, int time){
		team = time;
		location  = new Point(x, y);
		validMoves = new ArrayList<Point>();
	}

	public Piece(){
		team = -1;
		icon = null;
		validMoves = null;
		location = null;
	}

	public Piece(Piece p){
		this.location = p.location;
		this.validMoves = p.validMoves;
		this.team = p.team;
	}

	public void updatePosition(ArrayList<Piece> friend, ArrayList<Piece> enemy){
		return;
	}

	public void deletePiece(int x, int y){
		team = -1;
		icon = null;
		location.setLocation(x,y);
	}

	public int getLocX(){
		return (int)location.getX();
	}

	public int getLocY(){
		return (int)location.getY();
	}

	public void setLocation(int x, int y){
		location.setLocation(x,y);
	}

	public int getTeam(){
		return this.team;
	}

	public PieceType getType(){
		return this.pt;
	}

	public void setType(PieceType type){
		this.pt = type;
	}

	public void setTeam(int x){
		this.team = x;
	}

  public Point getLocation(){
		return this.location;
	}

  protected boolean contains(ArrayList<Piece> p, Point pt){
		for(Piece aux : p){
			if (aux.getLocation().equals(pt)){
				return true;
			}
		}
		return false;
	}

	public void setFirstMove(boolean t){
		this.firstMove = t;
	}

}
