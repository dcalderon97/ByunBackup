import java.util.Scanner;

public class CheckingAccount extends Account3
{
    private int pin;
    
    public CheckingAccount(String name, int number, int type, double balance)
    {
        super(name,number,type,balance);
        this.pin = 7777;
    }
    
    
    public boolean withdrawal(double fund)
    {
        Scanner keyboard = new Scanner (System.in);
        int pinInput;
        System.out.println("Enter pin");
        pinInput= keyboard.nextInt();
        if(pinInput!= pin)
        {
        	System.out.println("Incorrect pin.No withdrawl from account");
        	return false;
        }
        else
        {
        	super.setBalance( (super.getBalance() - fund));
        	return true;
        }
    }
    
    public static void main(String[] args)
    {
        CheckingAccount chase = new CheckingAccount("Dr. Byun", 1234, 1, 500.0);
        
        chase.withdrawal(450.0);
        
        System.out.println(chase);
    }

}