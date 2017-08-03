package testNGPckage;

import org.testng.annotations.*;

public class TestNgAnnotations {

	@Test(priority=0, groups={"Module1", "Regression"})
	public void test1(){
		System.out.println("Running test case 1");
	}
	
	@Test(priority=0, groups={"Module2", "Regression"})
	public void atest2(){
		System.out.println("Running test case 2");
	}
	
	@Test(groups={"Module1", "Sanity"})
	public void test3(){
		System.out.println("Running test case 3");
	}
	
	@BeforeGroups(groups={"Module1"})
	public void beforeGroups(){
		System.out.println("before groups");
	}
	
	@BeforeMethod
	public void beforeMethod(){
		//Testdata read
		//Open browser
		System.out.println("before each test case");
	}
	
	@AfterMethod
	public void afterMethod(){
		//Closing formalities
		System.out.println("after each test case");
	}
	
	@BeforeClass
	public void beforeClass(){
		//Runs before any of the methods in the class
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void afterClass(){
		System.out.println("After Class");
	}
	
	
}
