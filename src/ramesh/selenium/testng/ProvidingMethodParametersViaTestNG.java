package ramesh.selenium.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class ProvidingMethodParametersViaTestNG {

	private static WebDriver driver;

	@Test

	@Parameters({ "sUsername", "sPassword" })

	public void test(String sUsername, String sPassword) {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.store.demoqa.com");

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		driver.findElement(By.id("log")).sendKeys(sUsername);

		driver.findElement(By.id("pwd")).sendKeys(sPassword);

		driver.findElement(By.id("login")).click();

		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

		driver.quit();

	}

}

/** Sample TestNG.xml for above mentioned class:
 * <suite name="Suite">

    <test name="ToolsQA">

	<parameter name="sUsername" value="testuser_1"/>

	<parameter name="sPassword" value="Test@123"/>

		<classes>

		    <class name="ramesh.selenium.testng.ProvidingMethodParametersViaTestNG" />

		</classes>

    </test>

</suite>
 */

