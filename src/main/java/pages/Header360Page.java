package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class Header360Page extends BasePage {
	
	@FindBy(xpath = "//div[@data-test='info_tariffs-nav-button']")
	public WebElement prices;

	public Header360Page(WebDriver driver) {
		super(driver);
	}

	public void openPricesScreen() {
		prices.click();
		switchToLastWindowHandle(driver);
	}
}
