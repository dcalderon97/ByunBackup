/**
 * Title: Bank2.java
 * Abstract: This program creates a Bank2 class that holds only three accounts.
 *           The class should implement openAccount (), closeAccount (),
 *           printAllAccounts(), etc.

 * Author: XXXX
 * ID: XXXX
 * Date: MM/DD/YY
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class Bank2 
{
    private Account2[] accounts = new Account2[3];
    private String bankName;
    private int numOfAccounts;
    
    //Default constructor
    public Bank2()
    {
        bankName = "UNKNOWN";
        numOfAccounts = 0;
        for (int i = 0; i < 3; i++)
        {
            accounts[i] = new Account2("UNKNOWN", -1, 1, 0.0);
        }
    }
    
    //Controls printing bank information
    public String toString()
    {
        return("Bank name: " + bankName + "\nNumber of accounts: " + numOfAccounts);
    }
    
    //Checks equality of two bank objects
    public boolean equals(Bank2 otherObj)
    {
        return(this.bankName.equals(otherObj.bankName) 
              && this.numOfAccounts == otherObj.numOfAccounts);
    }
    
    //Changes the name of the bank
    public void setBankName(String bankName)
    {
        this.bankName = bankName;
    }
    
    //Opens an account for a user
    public boolean openAccount()
    {
        if (numOfAccounts == 3)
        {
            System.out.println("Sorry, there are already too many accounts." +
                              "\nPlease delete an account and try again.\n");
            return false;
        }
        
        //If an account has been deleted, find the index and use it
        //as the index for the new account
        boolean nullAccount = false;
        int accountIndex = 0;
        for (int i = 0; i < 3; i++)
        {
            if (accounts[i] == null)
            {
                accountIndex = i;
                nullAccount = true;
                accounts[i] = new Account2("UNKNOWN", -1, 1, 0.0);
                break;
            }
        }
        
        if (nullAccount == false)
        {
            accountIndex = numOfAccounts;
        }
        
        Scanner keyboard = new Scanner(System.in);
        String accountName = "ERROR";
        int accountNum = -2;
        int accountType = -2;
        double balance = 0;
        
        System.out.print("Enter the account owner's name: ");
        accountName = keyboard.nextLine();
        
        boolean entrySuccess = false;
        
        //Gets account number
        while (!entrySuccess)
        {
            while (!entrySuccess)
            {
                try
                {
                    System.out.print("Enter an account number: ");
                    accountNum = keyboard.nextInt();
                    entrySuccess = true;
                }
                catch (InputMismatchException notAnInt)
                {
                    System.out.println("Invalid input. Please try again.");
                    keyboard.nextLine();
                }
                
                if (accountNum < 1)
                {
                    System.out.println("Account number must be positive. Please try again.");
                    entrySuccess = false;
                }
            }
            
            for (int i = 0; i < 3; i++)
            {
                if (accounts[i] == null)
                {
                    continue;
                }
                
                if (accountNum == accounts[i].getAccountNumber())
                {
                    System.out.println("Account number in use. Please try again.");
                    entrySuccess = false;
                }
            }
            
        }
        
        entrySuccess = false;
        
        //Gets account type
        while (!entrySuccess)
        {
            while (!entrySuccess)
            {
                try
                {
                    System.out.print("Enter an account type: ");
                    accountType = keyboard.nextInt();
                    entrySuccess = true;
                }
                catch (InputMismatchException notAnInt)
                {
                    System.out.println("Invalid input. Please try again.");
                    keyboard.nextLine();
                }
            }
            
            if (accountType != 1 && accountType != 2)
            {
                System.out.println("Valid input: 1 or 2. Please try again.");
                entrySuccess = false;
            }
        }
        
        entrySuccess = false;
        
        //Gets initial balance
        while (!entrySuccess)
        {
            try
            {
                System.out.print("Enter an initial balance: ");
                balance = keyboard.nextDouble();
                entrySuccess = true;
            }
            catch (InputMismatchException notAnInt)
            {
                System.out.println("Invalid input. Please try again.");
                keyboard.nextLine();
            }
            
            if (balance < 0.0)
            {
                System.out.println("Invalid input. Please try again.");
                entrySuccess = false;
            }
        }
        
        
        //Create the account
        accounts[accountIndex].setAccount(accountName, accountNum, accountType, balance);
        numOfAccounts++;
        System.out.println("Account creation success!\n");
        return true;
    }
    
    //This closes an account
    public boolean closeAccount(int num)
    {
        for (int i = 0; i < 3; i++)
        {
            if (accounts[i] == null)
            {
                continue;
            }
            
            if (num == accounts[i].getAccountNumber())
            {
                accounts[i] = null;
                numOfAccounts--;
                return true;
            }
        }
        
        System.out.println("No such account exists to close!");
        return false;
    }
    
    //Prints out all the accounts' information
    public void printAllAccounts()
    {
        for (int i = 0; i < 3; i++)
        {
            if (accounts[i] == null)
            {
                continue;
            }
            
            System.out.println("Account " + (i + 1)  + " Information:\n");
            accounts[i].printAccount();
            System.out.println();
        }
    }
}
