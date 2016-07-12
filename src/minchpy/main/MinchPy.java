package minchpy.main;

import java.util.Scanner;

import minchpy.entity.*;
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
        boolean compMove = false;
        
        if (userInput1.equals('n')) {
            compMove = true;
        }
        
        while (!mp.isGameOver()) {
            if (compMove == true) {
                mp.playCompMove();
                compMove = false;
            } else {
                mp.getPlayerMove(in);
                compMove = true;
            }
        }
    }

    //updates mp.st after playing the move
    private void getPlayerMove(Scanner in) {
        // get move from in
        // validate move (support - in check cond; no support - castling, en passant, promotion)
        // if valid, play move and update mp.st and return
        // else do step 1
    }

    private void playCompMove() {
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
    }
}
