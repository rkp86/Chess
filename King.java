package chess;

public class King extends Pieces {
	
	//can move in any direction
	
	public int move;
	public boolean castle;
	public boolean hasCastled;
	
	public King() {
		castle = true;
	}
	
	public King( String st) {
		s = st;
		this.castle = true;
	}
	
	public void movePiece(Pieces p, int i, int j, int i1, int j1) {
		boolean cont = true;
		if (Board.colorMove==true) {
			if (whiteCheckCheckmate(i1,j1)) {
				cont = false;
			}	
		}
		if (Board.colorMove==false) {
			if(blackCheckCheckmate(i1,j1)) {
				cont=false;
			}
		}
	
		if (cont) {
			if (i-1 == i1 && j-1 == j1) {   //top left
				p.move(p, i, j, i1, j1);
				castle = false;
			}	
			else if (i-1 == i1 && j == j1) { //top middle
				p.move(p, i, j, i1, j1);
				castle = false;
			}
			else if (i-1 == i1 && j+1 == j1) { //top right
				p.move(p, i, j, i1, j1);
				castle = false;
			}
			else if (i == i1 && j+1 ==j1) { //right middle
				p.move(p, i, j, i1, j1);
				castle = false;
			}
			else if (i+1==i1 && j+1==j1) { //bottom right
				p.move(p, i, j, i1, j1);
				castle = false;
			}
			else if (i+1 ==i1 && j == j1) { //bottom middle
				p.move(p, i, j, i1, j1);
				castle = false;
			}
			else if (i+1 == i1 && j-1 ==j1) { //bottom left
				p.move(p, i, j, i1, j1);
				castle = false;
			}
			else if (i ==i1 && j-1 ==j1) { //left middle
				p.move(p, i, j, i1, j1);
				castle = false;
			}
			else if (i ==i1 && j-2 ==j1) {
				performCastle(p, i, j, i1, j1);
			}
			else if (i ==i1 && j+2 ==j1) {
				performCastle(p, i, j, i1, j1);
			}
		}
		else {
			p.illegalMove();
		}
	}
	
	public boolean blackCheckCheckmate(int i, int j) {
		boolean check = false;
		int i1 = i;
		int j1 = j;
		

		for (int c = j-1; c >= 0; c--) { //check to the left for rooks and queens and kings
			if (Board.isPieceBoard[i][c]) {
				if (Board.x[i][c].getPieces().s.substring(0,2).equals("wR") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("wQ") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("wK")) {
						check = true;
						break;
				}
				else if (Board.x[i][c].getPieces().s.substring(0,1).equals("b")) break;
			}
		}
		for (int c = j+1; c < 8; c++) { //check to the right for rooks and queens and kings
			if (Board.isPieceBoard[i][c]) {
				if (Board.x[i][c].getPieces().s.substring(0,2).equals("wR") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("wQ") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("wK")) {
						check = true;
						break;	
				}
				else if (Board.x[i][c].getPieces().s.substring(0,1).equals("b")) break;
			}
		}
		for (int c = i-1; c >= 0; c--) { //check the top for rooks and queens and kings
			if (Board.isPieceBoard[c][j]) {
				if (Board.x[c][j].getPieces().s.substring(0,2).equals("wR") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("wQ") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("wK")) {
						check = true;
						break;
				}
				else if (Board.x[c][j].getPieces().s.substring(0,1).equals("b")) break;
			}
		}
		for (int c = i+1; c < 8; c++) { //check the bottom for rooks and queens and kings
			if (Board.isPieceBoard[c][j]) {
				if (Board.x[c][j].getPieces().s.substring(0,2).equals("wR") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("wQ") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("wK")) {
						check = true;   
						break;
				}
				else if (Board.x[c][j].getPieces().s.substring(0,1).equals("b")) break;
			}
		}
		i1=i; j1=j;
		while (i1 < 8 && j1 < 8) {  //bottom right quadrant
			i1++;
			j1++;
			if(i1 !=8 && j1 !=8 && Board.isPieceBoard[i1][j1]) {
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wK")) {
							check = true;  System.out.println("140:" + i1 + " " + j1 + " " + check);
							break;
				}
				else if (i1 == i+1 && j1 == j+1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wp")) {
							check = true; System.out.println("145:" + i1 + " " + j1 + " " + check);
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("b")) break;
			}	
			
		}
		i1=i; j1=j;
		while (i1 < 8 && j1 >= 0) {  //bottom left quadrant
			System.out.println( i1 < 8 && j1 >= 0);
			i1++;
			j1--;
			System.out.println(i1 + " " + j1);
			if( i1 != 8 && j1 != -1 && Board.isPieceBoard[i1][j1]) {
				System.out.println("in: "+ i1 + " " + j1);
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wK")) {
						System.out.println("4: " + check );
						check = true;
						System.out.println("4: " + i1 + " " + j1 + " " + check );
						break;
				}
				else if (i1 == i+1 && j1 == j-1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wp")) {	
						check = true;
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("b")) break;
			}	
			
		}
					System.out.println("4: " + check );
			i1=i; j1=j;
		while (i1 >= 0 && j1 >= 0) {  //top left quadrant
			i1--;
			j1--;
			if(i1 != -1 && j1 !=-1 && Board.isPieceBoard[i1][j1]) {
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wK")) {
							check = true;
							break;
				}
				else if (i1 == i-1 && j1 == j-1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wp")) {
							check = true;
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("b")) break;
			}	
		
		}
		i1=i; j1=j;
		while (i1 >= 0 && j1 < 8) {  //top right quadrant
			i1--;
			j1++;
			if(i1 !=-1 && j1 != 8 && Board.isPieceBoard[i1][j1] ) {
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("wK")) {
							check = true;
							break;
				}
				else if (i1 == i-1 && j1 == j+1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("wp")) {
							check = true;
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("b")) break;
			}	
		}
					System.out.println("5: " + check );

		i1=i;
		j1=j;
		System.out.println("225:" + i1 + " " + j1 + " " + check);
		//check knights
		if (i1-1 >= 0 && j1-2 >= 0  && Board.isPieceBoard[i1-1][j1-2]) {
			if (Board.x[i1-1][j1-2].getPieces().s.substring(0,2).equals("wN")) {
				check = true;
			}
		}
		else if (i1-2 >= 0 && j1-1 >= 0  && Board.isPieceBoard[i1-2][j1-1]) {
			if (Board.x[i1-2][j1-1].getPieces().s.substring(0,2).equals("wN")) 
				check = true;
		}
		else if (i1-2 >0 && j1+1 < 8  && Board.isPieceBoard[i1-2][j1+1]) {
			if (Board.x[i1-2][j1+1].getPieces().s.substring(0,2).equals("wN")) 
				check = true;
		}
		else if (i1-1 > 0 && j1+2 < 8  && Board.isPieceBoard[i1-1][j1+2]) {
			if (Board.x[i1-1][j1+2].getPieces().s.substring(0,2).equals("wN")) 
				check = true;
		}
		else if (i1+1 < 8 && j1+2 < 8  && Board.isPieceBoard[i1+1][j1+2]) {
			if (Board.x[i1+1][j1+2].getPieces().s.substring(0,2).equals("wN")) 
				check = true;
		}
		else if (i1+2 < 8 && j1+1 < 8  && Board.isPieceBoard[i1+2][j1+1]) {
			if (Board.x[i1+2][j1+1].getPieces().s.substring(0,2).equals("wN")) { 
				System.out.println(Board.colorMove + "15");
				check = true;
			}
		}
		else if (i1+2 < 8 && j1-1 >= 0  && Board.isPieceBoard[i1+2][j1-1]) {
			if (Board.x[i1+2][j1-1].getPieces().s.substring(0,2).equals("wN")) 
				check = true;
		}
		else if (i1+1 < 8 && j1-2 >=0  && Board.isPieceBoard[i1+1][j1-2]) {
			if (Board.x[i1+1][j1-2].getPieces().s.substring(0,2).equals("wN")) 
				check = true;
		}
		
		System.out.println("check: " + check);
		return check;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean whiteCheckCheckmate(int i, int j) {
		boolean check = false;
		int i1 = i;
		int j1 = j;
		System.out.println("273:" + i1 + " " + j1 + " " + check);
		for (int c = j-1; c >= 0; c--) { //check to the left for rooks and queens and kings
			if (Board.isPieceBoard[i][c]) {
				if (Board.x[i][c].getPieces().s.substring(0,2).equals("bR") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("bQ") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("bK")) {
						check = true;
						System.out.println("280:" + i1 + " " + j1 + " " + check);
						break;
				}
				else if (Board.x[i][c].getPieces().s.substring(0,1).equals("w")) break;
			}
		}
		for (int c = j+1; c < 8; c++) { //check to the right for rooks and queens and kings					
			if (Board.isPieceBoard[i][c]) {
				if (Board.x[i][c].getPieces().s.substring(0,2).equals("bR") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("bQ") ||
					Board.x[i][c].getPieces().s.substring(0,2).equals("bK")) {
					System.out.println("291:" +i1 + " " + j1 + " " + check);
						check = true;
						break;	
				}
				else if (Board.x[i][c].getPieces().s.substring(0,1).equals("w")) break;
			}
		}
		for (int c = i-1; c >= 0; c--) { //check the top for rooks and queens and kings
			if (Board.isPieceBoard[c][j]) {
				if (Board.x[c][j].getPieces().s.substring(0,2).equals("bR") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("bQ") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("bK")) {
					System.out.println("303:"+ i1 + " " + j1 + " " + check);
						check = true;
						break;
				}
				else if (Board.x[c][j].getPieces().s.substring(0,1).equals("w")) break;
			}
		}
		for (int c = i+1; c < 8; c++) { //check the bottom for rooks and queens and kings
			if (Board.isPieceBoard[c][j]) {
				if (Board.x[c][j].getPieces().s.substring(0,2).equals("bR") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("bQ") ||
					Board.x[c][j].getPieces().s.substring(0,2).equals("bK")) {
					System.out.println("315:" +i1 + " " + j1 + " " + check);
						check = true;
						break;
				}
				else if (Board.x[c][j].getPieces().s.substring(0,1).equals("w")) break;
			}
		}
		i1=i; j1=j;
		while (i1 < 8 && j1 < 8) {  //bottom right quadrant
			i1++;
			j1++;
			if(i1 !=8 && j1 !=8 && Board.isPieceBoard[i1][j1]) {
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bK")) {
					System.out.println("330:"+ i1 + " " + j1 + " " + check);
							check = true;
							break;
				}
				else if (i1 == i+1 && j1 == j+1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bp")) {
					System.out.println("336:"+ i1 + " " + j1 + " " + check);
							check = true;
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("w")) break;
			}	
			
		}
		i1=i; j1=j;
		while (i1 < 8 && j1 >= 0) {  //bottom left quadrant
			i1++;
			j1--;
			if( i1 != 8 && j1 != -1 && Board.isPieceBoard[i1][j1]) {
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bK")) {
					System.out.println("353:" + i1 + " " + j1 + " " + check);
							check = true;
							break;
				}
				else if (i1 == i+1 && j1 == j-1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bp")) {
					System.out.println("350:" + i1 + " " + j1 + " " + check);
							check = true;
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("w")) break;
			}	
			
		}
		i1=i; j1=j;
		while (i1 >= 0 && j1 >= 0) {  //top left quadrant
			i1--;
			j1--;
			if(i1 != -1 && j1 !=-1 && Board.isPieceBoard[i1][j1]) {
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bK")) {
					System.out.println("376:" + i1 + " " + j1 + " " + check);
							check = true;
							break;
				}
				else if (i1 == i-1 && j1 == j-1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bp")) {
					System.out.println("382:" + i1 + " " + j1 + " " + check);
							check = true;
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("w")) break;
			}	
		
		}
		i1=i; j1=j;
		while (i1 >= 0 && j1 < 8) {  //top right quadrant
			i1--;
			j1++;
			if(i1 !=-1 && j1 != 8 && Board.isPieceBoard[i1][j1] ) {
				if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bB") ||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bQ")||
					Board.x[i1][j1].getPieces().s.substring(0,2).equals("bK")) {
					System.out.println("399:" + i1 + " " + j1 + " " + check);
							check = true;
							break;
				}
				else if (i1 == i-1 && j1 == j+1) { //for the pawn check 
					if (Board.x[i1][j1].getPieces().s.substring(0,2).equals("bp")) {
					System.out.println("405:" + i1 + " " + j1 + " " + check);
							check = true;
							break;
					}
				}
				else if (Board.x[i1][j1].getPieces().s.substring(0,1).equals("w")) break;
			}	
		}
		
		//check knights
		i1=i; j1=j;
		System.out.println("final:" + i1 + " " + j1 + " " + check);

			if (i1-1 >= 0 && j1-2 >= 0  && Board.isPieceBoard[i1-1][j1-2]) {
				if (Board.x[i1-1][j1-2].getPieces().s.substring(0,2).equals("bN")) {
					check = true;

				}
			}
			else if (i1-2 >= 0 && j1-1 >= 0  && Board.isPieceBoard[i1-2][j1-1]) {
				if (Board.x[i1-2][j1-1].getPieces().s.substring(0,2).equals("bN")) 
					check = true;

			}
			else if (i1-2 >0 && j1+1 < 8  && Board.isPieceBoard[i1-2][j1+1]) {
				if (Board.x[i1-2][j1+1].getPieces().s.substring(0,2).equals("bN")) 
					check = true;
			}
			else if (i1-1 > 0 && j1+2 < 8  && Board.isPieceBoard[i1-1][j1+2]) {
				if (Board.x[i1-1][j1+2].getPieces().s.substring(0,2).equals("bN")) 
					check = true;

			}
			else if (i1+1 < 8 && j1+2 < 8  && Board.isPieceBoard[i1+1][j1+2]) {
				if (Board.x[i1+1][j1+2].getPieces().s.substring(0,2).equals("bN")) 
					check = true;

			}
			else if (i1+2 < 8 && j1+1 < 8  && Board.isPieceBoard[i1+2][j1+1]) {
				if (Board.x[i1+2][j1+1].getPieces().s.substring(0,2).equals("bN")) { 
					check = true;

				}
			}
			else if (i1+2 < 8 && j1-1 >= 0  && Board.isPieceBoard[i1+2][j1-1]) {
				if (Board.x[i1+2][j1-1].getPieces().s.substring(0,2).equals("bN")) 
					check = true;

			}
			else if (i1+1 < 8 && j1-2 >=0  && Board.isPieceBoard[i1+1][j1-2]) {
				if (Board.x[i1+1][j1-2].getPieces().s.substring(0,2).equals("bN")) 
					check = true;

			}
	
		return check;
	}
	
	public void performCastle(Pieces p, int i, int j, int i1, int j1) {
		if(p.hasMoved == false) {
			//Right castle:
			if(Board.x[i][7].getPieces().hasMoved == false) {
				//checking for piece intervention
				if( j+2 == j1) {
					for(int x = 5; x<7; x++) {
						if(Board.x[i][x] != null) {
							((King) p).castle = false;
						}
					}
					//Castle can be performed
					if(((King) p).castle == true) {
						Board.x[i1][j1] = Board.x[i][j];
						Board.x[i1][j1-1] = Board.x[i][7];
						Board.x[i][7] = null;
						Board.x[i][j] = null;
						Board.isPieceBoard[i][j] = false;
						Board.isPieceBoard[i1][j1] = true;
						Board.isPieceBoard[i1][j1-1] = true;
						Board.isPieceBoard[i][7] = false;
						Chess.nextCall(true);
					}
					else {
						p.illegalMove();
					}
				}
				
				//Left Side Castling: 
				else if( j-2 == j1) {
					for(int x = 3; x>0; x--) {
						if(Board.x[i][x] != null) {
							((King) p).castle = false;
						}
					}
					//Castle can be performed
					if(((King) p).castle == true) {	
						Board.x[i1][j1] = Board.x[i][j];
						Board.x[i1][j1+1] = Board.x[i][0];
						Board.x[i][0] = null;
						Board.x[i][j] = null;
						Board.isPieceBoard[i][j] = false;
						Board.isPieceBoard[i1][j1] = true;
						Board.isPieceBoard[i1][j1+1] = true;
						Board.isPieceBoard[i][0] = false;
						Chess.nextCall(true);
					}
					else {
						p.illegalMove();
					}
				}
			}
		
			else {
				p.illegalMove();
			}
		}
		else {
			p.illegalMove();
		}
	}
}
