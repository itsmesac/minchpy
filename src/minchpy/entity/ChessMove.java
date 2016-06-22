package minchpy.entity;

public class ChessMove extends Move {
	//TODO: implement ChessMove class
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
}
