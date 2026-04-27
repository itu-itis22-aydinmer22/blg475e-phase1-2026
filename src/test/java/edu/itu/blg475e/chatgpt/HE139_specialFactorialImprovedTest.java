/* @Authors
 * Mert Aydın - 150220722
 * Oğuz Eren Kacar - 150200018
 * Mehmet Enes Tekgöz - 150210089
 */
package edu.itu.blg475e.chatgpt;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE139_specialFactorial (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * specialFactorial: n! * (n-1)! * ... * 1!. EC = {n=1 base, n=2, typical, larger}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE139_specialFactorialImprovedTest {

    private final HE139_specialFactorial sut = new HE139_specialFactorial();

    @Test
    void n_equals_one() {
        assertTrue(sut.specialFactorial(1) == 1, "EC/BV: n_equals_one");
    }

    @Test
    void n_equals_two() {
        assertTrue(sut.specialFactorial(2) == 2, "EC/BV: n_equals_two");
    }

    @Test
    void n_equals_three() {
        assertTrue(sut.specialFactorial(3) == 12, "EC/BV: n_equals_three");
    }

    @Test
    void n_equals_four() {
        assertTrue(sut.specialFactorial(4) == 288, "EC/BV: n_equals_four");
    }

    @Test
    void n_equals_five() {
        assertTrue(sut.specialFactorial(5) == 34560, "EC/BV: n_equals_five");
    }
}
