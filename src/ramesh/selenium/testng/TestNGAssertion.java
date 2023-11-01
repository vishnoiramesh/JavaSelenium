package ramesh.selenium.testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.Test;

public class TestNGAssertion {
	private static WebDriver driver;

	@Test
	public void methodToLearnTesNGAssert() {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.store.demoqa.com");

		// Here driver will try to find out My Account link on the application

		WebElement myAccount = driver.findElement(By.xpath(".//*[@id='account']/a"));

		// Test will only continue, if the below statement is true

		// This is to check whether the link is displayed or not

		Assert.assertTrue(myAccount.isDisplayed());
		Assert.assertFalse(!(myAccount.isDisplayed()));
		
		// Assert.assertEquals(actual, expected);
		boolean actual = myAccount.isDisplayed();
		boolean expected = true;
		Assert.assertEquals(actual, expected);
		
		Assert.assertEquals("Ramesh", "Ramesh");
		Assert.assertEquals(100, 100);
		Assert.assertNotEquals(105, 100);

		// My Account will be clicked only if the above condition is true

		myAccount.click();

	}

}
