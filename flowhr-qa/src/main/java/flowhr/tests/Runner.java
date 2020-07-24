package flowhr.tests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import flowhr.core.BaseTest;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/flowhr/tests/features/realizar_login.feature",
        tags = "@login", plugin = {"json:target/cucumber-report/cucumber.json"})

public class Runner extends BaseTest {
}
