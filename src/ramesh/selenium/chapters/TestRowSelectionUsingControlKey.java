package ramesh.selenium.chapters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestRowSelectionUsingControlKey {

	static public WebDriver driver;

	static public void waitImplicit(long n) {

		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
	}

	public static void main(String arg[]) {
		driver = new FirefoxDriver();
		String url = "http://demoqa.com/selectable/";
		driver.get(url);
		waitImplicit(15);
		driver.manage().window().maximize();
		Actions builder = new Actions(driver);
		WebElement tablerow1 = driver.findElement(By.xpath(".//*[@id='selectable']/li[1]"));
		WebElement tablerow2 = driver.findElement(By.xpath(".//*[@id='selectable']/li[2]"));

		builder.moveToElement(tablerow1).click(tablerow1).keyDown(Keys.CONTROL).click(tablerow2).keyUp(Keys.CONTROL)
				.build().perform();
		waitImplicit(5);
		
		if (tablerow1.getAttribute("class").toString().contains("selected")
				&& tablerow2.getAttribute("class").toString().contains("selected")) {
			System.out.println("Test case passed: Both elements have selected");
		} else {
			System.out.println("Test case failed: Both elements have not selected");
		}

		driver.close();

	}
}