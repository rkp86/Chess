package chess;

public class Queen extends Pieces {

	//can move up down diagonally anywhere as long as there is no piece in the way
	public int move ;
	public boolean color;
	
	public Queen() {
		
	}
	
	public Queen(boolean color, String st) {
		this.color=color;
		s = st;
	}
	
	public void movePiece(int i, int j) {
		
	}
}
