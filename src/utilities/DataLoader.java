package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.LoadableComponent;

public class DataLoader {
		FileInputStream input;
		XSSFWorkbook workBook;
		XSSFSheet sheet;
		private HashMap<String, String> data = new HashMap<String, String>();
		
		public synchronized void loadTestData(String testCaseName, String iteration){
			try {
				workBook = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"/testData/testData.xlsx"));
			} catch (IOException e1) {}
			sheet = workBook.getSheet("testData");
			int tcRowNum = getRowNumber(sheet, testCaseName);
			int dataRowNum = getIteratioRowNumber(sheet, testCaseName, tcRowNum, iteration);
			
			String key = null;
			String value = null;
			
			for(int i=1;i<1000;i++){
				try{
					XSSFCell cellField = sheet.getRow(tcRowNum).getCell(i);
					XSSFCell cellvalue = sheet.getRow(dataRowNum).getCell(i);
					key = cellField.getStringCellValue();
					
					switch(cellvalue.getCellTypeEnum()){
					case STRING:
						value = cellvalue.getStringCellValue();
					case NUMERIC:
						double num = cellvalue.getNumericCellValue();
						Double db = new Double(num);
						value = db.toString();
						if(value.contains("."))
							value = value.split(".")[0];
					case BLANK:
						break;
					}
				}catch(Exception e){}
				data.put(key.toLowerCase(), value);
			}
			
			
		}
		
		private int getRowNumber(XSSFSheet sheet, String testCaseName){
			int rowNum = 0;
			int lastRowNum = sheet.getLastRowNum();
			String nameFromExcel = null;
			try{
				for(int i=0;i<lastRowNum;i++){
					XSSFRow row = sheet.getRow(i);
					XSSFCell cell = row.getCell(0);
					switch(cell.getCellTypeEnum()){
					case STRING:
						nameFromExcel = cell.getStringCellValue();
						break;
					case BLANK:
						break;
					}
					
					if(nameFromExcel.equalsIgnoreCase(testCaseName)){
						rowNum = i;
						break;
					}
				}
			}catch(Exception e){
				
			}
			return rowNum;
		}
		
		private int getIteratioRowNumber(XSSFSheet sheet, String testCaseName, int tcRowNum, String iteration){
			int itrRow = 0;
			String itrName = null;
			for(int i=tcRowNum;i<=sheet.getLastRowNum();i++){
				try{
					itrName = sheet.getRow(i).getCell(1).getStringCellValue();
				}catch(Exception e){
					
				}
				
				if(itrName.equalsIgnoreCase(iteration)){
					itrRow = i;
					break;
				}
			}
			
			return itrRow;
		}
		
		public String getData(String key){
			String value = "";
			if(data.containsKey(key.toLowerCase())){
				value = data.get(key.toLowerCase());
			}
			
			return value;
		}
		
}
