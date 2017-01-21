package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class GameBoard {
	private char[][] gameBoard;
	private boolean gameOngoing = true;
	private Scanner keyboard;
	
	/**
	 * This is the constructor for the GameBoard class
	 */
	
	public GameBoard(){
		
		gameBoard = new char[3][3];
		
		for (int row=0; row < gameBoard.length; row++){
			Arrays.fill(gameBoard[row], ' ');
		}
	}	// end of constructor
	
	/**
	 * This method will display the gameBoard to the screen
	 */
	
	public void displayBoard(){
		for (int row=0; row < gameBoard.length; row++){
			for (int col=0; col < gameBoard[0].length; col++){
				System.out.print("\t"+gameBoard[row][col]);
				if (col == 0 || col == 1)
					System.out.print("|");
			}
			if (row == 0 || row == 1)
			System.out.print("\n----------------------------\n");
		}
		System.out.println();
	} // end of method displayboard
	
	/**
	 * This method will return true if the game is still active
	 */
	public boolean gameActive(){
		return gameOngoing;
	}
	
	/**
	 * This method will ask the user to pick a row and column,
	 * validate the inputs and call the method makeMove()
	 */
	public void askPlayer(char player){
		keyboard = new Scanner(System.in);
		int row, col;
		do{
			System.out.printf("Player %s, Please enter a row (1-3): ", player);
			row = keyboard.nextInt();
			
			System.out.printf("Player %s, Please enter a column (1-3): ", player);
			col = keyboard.nextInt();
			
		} while (notValid(row,col));
		
		makeMove(player,row-1,col-1);
		
	} //end of askPlayer method

	/**
	 * This method will check to see if there are 3 X's or O's in a row
	 * and return true if there is a winner, false otherwise
	 */
	public boolean checkForWinner(){
		//loop over each row and check for a winner
		for (int row=0; row < gameBoard.length; row++){
			if (gameBoard[row][0] == gameBoard[row][1] && gameBoard[row][1] == gameBoard[row][2]
					&& gameBoard[row][0] != ' '){
					System.out.print("\nTHE WINNER IS: " + gameBoard[row][0]);
					gameOngoing = false;
			}
		}

		//loop over each column and check for a winner
		for (int col=0; col < gameBoard.length; col++){
			if (gameBoard[0][col] == gameBoard[1][col] && gameBoard[1][col] == gameBoard[2][col]
					&& gameBoard[0][col] != ' '){
				System.out.print("\nTHE WINNER IS: " + gameBoard[0][col]);
				gameOngoing = false;				
			}
		}

		//check the diagonals and check for a winner
			if (gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2]
					&& gameBoard[0][0] != ' '){
				System.out.print("\nTHE WINNER IS: " + gameBoard[0][0]);
				gameOngoing = false;
			}
			
			if (gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[0][2]
					&& gameBoard[2][0] != ' '){
				System.out.print("\nTHE WINNER IS: " + gameBoard[2][0]);
				gameOngoing = false;
			}		
		return false;
	}
	
	
	/**
	 * This method will check if a position is empty
	 * and return true if the position is empty, false otherwise
	 */
	public boolean isEmpty(int row, int col){
		if (gameBoard[row-1][col-1] == ' ')
			return true;
		else{
			System.out.print("\nThat position is already taken. TRY AGAIN.\n");
			return false;
		}
	} // end of isEmpty method
	
	/** 
	 * This method will validate if the row and column are
	 * between 1-3, and if the position is currently empty
	 */
	public boolean notValid(int row, int col){
		if (row > 3 || row < 1 || col > 3 || col < 1){
			System.out.print("\nInvalid entry. TRY AGAIN.\n");
			return true;
		}
		if (!isEmpty(row,col))
			return true;
		return false;
	} // end of notValid method
	
	
	/**
	 * This method will validate if a players move is allowed
	 * and return true if the move was completed
	 */
	
	public boolean makeMove(char player, int row, int col){
		if (row >=0 && row <=2 && col >=0 && col <=2){
			if (gameBoard[row][col] != ' ')
				return false;
			else {
				gameBoard[row][col] = player;
				return true;
			}
		}
		else
			return false;
	} // end of makeMove method
	
}
