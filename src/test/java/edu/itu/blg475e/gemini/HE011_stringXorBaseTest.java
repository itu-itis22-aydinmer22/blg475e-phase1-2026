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
 * Base tests for HE011_stringXor (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE011_stringXorBaseTest {

    private final HE011_stringXor sut = new HE011_stringXor();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(Objects.equals(sut.stringXor("111000", "101010"), "010010"), "base assertion 1");
        assertTrue(Objects.equals(sut.stringXor("1", "1"), "0"), "base assertion 2");
        assertTrue(Objects.equals(sut.stringXor("0101", "0000"), "0101"), "base assertion 3");
    }
}
