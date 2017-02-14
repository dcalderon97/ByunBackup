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
				accounts[numOfAccounts].setAccountInfo(values[0],values[1], values[2], values[3]);
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
		    System.out.println("========== READ DATA ==========");
		    csumbBank.readData("/Users/danielcalderon/Documents/Eclipse/Java/Bank/test1.txt");
		    System.out.println("========== DONE ==========");
		    System.out.println("\n========== BANK INFORMATION ==========");
		    csumbBank.bankInfo();

		
	}
}