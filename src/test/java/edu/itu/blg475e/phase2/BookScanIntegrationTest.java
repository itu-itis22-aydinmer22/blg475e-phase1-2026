/* @Authors
 * Student Names: Mert Aydın, Oğuz Eren Kacar, Mehmet Enes Tekgöz
 * Student IDs:   150220722,  150200018,        150210089
 */
package edu.itu.blg475e.phase2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for {@link BookScanChatGPT} and {@link BookScanGemini}.
 *
 * <p>Test strategy:
 * <ol>
 *   <li>Unit tests for each HumanEval primitive (HE-018, HE-023, HE-027) to
 *       isolate defects before integration.</li>
 *   <li>Integration tests (IT-01..IT-05) verifying that the three primitives
 *       cooperate correctly through the BookScan API.</li>
 *   <li>Cross-agent comparison tests that surface divergences between the
 *       ChatGPT and Gemini implementations.</li>
 * </ol>
 */
class BookScanIntegrationTest {

    private BookScanChatGPT chatGpt;
    private BookScanGemini  gemini;

    @BeforeEach
    void setUp() {
        chatGpt = new BookScanChatGPT();
        gemini  = new BookScanGemini();
    }

    // ===================================================================
    //  UNIT LEVEL — HE-023 strlen
    // ===================================================================
    @Nested
    @DisplayName("HE-023 strlen — unit")
    class StrlenUnit {

        @Test @DisplayName("empty string → 0")
        void empty_chatgpt()  { assertEquals(0, chatGpt.strlen("")); }

        @Test @DisplayName("empty string → 0 (Gemini)")
        void empty_gemini()   { assertEquals(0, gemini.strlen(""));  }

        @Test @DisplayName("single char → 1")
        void single()         { assertEquals(1, chatGpt.strlen("x")); }

        @Test @DisplayName("multi-char ASCII")
        void multi()          { assertEquals(6, chatGpt.strlen("foobar")); }

        @Test @DisplayName("string with spaces counts spaces")
        void withSpaces()     { assertEquals(5, chatGpt.strlen("a b c")); }

        @Test @DisplayName("ChatGPT and Gemini agree on strlen")
        void bothAgree() {
            String[] samples = {"", "hello", "Hello World", "12345"};
            for (String s : samples) {
                assertEquals(chatGpt.strlen(s), gemini.strlen(s),
                        "strlen mismatch for: " + s);
            }
        }
    }

    // ===================================================================
    //  UNIT LEVEL — HE-018 howManyTimes
    // ===================================================================
    @Nested
    @DisplayName("HE-018 howManyTimes — unit")
    class HowManyTimesUnit {

        @Test @DisplayName("no occurrence → 0")
        void noOccurrence() {
            assertEquals(0, chatGpt.howManyTimes("hello world", "xyz"));
        }

        @Test @DisplayName("single occurrence")
        void singleOccurrence() {
            assertEquals(1, chatGpt.howManyTimes("hello world", "world"));
        }

        @Test @DisplayName("multiple non-overlapping")
        void multipleNonOverlapping() {
            assertEquals(3, chatGpt.howManyTimes("aaa", "a"));
        }

        @Test @DisplayName("overlapping occurrences — aaaa/aaa = 2")
        void overlapping() {
            assertEquals(2, chatGpt.howManyTimes("aaaa", "aaa"));
        }

        @Test @DisplayName("empty haystack → 0")
        void emptyHaystack() {
            assertEquals(0, chatGpt.howManyTimes("", "abc"));
        }

        // Empty substring behavior test: both agents return string.length() + 1
        @Test @DisplayName("IT-HE018-EmptySubstring: ChatGPT returns length+1 for empty needle")
        void emptNeedle_chatgpt() {
            assertEquals(4, chatGpt.howManyTimes("abc", ""),
                    "ChatGPT: howManyTimes with empty substring returns length+1");
        }

        @Test @DisplayName("IT-HE018-EmptySubstring: Gemini returns length+1 for empty needle")
        void emptyNeedle_gemini() {
            // Gemini returns string.length() + 1 for an empty substring
            assertEquals(4, gemini.howManyTimes("abc", ""),
                    "Gemini: howManyTimes with empty substring returns length+1");
        }

        @Test @DisplayName("non-empty needle: ChatGPT and Gemini agree")
        void nonEmptyNeedle_bothAgree() {
            assertEquals(
                chatGpt.howManyTimes("banana", "an"),
                gemini.howManyTimes("banana", "an")
            );
        }

        @Test @DisplayName("phase2_Coverage_substringLongerThanString")
        void phase2_Coverage_substringLongerThanString() {
            assertEquals(0, gemini.howManyTimes("ab", "abc"));
        }
    }

    // ===================================================================
    //  UNIT LEVEL — HE-027 flipCase
    // ===================================================================
    @Nested
    @DisplayName("HE-027 flipCase — unit")
    class FlipCaseUnit {

        @Test @DisplayName("empty string → empty")
        void empty() { assertEquals("", chatGpt.flipCase("")); }

        @Test @DisplayName("all lowercase → all uppercase")
        void allLower() { assertEquals("HELLO", chatGpt.flipCase("hello")); }

        @Test @DisplayName("all uppercase → all lowercase")
        void allUpper() { assertEquals("world", chatGpt.flipCase("WORLD")); }

        @Test @DisplayName("mixed case flipped correctly")
        void mixed() { assertEquals("hELLO wORLD", chatGpt.flipCase("Hello World")); }

        @Test @DisplayName("digits and punctuation unchanged")
        void digits() { assertEquals("hELLO 123!", chatGpt.flipCase("Hello 123!")); }

        @Test @DisplayName("flipCase is its own inverse")
        void selfInverse() {
            String original = "Hello World 42!";
            assertEquals(original, chatGpt.flipCase(chatGpt.flipCase(original)));
        }

        @Test @DisplayName("ChatGPT and Gemini agree on flipCase")
        void bothAgree() {
            String[] samples = {"", "hello", "WORLD", "Hello World", "abc123"};
            for (String s : samples) {
                assertEquals(chatGpt.flipCase(s), gemini.flipCase(s),
                        "flipCase mismatch for: " + s);
            }
        }

        @Test @DisplayName("strlen(flipCase(s)) == strlen(s) — length invariant")
        void lengthInvariant() {
            String s = "Hello World";
            assertEquals(chatGpt.strlen(s), chatGpt.strlen(chatGpt.flipCase(s)));
        }
    }

    // ===================================================================
    //  IT-01: strlen integrated inside countWordsOfLength
    // ===================================================================
    @Nested
    @DisplayName("IT-01 — countWordsOfLength uses strlen")
    class IT01_CountWordsOfLength {

        @Test @DisplayName("single line, 3-letter words: the/cat/sat = 3 but also 'on'=2, so the/cat/sat/mat = 4 three-letter words")
        void singleLine() {
            // "the"(3) "cat"(3) "sat"(3) "on"(2) "the"(3) "mat"(3) = 5 three-letter words
            assertEquals(5, chatGpt.countWordsOfLength("the cat sat on the mat", 3));
        }

        @Test @DisplayName("multi-line text — same result for both agents")
        void multiLine_bothAgree() {
            String text = "one two three\nfour five six\nseven";
            assertEquals(
                chatGpt.countWordsOfLength(text, 3),
                gemini.countWordsOfLength(text, 3)
            );
        }

        @Test @DisplayName("no matching words → 0")
        void noMatch() {
            assertEquals(0, chatGpt.countWordsOfLength("hello world", 1));
        }

        @Test @DisplayName("empty text → 0")
        void emptyText() {
            assertEquals(0, chatGpt.countWordsOfLength("", 4));
        }

        @Test @DisplayName("targetLen < 1 → IllegalArgumentException")
        void invalidLen_chatgpt() {
            assertThrows(IllegalArgumentException.class,
                    () -> chatGpt.countWordsOfLength("hello", 0));
        }

        @Test @DisplayName("targetLen < 1 → IllegalArgumentException (Gemini)")
        void invalidLen_gemini() {
            assertThrows(IllegalArgumentException.class,
                    () -> gemini.countWordsOfLength("hello", 0));
        }

        @Test @DisplayName("punctuation stripped before counting")
        void punctuationStripped() {
            // "word," → "word" (4 chars)
            assertEquals(1, chatGpt.countWordsOfLength("hello, word!", 4));
        }

        @Test @DisplayName("targetLen = 1 matches single-char tokens")
        void singleCharWords() {
            assertEquals(1, chatGpt.countWordsOfLength("I am here", 1));
        }
    }

    // ===================================================================
    //  IT-02/IT-03: linesContainingWordsOfLength uses strlen + howManyTimes + flipCase
    // ===================================================================
    @Nested
    @DisplayName("IT-02/03 — linesContainingWordsOfLength integrates all three HE methods")
    class IT02_03_LinesContaining {

        @Test @DisplayName("correct 1-based line numbers for 3-letter words")
        void correctLineNumbers() {
            String text = "the quick brown fox\njumps over the lazy dog\none two three";
            List<Integer> lines = chatGpt.linesContainingWordsOfLength(text, 3);
            assertTrue(lines.contains(1), "Line 1 should contain 'the','fox'");
            assertTrue(lines.contains(2), "Line 2 should contain 'the','dog'");
            assertTrue(lines.contains(3), "Line 3 should contain 'one','two'");
        }

        @Test @DisplayName("no match → empty list")
        void noMatch() {
            assertTrue(chatGpt.linesContainingWordsOfLength("hello world", 1).isEmpty());
        }

        @Test @DisplayName("single-line text → [1]")
        void singleLine() {
            assertEquals(List.of(1),
                    chatGpt.linesContainingWordsOfLength("cat", 3));
        }

        @Test @DisplayName("each matching line appears exactly once")
        void noDuplicateLines() {
            List<Integer> lines = chatGpt.linesContainingWordsOfLength("the cat sat", 3);
            long distinct = lines.stream().distinct().count();
            assertEquals(1, distinct, "Line 1 should appear only once");
        }

        @Test @DisplayName("targetLen < 1 → IllegalArgumentException")
        void invalidLen() {
            assertThrows(IllegalArgumentException.class,
                    () -> chatGpt.linesContainingWordsOfLength("text", 0));
        }

        @Test @DisplayName("phase2_Coverage_invalidLenGemini")
        void phase2_Coverage_invalidLenGemini() {
            assertThrows(IllegalArgumentException.class,
                    () -> gemini.linesContainingWordsOfLength("text", 0));
        }

        @Test @DisplayName("ChatGPT and Gemini return same lines for non-empty words")
        void bothAgree_normalInput() {
            String text = "hello world\nfoo bar baz\none two three";
            assertEquals(
                chatGpt.linesContainingWordsOfLength(text, 3),
                gemini.linesContainingWordsOfLength(text, 3)
            );
        }

        @Test @DisplayName("multi-line: line with no match is absent from result")
        void absentLine() {
            String text = "hi\nhello world";   // line 1: 'hi'(2); line 2: 'hello'(5),'world'(5)
            List<Integer> lines = chatGpt.linesContainingWordsOfLength(text, 5);
            assertFalse(lines.contains(1), "Line 1 has no 5-letter word");
            assertTrue(lines.contains(2),  "Line 2 has 5-letter words");
        }
    }

    // ===================================================================
    //  IT-04: scanByWordLength full pipeline
    // ===================================================================
    @Nested
    @DisplayName("IT-04 — scanByWordLength full pipeline")
    class IT04_ScanByWordLength {

        @Test @DisplayName("map contains expected word-length keys")
        void keysPresent() {
            Map<Integer, List<Integer>> map = chatGpt.scanByWordLength("I am here\nnow");
            assertTrue(map.containsKey(1), "Key 1 (I)");
            assertTrue(map.containsKey(2), "Key 2 (am)");
            assertTrue(map.containsKey(4), "Key 4 (here)");
            assertTrue(map.containsKey(3), "Key 3 (now)");
        }

        @Test @DisplayName("line numbers inside map are correct")
        void lineNumbers() {
            Map<Integer, List<Integer>> map = chatGpt.scanByWordLength("cat\ndog");
            List<Integer> threes = map.get(3);
            assertNotNull(threes);
            assertTrue(threes.contains(1), "cat is on line 1");
            assertTrue(threes.contains(2), "dog is on line 2");
        }

        @Test @DisplayName("empty text → empty map")
        void emptyText() {
            assertTrue(chatGpt.scanByWordLength("").isEmpty());
            assertTrue(gemini.scanByWordLength("").isEmpty());
        }

        @Test @DisplayName("ChatGPT and Gemini produce same map for normal text")
        void bothAgree() {
            String text = "hello world\nfoo bar";
            assertEquals(
                chatGpt.scanByWordLength(text),
                gemini.scanByWordLength(text)
            );
        }

        @Test @DisplayName("single word maps to key=word length, value=[1]")
        void singleWord() {
            Map<Integer, List<Integer>> map = chatGpt.scanByWordLength("java");
            assertEquals(List.of(1), map.get(4));
        }
    }

    // ===================================================================
    //  IT-05: End-to-end realistic passage
    // ===================================================================
    @Nested
    @DisplayName("IT-05 — End-to-end realistic passage")
    class IT05_EndToEnd {

        private static final String PASSAGE =
            "To be or not to be that is the question\n" +
            "Whether tis nobler in the mind to suffer\n" +
            "The slings and arrows of outrageous fortune\n" +
            "Or to take arms against a sea of troubles";

        @Test @DisplayName("at least one 2-letter word exists in passage")
        void count2LetterWords() {
            assertTrue(chatGpt.countWordsOfLength(PASSAGE, 2) > 0);
        }

        @Test @DisplayName("line 1 contains 3-letter words (not, the)")
        void linesWith3LetterWords() {
            assertTrue(chatGpt.linesContainingWordsOfLength(PASSAGE, 3).contains(1));
        }

        @Test @DisplayName("scan covers all four lines")
        void scanCoversAllLines() {
            Map<Integer, List<Integer>> map = chatGpt.scanByWordLength(PASSAGE);
            for (int line = 1; line <= 4; line++) {
                final int ln = line;
                assertTrue(
                    map.values().stream().anyMatch(list -> list.contains(ln)),
                    "Line " + line + " missing from scan"
                );
            }
        }

        @Test @DisplayName("strlen invariant: strlen(flipCase(w)) == strlen(w)")
        void flipCaseLengthInvariant() {
            for (String word : List.of("To", "be", "question", "outrageous")) {
                assertEquals(
                    chatGpt.strlen(word),
                    chatGpt.strlen(chatGpt.flipCase(word)),
                    "Length changed after flipCase on: " + word
                );
            }
        }

        @Test @DisplayName("ChatGPT and Gemini produce identical scan of passage")
        void bothAgreeOnPassage() {
            assertEquals(
                chatGpt.scanByWordLength(PASSAGE),
                gemini.scanByWordLength(PASSAGE)
            );
        }

        @Test @DisplayName("countWordsOfLength agrees between agents for all target lengths 1-10")
        void countAgreesForAllLengths() {
            for (int len = 1; len <= 10; len++) {
                assertEquals(
                    chatGpt.countWordsOfLength(PASSAGE, len),
                    gemini.countWordsOfLength(PASSAGE, len),
                    "Count mismatch at targetLen=" + len
                );
            }
        }
    }
}
