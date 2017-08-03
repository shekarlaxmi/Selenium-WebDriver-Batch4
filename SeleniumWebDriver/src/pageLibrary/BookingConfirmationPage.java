package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingConfirmationPage {
	WebDriver driver;

	public BookingConfirmationPage(WebDriver driver){
		this.driver = driver;
	}
	
	
	public String getConfirmationMessage(){
		String msg = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[3]/td/p/font/b/font[2]")).getText();
		return msg;
	}
}
