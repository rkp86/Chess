package chess;

public class Bishop extends Pieces{

	//can move diagonally (should check every spot in the diagonal before being allowed to move the piece)
	//basically next letter plus one (a6 <-- b5 <-- c4 <-- d3 <-- e2 <-- f1 --> g2 --> h3)
	
	public int move ;
	
	public Bishop() {
		// TODO Auto-generated constructor stub
	}
	
	public Bishop( String st) {
		s=st;
	}

	public void movePiece(Pieces p, int i, int j, int i1, int j1) { //think of bishops moving in quadrants
		boolean cont = true;
		int c = i; 
		int d = j;
		
		if (i1 < i && j1 < j) { //top left quadrant (i & j decreasing)
			c--; d--;
			while (c > i1 && d >j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove(); break; }
				c--;
				d--;
			}
			
			if (cont) { checkmate(i1,j1); p.move(p, i, j, i1, j1);  }
		}
		else if (i1 < i && j1 > j) { //top right quadrant (i decreasing & j increasing)
			c--; d++;
			while (c > i1 && d < j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove(); break; }
				c--;
				d++;
			}
		
			if (cont){ checkmate(i1,j1); p.move(p, i, j, i1, j1);  }
		}
		else if (i1 > i && j1 < j) { //bottom left quadrant (i increasing & j decreasing)
			c++; d--;
			while (c < i1 && d > j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove();	break; }	
				c++;
				d--;
			}
			
			if (cont) { checkmate(i1,j1); p.move(p, i, j, i1, j1);  }
		}
		else if (i1 > i && j1 > j) { //bottom right quadrant (i increasing & j increasing)
			c++; d++;
			while (c < i1 && d < j1) {
				if(Board.isPieceBoard[c][d]) { cont=false; p.illegalMove(); break; }
				c++;
				d++;
			}
			
			if (cont){ checkmate(i1,j1); p.move(p, i, j, i1, j1);  }
		}
		else {
			p.illegalMove();
		}
	}
	
	public void checkmate(int i, int j) {
		int c = i-1;
		int d = j-1;
		
		while (c >=0 && d >= 0) {  //top left quadrant
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
				else if (Board.colorMove && Board.isPieceBoard[c][d]) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
				c--;
				d--;
		}
		
		c = i-1;
		d = j+1;
		
		while (c >=0 && d < 8) { //top right quadrant
				if (Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
				else if (Board.colorMove && Board.isPieceBoard[c][d] ) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
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
				else if (Board.colorMove && Board.isPieceBoard[c][d] ) break;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] && Board.x[c][d].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;
				else if (!Board.colorMove && Board.isPieceBoard[c][d] ) break;
				c++;
				d++;
		}
		
		
	}
}
