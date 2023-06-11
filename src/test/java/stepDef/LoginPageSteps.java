package stepDef;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private LoginPage loginpage=new LoginPage(DriverFactory.getDriver());
	private HomePage homepage;
	String validationMsg;
	
	@When("user enters username {string} and password {string}")
	public void user_enters_username_and_password(String user, String pass) {
		loginpage.enterUserName(user);
		loginpage.enterPassword(pass);
	}

	@When("clicks on Login button")
	public void clicks_on_login_button() {
	    loginpage.clickOnLogin();
	}

	@Then("user moves to homepage")
	public void user_moves_to_homepage() {
	    homepage=loginpage.navigateToHomePage();
	}

	@Then("menu should contain {string}")
	public void menu_should_contain(String loggedinMsg) {
	    //homepage=new HomePage(DriverFactory.getDriver());
	    Assert.assertEquals(homepage.getLoginMsg(),loggedinMsg);
	}

	@Then("user gets the validation msg")
	public void user_gets_the_validation_msg() {
		validationMsg=loginpage.getErrMsg();
	}

	@Then("validation msg should be {string}")
	public void validation_msg_should_be(String validMsg) {
	    Assert.assertEquals(validationMsg, validMsg);
	}
}
