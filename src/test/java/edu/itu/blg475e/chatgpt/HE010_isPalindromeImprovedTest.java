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
 * Improved tests for HE010_isPalindrome (CHATGPT).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * makePalindrome: EC = {empty, already palindrome, single char, no palindromic suffix, suffix only the last char}. Boundary = 1-char suffix.
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class HE010_isPalindromeImprovedTest {

    private final HE010_isPalindrome sut = new HE010_isPalindrome();

    @Test
    void empty_returns_empty() {
        assertTrue(sut.makePalindrome("").equals(""), "EC/BV: empty_returns_empty");
    }

    @Test
    void single_char_is_palindrome() {
        assertTrue(sut.makePalindrome("x").equals("x"), "EC/BV: single_char_is_palindrome");
    }

    @Test
    void already_palindrome() {
        assertTrue(sut.makePalindrome("aba").equals("aba"), "EC/BV: already_palindrome");
    }

    @Test
    void cat_extends_to_catac() {
        assertTrue(sut.makePalindrome("cat").equals("catac"), "EC/BV: cat_extends_to_catac");
    }

    @Test
    void cata_extends_to_catac() {
        assertTrue(sut.makePalindrome("cata").equals("catac"), "EC/BV: cata_extends_to_catac");
    }

    @Test
    void palindromic_suffix() {
        assertTrue(sut.makePalindrome("aabb").equals("aabbaa"), "EC/BV: palindromic_suffix");
    }
}
