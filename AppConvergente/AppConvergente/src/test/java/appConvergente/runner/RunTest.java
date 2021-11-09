package appConvergente.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;


@CucumberOptions(
		features={"src//test//resources//features"},
		glue={"appConvergente.helpers",
				"appConvergente.steps.appConvergente"},
		plugin = {"pretty", "html:target/cucumber"},
		tags = {"@Caso1"},
		monochrome = false
	)

@Test
public class RunTest extends AbstractTestNGCucumberTests{

}
