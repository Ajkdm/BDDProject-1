Feature: Login

Scenario: Succesfull login with valid credentials
Given user launch chrome browser
When user opens URL "https://www.saucedemo.com/"
And user enters email as "standard_user" and password as "secret_sauce"
And click on login button
Then page title should be "Swag Labs"
When user clicks on logout button
Then page title should be "Swag Labs"
And close browser

Scenario Outline: Succesfull login with set of credentials
Given user launch chrome browser
When user opens URL "https://www.saucedemo.com/"
And user enters email as "<email>" and password as "<password>"
And click on login button
Then page title should be "Swag Labs"
When user clicks on logout button
Then page title should be "Swag Labs"
And close browser
Examples:
|email|password|
|standard_user|secret_sauce|
|test|secret_sauce|
