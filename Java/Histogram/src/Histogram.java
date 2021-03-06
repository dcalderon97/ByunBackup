/*
 Title:Histogram.java
 Abstract:This program creates a histogram table based on user input.
 Author: Daniel Calderon
 ID: 3083
 Date: 1/28/2017
 */
import java.util.Scanner;

public class Histogram {

	public static void main(String[] args) {
		int size;
		int highestOccurence;
		int temp;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("How many intergers would you like to enter[max 30]?");
		size = keyboard.nextInt();
		int[] ara = new int[size];
		
		System.out.println("Enter " + size + " numbers.");
		for(int i = 0;i<size;i++)
		{
			ara[i] = keyboard.nextInt();
		}
		
		int[] count = new int[10];
		for(int i =0;i<ara.length;i++)
		{
			
	
			temp = ara[i];
			count[temp]++;
		}
		highestOccurence = count[0];
		for(int i = 1; i < count.length;i++)
		{
			if(count[i] > highestOccurence)
				highestOccurence = count[i];
		}
		System.out.println("Number     Occurence");
		for(int i = 0; i < count.length;i++)
		{
			if(count[i] !=0)
			System.out.println(i + "          " + count[i]);
		}
		System.out.println("=======Vertical Bar==========");
		for(int i = highestOccurence; i >= 1;i--)
		{
			System.out.print("|  "+ i + " | ");
			for(int k = 0; k < count.length;k++)
			{
				if(count[k] == i || count[k]>i)
				{
					System.out.print("* ");
				}
				else
				{
					System.out.print("  ");
				}
			}
			System.out.println(" ");
		}
		System.out.println("============================");
		System.out.println("| NO | 0 1 2 3 4 5 6 7 8 9");
		System.out.println("============================");
		keyboard.close();
	}

}
