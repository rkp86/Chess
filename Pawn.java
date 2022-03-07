package chess;

public class Pawn extends Pieces {

	//can only move straight one block
	//can move two blocks the first time
	//can take a piece in its diagonal 
	
	
	//remember to account for EN PASANT!!!!!!!!!!
	//also that it can become a queen, knight, etc when it reaches the other side
	
	public int count; //if 0, then can move up two blocks
	public int move = 4; //can only move up one and two on the first move
	public boolean color;
	
	
	public Pawn() {
		this.count = 0;
		
	}
	public Pawn(boolean c, String st) {
		this.count = 0;
		this.color = c;
		s = st;
		
	}
	
	public void movePiece(int i, int j) {
		
	}
	
	
	
	
	
}
