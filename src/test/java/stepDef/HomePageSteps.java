package stepDef;

import org.junit.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class HomePageSteps {
	HomePage homepage=new HomePage(DriverFactory.getDriver());
	LoginPage loginpage;
	String title;
	
	@When("User opens the url {string}")
	public void user_opens_the_url(String url) {
	    DriverFactory.getDriver().get(url);
	}

	@Then("User get the title")
	public void user_get_the_title() {
		title=homepage.getTitle();
	    
	}

	@Then("Title should be {string}")
	public void title_should_be(String pageTitle) {
	    Assert.assertEquals(title, pageTitle);
	}


	@When("user clicks on signup or login link")
	public void user_clicks_on_signup_or_login_link() {
		loginpage=homepage.clickonSignUpOrIn();
	}

}
