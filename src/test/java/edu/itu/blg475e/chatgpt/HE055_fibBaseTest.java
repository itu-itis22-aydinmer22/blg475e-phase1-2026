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
 * Base tests for HE055_fib (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE055_fibBaseTest {

    private final HE055_fib sut = new HE055_fib();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.fib(10) == 55, "base assertion 1");
        assertTrue(sut.fib(1) == 1, "base assertion 2");
        assertTrue(sut.fib(8) == 21, "base assertion 3");
        assertTrue(sut.fib(11) == 89, "base assertion 4");
        assertTrue(sut.fib(12) == 144, "base assertion 5");
    }
}
