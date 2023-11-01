package ramesh.selenium.chapters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebElementCommands {
	WebDriver driver;
	String url;

	@BeforeClass
	public void setUp() {
		// Create a new instance of the FireFox driver
		driver = new FirefoxDriver();

		// Storing the Application Url in the String variable
		url = "http://toolsqa.com/Automation-practice-form/";
		driver.get(url);
		driver.manage().window().maximize();
		customWait(5);
	}

	private void customWait(long n) {
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
	}

	@Test(priority = 1, alwaysRun=true)
	public void comands1() {
		// Type Name in the FirstName text box
		driver.findElement(By.name("firstname")).sendKeys("Lakshay");

		// Type LastName in the LastName text box
		driver.findElement(By.name("lastname")).sendKeys("Sharma");

		// Click on the Submit button
		driver.findElement(By.id("submit")).click();
	}

	@Test(priority = 2)
	public void commands2() {
		// Click on "Partial Link Text" link
		driver.findElement(By.partialLinkText("Partial")).click();
		System.out.println("Partial Link Test Pass");

		// Convert element in to a string
		String sClass = driver.findElements(By.tagName("button")).toString();
		System.out.println(sClass);

		// Click on "Link Text" link
		driver.findElement(By.linkText("Link Test")).click();
		System.out.println("Link Test Pass");
	}

	@AfterClass
	public void tearDown() {
		// Closing browser
		// driver.close();
		// driver.quit();
	}
}
