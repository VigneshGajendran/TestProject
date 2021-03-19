Feature: CRUD operations for REST API 

@CreateEmployeeSuccessScenarios 
Scenario Outline: creating employee records successfully 
	Given user sends the below details in request 
		|firstName|<firstName>|
		|secondName|<secondName>|
		|designation|<designation>|
		|salary|<salary>|
	When user sends the data to create data 
	Then validate whether response is success with status code as "<statusCode>" 
	Examples: 
		|firstName|secondName|designation|salary|statusCode|
		|John|Johnson|Associate|10000|201|
		|ValidateFirstNameEleAcceptingMoreThanFiftyCharactr|Peter|Senior Associate|99999|201|
		|Peter|ValidateLastNameEleAcceptingMoreThanFiftyCharacter|Consultant|100000|201|
		|Mathew|Matt|Principal Consultants|100000|201|
		
		@CreateEmployeeErrorScenarios 
		Scenario Outline: creating employee records successfully 
			Given user sends the below details in request 
				|firstName|<firstName>|
				|secondName|<secondName>|
				|designation|<designation>|
				|salary|<salary>|
			When user sends the data to create data 
			# Error Code and Desc are written in assumption for testing purpose
			Then validate the create employee error response  
				|errorCode|<errorCode>|
				|errorDesc|<errorDesc>| 
				|statusCode|<statusCode>|
			Examples: 
				|firstName|secondName|designation|salary|errorCode|errorDesc|statusCode|				
				|ValidateFirstNameEleAcceptingMoreThanFiftyCharacter|Peter|Senior Associate|99999|10002|First name should not be more than 50 characters|400|
				|Peter|ValidateLastNameEleAcceptingMoreThanFiftyCharacter|Consultant|100000|10002|Last name should not be more than 50 characters|400|
				|Mathew|Matt|Sr Principal consulnt|100000|10002|Designation should not be more than 20 characters|400|
				|Andrew|Brown|Sr Principal consult|100001|10003|Salary Cannot be more than 100000 |400|
				|Mathew|Matt|Sr Principal consult|999999|10003|Salary Cannot be more than 100000 |400|
				|Mathew|Matt|Sr Principal consult|One Lash|10000|Only Numeric characters are allowed |400|
				|Mathew|Matt|Sr Principal consult|$10000|10000|Only Numeric characters are allowed |400|
				