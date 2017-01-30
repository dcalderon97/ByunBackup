/*
 Title:DrawDiagram.java
 Abstract:This probgram create a diamond,square,and triangle, based on the size of user input.
 Author: Daniel Calderon
 ID: 3083
 Date: 1/26/2017
 */
import java.util.Scanner;
public class DrawDiagram {
	
	void printSquare(int size)
	{
		for(int i = 0; i < size;i++)
		{
			for(int j = 0; j < size-1; j++)
			{
				System.out.print('*');
			}
			System.out.println('*');
		}
	}
	void printTriangel(int size)
	{
		for(int i  = 1; i <= size;i++)
		{
			for(int k =-1*i+size;k>=1;k--)
			{
				System.out.print(" ");
			}
			for(int  j = 1; j <=i ;j++)
			{
				System.out.print('*');
			}
			System.out.println("");
		}
			
	}
	void printDiamond(int size)
	{
		int space = size -1;
		int k,l;
		for (k = 1; k<=size; k++)
		{
		    for (l = 1; l<=space; l++)
		      System.out.print(" ");
		    space--;
		    for (l = 1; l<= 2*k-1; l++)
		      System.out.print("*");
	
		    System.out.print("\n");
		}
		space = 1;
		for (k = 1; k<= size - 1; k++)
		{
		    for (l = 1; l<= space; l++)
		      System.out.print(" ");
		    space++;
		    for (l = 1 ; l<= 2*(size-k)-1; l++)
		      System.out.print("*");
		    System.out.println("");
		}
	}
	public static void main(String[] args) {
		int userChoice;
		DrawDiagram functions = new DrawDiagram();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter size: ");
		userChoice = keyboard.nextInt();
		functions.printSquare(userChoice);
		functions.printTriangel(userChoice);
		functions.printDiamond(userChoice);
	}

}
