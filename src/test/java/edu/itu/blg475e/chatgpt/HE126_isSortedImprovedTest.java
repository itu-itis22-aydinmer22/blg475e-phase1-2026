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
 * Improved tests for HE126_isSorted (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * isSorted: EC = {empty true, single true, strictly ascending true, has strict duplicates true, has triple duplicates false, descending false}.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE126_isSortedImprovedTest {

    private final HE126_isSorted sut = new HE126_isSorted();

    @Test
    void empty_true() {
        assertTrue(sut.isSorted(Arrays.asList()), "EC/BV: empty_true");
    }

    @Test
    void single_true() {
        assertTrue(sut.isSorted(Arrays.asList(5)), "EC/BV: single_true");
    }

    @Test
    void strictly_ascending() {
        assertTrue(sut.isSorted(Arrays.asList(1, 2, 3)), "EC/BV: strictly_ascending");
    }

    @Test
    void duplicates_pair_allowed() {
        assertTrue(sut.isSorted(Arrays.asList(1, 2, 2, 3)), "EC/BV: duplicates_pair_allowed");
    }

    @Test
    void triple_duplicates_disallowed() {
        assertTrue(!sut.isSorted(Arrays.asList(1, 2, 2, 2, 3)), "EC/BV: triple_duplicates_disallowed");
    }

    @Test
    void descending_false() {
        assertTrue(!sut.isSorted(Arrays.asList(3, 2, 1)), "EC/BV: descending_false");
    }
}
