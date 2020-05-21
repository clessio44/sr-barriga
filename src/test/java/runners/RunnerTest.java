package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature/inserir_conta.feature",
		glue= "stepDefinition",
		tags = {"~@Disabled"},
		snippets = SnippetType.CAMELCASE
		,monochrome = false
		,strict = true
		,dryRun = false
		,plugin = {"pretty", "html:target/report-html"} //relatório html
)

public class RunnerTest {
	

}
