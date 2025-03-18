package testscripts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import pages.BusinessPricesPage;
import pages.StartPage;

import org.junit.jupiter.api.Test;

public class ActivatePromoTest extends BaseTest {

	private static final String notExistingPromo = "notexistingpromo";
	private static final String url = "https://ya.ru/";

	@Test
	@DisplayName("Проверка совпадения ошибок при некорректном промокоде на экране тарифов Бизнес 360 и Пользователям")
	public void errorsForBusinessAndConsumerEqualWhenPromoIsNotValid() throws Exception {
		
		StartPage startPage = new StartPage(getDriver());
		
		String errorMessageOnBusiness = startPage
				.open(url)
				.selectServicesMenu()
				.openBusiness360Screen()
				.openBusinessPricesScreen()
				.openActivatePromocodeScreen()
				.fillInPromocode(notExistingPromo)
				.getErrorMessageAndClose();

		BusinessPricesPage businessPricesPage = new BusinessPricesPage(getDriver());
		
		String errorMessageOnCustomer = businessPricesPage
				.openConsumerPage()
				.openConsumerPricesScreen()
				.openActivatePromocodeScreen()
				.fillInPromocode(notExistingPromo)
				.getErrorMessage();
		
		assertEquals(errorMessageOnBusiness, errorMessageOnCustomer,
				String.format(
						"Текст ошибки на странице для бизнеса - %s - "
								+ "не равен тексту ошибки на странице для пользователей" + " - %s ",
						errorMessageOnBusiness, errorMessageOnCustomer));
	}
}
