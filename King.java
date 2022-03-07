package chess;

public class King extends Pieces {
	
	//can move in any direction
	
	public int move;
	public boolean color;
	
	public King() {
		
	}
	
	public King(boolean color, String st) {
		this.color=color;
		s = st;
	}
	
	public void movePiece(int i, int j) {
		
	}
}
