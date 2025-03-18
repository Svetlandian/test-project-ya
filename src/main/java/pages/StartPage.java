package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class StartPage extends BasePage{
	
	@FindBy(linkText = "Войти")
	public WebElement loginLink;

	@FindBy(xpath = "//a[contains(@title,'Сервисы')]")
	public WebElement servicesMenuLink;

	@FindBy(xpath = "//div[contains(text(), '360 для бизнеса')]")
	public WebElement business360MenuItem;

	public StartPage(WebDriver driver) {
		super(driver);
	}

	@Step("Открыть стартовую страницу {url}")
	public StartPage open(String url) {
		driver.get(url);
		return this;
	}
	
	@Step("Перейти по '360 для бизнеса'")
	public Business360Page openBusiness360Screen() {
		business360MenuItem.click();
		switchToLastWindowHandle(driver);
		return new Business360Page(driver);
	}
	
	@Step("Открыть меню 'Сервисы'")
	public StartPage selectServicesMenu() {
		servicesMenuLink.click();
		return this;
	}
}
