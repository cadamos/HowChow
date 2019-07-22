package behaviortest;

import org.testng.annotations.AfterSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		// The feature is the outline for the tests.
		features = {"/HowChow/src/main/resources/features/SearchDish.feature","/HowChow/src/test/resources/DishDisplay.feature"},
		// The glue is where our actual code/step implementations exist.
		glue =  {"behaviortest"}	
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

	@AfterSuite
	public void tearDown() {
		ReviewStepImpl.driver.quit();
		SearchDish.driver.quit();
	}
}