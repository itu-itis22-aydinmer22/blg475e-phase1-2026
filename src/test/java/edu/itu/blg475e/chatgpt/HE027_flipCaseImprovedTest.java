/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722, 150200018, 150210089
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.chatgpt;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE027_flipCase (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * flipCase: EC = {empty, all-upper, all-lower, mixed, digits/symbols untouched}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE027_flipCaseImprovedTest {

    private final HE027_flipCase sut = new HE027_flipCase();

    @Test
    void empty_empty() {
        assertTrue(sut.flipCase("").equals(""), "EC/BV: empty_empty");
    }

    @Test
    void all_upper_to_lower() {
        assertTrue(sut.flipCase("ABC").equals("abc"), "EC/BV: all_upper_to_lower");
    }

    @Test
    void all_lower_to_upper() {
        assertTrue(sut.flipCase("xyz").equals("XYZ"), "EC/BV: all_lower_to_upper");
    }

    @Test
    void mixed() {
        assertTrue(sut.flipCase("Hello").equals("hELLO"), "EC/BV: mixed");
    }

    @Test
    void digits_unchanged() {
        assertTrue(sut.flipCase("123").equals("123"), "EC/BV: digits_unchanged");
    }

    @Test
    void symbols_unchanged() {
        assertTrue(sut.flipCase("!@#").equals("!@#"), "EC/BV: symbols_unchanged");
    }

    @Test
    void mixed_with_digits() {
        assertTrue(sut.flipCase("aB3").equals("Ab3"), "EC/BV: mixed_with_digits");
    }
}
