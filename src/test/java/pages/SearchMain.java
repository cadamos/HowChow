package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchMain {

	public WebDriver driver;


	public SearchMain(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchbar() {
		return driver.findElement(By.id("searchbar"));
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(By.className("btn btn-secondary ml-1"));
	}
	}
