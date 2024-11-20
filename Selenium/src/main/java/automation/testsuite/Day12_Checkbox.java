package automation.testsuite;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Checkbox extends CommonBase {
	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.demoQA);
	}

//	@Test
	public void clickOneCheckbox() throws InterruptedException {
		WebElement sportCheckbox = driver.findElement(By.id("hobbies-checkbox-1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", sportCheckbox);
		} catch (StaleElementReferenceException ex) {
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView(true);", sportCheckbox);
		}
		try {
			if (sportCheckbox.isSelected() == false) {
				sportCheckbox.click();
				System.out.println("Da duoc chon Sport");
			} else {
				System.out.println("Checkbox da  duoc chon mac dinh");
			}
		} catch (Exception e) {
			WebElement lableChb1 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
			lableChb1.click();
		}
	}

	@Test
	public void clickonRadioButton() throws InterruptedException {
		WebElement maleRadio = driver.findElement(By.id("gender-radio-1"));
		try {
			maleRadio.click();
			System.out.println("Da chon Male");
		} catch (Exception e) {
			driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", maleRadio);
		} catch (StaleElementReferenceException ex) {
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView(true);", maleRadio);
		}
	}

	@Test
	public void checkDefaultRadioButton() throws InterruptedException {
		WebElement maleRadio = driver.findElement(By.id("gender-radio-1"));
		WebElement femaleRadio = driver.findElement(By.id("gender-radio-2"));
		WebElement otherRadio = driver.findElement(By.id("gender-radio-3"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", maleRadio);
		} catch (StaleElementReferenceException ex) {
			Thread.sleep(3000);
			js.executeScript("arguments[0].scrollIntoView(true);", maleRadio);
		}
		System.out.println("Male radio button selected: " + maleRadio.isSelected());
		System.out.println("Female radio button selected: " + femaleRadio.isSelected());
		System.out.println("Other radio button selected: " + otherRadio.isSelected());

	}
}
