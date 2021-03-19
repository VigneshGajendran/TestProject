Feature: Update employee records 

@updateEmployeeSuccessScenarios 
Scenario Outline: Update employee records successfully 
	Given user sends the below details in update request 
		|empId|<empId>|
		|firstName|<firstName>|
		|secondName|<secondName>|
		|designation|<designation>|
		|salary|<salary>|
	When user sends the data to update employee api 
	Then validate whether update employee response is success with status code as "<statusCode>" 
		|empId|<empId>|
		|firstName|<firstName>|
		|secondName|<secondName>|
		|designation|<designation>|
		|salary|<salary>|
	Examples: 
		|empId|firstName|secondName|designation|salary|statusCode|
		|1111|John|Johnson|Associate|10000|200|
		|222|ValidateFirstNameEleAcceptingMoreThanFiftyCharactr|Peter|Senior Associate|99999|201|
		|333|Peter|ValidateLastNameEleAcceptingMoreThanFiftyCharacter|Consultant|100000|201|
		|444|Mathew|Matt|Principal Consultants|100000|201|
		
		@updateEmployeeErrorScenarios 
		Scenario Outline: Update employee records successfully 
			Given user sends the below details in update request 
				|empId|<empId>|
				|firstName|<firstName>|
				|secondName|<secondName>|
				|designation|<designation>|
				|salary|<salary>|
			When user sends the data to update employee api 
			Then validate the update employee error response 
				|errorCode|<errorCode>|
				|errorDesc|<errorDesc>| 
				|statusCode|<statusCode>|
				
			Examples: 
				|empId|firstName|secondName|designation|salary|errorCode|errorDesc|statusCode|				
				|101|ValidateFirstNameEleAcceptingMoreThanFiftyCharacter|Peter|Senior Associate|99999|10002|First name should not be more than 50 characters|400|
				|102|Peter|ValidateLastNameEleAcceptingMoreThanFiftyCharacter|Consultant|100000|10002|Last name should not be more than 50 characters|400|
				|103|Mathew|Matt|Sr Principal consulnt|100000|10002|Designation should not be more than 20 characters|400|
				|104|Andrew|Brown|Sr Principal consult|100001|10003|Salary Cannot be more than 100000 |400|
				|105|Mathew|Matt|Sr Principal consult|999999|10003|Salary Cannot be more than 100000 |400|
				|106|Mathew|Matt|Sr Principal consult|One Lash|10000|Only Numeric characters are allowed |400|
				|107|Mathew|Matt|Sr Principal consult|$10000|10000|Only Numeric characters are allowed |400|
				