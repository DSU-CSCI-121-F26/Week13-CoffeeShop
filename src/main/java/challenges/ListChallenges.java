package challenges;

import java.util.ArrayList;

// SECTION D: ArrayList. add, get, size, and the for-each loop.
// The test is src/test/java/challenges/ListChallengesTest.java.
// Change only the lines marked YOUR CODE. Each method says what to give back.
// Refresh: Part 12 (ArrayList and the for-each loop).

public class ListChallenges {

    // Give back a NEW list with every item except the sold-out one.
    // Capital and small letters count the same. Do not change the list you were given.
    //   removeSoldOut(["Latte", "Bagel", "latte"], "LATTE") -> ["Bagel"]
    //   removeSoldOut(["Tea"], "Coffee")                    -> ["Tea"]
    public static ArrayList<String> removeSoldOut(ArrayList<String> items, String soldOut) {
        ArrayList<String> result = new ArrayList<>();

        for (String item : items) {
            if (!item.equalsIgnoreCase(soldOut)) {
                result.add(item);
            }
        }

        return result;   // YOUR CODE
    }

    // The longest name in the list. If two tie, give back the first one.
    // If the list is empty, give back "" (an empty String).
    //   longestName(["Mo", "Jordan", "Skye"]) -> "Jordan"
    //   longestName(["Ana", "Bob"])           -> "Ana"
    public static String longestName(ArrayList<String> names) {
        if (names.isEmpty()) {
            return "";
        }

        String longest = names.get(0);

        for (String name : names) {
            if (name.length() > longest.length()) {
                longest = name;
            }
        }

        return longest;  // YOUR CODE
    }

    // Did any name order twice? Give back true if the same String (exactly, with equals)
    // is in the list more than once.
    //   hasRepeat(["Mo", "Ana", "Mo"]) -> true
    //   hasRepeat(["Mo", "Ana", "mo"]) -> false   (capital M is different)
    //   hasRepeat([])                  -> false
    public static boolean hasRepeat(ArrayList<String> names) {
        for (int i = 0; i < names.size(); i++) {

            for (int j = i + 1; j < names.size(); j++) {

                if (names.get(i).equals(names.get(j))) {
                    return true;
                }

            }
        }

        return false;  // YOUR CODE
    }
}
