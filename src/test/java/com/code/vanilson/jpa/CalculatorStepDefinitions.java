package com.code.vanilson.jpa;

import com.code.vanilson.jpa.calculator.Calculator;
import com.code.vanilson.jpa.shop.Shopping;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorStepDefinitions {

    Calculator calculator;
    Shopping shopping;
    Integer result;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator  = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(Integer a, Integer b) {
        result = calculator.add(a,b);
    }

    @Then("I should get {int}")
    public void i_should_get(Integer expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }


    @Given("Vanilson is a Freshness member")
    public void vanilson_is_a_Morning_Freshness_member() {
          shopping = new Shopping();
    }

    @When("Vanilson purchases {int} Banana smoothie")
    public void vanilson_purchases_Banana_smoothie(Integer int1) {
       result = shopping.earnPoint(int1);
    }

    @Then("I should earn {int} points")
    public void I_should_earn_points(Integer expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }


}
