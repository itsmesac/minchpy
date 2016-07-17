package minchpy.impl;

import java.util.List;

import minchpy.entity.ABState;
import minchpy.entity.ChessMove;
import minchpy.entity.Evaluation;
import minchpy.entity.GameCBS;
import minchpy.entity.Move;
import minchpy.entity.Piece;
import minchpy.entity.Square;
import minchpy.entity.State;

public class ChessCBS extends GameCBS {

    @Override
    public Evaluation positionEvaluationCB(State state) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Move> getMovesCB(State state) {
        // TODO Auto-generated method stub
        return null;
    }

    //Include condition for firstMove entry for pawn and king
    @Override
    public State makeMoveCB(State state, Move move) {
        Square src = ((ChessMove)move).getSrc();
        Square dest = ((ChessMove)move).getDst();
        if(!src.isEmpty()) {
            Piece piece = src.getPiece();
            src.clear();
            dest.setPiece(piece);
            piece.updateAfterMove();
        }
        return null;
    }

    @Override
    public boolean terminalTestCB(ABState abState) {
        // TODO Auto-generated method stub
        return false;
    }

}
