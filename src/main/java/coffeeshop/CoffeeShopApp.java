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
//Build By Lu-kee Tucker
// Commit message:  step 6: game loop

public class CoffeeShopApp {
    private CoffeeShop shop;
    private Order order;
    private Scanner input;
    private boolean alreadyApplied;

    // YOUR CODE (Step 6): add the fields shop and order here.

    public CoffeeShopApp(Scanner input) {
        this.input = input;
        // YOUR CODE (Step 6): make the shop, new CoffeeShop("Hornet Coffee"), and the first new Order().
        shop = new CoffeeShop("Hornet Coffee");
        order = new Order();
        alreadyApplied = false;
    }

    // The game loop. It keeps going until the user picks 0.
    public void run() {
//        System.out.println("Hornet Coffee is not open yet.");
//        System.out.println("Build Steps 1 to 5, then write the game loop here in Step 6.");
        // YOUR CODE (Step 6): replace the two lines above with the game loop.
        printBanner();

        boolean running = true;

        while (running) {

            printMainMenu();

            int choice = readNumber("Choice: ");

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

                case 8:
                    applyForJob();
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
        System.out.println("HORNET COFFEE");
    }
    private void printMainMenu() {

        System.out.println();
        System.out.println("1. Show menu");
        System.out.println("2. Add item");
        System.out.println("3. Remove item");
        System.out.println("4. View my order");
        System.out.println("5. Use coupon");
        System.out.println("6. Checkout");
        System.out.println("7. Today's sales");
        System.out.println("8. Apply for a Job");
        System.out.println("0. Close the shop");
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
    private void addItem() {
        System.out.println(shop.getMenu());

        int number = readNumber("Item number: ");

        MenuItem item = shop.getMenu().getItem(number);

        if (item == null) {
            System.out.println("That item does not exist.");
            return;
        }

        if (item.isDrink()) {

            String text = readText("Size (S, M, L): ");
            char size = text.charAt(0);

            Drink drink = new Drink(
                    item.getName(),
                    item.getPrice(),
                    size);

            order.addItem(drink);

        } else {

            String answer = readText("Heat it up? (y/n): ");

            boolean heated = answer.equalsIgnoreCase("y");

            Food food = new Food(
                    item.getName(),
                    item.getPrice(),
                    heated);

            order.addItem(food);
        }


    }
    private void removeItem() {

        System.out.println(order);

        int number = readNumber("Remove which item? ");

        if (order.removeItem(number)) {
            System.out.println("Item removed.");
        } else {
            System.out.println("That item does not exist.");
        }
    }
    private void viewOrder() {
        if (order.isEmpty()) {
            System.out.println("Your order is empty.");
            return;
        }

        System.out.println(order);
    }
    private void useCoupon() {

        String code = readText("Enter coupon code: ");

        if (order.applyCoupon(code)) {
            System.out.println("Coupon applied.");
        } else {
            System.out.println("Invalid coupon.");
        }
    }
    private void checkout() {

        int tipPercent = readNumber("Tip percent: ");

        double total = shop.checkout(order, tipPercent);

        System.out.println("Total: $" +
                String.format("%.2f", total));

        order = new Order();
    }
    private void applyForJob() {
        if (alreadyApplied) {
            System.out.println(
                    "You have already applied for a position. Please come back another time.");
            return;
        }


        alreadyApplied = true;



        System.out.println(
                "Hello! My name is Marie and  I am the hiring manager at HornetCoffeeShop. Nice to Meet you!");

        String name =
                readText("What is your name? ");
        System.out.println("Nice to meet you "+name+".");

        int years =
                readNumber("Years of experience? ");
        System.out.println("Okay "+name+" So you have "+years+" of experience");

        String answer =
                readText("What is one important Java concept? ");

        Applicant applicant =
                new Applicant(name, years, answer);

        HiringManager manager =
                new HiringManager();


        int score = manager.hire(applicant);
        if (score >= 80) {

            System.out.println(
                    "Wait a second...");

            System.out.println(
                    "Marie looks at your resume again.");

            System.out.println(
                    "You are overqualified for this position.");

            System.out.println(
                    "Congratulations " + name +
                            "! You are now the CEO of Hornet Coffee!");

        }
        else if (score >= 50) {

            System.out.println(
                    "Congratulations " + name +
                            "! You are hired!");

        }
        else {

            System.out.println(
                    "Thank you for applying, " + name +
                            ". Unfortunately, we will not be moving you forward in the hiring process at this time.");
        }
    }

    // Start here. Click the green arrow next to this line to run the game.
    public static void main(String[] args) {
        CoffeeShopApp app = new CoffeeShopApp(new Scanner(System.in));
        app.run();
    }
}
