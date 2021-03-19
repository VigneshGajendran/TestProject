Feature: Get employee details 

@GeEmployeeSuccessScenarios 
Scenario Outline: Get employee details successfully 
	Given user hits the get employee api to fetch "<allOrEmpId>" the employee details 
		|empId|<empId>|
	Then validate whether below employee details is present in the list 
		|empId|<empId>|
		|firstName|<firstName>|
		|secondName|<secondName>|
		|designation|<designation>|
		|salary|<salary>|
		
	Examples: 
		|allOrEmpId|empId|firstName|secondName|designation|salary|statusCode|
		|all|1111|John|Johnson|Associate|10000|201|
		|empId|1111|John|Johnson|Associate|10000|201|
		
		@GeEmployeeErrorScenarios 
		Scenario Outline: validate Get employee error scenarios 
			Given user hits the get employee api to fetch "<allOrEmpId>" the employee details 
				|empId|<empId> | 
				# Error Code and Desc are written in assumption for testing purpose
			Then user validates the get emp error response 
				|empId|<empId>|
				|errorCode|<errorCode>|
				|errorDesc|<errorDesc>| 
				|statusCode|<statusCode>|
				
			Examples: 
				|allOrEmpId|empId|errorCode|errorDesc|statusCode|
				|empId|Five|400|only numeric charaters are allowed|10001|
				|empId|#1111|400|only numeric charaters are allowed|10001|
				|empId|5555|400|Invalid employee id|10001|
				
				