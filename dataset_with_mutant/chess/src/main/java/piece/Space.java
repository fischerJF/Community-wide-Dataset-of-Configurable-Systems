package piece;

public class Space{

	private Piece piece;

	public boolean isPieceNull() {
		if(piece == null)
			return true;
		else return false;
	}

	public Space(Piece p) {
		this.piece = p;
	}

	public Space() {
		this.piece = null;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece p) {
		piece = p;
	}
  
}
