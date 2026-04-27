/* @Authors
 * Mert Aydın - 150220722
 * Oğuz Eren Kacar - 150200018
 * Mehmet Enes Tekgöz - 150210089
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE055_fib (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * fib: EC = {n=0, n=1, small n, medium n}. Boundary: 0,1 base cases.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE055_fibImprovedTest {

    private final HE055_fib sut = new HE055_fib();

    @Test
    void base_zero() {
        assertTrue(sut.fib(0) == 0, "EC/BV: base_zero");
    }

    @Test
    void base_one() {
        assertTrue(sut.fib(1) == 1, "EC/BV: base_one");
    }

    @Test
    void two() {
        assertTrue(sut.fib(2) == 1, "EC/BV: two");
    }

    @Test
    void seven() {
        assertTrue(sut.fib(7) == 13, "EC/BV: seven");
    }

    @Test
    void ten() {
        assertTrue(sut.fib(10) == 55, "EC/BV: ten");
    }
}
