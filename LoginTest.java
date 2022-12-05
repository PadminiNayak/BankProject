package bank.app.test;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {

	public void testLogin(WebDriver driver,XSSFRow row) {
		//userID
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]/input[1]")).sendKeys(String.valueOf((int)row.getCell(2).getNumericCellValue()));
		//Password
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/input[1]")).sendKeys(row.getCell(3).getStringCellValue());
		//Login Button
		driver.findElement(By.xpath("//tbody/tr[3]/td[2]/input[1]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

}
