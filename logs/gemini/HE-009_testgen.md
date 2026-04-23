# LLM Interaction Log — HE-009_rollingMax / test generation

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

Method under test: `HE009_rollingMax.rollingMax(List<Integer> numbers)`

Problem description:
From a given list of integers, generate a list of rolling maximum element found until given moment
    in the sequence.
    >>> rollingMax(Arrays.asList(1, 2, 3, 2, 3, 4, 2))
    [1, 2, 3, 3, 3, 4, 4]

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.gemini
  - Class name: HE009_rollingMaxImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/gemini/HE009_rollingMaxImprovedTest.java`](../../src/test/java/edu/itu/blg475e/gemini/HE009_rollingMaxImprovedTest.java).

EC/BV rationale returned by the model:
> rollingMax: EC = {empty, single, strictly ascending, strictly descending, all-equal, mixed}. Boundary = Integer.MIN_VALUE at start.

Test methods emitted (first 8):

- `empty_returns_empty`
- `single_element`
- `ascending_stays_ascending`
- `descending_plateaus_at_first`
- `all_equal`
- `min_value_boundary`
- `negative_numbers`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


