package automation.testsuite;

import org.testng.Assert;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.LoginPage;
import automation.page.UserPage;

public class LoginTest extends CommonBase {
	@BeforeMethod
	public void openBrowser() {
		driver = initFireFoxDriver(CT_PageURL.codeStarURL);
	}

	//Login thành công
	@Test(priority = 1)
	public void loginSucessfully() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");

		Assert.assertTrue(driver.getCurrentUrl().contains("http://test-system.crmstar.vn/user"));
	}
	
	//Login thất bại do sai email
	@Test(priority = 2)
	public void loginFail_IncorrectEmail() throws InterruptedException {
		LoginPage loginFail = new LoginPage(driver);
		loginFail.LoginFunction("abc@gmail.com", "12345678");

		Assert.assertEquals(loginFail.getErrorMessage(), "Email hoặc mật khẩu không đúng");
	}

	// Login thất bại do sai password
	@Test(priority = 3)
	public void loginFail_IncorrectPass() throws InterruptedException {
		LoginPage loginFail = new LoginPage(driver);
		loginFail.LoginFunction("admin@gmail.com", "12345");
		
		Assert.assertEquals(loginFail.getErrorMessage(), "Email hoặc mật khẩu không đúng");
	}

	// Login thất bại do sai cả mail và password
	@Test(priority = 4)
	public void loginFail_Incorrect() throws InterruptedException {
		LoginPage loginFail = new LoginPage(driver);
		loginFail.LoginFunction("abc@gmail.com", "12345");
		
		Assert.assertEquals(loginFail.getErrorMessage(), "Email hoặc mật khẩu không đúng");
	}

	// Logout
	@Test(priority = 5)
	public void logout() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		Thread.sleep(5000);
		
		UserPage user = new UserPage(driver);
		user.LogoutFunction();
		Thread.sleep(3000);
		Assert.assertTrue(driver.getCurrentUrl().equals("http://test-system.crmstar.vn/"));
	}

	@AfterMethod
	public void closeDriver() {
		driver.close();
	}

}
