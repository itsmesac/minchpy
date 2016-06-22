package minchpy.entity;

import minchpy.util.Constants;

public class ChessBoard extends Board {
	//TODO: implement ChessBoard class
	Square[][] board;
	
	//private static ChessBoard instance = null;
	public ChessBoard() {
		super();
		board = new Square[Constants.MAX_FILES][Constants.MAX_RANKS];
		for(int i = 0; i < Constants.MAX_FILES; i++) {
			for(int j = 0; j < Constants.MAX_RANKS; j++) {
				board[i][j] = new Square();
			}
		}
	}

	public Square[][] getBoard() {
		return board;
	}

	@Override
	protected ChessBoard clone() throws CloneNotSupportedException {
		ChessBoard chessBoardClone = new ChessBoard();
		//FIXME: add clone implementation here
		return chessBoardClone;
	}
	
	public Square getSquareOfBoard(int x, int y) {
		return board[x][y];
	}
	
	public void setPeiceOnSquare(int x, int y, Piece piece) {
		if((x < Constants.MAX_FILES) && (y < Constants.MAX_RANKS))
			board[x][y].setPiece(piece);
	}
}