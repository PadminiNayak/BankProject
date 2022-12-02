package bank.app.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BankProjectMain {

	public static void main(String[] args) {

		String browserType = "chrome";

		if (browserType.equalsIgnoreCase("Chrome")) {
			System.setProperty("windows.chrome.driver", "C://WebDrivers//chromedriver.exe");

			WebDriver driver = new ChromeDriver();

			String URL = "https://demo.guru99.com/Agile_Project/Agi_V1/";
			driver.get(URL);

			driver.manage().window().maximize();

			LoginTest login = new LoginTest();
			CustomerTest customerTest = new CustomerTest();

			login.testLogin(driver);
			customerTest.miniStatement(driver);

			driver.quit();
		} else if (browserType.equalsIgnoreCase("firefox")) {
			System.setProperty("windows.firefox.driver", "C://WebDrivers//geckodriver.exe");

			WebDriver driver = new FirefoxDriver();

			String URL = "https://demo.guru99.com/Agile_Project/Agi_V1/";
			driver.get(URL);

			driver.manage().window().maximize();

			LoginTest login = new LoginTest();
			CustomerTest customerTest = new CustomerTest();

			login.testLogin(driver);
			customerTest.miniStatement(driver);

			driver.quit();
		}

	}

}
