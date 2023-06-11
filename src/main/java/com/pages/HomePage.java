package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	private By signupOrLogin=By.xpath("//a[normalize-space()='Signup / Login']");
	private By signinMsg=By.xpath("//a[normalize-space()='Contact us']/parent::li/following-sibling::li/a");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage clickonSignUpOrIn() {
		driver.findElement(signupOrLogin).click();
		return new LoginPage(driver);
	}
	public String getTitle() {
		return driver.getTitle().trim();
	}
	
	public String getLoginMsg() {
		return driver.findElement(signinMsg).getText();
	}

}
