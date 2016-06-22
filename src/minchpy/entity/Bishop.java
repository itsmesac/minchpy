package minchpy.entity;

import java.util.ArrayList;
import java.util.List;
import minchpy.api.PieceMoves;

public class Bishop extends Piece implements PieceMoves{
	
	public Bishop(int side) {
		super(side);
	}

	@Override
	public List<Move> getAllMoves(State state, int rank, int file) {
		List<Move> moves = new ArrayList<Move>();
		return moves;
	}
	
}