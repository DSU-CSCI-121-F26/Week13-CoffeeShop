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

// Built by: Skye Pepp

public class CoffeeShopApp {
    private CoffeeShop shop;
    private Scanner input;
    private Order order;

    public CoffeeShopApp(Scanner input) {
        this.input = input;
        shop = new CoffeeShop("Hornet Coffee");
        order = new Order();
    }

    public void run() {
        printBanner();
        boolean running = true;

        while (running) {
            printMainMenu();
            int choice = readNumber("Your choice: ");

            switch (choice) {
                case 1:
                    System.out.print(shop.getMenu());
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
                    System.out.print(shop.salesReport());
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println(
                            "That is not on the list. Pick 0 to 7.");
            }
        }

        System.out.println("Shop closed. Goodbye!");
    }

    private void printBanner() {
        System.out.println("   ) ) )");
        System.out.println("  .-----.");
        System.out.println("  |     |]");
        System.out.println("   \\___/");
        System.out.println("HORNET COFFEE");
    }

    private void printMainMenu() {
        System.out.println();
        System.out.println(
                "Order #" + order.getOrderNumber()
                        + " | Items: " + order.getItemCount());
        System.out.println("1. Show the menu");
        System.out.println("2. Add an item");
        System.out.println("3. Remove an item");
        System.out.println("4. View my order");
        System.out.println("5. Use a coupon");
        System.out.println("6. Check out");
        System.out.println("7. Today's sales");
        System.out.println("0. Close the shop");
    }

    private void addItem() {
        System.out.print(shop.getMenu());

        int number = readNumber("Item number: ");
        MenuItem picked = shop.getMenu().getItem(number);

        if (picked == null) {
            System.out.println("That item is not on the menu.");
            return;
        }

        if (picked.isDrink()) {
            String answer = readText("Size (S, M, L): ");
            char sizeLetter = 'S';

            if (!answer.isEmpty()) {
                sizeLetter = answer.charAt(0);
            }

            Drink drink = new Drink(
                    picked.getName(),
                    picked.getPrice(),
                    sizeLetter);

            order.addItem(drink);
        } else {
            String answer = readText("Heat it up? (y/n): ");

            boolean heated = answer.equalsIgnoreCase("y")
                    || answer.equalsIgnoreCase("yes");

            Food food = new Food(
                    picked.getName(),
                    picked.getPrice(),
                    heated);

            order.addItem(food);
        }

        System.out.println("Item added.");
    }

    private void removeItem() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.print(order);

        int number = readNumber("Item number to remove: ");

        if (order.removeItem(number)) {
            System.out.println("Item removed.");
        } else {
            System.out.println("That item is not in your order.");
        }
    }

    private void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
        } else {
            System.out.print(order);
        }
    }

    private void useCoupon() {
        String code = readText("Coupon code: ");

        if (order.applyCoupon(code)) {
            System.out.println("Coupon applied. 10% off.");
        } else {
            System.out.println("Invalid coupon code.");
        }
    }

    private void checkout() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.print(order);

        int tipPercent = readNumber(
                "Tip percent (0, 10, 15, 20): ");

        double total = shop.checkout(order, tipPercent);

        System.out.println(
                "Total: $" + String.format("%.2f", total));

        order = new Order();
    }

    private int readNumber(String prompt) {
        System.out.print(prompt);

        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.print("Please type a number: ");
        }

        int number = input.nextInt();
        input.nextLine();
        return number;
    }

    private String readText(String prompt) {
        System.out.print(prompt);
        return input.nextLine().trim();
    }

    public static void main(String[] args) {
        CoffeeShopApp app = new CoffeeShopApp(new Scanner(System.in));
        app.run();
    }
}
