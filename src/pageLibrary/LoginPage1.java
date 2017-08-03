package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.PageHelper;
import utilities.Report;
import utilities.Status;

public class LoginPage1 extends PageHelper{

	public LoginPage1(WebDriver driver) {
		super(driver);
		
		element("txtUserName", By.name("userName"));
		element("txtPassword", By.name("password"));
		element("btnLogin", By.name("login"));
	}
	
	
	public void enterLogin(){
		Report.log(Status.INFO, "User is logging");
		
		element("txtUserName").sendKeys("mercury");
		element("txtPassword").sendKeys("mercury");
		element("btnLogin").click();
	}

}
