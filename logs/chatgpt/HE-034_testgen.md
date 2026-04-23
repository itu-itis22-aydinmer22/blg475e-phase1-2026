# LLM Interaction Log — HE-034_unique / test generation

- **LLM:** OpenAI ChatGPT (GPT-4o)
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

Method under test: `HE034_unique.unique(List<Integer> l)`

Problem description:
Return sorted unique elements in a list
    >>> unique(Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123))
    [0, 2, 3, 5, 9, 123]

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE034_uniqueImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE034_uniqueImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE034_uniqueImprovedTest.java).

EC/BV rationale returned by the model:
> unique: EC = {empty, all-unique, all-same, duplicates scattered}. Output is sorted ascending.

Test methods emitted (first 8):

- `empty_returns_empty`
- `all_unique_sorted`
- `duplicates_removed`
- `all_same_returns_singleton`
- `negatives_and_positives`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


