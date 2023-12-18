package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\JavaPrograms\\Teslaproject\\src\\main\\java\\featurefile",glue = {"stepdefinition"} ,dryRun = false, plugin = {"pretty" , "html:target/report.html"})

public class TestRunner {

}
