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
 * Base tests for HE014_allPrefixes (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE014_allPrefixesBaseTest {

    private final HE014_allPrefixes sut = new HE014_allPrefixes();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.allPrefixes("").equals(List.of()), "base assertion 1");
        assertTrue(sut.allPrefixes("asdfgh").equals(Arrays.asList("a", "as", "asd", "asdf", "asdfg", "asdfgh")), "base assertion 2");
        assertTrue(sut.allPrefixes("WWW").equals(Arrays.asList("W", "WW", "WWW")), "base assertion 3");
    }
}
