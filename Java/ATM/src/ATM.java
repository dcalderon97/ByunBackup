/*
 Title:ATM.java
 Abstract: This program simulates a small bank.
 Author: Daniel Calderon
 ID: 3083
 Date: 2/5/2017
 */
public class ATM {
	//Class to hold user information
	public  class PATRON{
		private  String patronName;
		private int pinNumber;
		private  double patronFunds;
		//Constructor
		PATRON()
		{
			patronName = null;
			pinNumber = 0;
			patronFunds = 0;
		}
		PATRON(String name, int pin, double funds)
		{
			patronName = name;
			pinNumber = pin;
			patronFunds = funds;
		}
		public void setPatronInfo(String name, int pin, double funds)
		{
			patronName = name;
			pinNumber = pin;
			patronFunds = funds;
		}
		//Getters
		public String getName()
		{
			return patronName;
		}
		public int getPin()
		{
			return pinNumber;
		}
		public double getFunds()
		{
			return patronFunds;
		}
		//Setters
		public void addFunds(double amount)
		{
			patronFunds += amount;
		}
		public void deductFunds(double amount)
		{
			patronFunds -= amount;
		}
		@Override
		public String toString(){
			return patronName;
		}
	}
	//End of class PATRON
	//Member Variables
	public PATRON[] users = new PATRON[10];
	private double bankBalance;
	private String bankLocation;
	private String bankName;
	private int serialNumber;
	//Variables to keep track of success and failures
	private int successWithdrawl;
	private int failWithdrawl;
	private int successDeposit;
	private int failDeposit;
	private int successTransfer;
	private int failTransfer;
	//Constructor
	ATM()
	{
		bankBalance = 100.00;
		serialNumber = 0;
		bankLocation = "UNKNOWN";
		bankName = "UNKNOWN";
		users[0] = new PATRON("Alice",1234,5000.00);
		users[1] = new PATRON("Tom",2000,200.00);
		users[2] = new PATRON("Monica",3000,50.00);
		users[3] = new PATRON("Michael",7777,0.00);
		users[4] = new PATRON("John",8000,500.00);
		users[5] = new PATRON("Jane",2222,500.00);
		users[6] = new PATRON("Robert",2323,200.00);
		users[7] = new PATRON("Owen",4455,50.00);
		users[8] = new PATRON("Chris",8787,10.00);
		users[9] = new PATRON("Rebecca",8080,555.55);
	}
	//Overloaded Constructors
	ATM(int serialNum,String name, String location)
	{
		bankBalance = 100.00;
		serialNumber = serialNum;
		bankName = name;
		bankLocation = location;
		users[0] = new PATRON("Alice",1234,5000.00);
		users[1] = new PATRON("Tom",2000,200.00);
		users[2] = new PATRON("Monica",3000,50.00);
		users[3] = new PATRON("Michael",7777,0.00);
		users[4] = new PATRON("John",8000,500.00);
		users[5] = new PATRON("Jane",2222,500.00);
		users[6] = new PATRON("Robert",2323,200.00);
		users[7] = new PATRON("Owen",4455,50.00);
		users[8] = new PATRON("Chris",8787,10.00);
		users[9] = new PATRON("Rebecca",8080,555.55);
	}
	ATM(String name)
	{
		bankBalance = 100.00;
		bankName = name;
		bankLocation = "UNKNOWN";
		serialNumber = 0;
		users[0] = new PATRON("Alice",1234,5000.00);
		users[1] = new PATRON("Tom",2000,200.00);
		users[2] = new PATRON("Monica",3000,50.00);
		users[3] = new PATRON("Michael",7777,0.00);
		users[4] = new PATRON("John",8000,500.00);
		users[5] = new PATRON("Jane",2222,500.00);
		users[6] = new PATRON("Robert",2323,200.00);
		users[7] = new PATRON("Owen",4455,50.00);
		users[8] = new PATRON("Chris",8787,10.00);
		users[9] = new PATRON("Rebecca",8080,555.55);
		
 	}
	//Getters
	double getBankBalance()
	{
		return bankBalance;
	}
	String getBankLocation()
	{
		return bankLocation;
	}
	String getBankName()
	{
		return bankName;
	}
	//Methods
	void setATM(int serialNum,String location)
	{
		serialNumber = serialNum;
		bankLocation = location;
		
	}
	void addFund(int amount)
	{
		bankBalance += amount;
	}
	void displayMenu()
	{
		System.out.println("===== ATM Transaction Menu =====");
		System.out.println("  1. Withdrawl");
		System.out.println("  2. Deposit");
		System.out.println("  3. Transfer");
	
	}
	void withdrawal(String name,int pin, double amount)
	{
		for(int i = 0; i < 10; i++)
		{
			if(users[i].getName().equals(name) && users[i].getPin() == pin)
			{
				if(users[i].getFunds() - amount >= 0 && bankBalance - amount >= 0)
				{
					users[i].deductFunds(amount);
					successWithdrawl++;
					System.out.println("Succeed - withdrawl: " +users[i].getName() + " new balance: $"+ users[i].getFunds() );
					bankBalance -= amount;
					return;
				}
			}
		}
		failWithdrawl++;
		System.out.println("Fail - withdrawl");
	}
	void deposit(String name, int pin, double amount)
	{
		for(int i = 0; i < 10; i++)
		{
			if(users[i].getName().equals(name) && users[i].getPin() == pin)
			{
				if(users[i].getFunds() - amount >= 0 && bankBalance - amount >= 0)
				{
					users[i].addFunds(amount);
					successDeposit++;
					System.out.println("Succeed - Deposit: " +users[i].getName() + " new balance: $"+ users[i].getFunds() );
					bankBalance += amount;
					return;
				}
			}
		}
		failDeposit++;
		System.out.println("Fail - deposit");
	}
	void transfer(String name, int pin, double amount,String name2,int pin2)
	{
		for(int i = 0 ; i < 10 ; i++)
		{
			if(users[i].getName().equals(name) && users[i].getPin() == pin)
			{
				for(int k = 0 ; k < 10; k++)
				{
					if(users[k].getName().equals(name2) && users[k].getPin() == pin2)
					{
						users[i].deductFunds(amount);
						users[k].addFunds(amount);
						System.out.println("Succeed - tansfer: "+ users[i].getName() + " new balance: $" + users[i].getFunds()+
								", Tom new balance: $" + users[k].getFunds());
						successTransfer++;
						return;
					}
				}
			}	
		}
		failTransfer++;
	}
	void status()
	{
		int transactions = successWithdrawl + failWithdrawl + successDeposit + failDeposit  + successTransfer + failTransfer;
		System.out.println("Serial Number: "+ serialNumber);
		System.out.println("Bank Name: " + bankName);
		System.out.println("Location: " + bankLocation);
		System.out.println("Balance: "+ bankBalance);
		System.out.println(transactions + " Transactions so far: ");
		System.out.println("   Withdrawl: " + (failWithdrawl + successWithdrawl) + " (" + successWithdrawl+ " success"+
								", " + failWithdrawl + " fail)");
		System.out.println("   Deposit: " + (failDeposit + successDeposit) + " (" + successDeposit+ " success"+
				", " + failDeposit + " fail)");
		System.out.println("   Transfer: " + (failTransfer + successTransfer) + " (" + successTransfer+ " success"+
				", " + failTransfer + " fail)");
	}
	//Overloaded Output
	@Override
	public String toString()
	{
		return "Serial Number: " + serialNumber+"\n"+"Bank Name: " + bankName +"\n"+
				"Location: " + bankLocation + "\n" + "Balance: " + bankBalance + "\n";
	}
	public static void main(String[] args) {
		ATM machine1 = new ATM("OtterUnion");
		ATM machine2 = new ATM(200,"BOA","Library");
		System.out.println("===== Welcome to CSUMB ATM Machine =====");
		System.out.println(machine1);
        System.out.println("");
        System.out.println(machine2);
        System.out.println("\n===== Equality Checking =====");
        System.out.println(machine1.equals(machine2));
        System.out.println("");
        machine1.setATM(100, "BIT110");
        machine1.addFund(400);
        System.out.println(machine1);
        System.out.println("");
        machine1.displayMenu();
        machine1.withdrawal("Alice", 7777, 10); 
        machine1.withdrawal("NoAlice", 1234, 10);
        machine1.withdrawal("Alice", 1234, 10000);
        machine1.withdrawal("Alice", 1234, 10);
        machine1.withdrawal("Alice", 1234, 2000);
        System.out.println("\n===== Machine Status =====");
        machine1.status();
        System.out.println("");
        machine1.deposit("Alice", 1234, 10); // In this method, we assume that
                                    // a user, Alice, wants the cash deposit $10
                                    // to the machine with PIN 1234.
        System.out.println("\n===== Machine Status =====");
        machine1.status();
        System.out.println("");
        machine1.transfer("Alice", 1234, 10, "Tom", 2000); // In this method,
                  // we assume that a user “Alice” wants to transfer $10
                  // to “Tom”. 1234 and 2000 indicates their PINs.
        System.out.println("\n===== Machine Status =====");
        machine1.status();
        System.out.println("\n===== Thank you! =====");
	}
	
}
