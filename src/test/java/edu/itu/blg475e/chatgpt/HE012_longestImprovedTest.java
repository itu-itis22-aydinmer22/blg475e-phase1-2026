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
 * Improved tests for HE012_longest (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * longest: EC = {empty, single, distinct lengths, tied lengths (first wins)}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE012_longestImprovedTest {

    private final HE012_longest sut = new HE012_longest();

    @Test
    void empty_returns_empty_optional() {
        assertTrue(!sut.longest(Arrays.asList()).isPresent(), "EC/BV: empty_returns_empty_optional");
    }

    @Test
    void single_item() {
        assertTrue(sut.longest(Arrays.asList("abc")).get().equals("abc"), "EC/BV: single_item");
    }

    @Test
    void distinct_lengths_longest_wins() {
        assertTrue(sut.longest(Arrays.asList("a", "bb", "ccc")).get().equals("ccc"), "EC/BV: distinct_lengths_longest_wins");
    }

    @Test
    void tied_length_first_wins() {
        assertTrue(sut.longest(Arrays.asList("aa", "bb", "cc")).get().equals("aa"), "EC/BV: tied_length_first_wins");
    }

    @Test
    void tied_with_longer_elsewhere() {
        assertTrue(sut.longest(Arrays.asList("aa", "bbb", "ccc")).get().equals("bbb"), "EC/BV: tied_with_longer_elsewhere");
    }
}
