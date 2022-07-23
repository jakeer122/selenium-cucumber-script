@Login
Feature: Login funtionality

Background:
Given if user is on home page
When click on login link

@Sanity
Scenario Outline: verify user is able to login with valid credential

And enter login details username as "<username>" and password as "<password>"
Then verify logout link
Examples:
    | username | password |
    | demo     | 1234     |
    | demo10   | 1234     |
    

    

@Regression@Sanity
Scenario: verify user in payment page
And enter login details username as "demo" and password as "1234"
And click pay user link
Then verify payment to user page
