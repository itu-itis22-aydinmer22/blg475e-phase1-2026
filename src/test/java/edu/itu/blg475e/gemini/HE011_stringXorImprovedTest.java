/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722, 150200018, 150210089
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.gemini;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE011_stringXor (GEMINI).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * stringXor: EC = {both empty, equal length 1, equal length N, all-0, all-1, alternating}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE011_stringXorImprovedTest {

    private final HE011_stringXor sut = new HE011_stringXor();

    @Test
    void both_empty() {
        assertTrue(sut.stringXor("", "").equals(""), "EC/BV: both_empty");
    }

    @Test
    void single_zero_zero() {
        assertTrue(sut.stringXor("0", "0").equals("0"), "EC/BV: single_zero_zero");
    }

    @Test
    void single_zero_one() {
        assertTrue(sut.stringXor("0", "1").equals("1"), "EC/BV: single_zero_one");
    }

    @Test
    void single_one_one() {
        assertTrue(sut.stringXor("1", "1").equals("0"), "EC/BV: single_one_one");
    }

    @Test
    void all_match_returns_zeros() {
        assertTrue(sut.stringXor("1010", "1010").equals("0000"), "EC/BV: all_match_returns_zeros");
    }

    @Test
    void alternating() {
        assertTrue(sut.stringXor("1010", "0101").equals("1111"), "EC/BV: alternating");
    }

    @Test
    void mixed_case() {
        assertTrue(sut.stringXor("111000", "101010").equals("010010"), "EC/BV: mixed_case");
    }
}
