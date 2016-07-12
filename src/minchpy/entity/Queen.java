package minchpy.entity;

import java.util.ArrayList;
import java.util.List;
import minchpy.api.PieceMoves;
import minchpy.util.Constants;

public class Queen extends Piece implements PieceMoves {

    public Queen(int side) {
        super(side);
    }

    @Override
    public List<Move> getAllMoves(State state, int rank, int file) {
        List<Move> moves = new ArrayList<Move>();
        if (((ChessState) state).getCurrentPlayer().getPlayer() == side) {
            Board board = ((ChessState) state).getCurrentBoard();
            ChessBoard chessBoard = (ChessBoard) board;
            int[][] directions = { Constants.TOP_DIRECTION, Constants.BOTTOM_DIRECTION, Constants.LEFT_DIRECTION,
                    Constants.RIGHT_DIRECTION, Constants.TOP_LEFT_DIRECTION, Constants.TOP_RIGHT_DIRECTION,
                    Constants.BOTTOM_LEFT_DIRECTION, Constants.BOTTOM_RIGHT_DIRECTION };
            for (int[] direction : directions) {
                int nextMoveRank = rank + direction[Constants.X];
                int nextMoveFile = file + direction[Constants.Y];
                while ((nextMoveRank >= 0) && (nextMoveRank < Constants.MAX_RANKS) && (nextMoveFile >= 0)
                        && (nextMoveFile < Constants.MAX_FILES)) {
                    Square nextPossibleMoveSquare = chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile);
                    if (!nextPossibleMoveSquare.isEmpty()) {
                        int nextMoveSquarePiecePlayer = nextPossibleMoveSquare.getPiece().getSide();
                        if (nextMoveSquarePiecePlayer != this.side) {
                            ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file),
                                    nextPossibleMoveSquare);
                            moves.add(move);
                        }
                        break;
                    } else {
                        ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), nextPossibleMoveSquare);
                        moves.add(move);
                        nextMoveRank = nextMoveRank + direction[Constants.X];
                        nextMoveFile = nextMoveFile + direction[Constants.Y];
                    }
                }
            }
        }
        return moves;
    }

}
