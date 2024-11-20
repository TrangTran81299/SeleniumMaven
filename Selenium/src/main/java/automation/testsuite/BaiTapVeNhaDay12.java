package automation.testsuite;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import automation.common.CommonBase;
import automation.constant.CT_PageURL;

public class BaiTapVeNhaDay12 extends CommonBase{
	@BeforeMethod
	public void openWebPage() {
		driver = initChromeDriver(CT_PageURL.globalsqa);
	}
	
	@Test
	public void chooseSelectCountry() {
		Select countryDropdownList = new Select(driver.findElement(By.xpath("//select")));
		countryDropdownList.selectByValue("ALB");
	}
}
