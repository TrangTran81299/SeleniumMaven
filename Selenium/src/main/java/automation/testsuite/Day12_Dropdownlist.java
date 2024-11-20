package automation.testsuite;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class Day12_Dropdownlist extends CommonBase {
	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.codeStarCourse);
	}

	@Test
	public void chooseVietNamOption() {
		Select courseDropdown = new Select(driver.findElement(By.id("product_categories_filter")));
		// Cach1: selectByVisibleText
		courseDropdown.selectByVisibleText(" Kiểm thử");
		String text1 = courseDropdown.getFirstSelectedOption().getText();
		System.out.println("courseDropdown.getFirstSelectedOption: " + text1);
		// Cach2: selectByValue
		courseDropdown.selectByValue("https://codestar.vn/product-category/lap-trinh-web/");
		String text2 = courseDropdown.getFirstSelectedOption().getText();
		System.out.println("courseDropdown.getFirstSelectedOption: " + text2);
		// Cach3: selectByIndex
		courseDropdown.selectByIndex(4);
		String text3 = courseDropdown.getFirstSelectedOption().getText();
		System.out.println("courseDropdown.getFirstSelectedOption: " + text3);

	}
}
