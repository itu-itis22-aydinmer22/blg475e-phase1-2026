# Phase 2 — Integration Test Results

## Run date: 2026-05-22
## Command: `./gradlew clean test --tests "edu.itu.blg475e.phase2.*"`

---

## Summary

| Category                        | Tests | Pass | Fail | Notes |
|---------------------------------|-------|------|------|-------|
| HE-023 strlen (unit)            | 6     | 6    | 0    | Both agents identical |
| HE-018 howManyTimes (unit)      | 7     | 7    | 0    | Divergence test explicitly asserts Gemini difference |
| HE-027 flipCase (unit)          | 7     | 7    | 0    | Both agents identical |
| IT-01 countWordsOfLength        | 8     | 8    | 0    | Punctuation stripping works |
| IT-02/03 linesContainingWords   | 7     | 7    | 0    | 1-based numbering correct |
| IT-04 scanByWordLength          | 5     | 5    | 0    | Both agents agree |
| IT-05 End-to-end passage        | 6     | 6    | 0    | All 4 lines covered |
| **Total**                       | **46**| **46**| **0** | |

---

## Cross-agent divergence summary

| Method                          | ChatGPT result | Gemini result | Status    |
|---------------------------------|----------------|---------------|-----------|
| `howManyTimes("abc", "")`       | 0              | 4             | ⚠️ Documented divergence (Gemini Phase 1 bug) |
| `howManyTimes("banana", "an")`  | 2              | 2             | ✅ Agree |
| `strlen` (all inputs)           | same           | same          | ✅ Agree |
| `flipCase` (all inputs)         | same           | same          | ✅ Agree |
| `countWordsOfLength` (all)      | same           | same          | ✅ Agree |
| `linesContainingWordsOfLength`  | same           | same          | ✅ Agree |
| `scanByWordLength`              | same           | same          | ✅ Agree |

---

## Notes

The only divergence is in `BookScanGemini.howManyTimes` with an empty needle,
which was already present in the Phase 1 Gemini HE-018 implementation
(`if (substring.isEmpty()) return string.length() + 1`).
This does NOT affect the BookScan core methods because `tokenize()` never
produces empty strings, so `howManyTimes` is never called with an empty needle
during normal BookScan operation.
