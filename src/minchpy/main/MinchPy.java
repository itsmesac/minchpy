package minchpy.main;

import java.util.Scanner;

import minchpy.display.BoardDisplay;
import minchpy.entity.ChessBoard;
import minchpy.entity.ChessMove;
import minchpy.entity.ChessState;
import minchpy.entity.Move;
import minchpy.entity.Player;
import minchpy.impl.ChessCBS;
import minchpy.util.Constants;
import minchpy.util.OpeningMoves;

public class MinchPy {
    ChessState st;
    boolean isGameOver;
    private static boolean isMidGame;

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public MinchPy() {
        super();
        // setup initial board and player
        this.st = new ChessState(new Player(Constants.WHITE));
        this.isGameOver = false;
        isMidGame = false;
    }

    public static void main(String[] args) {
        MinchPy mp = new MinchPy();
        Scanner in = new Scanner(System.in);

        String userInput1;
        System.out.println("Play white? (y/n) : ");
        userInput1 = in.next();
        boolean isCompMove;
        ChessState chessState = null;
        if (userInput1.equals("y")) {
            chessState = new ChessState(new ChessBoard(), new Player(Constants.WHITE));
            isCompMove = false;
        } else {
            chessState = new ChessState(new ChessBoard(), new Player(Constants.BLACK));
            isCompMove = true;
        }
        BoardDisplay board = new BoardDisplay(chessState.getCurrentBoard());
        board.display();
        ChessCBS cbs = new ChessCBS();
        while (!mp.isGameOver()) {
            if (isCompMove == true) {
                Move compMove = mp.playCompMove(chessState);
                cbs.makeMoveCB(chessState, compMove);
                isCompMove = false;
            } else {
                Move playerMove = mp.getPlayerMove(in, chessState);
                cbs.makeMoveCB(chessState, playerMove);
                isCompMove = true;
            }
            board = new BoardDisplay(chessState.getCurrentBoard());
            board.display();
        }
        System.out.println("Terminated");
    }

    // updates mp.st after playing the move
    private Move getPlayerMove(Scanner in, ChessState chessState) {
        // get move from in
        // validate move (support - in check cond; no support - castling, en
        // passant, promotion)
        // if valid, play move and update mp.st and return
        // else do step 1
        ChessMove playerMove = null;
        boolean isValidMove = false;
        while (!isValidMove) {
            String currentPosition = in.next();
            String nextMovePosition = in.next();
            playerMove = new ChessMove(chessState.getCurrentBoard().getSquareOfBoard(currentPosition),
                    chessState.getCurrentBoard().getSquareOfBoard(nextMovePosition));
            isValidMove = playerMove.isValid(chessState);
            if (!isValidMove)
                System.out.println("Invalid Move! Play again");
            if (isValidMove && !isMidGame)
                OpeningMoves.getInstance().logMove(currentPosition + nextMovePosition);
        }
        return playerMove;
    }

    private Move playCompMove(ChessState chessState) {
        // somewhere in this workflow,
        // do a static evaluation of the position.
        // static eval should be based on relative
        // positions of the pieces, piece activity,
        // pawn structures, king safety, material
        // difference etc. This can be continuously
        // improved upon and fine tuned.
        // For the alpha beta pruning algo, this
        // would be the root value. Now, consider
        // each move and run eval() on the resuting
        // position while applying a-b algo.
        ChessMove compMove = null;
        if (!isMidGame) {
            String nextMoveString = OpeningMoves.getInstance().getNextOpeningMove();
            if (nextMoveString != null) {
                String currentPosition = nextMoveString.substring(0, 2);
                String nextMovePosition = nextMoveString.substring(2, 4);
                compMove = new ChessMove(chessState.getCurrentBoard().getSquareOfBoard(currentPosition),
                        chessState.getCurrentBoard().getSquareOfBoard(nextMovePosition));
                OpeningMoves.getInstance().logMove(nextMoveString);
            } else {
                isMidGame = true;
            }
        }
        if (isMidGame) {
            // TODO : implement the midgame
        }
        return compMove;
    }
}
