package automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automation.constant.CT_Account;

public class UserPage {
	private WebDriver driver;

	public UserPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void LogoutFunction() throws InterruptedException {
		WebElement buttonDropdown = driver.findElement(CT_Account.BUTTON_DROPDOWN);
		if (buttonDropdown.isDisplayed()) {
			buttonDropdown.click();
		}
		Thread.sleep(500);
		WebElement buttonLogout = driver.findElement(CT_Account.BUTTON_LOGOUT);
		if (buttonLogout.isDisplayed()) {
			buttonLogout.click();
		}
		Thread.sleep(500);
		WebElement buttonLogoutPopup = driver.findElement(CT_Account.BUTTON_LOGOUTPOPUP);
		if (buttonLogoutPopup.isDisplayed()) {
			buttonLogoutPopup.click();
		}
	}
}
