package runnerTest1;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions
	     (
	    		 features ={".//FeaturesFile/Customers.feature"}, 
	                 glue = "stepDefination",
	                 dryRun = false,
	                 monochrome = true,
	                 plugin = {"pretty",
	        	       		  "html:target/html/htmlreport.html",
	          	  			"json:target/json/file.json",}
	             
                    // tags = {"@sanity, @regression"}
	      )
	
public class TestRunner1 {

}
