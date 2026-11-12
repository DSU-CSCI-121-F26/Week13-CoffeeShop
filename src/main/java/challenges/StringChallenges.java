package challenges;

// SECTION B: Strings. length, charAt, substring, indexOf, toUpperCase, trim, equals.
// The test is src/test/java/challenges/StringChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 11 (String methods and wrapper classes), Part 14 (printf).

public class StringChallenges {

    // A short code the barista prints on the cup: the first 3 letters of the drink in
    // CAPITALS, a dash, then the size letter in CAPITALS.
    // If the name is shorter than 3 letters, use the whole name.
    //   orderCode("latte", 'm') -> "LAT-M"
    //   orderCode("Tea", 'L')   -> "TEA-L"
    //   orderCode("Mo", 's')    -> "MO-S"
    public static String orderCode(String name, char size) {
        return "";   // YOUR CODE
    }

    // Write a customer's name on the cup neatly: no spaces at the ends, the first letter
    // a capital, every other letter small. If there is no name left, give back "Guest".
    //   cupName("jORDAN")   -> "Jordan"
    //   cupName("  sky  ")  -> "Sky"
    //   cupName("   ")      -> "Guest"
    public static String cupName(String name) {
        return "";   // YOUR CODE
    }

    // How many times does word show up in order? Capital and small letters count the same.
    // After you find the word, keep looking right after it.
    // If word is empty, give back 0.
    //   countWord("double shot, extra SHOT", "shot") -> 2
    //   countWord("oat milk latte", "milk")          -> 1
    //   countWord("black coffee", "sugar")           -> 0
    public static int countWord(String order, String word) {
        return 0;   // YOUR CODE
    }

    // One line of a receipt. The name, then dots until the line is 20 characters long,
    // then a dollar sign and the price with 2 decimals.
    // If the name is already 20 characters or longer, add no dots.
    //   receiptLine("Latte", 3.75) -> "Latte...............$3.75"   (5 letters + 15 dots = 20)
    //   receiptLine("Bagel", 2.5)  -> "Bagel...............$2.50"
    public static String receiptLine(String name, double price) {
        return "";   // YOUR CODE
    }
}
