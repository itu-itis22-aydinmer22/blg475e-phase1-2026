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
 * Improved tests for HE132_isNested (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * isNested: EC = {empty false, single bracket false, simple pair not nested, nested [[]] true, siblings not nested}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE132_isNestedImprovedTest {

    private final HE132_isNested sut = new HE132_isNested();

    @Test
    void empty_false() {
        assertTrue(!sut.isNested(""), "EC/BV: empty_false");
    }

    @Test
    void single_opener_false() {
        assertTrue(!sut.isNested("["), "EC/BV: single_opener_false");
    }

    @Test
    void simple_pair_not_nested() {
        assertTrue(!sut.isNested("[]"), "EC/BV: simple_pair_not_nested");
    }

    @Test
    void true_nesting() {
        assertTrue(sut.isNested("[[]]"), "EC/BV: true_nesting");
    }

    @Test
    void deep_nesting() {
        assertTrue(sut.isNested("[[[[]]]]"), "EC/BV: deep_nesting");
    }

    @Test
    void siblings_not_nested() {
        assertTrue(!sut.isNested("[][]"), "EC/BV: siblings_not_nested");
    }

    @Test
    void mixed_nested_and_siblings() {
        assertTrue(sut.isNested("[][][[]]"), "EC/BV: mixed_nested_and_siblings");
    }

    @Test
    void unbalanced_openers_only_false() {
        assertTrue(!sut.isNested("[[[[[[[["), "EC/BV: unbalanced_openers_only_false");
    }
}
