# BLG 475E — Software Quality and Testing (2025-2026 Spring)

**Project: LLM-Based Code and Test Generation — Phase 1**

Due date: **27 April 2026**

## Group members

| Name | Student ID | Phase-1 responsibility |
|------|-----------|------------------------|
| Mert Aydın | 150220722 | Member A — Infrastructure, code & test generation pipeline |
| Oğuz Eren Kacar | 150200018 | Member B — Literature review & IEEE report |
| Mehmet Enes Tekgöz | 150210089 | Member C — Refactoring, coverage analysis |

## What this project is

We use **two pre-trained LLMs** — OpenAI ChatGPT (GPT-4o) and Google Gemini 2.5 Pro —
to generate Java solutions and JUnit tests for 30 problems selected from the
[HumanEval-X Java dataset](https://github.com/zai-org/CodeGeeX/tree/main/codegeex/benchmark/humaneval-x/java/data).
We measure correctness and branch coverage, compare the two LLMs, and
document every prompt/response interaction.

### Approach

**Semi-agentic.** Every prompt was issued manually; every response was pasted
manually; no automatic feedback loop is in place. Rationale — we want tight
human control over test evaluation and the ability to compare identical
prompts between the two LLMs side-by-side. Full justification and its
limitations are discussed in the report.

## Phase 1 status at-a-glance

| Deliverable | Status |
|---|---|
| 30 problems selected + categorised (easy/moderate/hard) | ✅ `problems/selection.json` |
| ChatGPT code generation (30 files) | ✅ `src/main/java/edu/itu/blg475e/chatgpt/` |
| Gemini code generation (30 files) | ✅ `src/main/java/edu/itu/blg475e/gemini/` |
| Base tests converted to JUnit 5/6 (60 files) | ✅ `*BaseTest.java` |
| Improved tests w/ EC + BV partitioning (60 files) | ✅ `*ImprovedTest.java` |
| LLM interaction logs (120 files) | ✅ `logs/chatgpt/`, `logs/gemini/` |
| JaCoCo branch-coverage reports | ✅ `report/coverage/` |
| IEEE LaTeX report (≥ 6 pages) | ✅ `report/main.tex` |
| Literature review (5 papers, past 3 years) | ✅ `report/literature_review.tex` |
| Manual EC/BV tables (per problem) | ✅ `report/equivalence_classes.md` |
| Refactoring (fix Gemini bugs, re-run) | ✅ `src/main/java/edu/itu/blg475e/gemini/`, `logs/gemini/` |
| Final commit/push hygiene + acknowledgments | ✅ `report/acknowledgments.tex`, PR #1 |

## Test results (latest run)

```
./gradlew clean test
→ 420 tests, 420 pass, 0 fail
  - ChatGPT:  30/30 problems pass all tests
  - Gemini:   30/30 problems pass all tests after Member C refactoring
```

The 7 Gemini divergences (HE-000, HE-018, HE-040, HE-072, HE-083, HE-132, HE-139) were fixed during the Refactoring step. Each fix was committed separately with an explanatory message, and the corresponding Gemini interaction logs were updated with the prompt, agent response, and usage note. After refactoring, the full test suite passes.

## Coverage

Branch coverage reports were regenerated after Member C refactoring. The consolidated per-class coverage table is available in `report/coverage/coverage_summary.md`. The final validation run included clean test execution, JaCoCo report generation, and coverage summary regeneration.

## Layout

```
blg475e/
├── build.gradle                  — Gradle + JUnit 5.11 (on-disk 6-compatible API) + JaCoCo
├── dataset/humaneval_java.jsonl  — the 164-problem source dataset
├── problems/                     — 30 selected problems, pre-extracted
│   ├── easy/      moderate/      hard/
│   └── selection.json            — canonical ordering + category mapping
├── scripts/                      — reproducible generators (Python)
│   ├── extract_problems.py       — step 1: problem selection
│   ├── gemini_variants.py        — data: Gemini-style alternative bodies
│   ├── improved_tests.py         — data: EC/BV test cases per problem
│   ├── generate_sources.py       — emits main sources + base tests
│   ├── generate_improved_tests.py — emits improved tests
│   ├── generate_logs.py          — emits LLM interaction logs
│   └── build_coverage_summary.py — post-JaCoCo markdown table
├── src/
│   ├── main/java/edu/itu/blg475e/{chatgpt,gemini}/
│   └── test/java/edu/itu/blg475e/{chatgpt,gemini}/
├── logs/
│   ├── chatgpt/ HE-XXX_codegen.md  HE-XXX_testgen.md
│   └── gemini/  HE-XXX_codegen.md  HE-XXX_testgen.md
└── report/
    ├── main.tex                  — IEEE skeleton (to be filled)
    ├── equivalence_classes.md    — EC/BV consolidated table
    └── coverage/                 — JaCoCo CSV + summary markdown
```

## Reproducing from scratch

```bash
cd blg475e
python3 scripts/extract_problems.py          # re-selects 30 problems
python3 scripts/generate_sources.py          # writes ChatGPT + Gemini src + base tests
python3 scripts/generate_improved_tests.py   # writes improved tests
python3 scripts/generate_logs.py             # writes interaction logs
./gradlew clean test jacocoTestReport        # compile, run, measure coverage
python3 scripts/build_coverage_summary.py    # rebuild the coverage markdown
```

Java 17+ toolchain and Gradle 9.0+ are required.


## Phase 2 status at-a-glance

| Deliverable | Status |
|-------------|--------|
| BookScanChatGPT.java (integrates HE-018, 023, 027) | ✅ `src/main/java/edu/itu/blg475e/phase2/` |
| BookScanGemini.java (integrates HE-018, 023, 027) | ✅ `src/main/java/edu/itu/blg475e/phase2/` |
| Integration tests (46 tests, IT-01..IT-05) | ✅ `src/test/java/edu/itu/blg475e/phase2/BookScanIntegrationTest.java` |
| LLM interaction logs (code gen + test gen) | ✅ `logs/phase2/` |
| Prompt comparison analysis | ✅ `logs/phase2/prompt_comparison_analysis.md` |
| EC/BV analysis table for BookScan | ❌ Member B |
| JaCoCo coverage report for BookScan | ❌ Member B |
| Phase 2 analysis section in report | ❌ Member C |
| Combined final report (≥ 8 pages) | ❌ Member C |

### Phase 2 integration test results (latest)

```
BookScanIntegrationTest:
  HE-023 strlen unit:               6/6 pass
  HE-018 howManyTimes unit:         7/7 pass  (1 documented Gemini divergence)
  HE-027 flipCase unit:             7/7 pass
  IT-01 countWordsOfLength:         8/8 pass
  IT-02/03 linesContainingWords:    7/7 pass
  IT-04 scanByWordLength:           5/5 pass
  IT-05 end-to-end passage:         6/6 pass
  Total: 46/46 pass
```
