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
 * Base tests for HE034_unique (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE034_uniqueBaseTest {

    private final HE034_unique sut = new HE034_unique();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.unique(new ArrayList<>(Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123))).equals(Arrays.asList(0, 2, 3, 5, 9, 123)), "base assertion 1");
    }
}
