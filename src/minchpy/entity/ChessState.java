package minchpy.entity;

public class ChessState extends State {
	private Board currentPosition;
	private Player currentPlayer;
	
	public Board getCurrentPosition() {
		return currentPosition;
	}
	
	public void setCurrentPosition(Board currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
}