package pl.edu.pjatk.tau.BDD.MangaServiceStepsTest.LikeAsScenarioTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = { "pretty", "html:target/cucumber" },
        features = "classpath:MangaService/MangaServiceTestException.feature"
)
public class RunMangaServiceStepsExceptionTest {
}