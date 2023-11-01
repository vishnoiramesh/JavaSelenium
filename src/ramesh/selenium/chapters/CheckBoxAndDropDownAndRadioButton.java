package ramesh.selenium.chapters;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckBoxAndDropDownAndRadioButton {
	WebDriver driver;
	String url;

	@BeforeClass
	public void setUp() {
		// Create a new instance of the FireFox driver
		driver = new FirefoxDriver();

		// Storing the Application Url in the String variable
		url = "http://toolsqa.com/automation-practice-form";
		driver.get(url);
		driver.manage().window().maximize();
		customWait(5);
	}

	private void customWait(long n) {
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void comands1() {
		// Step : Select the de-selected Radio button (female) for category Sex
		// (Use IsSelected method)
		// Storing all the elements under category 'Sex' in the list of
		// WebLements
		List<WebElement> rdBtn_Sex = driver.findElements(By.name("sex"));

		// Create a boolean variable which will hold the value (True/False)
		boolean bValue = false;

		// This statement will return True, in case of first Radio button is
		// selected
		bValue = rdBtn_Sex.get(0).isSelected();

		// This will check that if the bValue is True means if the first radio
		// button is selected
		if (bValue == true) {
			// This will select Second radio button, if the first radio button
			// is selected by default
			rdBtn_Sex.get(1).click();
		} else {
			// If the first radio button is not selected by default, the first
			// will be selected
			rdBtn_Sex.get(0).click();
		}

		// Step: Select the Third radio button for category 'Years of Exp' (Use
		// Id attribute to select Radio button)
		WebElement rdBtn_Exp = driver.findElement(By.id("exp-2"));
		rdBtn_Exp.click();

		// STep: Check the Check Box 'Automation Tester' for category
		// 'Profession'( Use Value attribute to match the selection)
		// Find the Check Box or radio button element by Name
		List<WebElement> chkBx_Profession = driver.findElements(By.name("profession"));

		// This will tell you the number of Check Boxes are present
		int iSize = chkBx_Profession.size();

		// Start the loop from first Check Box to last Check Box.
		for (int i = 0; i < iSize; i++) {
			// Store the Check Box name to the string variable, using 'Value'
			// attribute
			String sValue = chkBx_Profession.get(i).getAttribute("value");

			// Select the Check Box it the value of the Check Box is same what
			// you are looking for
			if (sValue.equalsIgnoreCase("Automation Tester")) {
				chkBx_Profession.get(i).click();
				// This will take the execution out of for loop
				break;
			}
		}
	}

	@Test(priority = 2)
	public void commands2() {
		// Step: Check the Check Box 'Selenium IDE' for category 'Automation
		// Tool' (Use cssSelector)
		WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		oCheckBox.click();

	}

	@Test(priority = 3)
	public void commands3() {
		// Step: Select 'Selenium Commands' Multiple select box ( Use Name
		// locator to identify the element )
		Select oSelect = new Select(driver.findElement(By.name("selenium_commands")));

		// Step: Select option 'Browser Commands' and then de-select it (Use
		// selectByIndex and deselectByIndex)
		oSelect.selectByIndex(0);
		customWait(2);
		oSelect.deselectByIndex(0);

		// Step: Select option 'Navigation Commands' and then deselect it (Use
		// selectByVisibleText and deselectByVisibleText)
		oSelect.selectByVisibleText("Navigation Commands");
		customWait(2);
		oSelect.deselectByVisibleText("Navigation Commands");

		// Step: Print and select all the options for the selected Multiple
		// selection list.
		List<WebElement> oSize = oSelect.getOptions();
		int iListSize = oSize.size();

		// Setting up the loop to print all the options
		for (int i = 0; i < iListSize; i++) {
			// Storing the value of the option
			String sValue = oSelect.getOptions().get(i).getText();

			// Printing the stored value
			System.out.println(sValue);

			// Selecting all the elements one by one
			oSelect.selectByIndex(i);
			customWait(2);

		}
		// Step: Deselect all
		oSelect.deselectAll();
	}

	@AfterClass
	public void tearDown() {
		// Closing browser
		// driver.close();
		// driver.quit();
	}
}
