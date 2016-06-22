package minchpy.entity;

public class Square {
	Piece piece;
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public Square() {
		piece = null;
	}
	
	public boolean isEmpty() {
		if(this.piece == null)
			return true;
		else
			return false;
	}
}
