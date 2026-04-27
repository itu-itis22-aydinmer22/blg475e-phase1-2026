/* @Authors
 * Mert Aydın - 150220722
 * Oğuz Eren Kacar - 150200018
 * Mehmet Enes Tekgöz - 150210089
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Base tests for HE027_flipCase (LLM: GEMINI).
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
