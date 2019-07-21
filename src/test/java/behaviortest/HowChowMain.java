package behaviortest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HowChowMain {

public WebDriver driver;
	
	public HowChowMain(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getSearchbar() {
		return driver.findElement(By.name("search"));
	}
	
	public void logIn() {
		String username = "username";
		String password = "password";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement usernameInput = driver.findElement(By.id("username"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement subButton = driver.findElement(By.id("login"));
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		subButton.click();
	}
	
	public void makeReview() {
		String review = "This food is the worst, and whoever put it in this system should be ashamed!";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement badReview = driver.findElement(By.id("starhalf"));
		badReview.click();
		WebElement revInput = driver.findElement(By.id("comment"));
		revInput.sendKeys(review);
		By id = By.id("reviewsub");
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(id)).sendKeys(Keys.ENTER);
	}
}
