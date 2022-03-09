package chess;

public class Tile {

	private Pieces piece = null;
	private int x;
	private int y;
	private String s;
	
	public Tile() {
		piece = null;
		x = -1;
		y = -1;
		
	}
	
	public Tile(int i, int j, Pieces piece) {
		this.piece = (piece);
		this.x = i;
		this.y = j;
		//this.setS(s);
		/*if(piece != null) {
			if(s.contains("w")) {
				piece.isWhite = true;
			}
			else {
				piece.isWhite = false;
			}
		}
		*/
	}
	

	
	private void setY(int y) {
		this.y = y;	
	}
	
	private void setX(int x) {
		this.x = x;
	}
	
	public void setPieces(Pieces piece) {
		this.piece = piece;
	}
	
	
	
	Pieces getPieces() {
		return piece;	
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}
}
