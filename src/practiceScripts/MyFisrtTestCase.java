package practiceScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyFisrtTestCase {
	
	@Test
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
}
