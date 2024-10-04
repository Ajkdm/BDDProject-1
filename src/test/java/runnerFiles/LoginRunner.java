package runnerFiles;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="./FeatureFiles/Login.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true,
		plugin={"pretty","html:Reports/HTML_Report.html",
				"json:Reports/JSON_Report.json",
				"junit:Reports/XML_Report.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		}
		
		)
public class LoginRunner 
{

}
