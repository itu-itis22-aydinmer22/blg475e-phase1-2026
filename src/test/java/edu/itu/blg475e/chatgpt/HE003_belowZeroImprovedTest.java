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
 * Improved tests for HE003_belowZero (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * belowZero: EC = {empty, always-positive, goes-negative, returns-to-positive, ends-exactly-zero}; Boundary = transient -1 vs +1 balance.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE003_belowZeroImprovedTest {

    private final HE003_belowZero sut = new HE003_belowZero();

    @Test
    void empty_balance_never_negative() {
        assertTrue(!sut.belowZero(Arrays.asList()), "EC/BV: empty_balance_never_negative");
    }

    @Test
    void single_positive() {
        assertTrue(!sut.belowZero(Arrays.asList(10)), "EC/BV: single_positive");
    }

    @Test
    void single_negative_goes_below() {
        assertTrue(sut.belowZero(Arrays.asList(-1)), "EC/BV: single_negative_goes_below");
    }

    @Test
    void net_positive_but_dips_below() {
        assertTrue(sut.belowZero(Arrays.asList(1, -5, 10)), "EC/BV: net_positive_but_dips_below");
    }

    @Test
    void always_stays_at_zero_boundary() {
        assertTrue(!sut.belowZero(Arrays.asList(1, -1, 1, -1)), "EC/BV: always_stays_at_zero_boundary");
    }

    @Test
    void net_negative_but_never_below() {
        assertTrue(!sut.belowZero(Arrays.asList(5, -2, -2)), "EC/BV: net_negative_but_never_below");
    }
}
