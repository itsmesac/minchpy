package minchpy.test;

import java.util.List;

import minchpy.entity.Bishop;
import minchpy.entity.ChessBoard;
import minchpy.entity.ChessState;
import minchpy.entity.King;
import minchpy.entity.Move;
import minchpy.entity.Player;

public class Test {

	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		King king = new King(0);
		chessBoard.setPeiceOnSquare(3, 3, king);
		Bishop bishop = new Bishop(0);
		chessBoard.setPeiceOnSquare(3, 4, bishop);
		ChessState chessState = new ChessState(chessBoard, new Player(1));
		List<Move> kingMoves = king.getAllMoves(chessState, 3, 3);
		System.out.println(kingMoves.size());
	}

}
