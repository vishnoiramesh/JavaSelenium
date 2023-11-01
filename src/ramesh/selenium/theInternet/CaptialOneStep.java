package ramesh.selenium.theInternet;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

class CapitalOnePage {
	WebDriver driver;
	String pgURL;

	public CapitalOnePage(String pgURL, WebDriver driver) {
		this.driver = driver;
		this.pgURL = pgURL;
		// driver = new FirefoxDriver();
		driver.get(pgURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("You are on CapitalOne HomePage");

	}

	// handlingMultipleBrowsers
	public void clickChildBrowser(String investLk, String planurTrip, String planCalculator) {
		// Parent window initially is active due to calling get(URL) in
		// constructor. Save the handle for future use.
		String ParentBrowser = driver.getWindowHandle();
		Actions action = new Actions(driver);
		WebElement investMenu = driver.findElement(By.linkText(investLk));
		action.moveToElement(investMenu).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement PlanRetirementLink = driver.findElement(By.linkText(planurTrip));
		PlanRetirementLink.click();
		System.out.println("Click on Plan Retirement Link :" + PlanRetirementLink);

		// get the Browser 1 info
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		String newChilWindowOnBrowser = driver.getWindowHandle();
		driver.switchTo().window(newChilWindowOnBrowser);
		

		// WebElement planYourTripLink = driver.findElement(By.linkText("Plan
		// Your Retirement"));
		// planYourTripLink.click();
		// System.out.println("Click on Plan Your Trip Link" + planurTrip);

		/*
		 * Looping is not required as only 2 windows are there which can easily
		 * be handled by 2 variables. If you wish to handle multiple windows in
		 * loop to switch then put the required flow and clicking code in that
		 * loop itself. If you don't perform any action after switching then
		 * there is no use of switching. For example if you go to home of 3
		 * friends in sequence and return back to your home but if don't do
		 * anything there then there is no use of going there.
		 * 
		 */
		// get All the browser info
		// Set<String> allBrowsers = driver.getWindowHandles();
		// // Exclude browser -1 info in the above info
		// for (String eachBrowser : allBrowsers) {
		// if (!(eachBrowser.equals(ParentBrowser))) {
		// driver.switchTo().window(eachBrowser);
		// The operations like click and verify may come here if you wish to use
		// loop.
		// break;
		// }
		// }

		WebElement planToolTab = driver.findElement(By.xpath(planCalculator));
		planToolTab.click();
		System.out.println("Enter 3rd window with retiremyway.com link" + planCalculator);
		String newChilWindowOnBrowser2 = driver.getWindowHandle();
		driver.switchTo().window(newChilWindowOnBrowser2);
		driver.findElement(By.linkText("Accept"));

		// Here remaining code will be there.

		// If you wish to close the current window the use driver.close() and
		// then use driver.swithc.window(newChilWindowOnBrowser or parentWindow
		// as per need)

		driver.switchTo().window(ParentBrowser);

	}

}

public class CaptialOneStep {
	static WebDriver driver;
	static String pageURL;

	public static void main(String[] args) {
		driver = new FirefoxDriver();
		pageURL = "https://www.capitalone.com/";

		CapitalOnePage capitalOnePg = new CapitalOnePage(pageURL, driver);

		String selectInvestLk = new String("Invest");
		String selectPlanurTrip = new String("Plan Your Retirement");
		String selectPlanCalculator = new String("//*[@id='pyr']/div/a[2]/span/span/span");
		//span[contains(text(),'TRY OUR PLANNING TOOL')]
		capitalOnePg.clickChildBrowser(selectInvestLk, selectPlanurTrip, selectPlanCalculator);
	}
}