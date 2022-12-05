package bank.app.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BankProjectMain {

	public static void main(String[] args) {

		try {
			// create an object of FileInputStream class to read excel file
			FileInputStream fis = new FileInputStream("C:\\Users\\shirv\\OneDrive\\Documents\\Test-Data.xlsx");
			// creating workbook instance that refers to .xls file
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			// creating a Sheet object
			XSSFSheet sheet = workbook.getSheet("LoginData");
			// get all rows in the sheet
			Iterator<Row> rows = sheet.rowIterator();
			XSSFRow row;
			while(rows.hasNext()) {
				row = (XSSFRow) rows.next();
				XSSFCell cell =row.getCell(0);
				System.out.println("The cell is "+cell);
				if (row.getCell(0).getStringCellValue().equalsIgnoreCase("chrome")) {
					System.setProperty("windows.chrome.driver", "C://WebDrivers//chromedriver.exe");

					WebDriver driver = new ChromeDriver();

					//String URL = "https://demo.guru99.com/Agile_Project/Agi_V1/";
					driver.get(row.getCell(1).getStringCellValue());

					driver.manage().window().maximize();

					LoginTest login = new LoginTest();
					CustomerTest customerTest = new CustomerTest();

					login.testLogin(driver,row);
					customerTest.miniStatement(driver,row);

					driver.quit();
				} else if (row.getCell(0).getStringCellValue().equalsIgnoreCase("firefox")) {
					System.setProperty("windows.firefox.driver", "C://WebDrivers//geckodriver.exe");

					WebDriver driver = new FirefoxDriver();

					//String URL = "https://demo.guru99.com/Agile_Project/Agi_V1/";
					driver.get(row.getCell(1).getStringCellValue());

					driver.manage().window().maximize();

					LoginTest login = new LoginTest();
					CustomerTest customerTest = new CustomerTest();

					login.testLogin(driver,row);
					customerTest.miniStatement(driver,row);

					driver.quit();
				}
			}
			
			//int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();

			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
