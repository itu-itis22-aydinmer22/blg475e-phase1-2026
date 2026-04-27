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
 * Improved tests for HE017_parseMusic (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * parseMusic: EC = {empty string, all whole notes, all half, all quarter, mixed}. Boundary: empty.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE017_parseMusicImprovedTest {

    private final HE017_parseMusic sut = new HE017_parseMusic();

    @Test
    void empty_returns_empty_list() {
        assertTrue(sut.parseMusic("").isEmpty(), "EC/BV: empty_returns_empty_list");
    }

    @Test
    void single_whole_note() {
        assertTrue(sut.parseMusic("o").equals(Arrays.asList(4)), "EC/BV: single_whole_note");
    }

    @Test
    void single_half_note() {
        assertTrue(sut.parseMusic("o|").equals(Arrays.asList(2)), "EC/BV: single_half_note");
    }

    @Test
    void single_quarter_note() {
        assertTrue(sut.parseMusic(".|").equals(Arrays.asList(1)), "EC/BV: single_quarter_note");
    }

    @Test
    void mixed_pattern() {
        assertTrue(sut.parseMusic("o o| .|").equals(Arrays.asList(4, 2, 1)), "EC/BV: mixed_pattern");
    }

    @Test
    void all_quarter() {
        assertTrue(sut.parseMusic(".| .| .|").equals(Arrays.asList(1, 1, 1)), "EC/BV: all_quarter");
    }
}
