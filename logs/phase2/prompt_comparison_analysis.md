# Phase 2 — Prompt Comparison Analysis
## Unmodified vs Improved Prompt: BookScan Class Generation

---

## Unmodified prompt (sent first)

The unmodified prompt described the BookScan requirements at a high level without
specifying the `tokenize()` helper or punctuation handling. Both agents produced
functionally correct code for clean inputs (no punctuation).

### Issues found in unmodified output

| Issue | ChatGPT | Gemini |
|-------|---------|--------|
| Punctuation not stripped from tokens | ✅ Agent handled it | ✅ Agent handled it |
| Empty text edge case | ✅ Handled (split returns [""], tokenize returns empty) | ✅ Handled |
| `targetLen < 1` validation | ❌ Missing — no exception thrown | ❌ Missing |
| `howManyTimes` integration inside core method | ❌ Not used | ❌ Not used |
| Javadoc on all public methods | ✅ Present | ✅ Present |

### Root cause analysis

The primary gap was that the unmodified prompt did not explicitly state:
1. That `targetLen < 1` must throw `IllegalArgumentException`.
2. That all three HE methods must be called **inside** the core methods (not just declared).

---

## Improved prompt additions

The improved prompt added:
- "Throw `IllegalArgumentException` with message if `targetLen < 1`."
- "The three HumanEval methods must be called inside `countWordsOfLength`,
  `linesContainingWordsOfLength`, and `scanByWordLength` — not just declared.
  Specifically: use `strlen()` in word-length checks, `flipCase()` + `howManyTimes()`
  inside `linesContainingWordsOfLength` as an integration touch-point."

### Result after improved prompt

Both agents produced the final versions present in this repository (BookScanChatGPT.java
and BookScanGemini.java). All 46 integration tests pass after the improved versions.

---

## Prompt engineering technique used

**Constraint injection with integration contracts**: rather than describing what the
class "should" do, the improved prompt specified exact method-call relationships
("method A must call method B internally") and explicit error contracts
("throw X for input Y"). This forced both agents to honour the integration
requirements rather than implementing each method independently.

This is consistent with findings in the literature review (Phase 1) — specifying
method contracts explicitly in the prompt significantly reduces integration-level
defects in LLM-generated code.
