package minchpy.entity;

import java.util.ArrayList;
import java.util.List;
import minchpy.api.PieceMoves;
import minchpy.util.Constants;

public class Bishop extends Piece implements PieceMoves {

	public Bishop(int side) {
		super(side);
	}

	@Override
	public List<Move> getAllMoves(State state, int rank, int file) {
		List<Move> moves = new ArrayList<Move>();
		if (((ChessState) state).getCurrentPlayer().getPlayer() == side) {
			Board board = ((ChessState) state).getCurrentBoard();
			ChessBoard chessBoard = (ChessBoard) board;
			int[][] diagnols = { Constants.TOP_LEFT_DIRECTION, Constants.TOP_RIGHT_DIRECTION,
					Constants.BOTTOM_LEFT_DIRECTION, Constants.BOTTOM_RIGHT_DIRECTION };
			for (int[] direction : diagnols) {
				int nextMoveRank = rank + direction[Constants.X];
				int nextMoveFile = file + direction[Constants.Y];
				while((nextMoveRank < Constants.MAX_RANKS) && (nextMoveFile < Constants.MAX_FILES)) {
					if(!chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile).isEmpty()) {
						int nextMoveSquarePeicePlayer = chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile).getPiece().getSide();
						if(nextMoveSquarePeicePlayer == this.side) {
							break;
						} else {
							ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile));
							moves.add(move);
							break;
						}
					}
					ChessMove move = new ChessMove(chessBoard.getSquareOfBoard(rank, file), chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile));
					moves.add(move);
					nextMoveRank = nextMoveRank + direction[Constants.X];
					nextMoveFile = nextMoveFile + direction[Constants.Y];
				}
			}
		}
		return moves;
	}

}