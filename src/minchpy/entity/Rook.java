package minchpy.entity;

import java.util.List;
import minchpy.api.PieceMoves;

public class Rook extends Piece implements PieceMoves{
	
	Rook(int side) {
		super(side);
	}
	
	public List<Move> getAllMoves() {
		return null;
	}
}