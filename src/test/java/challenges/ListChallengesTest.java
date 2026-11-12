package challenges;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

// You do not change this file. It checks your answers.
// Run it with the green arrow next to the class name. Green means every answer is right.

class ListChallengesTest {

    private ArrayList<String> list(String... words) {
        return new ArrayList<>(List.of(words));
    }

    // ---- removeSoldOut ----

    @Test
    void removeSoldOutExamples() {
        assertEquals(list("Bagel"), ListChallenges.removeSoldOut(list("Latte", "Bagel", "latte"), "LATTE"));
        assertEquals(list("Tea"), ListChallenges.removeSoldOut(list("Tea"), "Coffee"));
    }

    @Test
    void removeSoldOutKeepsTheOrder() {
        assertEquals(list("Tea", "Bagel", "Mocha"),
                ListChallenges.removeSoldOut(list("Tea", "Muffin", "Bagel", "Mocha"), "muffin"));
    }

    @Test
    void removeSoldOutDoesNotChangeTheOriginal() {
        ArrayList<String> original = list("Latte", "Bagel");
        ListChallenges.removeSoldOut(original, "Latte");
        assertEquals(list("Latte", "Bagel"), original);
    }

    @Test
    void removeSoldOutEmpty() {
        assertEquals(list(), ListChallenges.removeSoldOut(list(), "Latte"));
    }

    // ---- longestName ----

    @Test
    void longestNameExamples() {
        assertEquals("Jordan", ListChallenges.longestName(list("Mo", "Jordan", "Skye")));
        assertEquals("Jordan", ListChallenges.longestName(list("Jordan", "Mo")));
    }

    @Test
    void longestNameTieGivesTheFirst() {
        assertEquals("Ana", ListChallenges.longestName(list("Ana", "Bob")));
    }

    @Test
    void longestNameEmpty() {
        assertEquals("", ListChallenges.longestName(list()));
    }

    // ---- hasRepeat ----

    @Test
    void hasRepeatYes() {
        assertTrue(ListChallenges.hasRepeat(list("Mo", "Ana", "Mo")));
        assertTrue(ListChallenges.hasRepeat(list("Ana", "Ana")));
    }

    @Test
    void hasRepeatCapitalsAreDifferent() {
        assertFalse(ListChallenges.hasRepeat(list("Mo", "Ana", "mo")));
    }

    @Test
    void hasRepeatNo() {
        assertFalse(ListChallenges.hasRepeat(list("Mo", "Ana", "Jo")));
        assertFalse(ListChallenges.hasRepeat(list("Mo")));
        assertFalse(ListChallenges.hasRepeat(list()));
    }
}
