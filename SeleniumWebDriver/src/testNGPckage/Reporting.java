package testNGPckage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class Reporting {
	@Test
	public void bookingFlight() {
		ExtentReports report = new ExtentReports("E:\\NewWorkSpace\\SeleniumWebDriver\\reports\\Suite.html", true, NetworkMode.OFFLINE);//Suite
		
		ExtentTest logger = report.startTest("Booking flight");// test case
		
		logger.log(LogStatus.INFO, "Test case execution is started");
		System.setProperty("webdriver.chrome.driver", "E:\\NewWorkSpace\\SeleniumWebDriver\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
		WebElement el1 = driver.findElement(By.id("u_0_2"));
		el1.sendKeys("fname");
		
		driver.findElement(By.name("lastname")).sendKeys("sname");
		
		driver.findElement(By.id("u_0_7")).sendKeys("58752556455");
		
		driver.findElement(By.id("u_0_e")).sendKeys("password123");
		
		WebElement el2 = driver.findElement(By.id("day"));
		
		Select sl1 = new Select(el2);
		sl1.selectByIndex(10);
		
		WebElement el3 = driver.findElement(By.name("birthday_month"));
		
		Select sl2 = new Select(el3);
		sl2.selectByValue("4");
		
		el3 = driver.findElement(By.id("year"));
		
		Select sl3 = new Select(el3);
		sl3.selectByVisibleText("1990");
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("E:\\NewWorkSpace\\SeleniumWebDriver\\reports\\s1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		logger.log(LogStatus.PASS, "Booking flight is successfull");
		
		report.flush();
		report.endTest(logger);
		report.close();
		
		el1.clear();
		driver.close();
	}
}
