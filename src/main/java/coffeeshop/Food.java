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

public class Food extends MenuItem {
    public static final double HEAT_FEE = 0.50;

    private boolean heated;

    public Food(String name, double price, boolean heated){
        super(name, price);
        this.heated = heated;
    }
    public boolean isHeated(){
        return heated;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();

        if (heated) {
            price += HEAT_FEE;
        }
        return price;
    }
    @Override
    public String toString(){
        return getName() + (heated ? " (heated)" : "")
                + ": $" + String.format("%.2f", getPrice());
    }


    // YOUR CODE

}
