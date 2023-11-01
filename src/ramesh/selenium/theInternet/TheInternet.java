package ramesh.selenium.theInternet;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
// import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.security.Credentials;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TheInternet {
//ProfilesIni profile = new ProfilesIni();
//FirefoxProfile firefoxProfile = profile.getProfile("vwig3zvq.Selenium");
//	FirefoxProfile firefoxProfile = new FirefoxProfile (
//			new File ("C://Users//1023524//AppData//Roaming//Mozilla//Firefox//Profiles//78j75slm.default"));
//	WebDriver driver = new FirefoxDriver(firefoxProfile);
	String URL = "http://the-internet.herokuapp.com/";
	WebDriver driver;
	String driverPath = "C://WS//Lib//Chrome Driver 116_Aug_2023//";

	@BeforeMethod
	public void setUp() {
	//	System.setProperty("webdriver.gecko.driver","C://WS//Automation//AA_Libraries//geckodriver33_64//geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		// Wait for page to be loaded.
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement elementClickable = driver.findElement(By
				.linkText("A/B Testing"));
		wait.until(ExpectedConditions.elementToBeClickable(elementClickable));
	}

	public void customWait(long TimeOutinSeconds) {
		try {
			long TimeOutinMillis = TimeOutinSeconds * 1000;
			Thread.sleep(TimeOutinMillis);
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
	}

	@Test
	public void abTesting() {
		// Find and click on link.
		driver.findElement(By.linkText("A/B Testing")).click();
		customWait(1);
		String actualText = "Also known as split testing. This is a way in which businesses are able to simultaneously test"
				+ " and learn different versions of a page to see which text and/or functionality works best towards a desired outcome"
				+ " (e.g. a user action such as a click-through).";
		boolean expectedTextFound = driver.getPageSource().contains(actualText);
		// The test case would be passed if expected text were found.
		Assert.assertTrue(expectedTextFound,
				"The expected text not found at page in test abTesting.");
	}

	@Test
	public void basicAuthPositive() {
		try {
			driver.findElement(By.partialLinkText("Basic Auth")).click();
			customWait(3);
			Alert authenticationAlert = driver.switchTo().alert();
			Credentials credentials = new UserAndPassword("admin", "admin");
			authenticationAlert.authenticateUsing(credentials);
			authenticationAlert.accept();
			customWait(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String actualText = "Congratulations! You must have the proper credentials.";
		boolean expectedTextFound = driver.getPageSource().contains(actualText);
		// The test case would be passed if expected text were found.
		Assert.assertTrue(expectedTextFound,
				"The expected text not found at page in test abTesting.");
		Assert.assertTrue(expectedTextFound,
				"The expected text not found at page in test abTesting.");
	}

	@Test
	public void basicAuthNegative() {
		try {
			driver.findElement(By.partialLinkText("Basic Auth")).click();
			customWait(3);
			Alert authenticationAlert = driver.switchTo().alert();
			authenticationAlert.dismiss();
			customWait(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		String actualText = "Not authorized ";
		boolean expectedTextFound = driver.getPageSource().contains(actualText);
		// The test case would be passed if expected text were found.
		Assert.assertTrue(expectedTextFound,
				"The expected text not found at page in test abTesting.");
		Assert.assertTrue(expectedTextFound,
				"The expected text not found at page in test abTesting.");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		System.out.println("Tear Down method is ending your test execution.");
	}
}
