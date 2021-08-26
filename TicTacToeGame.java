import java.util.Scanner;

public class TicTacToeGame {

	//To get input from the console
	public static Scanner sc=new Scanner(System.in);
	
	//@array to store board values
	public static char[] board= new char[10];  
	
	//@parameter input store whether the value is X or O
	public static char input_player,input_computer;     
	
	/*method for initializing the board
	 * It will initialize the board values with space
	 * Use case 1 :create a new board game and initialize the values to ' '
	 */
	public static void  newGame()     
	{
		 
		for(int i=1;i<board.length;i++)     //iterate through board array
		{
			board[i]=' ';
		}
	}
	
	/*@method to get input value X or O from the player
	 *then computer automatically gets other value 
	 * use case 2
	 */
	public static void inputLetter()
	{
		
			System.out.println("Enter the input(X or O) ");
			input_player=sc.next().charAt(0);
			if(input_player=='X'||input_player=='x')
				{
				input_computer='O';
				input_player='X';
				}
			else
				{
				input_computer='X';
				input_player='O';
				}
		
	}
	
	/*@method to display the contents of board in table format
	 * use case 3
	 */
	public static void showBoard()
	{
		System.out.println("|---|---|---|");
        System.out.println("| " + board[1] + " | "
                           + board[2] + " | " + board[3]
                           + " |");							//display first row
        System.out.println("|-----------|");
        System.out.println("| " + board[4] + " | "
                           + board[5] + " | " + board[6]
                           + " |");							//display second row
        System.out.println("|-----------|");
        System.out.println("| " + board[7] + " | "
                           + board[8] + " | " + board[9]
                           + " |");							//display third row
        System.out.println("|---|---|---|");
	}
	//main function of the class TicTacToeGame
	public static void main(String[] args) {
		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		newGame();	
		inputLetter();
		showBoard();
	}
}