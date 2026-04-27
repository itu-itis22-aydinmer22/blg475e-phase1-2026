/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722, 150200018, 150210089
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.chatgpt;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE109_moveOneBall (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE109_moveOneBallBaseTest {

    private final HE109_moveOneBall sut = new HE109_moveOneBall();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.moveOneBall(new ArrayList<>(Arrays.asList(3, 4, 5, 1, 2))) == true, "base assertion 1");
        assertTrue(sut.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 10, 1, 2))) == true, "base assertion 2");
        assertTrue(sut.moveOneBall(new ArrayList<>(Arrays.asList(4, 3, 1, 2))) == false, "base assertion 3");
        assertTrue(sut.moveOneBall(new ArrayList<>(Arrays.asList(3, 5, 4, 1, 2))) == false, "base assertion 4");
        assertTrue(sut.moveOneBall(new ArrayList<>(Arrays.asList())) == true, "base assertion 5");
    }
}
