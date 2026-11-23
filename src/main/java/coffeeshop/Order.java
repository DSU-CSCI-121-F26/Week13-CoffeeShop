package coffeeshop;

import java.util.ArrayList;

// STEP 4 · Order: one customer's order.
//
// Open UML.md and find "Step 4 · Order". This is the biggest class. Build it one method at a
// time, and run the test after each one.
//   2 constants:      COUPON_CODE, COUPON_PERCENT   (public static final)
//   1 static field:   nextOrderNumber, starts at 1
//   3 private fields: orderNumber, items, discountPercent
//   1 constructor:    Order()
//   10 methods:       getOrderNumber(), addItem(), removeItem(), getItemCount(), isEmpty(),
//                     getSubtotal(), applyCoupon(), getDiscount(), getTotal(), toString()
//
// Then drag check/coffeeshop/OrderTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 4: Order

public class Order {
    final String COUPON_CODE = "HORNET10";
    final int COUPON_PERCENT = 10;
    private static int nextOrderNumber = 1;

    private int orderNumber;
    private ArrayList<MenuItem> items;
    private int discountPercent;

    public Order() {
        orderNumber = nextOrderNumber;
        nextOrderNumber++;
        items = new ArrayList<>();
        this.discountPercent = 0;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void addItem(MenuItem item) {
        if (item != null) {
            items.add(item);
        }
    }
    public boolean removeItem(int number) {
        if (number < 0 || number >= items.size()) {
            return false;
        }
        items.remove(number);
        return true;
    }
    public int getItemCount() {
        return items.size();
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public double getSubtotal() {
        double subtotal = 0.0;
        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }
    public boolean applyCoupon(String code) {
        if (COUPON_CODE.equals(code)) {
            discountPercent = COUPON_PERCENT;
            return true;
        }
        return false;
    }
    public double getDiscount() {
        return getSubtotal() * (discountPercent / 100.0);
    }

    /**
     * Calculates the final total after discount and adding a tip percentage.
     */
    public double getTotal(int tipPercent) {
        double discountedTotal = getSubtotal() - getDiscount();
        double tipAmount = discountedTotal * (tipPercent / 100.0);
        return discountedTotal + tipAmount;
    }

    /**
     * Returns a string representation of the order details.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order #").append(orderNumber).append("\n");
        sb.append("Items:\n");
        for (MenuItem item : items) {
            sb.append(" - ").append(item.toString()).append("\n");
        }
        sb.append("Subtotal: $").append(String.format("%.2f", getSubtotal())).append("\n");
        sb.append("Discount: $").append(String.format("%.2f", getDiscount())).append("\n");
        sb.append("Total (0% tip): $").append(String.format("%.2f", getTotal(0))).append("\n");
        return sb.toString();
    }

    // YOUR CODE

}
