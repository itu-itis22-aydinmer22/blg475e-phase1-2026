#!/usr/bin/env python3
"""Extract selected HumanEval Java problems into individual files."""
import json
import os
import re
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
DATASET = ROOT / "dataset" / "humaneval_java.jsonl"
OUT = ROOT / "problems"

# Selected 30 problems with difficulty classification.
# Criteria:
# - 10 easy: simple arithmetic/string ops, single loop, straightforward
# - 10 moderate: multiple branches, nested loops, non-trivial logic
# - 10 hard: complex state, math reasoning, edge-heavy, tricky algorithms
# Includes #18, #23, #27 (required by Phase 2 BookScan)
SELECTION = {
    "easy": [0, 7, 9, 12, 21, 23, 24, 27, 28, 42],
    "moderate": [3, 11, 14, 15, 17, 18, 25, 31, 34, 35],
    "hard": [10, 40, 47, 55, 72, 83, 109, 126, 132, 139],
}


def parse_signature(prompt: str):
    """Extract method signature + doc from the full class prompt."""
    m = re.search(r"public\s+[\w<>\[\],\s?]+\s+(\w+)\s*\(([^)]*)\)\s*\{?", prompt)
    if not m:
        return None, None, None
    name, params = m.group(1), m.group(2).strip()
    # Extract doc between /** and */
    doc_m = re.search(r"/\*\*(.*?)\*/", prompt, re.DOTALL)
    doc = doc_m.group(1).strip() if doc_m else ""
    return name, params, doc


def classify(idx: int) -> str:
    for cat, ids in SELECTION.items():
        if idx in ids:
            return cat
    return None


def main():
    problems = []
    with DATASET.open() as f:
        for line in f:
            p = json.loads(line)
            tid = p["task_id"]
            idx = int(tid.split("/")[1])
            problems.append((idx, p))
    problems.sort(key=lambda x: x[0])

    selected_ids = set(SELECTION["easy"] + SELECTION["moderate"] + SELECTION["hard"])
    chosen = [p for idx, p in problems if idx in selected_ids]
    print(f"Dataset size: {len(problems)}, selected: {len(chosen)}")

    meta = []
    for p in chosen:
        tid = p["task_id"]
        idx = int(tid.split("/")[1])
        cat = classify(idx)
        name, params, doc = parse_signature(p["prompt"])
        slug = f"HE-{idx:03d}_{name}"
        pdir = OUT / cat / slug
        pdir.mkdir(parents=True, exist_ok=True)
        (pdir / "prompt.txt").write_text(p["prompt"])
        (pdir / "canonical_solution.java").write_text(p["canonical_solution"])
        (pdir / "test_original.java").write_text(p["test"])
        (pdir / "description.txt").write_text(doc)
        meta.append({
            "task_id": tid,
            "index": idx,
            "slug": slug,
            "category": cat,
            "method_name": name,
            "params": params,
            "doc": doc,
        })

    (ROOT / "problems" / "selection.json").write_text(json.dumps(meta, indent=2))
    print(f"Wrote {len(meta)} problems")
    for m in meta:
        print(f"  {m['category']:8} {m['slug']:40} {m['method_name']}({m['params']})")


if __name__ == "__main__":
    main()
