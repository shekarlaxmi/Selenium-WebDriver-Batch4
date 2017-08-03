package utilities;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

public class BaseTest {
	
	public static WebDriver driver = null;
	private String browser = "chrome";
	protected Config env = null;
	protected DataLoader dp = null;
	@BeforeSuite
	public void beforeExecution(){
		Report.startReport();
		env = new Config();
		env.loadEnvData();
	}
	
	@AfterSuite
	public void afterSuite(){
		Report.endReport();
	}
	@BeforeTest
	@Parameters("browser")
	public void  beforeTest(String browserName){
		browser = browserName;
	}
	
	@BeforeMethod
	public synchronized void beforeEachTestCase(Method method){
		//Load test data
		dp.loadTestData(method.getName(), "1");
		
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver =  new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(env.getEnvDeails("Url"));
	}
	
	@AfterMethod
	public synchronized void afterEachTestCase(){
		Report.endTest();
		driver.close();
		driver = null;
	}
	
	public static synchronized WebDriver getWebDriver(){
		return driver;
	}

}
