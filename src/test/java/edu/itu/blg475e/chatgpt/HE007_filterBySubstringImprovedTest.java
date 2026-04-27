/* @Authors
 * Mert Aydın - 150220722
 * Oğuz Eren Kacar - 150200018
 * Mehmet Enes Tekgöz - 150210089
 */
package edu.itu.blg475e.chatgpt;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE007_filterBySubstring (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * filterBySubstring: EC = {empty list, empty substring, no matches, all match, case-sensitive}; Boundary = substring equals candidate exactly.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE007_filterBySubstringImprovedTest {

    private final HE007_filterBySubstring sut = new HE007_filterBySubstring();

    @Test
    void empty_list_returns_empty() {
        assertTrue(sut.filterBySubstring(Arrays.asList(), "a").isEmpty(), "EC/BV: empty_list_returns_empty");
    }

    @Test
    void empty_substring_matches_all() {
        assertTrue(sut.filterBySubstring(Arrays.asList("x", "y"), "").size() == 2, "EC/BV: empty_substring_matches_all");
    }

    @Test
    void no_match_returns_empty() {
        assertTrue(sut.filterBySubstring(Arrays.asList("abc"), "xyz").isEmpty(), "EC/BV: no_match_returns_empty");
    }

    @Test
    void exact_match_included() {
        assertTrue(sut.filterBySubstring(Arrays.asList("abc"), "abc").size() == 1, "EC/BV: exact_match_included");
    }

    @Test
    void case_sensitive() {
        assertTrue(sut.filterBySubstring(Arrays.asList("ABC"), "abc").isEmpty(), "EC/BV: case_sensitive");
    }

    @Test
    void substring_at_start() {
        assertTrue(sut.filterBySubstring(Arrays.asList("catfish"), "cat").size() == 1, "EC/BV: substring_at_start");
    }

    @Test
    void substring_at_end() {
        assertTrue(sut.filterBySubstring(Arrays.asList("scat"), "cat").size() == 1, "EC/BV: substring_at_end");
    }
}
