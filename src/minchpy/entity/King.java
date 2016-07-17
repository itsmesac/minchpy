package minchpy.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import minchpy.util.Constants;

public class King extends Piece {

    boolean isFirstMove; // for castling

    public King(int side) {
        super(side);
        isFirstMove = true;
        movementDirections = Arrays.asList(Constants.TOP_DIRECTION, Constants.BOTTOM_DIRECTION,
                Constants.LEFT_DIRECTION, Constants.RIGHT_DIRECTION, Constants.TOP_LEFT_DIRECTION,
                Constants.TOP_RIGHT_DIRECTION, Constants.BOTTOM_LEFT_DIRECTION, Constants.BOTTOM_RIGHT_DIRECTION);
    }

    public boolean isPieceAttackedIfMoveIsPlayed(State state, Move move) {
        // TODO: implement the function
        return false;
    }

    @Override
    public void updateAfterMove() {
        if (isFirstMove)
            isFirstMove = false;
    }

    @Override
    public List<Move> getAllMoves(State state, int rank, int file) {
        List<Move> moves = new ArrayList<Move>();
        //TODO Include castling option
        //TODO remove instanceof validation
        //TODO remove isEmpty for all - check if king is attacking
        /* TODO last condition in all the 'ifs' should be like 
             (chessBoard.getSquareOfBoard(rank, file + 1).isEmpty() || 
             chessBoard.getSquareOfBoard(rank, file + 1).isOpposition())
         */
        if (((ChessState) state).getCurrentPlayer().getPlayer() == side) {
            ChessBoard chessBoard = ((ChessState) state).getCurrentBoard();
            for (int[] direction : movementDirections) {
                int nextMoveRank = rank + direction[Constants.X];
                int nextMoveFile = file + direction[Constants.Y];
                if((nextMoveRank >= 0) && (nextMoveRank < Constants.MAX_RANKS) && (nextMoveFile >= 0) && (nextMoveFile < Constants.MAX_FILES)) {
                    Square nextPossibleMoveSquare = chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile);
                    if(!nextPossibleMoveSquare.isEmpty()) {
                        int nextMoveSquarePiecePlayer = nextPossibleMoveSquare.getPiece().getSide();
                        if(nextMoveSquarePiecePlayer != this.side) {
                            ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), nextPossibleMoveSquare);
                            if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                                moves.add(move);
                            }
                        }
                        break;
                    } else {
                        ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), nextPossibleMoveSquare);
                        if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                            moves.add(move);
                        }
                    }
                }
            }
        }
        return moves;
    }

}
