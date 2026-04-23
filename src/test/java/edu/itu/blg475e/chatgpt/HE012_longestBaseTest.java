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
 * Base tests for HE012_longest (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE012_longestBaseTest {

    private final HE012_longest sut = new HE012_longest();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.longest(new ArrayList<>(List.of())).isEmpty(), "base assertion 1");
        assertTrue(Objects.equals(sut.longest(new ArrayList<>(Arrays.asList("x", "y", "z"))).get(), "x"), "base assertion 2");
        assertTrue(Objects.equals(sut.longest(new ArrayList<>(Arrays.asList("x", "yyy", "zzzz", "www", "kkkk", "abc"))).get(), "zzzz"), "base assertion 3");
    }
}
