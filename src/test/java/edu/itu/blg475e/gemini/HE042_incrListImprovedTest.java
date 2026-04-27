/* @Authors
 * Mert Aydın - 150220722
 * Oğuz Eren Kacar - 150200018
 * Mehmet Enes Tekgöz - 150210089
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE042_incrList (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * incrList: EC = {empty, single, negatives, zeros, positives, mixed}. Preserves order.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE042_incrListImprovedTest {

    private final HE042_incrList sut = new HE042_incrList();

    @Test
    void empty() {
        assertTrue(sut.incrList(Arrays.asList()).isEmpty(), "EC/BV: empty");
    }

    @Test
    void single() {
        assertTrue(sut.incrList(Arrays.asList(5)).equals(Arrays.asList(6)), "EC/BV: single");
    }

    @Test
    void negatives_to_zero() {
        assertTrue(sut.incrList(Arrays.asList(-1)).equals(Arrays.asList(0)), "EC/BV: negatives_to_zero");
    }

    @Test
    void mixed() {
        assertTrue(sut.incrList(Arrays.asList(-1, 0, 1)).equals(Arrays.asList(0, 1, 2)), "EC/BV: mixed");
    }

    @Test
    void preserves_order() {
        assertTrue(sut.incrList(Arrays.asList(3, 1, 2)).equals(Arrays.asList(4, 2, 3)), "EC/BV: preserves_order");
    }
}
