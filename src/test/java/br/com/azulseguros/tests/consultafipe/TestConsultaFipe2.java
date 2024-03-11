package br.com.azulseguros.tests.consultafipe;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
          features = "src/test/resources/features/consultaFipe/TZ-T4.feature",
          glue = {"br/com/azulseguros/steps"},
          plugin = {"junit:target/cucumber/result.xml", "json:target/cucumber/consultafipe.json"})
class TestConsultaFipe2 {

}
