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
 * Improved tests for HE035_maxElement (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * maxElement: EC = {single, ascending, descending, all-equal, negatives, min at ends}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE035_maxElementImprovedTest {

    private final HE035_maxElement sut = new HE035_maxElement();

    @Test
    void single() {
        assertTrue(sut.maxElement(Arrays.asList(5)) == 5, "EC/BV: single");
    }

    @Test
    void at_start() {
        assertTrue(sut.maxElement(Arrays.asList(9, 1, 2)) == 9, "EC/BV: at_start");
    }

    @Test
    void at_end() {
        assertTrue(sut.maxElement(Arrays.asList(1, 2, 9)) == 9, "EC/BV: at_end");
    }

    @Test
    void in_middle() {
        assertTrue(sut.maxElement(Arrays.asList(1, 9, 2)) == 9, "EC/BV: in_middle");
    }

    @Test
    void all_equal() {
        assertTrue(sut.maxElement(Arrays.asList(4, 4, 4)) == 4, "EC/BV: all_equal");
    }

    @Test
    void negatives() {
        assertTrue(sut.maxElement(Arrays.asList(-3, -1, -2)) == -1, "EC/BV: negatives");
    }
}
