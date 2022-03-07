package chess;

public abstract class Pieces {

	public String name;
	public String location;
	//public boolean isWhite;
	public boolean hasMoved;
	protected String s;
	
	
	public static final int horizontal = 1;
	public static final int vertical = 2;
	public static final int diagonal = 3;
	
	public abstract void movePiece(int i, int j);
	
	
	public Pieces() {
		this.name     = null;
		this.location = null;
	}
	
	public String getS() {
		return s;
	}

}
