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
 * Base tests for HE027_flipCase (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE027_flipCaseBaseTest {

    private final HE027_flipCase sut = new HE027_flipCase();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(Objects.equals(sut.flipCase(""), ""), "base assertion 1");
        assertTrue(Objects.equals(sut.flipCase("Hello!"), "hELLO!"), "base assertion 2");
        assertTrue(Objects.equals(sut.flipCase("These violent delights have violent ends"), "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS"), "base assertion 3");
    }
}
