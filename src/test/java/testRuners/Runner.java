package testRuners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/resources/features"},
		glue= {"stepDef","appHooks"},
		plugin= {"pretty",
				"html:target/cucumberReport.html",
				"rerun:target/failedRun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-out-thread/"
		},
		publish=true
		)
public class Runner {

}
