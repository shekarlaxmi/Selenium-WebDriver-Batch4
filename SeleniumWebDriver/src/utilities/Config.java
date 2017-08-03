package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Config {
	FileInputStream input;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	private HashMap<String, String> envData = new HashMap<String, String>();

	public synchronized void loadEnvData(){
		try {
			workBook = new XSSFWorkbook(new FileInputStream(System.getProperty("user.dir")+"/envConfig.xlsx"));
		} catch (IOException e1) {}
		sheet = workBook.getSheet("Env");

		String key = null;
		String value = null;

		for(int i=1;i<sheet.getLastRowNum();i++){
			try{
				XSSFCell cellVariable = sheet.getRow(i).getCell(1);
				XSSFCell cellvalue = sheet.getRow(i).getCell(2);
				key = cellVariable.getStringCellValue();

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
			envData.put(key.toLowerCase(), value);
		}
	}
	
	public String getEnvDeails(String key){
		String value = "";
		if(envData.containsKey(key))
			value =  envData.get(key);
		return value;
	}
}
