# LLM Interaction Log — HE-023_strlen / test generation

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

Method under test: `HE023_strlen.strlen(String string)`

Problem description:
Return length of given string
    >>> strlen("")
    0
    >>> strlen("abc")
    3

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.gemini
  - Class name: HE023_strlenImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/gemini/HE023_strlenImprovedTest.java`](../../src/test/java/edu/itu/blg475e/gemini/HE023_strlenImprovedTest.java).

EC/BV rationale returned by the model:
> strlen: EC = {empty, single, ascii, unicode surrogate, whitespace-only}. Boundary: "".

Test methods emitted (first 8):

- `empty_is_zero`
- `single_char`
- `typical`
- `whitespace_counts`
- `mixed_case`
- `newline_counts`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


