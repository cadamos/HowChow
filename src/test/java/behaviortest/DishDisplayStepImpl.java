package behaviortest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DishDisplayStepImpl {

	static {
		File file = new File("src/test/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
	static ChromeDriver driver = new ChromeDriver();
	static HowChowMain hcmain = new HowChowMain(driver);
	
	@Given("^I am on HowChow's Dish List page$")
	public void i_am_on_HowChow_s_Dish_List_page() {
	    driver.get("http://localhost:4200/dish-list");
	}

	@When("^I click on a card's image$")
	public void i_click_on_a_card_s_image() {
	    WebElement card = new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/app-dish-list/div/div/app-dish-list-item[1]/div/img")));
	    card.click();
	}

	@Then("^I should see the name of the dish on the redirect page$")
	public void i_should_see_the_name_of_the_dish_on_the_redirect_page() {
	    WebElement title = driver.findElement(By.xpath("/html/body/app-root/app-dish-display/div/div/div[2]/div/h5"));
	    String titlestring = title.getAttribute("innerHTML");
	    System.out.println(titlestring);
	    Assert.assertTrue(titlestring.equals("Tacos"));
	}
}
