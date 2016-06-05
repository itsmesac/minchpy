package minchpy.entity;

import java.util.List;
import minchpy.api.PieceMoves;

public class Pawn extends Piece implements PieceMoves{
	
	Pawn(int side) {
		super(side);
	}
	
	public List<Move> getAllMoves() {
		return null;
	}
}