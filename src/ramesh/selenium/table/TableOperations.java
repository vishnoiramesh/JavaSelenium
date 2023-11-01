package ramesh.selenium.table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TableOperations {
	static WebDriver driver;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/challenging_dom");
		int rowCount = getRowCount("//table");
		
		System.out.println("Rows in table = " + rowCount);
		
		String cellData = getTextInCell("//table", 2, 3);
		System.out.println("Data in cell row 2 and column 3 is " + cellData);
	}
	
	@Test
	public static int getRowCount(String tableXpath){
		
		WebElement tableElement = driver.findElement(By.xpath(tableXpath));
		String rowXpath = ".//tbody/tr";
		
		List<WebElement> rowElements = tableElement.findElements(By.xpath(rowXpath));
		return rowElements.size();
		
	}
	
	@Test
	public static String getTextInCell(String tableXpath, int rowNo, int colNo){
		WebElement tableElement = driver.findElement(By.xpath(tableXpath));
		String cellXpath = ".//tbody/tr[" +rowNo+ "]/td[" +colNo+ "]";
		
		WebElement cellElement = tableElement.findElement(By.xpath(cellXpath));
		return cellElement.getText();
	}
	
	public static int getColCount(String tableXpath){
		return 0;
	}
}