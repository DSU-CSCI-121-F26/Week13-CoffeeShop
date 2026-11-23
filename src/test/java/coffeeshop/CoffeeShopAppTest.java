package coffeeshop;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// You do not change this file. Copy it into src/test/java/coffeeshop/ in YOUR coffee-shop
// project, then run it with the green arrow next to the class name.
// Step 6 checks the game loop in CoffeeShopApp. Each test pretends to be a customer:
// it types the keys shown in the test (\n is the Enter key) and reads what your app printed.
// If a test says it timed out, your loop never stopped. Check what happens when 0 is picked.

class CoffeeShopAppTest {

    private final PrintStream realOut = System.out;
    private final ByteArrayOutputStream printed = new ByteArrayOutputStream();

    @BeforeEach
    void catchOutput() {
        System.setOut(new PrintStream(printed));
    }

    @AfterEach
    void putOutputBack() {
        System.setOut(realOut);
    }

    private String play(String keys) {
        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> {
            new CoffeeShopApp(new Scanner(keys)).run();
        }, "The app did not stop. Does picking 0 end the loop?");
        return printed.toString();
    }

    private int count(String text, String part) {
        int count = 0;
        int at = text.indexOf(part);
        while (at != -1) {
            count++;
            at = text.indexOf(part, at + 1);
        }
        return count;
    }

    @Test
    void zeroClosesTheShop() {
        String out = play("0\n");
        assertTrue(out.contains("HORNET COFFEE"), out);
        assertTrue(out.contains("Shop closed. Goodbye!"), out);
    }

    @Test
    void theMenuComesBackAfterEveryChoice() {
        String out = play("1\n4\n7\n0\n");
        assertEquals(4, count(out, "0. Close the shop"), out);
        assertEquals(1, count(out, "Shop closed. Goodbye!"), out);
    }

    @Test
    void aWrongNumberDoesNotEndTheGame() {
        String out = play("9\n0\n");
        assertTrue(out.contains("That is not on the list. Pick 0 to 7."), out);
        assertTrue(out.contains("Shop closed. Goodbye!"), out);
    }

    @Test
    void lettersDoNotCrashTheGame() {
        String out = play("abc\n0\n");
        assertTrue(out.contains("Please type a number"), out);
        assertTrue(out.contains("Shop closed. Goodbye!"), out);
    }

    @Test
    void seeTheMenu() {
        String out = play("1\n0\n");
        assertTrue(out.contains("1. Coffee (S) - $2.00"), out);
        assertTrue(out.contains("8. Breakfast Sandwich - $4.50"), out);
    }

    @Test
    void addALargeCoffee() {
        String out = play("2\n1\nL\n4\n0\n");
        assertTrue(out.contains("Coffee (L) - $3.00"), out);
    }

    @Test
    void addAHeatedBagel() {
        String out = play("2\n6\ny\n4\n0\n");
        assertTrue(out.contains("Bagel, heated - $3.25"), out);
    }

    @Test
    void removeAnItem() {
        String out = play("2\n1\nS\n3\n1\n4\n0\n");
        assertTrue(out.contains("Your order is empty."), out);
    }

    @Test
    void checkoutWithCouponAndTip() {
        // Latte (M) 3.75 + heated Bagel 3.25 = 7.00, coupon -0.70, 20% tip 1.26 = 7.56
        String keys = "2\n2\nM\n" + "2\n6\ny\n" + "5\nhornet10\n" + "6\n20\n" + "7\n" + "0\n";
        String out = play(keys);
        assertTrue(out.contains("$7.56"), out);
        assertTrue(out.contains("Orders: 1"), out);
        assertTrue(out.contains("Items sold: 2"), out);
    }

    @Test
    void checkoutStartsANewOrder() {
        String out = play("2\n1\nS\n6\n0\n4\n0\n");
        assertTrue(out.contains("Your order is empty."), out);
    }
}
