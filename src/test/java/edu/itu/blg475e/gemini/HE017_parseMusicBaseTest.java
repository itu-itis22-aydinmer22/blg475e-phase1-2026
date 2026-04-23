/* @Authors
 * Student Names: <Student 1>, <Student 2>, <Student 3>
 * Student IDs:   <ID 1>, <ID 2>, <ID 3>
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE017_parseMusic (LLM: GEMINI).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE017_parseMusicBaseTest {

    private final HE017_parseMusic sut = new HE017_parseMusic();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.parseMusic("").equals(List.of()), "base assertion 1");
        assertTrue(sut.parseMusic("o o o o").equals(Arrays.asList(4, 4, 4, 4)), "base assertion 2");
        assertTrue(sut.parseMusic(".| .| .| .|").equals(Arrays.asList(1, 1, 1, 1)), "base assertion 3");
        assertTrue(sut.parseMusic("o| o| .| .| o o o o").equals(Arrays.asList(2, 2, 1, 1, 4, 4, 4, 4)), "base assertion 4");
        assertTrue(sut.parseMusic("o| .| o| .| o o| o o|").equals(Arrays.asList(2, 1, 2, 1, 4, 2, 4, 2)), "base assertion 5");
    }
}
