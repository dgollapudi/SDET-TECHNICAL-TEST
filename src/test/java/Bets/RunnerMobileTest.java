package Bets;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/Place-A-Bet.feature/",
        glue = "Bets",
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber/cucumber-json-report.json",
                "rerun:target/rerun.txt"},
        tags = {"@placeabet","@mobile"}
)

public class RunnerMobileTest {
}
