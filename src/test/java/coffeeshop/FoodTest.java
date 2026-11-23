package coffeeshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. Copy it into src/test/java/coffeeshop/ in YOUR coffee-shop
// project, then run it with the green arrow next to the class name.
// Step 2 checks Food.

class FoodTest {

    @Test
    void isAMenuItemButNotADrink() {
        MenuItem item = new Food("Bagel", 2.75, false);
        assertEquals("Bagel", item.getName());
        assertFalse(item.isDrink());
    }

    @Test
    void remembersIfItIsHeated() {
        assertTrue(new Food("Bagel", 2.75, true).isHeated());
        assertFalse(new Food("Bagel", 2.75, false).isHeated());
    }

    @Test
    void notHeatedCostsThePrice() {
        assertEquals(2.75, new Food("Bagel", 2.75, false).getPrice(), 0.001);
    }

    @Test
    void heatedCostsFiftyCentsMore() {
        assertEquals(3.25, new Food("Bagel", 2.75, true).getPrice(), 0.001);
    }

    @Test
    void toStringSaysHeated() {
        assertEquals("Bagel, heated - $3.25", new Food("Bagel", 2.75, true).toString());
    }

    @Test
    void toStringNotHeatedLooksLikeAMenuItem() {
        assertEquals("Bagel - $2.75", new Food("Bagel", 2.75, false).toString());
    }

    @Test
    void heatFeeIsAConstant() {
        assertEquals(0.50, Food.HEAT_FEE, 0.001);
    }
}
