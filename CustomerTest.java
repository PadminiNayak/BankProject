package bank.app.test;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CustomerTest {

	public void miniStatement(WebDriver driver,XSSFRow row) {
		// Mini Statement tab
		driver.findElement(By.xpath("//a[contains(text(),'Mini Statement')]")).click();
		// Select the account
		Select select = new Select(driver.findElement(By.xpath("//tbody/tr[6]/td[2]/select[1]")));
		select.selectByVisibleText(String.valueOf((int)row.getCell(4).getNumericCellValue()));
		// Submit
		driver.findElement(By.xpath("//tbody/tr[11]/td[2]/input[1]")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.navigate().back();

		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	}

}
