package minchpy.test;

import java.util.ArrayList;
import java.util.List;

import minchpy.api.GenericCBS;
import minchpy.entity.ABState;
import minchpy.entity.Evaluation;
import minchpy.entity.GameCBS;
import minchpy.entity.Move;
import minchpy.entity.State;
import minchpy.util.EvaluationConstants;

public class TestImpl extends GameCBS implements GenericCBS {
    
    public static final int TERMINATION_DEPTH = 2;
    
    private static int evaluationIndex;
    
    private static int[] evaluationValues = {3, 12, 8, 2, 4, 6, 14, 5, 2};
    
    public TestImpl() {
        evaluationIndex = 0;
    }

    @Override
    public Evaluation positionEvaluationCB(State state) {
        return new Evaluation(evaluationValues[evaluationIndex++]);
    }

    @Override
    public List<Move> getMovesCB(State state) {
        List<Move> moves = new ArrayList<Move>();
        for(int i = 0; i < 3; i++) {
            moves.add(new Move());
        }
        return moves;
    }

    @Override
    public State makeMoveCB(State state, Move move) {
        return state;
    }

    @Override
    public boolean terminalTestCB(ABState abState) {
        if (abState.getDepth().equals(TERMINATION_DEPTH))
            return true;
        else
            return false;
    }

}
