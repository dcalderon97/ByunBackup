public class Account3 
{
    private String name;
    private int number;
    private int type;
    private double balance;
    
    // Constructor
    public Account3 (String name, int number, int type, double balance)
    {
        this.name = name;
        this.number = number;
        this.type = type;
        this.balance = balance;
    }
    
     
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    
    public String getName()
    {
        return (name);
    }
    
    
    public String toString()
    {
        return ("Name: " + name + ", Number: " + number + 
                ", Balance: " + balance);
    }

    
    public double getBalance()
    {
        return (balance);
    }
    
    
    public boolean withdrawal(double fund)
    {
        if (fund > balance) 
        {
            System.out.println("Error: insufficient balance to withdraw.");
            return false;
        }
        else 
        {
            balance -= fund;
            return true;
        }
    }
}