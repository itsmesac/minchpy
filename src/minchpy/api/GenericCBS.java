package minchpy.api;

import java.util.List;

import minchpy.entity.ABState;
import minchpy.entity.Board;
import minchpy.entity.Evaluation;
import minchpy.entity.Move;
import minchpy.entity.State;

public interface GenericCBS {
	Evaluation positionEvaluationCB (State state);
	List<Move> getMovesCB (State state);
	//Make move function should update board and player
	State makeMoveCB (State state, Move move);
	boolean terminalTestCB(ABState abState);
}
