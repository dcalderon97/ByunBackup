
public class Account {
	String ssn;
	String accountNumber;
	String accountType;
	String balance;
	String getSSN(){
		return this.ssn;
	}
	String getAccountNumber(){
		return this.accountNumber;
	}
	String getAccountType(){
		return this.accountType;
	}
	String getAccountBalance(){
		return this.balance;
	}
	public void setAccountInfo(String ssn,String accountNumber,String type,String balance){
		this.ssn = ssn;
		this.accountNumber = accountNumber;
		this.accountType = type;
		this.balance = balance;
	}
	public static void main(String[] args){
		
	}
}