import java.io.IOException;
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        boolean rightInput = true;
        String Junk;
        while(rightInput){
            try{
      
                System.out.print("Enter an integer number: ");
                int userChoice = keyboard.nextInt();
                rightInput = false;
            }
            catch(Exception e){              
            	System.out.println("Not a correct format.");
            	Junk = keyboard.nextLine();  
            }

        }

    }

}