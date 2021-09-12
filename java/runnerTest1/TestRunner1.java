package runnerTest1;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions
	     (features = "FeaturesFile/Login1.feature", 
	                 glue = "stepDefination",
	                 dryRun = false,
	                 monochrome = true,
	                 plugin = {"pretty","html:test-output"}
	                 //tags = {"@CustomerSearchByName"}
	      )
	
	public class TestRunner1 {	
}
