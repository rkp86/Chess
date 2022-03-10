package chess;

import java.util.Scanner;

//import java.util.Scanner;

//import java.util.Scanner;

public class Chess {
	
	static boolean resign = false; 

	public static void main(String[] args) {
		Board newBoard = new Board();
		Board.printBoard();
		
		//printBoard(newBoard);
		playersMove();
	}
	
	
	
	
	public static void playersMove() {
		Scanner in = new Scanner(System.in);
		String x = "";
		if (Board.colorMove) { //1=true
			System.out.println("White's move: "); //later, we have to print white's move and black's move (FIRST=White)
		}else {
			System.out.println("Black's move:"); 
		}
		if(in.hasNext() == false) {
			System.out.println("terminated");
			System.exit(0);
		} else {
			while (in.hasNext() != false ) {
				x = in.nextLine();
				break;
			}
			
			if (x.equals("resign")) {
				if (Board.colorMove) System.out.println("Black wins");
				else System.out.println("White wins");
				resign =true;
			}
			else if (resign != true){
				//newBoard.isPiece(i, j);
				//System.out.println(x.length());
				String piece ="";
				String move = "";
				String extra = ""; 
				if (x.length() >= 5) {			
					piece = x.substring(0,2);
					move = x.substring(3,5);
					if (x.length() > 5) { 
						extra = x.substring(5).trim();
						if (extra.equals("N") || extra.equals("R") || extra.equals("B") || extra.equals("Q")) { Pieces.promote = true; Pieces.promotion = extra; }
						if (extra.equals("draw")) 
							System.out.println("draw");
						else				
							Board.getTile(piece,move);
					}
					else				
						Board.getTile(piece,move);
					
				} else {
					System.out.println("Illegal input, try again");
					nextCall(false);
				}
			}
		}
		
		
		in.close();
	//	colorMove = !colorMove;
	//	playersMove(newBoard);
	
	}
	
	public static void nextCall(boolean next) {
		Pieces.promote = false;
		Pieces.promotion = "";
		if (next) {
			Board.printBoard();
			Board.colorMove = !Board.colorMove;
			Pieces.checkmate = false;
			playersMove();
		}
		else playersMove();
			
	}
	
}
