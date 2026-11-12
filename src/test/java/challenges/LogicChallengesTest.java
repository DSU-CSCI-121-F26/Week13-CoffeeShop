package challenges;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. It checks your answers.
// Run it with the green arrow next to the class name. Green means every answer is right.

class LogicChallengesTest {

    // ---- sizeUpcharge ----

    @Test
    void sizeUpchargeSmall() {
        assertEquals(0.0, LogicChallenges.sizeUpcharge('S'), 0.001);
        assertEquals(0.0, LogicChallenges.sizeUpcharge('s'), 0.001);
    }

    @Test
    void sizeUpchargeMediumAndLarge() {
        assertEquals(0.50, LogicChallenges.sizeUpcharge('M'), 0.001);
        assertEquals(0.50, LogicChallenges.sizeUpcharge('m'), 0.001);
        assertEquals(1.00, LogicChallenges.sizeUpcharge('L'), 0.001);
        assertEquals(1.00, LogicChallenges.sizeUpcharge('l'), 0.001);
    }

    @Test
    void sizeUpchargeUnknownSize() {
        assertEquals(-1.0, LogicChallenges.sizeUpcharge('X'), 0.001);
        assertEquals(-1.0, LogicChallenges.sizeUpcharge('3'), 0.001);
    }

    // ---- isHappyHour ----

    @Test
    void isHappyHourWeekdayInside() {
        assertTrue(LogicChallenges.isHappyHour(14, false));
        assertTrue(LogicChallenges.isHappyHour(15, false));
        assertTrue(LogicChallenges.isHappyHour(16, false));
    }

    @Test
    void isHappyHourWeekdayOutside() {
        assertFalse(LogicChallenges.isHappyHour(13, false));
        assertFalse(LogicChallenges.isHappyHour(17, false));
        assertFalse(LogicChallenges.isHappyHour(12, false));
    }

    @Test
    void isHappyHourWeekend() {
        assertTrue(LogicChallenges.isHappyHour(12, true));
        assertTrue(LogicChallenges.isHappyHour(17, true));
        assertFalse(LogicChallenges.isHappyHour(11, true));
        assertFalse(LogicChallenges.isHappyHour(18, true));
    }

    @Test
    void isHappyHourImpossibleHour() {
        assertFalse(LogicChallenges.isHappyHour(25, true));
        assertFalse(LogicChallenges.isHappyHour(-1, false));
    }

    // ---- freeDrinks ----

    @Test
    void freeDrinksExamples() {
        assertEquals(1, LogicChallenges.freeDrinks(8, 3));
        assertEquals(2, LogicChallenges.freeDrinks(0, 25));
        assertEquals(0, LogicChallenges.freeDrinks(4, 5));
    }

    @Test
    void freeDrinksExactlyTen() {
        assertEquals(1, LogicChallenges.freeDrinks(9, 1));
        assertEquals(3, LogicChallenges.freeDrinks(10, 20));
    }

    @Test
    void freeDrinksNegative() {
        assertEquals(0, LogicChallenges.freeDrinks(-1, 30));
        assertEquals(0, LogicChallenges.freeDrinks(30, -1));
    }

    // ---- coinsForChange ----

    @Test
    void coinsForChangeExamples() {
        assertEquals(2, LogicChallenges.coinsForChange(30));
        assertEquals(4, LogicChallenges.coinsForChange(41));
        assertEquals(9, LogicChallenges.coinsForChange(99));
    }

    @Test
    void coinsForChangeOneCoin() {
        assertEquals(1, LogicChallenges.coinsForChange(25));
        assertEquals(1, LogicChallenges.coinsForChange(10));
        assertEquals(1, LogicChallenges.coinsForChange(1));
    }

    @Test
    void coinsForChangeNothing() {
        assertEquals(0, LogicChallenges.coinsForChange(0));
        assertEquals(0, LogicChallenges.coinsForChange(-5));
    }
}
