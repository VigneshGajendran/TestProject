package api.apis;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.model.createEmpPojo;

public class createEmployee {

	public createEmpPojo createEmpPojo = new createEmpPojo();
	public ObjectMapper reqMapper = new ObjectMapper();

	public void formRequestBody(Map<String, String> empDetails)
			throws JsonParseException, JsonMappingException, IOException {
		createEmpPojo = reqMapper.readValue(new File("src/test/java/com/json/createEmp.json"), createEmpPojo.class);
		createEmpPojo.firstName = empDetails.get("firstName");
		createEmpPojo.lastName = empDetails.get("lastName");
		createEmpPojo.designation = empDetails.get("designation");
		createEmpPojo.salary = empDetails.get("salary");

	}

	public createEmpPojo requestDetails() {
		return createEmpPojo;
	}

	public ObjectMapper requestMapper() {
		return reqMapper;
	}

}
