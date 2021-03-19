package apiCom.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/resources/features", glue = {
		"UiStepDefinition" }, tags = "@emailSuccessValidations")
public class UiRunner {

}
