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
 * Improved tests for HE021_rescaleToUnit (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * rescaleToUnit: EC = {already [0,1], negative range, constant shift, contains max/min at extremes}. Boundary: min and max endpoints → 0.0 and 1.0.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE021_rescaleToUnitImprovedTest {

    private final HE021_rescaleToUnit sut = new HE021_rescaleToUnit();

    @Test
    void two_elements_become_zero_and_one() {
        assertTrue(sut.rescaleToUnit(Arrays.asList(0.0, 10.0)).equals(Arrays.asList(0.0, 1.0)), "EC/BV: two_elements_become_zero_and_one");
    }

    @Test
    void min_becomes_zero() {
        assertTrue(sut.rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0)).get(0) == 0.0, "EC/BV: min_becomes_zero");
    }

    @Test
    void max_becomes_one() {
        assertTrue(sut.rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0)).get(2) == 1.0, "EC/BV: max_becomes_one");
    }

    @Test
    void middle_is_half() {
        assertTrue(Math.abs(sut.rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0)).get(1) - 0.5) < 1e-9, "EC/BV: middle_is_half");
    }

    @Test
    void negative_range_normalised() {
        assertTrue(sut.rescaleToUnit(Arrays.asList(-5.0, 5.0)).equals(Arrays.asList(0.0, 1.0)), "EC/BV: negative_range_normalised");
    }
}
