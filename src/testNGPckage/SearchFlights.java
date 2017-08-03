package testNGPckage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import practiceScripts.BookFlight;

public class SearchFlights {
	public static void main(String[] args) throws IOException {
		FileInputStream input = new FileInputStream("E:\\NewWorkSpace\\SeleniumWebDriver\\testData\\testData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(input);
		XSSFSheet sheet = workBook.getSheet("testData");
		
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(1);
		String value = cell.getStringCellValue();
		System.out.println(value);
	}
	
	
}
