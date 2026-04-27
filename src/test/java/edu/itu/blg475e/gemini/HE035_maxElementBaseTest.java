/* @Authors
 * Mert Aydın - 150220722
 * Oğuz Eren Kacar - 150200018
 * Mehmet Enes Tekgöz - 150210089
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE035_maxElement (LLM: GEMINI).
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
