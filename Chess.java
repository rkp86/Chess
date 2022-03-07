package chess;

//import java.util.Scanner;

//import java.util.Scanner;

public class Chess {

	public static void main(String[] args) {
		Board newBoard = new Board();
		Board.printBoard(newBoard);
		int i = 0;
		int j = 0;
		//printBoard(newBoard);
		newBoard.playersMove(1, newBoard);
	}
	
	/*public void callMove(boolean color) {
		Scanner in = new Scanner(System.in); 
		if (color == true) System.out.println("White's move: ");
		if (color == false) System.out.println("Black's move: ");
		
		String x= in.nextLine();
		
		// send x to a method that reads the moves
		in.close();

	}*/
	
}
