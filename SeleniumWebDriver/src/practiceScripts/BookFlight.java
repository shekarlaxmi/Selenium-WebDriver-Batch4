package practiceScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

import utilities.BaseTest;

public class BookFlight extends BaseTest {
	
	
	@Test
	public void bookingFlight() {
		ExtentReports report = new ExtentReports("E:\\NewWorkSpace\\SeleniumWebDriver\\reports\\Suite.html", true, NetworkMode.OFFLINE);//Suite
		
		ExtentTest logger = report.startTest("Booking flight");// test case
		
		logger.log(LogStatus.INFO, "Test case execution is started");
		
		driver.get(url);
		
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
		
		logger.log(LogStatus.PASS, "Booking flight is successfull");
		
		report.flush();
		report.endTest(logger);
		report.close();
		
		el1.clear();
		
	}
	
	//@Test
	public void test1() {
		
		System.setProperty("webdriver.chrome.driver", "E:\\NewWorkSpace\\SeleniumWebDriver\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Options opt = driver.manage();
		
		Window win = opt.window();
		
		win.maximize();
		
		driver.get("https://www.facebook.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String url = driver.getCurrentUrl();
		System.out.println(url);
		
		WebElement element = driver.findElement(By.id("u_0_2"));
		
		element.sendKeys("shekar");
		
		//System.out.println(driver.getPageSource());
		driver.close();
		
	}
	
	@BeforeTest
	public void beforeTest(){
		System.out.println("before test");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
}
