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
		//chessStateClone.setCurrentEval(this.getCurrentEval().clone());
		
		return chessStateClone;
    }

    /*
     * General guidelines for static evaluation
     *
     * Priority Order:
     * 1 : King Safety
     *     - King at the corner, protected by pawns in front is safe
     *     - An open file near the king + the presence of opposite Rooks / Queen is unsafe
     *     - An open diagonal near the king + the presence of opposite Queen / Bishop + 
     *       absence of own similar colored bishop is unsafe
     *     - King tied to the defense of a piece / pawn are thus inactive is weak (in  the endgame)
     * 2 : Material
     * 3 : Center Control
     *     - More pawns in the center is strong
     * 4 : Activity of pieces
     *     - Exposed queen in early stages if the game is a weakness
     *     - Knights at the center is strong generally
     *     - Bishops blocked by own pieces are not strong
     *     - Rooks in open files are strong
     *     - A centralized king in the endgame is strong
     * 5 : Pawn Structure
     *     - Doubled pawns are weak
     *     - Isolated pawns are weak
     *     - Passed pawns are strong
     *     - Passed pawns supported by a pawn / pawns are strong
     *     - 
     */
    public void evaluate() {
    }
}
