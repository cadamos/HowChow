package behaviortest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HowChowMain {

public WebDriver driver;
	
	public HowChowMain(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSearchbar() {
		return driver.findElement(By.name("search"));
	}
}
