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
        if((state instanceof ChessState) && (((ChessState) state).getCurrentPlayer().getPlayer() == side)){
            Board board = ((ChessState) state).getCurrentBoard();
            if(board instanceof ChessBoard) {
                ChessBoard chessBoard = (ChessBoard) board;
                if(((rank) < Constants.MAX_FILES) && ((file + 1) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank, file + 1).isEmpty() || 
                        chessBoard.getSquareOfBoard(rank, file + 1).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank, file + 1));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
                if(((rank - 1) < Constants.MAX_FILES) && ((file + 1) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank - 1, file + 1).isEmpty() || 
                        chessBoard.getSquareOfBoard(rank - 1, file + 1).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank - 1, file + 1));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
                if(((rank - 1) < Constants.MAX_FILES) && ((file) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank - 1, file).isEmpty() || 
                        chessBoard.getSquareOfBoard(rank - 1, file).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank - 1, file));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
                if(((rank - 1) < Constants.MAX_FILES) && ((file - 1) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank - 1, file - 1).isEmpty() || 
                        chessBoard.getSquareOfBoard(rank - 1, file - 1).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank - 1, file - 1));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
                if(((rank) < Constants.MAX_FILES) && ((file - 1) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank, file - 1).isEmpty() || 
                        chessBoard.getSquareOfBoard(rank, file - 1).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank, file - 1));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
                if(((rank + 1) < Constants.MAX_FILES) && ((file - 1) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank + 1, file - 1).isEmpty() || 
                        chessBoard.getSquareOfBoard(rank + 1, file - 1).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank + 1, file - 1));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
                if(((rank + 1) < Constants.MAX_FILES) && ((file) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank + 1, file).isEmpty() || 
                        chessBoard.getSquareOfBoard(rank + 1, file).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank + 1, file));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
                if(((rank + 1) < Constants.MAX_FILES) && ((file + 1) < Constants.MAX_RANKS) && (chessBoard.getSquareOfBoard(rank + 1, file + 1).isEmpty()  || 
                        chessBoard.getSquareOfBoard(rank + 1, file + 1).getPiece().getSide() != side)) {
                    ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank + 1, file + 1));
                    if (!this.isPieceAttackedIfMoveIsPlayed(state, move)) {
                        moves.add(move);
                    }
                }
            }
        }
        return moves;
    }

}
