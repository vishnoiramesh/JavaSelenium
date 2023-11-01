package ramesh.selenium.browser;

import java.io.File;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class SimpleBrowserHandling {
	@Test
	public void setBrowser() {
		
		String browserName =  "Chrome";     
		// Provide value "Firefox" OR "Chrome"
		
		WebDriver driver;

		if (browserName.equals("Firefox")) {
			// To launch a specific profile of firefox.
			FirefoxProfile profile = new FirefoxProfile(
					new File(
							"C://Users//1023524//AppData//Roaming//Mozilla//Firefox//Profiles//78j75slm.default"));

			// If your firefox is not installed at default location.
			FirefoxBinary firefoxBinary = new FirefoxBinary(new File(
					"C://Program Files//Mozilla Firefox//firefox.exe"));
			driver = new FirefoxDriver(firefoxBinary, profile);

			// To get or change a setting of your browser using code.
			DesiredCapabilities capability = DesiredCapabilities.firefox();
			capability.setBrowserName(browserName);
			capability.setPlatform(Platform.WINDOWS);

		} else if (browserName.equals("Chrome")) {
			driver = new ChromeDriver();
			System.setProperty("webdrive.chorme.driver",
					"C://WS//Automation//AA_Libraries//chromedriver_linux32//chromedriver");
//			System.setProperty("webdrive.chorme.driver",
//					"C:/WS/Automation/AA_Libraries/chromedriver_linux32/chromedriver");
		} else {
			// If you are using IE.
			System.setProperty("webdrive.ie.driver",
					"Download the IE driver from Slenium website and put the path"
							+ "of exe file with filename and extension");
			driver = new InternetExplorerDriver();
		}

		driver.get("www.google.com");
	}
}
