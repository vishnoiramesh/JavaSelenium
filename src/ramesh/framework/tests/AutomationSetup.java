package ramesh.framework.tests;


import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import ramesh.framework.commonLib.Common;

public class AutomationSetup {
	
	@BeforeSuite
	@Parameters({"browser", "profile", "chromeDriver", "url", "objectMapFile", "testDataFile", "pageLaodTimeOut", "implicitWaitTimeOut"})
	public void setup(String browser, String profile, String chromeDriver, String url, String objectMapFile, String testDataFile, String pageLaodTimeOut, String implicitWaitTimeOut) throws IOException{
		
		Common.setTestDataFile(testDataFile);
		Common.setObjectMapFile(objectMapFile);
		
		Common.launchBrowser(browser, profile, chromeDriver);
		
		Common.launchUrl(url);
		
		Common.setTimeOuts(Integer.parseInt(implicitWaitTimeOut), Integer.parseInt(implicitWaitTimeOut));

	}
}
