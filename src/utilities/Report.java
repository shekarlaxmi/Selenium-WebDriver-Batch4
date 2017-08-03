package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class Report {
	private static ExtentReports report;
	private static ExtentTest test;
	private static String resultPath = null;
	private static String screenShotPath = null;
	private static WebDriver driver = null;
	private static int ssCount = 0;

	public static synchronized void startReport(){
		resultPath = System.getProperty("user.dir")+"/reports/Run_"+getCurrentDateTime("yyyyMMdd")+"_"+getCurrentDateTime("HHmmss");

		if(!new File(resultPath).isDirectory()){
			new File(resultPath).mkdirs();
		}
		screenShotPath = resultPath+"/ScreenShots/";

		if(!new File(screenShotPath).isDirectory()){
			new File(screenShotPath).mkdirs();
		}

		report = new ExtentReports(resultPath+"/Suite.html", true, NetworkMode.OFFLINE);
		report.addSystemInfo("enviroment", "QA");

	}

	public static synchronized void startTest(String testCaseName, String description, String category){
		test = report.startTest(testCaseName, description);
		test.assignCategory(category);
	}

	public static synchronized void endTest(){
		report.endTest(test);
		report.flush();
	}
	
	public static synchronized void endReport(){
		report.close();
		report = null;
	}

	
	public static synchronized void log(Status status, String message){
		driver = BaseTest.getWebDriver();
		switch(status){
		case PASS:
			test.log(LogStatus.PASS, message);
			break;
		case FAIL:
			takeScreenShot(driver, screenShotPath+"SS_"+ssCount+".png");
			test.log(LogStatus.FAIL, message+test.addScreenCapture(screenShotPath+"SS_"+ssCount+".png"));
			ssCount++;
			break;
		case WARN:
			test.log(LogStatus.WARNING, message);
			break;
		case INFO:
			test.log(LogStatus.INFO, message);
			break;
		case PassAndCapture:
			takeScreenShot(driver, screenShotPath+"SS_"+ssCount+".png");
			test.log(LogStatus.PASS, message+test.addScreenCapture(screenShotPath+"SS_"+ssCount+".png"));
			ssCount++;
			break;
		}
	}
	
	public static void takeScreenShot(WebDriver driver, String path){
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(scrFile, new File(path));
		}catch(IOException io){
			io.printStackTrace();
		}
		
	}

	public static String getCurrentDateTime(String format){
		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(cal.getTime());

	}

}
