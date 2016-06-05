package minchpy.util;

import minchpy.entity.Evaluation;
import minchpy.entity.GameCBS;
import minchpy.entity.MoveEval;
import minchpy.entity.State;

public class AlphaBetaPruningAlgorithm {
	
	//TODO check this value
	public static int INFINITY = 1000; 
	
	MoveEval minValue(GameCBS g, State state, int alpha, int beta) {
		//TODO implement the function
		return null;
	}
	
	MoveEval maxValue(GameCBS g, State state, int alpha, int beta) {
		if(g.terminalTestCB(state)) {
			//TODO decide return value
			return null;
		}
		Evaluation value = new Evaluation();
		value.setEvalValue(-INFINITY);
		return null;
	}
	
	MoveEval alphaBetaSearch(GameCBS g, State state) {
		return maxValue(g, state, INFINITY, -INFINITY);
	}
}
