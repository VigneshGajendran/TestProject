package UiStepDefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.pages.EmailPage;

import cucumber.api.java.en.*;

public class emailStepDefinition {
	public EmailPage emailpage = new EmailPage();

	@Given("^user sends the \"([^\"]*)\"$")
	public void user_sends_the(String email) throws FileNotFoundException, IOException {
		emailpage.moveToResultFrame().enterEmail(email);
	}

	@Then("^validate the \"([^\"]*)\"$")
	public void validate_the(String status) {
		Assert.assertEquals(status, emailpage.readStatus());
	}

}
