package com.code.vanilson.jpa.loyalty_cards;

import java.util.HashMap;
import java.util.Map;

public class SuperSmoothieSchema {
    Map<String,Integer> pointsPerCategory = new HashMap<>();
    public void setPointsPerCategory(String category, Integer points) {
        pointsPerCategory.put(category, points);
    }
}
