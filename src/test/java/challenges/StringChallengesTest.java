package challenges;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. It checks your answers.
// Run it with the green arrow next to the class name. Green means every answer is right.

class StringChallengesTest {

    // ---- orderCode ----

    @Test
    void orderCodeExamples() {
        assertEquals("LAT-M", StringChallenges.orderCode("latte", 'm'));
        assertEquals("TEA-L", StringChallenges.orderCode("Tea", 'L'));
        assertEquals("CAP-S", StringChallenges.orderCode("Cappuccino", 'S'));
    }

    @Test
    void orderCodeShortName() {
        assertEquals("MO-S", StringChallenges.orderCode("Mo", 's'));
        assertEquals("A-L", StringChallenges.orderCode("a", 'l'));
    }

    // ---- cupName ----

    @Test
    void cupNameFixesCapitals() {
        assertEquals("Jordan", StringChallenges.cupName("jORDAN"));
        assertEquals("Ana", StringChallenges.cupName("ana"));
    }

    @Test
    void cupNameTrimsSpaces() {
        assertEquals("Sky", StringChallenges.cupName("  sky  "));
    }

    @Test
    void cupNameOneLetter() {
        assertEquals("J", StringChallenges.cupName("j"));
    }

    @Test
    void cupNameEmptyIsGuest() {
        assertEquals("Guest", StringChallenges.cupName("   "));
        assertEquals("Guest", StringChallenges.cupName(""));
    }

    // ---- countWord ----

    @Test
    void countWordExamples() {
        assertEquals(2, StringChallenges.countWord("double shot, extra SHOT", "shot"));
        assertEquals(1, StringChallenges.countWord("oat milk latte", "milk"));
        assertEquals(0, StringChallenges.countWord("black coffee", "sugar"));
    }

    @Test
    void countWordIgnoresCaseOfTheWordToo() {
        assertEquals(3, StringChallenges.countWord("ice, ice, ICE", "Ice"));
    }

    @Test
    void countWordEmpty() {
        assertEquals(0, StringChallenges.countWord("latte", ""));
        assertEquals(0, StringChallenges.countWord("", "latte"));
    }

    // ---- receiptLine ----

    @Test
    void receiptLineExamples() {
        assertEquals("Latte...............$3.75", StringChallenges.receiptLine("Latte", 3.75));
        assertEquals("Bagel...............$2.50", StringChallenges.receiptLine("Bagel", 2.5));
    }

    @Test
    void receiptLineIsAlways20BeforeTheDollarSign() {
        String line = StringChallenges.receiptLine("Hot Chocolate", 2.5);
        assertEquals(20, line.indexOf("$"), line);
        assertTrue(line.endsWith("$2.50"), line);
    }

    @Test
    void receiptLineLongNameGetsNoDots() {
        assertEquals("Extra Large Pumpkin Spice$6.00",
                StringChallenges.receiptLine("Extra Large Pumpkin Spice", 6));
    }
}
