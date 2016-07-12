package minchpy.entity;

import java.lang.reflect.InvocationTargetException;

import minchpy.util.Constants;

public class ChessBoard extends Board {
	//TODO: implement ChessBoard class
	Square[][] board;
	
	//private static ChessBoard instance = null;
	
	private void createAndPlacePieceOnBoard(int rank, int file, int side) {
		Class[] piecesToBePlacedOnFirstRow = {Rook.class, Knight.class, Bishop.class, King.class, Queen.class, Bishop.class, Knight.class, Rook.class};
		Piece piece;
		try {
			if((rank == 1) || (rank == (Constants.MAX_FILES - 2)))
				piece = (Piece) new Pawn(side);
			else
				piece = (Piece) piecesToBePlacedOnFirstRow[file].getConstructor(int.class).newInstance(side);
			board[rank][file].setPiece(piece);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	private void initializePieces(int side) {
		int rank, file;
		for(int row = 0; row <= 1; row++) {
			if(side == Constants.WHITE) {
				rank = row;
				file = 0;
			}
			else {
				rank = Constants.MAX_RANKS - 1 - row;
				file = Constants.MAX_RANKS - 1;
			}
			while((file >= 0) && (file < Constants.MAX_FILES)) {
				createAndPlacePieceOnBoard(rank, file, side);
				if(side == Constants.WHITE)
					file++;
				else
					file--;
			}
		}
	}
	
	public ChessBoard() {
		super();
		board = new Square[Constants.MAX_FILES][Constants.MAX_RANKS];
		for(int i = 0; i < Constants.MAX_FILES; i++) {
			for(int j = 0; j < Constants.MAX_RANKS; j++) {
				board[i][j] = new Square();
			}
		}
		initializePieces(Constants.WHITE);
		initializePieces(Constants.BLACK);
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