import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {

	private static int t=0; //for repeating the game
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
	
	 /*@parameter turn to check whose turn to play
	  * turn can be player and computer
	  * turn=c means computer, turn=p means player 
	  */
	public static char turn; 
	
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
	/*@method to check for winner
	 * it checks if there is xxx or ooo in horizontal and vertical or diagonal directional
	 * if there exists then there is a winner
	 * later its iterated through board to check if all values are filled if yes then draw
	 * or else next person plays
	 * UseCase 7
	 */
	
	public static  char isWin()
    {
		 String line = null;
            
		//to check if there is an winning situation
        for (int a = 1; a < 10; a++) 
        {
           
            switch (a) {
            case 1:
                line = ""+board[1] + board[2] + board[3];
                break;
            case 2:
                line = ""+board[4] + board[5] + board[6];
                break;
            case 3:
                line = ""+board[7] + board[8] + board[9];
                break;
            case 4:
                line = ""+board[1] + board[4] + board[7];
                break;
            case 5:
                line = ""+board[2] + board[5] + board[8];
                break;
            case 6:
                line = ""+board[3] + board[6] + board[9];
                break;
            case 7:
                line = ""+board[1] + board[5] + board[9];
                break;
            case 8:
                line = ""+board[3] + board[5] + board[7];
                break;
            }
        //For X winner
        if (line.equals("XXX")) {
            return 'X';
        }
          
        // For O winner
        else if (line.equals("OOO")) {
            return  'O';
        }
        }
        int a1;
        	
        	for (a1 = 1; a1 < 10; a1++) {
        	
	            if (board[a1]==' ') {
	               break;
	            }
        	} if(a1==9)
	                return 'd';
        	else
        		return 'n';
    }
			
       
      
    /**display the winning player or indicate a tie (or unfinished game).*/
    public static void displayWinner()
    {
    	
       char win=isWin();
        if(win==input_player)
        {
        	System.out.println("Congratulations!!!! You have won the game");
        	t=1;
        }
        else if(win==input_computer)
        	{
        		System.out.println("Sorry!!!Computere has won the game");
        		t=1;
        	}
        else if(win=='d')
        {
        	System.out.println("It's a draw! Thanks for playing");
        	t=1;
        }
        else if(win=='n')
        {
        	if (turn=='p') {
                turn = 'c';
                
            }
            else {
                turn = 'p';
               
            }
        	
        }
        
}
    /*
     * here computer is played 
     * usecase 8,9,10 and 11
     * first computer will check if it has any winnig oppurtunities if not computer will check blocking conditions to stop player from playing
     * if both are not there it will check corner values if corner values filled then center value if that also filled it will fill remaining value
     */
    public static void ComputerGame()
	{
		System.out.println("Computer is playing!!!");
		//winning conditions usecase 8
		if((board[1]==' ')&&(board[2]==board[3]&&board[2]==input_computer)||(board[4]==board[7]&&board[4]==input_computer)||(board[5]==board[9]&&board[5]==input_computer))
					board[1]=input_computer;
					
		else if((board[2]==' ')&&(board[1]==board[3]&&board[3]==input_computer)||(board[5]==board[8]&&board[8]==input_computer))
				board[2]=input_computer;
		
		else if((board[3]==' ')&&(board[1]==board[2]&&board[2]==input_computer)||(board[6]==board[9]&&board[9]==input_computer)||(board[5]==board[7]&&board[7]==input_computer))
			board[3]=input_computer;
			
		else if((board[4]==' ')&&(board[1]==board[7]&&board[7]==input_computer)||(board[5]==board[6]&&board[6]==input_computer))
				board[4]=input_computer;
	
		else if((board[5]==' ')&&(board[1]==board[9]&&board[1]==input_computer)||(board[7]==board[3]&&board[7]==input_computer)||(board[2]==board[8]&&board[8]==input_computer)||(board[4]==board[6]&&board[6]==input_computer))
				board[5]=input_computer;
	
		else if((board[6]==' ')&&(board[9]==board[3]&&board[3]==input_computer)||(board[5]==board[4]&&board[4]==input_computer))
				board[6]=input_computer;
			
		else 	if((board[7]==' ')&&(board[1]==board[4]&&board[4]==input_computer)||(board[8]==board[9]&&board[9]==input_computer)||(board[3]==board[5]&&board[5]==input_computer))
				board[7]=input_computer;
			
		else if((board[8]==' ')&&(board[9]==board[7]&&board[7]==input_computer)||(board[2]==board[5]&&board[2]==input_computer))
				board[8]=input_computer;
			
		else if((board[9]==' ')&&(board[1]==board[5]&&board[5]==input_computer)||(board[6]==board[3]&&board[3]==input_computer)||(board[8]==board[7]&&board[7]==input_computer))
				board[9]=input_computer;
		
		//blocking conditions usecase9
		else if((board[1]==' ')&&(board[2]==board[3]&&board[2]==input_player)||(board[4]==board[7]&&board[4]==input_player)||(board[5]==board[9]&&board[5]==input_player))
				board[1]=input_computer;
			
		else if((board[2]==' ')&&(board[1]==board[3]&&board[3]==input_player)||(board[5]==board[8]&&board[8]==input_player))
				board[2]=input_computer;
		
		else if((board[3]==' ')&&(board[1]==board[2]&&board[2]==input_player)||(board[6]==board[9]&&board[9]==input_player)||(board[5]==board[7]&&board[7]==input_player))
				board[3]=input_computer;
		
		else if((board[4]==' ')&&(board[1]==board[7]&&board[7]==input_player)||(board[5]==board[6]&&board[6]==input_player))
				board[4]=input_computer;

		else if((board[5]==' ')&&(board[1]==board[9]&&board[1]==input_player)||(board[7]==board[3]&&board[7]==input_player)||(board[2]==board[8]&&board[8]==input_player)||(board[4]==board[6]&&board[6]==input_player))
				board[5]=input_computer;
	
		else if((board[6]==' ')&&(board[9]==board[3]&&board[3]==input_player)||(board[5]==board[4]&&board[4]==input_player))
				board[6]=input_computer;
	
		else if((board[7]==' ')&&(board[1]==board[4]&&board[4]==input_player)||(board[8]==board[9]&&board[9]==input_player)||(board[5]==board[3]&&board[3]==input_player))
				board[7]=input_computer;

		else if((board[8]==' ')&&(board[9]==board[7]&&board[7]==input_player)||(board[2]==board[5]&&board[2]==input_player))
			board[8]=input_computer;
		
		else if((board[9]==' ')&&(board[1]==board[5]&&board[5]==input_player)||(board[6]==board[3]&&board[3]==input_player)||(board[8]==board[7]&&board[7]==input_player))
			board[9]=input_computer;
	
		else
			{
			//checking for corner values usecase10
			int corner[]= {1,3,7,9};
			int f=0;
			for(int i=0;i<4;i++)
			{
				if(board[corner[i]]==' ')
					{board[corner[i]]=input_computer;
					f=1;
					break;
					}
			}
			//checking for center and remaining values usecase11
			if(f==0 )
				if(board[5]==' ')
					board[5]=input_computer;
				else
				{
					int rem[]= {2,4,6,8};
					for(int i=0;i<4;i++)
					{
						if(board[rem[i]]==' ')
							{
							board[rem[i]]=input_computer;
							f=1;
							break;
							}
					}
				}
			}
		}
    
    public static void tictactoe()
    {
    	newGame();	
		inputLetter();
		showBoard();
		toss();
		while(t==0)
		{
			
			if(turn=='c')
			{
				ComputerGame();
				showBoard();
				displayWinner();
				turn='p';
			}
			else if(turn=='p') 
			{
				desiredLocation();
				desiredMove();
				displayWinner();
				showBoard();
				turn='c';
				
			}
		}
    }
	//main function of the class TicTacToeGame
	public static void main(String[] args) {
		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		
		tictactoe();
	}
}