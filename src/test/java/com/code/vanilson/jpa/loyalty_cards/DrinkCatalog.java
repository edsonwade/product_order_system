package com.code.vanilson.jpa.loyalty_cards;

import java.util.HashMap;
import java.util.Map;

public class DrinkCatalog {
    Map<String , String> drinkCategories = new HashMap<>();
    public void add(String drink, String category) {
        drinkCategories.put(drink, category);
    }
}
