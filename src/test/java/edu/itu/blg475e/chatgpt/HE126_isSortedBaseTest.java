/* @Authors
 * Student Names: <Student 1>, <Student 2>, <Student 3>
 * Student IDs:   <ID 1>, <ID 2>, <ID 3>
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
 * Base tests for HE126_isSorted (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE126_isSortedBaseTest {

    private final HE126_isSorted sut = new HE126_isSorted();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.isSorted(new ArrayList<>(List.of(5))) == true, "base assertion 1");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5))) == true, "base assertion 2");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5))) == false, "base assertion 3");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))) == true, "base assertion 4");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))) == true, "base assertion 5");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 3, 2, 4, 5, 6, 7))) == false, "base assertion 6");
        assertTrue(sut.isSorted(new ArrayList<>(List.of())) == true, "base assertion 7");
        assertTrue(sut.isSorted(new ArrayList<>(List.of(1))) == true, "base assertion 8");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(3, 2, 1))) == false, "base assertion 9");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 4))) == false, "base assertion 10");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 4))) == false, "base assertion 11");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4))) == true, "base assertion 12");
        assertTrue(sut.isSorted(new ArrayList<>(Arrays.asList(1, 2, 3, 4))) == true, "base assertion 13");
    }
}
