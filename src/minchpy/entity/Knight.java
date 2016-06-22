package minchpy.entity;

import java.util.List;
import minchpy.api.PieceMoves;

public class Knight extends Piece implements PieceMoves{
	
	Knight(int side) {
		super(side);
	}

	@Override
	public List<Move> getAllMoves(State state, int rank, int file) {
		// TODO Auto-generated method stub
		return null;
	}
}