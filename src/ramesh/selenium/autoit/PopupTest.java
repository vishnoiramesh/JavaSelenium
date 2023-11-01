package ramesh.selenium.autoit;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupTest {
	
	public static void main(String[] args){
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.wufoo.com/gallery/templates/forms/employment-application/");
		
		driver.switchTo().frame(driver.findElement(By.id("wufooFormp1dftc311iksix")));
		
		WebElement fileElement = driver.findElement(By.xpath("//input[@id='Field12']//.."));
		
		fileElement.click();	
		
		try {
			Runtime.getRuntime().exec("C:/Eclipse/autoit_scripts/PopupOperations.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
