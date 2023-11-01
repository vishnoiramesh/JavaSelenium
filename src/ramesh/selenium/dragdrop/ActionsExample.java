package ramesh.selenium.dragdrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsExample {
	
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://yuilibrary.com/yui/docs/dd/groups-drag.html");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.MILLISECONDS);
		
		WebElement source = driver.findElement(By.id("pb1"));
		WebElement target = driver.findElement(By.id("b1"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
//		action.moveToElement(source).clickAndHold(source).moveToElement(target).release().perform();
		
		driver.quit();
	}

}
