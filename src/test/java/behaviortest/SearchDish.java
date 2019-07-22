package behaviortest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchDish {
	
	static {
		File file = new File("C:\\Users\\Owner\\Documents\\workspace-spring-tool-suite-4-4.3.0.RELEASE\\HowChow\\src\\test\\resources\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
	static ChromeDriver driver = new ChromeDriver();
	static HowChowMain hcmain = new HowChowMain(driver);
	
	
	@Given("^I am on the HowChow Home Page$")
	public void i_am_on_the_HowChow_Home_Page() throws Throwable {
	    driver.get("http://localhost:4200/dish-list");
	}

	@When("^I click in search box$")
	public void i_click_in_search_box() throws Throwable {
	    WebElement searchbar=hcmain.getSearchbar();
	    searchbar.click();
	    
	}

	@When("^select a dish tag$")
	public void select_a_dish_tag() throws Throwable {
	    WebElement dropdown= driver.findElement(By.xpath("/html/body/app-root/app-navbar/nav/form/div/sui-multi-select/div[2]/sui-select-option[1]"));
	    dropdown.click();
	    
	    WebElement searchbtn= driver.findElementByClassName("btn"); 
	    searchbtn.click();
	}

	@Then("^I should be able to see a list of dishes$")
	public void i_should_be_able_to_see_a_list_of_dishes() throws Throwable {
		Thread.sleep(3000);
	   WebElement clickImage = driver.findElement(By.xpath("/html/body/app-root/app-dish-list/div/div/app-dish-list-item[1]"));
	   clickImage.click();
	   
	   Thread.sleep(3000);
	   
	   WebElement btn= driver.findElement(By.xpath("/html/body/app-root/app-dish-display/div/div/div[2]/div/a"));
	   btn.click();
	   Assert.assertEquals(driver.getTitle(),"HowChow");
	    
	}

}
