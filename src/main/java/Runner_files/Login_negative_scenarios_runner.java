package Runner_files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
features = "G:\\Mobileautomationloginpositive-main\\src\\main\\java\\Login_negative_scenarios\\Login_negative_scenarios.feature",
glue= {"Login_negative_scenarios"},
monochrome = true,publish = true)
public class Login_negative_scenarios_runner extends AbstractTestNGCucumberTests {

	
}
