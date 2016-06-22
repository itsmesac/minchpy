package minchpy.entity;

public class ChessState extends State {
	private Board currentBoard;
	private Player currentPlayer;
	
	public ChessState() {
		super();
	}

	public ChessState(Board currentBoard, Player currentPlayer) {
		super();
		this.currentBoard = currentBoard;
		this.currentPlayer = currentPlayer;
	}

	public Board getCurrentBoard() {
		return currentBoard;
	}
	
	public void setCurrentBoard(Board currentBoard) {
		this.currentBoard = currentBoard;
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
		chessStateClone.setCurrentBoard(this.getCurrentBoard().clone());
		chessStateClone.setCurrentPlayer(this.getCurrentPlayer().clone());
		return chessStateClone;
	}
	
}
