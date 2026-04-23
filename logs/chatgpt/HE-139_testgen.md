# LLM Interaction Log — HE-139_specialFactorial / test generation

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

Method under test: `HE139_specialFactorial.specialFactorial(int n)`

Problem description:
The Brazilian factorial is defined as:
    brazilian_factorial(n) = n! * (n-1)! * (n-2)! * ... * 1!
    where n > 0

    For example:
    >>> specialFactorial(4)
    288

    The function will receive an integer as input and should return the special
    factorial of this integer.

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE139_specialFactorialImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE139_specialFactorialImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE139_specialFactorialImprovedTest.java).

EC/BV rationale returned by the model:
> specialFactorial: n! * (n-1)! * ... * 1!. EC = {n=1 base, n=2, typical, larger}.

Test methods emitted (first 8):

- `n_equals_one`
- `n_equals_two`
- `n_equals_three`
- `n_equals_four`
- `n_equals_five`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


