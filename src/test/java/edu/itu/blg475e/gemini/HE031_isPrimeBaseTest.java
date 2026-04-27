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
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE031_isPrime (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE031_isPrimeBaseTest {

    private final HE031_isPrime sut = new HE031_isPrime();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(!sut.isPrime(6), "base assertion 1");
        assertTrue(sut.isPrime(101), "base assertion 2");
        assertTrue(sut.isPrime(11), "base assertion 3");
        assertTrue(sut.isPrime(13441), "base assertion 4");
        assertTrue(sut.isPrime(61), "base assertion 5");
        assertTrue(!sut.isPrime(4), "base assertion 6");
        assertTrue(!sut.isPrime(1), "base assertion 7");
        assertTrue(sut.isPrime(5), "base assertion 8");
        assertTrue(sut.isPrime(11), "base assertion 9");
        assertTrue(sut.isPrime(17), "base assertion 10");
        assertTrue(!sut.isPrime(5 * 17), "base assertion 11");
        assertTrue(!sut.isPrime(11 * 7), "base assertion 12");
        assertTrue(!sut.isPrime(13441 * 19), "base assertion 13");
    }
}
