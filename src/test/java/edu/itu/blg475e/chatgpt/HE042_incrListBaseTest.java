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
 * Base tests for HE042_incrList (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE042_incrListBaseTest {

    private final HE042_incrList sut = new HE042_incrList();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.incrList(new ArrayList<>(Arrays.asList())).equals(List.of()), "base assertion 1");
        assertTrue(sut.incrList(new ArrayList<>(Arrays.asList(3, 2, 1))).equals(Arrays.asList(4, 3, 2)), "base assertion 2");
        assertTrue(sut.incrList(new ArrayList<>(Arrays.asList(5, 2, 5, 2, 3, 3, 9, 0, 123))).equals(Arrays.asList(6, 3, 6, 3, 4, 4, 10, 1, 124)), "base assertion 3");
    }
}
