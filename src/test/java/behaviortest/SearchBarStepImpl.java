package behaviortest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchBarStepImpl {
	
	static {
		File file = new File("src/test/resources/chromedriver");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
	}
	
	static ChromeDriver driver = new ChromeDriver();
	static HowChowMain hcmain = new HowChowMain(driver);

	@Given("^I am on HowChow's site$")
	public void i_am_on_HowChow_s_site() {
	    driver.get("localhost:4200/dish-list");
	}

	@Given("^The search bar's values are loaded$")
	public void the_search_bar_s_values_are_loaded() {
	    driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
	}

//	@When("^I select the \"([^\"]*)\" tag$")
//	public void i_select_the_tag(String arg1) {
//	    WebElement drpdwn = new WebElement(hcmain.getSearchbar());
//	    drpdwn.get
//	    drpdwn.selectByVisibleText(arg1);
//	}

	@Then("^\"([^\"]*)\" and \"([^\"]*)\" should be loaded below$")
	public void and_should_be_loaded_below(String arg1, String arg2) {
		boolean correct = false;
		WebElement e1 = driver.findElement(By.xpath("/html/body/app-root/app-dish-list/div/div/app-dish-list-item[1]/div/div/h5"));
		WebElement e2 = driver.findElement(By.xpath("/html/body/app-root/app-dish-list/div/div/app-dish-list-item[2]/div/div/h5"));
		if(e1.getAttribute("innerHTML") == arg1 && e2.getAttribute("innerHTML") == arg2) {
			correct = true;
		}
		Assert.assertTrue(correct);
	}
	
}
