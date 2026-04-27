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
 * Base tests for HE083_startsOneEnds (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE083_startsOneEndsBaseTest {

    private final HE083_startsOneEnds sut = new HE083_startsOneEnds();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.startsOneEnds(1) == 1, "base assertion 1");
        assertTrue(sut.startsOneEnds(2) == 18, "base assertion 2");
        assertTrue(sut.startsOneEnds(3) == 180, "base assertion 3");
        assertTrue(sut.startsOneEnds(4) == 1800, "base assertion 4");
        assertTrue(sut.startsOneEnds(5) == 18000, "base assertion 5");
    }
}
