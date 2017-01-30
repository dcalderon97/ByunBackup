/*
 Title:SortedString.java
 Abstract:This program takes a file input and sorts the contents in ascending order.
 Author: Daniel Calderon
 ID: 3083
 Date: 1/28/2017
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortedString {
	static void sortList(String[] args)
	{
		Arrays.sort(args);
	}
	public static void main(String[] args) {
		String filePath;
		ArrayList<String> containerString = new ArrayList<String>();
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter file path.");
		filePath = keyboard.nextLine();
	    try 
	    {
	        Scanner fileInput = new Scanner(new File(filePath));
	        while (fileInput.hasNext()) 
	        {
	          String str = fileInput.nextLine();
	          containerString.add(str);
	        }
	        fileInput.close();
	     } 
	    catch (IOException e) 
	    {
	       e.printStackTrace();
	    }
	    String[] fileWords = new String[containerString.size()];
	    fileWords = containerString.toArray(fileWords);
	    sortList(fileWords);
	    System.out.println("========Sorted Result=======");
	    for(int i  =0 ; i < fileWords.length;i++)
	    	System.out.println(fileWords[i]);
	    System.out.println("============================");
	    keyboard.close();
	}
}
