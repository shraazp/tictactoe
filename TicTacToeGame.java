
public class TicTacToeGame {
	//@array to store board values
	public static char[] board= new char[10];  
	public static void  newGame()     
	{
		 
		for(int i=1;i<board.length;i++)     //iterate through board array
		{
			board[i]=' ';
		}
	}
	//main function of the class TicTacToeGame
	public static void main(String[] args) {
		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		newGame();	
	}
}