package drivertest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.Select;

import pages.SearchMain;

public class SearchTest {

	public static ChromeDriver driver;
	public static SearchMain wikimain;

	@BeforeSuite
	public void setUp() {

		File file = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		driver = new ChromeDriver();
		wikimain = new SearchMain(driver);
	}

	@BeforeMethod
	public void before() {

		driver.get("http://localhost:4200/dish-list/");

	}

	@Test(priority = 1)
	public void search() {
		WebElement sbox = wikimain.getSearchbar();
		// wikimain.getSearchbar().click();

		try {
			Thread.sleep(8000);
			// sbox.sendKeys("Pasta");
			sbox.click();

			Thread.sleep(4000);

			WebElement dropdown = driver.findElement(By
					.xpath("/html/body/app-root/app-navbar/nav/form/div/sui-multi-select/div[2]/sui-select-option[1]"));
			Thread.sleep(4000);
			dropdown.click();
			// sbox.sendKeys(Keys.ENTER);
			// sbox.click();
			Thread.sleep(4000);
			WebElement review = driver
					.findElement(By.xpath("/html/body/app-root/app-dish-list/div/div/app-dish-list-item[3]/div/img"));
			Thread.sleep(4000);
			review.click();
			Thread.sleep(4000);
			Assert.assertEquals(driver.getTitle(), "HowChowApp");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}