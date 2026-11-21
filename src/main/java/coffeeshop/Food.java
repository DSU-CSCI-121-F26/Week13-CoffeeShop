package coffeeshop;

// STEP 2 · Food: a MenuItem that can be heated up for 50 cents.
//
// Open UML.md and find "Step 2 · Food extends MenuItem".
// First change the class line below to:   public class Food extends MenuItem {
//
//   1 constant:      HEAT_FEE   (public static final double)
//   1 private field: heated
//   1 constructor:   Food(String name, double price, boolean heated). Its first line is super(name, price);
//   3 methods:       isHeated(), and the overrides getPrice(), toString()
//
// Then drag check/coffeeshop/FoodTest.java into src/test/java/coffeeshop/ and run it.
// Commit message (after Drink is green too):  step 2: Drink and Food
//Build By: Lu-kee Tucker

public class Food extends MenuItem {

    // YOUR CODE
    public static final double HEAT_FEE = 0.50;

    private boolean heated;

    // Creates a food item with a name, price, and heated status.
    public Food(String name, double price, boolean heated) {
        super(name, price);
        this.heated = heated;
    }

    // Returns whether the food is heated.
    public boolean isHeated() {
        return heated;
    }

    // Returns the price including the heating fee.
    @Override
    public double getPrice() {

        if (heated) {
            return super.getPrice() + HEAT_FEE;
        }

        return super.getPrice();
    }

    // Returns the food as text.
    //Using the tenary operator of ?
    @Override
    public String toString() {
        return getName() + (heated ? ", heated": "")+ " - $" +
                String.format("%.2f", getPrice());
    }

}
