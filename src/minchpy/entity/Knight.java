package minchpy.entity;

import java.util.List;
import minchpy.api.PieceMoves;

public class Knight extends Piece implements PieceMoves{
	
	Knight(int side) {
		super(side);
	}
	
	public List<Move> getAllMoves() {
		return null;
	}
}