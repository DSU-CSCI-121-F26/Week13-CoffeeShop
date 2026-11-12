package coffeeshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. Copy it into src/test/java/coffeeshop/ in YOUR coffee-shop
// project, then run it with the green arrow next to the class name.
// Step 5 checks CoffeeShop.

class CoffeeShopTest {

    private Order latteAndBagel() {
        Order order = new Order();
        order.addItem(new Drink("Latte", 3.25, 'M'));    // 3.75
        order.addItem(new Food("Bagel", 2.75, true));    // 3.25
        return order;
    }

    @Test
    void keepsItsNameAndHasAMenu() {
        CoffeeShop shop = new CoffeeShop("Hornet Coffee");
        assertEquals("Hornet Coffee", shop.getName());
        assertEquals(8, shop.getMenu().size());
    }

    @Test
    void newShopHasNoSales() {
        CoffeeShop shop = new CoffeeShop("Hornet Coffee");
        assertEquals(0, shop.getOrdersCompleted());
        assertEquals(0, shop.getItemsSold());
        assertEquals(0.0, shop.getTotalSales(), 0.001);
    }

    @Test
    void checkoutGivesBackTheTotal() {
        CoffeeShop shop = new CoffeeShop("Hornet Coffee");
        assertEquals(8.40, shop.checkout(latteAndBagel(), 20), 0.001);
    }

    @Test
    void checkoutAddsUpSales() {
        CoffeeShop shop = new CoffeeShop("Hornet Coffee");
        shop.checkout(latteAndBagel(), 0);     // 7.00
        shop.checkout(latteAndBagel(), 20);    // 8.40
        assertEquals(2, shop.getOrdersCompleted());
        assertEquals(4, shop.getItemsSold());
        assertEquals(15.40, shop.getTotalSales(), 0.001);
    }

    @Test
    void emptyOrderIsNotRecorded() {
        CoffeeShop shop = new CoffeeShop("Hornet Coffee");
        assertEquals(0.0, shop.checkout(new Order(), 20), 0.001);
        assertEquals(0, shop.getOrdersCompleted());
    }

    @Test
    void salesReportShowsTheNumbers() {
        CoffeeShop shop = new CoffeeShop("Hornet Coffee");
        shop.checkout(latteAndBagel(), 20);
        String report = shop.salesReport();
        assertTrue(report.contains("Hornet Coffee"), report);
        assertTrue(report.contains("Orders: 1"), report);
        assertTrue(report.contains("Items sold: 2"), report);
        assertTrue(report.contains("Total: $8.40"), report);
    }
}
