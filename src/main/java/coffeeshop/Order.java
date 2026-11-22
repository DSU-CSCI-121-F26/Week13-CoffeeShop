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

    public static final String COUPON_CODE = "HORNET10";
    public static final int COUPON_PERCENT = 10;

    private static int nextOrderNumber = 1;

    private int orderNumber;
    private ArrayList<MenuItem> items;
    private int discountPercent;

    public Order() {
        orderNumber = nextOrderNumber++;

        items = new ArrayList<>();
        discountPercent = 0;
    }
    // Returns this order's number.
    public int getOrderNumber() {
        return orderNumber;
    }
    // Adds an item to the order.
    public void addItem(MenuItem item) {
        items.add(item);
    }
    // Returns how many items are in the order.
    public int getItemCount() {
        return items.size();
    }
    // Returns true if the order has no items.
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public boolean removeItem(int number) {

        if (number < 1 || number > items.size()) {
            return false;
        }

        items.remove(number - 1);
        return true;
    }
    // Returns the total price of all items before discounts and tips.
    public double getSubtotal() {

        double subtotal = 0.0;

        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }

        return subtotal;
    }
    // Applies a coupon code to the order.
    public boolean applyCoupon(String code) {

        if (code.trim().equalsIgnoreCase(COUPON_CODE)) {
            discountPercent = COUPON_PERCENT;
            return true;
        }

        return false;
    }
    // Returns the dollar amount of the discount.
    public double getDiscount() {
        return getSubtotal() * discountPercent / 100.0;
    }
    // Returns the final total after discount and tip.
    public double getTotal(int tipPercent) {

        if (tipPercent<0){
            tipPercent = 0;
        }

        double afterDiscount = getSubtotal() - getDiscount();

        double tip = afterDiscount * tipPercent / 100.0;

        return afterDiscount + tip;
    }
    @Override
    public String toString() {

        String result = "Order #" + orderNumber + "\n";

        for (int i = 0; i < items.size(); i++) {
            result += (i + 1) + ". " + items.get(i) + "\n";
        }

        result += "Subtotal: $" +
                String.format("%.2f", getSubtotal());

        return result;
    }


}
