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
	//main function of the class TicTacToeGame
	public static void main(String[] args) {
		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		newGame();	
		inputLetter();
	}
}