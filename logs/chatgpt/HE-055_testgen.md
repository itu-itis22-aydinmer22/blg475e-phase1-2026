# LLM Interaction Log — HE-055_fib / test generation

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

Method under test: `HE055_fib.fib(int n)`

Problem description:
Return n-th Fibonacci number.
    >>> fib(10)
    55
    >>> fib(1)
    1
    >>> fib(8)
    21

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE055_fibImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE055_fibImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE055_fibImprovedTest.java).

EC/BV rationale returned by the model:
> fib: EC = {n=0, n=1, small n, medium n}. Boundary: 0,1 base cases.

Test methods emitted (first 8):

- `base_zero`
- `base_one`
- `two`
- `seven`
- `ten`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


