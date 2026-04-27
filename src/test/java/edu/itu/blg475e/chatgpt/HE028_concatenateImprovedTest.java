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
 * Improved tests for HE028_concatenate (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * concatenate: EC = {empty list, single, many, empty strings interleaved}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE028_concatenateImprovedTest {

    private final HE028_concatenate sut = new HE028_concatenate();

    @Test
    void empty_list_empty_string() {
        assertTrue(sut.concatenate(Arrays.asList()).equals(""), "EC/BV: empty_list_empty_string");
    }

    @Test
    void single_item() {
        assertTrue(sut.concatenate(Arrays.asList("abc")).equals("abc"), "EC/BV: single_item");
    }

    @Test
    void two_items() {
        assertTrue(sut.concatenate(Arrays.asList("a", "b")).equals("ab"), "EC/BV: two_items");
    }

    @Test
    void with_empty_strings() {
        assertTrue(sut.concatenate(Arrays.asList("", "a", "")).equals("a"), "EC/BV: with_empty_strings");
    }

    @Test
    void all_empty() {
        assertTrue(sut.concatenate(Arrays.asList("", "", "")).equals(""), "EC/BV: all_empty");
    }
}
