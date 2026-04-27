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
 * Improved tests for HE009_rollingMax (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * rollingMax: EC = {empty, single, strictly ascending, strictly descending, all-equal, mixed}. Boundary = Integer.MIN_VALUE at start.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE009_rollingMaxImprovedTest {

    private final HE009_rollingMax sut = new HE009_rollingMax();

    @Test
    void empty_returns_empty() {
        assertTrue(sut.rollingMax(Arrays.asList()).isEmpty(), "EC/BV: empty_returns_empty");
    }

    @Test
    void single_element() {
        assertTrue(sut.rollingMax(Arrays.asList(5)).equals(Arrays.asList(5)), "EC/BV: single_element");
    }

    @Test
    void ascending_stays_ascending() {
        assertTrue(sut.rollingMax(Arrays.asList(1, 2, 3)).equals(Arrays.asList(1, 2, 3)), "EC/BV: ascending_stays_ascending");
    }

    @Test
    void descending_plateaus_at_first() {
        assertTrue(sut.rollingMax(Arrays.asList(3, 2, 1)).equals(Arrays.asList(3, 3, 3)), "EC/BV: descending_plateaus_at_first");
    }

    @Test
    void all_equal() {
        assertTrue(sut.rollingMax(Arrays.asList(7, 7, 7)).equals(Arrays.asList(7, 7, 7)), "EC/BV: all_equal");
    }

    @Test
    void min_value_boundary() {
        assertTrue(sut.rollingMax(Arrays.asList(Integer.MIN_VALUE, 0)).equals(Arrays.asList(Integer.MIN_VALUE, 0)), "EC/BV: min_value_boundary");
    }

    @Test
    void negative_numbers() {
        assertTrue(sut.rollingMax(Arrays.asList(-3, -5, -1)).equals(Arrays.asList(-3, -3, -1)), "EC/BV: negative_numbers");
    }
}
