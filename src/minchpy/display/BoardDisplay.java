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

    private ChessLabel[] labels = new ChessLabel[(Constants.MAX_FILES) * (Constants.MAX_RANKS)]; 
    
    private ChessLabel[] rankFileValues = new ChessLabel[(Constants.MAX_FILES * 2) + 1];
    
    private void initializeRankFileValues() {
        for(int i = 0; i < Constants.MAX_FILES; i++) {
            rankFileValues[i] = new ChessLabel(Character.toString((char)('a' + i)));
            rankFileValues[Constants.MAX_FILES + i + 1] = new ChessLabel(Integer.toString(Constants.MAX_FILES - i));
        }
        rankFileValues[Constants.MAX_FILES] = new ChessLabel("*");
    }

    public BoardDisplay(ChessBoard board) 
    {
        initializeRankFileValues();
        Square[][] chessBoard = board.getBoard();
        int chessLabelIndex = (Constants.MAX_FILES * Constants.MAX_RANKS) - 1;
        for(int i = 0; i < Constants.MAX_FILES; i++) {
            for(int j = (Constants.MAX_RANKS - 1); j >= 0; j--) {
                if(chessBoard[i][j].isEmpty())
                    labels[chessLabelIndex--] = new ChessLabel(" ");
                else {
                    Piece piece = chessBoard[i][j].getPiece();
                    if (piece instanceof Rook) {
                        if(piece.getSide() == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_ROOK);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_ROOK);
                    }
                    if (piece instanceof Knight) {
                        if(piece.getSide() == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_KNIGHT);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_KNIGHT);
                    }
                    if (piece instanceof Bishop) {
                        if(piece.getSide() == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_BISHOP);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_BISHOP);
                    }
                    if (piece instanceof King) {
                        if(piece.getSide() == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_KING);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_KING);
                    }
                    if (piece instanceof Queen) {
                        if(piece.getSide() == Constants.WHITE)
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.WHITE_QUEEN);
                        else
                            labels[chessLabelIndex--] = new ChessLabel(DisplayConstants.BLACK_QUEEN);
                    }
                    if (piece instanceof Pawn) {
                        if(piece.getSide() == Constants.WHITE)
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
        GridLayout gridLayout = new GridLayout(9, 9);

        contentPane.setLayout(gridLayout);
        
        for(int i = 0; i < Constants.MAX_FILES; i++) {
            rankFileValues[i].setRankFile(i, 0);
            contentPane.add(rankFileValues[i]);
        }

        int row = 0;
        for (int i = 0; i < labels.length; i++) {
            if (i % 8 == 0) {
                row++; // increment row number
                rankFileValues[Constants.MAX_FILES + (row - 1)].setRankFile(Constants.MAX_FILES + (row - 1), row);
                contentPane.add(rankFileValues[Constants.MAX_FILES + (row - 1)]);
            }
            labels[i].set(i, row);
            contentPane.add(labels[i]);
        } // i
        row++;
        rankFileValues[Constants.MAX_FILES + (row - 1)].setRankFile(Constants.MAX_FILES + (row - 1), row);
        contentPane.add(rankFileValues[Constants.MAX_FILES + (row - 1)]);
        
        setSize(600, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    } 

}