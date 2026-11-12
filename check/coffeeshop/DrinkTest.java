package coffeeshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. Copy it into src/test/java/coffeeshop/ in YOUR coffee-shop
// project, then run it with the green arrow next to the class name.
// Step 2 checks Drink.

class DrinkTest {

    @Test
    void isAMenuItem() {
        MenuItem item = new Drink("Latte", 3.25, 'S');
        assertEquals("Latte", item.getName());
    }

    @Test
    void isADrink() {
        assertTrue(new Drink("Latte", 3.25, 'S').isDrink());
    }

    @Test
    void smallCostsThePrice() {
        assertEquals(3.25, new Drink("Latte", 3.25, 'S').getPrice(), 0.001);
    }

    @Test
    void mediumCostsFiftyCentsMore() {
        assertEquals(3.75, new Drink("Latte", 3.25, 'M').getPrice(), 0.001);
    }

    @Test
    void largeCostsOneDollarMore() {
        assertEquals(4.25, new Drink("Latte", 3.25, 'L').getPrice(), 0.001);
    }

    @Test
    void lowerCaseSizeBecomesUpperCase() {
        assertEquals('M', new Drink("Latte", 3.25, 'm').getSize());
        assertEquals('L', new Drink("Latte", 3.25, 'l').getSize());
    }

    @Test
    void anyOtherSizeBecomesSmall() {
        assertEquals('S', new Drink("Latte", 3.25, 'X').getSize());
        assertEquals(3.25, new Drink("Latte", 3.25, 'X').getPrice(), 0.001);
    }

    @Test
    void toStringShowsTheSize() {
        assertEquals("Latte (M) - $3.75", new Drink("Latte", 3.25, 'M').toString());
        assertEquals("Coffee (S) - $2.00", new Drink("Coffee", 2.00, 's').toString());
    }

    @Test
    void upchargesAreConstants() {
        assertEquals(0.50, Drink.MEDIUM_UPCHARGE, 0.001);
        assertEquals(1.00, Drink.LARGE_UPCHARGE, 0.001);
    }
}
