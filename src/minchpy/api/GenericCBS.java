package minchpy.api;

import java.util.List;

import minchpy.entity.Board;
import minchpy.entity.Evaluation;
import minchpy.entity.Move;
import minchpy.entity.Player;
import minchpy.entity.State;

public interface GenericCBS {
	Evaluation positionEvaluationCB (State state);
	List<Move> getMovesCB (State state);
	Board makeMoveCB (State state, Move move);
	boolean terminalTestCB(State state);
}
