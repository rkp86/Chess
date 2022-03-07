package chess;

public class Rook extends Pieces {
	
	//can move up and down (check pieces in the same row and column)
	public int move ;
	public boolean color;
	
	
	public Rook() {
		
	}
	
	public Rook(boolean color, String st) {
		this.color = color;
		s = st;
	}
	
	public void movePiece(int i, int j) {
		
	}
}
