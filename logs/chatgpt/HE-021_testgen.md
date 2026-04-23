# LLM Interaction Log — HE-021_rescaleToUnit / test generation

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

Method under test: `HE021_rescaleToUnit.rescaleToUnit(List<Double> numbers)`

Problem description:
Given list of numbers (of at least two elements), apply a linear transform to that list,
    such that the smallest number will become 0 and the largest will become 1
    >>> rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0))
    [0.0, 0.25, 0.5, 0.75, 1.0]

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE021_rescaleToUnitImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE021_rescaleToUnitImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE021_rescaleToUnitImprovedTest.java).

EC/BV rationale returned by the model:
> rescaleToUnit: EC = {already [0,1], negative range, constant shift, contains max/min at extremes}. Boundary: min and max endpoints → 0.0 and 1.0.

Test methods emitted (first 8):

- `two_elements_become_zero_and_one`
- `min_becomes_zero`
- `max_becomes_one`
- `middle_is_half`
- `negative_range_normalised`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


