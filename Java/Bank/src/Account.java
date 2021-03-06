/*
 * Title: Account.java
 * Abstract: Deals with creating an account object.
 * Author: Daniel Calderon
 * Date: 2/15/17
 */
public class Account {
	String ssn;
	String accountNumber;
	String accountType;
	String balance;
	String accountHolder;
	
	public void deleteAccount(){
		ssn = null;
		accountNumber = null;
		accountType = null;
		balance = null;
		accountHolder = null;
	}
	public void setAccountBalanceDeposit(double num){
		double temp = Double.parseDouble(balance);
		temp += num;
		balance = Double.toString(temp);
	}
	public void setAccountBalanceWithdraw(double num){
		double temp = Double.parseDouble(balance);
		if(temp - num < 0)
		{
			System.out.println("Not enough funds");
			return;
		}
		temp -= num;
		balance = Double.toString(temp);
	}
	String getAccountName()
	{
		return this.accountHolder;
	}
	String getAccountSSN(){
		return this.ssn;
	}
	String getAccountNumber(){
		return this.accountNumber;
	}
	public String getAccountType(){
		return this.accountType;
	}
	public String getAccountBalance(){
		return this.balance;
	}
	public void setAccountInfo(String ssn,String accountNumber,String type,String balance,Customer[] customer,int size){
		this.ssn = ssn;
		this.accountNumber = accountNumber;
		this.accountType = type;
		this.balance = balance;
		for(int i =0; i < size;i++)
		{
			if(customer[i].getCustomerSSN().equals(ssn))
			{
				accountHolder = customer[i].getCustomerName();
				if(type.equals("1"))
				{
					customer[i].incrementNumCheckings();
				}
				else if(type.equals("2")){
					customer[i].incrementNumSavings();
				}
			}

		}
	}
	public static void main(String[] args){
		
	}
}
