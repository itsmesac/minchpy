package minchpy.impl;

import java.util.List;

import minchpy.api.GenericCBS;
import minchpy.entity.Board;
import minchpy.entity.Evaluation;
import minchpy.entity.GameCBS;
import minchpy.entity.Move;
import minchpy.entity.Player;
import minchpy.entity.State;

public class ChessCBS extends GameCBS {

	@Override
	public Evaluation positionEvaluationCB(Board currentPosition, Player currentPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Move> getMovesCB(Board currentPosition, Player currentPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board makeMoveCB(Board currentPosition, Player currentPlayer, Move move) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean terminalTestCB(State state) {
		// TODO Auto-generated method stub
		return false;
	}

}
