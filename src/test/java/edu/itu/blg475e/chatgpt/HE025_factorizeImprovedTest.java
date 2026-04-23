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
 * Improved tests for HE025_factorize (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * factorize: EC = {n=2 smallest prime, prime n, composite n, power of prime, many distinct primes}. Boundary: n=2.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE025_factorizeImprovedTest {

    private final HE025_factorize sut = new HE025_factorize();

    @Test
    void n_two_single_factor() {
        assertTrue(sut.factorize(2).equals(Arrays.asList(2)), "EC/BV: n_two_single_factor");
    }

    @Test
    void prime_returns_self() {
        assertTrue(sut.factorize(7).equals(Arrays.asList(7)), "EC/BV: prime_returns_self");
    }

    @Test
    void power_of_prime() {
        assertTrue(sut.factorize(8).equals(Arrays.asList(2, 2, 2)), "EC/BV: power_of_prime");
    }

    @Test
    void distinct_primes() {
        assertTrue(sut.factorize(30).equals(Arrays.asList(2, 3, 5)), "EC/BV: distinct_primes");
    }

    @Test
    void repeated_and_distinct() {
        assertTrue(sut.factorize(12).equals(Arrays.asList(2, 2, 3)), "EC/BV: repeated_and_distinct");
    }

    @Test
    void big_composite() {
        assertTrue(sut.factorize(100).equals(Arrays.asList(2, 2, 5, 5)), "EC/BV: big_composite");
    }
}
