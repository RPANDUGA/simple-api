import org.junit.Test;
import org.ubs.ShoppingBasketCalculator;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketCalculatorTest {

    @Test
    public void testEmptyBasket() {
        String[] basket = {};
        assertEquals("The total cost of an empty basket should be 0.", 0, ShoppingBasketCalculator.calculateTotalCost(basket));
    }

    @Test
    public void testSingleItemBasket() {
        String[] basket = {"Apple"};
        assertEquals("The total cost of a basket with one apple should be 35.", 35, ShoppingBasketCalculator.calculateTotalCost(basket));
    }

    @Test
    public void testMultipleItemsNoOffers() {
        String[] basket = {"Apple", "Banana"};
        assertEquals("The total cost of a basket with an apple and a banana should be 55.", 55, ShoppingBasketCalculator.calculateTotalCost(basket));
    }

    @Test
    public void testMelonOffer() {
        String[] basket = {"Melon", "Melon"};
        assertEquals("The total cost of a basket with two melons (buy one get one free) should be 50.", 50, ShoppingBasketCalculator.calculateTotalCost(basket));
    }

    @Test
    public void testLimeOffer() {
        String[] basket = {"Lime", "Lime", "Lime"};
        assertEquals("The total cost of a basket with three limes (three for the price of two) should be 30.", 30, ShoppingBasketCalculator.calculateTotalCost(basket));
    }

    @Test
    public void testMixedBasketWithOffers() {
        String[] basket = {"Apple", "Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime"};
        assertEquals("The total cost of a mixed basket with various offers applied should be 170.", 170, ShoppingBasketCalculator.calculateTotalCost(basket));
    }

    @Test
    public void testOddNumberMelons() {
        String[] basket = {"Melon", "Melon", "Melon"};
        assertEquals("The total cost of a basket with three melons should account for one free melon.", 100, ShoppingBasketCalculator.calculateTotalCost(basket));
    }

    @Test
    public void testOddNumberLimes() {
        String[] basket = {"Lime", "Lime", "Lime", "Lime"};
        assertEquals("The total cost of a basket with four limes should account for the three for the price of two offer.", 45, ShoppingBasketCalculator.calculateTotalCost(basket));
    }
}
