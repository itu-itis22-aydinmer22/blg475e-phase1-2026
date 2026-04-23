# LLM Interaction Log — HE-083_startsOneEnds / test generation

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

Method under test: `HE083_startsOneEnds.startsOneEnds(int n)`

Problem description:
Given a positive integer n, return the count of the numbers of n-digit
    positive integers that start or end with 1.

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE083_startsOneEndsImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE083_startsOneEndsImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE083_startsOneEndsImprovedTest.java).

EC/BV rationale returned by the model:
> startsOneEnds: EC = {n=1 single 1 exception, n=2, medium n}. Formula: 18 * 10^(n-2) for n>=2.

Test methods emitted (first 8):

- `n_equals_one`
- `n_equals_two`
- `n_equals_three`
- `n_equals_four`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


