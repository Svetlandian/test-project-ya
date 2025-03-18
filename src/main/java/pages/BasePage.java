package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

abstract class BasePage {
	protected WebDriver driver;
	
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

	protected void switchToLastWindowHandle(WebDriver driver) {
		Object[] windowHandles = driver.getWindowHandles().toArray();
		driver.switchTo().window((String) windowHandles[windowHandles.length - 1]);
	}
}
