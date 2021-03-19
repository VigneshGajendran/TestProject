package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import junit.framework.Assert;

public class GetEmployeeStepDefinition {
	private String allOrEmpId;
	ValidatableResponse response;

	@Given("^user hits the get employee api to fetch \"([^\"]*)\" the employee details$")
	public void user_hits_the_get_employee_api_to_fetch_the_employee_details(String allOrEmpIdVal, DataTable empIdData)
			throws Throwable {

		Map<String, String> empId = empIdData.asMap(String.class, String.class);
		allOrEmpId = allOrEmpIdVal;

		response = given().header("Content-Type", "application/json").when()
				.get(allOrEmpIdVal.equals("all") ? "http://localhost:8080/rest/employee"
						: "http://localhost:8080/rest/employee" + empId.get("empId"))
				.then();

	}

	@Then("^validate whether below employee details is present in the list$")
	public void validate_whether_below_employee_details_is_present_in_the_list(DataTable expectedDatails)
			throws Throwable {
		Map<String, String> expectedData = expectedDatails.asMap(String.class, String.class);
		response.assertThat().statusCode(Integer.parseInt(expectedData.get("statusCode")));

		String responseString = response.extract().response().asString();

		JsonPath responsePath = new JsonPath(responseString);

		Assert.assertEquals(expectedData.get("empId"), responsePath.get("empId"));
		Assert.assertEquals(expectedData.get("firstName"), responsePath.get("firstName"));
		Assert.assertEquals(expectedData.get("lastName"), responsePath.get("lastName"));
		Assert.assertEquals(expectedData.get("designation"), responsePath.get("designation"));
		Assert.assertEquals(expectedData.get("salary"), responsePath.get("salary"));
	}

	@Then("^user validates the get emp error response$")
	public void user_validates_the_get_emp_error_response(DataTable errorData) throws Throwable {
		Map<String, String> errorDetails = errorData.asMap(String.class, String.class);
		response.assertThat().statusCode(Integer.parseInt(errorDetails.get("statusCode")));
		String responseString = response.extract().response().asString();

		JsonPath responsePath = new JsonPath(responseString);

		Assert.assertEquals(errorDetails.get("errorCode"), responsePath.get("errorCode"));
		Assert.assertEquals(errorDetails.get("errorDesc"), responsePath.get("errorDesc"));
	}
}
