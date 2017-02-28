/**
	 * Title: TestCase_1.java
	 * Purpose:Verify if method to deposit money works.
	 * Input: Call deposit method with 200 as input.
	 * Account: AAAA,1111,1,1000.50
	 * Expected Result: After printing account info, balance should be 1200.50;
	 * 1
	 *
	 * Test Result: The program passed the test case.
	 *
	 * Author: XXXX
	 * ID: XXXX
	 * Date: MM/DD/YY
*/
public class TestCase_3 {

	public static void main(String[] args) {
		Bank2 testBank = new Bank2();
		testBank.setBankName("CSUMB");
		testBank.openAccount();
		testBank.printAllAccounts();

	}

}
