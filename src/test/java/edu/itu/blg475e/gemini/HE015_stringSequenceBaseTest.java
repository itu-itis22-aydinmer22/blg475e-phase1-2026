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
 * Base tests for HE015_stringSequence (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE015_stringSequenceBaseTest {

    private final HE015_stringSequence sut = new HE015_stringSequence();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.stringSequence(0).equals("0"), "base assertion 1");
        assertTrue(sut.stringSequence(3).equals("0 1 2 3"), "base assertion 2");
        assertTrue(sut.stringSequence(10).equals("0 1 2 3 4 5 6 7 8 9 10"), "base assertion 3");
    }
}
