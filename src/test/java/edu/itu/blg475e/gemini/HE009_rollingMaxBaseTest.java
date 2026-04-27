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
 * Base tests for HE009_rollingMax (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE009_rollingMaxBaseTest {

    private final HE009_rollingMax sut = new HE009_rollingMax();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.rollingMax(new ArrayList<>(List.of())).equals(List.of()), "base assertion 1");
        assertTrue(sut.rollingMax(new ArrayList<>(Arrays.asList(1, 2, 3, 4))).equals(Arrays.asList(1, 2, 3, 4)), "base assertion 2");
        assertTrue(sut.rollingMax(new ArrayList<>(Arrays.asList(4, 3, 2, 1))).equals(Arrays.asList(4, 4, 4, 4)), "base assertion 3");
        assertTrue(sut.rollingMax(new ArrayList<>(Arrays.asList(3, 2, 3, 100, 3))).equals(Arrays.asList(3, 3, 3, 100, 100)), "base assertion 4");
    }
}
