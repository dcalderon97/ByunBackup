import java.util.Scanner;

public class Factorial {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		int userInput = 0;
		int answer = 1;
		String junk;
		boolean correct = false;
		while(!correct)
		{
			try
			{
				System.out.println("Enter an Interger Number: ");
				userInput = keyboard.nextInt();
				if(userInput == 0)
				{
					System.out.println("0! -- > 1 --> 1");
					correct = true;
					continue;
				}
				if(userInput < 0)
				{
					System.out.println("No result for negative numbers");
					correct = true;
				}
				else
				{
					System.out.print(userInput +"! --> ");
					for(int i = 1; i <= userInput; i ++)
					{
						if(i < userInput)
							System.out.print(i + " * ");
						else
							System.out.print(i );
						answer = answer * i ;
					}
					System.out.println(" --> " + answer);
					correct =true;
				}
			}
			catch(Exception e)
			{
				System.out.println("Incorrect Format");
				junk = keyboard.nextLine();
			}
		}

	}
}
