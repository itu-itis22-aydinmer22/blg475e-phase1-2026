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
 * Base tests for HE010_isPalindrome (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE010_isPalindromeBaseTest {

    private final HE010_isPalindrome sut = new HE010_isPalindrome();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(Objects.equals(sut.makePalindrome(""), ""), "base assertion 1");
        assertTrue(Objects.equals(sut.makePalindrome("x"), "x"), "base assertion 2");
        assertTrue(Objects.equals(sut.makePalindrome("xyz"), "xyzyx"), "base assertion 3");
        assertTrue(Objects.equals(sut.makePalindrome("xyx"), "xyx"), "base assertion 4");
        assertTrue(Objects.equals(sut.makePalindrome("jerry"), "jerryrrej"), "base assertion 5");
    }
}
