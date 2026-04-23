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
 * Improved tests for HE109_moveOneBall (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * moveOneBall: EC = {empty true, already sorted true, single rotation sorts it, cannot be sorted, reverse order cannot}. Boundary: empty and single-element.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE109_moveOneBallImprovedTest {

    private final HE109_moveOneBall sut = new HE109_moveOneBall();

    @Test
    void empty_true() {
        assertTrue(sut.moveOneBall(Arrays.asList()), "EC/BV: empty_true");
    }

    @Test
    void single_true() {
        assertTrue(sut.moveOneBall(Arrays.asList(1)), "EC/BV: single_true");
    }

    @Test
    void already_sorted_true() {
        assertTrue(sut.moveOneBall(Arrays.asList(1, 2, 3)), "EC/BV: already_sorted_true");
    }

    @Test
    void rotated_true() {
        assertTrue(sut.moveOneBall(Arrays.asList(3, 4, 5, 1, 2)), "EC/BV: rotated_true");
    }

    @Test
    void unsortable_false() {
        assertTrue(!sut.moveOneBall(Arrays.asList(3, 5, 4, 1, 2)), "EC/BV: unsortable_false");
    }

    @Test
    void descending_false() {
        assertTrue(!sut.moveOneBall(Arrays.asList(5, 4, 3, 2, 1)), "EC/BV: descending_false");
    }
}
