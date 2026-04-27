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
 * Improved tests for HE132_isNested (CHATGPT).
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
