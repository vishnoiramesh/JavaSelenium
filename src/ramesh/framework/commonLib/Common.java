package ramesh.framework.commonLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Common {

	private static Properties objectMapProps;
	private static XSSFSheet sheet;
	private static WebDriver driver;
	private static FileInputStream fis;
	private static String URL;

	public static void sleep(int millSec) {
		try {
			Thread.sleep(millSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void launchBrowser(String browser, String profile,
			String chromeDriver) {
		if (browser.contains("firefox")) {
//			FirefoxBinary bin = new FirefoxBinary(new File(browser));
//			FirefoxProfile prof = new FirefoxProfile(new File(profile));
//			driver = new FirefoxDriver(bin, prof);
		driver = new FirefoxDriver();
			
			return;
		}

		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", chromeDriver);
			driver = new ChromeDriver();
			return;
		}

		if (driver == null) {
			throw new RuntimeException(
					"Unable to determine browser type from path:" + browser);
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void launchUrl(String url) {
		driver.get(url);
		URL = url;
	}

	public static void launchUrl() {
		driver.get(URL);
	}

	public static void setTimeOuts(int pageLoadTimeOutInSec,
			int implicitWaitInSec) {
		driver.manage().timeouts()
				.pageLoadTimeout(pageLoadTimeOutInSec, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(implicitWaitInSec, TimeUnit.SECONDS);
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void quit() {
		try {
			fis.close();
			driver.quit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This method load the properties file into memory.
	 * 
	 * @param configFilePath
	 * @throws IOException 
	 */
	public static void setObjectMapFile(String configFilePath) throws IOException {
		objectMapProps = new Properties();
		InputStream fis;
		try {
			fis = new FileInputStream(configFilePath);
			objectMapProps.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
//		String myFile = "c:/MyFile";
//		Properties prop = new Properties();
//		FileInputStream f1 = new FileInputStream(myFile);
//		prop.load(f1);
//		
		
	}

	public static String getObjectValue(String objectName) {
		return objectMapProps.getProperty(objectName);
	}

	public static void setTestDataFile(String testDataFilePath) {

		try {
			File file = new File(testDataFilePath);
			fis = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getTestData(String testCaseName) {
		ArrayList<String> testData = new ArrayList<String>();

		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (rowIterator.hasNext()) {
				Cell c = cellIterator.next();
				testData.add(c.toString());
			}
			// Remove the element from Array List if it contains test case name
			// as header.
			if (testData.get(0).equals(testCaseName)) {
				testData.remove(testCaseName);
				return testData;
			}
			testData = null;
			testData = new ArrayList<String>();
		}
		return testData;
	}

	public static void captureScreenshot(String screenshotFilePath) {
		try {
			// Take the screenshot as File and cast it into File which is in
			// memory.
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			// Copy the file from memory to physical disk.
			FileUtils.copyFile(scrFile, new File(screenshotFilePath));
			// Message to user.
			System.out.println("Saved screenshot: " + screenshotFilePath);
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Failed to capture screenshot to file : "
					+ screenshotFilePath);
			npe.printStackTrace();
		}
	}
}

// Reference: http://www.concretepage.com/apache-api/read-write-and-update-xlsx-using-poi-in-java