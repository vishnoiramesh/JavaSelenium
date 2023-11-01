package ramesh.selenium.locatorsInPropertyFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SampleTest {

	private RepositoryParser parser;
	private WebDriver driver;
	private String URL = "http://toolsqa.com/automation-practice-form/";
	private String propertyFilePath = "C:\\Radical\\Workspace\\Test\\src\\ramesh\\selenium\\locatorsInPropertyFile\\PropertyFile.Properties";

	@BeforeClass
	public void setUp() throws IOException {
		driver = new FirefoxDriver();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		parser = new RepositoryParser(propertyFilePath);
	}

	@Test(priority = 1)
	public void EnterValue() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Lets see how we can find the first name field
		WebElement FirstName = driver.findElement(parser.getObjectLocator("FirstName"));
		WebElement LastName = driver.findElement(parser.getObjectLocator("LastName"));
		FirstName.sendKeys("Ramesh");
		LastName.sendKeys("Kumar");
	}

	@Test(priority = 2)
	public void FindPartialLink() {
		WebElement link = driver.findElement(parser.getObjectLocator("PartialLink"));
		link.click();
	}

	@AfterClass
	public void tearDown() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.quit();
	}

}