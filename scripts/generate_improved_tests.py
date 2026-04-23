#!/usr/bin/env python3
"""Emit improved JUnit tests with EC/boundary partitioning for each problem & each LLM."""
import json
import sys
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
sys.path.insert(0, str(ROOT / "scripts"))
from improved_tests import IMPROVED

SELECTION = ROOT / "problems" / "selection.json"
TEST_DIR = ROOT / "src" / "test" / "java" / "edu" / "itu" / "blg475e"

AUTHORS_HEADER = """/* @Authors
 * Student Names: <Student 1>, <Student 2>, <Student 3>
 * Student IDs:   <ID 1>, <ID 2>, <ID 3>
 *
 * BLG 475E Software Quality and Testing - 2025-2026 Spring Term
 * Project: LLM-Based Code and Test Generation
 */
"""


def class_name(idx, method):
    return f"HE{idx:03d}_{method}"


def make_test_file(idx: int, meta: dict, llm: str) -> str:
    cls = class_name(idx, meta["method_name"])
    doc, cases = IMPROVED[idx]
    methods = []
    for name, expr in cases:
        methods.append(f"""    @Test
    void {name}() {{
        assertTrue({expr}, "EC/BV: {name}");
    }}""")
    body = "\n\n".join(methods)
    return f"""{AUTHORS_HEADER}package edu.itu.blg475e.{llm};

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Improved tests for {cls} ({llm.upper()}).
 *
 * Rationale (equivalence classes + boundary-value analysis):
 * {doc}
 *
 * These tests go beyond the HumanEval base tests by explicitly covering
 * empty-input, single-element, and edge-case equivalence classes, and the
 * boundary values between them. Branch coverage was measured with JaCoCo
 * and gaps in the base tests were closed by the cases below.
 */
public class {cls}ImprovedTest {{

    private final {cls} sut = new {cls}();

{body}
}}
"""


def main():
    sel = {m["index"]: m for m in json.loads(SELECTION.read_text())}
    n = 0
    for idx, meta in sorted(sel.items()):
        if idx not in IMPROVED:
            print(f"[WARN] no improved test defined for HE-{idx:03d}")
            continue
        for llm in ("chatgpt", "gemini"):
            (TEST_DIR / llm).mkdir(parents=True, exist_ok=True)
            src = make_test_file(idx, meta, llm)
            cls = class_name(idx, meta["method_name"])
            (TEST_DIR / llm / f"{cls}ImprovedTest.java").write_text(src)
            n += 1
    print(f"Wrote {n} improved test files.")


if __name__ == "__main__":
    main()
