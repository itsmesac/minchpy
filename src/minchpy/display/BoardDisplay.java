package minchpy.display;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;

import minchpy.entity.Bishop;
import minchpy.entity.ChessBoard;
import minchpy.entity.King;
import minchpy.entity.Knight;
import minchpy.entity.Pawn;
import minchpy.entity.Piece;
import minchpy.entity.Queen;
import minchpy.entity.Rook;
import minchpy.entity.Square;
import minchpy.util.Constants;

public class BoardDisplay extends JFrame {

    // Initialise arrays to hold panels and images of the board

    private ChessLabel[] labels = new ChessLabel[Constants.MAX_FILES * Constants.MAX_RANKS]; 


    public BoardDisplay(ChessBoard board) 
    {
        Square[][] chessBoard = board.getBoard();
        int chessLabelIndex = (Constants.MAX_FILES * Constants.MAX_RANKS) - 1;
        for(int i = 0; i < Constants.MAX_FILES; i++) {
            for(int j = (Constants.MAX_RANKS - 1); j >= 0; j--) {
                if(chessBoard[i][j].isEmpty())
                    labels[chessLabelIndex--] = new ChessLabel(" ");
                else {
                    Piece piece = chessBoard[i][j].getPiece();
                    if (piece instanceof Rook) {
                        if(piece.side == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_ROOK);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_ROOK);
                    }
                    if (piece instanceof Knight) {
                        if(piece.side == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_KNIGHT);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_KNIGHT);
                    }
                    if (piece instanceof Bishop) {
                        if(piece.side == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_BISHOP);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_BISHOP);
                    }
                    if (piece instanceof King) {
                        if(piece.side == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_KING);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_KING);
                    }
                    if (piece instanceof Queen) {
                        if(piece.side == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_QUEEN);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_QUEEN);
                    }
                    if (piece instanceof Pawn) {
                        if(piece.side == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_PAWN);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_PAWN);
                    }
                }
            }
        }
    }

    public void display() {
        setTitle("Chess board");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container contentPane = getContentPane();
        GridLayout gridLayout = new GridLayout(8, 8);

        contentPane.setLayout(gridLayout);

        int row = -1;
        for (int i = 0; i < labels.length; i++) {
            if (i % 8 == 0)
                row++; // increment row number
            labels[i].set(i, row);
            contentPane.add(labels[i]);
        } // i

        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    } 

}