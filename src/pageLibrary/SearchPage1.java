package pageLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.PageHelper;

public class SearchPage1 extends PageHelper {

	public SearchPage1(WebDriver driver) {
		super(driver);
		element("rdoOneWay", By.xpath(""));
		element("", By.xpath(""));
	}

	
}
