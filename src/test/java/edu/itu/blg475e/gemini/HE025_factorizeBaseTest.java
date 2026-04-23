/* @Authors
 * Student Names: <Student 1>, <Student 2>, <Student 3>
 * Student IDs:   <ID 1>, <ID 2>, <ID 3>
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
 * Base tests for HE025_factorize (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE025_factorizeBaseTest {

    private final HE025_factorize sut = new HE025_factorize();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.factorize(2).equals(List.of(2)), "base assertion 1");
        assertTrue(sut.factorize(4).equals(Arrays.asList(2, 2)), "base assertion 2");
        assertTrue(sut.factorize(8).equals(Arrays.asList(2, 2, 2)), "base assertion 3");
        assertTrue(sut.factorize(3 * 19).equals(Arrays.asList(3, 19)), "base assertion 4");
        assertTrue(sut.factorize(3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 19, 19)), "base assertion 5");
        assertTrue(sut.factorize(3 * 19 * 3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 3, 19, 19, 19)), "base assertion 6");
        assertTrue(sut.factorize(3 * 19 * 19 * 19).equals(Arrays.asList(3, 19, 19, 19)), "base assertion 7");
        assertTrue(sut.factorize(3 * 2 * 3).equals(Arrays.asList(2, 3, 3)), "base assertion 8");
    }
}
