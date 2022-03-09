package chess;

public class Rook extends Pieces {
	
	//can move up and down (check pieces in the same row and column)
	public int move ;
	
	
	public Rook() {
		
	}
	
	public Rook(String st) {
		s = st;
	}
	
	public void movePiece(Pieces p, int i, int j, int i1, int j1) {
		boolean cont = true;

		if (j==j1){ //same column good to go
			if (i < i1)
				for (int c = i+1; c < i1; c++) {
					if (Board.isPieceBoard[c][j1]) {cont = false; p.illegalMove(); break;}
				}
			else if (i > i1)
				for (int c = i-1; c > i1; c--) {
					if (Board.isPieceBoard[c][j1]) {cont = false; p.illegalMove(); break; }
				}
			
			if (cont) {checkmate(i1,j1); p.move(p, i, j, i1, j1);  }
		
		}
		else if (i==i1) { //same row good to go
			if (j < j1)
				for (int c = j+1; c < j1; c++) {
					if (Board.isPieceBoard[i][c]) {cont = false; p.illegalMove(); break; }
				}
			else if (j > j1)
				for (int c = j-1; c > j1; c--) {
					if (Board.isPieceBoard[i][c]) {cont = false; p.illegalMove(); break; }
				}
			
	
			if (cont) { checkmate(i1,j1); p.move(p, i, j, i1, j1); } 
			
		}
		else {
			p.illegalMove();
		}
	}
	
	public void checkmate(int i, int j) {
		
		for (int c = i; c >= 0; c--) {
			if (Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[c][j]) break;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] ) break;
		}
		for (int c = i; c < 8; c++) {
			if (Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[c][j] ) break;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] && Board.x[c][j].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[c][j] ) break;
		}
		for (int c = j; c >= 0; c--) {
			if (Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[i][c] ) break;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] ) break;
		
		}
		for (int c = j; c < 8; c++) {
			if (Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[i][c] ) break;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] && Board.x[i][c].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[i][c] ) break;
		
		}
		

	}
}
