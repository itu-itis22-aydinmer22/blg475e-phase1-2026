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
 * Base tests for HE132_isNested (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE132_isNestedBaseTest {

    private final HE132_isNested sut = new HE132_isNested();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.isNested("[[]]" ), "base assertion 1");
        assertTrue(!sut.isNested("[]]]]]]][[[[[]" ), "base assertion 2");
        assertTrue(!sut.isNested("[][]" ), "base assertion 3");
        assertTrue(!sut.isNested("[]" ), "base assertion 4");
        assertTrue(sut.isNested("[[[[]]]]" ), "base assertion 5");
        assertTrue(!sut.isNested("[]]]]]]]]]]" ), "base assertion 6");
        assertTrue(sut.isNested("[][][[]]" ), "base assertion 7");
        assertTrue(!sut.isNested("[[]" ), "base assertion 8");
        assertTrue(!sut.isNested("[]]" ), "base assertion 9");
        assertTrue(sut.isNested("[[]][[" ), "base assertion 10");
        assertTrue(sut.isNested("[[][]]" ), "base assertion 11");
        assertTrue(!sut.isNested("" ), "base assertion 12");
        assertTrue(!sut.isNested("[[[[[[[[" ), "base assertion 13");
        assertTrue(!sut.isNested("]]]]]]]]" ), "base assertion 14");
    }
}
