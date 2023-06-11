package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	private DriverFactory driverfactory;
	private ConfigReader confi;
	private Properties prop;
	WebDriver driver;
	
	@Before(order=0)
	public void getProperties() {
		confi=new ConfigReader();
		prop=confi.readConfig();
	}
	@Before(order=1)
	public void initalizeBrowser() {
		driverfactory=new DriverFactory();
		driver=driverfactory.initialzeDriver(prop.getProperty("browser"));
	}
	
	@After(order=0)
	public void quitDriver() {
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			String screenShotName=scenario.getName().replaceAll(" ", "_");
			byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", screenShotName);
		}
	}

}
