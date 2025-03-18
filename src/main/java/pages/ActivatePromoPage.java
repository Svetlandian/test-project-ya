package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ActivatePromoPage extends BasePage {
	
	@FindBy(xpath = "//input[contains(@placeholder, 'Введите промокод')]")
	public WebElement promoField;
	
	@FindBy(xpath = "//span[contains(text(), 'Активировать')]")
	public WebElement activateButton;
	
	@FindBy(xpath = "//span[contains(@class, 'Textinput-Hint')]")
	public WebElement messageHint;
	
	@FindBy(xpath = "//button[contains(@class, 'closeIcon')]")
	public WebElement closeButton;
	
	public ActivatePromoPage(WebDriver driver) {
		super(driver);
	}

	@Step("Ввести промокод {promo}")
	public ActivatePromoPage fillInPromocode(String promo) {
		promoField.sendKeys(promo);
		Actions actions = new Actions(driver);
    	actions.moveToElement(activateButton).click().build().perform();
		return this;
	}
	
	@Step("Получить текст ошибки и закрыть окно активации промокода")
	public String getErrorMessageAndClose() throws InterruptedException {
		String message = getErrorMessage();
		closeButton.click();
		switchToLastWindowHandle(driver);
		return message;
	}
	
	@Step("Получить текст ошибки")
	public String getErrorMessage() throws InterruptedException {
		return messageHint.getText();
	}
}
