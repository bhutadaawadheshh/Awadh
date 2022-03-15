package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void screenshot(WebDriver driver, String testID) throws Exception
	{
		
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   System.out.println(dtf.format(now));
		   
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = (ts.getScreenshotAs(OutputType.FILE));
	File dest= new File("C:\\Users\\DELL\\Downloads\\Selenium\\SeleniumScreenshots\\"+testID+ dtf.format(now)+".jpeg");
	FileHandler.copy(source, dest);
	}
	
	public static String getDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException 
	{
        String data = null;
		String path = "C:\\Users\\DELL\\Downloads\\Selenium\\Book1.xlsx";
		FileInputStream file = new FileInputStream(path);
		try
		{
		 data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		}
		catch(IllegalStateException e) 
		{
			double value = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			data = Double.toString(value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
        
		System.out.println(data);
		return data;		
	}

}
