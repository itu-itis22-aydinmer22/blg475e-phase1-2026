/* @Authors
 * Mert Aydın - 150220722
 * Oğuz Eren Kacar - 150200018
 * Mehmet Enes Tekgöz - 150210089
 */
package edu.itu.blg475e.chatgpt;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE025_factorize (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE025_factorizeBaseTest {

    private final HE025_factorize sut = new HE025_factorize();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.factorize(2).equals(List.of(2)), "base assertion 1");
        assertTrue(sut.factorize(4).equals(Arrays.asList(2, 2)), "base assertion 2");
        assertTrue(sut.factorize(8).equals(Arrays.asList(2, 2, 2)), "base assertion 3");
        assertTrue(sut.factorize(3 * 19).equals(Arrays.asList(3, 19)), "base assertion 4");
        assertTrue(sut.factorize(3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 19, 19)), "base assertion 5");
        assertTrue(sut.factorize(3 * 19 * 3 * 19 * 3 * 19).equals(Arrays.asList(3, 3, 3, 19, 19, 19)), "base assertion 6");
        assertTrue(sut.factorize(3 * 19 * 19 * 19).equals(Arrays.asList(3, 19, 19, 19)), "base assertion 7");
        assertTrue(sut.factorize(3 * 2 * 3).equals(Arrays.asList(2, 3, 3)), "base assertion 8");
    }
}
