package minchpy.entity;

import java.util.List;

import minchpy.util.Constants;

public class ChessMove extends Move {
    public Square src;
    public Square dst;

    public ChessMove() {
        super();
    }

    public ChessMove(Square src, Square dest) {
        super();
        this.src = src;
        this.dst = dest;
    }

    public Square getSrc() {
        return src;
    }

    public void setSrc(Square src) {
        this.src = src;
    }

    public Square getDst() {
        return dst;
    }

    public void setDst(Square dst) {
        this.dst = dst;
    }

    public boolean isValid(ChessState state) {
        boolean isValidMove = false;
        int currentRank = src.getRank();
        int currentFile = src.getFile();
        int nextMoveRank = dst.getRank();
        int nextMoveFile = dst.getFile();
        List<Move> pawnMoves = src.getPiece().getAllMoves(state, currentRank, currentFile);
        for (Move move : pawnMoves) {
            if ((((ChessMove) move).getDst().getRank() == nextMoveRank)
                    && (((ChessMove) move).getDst().getFile() == nextMoveFile)) {
                isValidMove = true;
                break;
            }
        }
        return isValidMove;
    }
}
