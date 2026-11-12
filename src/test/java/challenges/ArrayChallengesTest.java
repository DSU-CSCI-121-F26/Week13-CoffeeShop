package challenges;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// You do not change this file. It checks your answers.
// Run it with the green arrow next to the class name. Green means every answer is right.

class ArrayChallengesTest {

    // ---- cheapest ----

    @Test
    void cheapestExamples() {
        assertEquals(2.0, ArrayChallenges.cheapest(new double[] {3.25, 2.00, 4.50}), 0.001);
        assertEquals(5.0, ArrayChallenges.cheapest(new double[] {5.0}), 0.001);
    }

    @Test
    void cheapestFirstOrLast() {
        assertEquals(1.0, ArrayChallenges.cheapest(new double[] {1.0, 2.0, 3.0}), 0.001);
        assertEquals(1.0, ArrayChallenges.cheapest(new double[] {3.0, 2.0, 1.0}), 0.001);
    }

    @Test
    void cheapestEmpty() {
        assertEquals(0.0, ArrayChallenges.cheapest(new double[] {}), 0.001);
    }

    // ---- countOver ----

    @Test
    void countOverExamples() {
        assertEquals(2, ArrayChallenges.countOver(new double[] {3.25, 2.00, 4.50}, 3.00));
        assertEquals(0, ArrayChallenges.countOver(new double[] {3.25, 2.00, 4.50}, 4.50));
    }

    @Test
    void countOverAllAndEmpty() {
        assertEquals(3, ArrayChallenges.countOver(new double[] {3.25, 2.00, 4.50}, 0));
        assertEquals(0, ArrayChallenges.countOver(new double[] {}, 1.0));
    }

    // ---- busiestDay ----

    @Test
    void busiestDayExamples() {
        assertEquals(1, ArrayChallenges.busiestDay(new int[][] {{5, 9}, {20, 1}, {3, 3}}));
        assertEquals(2, ArrayChallenges.busiestDay(new int[][] {{1}, {2}, {3, 3}}));
    }

    @Test
    void busiestDayTieGivesTheFirst() {
        assertEquals(0, ArrayChallenges.busiestDay(new int[][] {{4, 4}, {8}}));
    }

    @Test
    void busiestDayAllZero() {
        assertEquals(0, ArrayChallenges.busiestDay(new int[][] {{0, 0}, {0}}));
    }

    @Test
    void busiestDayNoDays() {
        assertEquals(-1, ArrayChallenges.busiestDay(new int[][] {}));
    }
}
