package ramesh.selenium.chapters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DriverCommands {
	WebDriver driver;
	String url;

	@BeforeClass
	public void setUp() {
		// Create a new instance of the FireFox driver
		driver = new FirefoxDriver();

		// Storing the Application Url in the String variable
		url = "http://store.demoqa.com";
	}

	private void customWait(long n) {
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
	}
	
	 private void windowMaximize(){
		driver.manage().window().maximize();
	}	

	@Test(priority = 1)
	public void comands1() {
		// Launch the ToolsQA WebSite
		driver.get(url);
		customWait(5);
		windowMaximize();
		

		// Storing Title name in the String variable
		String title = driver.getTitle();
//	  String title1 = driver.getTitle();   New variable with new value.
		

		// Storing Title length in the Int variable
		int titleLength = driver.getTitle().length();

		// Printing Title & Title length in the Console window
		System.out.println("Title of the page is : " + title);
		System.out.println("Length of the title is : " + titleLength);

		// Storing URL in String variable
		String actualUrl = driver.getCurrentUrl();

		if (actualUrl.contains(url)) {
			System.out.println("Verification Successful - The correct Url is opened.");
		} else {
			System.out.println("Verification Failed - An incorrect Url is opened.");

			// In case of Fail, you like to print the actual and expected URL
			// for the record purpose
			System.out.println("Actual URL is : " + actualUrl);
			System.out.println("Expected URL is : " + url);

			// Storing Page Source in String variable
			String pageSource = driver.getPageSource();

			// Storing Page Source length in Int variable
			int pageSourceLength = pageSource.length();

			// Printing length of the Page Source on console
			System.out.println("Total length of the Pgae Source is : "

					+ pageSourceLength);

		}
	}

	@Test(priority = 2)
	public void commands2() {
		url = "http://demoqa.com/frames-and-windows/";
		driver.navigate().to(url);
		customWait(5);
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='tabs-1']/div/p/a")).click();

		// Open ToolsQA web site
		String appUrl = "http://www.DemoQA.com";
		driver.get(appUrl);

		// Click on Registration link
		driver.findElement(By.xpath(".//*[@id='menu-item-374']/a")).click();

		// Go back to Home Page
		driver.navigate().back();

		// Go forward to Registration page
		driver.navigate().forward();

		// Go back to Home page
		driver.navigate().to(appUrl);

		// Refresh browser
		driver.navigate().refresh();

	}

	@AfterClass
	public void tearDown() {
		// Closing browser
		driver.close();
		// driver.quit();
	}
}
