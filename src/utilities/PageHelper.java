package utilities;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageHelper {
	WebDriver driver;
	private HashMap<String, By> objectRep = new HashMap<String, By>();
	
	public PageHelper(WebDriver driver){
		this.driver = driver;
	}
	
	public void element(String name, By findBy){
		objectRep.put(name.toLowerCase(), findBy);
	}
	
	public WebElement element(String name){
		By findBy = null;
		if(objectRep.containsKey(name.toLowerCase()))
			findBy = objectRep.get(name.toLowerCase());
		return driver.findElement(findBy);
	}
}
