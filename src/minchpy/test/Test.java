package minchpy.test;

import java.util.List;

import minchpy.entity.Bishop;
import minchpy.entity.ChessBoard;
import minchpy.entity.ChessState;
import minchpy.entity.King;
import minchpy.entity.Move;
import minchpy.entity.Pawn;
import minchpy.entity.Player;
import minchpy.entity.Queen;
import minchpy.entity.Rook;
import minchpy.util.Constants;

public class Test {

	public static void main(String[] args) {
		ChessBoard chessBoard = new ChessBoard();
		King king = new King(Constants.WHITE);
		chessBoard.setPeiceOnSquare(3, 3, king);
		//Bishop bishop = new Bishop(0);
		//chessBoard.setPeiceOnSquare(3, 4, bishop);
		ChessState chessState = new ChessState(chessBoard, new Player(0));
		//testing king getAllMoves method - basic - number of moves generated test
		List<Move> kingMoves = king.getAllMoves(chessState, 3, 3);
		System.out.println(kingMoves.size());
		//testing bishop getAllMoves method - basic - number of moves generated test
		Bishop bishop = new Bishop(Constants.WHITE);
		chessBoard.setPeiceOnSquare(4, 4, bishop);
		Bishop oppositePlayerBishop = new Bishop(Constants.BLACK);
		chessBoard.setPeiceOnSquare(2, 6, oppositePlayerBishop);
		List<Move> bishopMoves = bishop.getAllMoves(chessState, 4, 4);
		System.out.println(bishopMoves.size());
		//testing rook getAllMoves method - basic - number of moves generated test
		Rook rook = new Rook(Constants.WHITE);
		chessBoard.setPeiceOnSquare(0, 0, rook);
		List<Move> rookMoves = rook.getAllMoves(chessState, 0, 0);
		System.out.println(rookMoves.size());
		//testing queen getAllMoves method - basic - number of moves generated test
		Queen queen = new Queen(Constants.WHITE);
		chessBoard.setPeiceOnSquare(1, 4, queen);
		List<Move> queenMoves = queen.getAllMoves(chessState, 1, 4);
		System.out.println(queenMoves.size());
		//testing pawn getAllMoves method - basic - number of moves generated test
		Pawn pawn = new Pawn(Constants.WHITE);
		chessBoard.setPeiceOnSquare(1, 5, pawn);
		List<Move> pawnMoves = pawn.getAllMoves(chessState, 1, 5);
		System.out.println(pawnMoves.size());
	}

}
