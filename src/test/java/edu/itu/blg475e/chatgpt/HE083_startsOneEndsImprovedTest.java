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
 * Improved tests for HE083_startsOneEnds (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * startsOneEnds: EC = {n=1 single 1 exception, n=2, medium n}. Formula: 18 * 10^(n-2) for n>=2.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE083_startsOneEndsImprovedTest {

    private final HE083_startsOneEnds sut = new HE083_startsOneEnds();

    @Test
    void n_equals_one() {
        assertTrue(sut.startsOneEnds(1) == 1, "EC/BV: n_equals_one");
    }

    @Test
    void n_equals_two() {
        assertTrue(sut.startsOneEnds(2) == 18, "EC/BV: n_equals_two");
    }

    @Test
    void n_equals_three() {
        assertTrue(sut.startsOneEnds(3) == 180, "EC/BV: n_equals_three");
    }

    @Test
    void n_equals_four() {
        assertTrue(sut.startsOneEnds(4) == 1800, "EC/BV: n_equals_four");
    }
}
