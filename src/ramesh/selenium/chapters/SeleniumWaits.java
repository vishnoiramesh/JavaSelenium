package ramesh.selenium.chapters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SeleniumWaits {
	public static WebDriver driver;

	public static void main(String[] args) {

		// Create a new instance of the Firefox driver

		driver = new FirefoxDriver();

		// Launch the URL

		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Click on the Button "Timing Alert"
		// WebElement myElement = driver.findElement(By.name("Timing Alert"));
		// myElement.click();
		driver.findElement(By.name("Timing Alert")).click();
		// Put an Implicit wait, this means that any search for elements on the
		// page could take the time the implicit wait is set for before throwing
		// exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Timer JavaScript Alert is triggered but it is not yet opened");

		// Create new WebDriver wait

		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Wait for Alert to be present
		// ExpectedCondition<Alert, String, int> condition =
		// ExpectedConditions.alertIsPresent();
		// Alert myAlert = wait.until(condition);

		// ExpectedConditions.elementToBeClickable(myElement);
		// ExpectedConditions.titleContains("Google");
		Alert myAlert = wait.until(ExpectedConditions.alertIsPresent());

		System.out.println("Either Pop Up is displayed or it is Timed Out");

		// Accept the Alert

		myAlert.accept();

		System.out.println("Alert Accepted");

		// Close the main window

		driver.close();

		WebElement countdown = driver.findElement(By.name("Timing Alert"));

		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(countdown));

		new FluentWait<WebElement>(countdown).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new Function<WebElement, Boolean>() {
					@Override
					public Boolean apply(WebElement element) {
						return element.getText().contains("Alert");
					}
				});

	}
}