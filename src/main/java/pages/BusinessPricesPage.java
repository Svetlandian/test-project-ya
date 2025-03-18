package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class BusinessPricesPage extends BasePage {
	
	@FindBy(xpath = "//a[@data-test='promocode-button']")
	public WebElement promoButton;
	
	public BusinessPricesPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Перейти по ссылке 'У меня есть промокод'")
	public ActivatePromoPage openActivatePromocodeScreen() {
		promoButton.click();
		switchToLastWindowHandle(driver);
		return new ActivatePromoPage(driver);
	}
	
	@Step("В footer выбрать ссылку 'Пользователям'")
	public ConsumerPage openConsumerPage() {		
		FooterPage footer = new FooterPage(driver);
		footer.openСonsumerScreen();
		return new ConsumerPage(driver);
	}	
}
