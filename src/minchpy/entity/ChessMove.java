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
            
//        } else {
//            isValidMove = true;
//            boolean hasManyMovesInOneDirection = false;
//            List<int[]> directions = src.getPiece().getMovementDirections();
//            if ((src.getPiece() instanceof Bishop) || (src.getPiece() instanceof Queen)
//                    || (src.getPiece() instanceof Rook)) {
//                hasManyMovesInOneDirection = true;
//            } else if ((src.getPiece() instanceof King) || (src.getPiece() instanceof Knight)) {
//                hasManyMovesInOneDirection = false;
//            }
//            for (int[] direction : directions) {
//                int nexValidMoveRank = currentRank + direction[Constants.X];
//                int nexValidMoveFile = currentFile + direction[Constants.Y];
//                do {
//                    if ((nexValidMoveRank >= 0) && (nexValidMoveRank < Constants.MAX_RANKS) && (nexValidMoveFile >= 0)
//                            && (nexValidMoveFile < Constants.MAX_FILES)) {
//                        if ((nextMoveRank == nexValidMoveRank) && (nextMoveFile == nexValidMoveFile)) {
//                            isValidMove = true;
//                            ChessBoard chessBoard = (ChessBoard) ((ChessState) state).getCurrentBoard();
//                            Square nextPossibleMoveSquare = chessBoard.getSquareOfBoard(nextMoveRank, nextMoveFile);
//                            if (!nextPossibleMoveSquare.isEmpty()) {
//                                int nextMoveSquarePiecePlayer = nextPossibleMoveSquare.getPiece().getSide();
//                                if (nextMoveSquarePiecePlayer == src.getPiece().getSide()) {
//                                    isValidMove = false;
//                                }
//                            }
//                            break;
//                        }
//                        nexValidMoveRank = nexValidMoveRank + direction[Constants.X];
//                        nexValidMoveFile = nexValidMoveFile + direction[Constants.Y];
//                    }
//                } while (hasManyMovesInOneDirection);
//            }
        return isValidMove;
    }
}
