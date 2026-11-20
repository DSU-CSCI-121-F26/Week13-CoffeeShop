package coffeeshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. Copy it into src/test/java/coffeeshop/ in YOUR coffee-shop
// project, then run it with the green arrow next to the class name.
// Step 1 checks MenuItem.

class MenuItemTest {

    @Test
    void keepsItsName() {
        MenuItem item = new MenuItem("Bagel", 2.75);
        assertEquals("Bagel", item.getName());
    }

    @Test
    void keepsItsPrice() {
        MenuItem item = new MenuItem("Bagel", 2.75);
        assertEquals(2.75, item.getPrice(), 0.001);
    }

    @Test
    void isNotADrink() {
        assertFalse(new MenuItem("Bagel", 2.75).isDrink());
    }

    @Test
    void toStringShowsNameAndPriceWithTwoDecimals() {
        assertEquals("Bagel - $2.75", new MenuItem("Bagel", 2.75).toString());
        assertEquals("Cookie - $1.50", new MenuItem("Cookie", 1.5).toString());
        assertEquals("Water - $1.00", new MenuItem("Water", 1).toString());
    }
}
