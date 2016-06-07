package minchpy.entity;

import minchpy.util.Constants;

//TODO: Make this a singleton class
public class ChessBoard extends Board {
	//TODO: implement ChessBoard class
	Square board[];
	
	private static ChessBoard instance = null;
	protected ChessBoard() {
		board = new Square[Constants.MAX_FILES * Constants.MAX_RANKS];
	}

	public static ChessBoard getInstance() {
		if (instance == null) {
			instance = new ChessBoard();
		}
		return instance;
	}

	@Override
	protected ChessBoard clone() throws CloneNotSupportedException {
		ChessBoard chessBoardClone = new ChessBoard();
		//FIXME: add clone implementation here
		return chessBoardClone;
	}
}