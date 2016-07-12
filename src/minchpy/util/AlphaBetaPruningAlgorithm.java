package minchpy.util;

import java.util.List;

import minchpy.entity.ABState;
import minchpy.entity.Evaluation;
import minchpy.entity.GameCBS;
import minchpy.entity.Move;
import minchpy.entity.MoveEval;
import minchpy.entity.State;

public class AlphaBetaPruningAlgorithm {
    
    //TODO check this value
    public static int INFINITY = 1000; 
    
    MoveEval minValue(GameCBS g, ABState abState, double alpha, double beta) throws CloneNotSupportedException {
        if(g.terminalTestCB(abState)) {
            MoveEval moveEval = new MoveEval(null, g.positionEvaluationCB(abState.getState().clone()));
            return moveEval;
        }
        MoveEval moveEval = new MoveEval();
        moveEval.setMove(null);
        moveEval.setValue(new Evaluation(INFINITY));
        List<Move> moves = g.getMovesCB(abState.getState());
        for (Move move : moves) {
            ABState updatedABState = abState.clone();
            State stateAfterMove = g.makeMoveCB(updatedABState.getState(), move);
            updatedABState.setState(stateAfterMove);
            MoveEval nextMoveAndEval = maxValue(g, updatedABState, alpha, beta);
            if(nextMoveAndEval.getValue().getEvalValue() < moveEval.getValue().getEvalValue()) {
                moveEval.setMove(move);
                moveEval.getValue().setEvalValue(nextMoveAndEval.getValue().getEvalValue());
            }
            if(moveEval.getValue().getEvalValue() <= alpha) {
                return moveEval;
            }
            beta = Math.min(beta, moveEval.getValue().getEvalValue());
        }
        return moveEval;
    }
    
    MoveEval maxValue(GameCBS g, ABState abState, double alpha, double beta) throws CloneNotSupportedException {
        if(g.terminalTestCB(abState)) {
            MoveEval moveEval = new MoveEval(null, g.positionEvaluationCB(abState.getState().clone()));
            return moveEval;
        }
        MoveEval moveEval = new MoveEval();
        moveEval.setMove(null);
        moveEval.setValue(new Evaluation(-INFINITY));
        List<Move> moves = g.getMovesCB(abState.getState());
        for (Move move : moves) {
            ABState updatedABState = abState.clone();
            State stateAfterMove = g.makeMoveCB(updatedABState.getState(), move);
            updatedABState.setState(stateAfterMove);
            MoveEval nextMoveAndEval = minValue(g, updatedABState, alpha, beta);
            if(nextMoveAndEval.getValue().getEvalValue() > moveEval.getValue().getEvalValue()) {
                moveEval.setMove(move);
                moveEval.getValue().setEvalValue(nextMoveAndEval.getValue().getEvalValue());
            }
            if(moveEval.getValue().getEvalValue() >= beta) {
                return moveEval;
            }
            alpha = Math.min(alpha, moveEval.getValue().getEvalValue());
        }
        return moveEval;
    }
    
    MoveEval alphaBetaSearch(GameCBS g, ABState abState) {
        MoveEval nextMove = null;
        try {
            nextMove = maxValue(g, abState, INFINITY, -INFINITY);
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        return nextMove;
    }
}
