# Phase 2 Coverage Summary

## 1. Command Used
To generate the code coverage report for Phase 2 tests, the following Gradle command was executed:
```bash
./gradlew clean test jacocoTestReport
```

## 2. Final JaCoCo CSV Rows
After the complete test suite execution, the `jacocoTestReport.csv` file produced the following results for the `BookScan` classes:

```csv
blg475e-project-2026,edu.itu.blg475e.phase2,BookScanChatGPT,0,285,0,34,0,53,0,26,0,9
blg475e-project-2026,edu.itu.blg475e.phase2,BookScanGemini,0,309,0,40,0,55,0,29,0,9
```

## 3. Coverage Percentages
Based on the JaCoCo report CSV output, the final test coverage metrics for the integrated AI-generated classes are:
- **BookScanChatGPT**: 100% instruction coverage (0 missed), 100% branch coverage (0 missed).
- **BookScanGemini**: 100% instruction coverage (0 missed), 100% branch coverage (0 missed).

## 4. Before/After Coverage Note
Before adding the two coverage-driven integration tests, the JaCoCo test report revealed that `BookScanGemini` had **8 missed instructions** and **2 missed branches**. 

After adding the targeted test cases (`phase2_Coverage_substringLongerThanString` and `phase2_Coverage_invalidLenGemini`) into `BookScanIntegrationTest.java`, the missed instructions and missed branches for `BookScanGemini` successfully became **0**.

## 5. Explanation of Added Tests
To achieve 100% coverage, two specific boundary cases were identified directly from the JaCoCo HTML report and mitigated via new JUnit 5 tests:

1. **`phase2_Coverage_substringLongerThanString`**:
   - **Method Tested**: `BookScanGemini.howManyTimes`
   - **Branch Covered**: `if (substring.length() > string.length()) return 0;` (Line 61)
   - **Explanation**: This test specifically passes a `substring` parameter ("abc") that is longer than the search `string` ("ab"). Prior tests only evaluated scenarios where the substring was equal to or smaller than the primary string.

2. **`phase2_Coverage_invalidLenGemini`**:
   - **Method Tested**: `BookScanGemini.linesContainingWordsOfLength`
   - **Branch Covered**: `if (targetLen < 1)` (Line 138)
   - **Explanation**: While the invalid length boundary (`targetLen < 1`) was previously tested for ChatGPT's implementation of this method and for Gemini's `countWordsOfLength`, the `IllegalArgumentException` path in `BookScanGemini.linesContainingWordsOfLength` remained unexercised. This test explicitly asserts the exception occurs, fully resolving the final missed branch.
