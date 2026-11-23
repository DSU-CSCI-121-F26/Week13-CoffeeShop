package coffeeshop;

import java.util.Scanner;

// STEP 6 · CoffeeShopApp: the game you play. This is the class with main.
//
// It already runs. Click the green arrow next to main and try it.
//
// In Step 6 you finish it. Open UML.md ("Step 6") and the README ("Step 6") for the
// screens and the exact sentences. You add:
//   2 more private fields: shop and order
//   the game loop in run()
//   printBanner(), printMainMenu(), and one method for each menu choice
//
// Then drag check/coffeeshop/CoffeeShopAppTest.java into src/test/java/coffeeshop/ and run it.
// Commit message:  step 6: game loop

public class CoffeeShopApp {

    private Scanner input;
    private CoffeeShop shop;
    private Order order;

    // YOUR CODE (Step 6): add the fields shop and order here.

    public CoffeeShopApp(Scanner input) {
        this.input = input;
        shop = new CoffeeShop("Hornet Coffee");
        order = new Order();
        // YOUR CODE (Step 6): make the shop, new CoffeeShop("Hornet Coffee"), and the first new Order().
    }

    // The game loop. It keeps going until the user picks 0.
    public void run() {
        printBanner();

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = readNumber("Pick 0 to 7: ");

            switch (choice) {
                case 1:
                    System.out.println(shop.getMenu());
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    removeItem();
                    break;
                case 4:
                    viewOrder();
                    break;
                case 5:
                    useCoupon();
                    break;
                case 6:
                    checkout();
                    break;
                case 7:
                    System.out.println(shop.salesReport());
                    break;
                case 0:
                    System.out.println("Shop closed. Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("That is not on the list!");


            }
    }
    }
    private void printBanner () {
        System.out.println("===== HORNET COFFEE =====");
    }

    private void printMainMenu() {
        System.out.println("1 -> show the menu");
        System.out.println("2 -> add an item");
        System.out.println("3 -> remove an item");
        System.out.println("4 -> view the order");
        System.out.println("5 -> use a coupon");
        System.out.println("6 -> check out");
        System.out.println("7 -> today's sales");
        System.out.println("0 -> exit");
    }
    private void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
        } else {
            System.out.println(order);
        }
    }
    private void useCoupon() {
        String code = readText("Enter coupon code: ");

        if (order.applyCoupon(code)) {
            System.out.println("Coupon applied!");
        } else {
            System.out.println("Invalid coupon.");
        }
    }
    private void checkout() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println(order);
        int tip = readNumber("Tip percent (0, 10, 15, 20): ");
        double total = shop.checkout(order, tip);
        System.out.printf("Total: $%.2f%n", total);
        order = new Order();
    }
    private void addItem() {
        System.out.println(shop.getMenu());

        int number = readNumber("Item number: ");
        MenuItem item = shop.getMenu().getItem(number);

        if (item == null) {
            System.out.println("Invalid item number.");
            return;
        }
        if (item.isDrink()) {
            String sizeInput = readText("Size (S, M, L): ");
            char size = Character.toUpperCase(sizeInput.charAt(0));
            order.addItem(new Drink(item.getName(), item.getPrice(), size));
        } else {
            String answer = readText("Heat it up? (y/n): ");
            boolean heated = answer.equalsIgnoreCase("y");
            order.addItem(new Food(item.getName(), item.getPrice(), heated));
        }
        System.out.println("Item added!");
    }

    private void removeItem() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }
        System.out.println(order);
        int number = readNumber("Item number to remove: ");
        if (order.removeItem(number)) {
            System.out.println("Item removed!");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    // GIVEN CODE. Do not change it. Use it for every number the user types.
    // It keeps asking until the user types a whole number, so letters can not crash your game.
    private int readNumber(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            input.nextLine();                    // throw away what they typed
            System.out.print("Please type a number: ");
        }
        int number = input.nextInt();
        input.nextLine();                        // throw away the Enter key
        return number;
    }

    // GIVEN CODE. Do not change it. Use it for every word the user types.
    // Reads one line of text, with the spaces at the ends cut off.
    private String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    // Start here. Click the green arrow next to this line to run the game.
    public static void main(String[] args) {
        CoffeeShopApp app = new CoffeeShopApp(new Scanner(System.in));
        app.run();
    }
}
