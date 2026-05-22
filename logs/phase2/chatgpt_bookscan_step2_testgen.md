# Phase 2 – LLM Interaction Log: Integration Test Generation
## Agent: ChatGPT (GPT-4o) | Step 2 — Integration Test Generation
## Date: 2026-05-22

---

### Prompt sent

```
I have a Java class called BookScanChatGPT in package edu.itu.blg475e.phase2.
It integrates three HumanEval methods (HE-018 howManyTimes, HE-023 strlen, HE-027 flipCase)
and exposes three core methods:
  - int countWordsOfLength(String text, int targetLen)
  - List<Integer> linesContainingWordsOfLength(String text, int targetLen)
  - Map<Integer, List<Integer>> scanByWordLength(String text)

Generate JUnit 5 integration tests for this class. The tests should:
1. First test each of the three HumanEval primitives in isolation.
2. Then test integration scenarios (IT-01..IT-05) verifying that the primitives
   cooperate correctly inside the core BookScan methods.
3. Include equivalence class and boundary value tests.
4. Include a cross-agent test that compares BookScanChatGPT output vs BookScanGemini output.
Cover: empty inputs, single-line, multi-line, punctuation stripping, 1-based line numbers,
duplicate-line suppression, and illegal argument validation.
```

### Agent response (full output)

The agent generated a complete `BookScanIntegrationTest.java` with nested `@Nested` classes
per test category. Key scenarios produced:
- `StrlenUnit`, `HowManyTimesUnit`, `FlipCaseUnit` — primitive isolation
- `IT01_CountWordsOfLength` — verifies `strlen` used inside `countWordsOfLength`
- `IT02_03_LinesContaining` — verifies all three HE methods exercised inside `linesContainingWordsOfLength`
- `IT04_ScanByWordLength` — full pipeline scan
- `IT05_EndToEnd` — realistic Shakespeare passage

### How output was used / modifications made

- Added cross-agent tests comparing `BookScanChatGPT` vs `BookScanGemini` for every method.
- Added `IT-HE018-EmptySubstring` divergence test to explicitly document the Gemini bug.
- Added `singleLine()` assertion correction: "the cat sat on the mat" has 5 three-letter
  words (the, cat, sat, the, mat), not 2 — test was adjusted accordingly.
