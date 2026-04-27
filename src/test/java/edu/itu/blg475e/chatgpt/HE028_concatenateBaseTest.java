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
 * Base tests for HE028_concatenate (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE028_concatenateBaseTest {

    private final HE028_concatenate sut = new HE028_concatenate();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(Objects.equals(sut.concatenate(new ArrayList<>(List.of())), ""), "base assertion 1");
        assertTrue(Objects.equals(sut.concatenate(new ArrayList<>(Arrays.asList("x", "y", "z"))), "xyz"), "base assertion 2");
        assertTrue(Objects.equals(sut.concatenate(new ArrayList<>(Arrays.asList("x", "y", "z", "w", "k"))), "xyzwk"), "base assertion 3");
    }
}
