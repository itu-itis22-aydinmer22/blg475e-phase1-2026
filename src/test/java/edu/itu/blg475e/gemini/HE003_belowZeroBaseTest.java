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
 * Base tests for HE003_belowZero (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE003_belowZeroBaseTest {

    private final HE003_belowZero sut = new HE003_belowZero();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(!sut.belowZero(new ArrayList<>(Arrays.asList())), "base assertion 1");
        assertTrue(!sut.belowZero(new ArrayList<>(Arrays.asList(1, 2, -3, 1, 2, -3))), "base assertion 2");
        assertTrue(sut.belowZero(new ArrayList<>(Arrays.asList(1, 2, -4, 5, 6))), "base assertion 3");
        assertTrue(!sut.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4))), "base assertion 4");
        assertTrue(sut.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5))), "base assertion 5");
        assertTrue(sut.belowZero(new ArrayList<>(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4))), "base assertion 6");
    }
}
