package minchpy.entity;

public class MoveEval {
	Move move;
	
	Evaluation value;

	public MoveEval() {
		super();
	}

	public MoveEval(Move move, Evaluation value) {
		super();
		this.move = move;
		this.value = value;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}

	public Evaluation getValue() {
		return value;
	}

	public void setValue(Evaluation value) {
		this.value = value;
	}
	
}
