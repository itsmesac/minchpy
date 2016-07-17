package minchpy.main;

import java.util.Scanner;

import minchpy.entity.ChessBoard;
import minchpy.entity.ChessState;
import minchpy.entity.Move;
import minchpy.entity.Player;
import minchpy.entity.State;
import minchpy.impl.ChessCBS;
import minchpy.util.Constants;

public class MinchPy {
    State st;
    boolean isGameOver;
    
    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    public MinchPy() {
        super();
        //setup initial board and player
        this.st = new ChessState(new Player(Constants.WHITE));
        this.isGameOver = false;
    }

    public static void main(String[] args) {
        MinchPy mp = new MinchPy();
        Scanner in = new Scanner(System.in);

        String userInput1;
        System.out.println("Play white? (y/n) : ");
        userInput1 = in.next();
        boolean isCompMove;
        ChessState chessState = null;
        if (userInput1.equals('y')) {
        	chessState = new ChessState(new ChessBoard(), new Player(Constants.WHITE));
        	isCompMove = false;
        } else {
        	chessState = new ChessState(new ChessBoard(), new Player(Constants.BLACK));
        	isCompMove = true;
        }
        
        ChessCBS cbs = new ChessCBS();
        while (!mp.isGameOver()) {
            if (isCompMove == true) {
            	Move compMove = mp.playCompMove();
            	cbs.makeMoveCB(chessState, compMove);
            	isCompMove = false;
            } else {
                Move playerMove = mp.getPlayerMove(in);
                cbs.makeMoveCB(chessState, playerMove);
                isCompMove = true;
            }
        }
    }

    //updates mp.st after playing the move
    private Move getPlayerMove(Scanner in) {
        // get move from in
    	Move playerMove = null;
    	boolean isValidMove = false;
    	while(!isValidMove) {
    		int currentRank = in.nextInt();
    		int currentFile = in.nextInt();
    		int nextMoveRank = in.nextInt();
    		int nextMoveFile = in.nextInt();
    	}
    	return playerMove;
        // validate move (support - in check cond; no support - castling, en passant, promotion)
        // if valid, play move and update mp.st and return
        // else do step 1
    }

    private Move playCompMove() {
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
    	return null;
    }
}
