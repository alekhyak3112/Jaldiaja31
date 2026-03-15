package org.Global;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager; // 9884291190 

public class SeleniumBase {

	public static WebDriver driver;
	public JavascriptExecutor javascriptExecutor;
	public TakesScreenshot takesScreenshot;

	public static void getBrowser(String browserType) {

		try {

			switch (browserType) {
			case "Firefox":

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

				break;

			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
				

			default:
				System.err.println("Invalid Browser Type");
				break;
			}

		} catch (SessionNotCreatedException e) {

			System.out.println("Check driver and browser" + e.getMessage());
			e.printStackTrace();
		}

		catch (WebDriverException e) {

			System.out.println("Check driver " + e.getMessage());
			e.printStackTrace();
		}

	}

	public void windMax() {
		driver.manage().window().maximize();
	}

	public void getApplication(String url) {
		driver.get(url);

	}

	public static void sendkeysByJava(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);

	}

	public void clickByJava(WebElement element) {
		element.click();
	}

	public void sendkeysByJSE(WebElement element, String keysToSend) {

		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].setAttribute('value','  " + keysToSend + " ')", element);

	}

	public void clickByJSE(WebElement element) {
		try {

			javascriptExecutor = (JavascriptExecutor) driver;
			javascriptExecutor.executeScript("arguments[0].click()", element);

		} catch (JavascriptException e) {

		} catch (Exception e) {

		}

	}

	public void screenCapture(String refname) {

		try {

			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("target\\" + refname + ".png");
			FileUtils.copyFile(sourceFile, targetFile);

		} catch (Exception e) {
			System.out.println("");

		}

	}

	public void screenCapture2() {

		try {

			takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File targetFile = new File("target\\" + System.currentTimeMillis() + ".png");
			FileUtils.copyFile(sourceFile, targetFile);

		} catch (Exception e) {
			System.out.println("");

		}

	}

	public void moveToElement(WebElement element) {

		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}

	public void windowsHandling(int requiredWindowsIndexNumber) {

		try {

			String currentWindowsID = driver.getWindowHandle();

			Set<String> allwindowsID = driver.getWindowHandles();

			List<String> list = new LinkedList<>();
			list.addAll(allwindowsID);

			// To get Single Windows Id from list
			String requiredWindowsID = list.get(requiredWindowsIndexNumber);

			// To Switch to Windows
			driver.switchTo().window(requiredWindowsID);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public String getWindowsID(int requiredWindowsIndexNumber) {

		String requiredWindowsID = null;
		try {

			String currentWindowsID = driver.getWindowHandle();

			Set<String> allwindowsID = driver.getWindowHandles();

			List<String> list = new LinkedList<>();
			list.addAll(allwindowsID);

			// To get Single Windows Id from list
			requiredWindowsID = list.get(requiredWindowsIndexNumber);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return requiredWindowsID;

	}

	public void switchToWindows(String requiredWinsdowsID) {

		driver.switchTo().window(requiredWinsdowsID);
	}

	public String getDataFromExcelSheet(String sheetName, int rownum, int cellnum) throws IOException {

		String requiredDatasfromExcel = "";
		try {

			// To Locate where the file will be
			File file = new File("DataBase\\Logins.xlsx");

			// To get File as a Input Data from location
			FileInputStream fileInputStream = new FileInputStream(file); // throws FileNotFoundException

			// To Define Workbook
			Workbook book = new XSSFWorkbook(fileInputStream); // throws IOException

			// To get Sheet from Workbook
			Sheet sheet = book.getSheet(sheetName);

			// To get Row from Sheet
			Row row = sheet.getRow(rownum);

			// To get Cell from Row
			Cell cell = row.getCell(cellnum);

			// To find Cell Type
			CellType cellType = cell.getCellType();

			switch (cellType) {
			case STRING:

				// To get String kind of values
				requiredDatasfromExcel = cell.getStringCellValue();

				break;

			case NUMERIC:

				// It find Date formated values
				if (DateUtil.isCellDateFormatted(cell)) {
					// to get Date values
					Date dateCellValue = cell.getDateCellValue();

					// To arrange Date format requirements
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					requiredDatasfromExcel = simpleDateFormat.format(dateCellValue);

				} else {

					// To get Numeric cell value
					double numericCellValue = cell.getNumericCellValue();
					BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
					requiredDatasfromExcel = valueOf.toString();

				}

				break;

			default:
				System.out.println("No Datas");
				break;
			}

		} catch (Exception e) {

		}

		return requiredDatasfromExcel;
	}

	public String getDataFromPropertyFile(String propertyKey) throws IOException {

		String property = null;
		try {

			// To Locate where the file will be
			File file = new File("DataBase\\Config.properties");

			// To get File as a input
			FileReader fileReader = new FileReader(file); // throws FileNotFoundException

			Properties properties = new Properties();

			properties.load(fileReader); // throws IOException

			property = properties.getProperty(propertyKey);

		} catch (Exception e) {
			
		}

		return property;

	}
	
	public static void refresh() {

		driver.navigate().refresh();
	}
	
	

}