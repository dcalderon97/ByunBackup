package exercise;

import java.util.Scanner;

public class ExceptDemo {
	public static void main(String[]args)
	{
		boolean correct =false;
		while(!correct)
		{
			try
			{
				int n = 0;
				Scanner keyboard = new Scanner(System.in);
				System.out.println("Please enter whole number");
				n = keyboard.nextInt();
				System.out.println("Correct from. You entered: "+n );
				correct = true;
			}
			catch(Exception e)
			{
				String message = e.getMessage();
				System.out.println(message);
			}
		}
		System.out.println("End of main");
	}
}
