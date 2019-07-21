package behaviortest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReviewStepImpl {

	static {
		File file = new File("src/test/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
	static ChromeDriver driver = new ChromeDriver();
	static HowChowMain hcmain = new HowChowMain(driver);
	static float ratingAvg = 0;
	
	@Given("^I am logged in$")
	public void i_am_logged_in() {
	    driver.get("localhost:4200/login");
	    hcmain.logIn();
	}

//	@Given("^I am on a HowChow dish display page$")
//	@Given("^I am logged in and I am on a HowChow dish display page$")
//	public void i_am_logged_in_and_I_am_on_a_HowChow_dish_display_page() {
//		driver.get("http://ec2-3-15-163-20.us-east-2.compute.amazonaws.com:8080/angular/how-chow-app");
//		WebElement login = driver.findElement(By)
//		hcmain.logIn();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//	    WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logo")));;
//	    logo.click();
//	    WebDriverWait wait2 = new WebDriverWait(driver, 10);
//	    WebElement card = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-dish-list/div/div/app-dish-list-item[1]/div/img")));
//	    card.click();
//	    WebElement rating = driver.findElement(By.id("stars"));
//	    ratingAvg = Float.parseFloat(rating.getAttribute("value"));
//	}

	@When("^I make a review$")
	public void i_make_a_review() {
	    hcmain.makeReview(); 
	}	

	@Then("^the aggregate star rating should change$")
	public void the_aggregate_star_rating_should_change() {
		WebElement rating = driver.findElement(By.id("stars"));
	    float newRatingAvg = Float.parseFloat(rating.getAttribute("value"));
	    Assert.assertTrue(newRatingAvg > ratingAvg);
	}

}
