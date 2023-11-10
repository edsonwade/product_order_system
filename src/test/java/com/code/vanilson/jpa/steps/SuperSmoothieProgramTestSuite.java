package com.code.vanilson.jpa.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.pluralsight.bdd.steps",
        features = "src/test/resources/Features/loyalty_cards"
)
public class SuperSmoothieProgramTestSuite {
}
