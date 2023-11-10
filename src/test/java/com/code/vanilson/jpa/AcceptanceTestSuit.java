package com.code.vanilson.jpa;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = "com.pluralsight.bdd.steps",
        features ="classpath:features"
)
public class AcceptanceTestSuit {
}
