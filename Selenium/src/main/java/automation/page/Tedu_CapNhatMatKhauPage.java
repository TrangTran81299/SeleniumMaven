package automation.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tedu_CapNhatMatKhauPage {
	private WebDriver driver;
	@FindBy(xpath = "//a[@title='Đăng nhập']")
	WebElement buttonDangNhap;
	@FindBy(id = "UserName")
	WebElement textUserName;
	@FindBy(id = "Password")
	WebElement textPassWord;
	@FindBy(xpath = "//button[text()='Đăng nhập']")
	WebElement btnDangNhap;
	@FindBy(id = "onesignal-slidedown-cancel-button")
	WebElement btnLater;
	@FindBy(xpath = "//a[@title = 'Đổi mật khẩu']")
	WebElement btnDoiMatKhau;
	@FindBy(xpath = "//a[@title='Tài khoản' and @class='btn btn-xs dropdown-toggle']")
	WebElement btnAvatar;
	@FindBy(id = "OldPassword") WebElement textOldPass;
	@FindBy(id = "NewPassword") WebElement textNewPass;
	@FindBy(id = "ConfirmNewPassword") WebElement textConfirmNewPassword;
	@FindBy(xpath = "//input[@value='Cập nhật']") WebElement btnCapNhat;

	public Tedu_CapNhatMatKhauPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void DangNhap(String email, String password) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", buttonDangNhap);
		buttonDangNhap.click();
		textUserName.sendKeys(email);
		textPassWord.sendKeys(password);
		btnDangNhap.click();
	}

	public void CloseNotification() {
		btnLater.click();
	}
	
	public void CapNhatMatKhau(String oldPass, String newPass) {
		btnAvatar.click();
		btnDoiMatKhau.click();
		textOldPass.sendKeys(oldPass);
		textNewPass.sendKeys(newPass);
		textConfirmNewPassword.sendKeys(newPass);
		btnCapNhat.click();
	}
}
