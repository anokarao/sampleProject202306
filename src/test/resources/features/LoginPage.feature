Feature: Loginpage Feature

Background:
Given User opens the url "https://automationexercise.com/"
And user clicks on signup or login link

Scenario: Login with correct credentials

When user enters username "anokarb1996@gmail.com" and password "test@1234"
And clicks on Login button
Then user moves to homepage
And menu should contain "Logged in as test qa"

Scenario: Login with incorrect credentials

When user enters username "anokarb1996@gmail.com" and password "test@123"
And clicks on Login button
Then user gets the validation msg
And validation msg should be "Your email or password is incorrect!"

