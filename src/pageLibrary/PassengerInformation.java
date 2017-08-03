package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PassengerInformation {
	WebDriver driver;

	public PassengerInformation(WebDriver driver){
		this.driver = driver;
	}
	
	public void enterPassengerDetails(){
		driver.findElement(By.name("passFirst0")).sendKeys("fnmae");
		driver.findElement(By.name("passLast0")).sendKeys("last name");
	}
	
	public void clickOnPurchase(){
		driver.findElement(By.name("buyFlights")).click();
	}
}
