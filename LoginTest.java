package bank.app.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

	public void testLogin(WebDriver driver) {
		//userID
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys("1303");
		//Password
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys("Guru99");
		//Login Button
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

}
