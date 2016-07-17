package minchpy.entity;

import java.util.List;

import minchpy.api.PieceMoves;

public abstract class Piece implements PieceMoves{
    protected int side;
    
    protected List<int[]> movementDirections = null;
    
    public List<int[]> getMovementDirections() {
        return movementDirections;
    }
    
    Piece (int side) {
        this.side = side;
    }
    
    public int getSide() {
        return side;
    }
    
    public void updateAfterMove() {
        
    }
    public boolean isPieceAttackedIfMoveIsPlayed(State state, Move move) {
        return false;
    }
}
