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
