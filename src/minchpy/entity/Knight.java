package minchpy.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import minchpy.api.PieceMoves;
import minchpy.util.Constants;

public class Knight extends Piece {
    
    public Knight(int side) {
        super(side);
        movementDirections = Arrays.asList(Constants.KNIGHT_BOTTOM_LEFT_DIRECTION_1,
                Constants.KNIGHT_BOTTOM_LEFT_DIRECTION_2, Constants.KNIGHT_BOTTOM_RIGHT_DIRECTION_1,
                Constants.KNIGHT_BOTTOM_RIGHT_DIRECTION_2, Constants.KNIGHT_TOP_LEFT_DIRECTION_1,
                Constants.KNIGHT_TOP_LEFT_DIRECTION_2, Constants.KNIGHT_TOP_RIGHT_DIRECTION_1,
                Constants.KNIGHT_TOP_RIGHT_DIRECTION_2);
    }
    

    @Override
    public List<Move> getAllMoves(State state, int rank, int file) {
        List<Move> moves = new ArrayList<Move>();
        if (((ChessState) state).getCurrentPlayer().getPlayer() == side) {
            ChessBoard chessBoard = ((ChessState) state).getCurrentBoard();
            for (int[] direction : movementDirections) {
                int nextMoveRank = rank + direction[Constants.X];
                int nextMoveFile = file + direction[Constants.Y];
                if ((nextMoveRank >= 0) && (nextMoveRank < Constants.MAX_RANKS) && (nextMoveFile >= 0)
                        && (nextMoveFile < Constants.MAX_FILES)) {
                    Square nextPossibleMoveSquare = chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile);
                    if (!nextPossibleMoveSquare.isEmpty()) {
                        int nextMoveSquarePiecePlayer = nextPossibleMoveSquare.getPiece().getSide();
                        if (nextMoveSquarePiecePlayer != this.side) {
                            ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file),
                                    nextPossibleMoveSquare);
                            moves.add(move);
                        }
                    } else {
                        ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), nextPossibleMoveSquare);
                        moves.add(move);
                    }
                }
            }
        }
        return moves;
    }
    public boolean isPieceAttackedIfMoveIsPlayed(State state, Move move) {
        return false;
    }
}