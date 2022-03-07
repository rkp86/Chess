package chess;

public class Tile {

	private Pieces piece;
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
	
//	public String toString() {
//		return getS();
//	}
//	public Tile(int i, int j, Rook rook) {
//		this.piece = rook;
//		this.x = i;
//		this.y = j;
//	}
//	
//	public Tile(int i, int j, Knight knight) {
//		this.piece = knight;
//		this.x = i;
//		this.y = j;
//	}
//	
//	public Tile(int i, int j, Bishop bishop) {
//		this.piece = bishop;
//		this.x = i;
//		this.y = j;
//	}
//	
//	public Tile(int i, int j, Queen queen) {
//		this.piece = queen;
//		this.x = i;
//		this.y = j;
//	}
//	
//	public Tile(int i, int j, King king) {
//		this.piece = king;
//		this.x = i;
//		this.y = j;
//	}
//	
//	public Tile(int i, int j, Pawn pawn) {
//		this.piece = pawn;
//		this.x = i;
//		this.y = j;
//	}
	
	private void setY(int y) {
		this.y = y;	
	}
	
	private void setX(int x) {
		this.x = x;
	}
	
	private void setPieces(Pieces piece) {
		this.piece = piece;
	}
	
	private int getX() {
		return x;	
	}
	
	private int getY() {
		return y;	
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
