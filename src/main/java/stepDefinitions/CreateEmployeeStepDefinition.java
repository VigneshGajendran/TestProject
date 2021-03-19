package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.apis.createEmployee;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class CreateEmployeeStepDefinition {

	public createEmployee crudApi = new createEmployee();
	public ValidatableResponse response;

	@Given("^user sends the below details in request$")
	public void user_sends_the_below_details_in_request(DataTable empData) throws JsonParseException, JsonMappingException, IOException {
		Map<String, String> empDetails = empData.asMap(String.class, String.class);
		crudApi.formRequestBody(empDetails);
	}

	@When("^user sends the data to create data$")
	public void user_sends_the_data_to_create_data() throws JsonProcessingException {
		String request = crudApi.requestMapper().writeValueAsString(crudApi.requestDetails());
		System.out.println(request);

		ValidatableResponse response = given().header("Content-Type", "application/json").body(request).when()
				.post("http://localhost:8080/rest/employee").then();

	}

	@Then("^validate whether response is success with status code as \"([^\"]*)\"$")
	public void validate_whether_response_is_success_with_status_code_as(String statusCode) {
		response.assertThat().statusCode(Integer.parseInt(statusCode));
	}

	@Then("^validate the create employee error response$")
	public void validate_the_create_employee_error_response(DataTable errorData) {
		Map<String, String> errorDetails = errorData.asMap(String.class, String.class);
		response.assertThat().statusCode(Integer.parseInt(errorDetails.get("statusCode")));
		String responseString = response.extract().response().asString();

		JsonPath responsePath = new JsonPath(responseString);

		Assert.assertEquals(errorDetails.get("errorCode"), responsePath.get("errorCode"));
		Assert.assertEquals(errorDetails.get("errorDesc"), responsePath.get("errorDesc"));

	}
}
