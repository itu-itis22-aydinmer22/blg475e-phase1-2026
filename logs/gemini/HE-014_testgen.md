# LLM Interaction Log — HE-014_allPrefixes / test generation

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

Method under test: `HE014_allPrefixes.allPrefixes(String string)`

Problem description:
Return list of all prefixes from shortest to longest of the input string
    >>> allPrefixes("abc")
    ["a", "ab", "abc"]

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.gemini
  - Class name: HE014_allPrefixesImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/gemini/HE014_allPrefixesImprovedTest.java`](../../src/test/java/edu/itu/blg475e/gemini/HE014_allPrefixesImprovedTest.java).

EC/BV rationale returned by the model:
> allPrefixes: EC = {empty, length-1, length-N}. Boundary: verify size == input length.

Test methods emitted (first 8):

- `empty_returns_empty`
- `length_one`
- `length_three_count`
- `length_three_order`
- `repeated_chars`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


