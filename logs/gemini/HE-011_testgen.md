# LLM Interaction Log — HE-011_stringXor / test generation

- **LLM:** Google Gemini 2.5 Pro
- **Approach:** Semi-agentic (manual prompt → manual paste → no automated feedback).
- **Date:** 2026-04-23

## Prompt sent

```
You are a senior Java test engineer. For the Java method below, produce a
JUnit 5/6 test class that improves branch coverage and exercises equivalence
class partitions as well as boundary values. Focus on:
  1. empty / minimum-size inputs
  2. single-element inputs
  3. typical valid inputs
  4. boundary values (off-by-one)
  5. invalid or degenerate edge cases if the signature permits them

Method under test: `HE011_stringXor.stringXor(String a, String b)`

Problem description:
Input are two strings a and b consisting only of 1s and 0s.
    Perform binary XOR on these inputs and return result also as a string.
    >>> stringXor("010", "110")
    "100"

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.gemini
  - Class name: HE011_stringXorImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/gemini/HE011_stringXorImprovedTest.java`](../../src/test/java/edu/itu/blg475e/gemini/HE011_stringXorImprovedTest.java).

EC/BV rationale returned by the model:
> stringXor: EC = {both empty, equal length 1, equal length N, all-0, all-1, alternating}.

Test methods emitted (first 8):

- `both_empty`
- `single_zero_zero`
- `single_zero_one`
- `single_one_one`
- `all_match_returns_zeros`
- `alternating`
- `mixed_case`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


