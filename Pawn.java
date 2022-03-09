package chess;

public class Pawn extends Pieces {
	
	// public int count; //if 0, then can move up two blocks
	public int move = 4; //can only move up one and two on the first move
	
	
	public Pawn() {
		this.count = 0;
		
	}
	public Pawn( String st) {
		this.count = 0;
		s = st;
		
	}
	
	public int getCount() {
		return this.count;
	}
	
	public void movePiece(Pieces p, int i, int j, int i1, int j1) {
		String piece = p.s.substring(0,1);
		boolean cont = true;
		if (j==j1) { //same column good to go
		
			if (p.count == 0) { //first move
				
				if (piece.equals("w")) {
					if (i < i1 || i-2 > i1) { p.illegalMove(); cont = false; p.count++; }
				}
				else if (piece.equals("b")){
					if (i > i1 || i+2 < i1 ) { p.illegalMove(); cont = false; p.count++; }
				}
			}
			else {
				if (piece.equals("w")) {
					if (i < i1 || i-1 > i1) {p.illegalMove(); cont = false; }
				}
				else if (piece.equals("b")) {
					if (i > i1 || i+1 <i1 ) {p.illegalMove(); cont = false; }
				}
			}
		
			if (cont && !Board.isPieceBoard[i1][j1]) {
				if (Board.colorMove && i1==0) Pieces.promote = true;
				if (!Board.colorMove && i1==7) Pieces.promote = true;
				p.move(p, i, j, i1, j1);
			}
			else p.illegalMove();
		}
		else if (j1 == j+1 || j1 == j-1) {  //different columns so moving diagonally
			if (piece.equals("w")) {
				if (i1 != i -1) {p.illegalMove(); cont = false; }
			}
			else if (piece.equals("b")) {
				if (i1 != i + 1) {p.illegalMove(); cont = false; }
			}

			if (cont && Board.isPieceBoard[i1][j1]) {  //capturing a piece
				if (Board.colorMove && i1==0) Pieces.promote = true;
				if (!Board.colorMove && i1==7) Pieces.promote = true;
				checkmate(i1, j1);
				p.move(p, i, j, i1, j1);
			}
			else p.illegalMove();
		}
		else {
			p.illegalMove(); 
		}
	
	}
	
	
	public void checkmate(int i, int j) {
	  
		if (Board.colorMove) {
			if (i-1 >= 0 && j+1 < 8 && Board.isPieceBoard[i-1][j+1] && Board.x[i-1][j+1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (i-1 >= 0 && j-1 >=0 &&Board.isPieceBoard[i-1][j-1] && Board.x[i-1][j-1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
		}
		else if (!Board.colorMove) {
			if (i+1 < 8 && j+1 < 8 && Board.isPieceBoard[i+1][j+1] &&Board.x[i+1][j+1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			if (i+1 < 8 && j-1 >=0 && Board.isPieceBoard[i+1][j-1] && Board.x[i+1][j-1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
		}

	}
	
	
}
