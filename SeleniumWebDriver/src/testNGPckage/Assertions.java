package testNGPckage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import practiceScripts.BookFlight;

public class Assertions {
	//@Test
	public void loginMercury(){
		System.setProperty("webdriver.chrome.driver", "E:\\NewWorkSpace\\SeleniumWebDriver\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Open url
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		
		boolean flag = driver.findElement(By.name("passCount")).isDisplayed();
		
		Assert.assertTrue(flag, "Login is not successfully");//
		
		WebElement drp1 = driver.findElement(By.name("passCount"));
		
		Select sl1 = new Select(drp1);
		sl1.selectByVisibleText("3");
		
		System.out.println("End of test");
		driver.close();
	}
	
	@Test
	public void test2(){
		System.setProperty("webdriver.chrome.driver", "E:\\NewWorkSpace\\SeleniumWebDriver\\drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//Open url
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		
			String actual = driver.findElement(By.linkText("Home")).getText();
			
			BookFlight obj1 = new BookFlight();
			
			BookFlight obj2 =  new BookFlight();
			String str = new String("home");// String str = "nome";
			
		Assert.assertEquals(actual, "Home", "Expected text is not matching");
		Assert.assertSame(obj1, obj2, "Expected text is not matching");
		
		WebElement drp1 = driver.findElement(By.name("passCount"));
		
		Select sl1 = new Select(drp1);
		sl1.selectByVisibleText("3");
		
		System.out.println("End of test");
		driver.close();
	}
}
