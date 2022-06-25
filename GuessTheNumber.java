import java.util.Scanner;
import java.util.Random;
class Number_game
{
	int System_input;
	int User_input;
	int noofguesses=0;
	Number_game()
	{
		Random random=new Random();
		this.System_input=random.nextInt(100)+1;
	}
	public boolean takeUser_input()
	{
		if(noofguesses<10)
		{
			System.out.println("Guess the number:");
			this.User_input=GuessTheNumber.takeIntegerInput(100);
			noofguesses++;
			return false;
		}
		else
		{
			System.out.println("Better Luck Next Time...........Number of attempts finished\n");
			return true;
		}
	}
	public boolean isCorrectGuess()
	{
		if(System_input==User_input)
		{
			System.out.println("Congratulations .you guessed the number " +System_input+" in "+noofguesses+" guesses");
			switch(noofguesses)
			{
				case 1:
				System.out.println("Your score is 100");
				break;
				case 2:
				System.out.println("Your score is 90");
				break;
				case 3:
				System.out.println("Your score is 80");
				break;
				case 4:
				System.out.println("Your score is 70");
				break;
				case 5:
				System.out.println("Your score is 60");
				break;
				case 6:
				System.out.println("Your score is 50");
				break;
				case 7:
				System.out.println("Your score is 40");
				break;
				case 8:
				System.out.println("Your score is 30");
				break;
				case 9:
				System.out.println("Your score is 20");
				break;
				case 10:
				System.out.println("Your score is 10");
				break;
			}
			System.out.println();
			return true;
		}
		else if(noofguesses<10 && User_input>System_input)
		{
			if(User_input-System_input>10)
			{
				System.out.println("Too high");
			}
			else
			{
				System.out.println("Little high");
			}
		}
		return false;
	}
}
public class GuessTheNumber
{
	public static int takeIntegerInput(int limit)
	{
		int input=0;
		boolean flag=false;
		while(!flag)
		{
			try
			{
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag && input>limit||input<1)
				{
					System.out.println("choose the number between 1 to " + limit);
					flag=false;
				}
			}
			catch(Exception e)
			{
				System.out.println("Enter only integer value");
				flag=false;
			}
		};
		return input;
	}
	public static void main (String[] args)
	{
		System.out.println("1. Start The Game \n2. Exit");
		System.out.print("Enter your choice: ");
		int choice=takeIntegerInput(2);
		int nextRound=1;
		int noOfRound=0;
		if(choice==1)
		{
			while(nextRound==1)
			{
				Number_game game=new Number_game();
				boolean isMatched=false;
				boolean isLimitCross=false;
				System.out.println("\n Round" + ++noOfRound +" starts...");
				while(!isMatched && !isLimitCross)
				{
					isLimitCross=game.takeUser_input();
					isMatched=game.isCorrectGuess();
				}
				System.out.println("1.Next Round \n2. Exit");
				System.out.println("Enter your choice : ");
				nextRound=takeIntegerInput(2);
				if(nextRound!=1)
				{
					System.exit(0);
				}
			}
		}
		else
		{
			System.exit(0);
		}
	}
}

				
				
		