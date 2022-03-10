package chess;

public abstract class Pieces {

	public String name;
	public String location;
	//public boolean isWhite;
	public boolean hasMoved;
	protected String s;
	//protected int count;
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
		
			if(checkmate && checkCheckmate(i1, j1))
				checkmate();
			else if (Board.isPieceBoard[i1][j1]) {
			String cmp = Board.x[i1][j1].getPieces().getS().substring(0,1);
			
				if (cmp.equals(piece))  illegalMove(); 
				else {
					Board.x[i1][j1] = Board.x[i][j]; 
					Board.x[i][j] = null;
					Board.isPieceBoard[i][j] = false;
					Board.isPieceBoard[i1][j1] = true;
					Chess.nextCall(true);
				}
			}
			else if (promote) promote(i,j,i1,j1);
			else {
				Board.x[i1][j1] = Board.x[i][j]; 
				Board.x[i][j] = null;
				Board.isPieceBoard[i][j] = false;
				Board.isPieceBoard[i1][j1] = true;
				Chess.nextCall(true);
			}
	}
	
	public void promote(int i, int j, int i1, int j1) {
		System.out.println(Board.colorMove + " " + promotion );
		if (promote && Board.colorMove) {
			if (promotion.equals("N")) { Board.x[i1][j1] = new Tile(i1, j1, new Knight("wN ")); }
			else if (promotion.equals("R")) {  Board.x[i1][j1] = new Tile(i1, j1, new Rook("wR ")); }
			else if (promotion.equals("B")) {  Board.x[i1][j1] = new Tile(i1, j1, new Bishop("wB ")); }
			else if (promotion.equals("Q") || promotion.isEmpty()) {  Board.x[i1][j1] = new Tile(i1, j1, new Queen("wQ ")); }	
		}
		if (promote && !Board.colorMove) {
			if (promotion.equals("N")) { Board.x[i1][j1] = new Tile(i1, j1, new Knight("bN ")); }
			else if (promotion.equals("R")) {  Board.x[i1][j1] = new Tile(i1, j1, new Rook("bR ")); }
			else if (promotion.equals("B")) {  Board.x[i1][j1] = new Tile(i1, j1, new Bishop("bB ")); }
			else if (promotion.equals("Q") || promotion.isEmpty()) {  Board.x[i1][j1] = new Tile(i1, j1, new Queen("bQ ")); }
		}
		Board.x[i][j] = null;
		Board.isPieceBoard[i][j] = false;
		Board.isPieceBoard[i1][j1] = true;
		Chess.nextCall(true);
		
	}
	
	
	
	public boolean checkCheckmate(int i, int j) { 
		//check the whole board for any possibility of breaking the checkmate
		boolean pos = true;
	
////////Pawn
		if (Board.colorMove && i-1 >= 0 && j+1 < 8 && Board.isPieceBoard[i-1][j+1] && Board.x[i-1][j+1].getPieces().s.substring(0,2).equals("bp")) pos = false;
		if (Board.colorMove && i-1 >= 0 && j-1 >=0 &&Board.isPieceBoard[i-1][j-1] && Board.x[i-1][j-1].getPieces().s.substring(0,2).equals("bp")) pos = false;
	
		if (!Board.colorMove && i+1 < 8 && j+1 < 8 && Board.isPieceBoard[i+1][j+1] &&Board.x[i+1][j+1].getPieces().s.substring(0,2).equals("w"))  pos = false;
		if (!Board.colorMove &&i+1 < 8 && j-1 >=0 && Board.isPieceBoard[i+1][j-1] && Board.x[i+1][j-1].getPieces().s.substring(0,2).equals("w"))  pos = false;

//////////Knight		
		if (i-1 >= 0 && j-2 >= 0 ) {
			if (Board.colorMove && Board.isPieceBoard[i-1][j-2] && Board.x[i-1][j-2].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i-1][j-2] && Board.x[i-1][j-2].getPieces().s.substring(0,2).equals("wN")) pos = false;			
		}
		else if (i-2 >= 0 && j-1 >= 0 ) {
			if (Board.colorMove && Board.isPieceBoard[i-2][j-1] && Board.x[i-2][j-1].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i-2][j-1] && Board.x[i-2][j-1].getPieces().s.substring(0,2).equals("wN")) pos = false;		
		}
		else if (i-2 >= 0&& j+1 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i-2][j+1] && Board.x[i-2][j+1].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i-2][j+1] && Board.x[i-2][j+1].getPieces().s.substring(0,2).equals("wN")) pos = false;			
		}
		else if (i-1 >=0  && j+2 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i-1][j+2] && Board.x[i-1][j+2].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i-1][j+2] && Board.x[i-1][j+2].getPieces().s.substring(0,2).equals("wN")) pos = false;			
		}
		else if (i+1 < 8 && j+2 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i+1][j+2] && Board.x[i+1][j+2].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i+1][j+2]&& Board.x[i+1][j+2].getPieces().s.substring(0,2).equals("wN")) pos = false;			
		}
		else if (i+2 < 8 && j+1 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i+2][j+1] && Board.x[i+2][j+1].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i+2][j+1] && Board.x[i+2][j+1].getPieces().s.substring(0,2).equals("wN")) pos = false;			
		}
		else if (i+2 < 8 && j-1 >= 0) {
			if (Board.colorMove && Board.isPieceBoard[i+2][j-1] && Board.x[i+2][j-1].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i+2][j-1] && Board.x[i+2][j-1].getPieces().s.substring(0,2).equals("wN"))pos = false;			
		}
		else if (i+1 < 8 && j-2 >= 0) {
			if (Board.colorMove && Board.isPieceBoard[i+1][j-2] && Board.x[i+1][j-2].getPieces().s.substring(0,2).equals("bN")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i+1][j-2] && Board.x[i+1][j-2].getPieces().s.substring(0,2).equals("wN")) pos = false;			
		}

///////// Rook Queen 
		for (int c = i; c >= 0; c--) {
			if (Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("bR")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("bQ")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[c][j]) break;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("wR")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("wQ")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] ) break;
		}
		for (int c = i; c < 8; c++) {
			if (Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("bR")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("bQ")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[c][j]) break;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("wR")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("wQ")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] ) break;
		}
		for (int c = j; c >= 0; c--) {
			if (Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("bR")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("bQ")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[i][c] ) break;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("wR")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("wQ")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] ) break;
		
		}
		for (int c = j; c < 8; c++) {
			if (Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("bR")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("bQ")) pos = false;
			else if (Board.colorMove && Board.isPieceBoard[i][c] ) break;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("wR")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("wQ")) pos = false;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] ) break;
		
		}

/////////Bishop Queen 
		
	
		for (int c=i-1; c>=0; c--) { //top left quadrant
			for (int d=j-1; d>=0; d--) {
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bB")) pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bQ")) pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wB")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wQ")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
			}
		}
		
		for (int c=i-1; c>=0; c--) { //top right quadrant
			for (int d=j+1; d<8; d++) {
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bB")) pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bQ")) pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wB")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wQ")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
			}
		}
		
		for (int c=i+1; c < 8; c++) { //bottom left quadrant
			for (int d=j-1; d>= 0; d--) {
				//System.out.println(pos+": row: "+c+ " column: " + d); 
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bB")) pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bQ"))  pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wB")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wQ")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
			}
		}
	
		
		for (int c=i+1; c < 8; c++) { //bottom right quadrant
			for (int d=j+1; d<8; d++) {
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bB")) pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bQ")) pos = false;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wB")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wQ")) pos = false;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
			}
		}
	
		

		//KING
		if (i-1 >=0 && j-1 >=0 ) {   //top left
			if (Board.colorMove && Board.isPieceBoard[i-1][j-1] && Board.x[i-1][j-1].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i-1][j-1] && Board.x[i-1][j-1].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}	
		if (i-1 >=0 ) { //top middle
			if (Board.colorMove && Board.isPieceBoard[i-1][j] && Board.x[i-1][j].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i-1][j] && Board.x[i-1][j].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}
		if (i-1  >=0  && j+1 < 8) { //top right
			if (Board.colorMove && Board.isPieceBoard[i-1][j+1] && Board.x[i-1][j+1].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i-1][j+1] && Board.x[i-1][j+1].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}
		if ( j+1< 8) { //right middle
			if (Board.colorMove && Board.isPieceBoard[i][j+1] && Board.x[i][j+1].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i][j+1] && Board.x[i][j+1].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}
		if (i+1< 8 && j+1< 8) { //bottom right   
			if (Board.colorMove && Board.isPieceBoard[i+1][j+1] && Board.x[i+1][j+1].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i+1][j+1] && Board.x[i+1][j+1].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}
		if (i+1 < 8 ) { //bottom middle
			if (Board.colorMove && Board.isPieceBoard[i+1][j] && Board.x[i+1][j].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i+1][j] && Board.x[i+1][j].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}
		if (i+1 < 8 && j-1  >=0 ) { //bottom left
			if (Board.colorMove && Board.isPieceBoard[i+1][j-1] && Board.x[i+1][j-1].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i+1][j-1] && Board.x[i+1][j-1].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}
		if (j-1 >=0 ) { //left middle
			if (Board.colorMove && Board.isPieceBoard[i][j-1] && Board.x[i][j-1].getPieces().s.substring(0,2).equals("bK")) pos = false;
			if (!Board.colorMove && Board.isPieceBoard[i][j-1] && Board.x[i][j-1].getPieces().s.substring(0,2).equals("wK")) pos = false;			
	
		}

		return pos;
	}
	
}
