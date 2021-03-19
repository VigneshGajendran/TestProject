Feature: Validate the email 

@emailSuccessValidations 
Scenario Outline: validating the email 
	Given user sends the "<emailId>" 
	Then validate the "<status>" 
	
	Examples: 
		|emailId|status|
		|abc@gmail.com|true|
		|abcgmail.com|false|
		|abc1@gmail.com|true|
		|1abc@gmail.com|true|
		|@abc@gmail.com|false|
		|test@abc@gmail.com|false|
		|$abc@gmail.com|true|
		|abc#@gmail.com|true|
		|2213abc#@gmail.com|true|