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
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE018_howManyTimes (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * howManyTimes: EC = {empty string, empty substring (zero by convention), no match, single match, overlapping matches, substring longer than string}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE018_howManyTimesImprovedTest {

    private final HE018_howManyTimes sut = new HE018_howManyTimes();

    @Test
    void empty_string_zero() {
        assertTrue(sut.howManyTimes("", "a") == 0, "EC/BV: empty_string_zero");
    }

    @Test
    void empty_substring_matches_every_position() {
        assertTrue(sut.howManyTimes("abc", "") == 4, "EC/BV: empty_substring_matches_every_position");
    }

    @Test
    void no_match_zero() {
        assertTrue(sut.howManyTimes("abc", "xyz") == 0, "EC/BV: no_match_zero");
    }

    @Test
    void single_match() {
        assertTrue(sut.howManyTimes("hello", "ell") == 1, "EC/BV: single_match");
    }

    @Test
    void overlapping_aaa_a_three() {
        assertTrue(sut.howManyTimes("aaa", "a") == 3, "EC/BV: overlapping_aaa_a_three");
    }

    @Test
    void overlapping_aaaa_aa_three() {
        assertTrue(sut.howManyTimes("aaaa", "aa") == 3, "EC/BV: overlapping_aaaa_aa_three");
    }

    @Test
    void substring_longer_zero() {
        assertTrue(sut.howManyTimes("ab", "abc") == 0, "EC/BV: substring_longer_zero");
    }

    @Test
    void full_string_match() {
        assertTrue(sut.howManyTimes("abc", "abc") == 1, "EC/BV: full_string_match");
    }
}
