package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import api.apis.updateEmployee;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class updateEmployeeStepDefinition {

	public updateEmployee updateEmp = new updateEmployee();
	public ValidatableResponse response;

	@Given("^user sends the below details in update request$")
	public void user_sends_the_below_details_in_update_request(DataTable empData)
			throws JsonParseException, JsonMappingException, IOException {
		Map<String, String> empDetails = empData.asMap(String.class, String.class);
		updateEmp.formRequestBody(empDetails);
	}

	@When("^user sends the data to update employee api$")
	public void user_sends_the_data_to_update_employee_api() throws JsonProcessingException {
		String request = updateEmp.requestMapper().writeValueAsString(updateEmp.requestDetails());
		System.out.println(request);

		ValidatableResponse response = given().header("Content-Type", "application/json").body(request).when()
				.put("http://localhost:8080/rest/employee").then();

	}

	@Then("^validate whether update employee response is success with status code as \"([^\"]*)\"$")
	public void validate_whether_update_employee_response_is_success_with_status_code_as(String statusCode,
			DataTable expectedDetails) {
		Map<String, String> expectedData = expectedDetails.asMap(String.class, String.class);

		response.assertThat().statusCode(Integer.parseInt(statusCode));
		String responseString = response.extract().response().asString();

		JsonPath responsePath = new JsonPath(responseString);

		Assert.assertEquals(Long.parseLong(expectedData.get("empId")), (long) responsePath.get("empId"));
		Assert.assertEquals(expectedData.get("firstName"), responsePath.get("firstName"));
		Assert.assertEquals(expectedData.get("lastName"), responsePath.get("lastName"));
		Assert.assertEquals(expectedData.get("designation"), responsePath.get("designation"));
		Assert.assertEquals(Integer.parseInt(expectedData.get("salary")), (int) responsePath.get("salary"));
	}

	@Then("^validate the update employee error response$")
	public void validate_the_update_employee_error_response(DataTable errorData) {

		Map<String, String> errorDetails = errorData.asMap(String.class, String.class);
		response.assertThat().statusCode(Integer.parseInt(errorDetails.get("statusCode")));
		String responseString = response.extract().response().asString();

		JsonPath responsePath = new JsonPath(responseString);

		Assert.assertEquals(errorDetails.get("errorCode"), responsePath.get("errorCode"));
		Assert.assertEquals(errorDetails.get("errorDesc"), responsePath.get("errorDesc"));

	}

}
