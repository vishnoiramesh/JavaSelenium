package ramesh.framework.commonLib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverWrapper {
	
	private static WebDriver driver = Common.getDriver();
	
	public static void clickById(String id){
		driver.findElement(By.id(id)).click();		
	}
	
	public static void clickByXpath(String xpath){
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public static void sendKeysById(String id, String value){
		driver.findElement(By.xpath(id)).sendKeys(value);
	}
	
	public static void sendKeysByXpath(String xpath, String value){
		driver.findElement(By.xpath(xpath)).sendKeys(value);
	}
	
	public static void switchToFrameById(String id){
		driver.switchTo().frame(driver.findElement(By.id(id)));
	}

}
