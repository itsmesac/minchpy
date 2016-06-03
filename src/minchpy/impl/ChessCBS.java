package minchpy.impl;

import java.util.List;

import minchpy.api.GenericCBS;
import minchpy.entity.Board;
import minchpy.entity.Evaluation;
import minchpy.entity.GameCBS;
import minchpy.entity.Move;
import minchpy.entity.Player;

public class ChessCBS extends GameCBS implements GenericCBS {

	@Override
	public Evaluation positionEvaluationCB(Board currentPosition, Player currentPlayer) {
		// TODO implement the function
		return null;
	}

	@Override
	public List<Move> getMovesCB(Board currentPosition, Player currentPlayer) {
		// TODO implement the function
		return null;
	}

	@Override
	public Board makeMoveCB(Board currentPosition, Player currentPlayer, Move move) {
		// TODO implement the function
		return null;
	}

}
