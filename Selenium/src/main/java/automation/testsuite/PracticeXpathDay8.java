package automation.testsuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class PracticeXpathDay8 extends CommonBase {
	@BeforeMethod
	private void openChrome() {
		driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");

	}

	@Test
	private void getLocatorAutomationfc() {
		// Link name
		WebElement linkName = driver.findElement(By.id("name"));
		System.out.println("Link name is: " + linkName);
		// Link address
		WebElement linkAdress = driver.findElement(By.id("address"));
		System.out.println("Link address is: " + linkAdress);
		// Link email
		WebElement linkEmail = driver.findElement(By.id("email"));
		System.out.println("Link address is: " + linkEmail);
		// Link password
		WebElement linkPassword = driver.findElement(By.id("password"));
		System.out.println("Link address is: " + linkPassword);

	}
}
