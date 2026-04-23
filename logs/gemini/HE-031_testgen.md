# LLM Interaction Log — HE-031_isPrime / test generation

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

Method under test: `HE031_isPrime.isPrime(int n)`

Problem description:
Return true if a given number is prime, and false otherwise.
    >>> isPrime(6)
    false
    >>> isPrime(101)
    true
    >>> isPrime(11)
    true
    >>> isPrime(13441)
    true
    >>> isPrime(61)
    true
    >>> isPrime(4)
    false
    >>> isPrime(1)
    false

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.gemini
  - Class name: HE031_isPrimeImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/gemini/HE031_isPrimeImprovedTest.java`](../../src/test/java/edu/itu/blg475e/gemini/HE031_isPrimeImprovedTest.java).

EC/BV rationale returned by the model:
> isPrime: EC = {n<2 false, n=2 true, small odd primes, even composites, odd composites, perfect squares}. Boundary: n=0, n=1, n=2, n=3.

Test methods emitted (first 8):

- `zero_not_prime`
- `one_not_prime`
- `two_is_prime`
- `three_is_prime`
- `four_not_prime`
- `nine_not_prime`
- `twentyfive_not_prime`
- `seventeen_is_prime`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


