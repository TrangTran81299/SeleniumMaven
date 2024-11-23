package automation.constant;

import org.openqa.selenium.By;

public class CT_Account {
	// Chứa các locator của element trên toàn bộ các trang cần test
	// Nếu locator bị thay đổi, tester vào class này để thay đổi xPath
	// ======================== Login Page ========================
	public static By TEXT_EMAIL = By.id("email");
	public static By TEXT_PASSWORD = By.id("password");
	public static By BUTTON_LOGIN = By.xpath("//button[text()='Đăng nhập' and contains(@class , 'btn btn-success')]");
	public static By errorMessage = By.xpath("//span[contains(@class , 'fl-message')]");
	// ======================== User Page ========================
	public static By BUTTON_DROPDOWN = By.xpath("//a[@id='dropdownMenuLink']");
	public static By BUTTON_LOGOUT = By.xpath("//button[text()='Đăng xuất' and @class='dropdown-item']");
	public static By BUTTON_LOGOUTPOPUP = By.xpath("//button[@form='logout' and @class='btn btn-success']");

}
