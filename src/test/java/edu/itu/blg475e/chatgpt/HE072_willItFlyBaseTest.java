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
 * Base tests for HE072_willItFly (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE072_willItFlyBaseTest {

    private final HE072_willItFly sut = new HE072_willItFly();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.willItFly(new ArrayList<>(Arrays.asList(3, 2, 3)), 9), "base assertion 1");
        assertTrue(!sut.willItFly(new ArrayList<>(Arrays.asList(1, 2)), 5), "base assertion 2");
        assertTrue(sut.willItFly(new ArrayList<>(List.of(3)), 5), "base assertion 3");
        assertTrue(!sut.willItFly(new ArrayList<>(Arrays.asList(3, 2, 3)), 1), "base assertion 4");
        assertTrue(!sut.willItFly(new ArrayList<>(Arrays.asList(1, 2, 3)), 6), "base assertion 5");
        assertTrue(sut.willItFly(new ArrayList<>(List.of(5)), 5), "base assertion 6");
    }
}
