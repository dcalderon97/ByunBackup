/*
 * Title: Customer.java
 * Abstract: Creates a customer object when called
 * Author: Daniel Calderon
 * Date: 2/15/17
 */
public class Customer {
	
	String name;
	String address;
	String zipCode;
	String ssn;
	int numCheckings;
	int numSavings;
	Customer(){
		name = null;
		address =null;
		zipCode = null;
		ssn = null;
	}
	int getNumCheckings()
	{
		return this.numCheckings;
	}
	int getNumSavings(){
		return this.numSavings;
	}
	void incrementNumCheckings(){
		numCheckings++;
	}
	void incrementNumSavings(){
		numSavings++;
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