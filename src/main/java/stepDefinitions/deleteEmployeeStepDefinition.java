package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.DataTable;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class deleteEmployeeStepDefinition {
	ValidatableResponse response;

	@Given("^user hits the delete employee api \"([^\"]*)\"$")
	public void user_hits_the_delete_employee_api(String empId) {

		response = given().header("Content-Type", "application/json").when()
				.delete("http://localhost:8080/rest/employee" + empId).then();
	}

	@Then("^validate whether employee details is deleted \"([^\"]*)\"$")
	public void validate_whether_employee_details_is_deleted(String statusCode) {
		response.assertThat().statusCode(Integer.parseInt(statusCode));
	}

	@Then("^validate the delete api error response$")
	public void validate_the_delete_api_error_response(DataTable errorData) throws Throwable {
		Map<String, String> errorDetails = errorData.asMap(String.class, String.class);
		response.assertThat().statusCode(Integer.parseInt(errorDetails.get("statusCode")));
		String responseString = response.extract().response().asString();

		JsonPath responsePath = new JsonPath(responseString);

		Assert.assertEquals(errorDetails.get("errorCode"), responsePath.get("errorCode"));
		Assert.assertEquals(errorDetails.get("errorDesc"), responsePath.get("errorDesc"));
	}

}
