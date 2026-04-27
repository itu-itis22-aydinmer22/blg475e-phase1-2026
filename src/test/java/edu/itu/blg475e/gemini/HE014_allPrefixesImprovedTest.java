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
 * Improved tests for HE014_allPrefixes (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * allPrefixes: EC = {empty, length-1, length-N}. Boundary: verify size == input length.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE014_allPrefixesImprovedTest {

    private final HE014_allPrefixes sut = new HE014_allPrefixes();

    @Test
    void empty_returns_empty() {
        assertTrue(sut.allPrefixes("").isEmpty(), "EC/BV: empty_returns_empty");
    }

    @Test
    void length_one() {
        assertTrue(sut.allPrefixes("a").equals(Arrays.asList("a")), "EC/BV: length_one");
    }

    @Test
    void length_three_count() {
        assertTrue(sut.allPrefixes("abc").size() == 3, "EC/BV: length_three_count");
    }

    @Test
    void length_three_order() {
        assertTrue(sut.allPrefixes("abc").equals(Arrays.asList("a", "ab", "abc")), "EC/BV: length_three_order");
    }

    @Test
    void repeated_chars() {
        assertTrue(sut.allPrefixes("aa").equals(Arrays.asList("a", "aa")), "EC/BV: repeated_chars");
    }
}
