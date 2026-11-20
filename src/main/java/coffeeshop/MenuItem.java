package coffeeshop;

// STEP 1 · MenuItem: one thing you can buy at the coffee shop.
//
// Open UML.md and find "Step 1 · MenuItem". Build everything in that table:
//   2 private fields:  name, price
//   1 constructor:     MenuItem(String name, double price)
//   4 methods:         getName(), getPrice(), isDrink(), toString()
//
// Then drag check/coffeeshop/MenuItemTest.java into src/test/java/coffeeshop/ and run it.
// Commit message when it is all green:  step 1: MenuItem
//Build By: Lu-kee Tucker
public class MenuItem {

    private String name;
    private double price;

    // Creates a menu item with a name and price.
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Returns the name of the item.
    public String getName() {
        return name;
    }

    // Returns the price of the item.
    public double getPrice() {
        return price;
    }

    // Returns false because a generic menu item is not necessarily a drink.
    public boolean isDrink() {
        return false;
    }

    // Returns the item as text.
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", getPrice());
    }

}
