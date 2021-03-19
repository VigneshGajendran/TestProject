package api.apis;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.model.createEmpPojo;
import api.model.updateEmpPojo;

public class updateEmployee {
	public updateEmpPojo updateEmpPojo = new updateEmpPojo();
	public ObjectMapper reqMapper = new ObjectMapper();

	public void formRequestBody(Map<String, String> empDetails)
			throws JsonParseException, JsonMappingException, IOException {
		updateEmpPojo = reqMapper.readValue(new File("src/test/java/com/json/updateEmployee.json"),
				updateEmpPojo.class);
		updateEmpPojo.id = Long.parseLong(empDetails.get("empId"));

		if (null != empDetails.get("firstName")) {
			updateEmpPojo.firstName = empDetails.get("firstName");
		}

		if (null != empDetails.get("lastName")) {

			updateEmpPojo.lastName = empDetails.get("lastName");
		}

		if (null != empDetails.get("designation")) {
			updateEmpPojo.designation = empDetails.get("designation");
		}

		if (null != empDetails.get("salary")) {
			updateEmpPojo.salary = Integer.parseInt(empDetails.get("salary"));
		}
	}

	public updateEmpPojo requestDetails() {
		return updateEmpPojo;
	}

	public ObjectMapper requestMapper() {
		return reqMapper;
	}

}
