package minchpy.entity;

import java.util.ArrayList;
import java.util.List;

import minchpy.api.PieceMoves;

import minchpy.util.Constants;

public class King extends Piece implements PieceMoves{
	
	public King(int side) {
		super(side);
	}
	
	public boolean isAttacked(State state, int rank, int file) {
		//TODO: implement the function
		return false;
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
				if(((rank) < Constants.MAX_FILES) && ((file + 1) < Constants.MAX_RANKS) && !isAttacked(state, rank, file + 1) && (chessBoard.getSquareOfBoard(rank, file + 1).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank, file + 1));
					moves.add(move);
				}
				if(((rank - 1) < Constants.MAX_FILES) && ((file + 1) < Constants.MAX_RANKS) && !isAttacked(state, rank - 1, file + 1) && (chessBoard.getSquareOfBoard(rank - 1, file + 1).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank - 1, file + 1));
					moves.add(move);
				}
				if(((rank - 1) < Constants.MAX_FILES) && ((file) < Constants.MAX_RANKS) && !isAttacked(state, rank - 1, file) && (chessBoard.getSquareOfBoard(rank - 1, file).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank - 1, file));
					moves.add(move);
				}
				if(((rank - 1) < Constants.MAX_FILES) && ((file - 1) < Constants.MAX_RANKS) && !isAttacked(state, rank - 1, file - 1) && (chessBoard.getSquareOfBoard(rank - 1, file - 1).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank - 1, file - 1));
					moves.add(move);
				}
				if(((rank) < Constants.MAX_FILES) && ((file - 1) < Constants.MAX_RANKS) && !isAttacked(state, rank, file - 1) && (chessBoard.getSquareOfBoard(rank, file - 1).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank, file - 1));
					moves.add(move);
				}
				if(((rank + 1) < Constants.MAX_FILES) && ((file - 1) < Constants.MAX_RANKS) && !isAttacked(state, rank + 1, file - 1) && (chessBoard.getSquareOfBoard(rank + 1, file - 1).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank + 1, file - 1));
					moves.add(move);
				}
				if(((rank + 1) < Constants.MAX_FILES) && ((file) < Constants.MAX_RANKS) && !isAttacked(state, rank + 1, file) && (chessBoard.getSquareOfBoard(rank + 1, file).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank + 1, file));
					moves.add(move);
				}
				if(((rank + 1) < Constants.MAX_FILES) && ((file + 1) < Constants.MAX_RANKS) && !isAttacked(state, rank + 1, file + 1) && (chessBoard.getSquareOfBoard(rank + 1, file + 1).isEmpty())) {
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(rank + 1, file + 1));
					moves.add(move);
				}
			}
		}
		return moves;
	}
	
}
