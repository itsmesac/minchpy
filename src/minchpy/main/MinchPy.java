package minchpy.main;

import java.util.Scanner;

import minchpy.entity.Board;
import minchpy.entity.ChessBoard;

public class MinchPy {
    Board cb;
    
	public MinchPy() {
		super();
		this.cb = new ChessBoard();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String userInput1 = in.next();
		String userInput2 = in.next();
		System.out.println(userInput1 + " " + userInput2);
	}
}
