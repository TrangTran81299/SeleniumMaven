package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.Tedu_CapNhatMatKhauPage;

public class Tedu_CapNhatMatKhauTest extends CommonBase {
	public Tedu_CapNhatMatKhauPage teduPage;
	String currentPass = "123456";

	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURL.TEDUURL);
		teduPage = new Tedu_CapNhatMatKhauPage(driver);
	}

	@Test(priority = 1)
	public void DangNhapThanhCong() throws InterruptedException {
		Tedu_CapNhatMatKhauPage teduPage = new Tedu_CapNhatMatKhauPage(driver);
		Thread.sleep(3000);
		teduPage.CloseNotification();
		Thread.sleep(3000);
		teduPage.DangNhap("tttrang0899@gmail.com", currentPass);
		assertTrue(driver.findElement(By.xpath("//a[@title = 'Tài khoản' and @class='btn btn-xs dropdown-toggle']"))
				.isDisplayed());
	}

	@Test(priority = 2)
	public void CapNhatMatKhauThanhCong() throws InterruptedException {
		Random rand = new Random();
		int value = 7;//rand.nextInt(50);
		String newPass = currentPass + value;
		System.out.println(newPass);
		DangNhapThanhCong();
		teduPage.CapNhatMatKhau(currentPass, newPass);
		assertTrue(driver.findElement(By.xpath("//div[text() = 'Đổi mật khẩu thành công. Mời bạn đăng nhập lại.']"))
				.isDisplayed());
		currentPass = newPass;
	}
}
