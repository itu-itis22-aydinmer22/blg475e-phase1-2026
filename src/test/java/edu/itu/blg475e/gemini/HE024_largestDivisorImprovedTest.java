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
 * Improved tests for HE024_largestDivisor (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * largestDivisor: EC = {n=1 -> 1 by contract, n=prime -> 1, n=composite -> n/smallestFactor, n=power of two}. Boundary: n=1.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE024_largestDivisorImprovedTest {

    private final HE024_largestDivisor sut = new HE024_largestDivisor();

    @Test
    void n_one_returns_one() {
        assertTrue(sut.largestDivisor(1) == 1, "EC/BV: n_one_returns_one");
    }

    @Test
    void n_two_is_prime_returns_one() {
        assertTrue(sut.largestDivisor(2) == 1, "EC/BV: n_two_is_prime_returns_one");
    }

    @Test
    void n_composite_15_returns_5() {
        assertTrue(sut.largestDivisor(15) == 5, "EC/BV: n_composite_15_returns_5");
    }

    @Test
    void n_power_of_two() {
        assertTrue(sut.largestDivisor(16) == 8, "EC/BV: n_power_of_two");
    }

    @Test
    void n_even_prime_even_divisor() {
        assertTrue(sut.largestDivisor(100) == 50, "EC/BV: n_even_prime_even_divisor");
    }
}
