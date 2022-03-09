package chess;

public class Queen extends Pieces {
	
	//can move up down diagonally anywhere as long as there is no piece in the way
	public int move ;
	
	public Queen() {
		
	}
	
	public Queen(String st) {
		s = st;
	}
	
	public void movePiece(Pieces p, int i, int j, int i1, int j1) {
		boolean cont = true;
		int c = i;
		int d = j;
		if (j==j1){ //same column good to go
			if (i < i1)
				for (int c1 = i+1; c1 < i1; c1++) {
					if (Board.isPieceBoard[c1][j1]) {cont = false; p.illegalMove(); break;}
				}
			else if (i > i1)
				for (int c2 = i-1; c2 > i1; c2--) {
					if (Board.isPieceBoard[c2][j1]) {cont = false; p.illegalMove(); break; }
				}
			if (cont) {checkmate(i1,j1); p.move(p, i, j, i1, j1); }
		
		}
		else if (i==i1) { //same row good to go
			if (j < j1)
				for (int c1 = j+1; c1 < j1; c1++) {
					if (Board.isPieceBoard[i][c1]) {cont = false; p.illegalMove(); break; }
				}
			else if (j > j1)
				for (int c2 = j-1; c2 > j1; c2--) {
					if (Board.isPieceBoard[i][c2]) {cont = false; p.illegalMove(); break; }
				}
			
	
			if (cont) { checkmate(i1,j1); p.move(p, i, j, i1, j1); }
			
		}
		else if (i1 < i && j1 < j) { //top left quadrant (i & j decreasing)
			c--; d--;
			while (c > i1 && d >j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove(); break; }
				c--;
				d--;
			}
			
			if (cont) {checkmate(i1,j1); p.move(p, i, j, i1, j1); }
		}
		else if (i1 < i && j1 > j) { //top right quadrant (i decreasing & j increasing)
			c--; d++;
			while (c > i1 && d < j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove(); break; }
				c--;
				d++;
			}
		
			if (cont) {checkmate(i1,j1); p.move(p, i, j, i1, j1); }
		}
		else if (i1 > i && j1 < j) { //bottom left quadrant (i increasing & j decreasing)
			c++; d--;
			while (c < i1 && d > j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove();	break; }	
				c++;
				d--;
			}
			
			if (cont){checkmate(i1,j1); p.move(p, i, j, i1, j1); }
		}
		else if (i1 > i && j1 > j) { //bottom right quadrant (i increasing & j increasing)
			c++; d++;
			while (c < i1 && d < j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove(); break; }
				c++;
				d++;
			}
			
			if (cont) {checkmate(i1,j1); p.move(p, i, j, i1, j1); }
		}
		else {
			p.illegalMove();
		}
	}
	
	
	public void checkmate(int i, int j) {
		int c = i-1;
		int d = j-1;
		
		for (int c1 = i; c1 >= 0; c1--) {
			if (Board.colorMove && Board.isPieceBoard[c1][j] && Board.x[c1][j].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[c1][j]) break;
			else if (!Board.colorMove && Board.isPieceBoard[c1][j] && Board.x[c1][j].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[c1][j] ) break;
		}
		for (int c1 = i; c1 < 8; c1++) {
			if (Board.colorMove && Board.isPieceBoard[c1][j] && Board.x[c1][j].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[c1][j]) break;
			else if (!Board.colorMove && Board.isPieceBoard[c1][j] && Board.x[c1][j].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[c1][j]) break;
		}
		for (int c1 = j; c1 >= 0; c1--) {
			if (Board.colorMove && Board.isPieceBoard[i][c1] && Board.x[i][c1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[i][c1]) break;
			else if (!Board.colorMove && Board.isPieceBoard[i][c1] && Board.x[i][c1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[i][c1]) break;
		
		}
		for (int c1 = j; c1 < 8; c1++) {
			if (Board.colorMove && Board.isPieceBoard[i][c1] && Board.x[i][c1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			else if (Board.colorMove && Board.isPieceBoard[i][c1] ) break;
			else if (!Board.colorMove && Board.isPieceBoard[i][c1]&& Board.x[i][c1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
			else if (!Board.colorMove && Board.isPieceBoard[i][c1] ) break;
		
		}
		
		while (c >=0 && d >= 0) {  //top left quadrant
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
				else if (!Board.colorMove && Board.isPieceBoard[c][d]) break;
				c--;
				d--;
		}
		
		c = i-1;
		d = j+1;
		
		while (c >=0 && d < 8) { //top right quadrant
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
				else if (!Board.colorMove && Board.isPieceBoard[c][d]) break;
				c--;
				d++;
		}
		
		c = i+1;
		d = j-1;
		
		while (c < 8 && d >= 0) { //bottom left quadrant
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
				else if (Board.colorMove && Board.isPieceBoard[c][d] ) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
				c++;
				d--;
		}
		
		c = i+1;
		d = j+1;
		
		while (c < 8 && d < 8) { //bottom right quadrant
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
				c++;
				d++;
		}
		
		
	}
}
