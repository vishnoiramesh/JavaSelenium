package ramesh.selenium.dragdrop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.interactions.Action;

import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		String URL = "http://demoqa.com/droppable/";

		driver.get(URL);

		// It is always advisable to Maximize the window before performing
		// DragNDrop action

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

		WebElement From = driver
				.findElement(By.xpath(".//*[@id='draggableview']"));

		WebElement To = driver
				.findElement(By.xpath(".//*[@id='droppableview']"));

		Actions builder = new Actions(driver);

		/*
		 * Action dragAndDrop = builder.clickAndHold(From)
		 * 
		 * .moveToElement(To)
		 * 
		 * .release(To)
		 * 
		 * .build();
		 * 
		 * dragAndDrop.perform();
		 */

		builder.dragAndDrop(From,To).build().perform();

	}

}