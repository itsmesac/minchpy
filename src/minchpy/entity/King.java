package minchpy.entity;

import java.util.List;
import minchpy.api.PieceMoves;

public class King extends Piece implements PieceMoves{
	
	King(int side) {
		super(side);
	}
	
	public List<Move> getAllMoves() {
		return null;
	}
}
