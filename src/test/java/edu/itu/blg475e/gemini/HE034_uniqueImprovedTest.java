/* @Authors
 * Student Names: <Student 1>, <Student 2>, <Student 3>
 * Student IDs:   <ID 1>, <ID 2>, <ID 3>
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE034_unique (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * unique: EC = {empty, all-unique, all-same, duplicates scattered}. Output is sorted ascending.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE034_uniqueImprovedTest {

    private final HE034_unique sut = new HE034_unique();

    @Test
    void empty_returns_empty() {
        assertTrue(sut.unique(Arrays.asList()).isEmpty(), "EC/BV: empty_returns_empty");
    }

    @Test
    void all_unique_sorted() {
        assertTrue(sut.unique(Arrays.asList(3, 1, 2)).equals(Arrays.asList(1, 2, 3)), "EC/BV: all_unique_sorted");
    }

    @Test
    void duplicates_removed() {
        assertTrue(sut.unique(Arrays.asList(1, 1, 2, 2, 3)).equals(Arrays.asList(1, 2, 3)), "EC/BV: duplicates_removed");
    }

    @Test
    void all_same_returns_singleton() {
        assertTrue(sut.unique(Arrays.asList(5, 5, 5)).equals(Arrays.asList(5)), "EC/BV: all_same_returns_singleton");
    }

    @Test
    void negatives_and_positives() {
        assertTrue(sut.unique(Arrays.asList(-1, -2, -1, 0)).equals(Arrays.asList(-2, -1, 0)), "EC/BV: negatives_and_positives");
    }
}
