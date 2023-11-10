package com.code.vanilson.jpa.steps;

import com.code.vanilson.jpa.loyalty_cards.DrinkCatalog;
import com.code.vanilson.jpa.loyalty_cards.SuperSmoothieSchema;
import com.code.vanilson.jpa.loyalty_cards.MorningFreshnessMember;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class SuperSmoothieStepDefinitions {

    private DrinkCatalog drinkCatalog = new DrinkCatalog();
    SuperSmoothieSchema superSmoothieSchema = new SuperSmoothieSchema();

    MorningFreshnessMember vanilson;

    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategories) {
        drinkCategories.stream().forEach(
                drinkCategory -> {
                    String drink = drinkCategory.get("Drink");
                    String category = drinkCategory.get("Category");
                    Integer points = Integer.parseInt(drinkCategory
                            .get("Points"));

                    drinkCatalog.add(drink, category);

                    superSmoothieSchema.setPointsPerCategory(category, points);

                }
        );
    }

    @Given("^(.*) is a Morning Freshness member")
    public void vanilson_is_a_Morning_Freshness_member(String name) {
         vanilson = new MorningFreshnessMember(name);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void vanilson_purchases_Apple_and_Kale_drinks(
            String name,
            int amount,
            String drink) {

        vanilson.orders(amount, drink);

    }

    @Then("he should earn {int} points")
    public void he_should_earn_points(int expectedPoints) {
        Assertions.assertThat(vanilson.getPoints()).isEqualTo(expectedPoints);
    }
}
