# LLM Interaction Log — HE-003_belowZero / test generation

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

Method under test: `HE003_belowZero.belowZero(List<Integer> operations)`

Problem description:
You're given a list of deposit and withdrawal operations on a bank account that starts with
    zero balance. Your task is to detect if at any point the balance of account fallls below zero, and
    at that point function should return True. Otherwise it should return False.
    >>> belowZero(Arrays.asList(1, 2, 3))
    false
    >>> belowZero(Arrays.asList(1, 2, -4, 5))
    true

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE003_belowZeroImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE003_belowZeroImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE003_belowZeroImprovedTest.java).

EC/BV rationale returned by the model:
> belowZero: EC = {empty, always-positive, goes-negative, returns-to-positive, ends-exactly-zero}; Boundary = transient -1 vs +1 balance.

Test methods emitted (first 8):

- `empty_balance_never_negative`
- `single_positive`
- `single_negative_goes_below`
- `net_positive_but_dips_below`
- `always_stays_at_zero_boundary`
- `net_negative_but_never_below`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


