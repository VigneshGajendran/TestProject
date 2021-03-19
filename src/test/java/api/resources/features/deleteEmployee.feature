Feature: delete employee details 

@DeletemployeeSuccessScenarios 
Scenario Outline: Get employee details successfully 
	Given user hits the delete employee api "<empId>" 
	Then validate whether employee details is deleted "<statusCode>" 
	
	
	Examples: 
		|empId|statusCode|
		|111|410|
		
		@DeletemployeeErrorScenarios 
		Scenario Outline: Get employee details successfully 
			Given user hits the delete employee api "<empId>" 
			# Error Code and Desc are written in assumption for testing purpose
			Then  validate the delete api error response 
				|empId|<empId>|
				|errorCode|<errorCode>|
				|errorDesc|<errorDesc>| 
				|statusCode|<statusCode>|
				
				
			Examples: 
				|empId|statusCode|errorDesc|errorCode|
				|Five|400|only numeric charaters are allowed|10001|
				|#111|400|only numeric charaters are allowed|10001|
				|5555|400|Invalid Employee Id|10001|
				