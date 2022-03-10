package chess;

//import java.util.ArrayList;

public class Board {
	
	Pieces piece;
	
	Rook W_rook1 = new Rook("wR ");       Rook B_rook1 = new Rook("bR ");
	Rook W_rook8 = new Rook("wR ");       Rook B_rook8 = new Rook( "bR ");

	Knight W_knight2 = new Knight("wN ");   Knight B_knight2  = new Knight("bN ");
	Bishop W_bishop3 = new Bishop("wB ");   Bishop B_bishop3 = new Bishop( "bB ");
	Knight W_knight7 = new Knight("wN ");   Knight B_knight7  = new Knight( "bN ");
	Bishop W_bishop6 = new Bishop( "wB ");   Bishop B_bishop6 = new Bishop( "bB ");
	King W_king = new King("wK ");        King B_king = new King("bK ");
	Queen W_queen = new Queen("wQ ");     Queen B_queen = new Queen("bQ ");
	Pawn W_pawn1 = new Pawn("wp ");       Pawn B_pawn1 = new Pawn("bp ");
	Pawn W_pawn2 = new Pawn("wp ");       Pawn B_pawn2 = new Pawn("bp ");
	Pawn W_pawn3 = new Pawn("wp ");       Pawn B_pawn3 = new Pawn("bp ");
	Pawn W_pawn4 = new Pawn("wp ");       Pawn B_pawn4 = new Pawn("bp ");
	Pawn W_pawn5 = new Pawn("wp ");       Pawn B_pawn5 = new Pawn("bp ");
	Pawn W_pawn6 = new Pawn("wp ");       Pawn B_pawn6 = new Pawn("bp ");
	Pawn W_pawn7 = new Pawn("wp ");       Pawn B_pawn7 = new Pawn("bp ");
	Pawn W_pawn8 = new Pawn("wp ");       Pawn B_pawn8 = new Pawn("bp ");
	
	
	static String[][] boardPrintFormat = new String[8][8];
	static Boolean[][] isPieceBoard = new Boolean[8][8];
	static Tile[][] x = new Tile[8][8];
	
	public static boolean colorMove = true;
	
	public Board() {
		/*|R_|K_|B_|Q_|KG|B_|K_|R_|8
		 *|P_|P_|P_|P_|P_|P_|P_|P_|7
		 *|__|__|__|__|__|__|__|__|6
		 *|__|__|__|__|__|__|__|__|5
		 *|__|__|__|__|__|__|__|__|4
		 *|__|__|__|__|__|__|__|__|3
		 *|P_|P_|P_|P_|P_|P_|P_|P_|2
		 *|R_|K_|B_|Q_|KG|B_|K_|R_|1
		 *  a  b  c  d  e  f  g  h
		 */
		//Setting Pieces ::
		x[0][0] = new Tile(0,0,B_rook1);     x[7][0] = new Tile(7,0,W_rook1);
		x[0][1] = new Tile(0,1,B_knight2);   x[7][1] = new Tile(7,1,W_knight2);
		x[0][2] = new Tile(0,2,B_bishop3);   x[7][2] = new Tile(7,2,W_bishop3);
		x[0][3] = new Tile(0,3,B_queen);     x[7][3] = new Tile(7,3,W_queen);
		x[0][4] = new Tile(0,4,B_king);      x[7][4] = new Tile(7,4,W_king);
		x[0][5] = new Tile(0,5,B_bishop6);   x[7][5] = new Tile(7,5,W_bishop6);
		x[0][6] = new Tile(0,6,B_knight7);   x[7][6] = new Tile(7,6,W_knight7);
		x[0][7] = new Tile(0,7,B_rook8);     x[7][7] = new Tile(7,7,W_rook8);
		
		//Pawns
		x[1][0] = new Tile(0,0,B_pawn1);   x[6][0] = new Tile(7,0,W_pawn1);
		x[1][1] = new Tile(0,1,B_pawn2);   x[6][1] = new Tile(7,1,W_pawn2);
		x[1][2] = new Tile(0,2,B_pawn3);   x[6][2] = new Tile(7,2,W_pawn3);
		x[1][3] = new Tile(0,3,B_pawn4);   x[6][3] = new Tile(7,3,W_pawn4);
		x[1][4] = new Tile(0,4,B_pawn5);   x[6][4] = new Tile(7,4,W_pawn5);
		x[1][5] = new Tile(0,5,B_pawn6);   x[6][5] = new Tile(7,5,W_pawn6);
		x[1][6] = new Tile(0,6,B_pawn7);   x[6][6] = new Tile(7,6,W_pawn7);
		x[1][7] = new Tile(0,7,B_pawn8);   x[6][7] = new Tile(7,7,W_pawn8);
		
		
		
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j<8; j++) {
				if(isPiece(i,j)) {
					isPieceBoard[i][j] = true;
				}
				else {
					isPieceBoard[i][j] = false;
				}
			}
		}
		
	}
	
	
	//Prints out the board in the given format
	public static void printBoard() {
		for(int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if((i%2==1 && j%2==1) || (i%2==0 && j%2==0)) {
					if(x[i][j] != null) {
						boardPrintFormat[i][j] = x[i][j].getPieces().getS();
						System.out.print(boardPrintFormat[i][j]);
					} else {
					boardPrintFormat[i][j] = ("   ");
					System.out.print(boardPrintFormat[i][j]);
					}
				}
                else {
                	if(x[i][j] != null) {
                		boardPrintFormat[i][j] = x[i][j].getPieces().getS();
						System.out.print(boardPrintFormat[i][j]);
                	} else {
                	boardPrintFormat[i][j] = ("## ");
                	System.out.print(boardPrintFormat[i][j]);
                	}
                }
                    
			}
			System.out.print(8-i);
			System.out.println();
			if(i == 7) {
				System.out.println(" a  b  c  d  e  f  g  h");
			}
		}
	}
	
	public Pieces getPiece(int i, int j) {
		return null;
	}

	public static boolean isPiece(int i, int j) {
		if(x[i][j] != null ) {
			return true;
		}
		return false;
	}
	

	
	public static void getTile(String piece, String move) {
		//System.out.println(piece + " " + move);
		char letter = piece.charAt(0); //CHANGE TO STRING SUBSTRING???
		char number = piece.charAt(1); 
		int i = -1, j = -1;
		
		switch (letter) {
		case 'a' : j = 0; break;
		case 'b' : j = 1; break;
		case 'c' : j = 2; break;
		case 'd' : j = 3; break;
		case 'e' : j = 4; break;
		case 'f' : j = 5; break;
		case 'g' : j = 6; break;
		case 'h' : j = 7; break;
		}
		
		switch (number) {
		case '8' : i = 0; break;
		case '7' : i = 1; break;
		case '6' : i = 2; break;
		case '5' : i = 3; break;
		case '4' : i = 4; break;
		case '3' : i = 5; break;
		case '2' : i = 6; break;
		case '1' : i = 7; break;
		}
		
		Pieces p = null;
		if (isPiece(i, j)) {
			 p = x[i][j].getPieces();
			 
			 String check = p.s.substring(0,1);
			// System.out.println(check);
			 if (colorMove == true && check.equals("b")) p.illegalMove();
			 if (colorMove == false && check.equals("w")) p.illegalMove();
			 
		}
		
		int i1 = -1, j1 =-1;
		
		char letter1 = move.charAt(0);
		char number1 = move.charAt(1);  
		
		switch (letter1) {
		case 'a' : j1 = 0; break;
		case 'b' : j1 = 1; break;
		case 'c' : j1 = 2; break;
		case 'd' : j1 = 3; break;
		case 'e' : j1 = 4; break;
		case 'f' : j1 = 5; break;
		case 'g' : j1 = 6; break;
		case 'h' : j1 = 7; break;
		}
		
		switch (number1) {
		case '8' : i1 = 0; break;
		case '7' : i1 = 1; break;
		case '6' : i1 = 2; break;
		case '5' : i1 = 3; break;
		case '4' : i1 = 4; break;
		case '3' : i1 = 5; break;
		case '2' : i1 = 6; break;
		case '1' : i1 = 7; break;
		}
		//System.out.println(letter + " " + number + " " + letter1 + " " + number1);
		//System.out.println(i + " " + j + " " + i1 + " " + j1);
		if (p instanceof Pawn) {
			//System.out.println("instance");
			p.movePiece(p, i, j, i1, j1);
		}
		if (p instanceof Rook) {
			p.movePiece(p, i, j, i1, j1);
		}
		if (p instanceof Knight) {
			p.movePiece(p, i, j, i1, j1);
		}
		if (p instanceof Bishop) {
			p.movePiece(p, i, j, i1, j1);
		}		
		if (p instanceof King) {
			p.movePiece(p, i, j, i1, j1);
		}	
		if (p instanceof Queen) {
			p.movePiece(p, i, j, i1, j1);
		}
	}
}
