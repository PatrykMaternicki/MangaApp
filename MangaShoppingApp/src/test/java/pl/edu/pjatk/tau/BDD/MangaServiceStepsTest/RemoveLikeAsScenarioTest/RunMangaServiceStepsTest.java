package pl.edu.pjatk.tau.BDD.MangaServiceStepsTest.RemoveLikeAsScenarioTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "classpath:MangaService/RemoveAsScenario/MangaServiceTest.feature"
)
public class RunMangaServiceStepsTest {
}
