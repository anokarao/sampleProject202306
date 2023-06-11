Feature: Homepage feature

Scenario: verify Home page title

When User opens the url "https://automationexercise.com/"
Then User get the title 
And Title should be "Automation Exercise"

Scenario: Verify Login or signup page openeing
Given User opens the url "https://automationexercise.com/"
When user clicks on signup or login link
Then User get the title 
And Title should be "Automation Exercise - Signup / Login"
