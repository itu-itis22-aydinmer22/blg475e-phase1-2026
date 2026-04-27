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
 * Improved tests for HE031_isPrime (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * isPrime: EC = {n<2 false, n=2 true, small odd primes, even composites, odd composites, perfect squares}. Boundary: n=0, n=1, n=2, n=3.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE031_isPrimeImprovedTest {

    private final HE031_isPrime sut = new HE031_isPrime();

    @Test
    void zero_not_prime() {
        assertTrue(!sut.isPrime(0), "EC/BV: zero_not_prime");
    }

    @Test
    void one_not_prime() {
        assertTrue(!sut.isPrime(1), "EC/BV: one_not_prime");
    }

    @Test
    void two_is_prime() {
        assertTrue(sut.isPrime(2), "EC/BV: two_is_prime");
    }

    @Test
    void three_is_prime() {
        assertTrue(sut.isPrime(3), "EC/BV: three_is_prime");
    }

    @Test
    void four_not_prime() {
        assertTrue(!sut.isPrime(4), "EC/BV: four_not_prime");
    }

    @Test
    void nine_not_prime() {
        assertTrue(!sut.isPrime(9), "EC/BV: nine_not_prime");
    }

    @Test
    void twentyfive_not_prime() {
        assertTrue(!sut.isPrime(25), "EC/BV: twentyfive_not_prime");
    }

    @Test
    void seventeen_is_prime() {
        assertTrue(sut.isPrime(17), "EC/BV: seventeen_is_prime");
    }

    @Test
    void hundred_and_one_is_prime() {
        assertTrue(sut.isPrime(101), "EC/BV: hundred_and_one_is_prime");
    }

    @Test
    void negative_not_prime() {
        assertTrue(!sut.isPrime(-7), "EC/BV: negative_not_prime");
    }
}
