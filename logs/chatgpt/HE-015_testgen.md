# LLM Interaction Log — HE-015_stringSequence / test generation

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

Method under test: `HE015_stringSequence.stringSequence(int n)`

Problem description:
Return a string containing space-delimited numbers starting from 0 upto n inclusive.
    >>> stringSequence(0)
    "0"
    >>> stringSequence(5)
    "0 1 2 3 4 5"

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE015_stringSequenceImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE015_stringSequenceImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE015_stringSequenceImprovedTest.java).

EC/BV rationale returned by the model:
> stringSequence: EC = {n=0 smallest boundary, n=1, typical, large n}. Format: space-separated.

Test methods emitted (first 8):

- `n_zero_just_zero`
- `n_one`
- `n_five`
- `n_has_right_count`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


