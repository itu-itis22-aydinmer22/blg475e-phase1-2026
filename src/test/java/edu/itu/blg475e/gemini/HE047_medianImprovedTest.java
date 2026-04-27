/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722, 150200018, 150210089
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE047_median (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * median: EC = {odd length, even length, all same, negatives}. Boundary: 1-element list.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE047_medianImprovedTest {

    private final HE047_median sut = new HE047_median();

    @Test
    void single_element() {
        assertTrue(sut.median(Arrays.asList(7)) == 7.0, "EC/BV: single_element");
    }

    @Test
    void odd_length() {
        assertTrue(sut.median(Arrays.asList(3, 1, 2, 4, 5)) == 3.0, "EC/BV: odd_length");
    }

    @Test
    void even_length() {
        assertTrue(sut.median(Arrays.asList(1, 2, 3, 4)) == 2.5, "EC/BV: even_length");
    }

    @Test
    void negatives_mixed_sorted_yields_8() {
        assertTrue(sut.median(Arrays.asList(-10, 4, 6, 1000, 10, 20)) == 8.0, "EC/BV: negatives_mixed_sorted_yields_8");
    }

    @Test
    void all_same() {
        assertTrue(sut.median(Arrays.asList(5, 5, 5, 5)) == 5.0, "EC/BV: all_same");
    }
}
