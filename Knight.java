package chess;

public class Knight extends Pieces {
	
	//can move up 2 and right or left one 
	
	public int move; 

	
	public Knight() {
		// TODO Auto-generated constructor stub
	}
	
	public Knight(String st) {
		s = st;
	}

	public void movePiece(Pieces p, int i, int j, int i1, int j1) {
		//boolean cont; 
		
		if (i-1 == i1 && j-2 == j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else if (i-2 == i1 && j-1 == j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else if (i-2 == i1 && j+1 == j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else if (i-1 == i1 && j+2 ==j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else if (i+1==i1 && j+2==j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else if (i+2 ==i1 && j+1 == j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else if (i+2 == i1 && j-1 ==j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else if (i+1 ==i1 && j-2 ==j1) {
			checkmate(i1,j1);
			p.move(p, i, j, i1, j1);
		}
		else {
			p.illegalMove();
		}
	}	
	
	public void checkmate(int i, int j) {
		if (i-1 >= 0 && j-2 >= 0 ) {
			if (Board.colorMove && Board.isPieceBoard[i-1][j-2] && Board.x[i-1][j-2].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i-1][j-2] && Board.x[i-1][j-2].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
		else if (i-2 >= 0 && j-1 >= 0 ) {
			if (Board.colorMove && Board.isPieceBoard[i-2][j-1] && Board.x[i-2][j-1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i-2][j-1] && Board.x[i-2][j-1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
		else if (i-2 >= 0&& j+1 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i-2][j+1] && Board.x[i-2][j+1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i-2][j+1] && Board.x[i-2][j+1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
		else if (i-1 >=0  && j+2 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i-1][j+2] && Board.x[i-1][j+2].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i-1][j+2] && Board.x[i-1][j+2].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
		else if (i+1 < 8 && j+2 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i+1][j+2] && Board.x[i+1][j+2].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i+1][j+2]&& Board.x[i+1][j+2].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
		else if (i+2 < 8 && j+1 < 8) {
			if (Board.colorMove && Board.isPieceBoard[i+2][j+1] && Board.x[i+2][j+1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i+2][j+1] && Board.x[i+2][j+1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
		else if (i+2 < 8 && j-1 >= 0) {
			if (Board.colorMove && Board.isPieceBoard[i+2][j-1] && Board.x[i+2][j-1].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i+2][j-1] && Board.x[i+2][j-1].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
		else if (i+1 < 8 && j-2 >= 0) {
			if (Board.colorMove && Board.isPieceBoard[i+1][j-2] && Board.x[i+1][j-2].getPieces().s.substring(0,2).equals("bK")) Pieces.checkmate = true;
			if (!Board.colorMove && Board.isPieceBoard[i+1][j-2] && Board.x[i+1][j-2].getPieces().s.substring(0,2).equals("wK")) Pieces.checkmate = true;			
		}
	}
}
