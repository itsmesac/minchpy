package minchpy.test;

import java.util.List;

import minchpy.display.BoardDisplay;
import minchpy.entity.ChessBoard;
import minchpy.entity.ChessState;
import minchpy.entity.Move;
import minchpy.entity.Pawn;
import minchpy.entity.Player;
import minchpy.impl.ChessCBS;
import minchpy.util.Constants;

public class Test {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        ChessState chessState = new ChessState(chessBoard, new Player(Constants.WHITE));
        List<Move> pawnMoves = ((Pawn)chessBoard.getSquareOfBoard("E2").getPiece()).getAllMoves(chessState, 1, Constants.E);
        ChessCBS cbs = new ChessCBS();
        cbs.makeMoveCB(chessState, pawnMoves.get(1));
        BoardDisplay board = new BoardDisplay(chessBoard);
        board.display();
//        King king = new King(Constants.WHITE);
//        chessBoard.setPeiceOnSquare(3, 3, king);
//        //Bishop bishop = new Bishop(0);
//        //chessBoard.setPeiceOnSquare(3, 4, bishop);
//        ChessState chessState = new ChessState(chessBoard, new Player(0));
//        //testing king getAllMoves method - basic - number of moves generated test
//        List<Move> kingMoves = king.getAllMoves(chessState, 3, 3);
//        System.out.println(kingMoves.size());
//        //testing bishop getAllMoves method - basic - number of moves generated test
//        Bishop bishop = new Bishop(Constants.WHITE);
//        chessBoard.setPeiceOnSquare(4, 4, bishop);
//        Bishop oppositePlayerBishop = new Bishop(Constants.BLACK);
//        chessBoard.setPeiceOnSquare(2, 6, oppositePlayerBishop);
//        List<Move> bishopMoves = bishop.getAllMoves(chessState, 4, 4);
//        System.out.println(bishopMoves.size());
//        //testing rook getAllMoves method - basic - number of moves generated test
//        Rook rook = new Rook(Constants.WHITE);
//        chessBoard.setPeiceOnSquare(0, 0, rook);
//        List<Move> rookMoves = rook.getAllMoves(chessState, 0, 0);
//        System.out.println(rookMoves.size());
//        //testing queen getAllMoves method - basic - number of moves generated test
//        Queen queen = new Queen(Constants.WHITE);
//        chessBoard.setPeiceOnSquare(1, 4, queen);
//        List<Move> queenMoves = queen.getAllMoves(chessState, 1, 4);
//        System.out.println(queenMoves.size());
//        //testing pawn getAllMoves method - basic - number of moves generated test
//        Pawn pawn = new Pawn(Constants.WHITE);
//        chessBoard.setPeiceOnSquare(1, 5, pawn);
//        List<Move> pawnMoves = pawn.getAllMoves(chessState, 1, 5);
//        System.out.println(pawnMoves.size());
        System.out.println("test");
    }

}
