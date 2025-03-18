package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ConsumerPricesPage extends BasePage {
	
	@FindBy(xpath = "//button[@id='header-promocode-btn']")
	public WebElement promoButton;

	public ConsumerPricesPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Перейти по ссылке 'У меня есть промокод'")
	public ActivatePromoPage openActivatePromocodeScreen() {
		promoButton.click();
		switchToLastWindowHandle(driver);
		return new ActivatePromoPage(driver);
	}
}
