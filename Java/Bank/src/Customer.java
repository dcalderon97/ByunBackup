
public class Customer {
	
	String name;
	String address;
	String zipCode;
	String ssn;
	Customer(){
		name = null;
		address =null;
		zipCode = null;
		ssn = null;
	}
	String getCustomerName(){
		return this.name;
	}
	String getCustomerAddress(){
		return this.address;
	}
	String getZipCode(){
		return this.zipCode;
	}
	String getCustomerSSN(){
		return this.ssn;
	}
	void setCustomerInfo(String name,String address,String zipCode,String ssn){
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.ssn = ssn;
	}
	public static void main(String[] args){
		
	}
}