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
 * Base tests for HE055_fib (LLM: CHATGPT).
 * Converted from the HumanEval original test.
 * Minor modifications: reworded into JUnit 6 style; method calls rebound to the
 * LLM-generated class. NO changes to expected values.
 */
public class HE055_fibBaseTest {

    private final HE055_fib sut = new HE055_fib();

    @Test
    void baseHumanEvalAssertions() {
        assertTrue(sut.fib(10) == 55, "base assertion 1");
        assertTrue(sut.fib(1) == 1, "base assertion 2");
        assertTrue(sut.fib(8) == 21, "base assertion 3");
        assertTrue(sut.fib(11) == 89, "base assertion 4");
        assertTrue(sut.fib(12) == 144, "base assertion 5");
    }
}
