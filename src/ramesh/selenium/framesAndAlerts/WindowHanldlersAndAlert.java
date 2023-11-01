package ramesh.selenium.framesAndAlerts;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WindowHanldlersAndAlert {
	public static WebDriver driver;

	@Test(priority = 1)
	public void Test() {

		// Create a new instance of the Firefox driver
		driver = new FirefoxDriver();

		// Launch the URL
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();

		// Put an Implicit wait, this means that any search for elements on the
		// page could take the time the implicit wait is set for before throwing
		// exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Store and Print the name of the First window on the console
		String handle = driver.getWindowHandle();

		System.out.println(handle);

		// Click on the Button "New Message Window"
		driver.findElement(By.xpath(".//*[@id='content']/p[3]/button")).click();

		// Store and Print the name of all the windows open
		Set<String> handles = driver.getWindowHandles();

		System.out.println(handles);

		// Pass a window handle to the other window

		for (String handle1 : driver.getWindowHandles()) {

			System.out.println(handle1);

			driver.switchTo().window(handle1);

			driver.switchTo().defaultContent();
		}

		// Closing Pop Up window

		// driver.close();

		// Close Original window

		// driver.quit();

	}

	@Test(priority = 1)
	public void Test2() {

		driver = new FirefoxDriver();
		// Launch the URL
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on the Button "Alert Box"
		driver.findElement(By.id("alert")).click();

		// Switch to JavaScript Alert window
		Alert myAlert = driver.switchTo().alert();

		// Accept the Alert

		myAlert.accept();

		// myAlert.dismiss();
		// myAlert.sendkeys("Enters text in text box.")
		// myAlert.getText();
		// Close Original window

		// driver.close();

	}

}