package testCases;

import org.openqa.selenium.By;
import org.testng.annotations.*;

import pageLibrary.*;
import utilities.Assert;
import utilities.BaseTest;
import utilities.DataLoader;
import utilities.Report;
import utilities.Status;
import utilities.ValidationType;

public class SearchFlightsNewTours extends BaseTest{

	@Test(dataProvider="searchingData")
	public void searchingFlights(DataLoader data){
		
		Report.startTest("searchingFlights", "description", "Module1");
		//sign in aaplication
		LoginPage lgn = new LoginPage(driver);
		lgn.login("mercury", "mercury");

		//enter search criteria and click on search
		SearchPage srch = new SearchPage(driver);
		srch.searchFlights(data);
		
		boolean flag = driver.findElement(By.name("outFlight")).isDisplayed();
		
		Assert.assertTrue(ValidationType.Assert, flag, "out flight element is displayed");
		
		
	}

	//@Test
	public void bookFlight(){
		Report.startTest("bookFlight", "description", "Module2");
		
		DataLoader data1 = new DataLoader();
		data1.loadTestData("bookFlight", "Dataset1");
		
		//sign in aaplication
		LoginPage lgn = new LoginPage(driver);
		lgn.login("mercury", "mercury");

		//enter search criteria and click on search
		SearchPage srch = new SearchPage(driver);
		srch.searchFlights(data1);

		boolean flag = driver.findElement(By.name("outFlight")).isDisplayed();
		Assert.assertTrue(ValidationType.VerifyAndCapture, flag, "out flight element is displayed");
		System.out.println("after assertion");
		//Select flight and click on continue
		srch.selectAFlight();
		srch.clickContinue();

		//enter passenger deails
		PassengerInformation psn = new PassengerInformation(driver);
		psn.enterPassengerDetails();
		psn.clickOnPurchase();
		
		//validation
		BookingConfirmationPage conf = new BookingConfirmationPage(driver);
		Assert.assertEquals(ValidationType.Assert, "Your itinerary has been booked!", conf.getConfirmationMessage(), "Your itinerary has been booked!");
		Report.endTest();
	}
	
	@DataProvider(name="searchingData")
	public Object[][] dataSearchFlights(){
		Object[][] obj = new Object[1][1];
		
		DataLoader data1 = new DataLoader();
		data1.loadTestData("searchingFlights", "Dataset1");
		obj[0][0] = data1;
		
		/*DataLoader data2 = new DataLoader();
		data2.loadTestData("searchingFlights", "Dataset2");
		obj[1][0] = data2;
		
		DataLoader data3 = new DataLoader();
		data3.loadTestData("searchingFlights", "Dataset3");
		obj[2][0] = data3;*/
		
		return obj;
	}
}
