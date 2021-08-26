import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	//To get input from the console
	public static Scanner sc=new Scanner(System.in);
	
	//@array to store board values
	public static char[] board= new char[10];  
	
	//to get a random value random class is used
	public static Random rand=new Random();
	
	//@parameter input store whether the value is X or O
	public static char input_player,input_computer;     
	
	//@parameter index to ask user where to mark x or o
	public static int index;
	
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
	
	/*@method selects the index from 1 to 9 
	 * stores the user input in desired location in the board
	 * check whether index is between 1 and 9
	 * UseCase 4
	 */
	public static void desiredLocation()
	{
		System.out.println("Player is playing!!");
		System.out.println("Please enter the index where you want to mark!!");
		index=sc.nextInt();
		if(index<1 || index>9)					//check if index is between 1 and 9
		{
			System.out.println("Please enter the index value between 1 and 9!!");
			desiredLocation();
		}	
	}
	
	/*@method moves to desired location
	 * checks if the space is free
	 * ability to make a move for desired location
	 * UseCase 5
	 */
	public static void desiredMove()
	{
		
		if(board[index]==' ')					//check if index is free
		{
			board[index]=input_player;
		}
		else
			{
				System.out.println("Please enter different index current one is already filled!!!");
				desiredLocation();					//@call desired location method
				desiredMove();
			}
		
	}
	/*@method does a toss to check who plays first
	 * random number is used to check for head and tail
	 * UseCase 6
	 */
	public static void toss()
	{
		System.out.println("Player do you want to choose head(0) or tail(1)!!");
		int choice=sc.nextInt();							//class member for storing choice of the player
		/* a random number is chosen between 1 or 0
		 * if its 0 then head or if it is 1 its tail
		 */
		int randnum=rand.nextInt(2);						
		if(choice==randnum)
		{
			System.out.println("Its player's turn!!!");
			turn='p';
			
			
		}
		else
		{
			System.out.println("Its computer's turn!!!");
			turn='c';
			
		}
		
	}
	//main function of the class TicTacToeGame
	public static void main(String[] args) {
		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		newGame();	
		inputLetter();
		showBoard();
		desiredLocation();
		desiredMove();
	}
}