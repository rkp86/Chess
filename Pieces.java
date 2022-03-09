package chess;

public abstract class Pieces {

	public String name;
	public String location;
	//public boolean isWhite;
	public boolean hasMoved;
	protected String s;
	protected int count;
	static boolean checkmate = false;
	static boolean promote = false;
	static String promotion = "";

//	public static final int horizontal = 1;
	
	public abstract void movePiece(Pieces p, int i, int j, int i1, int j1);
	
	public Pieces() {
		this.name     = null;
		this.location = null;
	}
	
	public String getS() {
		return s;
	}

	public void illegalMove() { //figure out how to call playersMove again
		if(Chess.resign != true ) {
			System.out.println("Illegal move, try again");
			Chess.nextCall(false);
		}
	}
	
	public void checkmate() {
		System.out.println("Checkmate");
		if (Board.colorMove) System.out.println("White wins");
		if (!Board.colorMove) System.out.println("Black wins");
	}
	
	public void move(Pieces p, int i, int j, int i1, int j1) {
		
		String piece = Board.x[i][j].getPieces().getS().substring(0,1);
		
		if (checkmate) {
			checkmate();
		}
		else if (Board.isPieceBoard[i1][j1]) {
			String cmp = Board.x[i1][j1].getPieces().getS().substring(0,1);
			
			if (cmp.equals(piece))  illegalMove(); 
				
			else {
				if (promote) promote(i,j,i1,j1);
				else {
				Board.x[i1][j1] = Board.x[i][j]; 
				Board.x[i][j] = null;
				Board.isPieceBoard[i][j] = false;
				Board.isPieceBoard[i1][j1] = true;
				Chess.nextCall(true);
				}
			}
		
		}
		else {
			if (promote) promote(i,j,i1,j1);
			else {
			Board.x[i1][j1] = Board.x[i][j]; 
			Board.x[i][j] = null;
			Board.isPieceBoard[i][j] = false;
			Board.isPieceBoard[i1][j1] = true;
			Chess.nextCall(true);
			}
		}
	}
	
	public void promote(int i, int j, int i1, int j1) {
		if (promote && Board.colorMove) {
			switch (promotion) {
			case "N" : Board.x[i1][j1] = new Tile(i1, j1, new Knight("wN "));
			case "R" : Board.x[i1][j1] = new Tile(i1, j1, new Rook("wR "));
			case "B" : Board.x[i1][j1] = new Tile(i1, j1, new Bishop("wB "));
			case "Q" : Board.x[i1][j1] = new Tile(i1, j1, new Queen("wQ "));
			default : Board.x[i1][j1] = new Tile(i1, j1, new Queen( "wQ "));
			}
		}
		if (promote && !Board.colorMove) {
			switch (promotion) {
			case "N" : Board.x[i1][j1] = new Tile(i1, j1, new Knight("bN "));
			case "R" : Board.x[i1][j1] = new Tile(i1, j1, new Rook( "bR "));
			case "B" : Board.x[i1][j1] = new Tile(i1, j1, new Bishop( "bB "));
			case "Q" : Board.x[i1][j1] = new Tile(i1, j1, new Queen("bQ "));
			default : Board.x[i1][j1] = new Tile(i1, j1, new Queen( "bQ "));
			}
		}
		Board.x[i][j] = null;
		Board.isPieceBoard[i][j] = false;
		Board.isPieceBoard[i1][j1] = true;
		Chess.nextCall(true);
		promote = false;
		promotion = "";
	}
	
	
}
