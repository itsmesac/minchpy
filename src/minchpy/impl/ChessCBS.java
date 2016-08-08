package minchpy.impl;

import java.util.List;

import minchpy.entity.ABState;
import minchpy.entity.Bishop;
import minchpy.entity.ChessBoard;
import minchpy.entity.ChessMove;
import minchpy.entity.ChessState;
import minchpy.entity.Evaluation;
import minchpy.entity.GameCBS;
import minchpy.entity.King;
import minchpy.entity.Knight;
import minchpy.entity.Move;
import minchpy.entity.Pawn;
import minchpy.entity.Piece;
import minchpy.entity.Queen;
import minchpy.entity.Square;
import minchpy.entity.State;
import minchpy.util.Constants;
import minchpy.util.EvaluationConstants;

public class ChessCBS extends GameCBS {

    public int[][] getPieceSquareTable(Piece piece) {
        if (piece instanceof King) {
            return EvaluationConstants.KING_PIECE_SQUARE_TABLE_MIDDLE_GAME;
        } else if (piece instanceof Queen) {
            return EvaluationConstants.QUEEN_PIECE_SQUARE_TABLE;
        } else if (piece instanceof Bishop) {
            return EvaluationConstants.BISHOP_PIECE_SQUARE_TABLE;
        } else if (piece instanceof Knight) {
            return EvaluationConstants.KNIGHT_PIECE_SQUARE_TABLE;
        } else if (piece instanceof Pawn) {
            return EvaluationConstants.PAWN_PIECE_SQUARE_TABLE;
        }
        return null;
    }
    
    public int getPieceMaterialValue(Piece piece) {
        if (piece instanceof King) {
            return EvaluationConstants.EVAL_KING;
        } else if (piece instanceof Queen) {
            return EvaluationConstants.EVAL_QUEEN;
        } else if (piece instanceof Bishop) {
            return EvaluationConstants.EVAL_BISHOP;
        } else if (piece instanceof Knight) {
            return EvaluationConstants.EVAL_KNIGHT;
        } else if (piece instanceof Pawn) {
            return EvaluationConstants.EVAL_PAWN;
        }
        return 0;
    }

    @Override
    public Evaluation positionEvaluationCB(State state) {
        ChessBoard chessBoard = ((ChessState) state).getCurrentBoard();
        double boardEvaluationValue = 0;
        for(int i = 0; i < Constants.MAX_RANKS; i++) {
            for(int j = 0; j < Constants.MAX_FILES; j++) {
                Piece pieceAtSquareIJ = chessBoard.getSquareOfBoard(i, j).getPiece();
                int[][] pieceSquareTable = getPieceSquareTable(pieceAtSquareIJ);
                int pieceMaterialValue = getPieceMaterialValue(pieceAtSquareIJ);
                boardEvaluationValue += pieceSquareTable[i][j] * pieceMaterialValue;
            }
        }
        return (new Evaluation(boardEvaluationValue));
    }

    @Override
    public List<Move> getMovesCB(State state) {
        // TODO Auto-generated method stub
        return null;
    }

    // Include condition for firstMove entry for pawn and king
    @Override
    public State makeMoveCB(State state, Move move) {
        Square src = ((ChessMove) move).getSrc();
        Square dest = ((ChessMove) move).getDst();
        if (!src.isEmpty()) {
            Piece piece = src.getPiece();
            src.clear();
            dest.setPiece(piece);
            piece.updateAfterMove();
        }
        return null;
    }

    @Override
    public boolean terminalTestCB(ABState abState) {
        if(abState.getDepth().equals(EvaluationConstants.TERMINATION_DEPTH))
            return true;
        else
            return false;
    }

}
