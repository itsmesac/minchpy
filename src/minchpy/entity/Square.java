package minchpy.entity;

import minchpy.api.PieceMoves;

public class Square {
	PieceMoves piece;
	
	public PieceMoves getPiece() {
		return piece;
	}

	public void setPiece(PieceMoves piece) {
		this.piece = piece;
	}

	public Square() {
		piece = null;
	}
	
}
