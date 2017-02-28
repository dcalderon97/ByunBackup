/**
	 * Title: TestCase_1.java
	 * Purpose:Verify if method to print object information is properly created.
	 * Input: Account name: CSUMB
	 * First account: AAAA, 1111, 1, 1000.50
	 * Expected Result: Program should print out Bank name followed by bank name then a new line
	 * and then Number of Accounts followed by bank number of accounts. Should print CSUMB 
	 * 1
	 *
	 * Test Result: The program passed the test case.
	 *
	 * Author: Daniel Calderon
	 * ID: 3083
	 * Date: 02/16/17
*/

public class TestCase_1 {
	public static void main(String[] args){
		Bank2 testBank = new Bank2();
		testBank.setBankName("CSUMB");
		testBank.openAccount();
		System.out.println(testBank);
	}
}
