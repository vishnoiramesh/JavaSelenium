package ramesh.selenium.chapters;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Log4jExample {

	private static WebDriver driver;
@Test
	public void testMethod() {

		DOMConfigurator.configure("log4j.xml");
		Logger log = Logger.getLogger(Log4jExample.class.getName());

		// This code is to generate additional custom files along with already
		// set in log4j.xml
		FileAppender fileAppender = new FileAppender();
		ConsoleAppender consoleAppender = new ConsoleAppender();

		fileAppender.setFile("logfile.txt");

		fileAppender.setLayout(new SimpleLayout());
		consoleAppender.setLayout(new PatternLayout("%d %-5p [%c{1}] %m %n"));

		log.addAppender(fileAppender);
		log.addAppender(consoleAppender);

		consoleAppender.activateOptions();
		fileAppender.activateOptions();

		// Create a new instance of the Firefox driver

		driver = new FirefoxDriver();

		log.info("New driver instantiated");

		// Put a Implicit wait, this means that any search for elements on the
		// page could take the time the implicit wait is set for before throwing
		// exception

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		log.info("Implicit wait applied on the driver for 10 seconds");

		// Launch the Online Store Website

		driver.get("http://store.demoqa.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.info("Web application launchedand browser window maximized");

		// Find the element that's ID attribute is 'account'(My Account)

		driver.findElement(By.className("account_icon")).click();

		log.info("Click action performed on My Account link");

		// Find the element that's ID attribute is 'log' (Username)

		// Enter Username on the element found by above desc.

		driver.findElement(By.id("log")).sendKeys("testuser_1");

		log.info(
				"Username entered in the Username text box. This will be printed when your log mode is info in your log.xml file");
		log.debug("When you enable log mode as debug in log.xml then only you will see that you are line no 59");
		// Find the element that's ID attribute is 'pwd' (Password)

		// Enter Password on the element found by the above desc.

		driver.findElement(By.id("pwd")).sendKeys("Test@123");

		log.info("Password entered in the Password text box");

		// Now submit the form. WebDriver will find the form for us from the
		// element
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		driver.findElement(By.id("login")).click();

		log.info("Click action performed on Submit button");

		// If user credentials are not valid then Error message will be shown.
		// Handle that case here by Exception handling.
		try {
			// Find the element that's ID attribute is 'account_logout' (Log
			// Out)
			driver.findElement(By.id("account_logout"));
			log.info("Click action performed on Log out link");
			// Print a Log In message to the screen
			System.out.println("Login was Successful.");
		} catch (NoSuchElementException nse) {
			nse.getMessage();
			log.info("Could not login. Invalid credentials");
			driver.findElement(By.linkText("Register"));
			log.info("At Register new user page");
		} catch (Exception e) {
			log.info("Could not login. Invalid credentials");
			e.getMessage();
		}

		// If login successful then there will be no exception and flow can go
		// ahead.
		// Close the driver

		Reporter.log("If you use log method of Reporter class then this log will be added to TestNG report fille @ test-output/emailabletestNGReport.html.");

		driver.quit();

		log.info("Browser closed");

	}

}
