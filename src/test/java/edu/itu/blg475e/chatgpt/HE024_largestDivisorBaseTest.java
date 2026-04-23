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
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE024_largestDivisor (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE024_largestDivisorBaseTest {

    private final HE024_largestDivisor sut = new HE024_largestDivisor();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.largestDivisor(3) == 1, "base assertion 1");
        assertTrue(sut.largestDivisor(7) == 1, "base assertion 2");
        assertTrue(sut.largestDivisor(10) == 5, "base assertion 3");
        assertTrue(sut.largestDivisor(100) == 50, "base assertion 4");
        assertTrue(sut.largestDivisor(49) == 7, "base assertion 5");
    }
}
