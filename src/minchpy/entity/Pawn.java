package minchpy.entity;

import java.util.ArrayList;
import java.util.List;

import minchpy.api.PieceMoves;
import minchpy.util.Constants;

public class Pawn extends Piece implements PieceMoves {

	boolean isFirstMove;

	public Pawn(int side) {
		super(side);
		isFirstMove = true;
	}
	

	@Override
	public void updateAfterMove() {
		isFirstMove = false;
	}


	@Override
	public List<Move> getAllMoves(State state, int rank, int file) {
		List<Move> moves = new ArrayList<Move>();
		if (((ChessState) state).getCurrentPlayer().getPlayer() == side) {
			Board board = ((ChessState) state).getCurrentBoard();
			ChessBoard chessBoard = (ChessBoard) board;
			int[] pieceMovementDirection;
			if (this.side == Constants.WHITE)
				pieceMovementDirection = Constants.TOP_DIRECTION;
			else
				pieceMovementDirection = Constants.BOTTOM_DIRECTION;
			List<int[]> directions = new ArrayList<int[]>();
			directions.add(pieceMovementDirection);
			if (isFirstMove) {
				int[] extraMove = { 0, 0 };
				// To move two steps further
				for (int i = 0; i < 2; i++) {
					extraMove[Constants.X] += pieceMovementDirection[Constants.X];
					extraMove[Constants.Y] += pieceMovementDirection[Constants.Y];
				}
				directions.add(extraMove);
			}
			for (int[] direction : directions) {
				int nextMoveRank = rank + direction[Constants.X];
				int nextMoveFile = file + direction[Constants.Y];
				if ((nextMoveRank >= 0) && (nextMoveRank < Constants.MAX_RANKS) && (nextMoveFile >= 0)
						&& (nextMoveFile < Constants.MAX_FILES)) {
					Square nextPossibleMoveSquare = chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile);
					if (nextPossibleMoveSquare.isEmpty()) {
						ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), nextPossibleMoveSquare);
						moves.add(move);
					}
				}
			}
			// code to capture opponent pieces (if possible)
			directions = new ArrayList<int[]>();
			if (this.side == Constants.WHITE) {
				directions.add(Constants.TOP_LEFT_DIRECTION);
				directions.add(Constants.TOP_RIGHT_DIRECTION);
			} else {
				directions.add(Constants.BOTTOM_LEFT_DIRECTION);
				directions.add(Constants.BOTTOM_RIGHT_DIRECTION);
			}
			for (int[] direction : directions) {
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
					}
				}
			}
		}
		return moves;
	}

}