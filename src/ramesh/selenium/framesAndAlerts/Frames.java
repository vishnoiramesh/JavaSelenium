package ramesh.selenium.framesAndAlerts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Frames {
	@Test(priority = 1)
	public void Test1() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// By executing a java script
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are " + numberOfFrames);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
	}

	@Test(priority = 2)
	public void Test2() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Switch by Index
		driver.switchTo().frame(0);

		driver.switchTo().defaultContent();

		// Switch by frame name
		driver.switchTo().frame("iframe1");

		driver.switchTo().defaultContent();

		// Switch by frame ID
		driver.switchTo().frame("IF1");

		// driver.quit();
	}

	@Test(priority = 3)
	public void Test3() {
		WebDriver driver = new FirefoxDriver();

		// Step 1: Navigate to the page with multiple iframes.
		driver.get("http://toolsqa.com/iframe-practice-page/");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// Step 2: Switch to first frame and then find First Name and Last name
		// element

		/* Switch to the first frame, remember frame index starts from 0 */
		driver.switchTo().frame(0);

		/* now find the First name field */
		WebElement firstName = driver.findElement(By.xpath(".//*[@id='content']/form/fieldset/div[1]/strong[1]"));

		/* now find the Last name field */
		WebElement lastName = driver.findElement(By.xpath(".//*[@id='content']/form/fieldset/div[1]/strong[2]"));

		// Step 3: Fill some value in the first name and last name files
		firstName.sendKeys("Virender");
		lastName.sendKeys("Singh");

		// Step 4: Switching to the 2nd frame, frame index 1
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);

		// Step 5: Find image element and click on that
		WebElement imageElement = driver.findElement(By.xpath(".//*[@id='post-9']/div/div[1]/div/p[1]/a/img"));

		imageElement.click();
		System.out.println("Switching successfull");
	}
}
