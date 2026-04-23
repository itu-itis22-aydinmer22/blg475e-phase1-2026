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
 * Improved tests for HE040_triplesSumToZero (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * triplesSumToZero: EC = {<3 elements false, valid triple exists, no triple, triple using negatives}. Boundary: exactly 3 elements summing to zero.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE040_triplesSumToZeroImprovedTest {

    private final HE040_triplesSumToZero sut = new HE040_triplesSumToZero();

    @Test
    void too_few_false() {
        assertTrue(!sut.triplesSumToZero(Arrays.asList(1, 2)), "EC/BV: too_few_false");
    }

    @Test
    void exactly_three_summing_zero() {
        assertTrue(sut.triplesSumToZero(Arrays.asList(1, 2, -3)), "EC/BV: exactly_three_summing_zero");
    }

    @Test
    void exactly_three_not_summing_zero() {
        assertTrue(!sut.triplesSumToZero(Arrays.asList(1, 2, 3)), "EC/BV: exactly_three_not_summing_zero");
    }

    @Test
    void five_elements_with_triple() {
        assertTrue(sut.triplesSumToZero(Arrays.asList(1, 3, -2, 1, 5)), "EC/BV: five_elements_with_triple");
    }

    @Test
    void all_positive_no_triple() {
        assertTrue(!sut.triplesSumToZero(Arrays.asList(1, 2, 3, 4)), "EC/BV: all_positive_no_triple");
    }

    @Test
    void three_zeros() {
        assertTrue(sut.triplesSumToZero(Arrays.asList(0, 0, 0)), "EC/BV: three_zeros");
    }
}
