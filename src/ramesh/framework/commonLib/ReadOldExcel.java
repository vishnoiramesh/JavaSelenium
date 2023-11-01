package ramesh.framework.commonLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

public class ReadOldExcel {

	public static void main(String[] args) {
		HSSFSheet sheet;
		WebDriver driver;
		FileInputStream fis;
		try {
			File file = new File("C:/WS/Java/test/Resources/datafile2.xls");
			fis = new FileInputStream(file); 

			HSSFWorkbook workbook = new HSSFWorkbook(fis);			
			sheet = workbook.getSheetAt(0);
			
			Iterator<Row> ite = sheet.rowIterator();
			while(ite.hasNext()){
				Row row = ite.next();
				Iterator<Cell> cite = row.cellIterator();
				while(cite.hasNext()){
					Cell c = cite.next();
					System.out.println(c.toString());
				}
				
			}
			
			workbook.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
