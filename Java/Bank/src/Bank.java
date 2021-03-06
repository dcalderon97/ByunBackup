/*
 * Title: Bank.java
 * Abstract: Pieces all classes together and creates a small bank
 * Author: Daniel Calderon
 * Date: 2/15/17
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class Bank {
	String bankName;
	int numOfCustomers;
	int numOfAccounts;
	double totalBalance;
	Customer[] customers = new Customer[10];
	Account[] accounts = new Account[10];
	void newAccount(String ssn, double accountNum,int accountType,double balance)
	{
		for(int j = 0 ; j < numOfAccounts;j++)
		{
	
			if(accounts[j].getAccountNumber().equals(Integer.toString((int)accountNum)))
			{
		
				System.out.println("Account creation failed - Account " +accounts[j].getAccountNumber()+ " already exists" );
				return ;
			}
		}
		for(int i = 0 ; i< numOfCustomers;i++)
		{
			
			if(customers[i].getCustomerSSN().equals(ssn) )
			{
				if(accountType == 1)
				{
						if(customers[i].getNumCheckings() == 1){
							System.out.println("Account creation failes - " +customers[i].getCustomerName() + "(" + customers[i].getCustomerSSN()+")" +
									" already has a checking account");
							return;
						}
						
				}
				else if(accountType == 2)
				{
						if(customers[i].getNumSavings() == 1){
							System.out.println("Account creation failed - " +customers[i].getCustomerName() + "(" + customers[i].getCustomerSSN()+")" +
										" already has a saving account");
							return;
						}
						
				}
			}
		}
		accounts[numOfAccounts] = new Account();
		accounts[numOfAccounts].setAccountInfo(ssn, Double.toString(accountNum), Integer.toString(accountType), Double.toString(balance), customers, numOfCustomers);
		System.out.print("Account creation - Number " +(int)accountNum + ", " + "Customer: " );
		for(int i = 0 ; i < numOfCustomers;i++)
		{
			if(customers[i].getCustomerSSN().equals(ssn) )
				System.out.println(customers[i].getCustomerName());
		}
		numOfAccounts++;
	}
	void newCustomer(String name,String address,double zipCode,String ssn)
	{
		for(int i = 0 ; i < numOfCustomers;i++)
		{
//			System.out.println(ssn);
//			System.out.println(customers[i].getCustomerSSN());
			if(customers[i].getCustomerSSN().equals(ssn))
			{
				System.out.println( name +" is NOT added - Duplicated SSN");
				return;
			}
			
		}
		customers[numOfCustomers] = new Customer();
		customers[numOfCustomers].setCustomerInfo(name, address, Double.toString(zipCode), ssn);
		System.out.println(customers[numOfCustomers].getCustomerName() + " is added");
		numOfCustomers++;
	}
	boolean closeAccount(double accountNum){
		for(int i = 0 ; i < numOfAccounts;i++)
		{
			if(accountNum == Double.parseDouble(accounts[i].getAccountNumber()))
			{
				accounts[i].deleteAccount();
				return true;
			}
		}
		return false;
	}
	void withdraw(double accountNum,double balance)
	{
		for(int i = 0 ; i < numOfAccounts; i++)
		{
			if(accountNum == Double.parseDouble(accounts[i].getAccountNumber()))
			{
				accounts[i].setAccountBalanceWithdraw(balance);
			}
		}
	}
	void deposit(double accountNum,double balance){
		for(int i = 0 ; i < numOfAccounts; i++)
		{
			if(accountNum == Double.parseDouble(accounts[i].getAccountNumber()))
			{
				accounts[i].setAccountBalanceDeposit(balance);
			}
		}
	}
	void accountInfo(double acNum){
		for(int i = 0; i < numOfAccounts; i++)
		{
			if(acNum == Double.parseDouble(accounts[i].getAccountNumber())){
				System.out.println("Number: " + accounts[i].getAccountNumber());
				if( accounts[i].getAccountType().equals("1"))
				{
					System.out.println("Checking");
				}
				else{
					System.out.println("Savings");
				}
				System.out.println("Balance: $" + accounts[i].getAccountBalance());
				System.out.println("Customer: " + accounts[i].getAccountName());
				return;
			}
		}
		System.out.println("Account (" + acNum + ") does not exist.");
	}
 	Bank(){
		bankName = null;
	}
	Bank(String name){
		this.bankName = name;
	}
	void readData(String path) {
		int numCustomers = 0;
		int numAccounts = 0;
		int count = 0;
		String line = null;
		try{
			FileReader fileReader = new FileReader(path);
			BufferedReader br = new BufferedReader(fileReader);
			numCustomers = Integer.parseInt(br.readLine());

			line = null;
			while(count < numCustomers)
			{
				line = br.readLine();
				String [] values = line.split(",");
				customers [numOfCustomers] = new Customer();
				customers[numOfCustomers].setCustomerInfo(values[0],values[1], values[2], values[3]);
				numOfCustomers++;
				count++;
			}
			count = 0;
			numAccounts = Integer.parseInt(br.readLine());
			while(count < numAccounts)
			{
				line = br.readLine();
				String [] values = line.split(",");
				accounts[numOfAccounts] = new Account();
				accounts[numOfAccounts].setAccountInfo(values[0],values[1], values[2], values[3],customers,numCustomers);
				numOfAccounts++;
				count++;
			}
			line = null;
			
		}
		catch(FileNotFoundException ex)
		{
            System.out.println("Unable to open file: " + path);
		}
		catch (IOException ex){
			System.out.println("Unable to open file: " + path);
		}
		
	}
	public void bankInfo(){
		System.out.println("Bank Name:  "+ bankName );
		System.out.println("Number of Customers: "+ numOfCustomers);
		for(int i =0; i < numOfCustomers;i++)
		{
			System.out.println("    "+customers[i].getCustomerName() + ": " +customers[i].getCustomerSSN() );
		}
		System.out.println("Number of accounts: "+ numOfAccounts);
		for(int i =0; i < numOfAccounts;i++)
		{
			System.out.println("    "+accounts[i].getAccountNumber() + ": $" +accounts[i].getAccountBalance() );
			totalBalance+= Double.parseDouble(accounts[i].getAccountBalance());
		}
		System.out.println("Total balance:$ " + totalBalance);
	}
	public static void main(String[] args){
	    Bank csumbBank = new Bank("CSUMB");
	    csumbBank.readData("/Users/danielcalderon/Documents/Eclipse/Java/Bank/test1.txt");
	    System.out.println("========== NEW CUSTOMERS =========="); 
	    csumbBank.newCustomer("Bob Smith", "123 University Center",93955, "123-45-6789"); 
	    csumbBank.newCustomer("Unknown Smith", "123 University Center",93955, "777-77-7777");
	    System.out.println("\n========== NEW ACCOUNTS ==========");
	    csumbBank.newAccount("777-77-7777", 4000, 1, 100.50);
	    csumbBank.newAccount("123-45-7777", 2000, 1, 100.50);
	    csumbBank.newAccount("123-45-7777", 4000, 1, 100.50);
	    System.out.println("\n========== ACCOUNT INFO ==========");
	    csumbBank.accountInfo(7000);
		
	}
}
