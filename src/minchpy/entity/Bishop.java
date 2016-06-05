package minchpy.entity;

import java.util.List;
import minchpy.api.PieceMoves;

public class Bishop extends Piece implements PieceMoves{
	
	Bishop(int side) {
		super(side);
	}
	
	public List<Move> getAllMoves() {
		return null;
	}
}