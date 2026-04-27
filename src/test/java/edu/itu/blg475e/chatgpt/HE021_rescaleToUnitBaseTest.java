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
 * Base tests for HE021_rescaleToUnit (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE021_rescaleToUnitBaseTest {

    private final HE021_rescaleToUnit sut = new HE021_rescaleToUnit();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.rescaleToUnit(new ArrayList<>(Arrays.asList(2.0, 49.9))).equals(Arrays.asList(0.0, 1.0)), "base assertion 1");
        assertTrue(sut.rescaleToUnit(new ArrayList<>(Arrays.asList(100.0, 49.9))).equals(Arrays.asList(1.0, 0.0)), "base assertion 2");
        assertTrue(sut.rescaleToUnit(new ArrayList<>(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))).equals(Arrays.asList(0.0, 0.25, 0.5, 0.75, 1.0)), "base assertion 3");
        assertTrue(sut.rescaleToUnit(new ArrayList<>(Arrays.asList(2.0, 1.0, 5.0, 3.0, 4.0))).equals(Arrays.asList(0.25, 0.0, 1.0, 0.5, 0.75)), "base assertion 4");
        assertTrue(sut.rescaleToUnit(new ArrayList<>(Arrays.asList(12.0, 11.0, 15.0, 13.0, 14.0))).equals(Arrays.asList(0.25, 0.0, 1.0, 0.5, 0.75)), "base assertion 5");
    }
}
