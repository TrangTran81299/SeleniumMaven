package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class LocatorPractise extends CommonBase {
	@BeforeMethod
	private void openChrome() {
//		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
		driver = initChromeDriver("https://bepantoan.vn/");

	}

	@Test
	private void getLocator() {
		WebElement username = driver.findElement(By.name("email"));
		System.out.println("username is: " + username);
		WebElement password = driver.findElement(By.id("pass"));
		System.out.println("password is: " + password);
		WebElement mobileNumber = driver.findElement(By.name("mobile number"));
		System.out.println("password is: " + mobileNumber);
	}

	@Test
	private void getLocatorBepTu() {
		WebElement linkBepTu = driver.findElement(By.linkText("Bếp Từ"));
		System.out.println("Link bếp từ is: " + linkBepTu);
		WebElement linkMayHutMui = driver.findElement(By.linkText("Máy Hút Mùi"));
		System.out.println("Link máy hút mùi is: " + linkMayHutMui);
		WebElement linkMayRuaChenBat = driver.findElement(By.partialLinkText("Máy Rửa Chén"));
		System.out.println("Link máy rửa chén bát is: " + linkMayRuaChenBat);
	}

}
