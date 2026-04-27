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
 * Base tests for HE018_howManyTimes (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE018_howManyTimesBaseTest {

    private final HE018_howManyTimes sut = new HE018_howManyTimes();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.howManyTimes("", "x") == 0, "base assertion 1");
        assertTrue(sut.howManyTimes("xyxyxyx", "x") == 4, "base assertion 2");
        assertTrue(sut.howManyTimes("cacacacac", "cac") == 4, "base assertion 3");
        assertTrue(sut.howManyTimes("john doe", "john") == 1, "base assertion 4");
    }
}
