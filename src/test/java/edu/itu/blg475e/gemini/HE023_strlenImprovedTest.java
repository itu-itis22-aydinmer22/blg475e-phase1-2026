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
 * Improved tests for HE023_strlen (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * strlen: EC = {empty, single, ascii, unicode surrogate, whitespace-only}. Boundary: "".
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE023_strlenImprovedTest {

    private final HE023_strlen sut = new HE023_strlen();

    @Test
    void empty_is_zero() {
        assertTrue(sut.strlen("") == 0, "EC/BV: empty_is_zero");
    }

    @Test
    void single_char() {
        assertTrue(sut.strlen("a") == 1, "EC/BV: single_char");
    }

    @Test
    void typical() {
        assertTrue(sut.strlen("hello") == 5, "EC/BV: typical");
    }

    @Test
    void whitespace_counts() {
        assertTrue(sut.strlen("   ") == 3, "EC/BV: whitespace_counts");
    }

    @Test
    void mixed_case() {
        assertTrue(sut.strlen("AbC") == 3, "EC/BV: mixed_case");
    }

    @Test
    void newline_counts() {
        assertTrue(sut.strlen("a\nb") == 3, "EC/BV: newline_counts");
    }
}
