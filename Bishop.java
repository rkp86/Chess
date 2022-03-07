package chess;

public class Bishop extends Pieces{

	//can move diagonally (should check every spot in the diagonal before being allowed to move the piece)
	//basically next letter plus one (a6 <-- b5 <-- c4 <-- d3 <-- e2 <-- f1 --> g2 --> h3)
	
	public int move ;
	public boolean color;
	
	public Bishop() {
		// TODO Auto-generated constructor stub
	}
	
	public Bishop(boolean color, String st) {
		this.color = color;
		s=st;
	}

	public void movePiece(int i, int j) {
		
	}
}
