package challenges;

// SECTION A: Logic. if, else if, && and ||, and a little math.
// The test is src/test/java/challenges/LogicChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 06 (if and switch), Part 07 (logical operators), Part 13 (methods).

public class LogicChallenges {

    // How much extra a drink size costs.
    //   'S' or 's' -> 0.0     'M' or 'm' -> 0.50     'L' or 'l' -> 1.00
    //   anything else -> -1.0 (that size does not exist)
    //   sizeUpcharge('M') -> 0.5     sizeUpcharge('l') -> 1.0     sizeUpcharge('X') -> -1.0
    public static double sizeUpcharge(char size) {
        return 0.0;   // YOUR CODE
    }

    // Happy hour on a weekday is from hour 14 to hour 16 (2 PM to 4 PM), both included.
    // On the weekend it is longer: hour 12 to hour 17, both included.
    // hour is on a 24-hour clock (0 to 23). Any other hour is never happy hour.
    //   isHappyHour(15, false) -> true     isHappyHour(12, false) -> false
    //   isHappyHour(12, true)  -> true     isHappyHour(25, true)  -> false
    public static boolean isHappyHour(int hour, boolean weekend) {
        return false;   // YOUR CODE
    }

    // A loyalty card gets one stamp per drink. Every 10 stamps is one free drink.
    // The card already has stamps, and the customer buys more drinks.
    // Give back how many free drinks they have earned in total.
    // If stamps or bought is below 0, give back 0.
    //   freeDrinks(8, 3)  -> 1     freeDrinks(0, 25) -> 2
    //   freeDrinks(4, 5)  -> 0     freeDrinks(-1, 30) -> 0
    public static int freeDrinks(int stamps, int bought) {
        return 0;   // YOUR CODE
    }

    // The fewest coins that make the change. Coins are 25, 10, 5 and 1 cents.
    // Use as many quarters as you can, then dimes, then nickels, then pennies.
    // If cents is 0 or less, give back 0.
    //   coinsForChange(30) -> 2  (25 + 5)
    //   coinsForChange(41) -> 4  (25 + 10 + 5 + 1)
    //   coinsForChange(99) -> 9  (3 quarters, 2 dimes, 4 pennies)
    public static int coinsForChange(int cents) {
        return 0;   // YOUR CODE
    }
}
