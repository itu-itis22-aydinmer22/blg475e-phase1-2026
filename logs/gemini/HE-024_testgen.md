# LLM Interaction Log — HE-024_largestDivisor / test generation

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

Method under test: `HE024_largestDivisor.largestDivisor(int n)`

Problem description:
For a given number n, find the largest number that divides n evenly, smaller than n
    >>> largestDivisor(15)
    5

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.gemini
  - Class name: HE024_largestDivisorImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/gemini/HE024_largestDivisorImprovedTest.java`](../../src/test/java/edu/itu/blg475e/gemini/HE024_largestDivisorImprovedTest.java).

EC/BV rationale returned by the model:
> largestDivisor: EC = {n=1 -> 1 by contract, n=prime -> 1, n=composite -> n/smallestFactor, n=power of two}. Boundary: n=1.

Test methods emitted (first 8):

- `n_one_returns_one`
- `n_two_is_prime_returns_one`
- `n_composite_15_returns_5`
- `n_power_of_two`
- `n_even_prime_even_divisor`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


