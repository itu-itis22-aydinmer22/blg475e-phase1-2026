# LLM Interaction Log — HE-017_parseMusic / test generation

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

Method under test: `HE017_parseMusic.parseMusic(String string)`

Problem description:
Input to this function is a string representing musical notes in a special ASCII format.
    Your task is to parse this string and return list of integers corresponding to how many beats does each
    not last.

    Here is a legend:
    "o" - whole note, lasts four beats
    "o|" - half note, lasts two beats
    ".|" - quater note, lasts one beat

    >>> parseMusic("o o| .| o| o| .| .| .| .| o o")
    [4, 2, 1, 2, 2, 1, 1, 1, 1, 4, 4]

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.chatgpt
  - Class name: HE017_parseMusicImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/chatgpt/HE017_parseMusicImprovedTest.java`](../../src/test/java/edu/itu/blg475e/chatgpt/HE017_parseMusicImprovedTest.java).

EC/BV rationale returned by the model:
> parseMusic: EC = {empty string, all whole notes, all half, all quarter, mixed}. Boundary: empty.

Test methods emitted (first 8):

- `empty_returns_empty_list`
- `single_whole_note`
- `single_half_note`
- `single_quarter_note`
- `mixed_pattern`
- `all_quarter`

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).


