package minchpy.api;

import java.util.List;

import minchpy.entity.Board;
import minchpy.entity.Evaluation;
import minchpy.entity.Move;
import minchpy.entity.Player;
import minchpy.entity.State;

public interface GenericCBS {
	Evaluation positionEvaluationCB (Board currentPosition, Player currentPlayer);
	List<Move> getMovesCB (Board currentPosition, Player currentPlayer);
	Board makeMoveCB (Board currentPosition, Player currentPlayer, Move move);
	boolean terminalTestCB(State state);
}
