package testNGPckage;

import org.testng.annotations.*;

public class Annotations2 {

	@BeforeTest
	public void beforeTest(){
		System.out.println("before test");
	}
	
	@AfterTest
	public void afterTest(){
		System.out.println("After Test");
	}
	
	@BeforeSuite
	public void beforeSuite(){
		System.out.println("before Suite");
	}
	
	@AfterSuite
	public void afterSuite(){
		System.out.println("After Suite");
	}
	
	@Test(groups={"Module1"})
	public void createStudentProfile(){
		System.out.println("Creating student profile");
	}
	
	
	@Test(groups={"Module2"}, dependsOnMethods={"createStudentProfile"})
	public void editStudentProfile(){
		System.out.println("editing student profile");
	}
	
	@Test(groups={"Module2"})
	public void test(){
		System.out.println("Module2 test case");
	}
	
	@Test(dependsOnGroups={"Module2"})
	public void search(){
		System.out.println("search student details");
	}
}
