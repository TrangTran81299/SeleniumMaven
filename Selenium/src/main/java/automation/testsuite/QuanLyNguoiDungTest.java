package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;
import automation.page.LoginPage_Day14;
import automation.page.QuanLyNguoiDungPage;

public class QuanLyNguoiDungTest extends CommonBase {
	@BeforeMethod
	public void OpenFireFox() {
		driver = initFireFoxDriver(CT_PageURL.CRMCodeStar);
		LoginPage_Day14 login = new LoginPage_Day14(driver);
		login.LoginFunction("admin@gmail.com", "12345678");
		assertTrue(driver.findElement(By.xpath("//p[text()='Quản lý người dùng']")).isDisplayed());
	}

	@Test(priority = 1)
	public void ThemNguoiDungThatBai_DuLieuSaiDinhDang() {
		QuanLyNguoiDungPage quanlyND = new QuanLyNguoiDungPage(driver);
		quanlyND.ThemNguoiDung("autotest", "test@gmail.com", "12345678", "4", "1", "2", "NDTest1");
		assertTrue(driver.findElement(By.xpath("//div[text()='Dữ liệu nhập vào sai định dạng']")).isDisplayed());
	}
	
	//BTVN: case1 - Them nguoi dung thanh cong
	@Test(priority = 2)
	public void ThemNguoiDungThanhCong() throws InterruptedException {
		QuanLyNguoiDungPage quanlyND = new QuanLyNguoiDungPage(driver);
		quanlyND.ThemNguoiDung("TrangTran", "anh999@gmail.com", "978782289", "4", "1", "2", "500888");
		Thread.sleep(500);
		quanlyND.ThemNguoiDungThanhCong();
		Thread.sleep(200);
		assertTrue(driver.findElement(By.xpath("//div[text()='Thêm mới người dùng thành công']")).isDisplayed());
	}
	
	//BTVN: case1 - Xoa nguoi dung sau khi them
}
