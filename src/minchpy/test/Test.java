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
import minchpy.util.EvaluationConstants;

public class Test {

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        ChessState chessState = new ChessState(chessBoard, new Player(Constants.WHITE));
        List<Move> pawnMoves = chessBoard.getSquareOfBoard("E2").getPiece().getAllMoves(chessState, 1, Constants.E);
        ChessCBS cbs = new ChessCBS();
        cbs.makeMoveCB(chessState, pawnMoves.get(1));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("D2").getPiece().getAllMoves(chessState, 1, Constants.D).get(1));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("D1").getPiece().getAllMoves(chessState, 0, Constants.D).get(0));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("F1").getPiece().getAllMoves(chessState, 0, Constants.F).get(3));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("B5").getPiece().getAllMoves(chessState, 4, Constants.B).get(2));
        //chessState.setCurrentPlayer(new Player(Constants.BLACK));
        //cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("C8").getPiece().getAllMoves(chessState, 7, Constants.C).get(1));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("B1").getPiece().getAllMoves(chessState, 0, Constants.B).get(1));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("C3").getPiece().getAllMoves(chessState, 2, Constants.C).get(5));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("A2").getPiece().getAllMoves(chessState, 1, Constants.A).get(1));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("A1").getPiece().getAllMoves(chessState, 0, Constants.A).get(1));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("A3").getPiece().getAllMoves(chessState, 2, Constants.A).get(7));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("D2").getPiece().getAllMoves(chessState, 1, Constants.D).get(5));
        cbs.makeMoveCB(chessState, chessBoard.getSquareOfBoard("E1").getPiece().getAllMoves(chessState, 0, Constants.E).get(3));
        BoardDisplay board = new BoardDisplay(chessBoard);
        board.display();
        
        //System.out.println(EvaluationConstants.KING_PIECE_SQUARE_TABLE_MIDDLE_GAME[5][5]);

    }

}
