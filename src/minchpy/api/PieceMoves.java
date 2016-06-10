package minchpy.api;

import java.util.List;
import minchpy.entity.Move;

public interface PieceMoves {
	
	/* Method to generate all possible legal moves of a piece */
	List<Move> getAllMoves();
}
