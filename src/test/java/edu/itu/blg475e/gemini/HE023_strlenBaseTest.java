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
 * Base tests for HE023_strlen (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE023_strlenBaseTest {

    private final HE023_strlen sut = new HE023_strlen();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.strlen("") == 0, "base assertion 1");
        assertTrue(sut.strlen("x") == 1, "base assertion 2");
        assertTrue(sut.strlen("asdasnakj") == 9, "base assertion 3");
    }
}
