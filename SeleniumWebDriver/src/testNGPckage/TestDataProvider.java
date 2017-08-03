package testNGPckage;

import org.testng.annotations.*;

public class TestDataProvider {

	@Test(dataProvider="dataManagement")
	public void login(String uname, String pwd){
		System.out.println("Entering username: "+uname);
		System.out.println("Entering passord: "+pwd);
		System.out.println("Click on Login");
	}
	
	@DataProvider
	public Object[][] dataManagement(){
		Object[][] data = new Object[3][2];
		
		data[0][0] = "shekar";
		data[0][1] = "password";
		
		data[1][0] = "shekar1";
		data[1][1] = "password1";
		
		data[2][0] = "shekar1";
		data[2][1] = "password1";
		
		return data;
	}
}
