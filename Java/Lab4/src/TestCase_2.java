/**
	 * Title: TestCase_2.java
	 * Purpose:Verify if method equals method work properly.
	 * Input:Bank1 name: CSUMB Bank2 name: CSUMB
	 * First account Bank1: AAAA, 1111, 1, 1000.50
	 * First account Bank2: AAAA, 1111, 1, 1000.50
	 * Expected Result: Program should return true
	 *
	 * Test Result: The program passed the test case.
	 *
	 * Author: Daniel Calderon
	 * ID: 3083
	 * Date: 01/24/17
*/
public class TestCase_2 {

	public static void main(String[] args) {
		Bank2 testBank = new Bank2();
		testBank.setBankName("CSUMB");
		testBank.openAccount();
		Bank2 testBank2 = new Bank2();
		testBank2.setBankName("CSUMB");
		testBank2.openAccount();
		System.out.println(testBank.equals(testBank2));

	}

}
