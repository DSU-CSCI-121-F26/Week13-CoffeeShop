package coffeeshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. Copy it into src/test/java/coffeeshop/ in YOUR coffee-shop
// project, then run it with the green arrow next to the class name.
// Step 3 checks Menu.

class MenuTest {

    @Test
    void hasEightItems() {
        assertEquals(8, new Menu().size());
    }

    @Test
    void itemOneIsSmallCoffee() {
        MenuItem item = new Menu().getItem(1);
        assertEquals("Coffee", item.getName());
        assertEquals(2.00, item.getPrice(), 0.001);
        assertTrue(item.isDrink());
    }

    @Test
    void itemsAreInTheOrderFromTheTable() {
        Menu menu = new Menu();
        String[] names = {"Coffee", "Latte", "Cappuccino", "Hot Chocolate", "Iced Tea",
                "Bagel", "Blueberry Muffin", "Breakfast Sandwich"};
        double[] prices = {2.00, 3.25, 3.25, 2.50, 2.25, 2.75, 2.50, 4.50};
        for (int i = 0; i < names.length; i++) {
            assertEquals(names[i], menu.getItem(i + 1).getName(), "item " + (i + 1));
            assertEquals(prices[i], menu.getItem(i + 1).getPrice(), 0.001, "item " + (i + 1));
        }
    }

    @Test
    void drinksAreOneToFiveFoodIsSixToEight() {
        Menu menu = new Menu();
        for (int n = 1; n <= 5; n++) {
            assertTrue(menu.getItem(n).isDrink(), "item " + n + " should be a drink");
        }
        for (int n = 6; n <= 8; n++) {
            assertFalse(menu.getItem(n).isDrink(), "item " + n + " should be food");
        }
    }

    @Test
    void numbersOutsideTheMenuGiveNull() {
        Menu menu = new Menu();
        assertNull(menu.getItem(0));
        assertNull(menu.getItem(9));
        assertNull(menu.getItem(-3));
    }

    @Test
    void toStringNumbersEveryLine() {
        String text = new Menu().toString();
        assertTrue(text.contains("1. Coffee (S) - $2.00"), text);
        assertTrue(text.contains("6. Bagel - $2.75"), text);
        assertTrue(text.contains("8. Breakfast Sandwich - $4.50"), text);
    }
}
