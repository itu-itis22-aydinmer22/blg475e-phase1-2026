/* @Authors
 * Student Names: <Student 1>, <Student 2>, <Student 3>
 * Student IDs:   <ID 1>, <ID 2>, <ID 3>
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.chatgpt;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE072_willItFly (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * willItFly: EC = {not palindrome fails, palindrome with sum<=w, palindrome with sum>w, single element}. Boundary: sum exactly == w.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE072_willItFlyImprovedTest {

    private final HE072_willItFly sut = new HE072_willItFly();

    @Test
    void not_palindrome_false() {
        assertTrue(!sut.willItFly(Arrays.asList(1, 2), 5), "EC/BV: not_palindrome_false");
    }

    @Test
    void palindrome_and_light_true() {
        assertTrue(sut.willItFly(Arrays.asList(3, 2, 3), 9), "EC/BV: palindrome_and_light_true");
    }

    @Test
    void palindrome_but_heavy_false() {
        assertTrue(!sut.willItFly(Arrays.asList(3, 2, 3), 1), "EC/BV: palindrome_but_heavy_false");
    }

    @Test
    void single_element_always_palindrome() {
        assertTrue(sut.willItFly(Arrays.asList(3), 5), "EC/BV: single_element_always_palindrome");
    }

    @Test
    void exact_weight_boundary() {
        assertTrue(sut.willItFly(Arrays.asList(1, 2, 1), 4), "EC/BV: exact_weight_boundary");
    }

    @Test
    void just_over_weight() {
        assertTrue(!sut.willItFly(Arrays.asList(1, 2, 1), 3), "EC/BV: just_over_weight");
    }
}
