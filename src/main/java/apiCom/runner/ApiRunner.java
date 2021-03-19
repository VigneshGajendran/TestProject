package apiCom.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/api/resources/features", glue = {
		"stepDefinitions" }, tags = "@GeEmployeeErrorScenarios")
public class ApiRunner {

}
