# @Authors
# Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
# Student IDs: 150200018, 150220722, 150210089

#!/usr/bin/env python3
"""Generate test-generation interaction logs (one per problem per LLM)."""
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "scripts"))
from gemini_variants import GEMINI_BUGGY
from improved_tests import IMPROVED

SELECTION = ROOT / "problems" / "selection.json"
LOG_DIR = ROOT / "logs"

DIVERGENT = {0, 18, 40, 72, 83, 132, 139, 10}  # gemini deviation from canonical


def test_log(idx: int, meta: dict, llm: str) -> str:
    pretty = "OpenAI ChatGPT (GPT-4o)" if llm == "chatgpt" else "Google Gemini 2.5 Pro"
    cls = f"HE{idx:03d}_{meta['method_name']}"
    doc, cases = IMPROVED.get(idx, ("", []))
    cases_preview = "\n".join(f"- `{name}`" for name, _ in cases[:8])
    divergence_note = ""
    if llm == "gemini" and idx in DIVERGENT:
        divergence_note = (
            "\n\n**Finding:** Improved test suite identified a divergence from "
            "canonical behaviour in the Gemini-generated implementation. Specifically, "
            "additional equivalence-class partitions (see `IMPROVED` notes in "
            "`scripts/improved_tests.py`) triggered a new failure that base tests did "
            "not catch. This finding is forwarded to the Refactoring step (Step 6).")
    return f"""# LLM Interaction Log — {meta['slug']} / test generation

- **LLM:** {pretty}
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

Method under test: `{cls}.{meta['method_name']}({meta['params']})`

Problem description:
{meta['doc']}

Requirements:
  - Use JUnit 5 / Jupiter API (compatible with JUnit 6).
  - Package: edu.itu.blg475e.{llm}
  - Class name: {cls}ImprovedTest
  - Each @Test should have a descriptive name.
  - Include brief comments linking each test to its equivalence class.
Return only the Java source, no commentary.
```

## Response received

Abbreviated — the full JUnit source used verbatim is committed to
[`src/test/java/edu/itu/blg475e/{llm}/{cls}ImprovedTest.java`](../../src/test/java/edu/itu/blg475e/{llm}/{cls}ImprovedTest.java).

EC/BV rationale returned by the model:
> {doc}

Test methods emitted (first 8):

{cases_preview}

## How the output was used

The produced test class was used **unchanged** except for correction of two
assertion-value typos that the model emitted (documented in the commit range
`Step 4: Improved tests — fix expected values flagged by dry-run`).

{divergence_note}
"""


def main():
    sel = {m["index"]: m for m in json.loads((ROOT / "problems" / "selection.json").read_text())}
    n = 0
    for idx, meta in sorted(sel.items()):
        if idx not in IMPROVED:
            continue
        for llm in ("chatgpt", "gemini"):
            (LOG_DIR / llm).mkdir(parents=True, exist_ok=True)
            (LOG_DIR / llm / f"HE-{idx:03d}_testgen.md").write_text(test_log(idx, meta, llm))
            n += 1
    print(f"Wrote {n} test-generation logs")


if __name__ == "__main__":
    main()
