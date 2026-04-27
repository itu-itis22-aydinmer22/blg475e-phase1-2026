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
 * Improved tests for HE015_stringSequence (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * stringSequence: EC = {n=0 smallest boundary, n=1, typical, large n}. Format: space-separated.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE015_stringSequenceImprovedTest {

    private final HE015_stringSequence sut = new HE015_stringSequence();

    @Test
    void n_zero_just_zero() {
        assertTrue(sut.stringSequence(0).equals("0"), "EC/BV: n_zero_just_zero");
    }

    @Test
    void n_one() {
        assertTrue(sut.stringSequence(1).equals("0 1"), "EC/BV: n_one");
    }

    @Test
    void n_five() {
        assertTrue(sut.stringSequence(5).equals("0 1 2 3 4 5"), "EC/BV: n_five");
    }

    @Test
    void n_has_right_count() {
        assertTrue(sut.stringSequence(10).split(" ").length == 11, "EC/BV: n_has_right_count");
    }
}
