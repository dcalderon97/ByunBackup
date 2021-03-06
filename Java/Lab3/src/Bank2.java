import java.util.*;
public class Bank2 {
	private String bankName;
	private int numOfAccounts;
	private Account2[] ara = new Account2[3];
	public Bank2(){
		bankName = null;
		numOfAccounts=0;
	}
	public void setbankName(String name){
		bankName = name;
	}
	public boolean openAccount(){
		Scanner keyboard = new Scanner(System.in);
		int accountNum;
		int accountType;
		String accountName;
		double accountBalance;
		String junk;
		System.out.println("Enter account number.");
		accountNum = keyboard.nextInt();
		System.out.println("Enter account tyep.");
		accountType = keyboard.nextInt();
		System.out.println("Enter Initial balance");
		accountBalance = keyboard.nextDouble();
		junk = keyboard.nextLine();
		System.out.println("Enter account holder name");
		accountName = keyboard.nextLine();
		if(numOfAccounts == 3)
		{
			return false;
		}
		else{
			for(int i = 0 ; i < numOfAccounts;i++)
			{
				if(accountNum == ara[i].getNumber())
				{
					return false;
				}
			}
			ara[numOfAccounts] = new Account2(accountName,accountNum,accountType,accountBalance);
			numOfAccounts++;
			return true;
		}
	}
	public boolean closeAccount(int accountNum){
		for(int i = 0; i < accountNum;i++)
		{
			if(ara[i].getNumber() == accountNum)
			{
				ara[i] = ara[i+1];
				numOfAccounts--;
				return true;
			}
		}
		return false;
	}
	public void printAllAccounts(){
		for(int i = 0 ; i < numOfAccounts;i++)
		{
			if(ara[i].getName() != null)
			{
				System.out.println( "Account name: "+ ara[i].getName() );
				System.out.println("Account balance: "+ara[i].getBalance() );
				System.out.println("Account type:" +ara[i].getType() );
				System.out.println("Account number: " +ara[i].getNumber() );
			}
			System.out.println(" ");
		}
	}
	public static void main(String[] args) {
		Bank2 bank =new Bank2();
		bank.setbankName("Potato");
		bank.openAccount();
		bank.printAllAccounts();
		
		bank.openAccount();
		bank.printAllAccounts();
		
		bank.openAccount();
		bank.printAllAccounts();
		
		bank.closeAccount(2);
		
		bank.openAccount();
		bank.printAllAccounts();
	}

}
