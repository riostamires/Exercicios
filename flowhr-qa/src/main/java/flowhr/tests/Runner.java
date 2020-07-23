package flowhr.tests;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import flowhr.core.BaseTest;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/java/flowhr/tests/features/consultar_vagas_flowhr.feature",
        tags = "@vagas", plugin = {"json:target/cucumber-report/cucumber.json"})

public class Runner extends BaseTest {
}
