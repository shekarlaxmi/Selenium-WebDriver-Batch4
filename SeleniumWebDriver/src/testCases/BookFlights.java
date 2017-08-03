package testCases;

import org.testng.annotations.Test;

import pageLibrary.LoginPage;
import pageLibrary.SearchPage;
import utilities.BaseTest;

public class BookFlights extends BaseTest{
	
	@Test
	public void testCase1(){
		LoginPage login = new LoginPage(driver);
		login.login(env.getEnvDeails("Creds_UserName"), env.getEnvDeails("Creds_Password"));
		
		SearchPage srch = new SearchPage(driver);
		srch.searchFlights(dp);
		
		
	}
}
