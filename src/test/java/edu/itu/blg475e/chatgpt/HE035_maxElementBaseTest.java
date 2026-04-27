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
 * Base tests for HE035_maxElement (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE035_maxElementBaseTest {

    private final HE035_maxElement sut = new HE035_maxElement();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.maxElement(new ArrayList<>(Arrays.asList(1, 2, 3))) == 3, "base assertion 1");
        assertTrue(sut.maxElement(new ArrayList<>(Arrays.asList(5, 3, -5, 2, -3, 3, 9, 0, 124, 1, -10))) == 124, "base assertion 2");
    }
}
