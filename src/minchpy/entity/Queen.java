package minchpy.entity;

import java.util.List;
import minchpy.api.PieceMoves;

public class Queen extends Piece implements PieceMoves{
	
	Queen(int side) {
		super(side);
	}
	
	public List<Move> getAllMoves() {
		return null;
	}
}
