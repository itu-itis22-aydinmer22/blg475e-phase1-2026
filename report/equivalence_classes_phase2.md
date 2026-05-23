# Phase 2 Equivalence Class and Boundary Value Analysis

## 1. Scope
This document outlines the Equivalence Class Partitioning (ECP) and Boundary Value Analysis (BVA) for the `BookScan` classes (`BookScanChatGPT` and `BookScanGemini`) integrated with three HumanEval-X methods (HE-018, HE-023, HE-027). The tests ensure correct behavior across core string processing components and the integrated word scanning pipeline, targeting text structures, tokenization, word length matching, and line number mappings.

## 2. Equivalence Class Analysis

| Variable / Input | Valid Equivalence Classes | Invalid Equivalence Classes |
| --- | --- | --- |
| `text` (Input Document) | EC_T1: Empty string | EC_T4: Null text (Implicitly untested/unsupported) |
| | EC_T2: Single-line text | |
| | EC_T3: Multi-line text | |
| `text` (Tokenization) | EC_TOK1: Alphanumeric words | EC_TOK3: Words with punctuation (must be stripped) |
| | EC_TOK2: Repeated words on same line | |
| `targetLen` (Word Length) | EC_L1: `targetLen = 1` | EC_L3: `targetLen < 1` |
| | EC_L2: `targetLen > 1` | |
| Search Results | EC_RES1: No matching words | |
| | EC_RES2: Matching words present | |
| `HE-018` Substring | EC_SUB1: Normal occurrence | EC_SUB4: Substring longer than text |
| | EC_SUB2: Overlapping occurrence | |
| | EC_SUB3: Empty substring | |
| `HE-023` String Length | EC_LEN1: Empty string | |
| | EC_LEN2: Normal string (alphanumeric/spaces) | |
| `HE-027` Flip Case | EC_CASE1: All lowercase | |
| | EC_CASE2: All uppercase | |
| | EC_CASE3: Mixed case | |
| | EC_CASE4: Digits/Punctuation (unchanged) | |

## 3. Boundary Value Analysis

| Input Parameter | Boundary / Edge Case | Expected Behavior / Observation |
| --- | --- | --- |
| `targetLen` | 0 | Throws `IllegalArgumentException` |
| `targetLen` | 1 | Matches single-character words |
| `text` (Lines) | 0 lines (Empty string) | Returns 0 counts, empty lists, empty maps |
| `text` (Lines) | 1 line | Correctly processes words without `\n` |
| `HE-018` (Substring length) | Substring length > String length | Returns `0` (Tested in `phase2_Coverage_substringLongerThanString`) |
| `HE-018` (Empty Substring) | Length 0 needle | **Both** `BookScanChatGPT` and `BookScanGemini` consistently return `string.length() + 1`. This observation was corrected during integration testing. |

## 4. Mapping between EC/BV Classes and BookScanIntegrationTest Methods

| Method in `BookScanIntegrationTest` | Covered EC / BV Classes | Description |
| --- | --- | --- |
| `HE-023: empty() / single() / multi() / withSpaces()` | EC_LEN1, EC_LEN2 | Tests `strlen` on various lengths, including spaces. |
| `HE-018: noOccurrence() / singleOccurrence() / overlapping() / emptyHaystack()` | EC_SUB1, EC_SUB2 | Tests basic substring operations. |
| `HE-018: emptNeedle_chatgpt() / emptyNeedle_gemini()` | EC_SUB3, HE-018 BVA | Tests empty substring boundary (returns `len+1` for both). |
| `HE-027: empty() / allLower() / allUpper() / mixed() / digits()` | EC_CASE1, EC_CASE2, EC_CASE3, EC_CASE4 | Tests all case permutations and non-letter resilience. |
| `IT-01: singleLine() / multiLine_bothAgree() / emptyText() / singleCharWords()` | EC_T1, EC_T2, EC_T3, EC_L1, EC_L2 | Tests text line structures and `targetLen=1`. |
| `IT-01: punctuationStripped()` | EC_TOK1, EC_TOK3 | Validates punctuation tokenization. |
| `IT-01/02: invalidLen() / invalidLen_gemini()` | EC_L3, `targetLen` BVA | Validates `IllegalArgumentException` on `targetLen < 1`. |
| `IT-02: correctLineNumbers() / noDuplicateLines()` | EC_RES2, EC_TOK2 | Ensures line correct extraction and deduplication of hits. |

## 5. Coverage-Driven Additional Tests (JaCoCo)

After initial integration testing, JaCoCo identified minor missed branches in the Gemini generation. The following tests were added to reach 100% branch and instruction coverage:
- **`phase2_Coverage_substringLongerThanString`**: Added to `HowManyTimesUnit`. Covers the boundary condition in `BookScanGemini.howManyTimes` where `if (substring.length() > string.length()) return 0;`.
- **`phase2_Coverage_invalidLenGemini`**: Added to `IT02_03_LinesContaining`. Covers the validation branch `if (targetLen < 1)` specifically for `BookScanGemini.linesContainingWordsOfLength` method, since only ChatGPT had been explicitly verified for this branch in that nested suite.

## 6. Remaining Limitations
- **Null Safety**: Null inputs for strings and text blocks are not explicitly handled and may result in standard `NullPointerException`s, which is consistent with the initial requirements.
- **Strict Punctuation Constraints**: While punctuation is stripped from edges of words correctly, heavy internal punctuation tokenization may depend on the specifics of the regex `[^a-zA-Z0-9]+` edge stripping vs whitespace splitting.
- **Divergence Considerations**: While both agents now agree on returning `string.length() + 1` for empty strings in `HE-018`, this diverges from standard expected logic (usually `0`). It has been explicitly codified into tests as a behavioral characteristic of the LLM-generated code.
