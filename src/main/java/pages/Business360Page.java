package pages;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class Business360Page extends BasePage {
	public Business360Page(WebDriver driver) {
		super(driver);
	}
	
	@Step("Открыть вкладку 'Тарифы'")
	public BusinessPricesPage openBusinessPricesScreen() {
		Header360Page header = new Header360Page(driver);
		header.openPricesScreen();
		return new BusinessPricesPage(driver);
	}
}
