package practiceScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPassword {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "E:\\NewWorkSpace\\SeleniumWebDriver\\drivers\\geckodriver.exe");
		//chrome, ie, gecko
		//ChromeDriver driver = new ChromeDriver();
		FirefoxDriver driver = new FirefoxDriver();
		
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.linkText("Forgotten account?")).click();
		
		//page load
		driver.findElement(By.id("identify_email")).sendKeys("abc@example.com");
		
		driver.findElement(By.xpath("//input[@value='Search' and @type='submit']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
		
		driver.findElement(By.xpath("")).sendKeys("");
		driver.close();
	}
}
