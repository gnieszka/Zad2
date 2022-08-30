package Cucumber.Test;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/Cucumber/Features/",
        plugin = {"pretty","html:out.html"})

public class FinalTasksTests {
}