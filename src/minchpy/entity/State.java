package minchpy.entity;

public class State {
	private Board currentPosition;
	private Depth depth;
	private Player currentPlayer;
	
	public Board getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(Board currentPosition) {
		this.currentPosition = currentPosition;
	}
	public Depth getDepth() {
		return depth;
	}
	public void setDepth(Depth depth) {
		this.depth = depth;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
}
