package minchpy.entity;

public class ChessState extends State {
	private Board currentBoard;
	private Player currentPlayer;
	private Evaluation currentEval;
	
	public Evaluation getCurrentEval() {
		return currentEval;
	}

	public void setCurrentEval(Evaluation currentEval) {
		this.currentEval = currentEval;
	}

	public ChessState() {
		super();
		this.currentBoard = new ChessBoard();
		this.currentPlayer = new Player();
		this.currentEval = new Evaluation();
	}
	
	public ChessState(Board currentBoard) {
		super();
		this.currentBoard = currentBoard;
		this.currentPlayer = new Player();
		this.currentEval = new Evaluation();
	}
	
	public ChessState(Player currentPlayer) {
		super();
		this.currentBoard = new ChessBoard();
		this.currentPlayer = currentPlayer;
		this.currentEval = new Evaluation();
	}
	
	public ChessState(Board currentBoard, Player currentPlayer) {
		super();
		this.currentBoard = currentBoard;
		this.currentPlayer = currentPlayer;
		this.currentEval = new Evaluation();
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
		chessStateClone.setCurrentEval(this.getCurrentEval().clone());
		
		return chessStateClone;
	}
	
}
