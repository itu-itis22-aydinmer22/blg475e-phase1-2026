/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722, 150200018, 150210089
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
package edu.itu.blg475e.chatgpt;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for HE000_hasCloseElements (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * hasCloseElements: EC = {empty, single, all-equal, no-close, has-close, duplicates}; Boundary = distance exactly at threshold (closed vs open interval).
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE000_hasCloseElementsImprovedTest {

    private final HE000_hasCloseElements sut = new HE000_hasCloseElements();

    @Test
    void empty_list_returns_false() {
        assertTrue(!sut.hasCloseElements(Arrays.asList(), 0.5), "EC/BV: empty_list_returns_false");
    }

    @Test
    void single_element_no_pair() {
        assertTrue(!sut.hasCloseElements(Arrays.asList(1.0), 0.5), "EC/BV: single_element_no_pair");
    }

    @Test
    void duplicates_are_close() {
        assertTrue(sut.hasCloseElements(Arrays.asList(2.0, 2.0), 0.1), "EC/BV: duplicates_are_close");
    }

    @Test
    void exact_threshold_boundary_open() {
        assertTrue(!sut.hasCloseElements(Arrays.asList(1.0, 1.5), 0.5), "EC/BV: exact_threshold_boundary_open");
    }

    @Test
    void just_below_threshold() {
        assertTrue(sut.hasCloseElements(Arrays.asList(1.0, 1.4999), 0.5), "EC/BV: just_below_threshold");
    }

    @Test
    void spread_out_no_close() {
        assertTrue(!sut.hasCloseElements(Arrays.asList(1.0, 5.0, 10.0), 0.5), "EC/BV: spread_out_no_close");
    }

    @Test
    void all_equal_close() {
        assertTrue(sut.hasCloseElements(Arrays.asList(3.0, 3.0, 3.0), 0.001), "EC/BV: all_equal_close");
    }

    @Test
    void negative_threshold_trivially_false() {
        assertTrue(!sut.hasCloseElements(Arrays.asList(1.0, 1.1), -0.1), "EC/BV: negative_threshold_trivially_false");
    }
}
