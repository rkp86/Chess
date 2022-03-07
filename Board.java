package chess;

import java.util.Scanner;

//import java.util.ArrayList;

public class Board {
	
	Pieces piece;
	
	Rook W_rook1 = new Rook(true, "wR ");       Rook B_rook1 = new Rook(false, "bR ");
	Rook W_rook8 = new Rook(true, "wR ");       Rook B_rook8 = new Rook(false, "bR ");

	Knight W_knight2 = new Knight(true, "wN ");   Knight B_knight2  = new Knight(false, "bN ");
	Bishop W_bishop3 = new Bishop(true, "wB ");   Bishop B_bishop3 = new Bishop(false, "bB ");
	Knight W_knight7 = new Knight(true, "wN ");   Knight B_knight7  = new Knight(false, "bN ");
	Bishop W_bishop6 = new Bishop(true, "wB ");   Bishop B_bishop6 = new Bishop(false, "bB ");
	King W_king = new King(true, "wK ");        King B_king = new King(false, "bK ");
	Queen W_queen = new Queen(true, "wQ ");     Queen B_queen = new Queen(false, "bQ ");
	Pawn W_pawn1 = new Pawn(true, "wp ");       Pawn B_pawn1 = new Pawn(false, "bp ");
	Pawn W_pawn2 = new Pawn(true, "wp ");       Pawn B_pawn2 = new Pawn(false, "bp ");
	Pawn W_pawn3 = new Pawn(true, "wp ");       Pawn B_pawn3 = new Pawn(false, "bp ");
	Pawn W_pawn4 = new Pawn(true, "wp ");       Pawn B_pawn4 = new Pawn(false, "bp ");
	Pawn W_pawn5 = new Pawn(true, "wp ");       Pawn B_pawn5 = new Pawn(false, "bp ");
	Pawn W_pawn6 = new Pawn(true, "wp ");       Pawn B_pawn6 = new Pawn(false, "bp ");
	Pawn W_pawn7 = new Pawn(true, "wp ");       Pawn B_pawn7 = new Pawn(false, "bp ");
	Pawn W_pawn8 = new Pawn(true, "wp ");       Pawn B_pawn8 = new Pawn(false, "bp ");
	
	
	static String[][] boardPrintFormat = new String[8][8];
	static Boolean[][] isPieceBoard = new Boolean[8][8];
	static Tile[][] x = new Tile[8][8];
	
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
	public static void printBoard(Board newBoard) {
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

	public boolean isPiece(int i, int j) {
		if(x[i][j] != null ) {
			return true;
		}
		return false;
	}
	
	
	public void playersMove(int color, Board newBoard) {
		Scanner in = new Scanner(System.in);
		if (color==0)  //0=false
			System.out.println("Black's move: "); 
		if (color==1)  //1=true
			System.out.println("White's move: "); //later, we have to print white's move and black's move (FIRST=White)
		
		String x = in.nextLine();
		in.close();
		
		if (x.equals("resign")) {
			if (color == 0) System.out.println("White wins");
			if (color == 1) System.out.println("Black wins");
		}
		else {
			System.out.println(x); //CHANGE THIS TO METHOD CALL that reads the moves in String x
			//newBoard.isPiece(i, j);
			System.out.println(x.length());
			String piece ="";
			String move = "";
			if (x.length() ==5) {		//THIS WILL CHANGE WHEN ACCOUNTING FOR N OR "DRAW" 		
				piece = x.substring(0,2);
				move = x.substring(3,5);
			}
			
			getTile(piece,move);
			
		}
		
		printBoard(newBoard);
	//	if (color == 0 ) playersMove(1,newBoard);
	//	if (color == 1 ) playersMove(0,newBoard);
	}
	
	
	public void getTile(String piece, String move) {
		char letter = piece.charAt(0);
		char number = piece.charAt(1); 
		int i = -1, j = -1;
		
		switch (letter) {
		case 'a' : i = 0;
		case 'b' : i = 1;
		case 'c' : i = 2;
		case 'd' : i = 3;
		case 'e' : i = 4;
		case 'f' : i = 5;
		case 'g' : i = 6;
		case 'h' : i = 7;
		}
		
		switch (number) {
		case '8' : j = 0;
		case '7' : j = 1;
		case '6' : j = 2;
		case '5' : j = 3;
		case '4' : j = 4;
		case '3' : j = 5;
		case '2' : j = 6;
		case '1' : j = 7;
		}
		
		Pieces p = x[i][j].getPieces();
		
		int i1 = -1, j1 =-1;
		
		char letter1 = move.charAt(0);
		char number1 = move.charAt(1);  
		
		switch (letter1) {
		case 'a' : i1 = 0;
		case 'b' : i1 = 1;
		case 'c' : i1 = 2;
		case 'd' : i1 = 3;
		case 'e' : i1 = 4;
		case 'f' : i1 = 5;
		case 'g' : i1 = 6;
		case 'h' : i1 = 7;
		}
		
		switch (number1) {
		case '8' : j1 = 0;
		case '7' : j1 = 1;
		case '6' : j1 = 2;
		case '5' : j1 = 3;
		case '4' : j1 = 4;
		case '3' : j1 = 5;
		case '2' : j1 = 6;
		case '1' : j1 = 7;
		}
		
		if (p instanceof Pawn) {
			p.movePiece(i1, j1);
		}
		if (p instanceof Rook) {
			p.movePiece(i1, j1);
		}
		if (p instanceof Knight) {
			p.movePiece(i1, j1);
		}
		if (p instanceof Bishop) {
			p.movePiece(i1, j1);
		}		
		if (p instanceof King) {
			p.movePiece(i1, j1);
		}	
		if (p instanceof Queen) {
			p.movePiece(i1, j1);
		}
	}
}
