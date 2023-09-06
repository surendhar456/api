package CucumberOptionsss;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions(features="C:\Users\Ashok Raj\Selenium\RestAssured\src\test\java\Feature",plugin ="json:target/jsonReports/cucumber-report.json",glue= {"StepDefinationss"})
	public class TestRunners {
	//tags= {"@DeletePlace"}  compile test verify
	


}
