package minchpy.entity;

public class Square {
    Piece piece;
    final int rank;
    final int file;
    
    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    
    public void clear() {
        this.piece = null;
    }

    public Square(int rank, int file) {
        piece = null;
        this.rank = rank;
        this.file = file;
    }
    
    public boolean isEmpty() {
        if(this.piece == null)
            return true;
        else
            return false;
    }
}
