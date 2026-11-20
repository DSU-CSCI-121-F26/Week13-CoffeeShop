package coffeeshop;

import java.util.ArrayList;

// STEP 5 · CoffeeShop: the shop, its menu, and every order it finished today.
//
// Open UML.md and find "Step 5 · CoffeeShop".
//   4 private fields: name, menu, completedOrders, totalSales
//   1 constructor:    CoffeeShop(String name)
//   7 methods:        getName(), getMenu(), checkout(), getOrdersCompleted(),
//                     getTotalSales(), getItemsSold(), salesReport()
//
// Then drag check/coffeeshop/CoffeeShopTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 5: CoffeeShop

public class CoffeeShop {
    // stores the shop's name
    private String name;
    // holds everything the shop sells
    private Menu menu;
    // saves the orders that already checked out
    private ArrayList<Order> completedOrders;
    // keeps track of the money collected today
    private double totalSales;

    public CoffeeShop(String name) {
        // saves the name given to this shop
        this.name = name;
        // makes the shop's menu
        menu = new Menu();
        // starts an empty list for finished orders
        completedOrders = new ArrayList<Order>();
        // starts today's sales at zero
        totalSales = 0.0;
    }

    public String getName() {
        // gives back the saved name
        return name;
    }

    public Menu getMenu() {
        // gives back the menu belonging to this shop
        return menu;
    }

    public double checkout(Order order, int tipPercent) {
        // checks whether the customer ordered anything
        if (order.isEmpty()) {
            // skips charging or saving an empty order
            return 0.0;
        }
        // gets the amount after the coupon and tip
        double total = order.getTotal(tipPercent);
        // adds this order to the finished orders
        completedOrders.add(order);
        // adds the payment to the day's sales
        totalSales += total;
        // gives back the amount the customer paid
        return total;
    }
    // counts how many orders have checked out
    public int getOrdersCompleted() {
        // uses the number of orders in the finished list
        return completedOrders.size();
    }

    public double getTotalSales() {
        // gives back today's running sales total
        return totalSales;
    }

    public int getItemsSold() {
        // starts the item count at zero
        int total = 0;
        // goes through each order that checked out
        for (Order order : completedOrders) {
            // adds the number of items from that order
            total += order.getItemCount();
        }
        // gives back the combined item count
        return total;
    }

    public String salesReport() {
        // starts the report with the shop's name
        String report = name + " – today's sales\n";
        // adds how many orders checked out
        report += "  Orders: " + getOrdersCompleted() + "\n";
        // adds how many items were sold
        report += "  Items sold: " + getItemsSold() + "\n";
        // shows the sales total with two decimal places
        report += "  Total: $" + String.format("%.2f", totalSales) + "\n";
        // gives back the finished report
        return report;
    }

}
