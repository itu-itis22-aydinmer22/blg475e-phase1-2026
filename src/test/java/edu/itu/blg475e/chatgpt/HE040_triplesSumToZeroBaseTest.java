/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722, 150200018, 150210089
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
 * Base tests for HE040_triplesSumToZero (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE040_triplesSumToZeroBaseTest {

    private final HE040_triplesSumToZero sut = new HE040_triplesSumToZero();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(!sut.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, 0))), "base assertion 1");
        assertTrue(!sut.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, -1))), "base assertion 2");
        assertTrue(sut.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, -2, 1))), "base assertion 3");
        assertTrue(!sut.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 2, 3, 7))), "base assertion 4");
        assertTrue(!sut.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 2, 5, 7))), "base assertion 5");
        assertTrue(sut.triplesSumToZero(new ArrayList<>(Arrays.asList(2, 4, -5, 3, 9, 7))), "base assertion 6");
        assertTrue(!sut.triplesSumToZero(new ArrayList<>(Arrays.asList(1))), "base assertion 7");
        assertTrue(!sut.triplesSumToZero(new ArrayList<>(Arrays.asList(1, 3, 5, -100))), "base assertion 8");
        assertTrue(!sut.triplesSumToZero(new ArrayList<>(Arrays.asList(100, 3, 5, -100))), "base assertion 9");
    }
}
