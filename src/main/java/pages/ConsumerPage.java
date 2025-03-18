package pages;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;

public class ConsumerPage extends BasePage {
	
	public ConsumerPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Открыть вкладку 'Тарифы'")
	public ConsumerPricesPage openConsumerPricesScreen() {
		Header360Page header = new Header360Page(driver);
		header.openPricesScreen();
		return new ConsumerPricesPage(driver);
	}
}
