package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.DataLoader;
import utilities.Report;
import utilities.Status;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='tripType' and @value='oneway']")
	public WebElement rdoOneWay;
	
	@FindBy(name="passCount")
	public WebElement lstPassengeCount;
	
	@FindBy(name="fromPort")
	public WebElement lstDepartingFrom;
	
	@FindBy(name="fromMonth")
	public WebElement lstDepartingOnMon;
	
	@FindBy(name="fromDay")
	public WebElement lstDepartingOnDay;
	
	@FindBy(name="findFlights")
	public WebElement btnFindFlights;

	public void searchFlights(DataLoader data){
		Report.log(Status.INFO, "Searching for flight");
		
		rdoOneWay.click();
		
		Select psn = new Select(lstPassengeCount);
		psn.selectByVisibleText(data.getData("lstPassengers"));
		
		/*driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']")).click();
		WebElement el1 = driver.findElement(By.name("passCount"));
		Select psn = new Select(el1);
		psn.selectByVisibleText(data.getData("lstPassengers"));*/

		Select from = new Select(lstDepartingFrom);
		from.selectByVisibleText(data.getData("lstDepartingFrom"));

		new Select(lstDepartingOnMon).selectByVisibleText(data.getData("lstDepartingOnMon"));

		new Select(lstDepartingOnDay).selectByIndex(Integer.parseInt(data.getData("lstDepartingOnDay")));

		btnFindFlights.click();
	}
	
	public void selectAFlight(){
		driver.findElement(By.name("outFlight")).click();
	}
	
	public void clickContinue(){
		driver.findElement(By.name("reserveFlights")).click();

	}

}
