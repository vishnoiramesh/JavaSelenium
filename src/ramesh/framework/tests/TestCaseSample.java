package ramesh.framework.tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ramesh.framework.commonLib.Common;

public class TestCaseSample {
	
	@Test
	public void enterEmpData(){
		ArrayList<String> testData = Common.getTestData("Test Case Name");
		
		WebDriver driver = Common.getDriver();

		String frameId = Common.getObjectValue("EMPLOYMENT_FRAME_ID");		
		WebElement frame = driver.findElement(By.id(frameId));		
		driver.switchTo().frame(frame);
		
		Common.sleep(2000);
		
		String positionId = Common.getObjectValue("EMPLOYMENT_POSITION_ID");
		WebElement positionList = driver.findElement(By.id(positionId));
		Select position = new Select(positionList);
		position.selectByVisibleText(testData.get(0));
		
		String nameId = Common.getObjectValue("EMPLOYMENT_NAME_ID");
		WebElement nameFld = driver.findElement(By.id(nameId)); 
		nameFld.sendKeys(testData.get(1));		
		
		String salaryId = Common.getObjectValue("EMPLOYMENT_SALATY_ID");
		WebElement salaryFld = driver.findElement(By.id(salaryId)); 
		salaryFld.sendKeys(testData.get(2));		
	}
	
	
	@Test
	public void clicMailingList(){
		Common.getDriver().findElement(By.xpath("//a[contains(., 'Mailing List')]")).click();;
	}
}