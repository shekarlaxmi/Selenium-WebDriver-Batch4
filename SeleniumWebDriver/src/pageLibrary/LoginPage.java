package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Report;
import utilities.Status;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="userName")//xpath=""
	public WebElement txtUserName;
	
	@FindBy(name="password")
	public WebElement txtPassword;
	
	@FindBy(name="login")
	public WebElement btnLogin;
	
	public void  login(String userName, String password){
		Report.log(Status.INFO, "Logging into allplication");
		
		txtUserName.sendKeys(userName);
		txtPassword.sendKeys(password);
		btnLogin.click();
		
		/*driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();*/

	}
	
	public void clickLogin(){
		btnLogin.click();
	}
	
}
