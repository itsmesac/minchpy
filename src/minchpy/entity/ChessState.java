package minchpy.entity;

public class ChessState extends State {
	private Board currentPosition;
	private Player currentPlayer;
	
	public ChessState() {
		super();
	}

	public ChessState(Board currentPosition, Player currentPlayer) {
		super();
		this.currentPosition = currentPosition;
		this.currentPlayer = currentPlayer;
	}

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

	@Override
	public State clone() throws CloneNotSupportedException {
		ChessState chessStateClone = new ChessState();
		chessStateClone.setCurrentPosition(this.getCurrentPosition().clone());
		chessStateClone.setCurrentPlayer(this.getCurrentPlayer().clone());
		return chessStateClone;
	}
	
}
