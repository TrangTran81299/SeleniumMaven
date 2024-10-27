package automation.testsuite;

import org.testng.annotations.*;

public class Login {
	@BeforeMethod
	private void init() {
		System.out.println("This is before method");
	}

	@Test
	private void testcase1() {
		System.out.println("This is test case 1");
	}
}
