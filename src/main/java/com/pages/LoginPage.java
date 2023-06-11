package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	private By user=By.xpath("//input[@data-qa='login-email']");
	private By pass=By.xpath("//input[@placeholder='Password']");
	private By loginBtn=By.xpath("//button[normalize-space()='Login']");
	private By errMsg=By.xpath("//input[@placeholder='Password']/following-sibling::p");

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getTitle() {
		return driver.getTitle().trim();
	}
	
	public void enterUserName(String username) {
		driver.findElement(user).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(pass).sendKeys(password);
	}
	public void clickOnLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public HomePage navigateToHomePage() {
		return new HomePage(driver);
	}
	
	public String getErrMsg() {
		return driver.findElement(errMsg).getText();
	}
}
