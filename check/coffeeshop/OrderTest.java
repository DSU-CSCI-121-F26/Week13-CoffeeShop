package coffeeshop;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. Copy it into src/test/java/coffeeshop/ in YOUR coffee-shop
// project, then run it with the green arrow next to the class name.
// Step 4 checks Order.

class OrderTest {

    private Order latteAndBagel() {
        Order order = new Order();
        order.addItem(new Drink("Latte", 3.25, 'M'));    // 3.75
        order.addItem(new Food("Bagel", 2.75, true));    // 3.25
        return order;
    }

    @Test
    void newOrderIsEmpty() {
        Order order = new Order();
        assertTrue(order.isEmpty());
        assertEquals(0, order.getItemCount());
        assertEquals(0.0, order.getSubtotal(), 0.001);
    }

    @Test
    void eachNewOrderGetsTheNextNumber() {
        Order first = new Order();
        Order second = new Order();
        assertEquals(first.getOrderNumber() + 1, second.getOrderNumber());
    }

    @Test
    void addItemCountsItems() {
        Order order = latteAndBagel();
        assertEquals(2, order.getItemCount());
        assertFalse(order.isEmpty());
    }

    @Test
    void subtotalUsesEachItemsOwnPrice() {
        assertEquals(7.00, latteAndBagel().getSubtotal(), 0.001);
    }

    @Test
    void removeItemStartsCountingAtOne() {
        Order order = latteAndBagel();
        assertTrue(order.removeItem(1));
        assertEquals(1, order.getItemCount());
        assertEquals(3.25, order.getSubtotal(), 0.001);
    }

    @Test
    void removeItemThatIsNotThereGivesFalse() {
        Order order = latteAndBagel();
        assertFalse(order.removeItem(0));
        assertFalse(order.removeItem(3));
        assertEquals(2, order.getItemCount());
    }

    @Test
    void goodCouponTakesTenPercentOff() {
        Order order = latteAndBagel();
        assertTrue(order.applyCoupon("HORNET10"));
        assertEquals(0.70, order.getDiscount(), 0.001);
    }

    @Test
    void couponIgnoresCaseAndSpaces() {
        assertTrue(latteAndBagel().applyCoupon("  hornet10 "));
    }

    @Test
    void badCouponDoesNothing() {
        Order order = latteAndBagel();
        assertFalse(order.applyCoupon("FREECOFFEE"));
        assertEquals(0.0, order.getDiscount(), 0.001);
    }

    @Test
    void totalWithNoTipAndNoCoupon() {
        assertEquals(7.00, latteAndBagel().getTotal(0), 0.001);
    }

    @Test
    void totalAddsTheTip() {
        assertEquals(8.40, latteAndBagel().getTotal(20), 0.001);
    }

    @Test
    void tipIsOnThePriceAfterTheCoupon() {
        Order order = latteAndBagel();
        order.applyCoupon("HORNET10");
        // 7.00 - 0.70 = 6.30, plus 20% tip of 6.30 (1.26) = 7.56
        assertEquals(7.56, order.getTotal(20), 0.001);
    }

    @Test
    void negativeTipCountsAsZero() {
        assertEquals(7.00, latteAndBagel().getTotal(-15), 0.001);
    }

    @Test
    void toStringListsTheItemsAndSubtotal() {
        Order order = latteAndBagel();
        String text = order.toString();
        assertTrue(text.contains("Order #" + order.getOrderNumber()), text);
        assertTrue(text.contains("1. Latte (M) - $3.75"), text);
        assertTrue(text.contains("2. Bagel, heated - $3.25"), text);
        assertTrue(text.contains("Subtotal: $7.00"), text);
    }

    @Test
    void couponCodeIsAConstant() {
        assertEquals("HORNET10", Order.COUPON_CODE);
        assertEquals(10, Order.COUPON_PERCENT);
    }
}
