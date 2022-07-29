package Stepdef;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = {"featurefile"},
		glue={"Stepdef"},
		//plugin = {"me.jvt.cucumber.report.PrettyReports:target/cucumber" }
		//dryRun = true,
		plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber" },
		//plugin = { "de.monochromata.cucumber.report.PrettyReports:target/cucumber", "json:target/cucumber.json" },
		
	    tags= "@Sanity and not @Regression"

		)
 
public class TestRunner 
{
	
 
} 
