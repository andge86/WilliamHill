package steps_definitions;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resourses/features/placeBet.feature",
        glue={"steps_definitions"},
        plugin = {"pretty", "html:target/cucumber-html-report"}  // Generating html report in project folder
)

public class TestRunner {
}
