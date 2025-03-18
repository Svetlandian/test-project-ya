package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class FooterPage extends BasePage {

	@FindBy(xpath = "//span[contains(text(), 'Пользователям')]/parent::a")
	public WebElement forConsumerLink;

	public FooterPage(WebDriver driver) {
		super(driver);
	}

	public void openСonsumerScreen() {
		forConsumerLink.click();
		switchToLastWindowHandle(driver);
	}

}
