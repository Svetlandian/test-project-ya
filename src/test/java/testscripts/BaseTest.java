package testscripts;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

abstract class BaseTest {

	private WebDriver driver;
	private final static String optionsFile = "/chrome.properties";
	private static ChromeOptions chromeOptions;

	public WebDriver getDriver() {
		return driver;
	}

	@BeforeAll
	public static void init() {
		chromeOptions = getChromeOptions();
	}

	@BeforeEach
	public void setUp() throws Exception {
		driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10L));
	}

	@AfterEach
	public void tearDown() throws Exception {
		getDriver().quit();
	}

	private static ChromeOptions getChromeOptions() {
		Properties properties = new Properties();

		try (var is = BaseTest.class.getResourceAsStream(optionsFile)) {
			if (is == null)
				throw new RuntimeException("Не удается открыть файл properties");
			properties.load(BaseTest.class.getResourceAsStream(optionsFile));
		} catch (IOException e) {
			throw new RuntimeException("Загрузка properties файла не успешна", e);
		}

		ChromeOptions chromeOptions = new ChromeOptions();
		for (String name : properties.stringPropertyNames()) {
			String value = properties.getProperty(name);
			if (value.toLowerCase().equals("true")) {
				chromeOptions.addArguments(name);
			} else {
				chromeOptions.addArguments(String.format("%s=%s", name, value));
			}
		}

		return chromeOptions;
	}
}
