package org.ubs;
import java.util.HashMap;
import java.util.Map;

public class ShoppingBasketCalculator {

    public static void main(String[] args) {
        // Example basket
        String[] basket = {"Apple", "Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime"};

        // Calculate and print the total cost
        int totalCost = calculateTotalCost(basket);
        System.out.println("Total cost: " + totalCost + "p");
    }

    public static int calculateTotalCost(String[] basket) {
        // Pricing structure as per problem
        Map<String, Integer> prices = new HashMap<>();
        prices.put("Apple", 35);
        prices.put("Banana", 20);
        prices.put("Melon", 50); // Melon Buy one, get one free
        prices.put("Lime", 15);  // Three for the price of two

        // Count items in the basket
        Map<String, Integer> itemCount = new HashMap<>();
        for (String item : basket) {
            itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
        }

        // Calculate total cost
        int totalCost = 0;
        for (Map.Entry<String, Integer> entry : itemCount.entrySet()) {
            String item = entry.getKey();
            int count = entry.getValue();
            int price = prices.get(item);

            switch (item) {
                case "Melon":
                    // Buy one, get one free
                    totalCost += (count / 2 + count % 2) * price;
                    break;
                case "Lime":
                    // Three for the price of two
                    totalCost += (count / 3 * 2 + count % 3) * price;
                    break;
                default:
                    // Regular pricing
                    totalCost += count * price;
                    break;
            }
        }

        return totalCost;
    }
}

