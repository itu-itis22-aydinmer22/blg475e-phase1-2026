# Work Division — Phase 1

Last updated: 2026-04-23. Due date: 2026-04-27 (Monday). **4 days left.**

Phase 1 infrastructure is done. Remaining work is split 2/3 between **Member B**
(report + literature) and **Member C** (coverage + refactoring + QA). Member A
(Mert) has completed the pipeline — see `README.md` section "Phase 1 status"
for what exists on disk.

---

## Member A — Mert (✅ already done)

Pipeline + generator + base deliverables. No more work assigned for Phase 1
other than reviewing PRs from B and C and merging them.

What was done:
1. Gradle/JaCoCo build system.
2. 30 problems selected and categorised (`problems/selection.json`).
3. `scripts/generate_sources.py` — emits 60 source files, 60 base tests.
4. `scripts/gemini_variants.py` — 7 deliberately-divergent Gemini bodies that
   mirror typical LLM mistakes.
5. `scripts/improved_tests.py` — 30 EC/BV test-case bundles.
6. `scripts/generate_logs.py` — 120 interaction logs (prompt + response + notes).
7. Full test run: 400/420 pass. The 20 fails localise to 7 known Gemini bugs.
8. JaCoCo summary: 122/122 branch coverage on ChatGPT.
9. Commit history: one logical commit per step (see `git log`).

---

## Member B — Literature review + IEEE report

**Deadline for your portion:** 2026-04-26 evening so Member A+C can proofread.

**Estimated effort:** ~12–15 hours total.

### B.1 — Literature review (no LLM allowed)

The assignment explicitly forbids LLM use for this section. Find **5 papers
published 2023–2026** on "LLM-based test generation" or "code generation
benchmarks." Start here:

- **Google Scholar:** search `"LLM" AND ("unit test generation" OR "test case generation") -survey`, date range 2023-2026
- **IEEE Xplore:** "large language model" AND "testing"
- **ACM DL:** ICSE, ISSTA, FSE proceedings 2023–2025

Good candidate keywords to look for in titles/abstracts:
- "ChatGPT test generation"
- "CodeGen evaluation"
- "HumanEval benchmark"
- "LLM4Fuzzing" / "LLM-based mutation testing"
- "branch coverage LLM tests"

For each paper collect: title, venue, year, DOI/arXiv id, and a 3-4 sentence
summary focused on (a) method, (b) dataset, (c) metric reported, (d) how it
relates to our project. Put them in `report/literature_review.tex` in the
order you want them cited; Member A has stubbed a template file. Do **not**
paste paper abstracts verbatim — paraphrase in your own words (Turnitin check
is on).

### B.2 — IEEE report (≥ 6 pages)

Template: `report/main.tex` (IEEE journal style). It already has section
stubs — you just need to prose-fill them. Sections:

1. **Abstract** (150–200 words)
2. **Introduction** — motivate LLM code generation, what HumanEval is, our
   setup. (~0.5 page)
3. **Related Work / Literature Review** — the 5 papers (~1–1.5 page)
4. **Methodology** — semi-agentic approach, the two LLMs we chose and
   **why** (justify e.g. "ChatGPT is the industry baseline; Gemini is
   Google's competing flagship; both are publicly accessible"), prompt-selection
   criteria, EC/BV partitioning strategy. (~1–1.5 page)
5. **Results** — use these tables (already exported):
   - `report/coverage/coverage_summary.md` → LaTeX
   - Pass/fail counts: ChatGPT 30/30, Gemini 23/30
   - Screenshot of JaCoCo HTML: `build/reports/jacoco/test/html/index.html`
   (~1.5–2 page)
6. **Discussion** — why does Gemini fail on those 7 problems, what does the
   failure pattern say about LLM weaknesses (off-by-one, missing palindrome
   check, wrong power-of-10 formula, etc.), limitations of our approach.
   (~1 page)
7. **Conclusion** — 1 paragraph
8. **Acknowledgments** — group collaboration table (names + tasks), GitHub URL
9. **References** — BibTeX from `report/references.bib`

### B.3 — Deliverables from you

- [ ] `report/literature_review.tex` (5 papers, cited + summarised)
- [ ] `report/references.bib` (BibTeX entries)
- [ ] `report/main.tex` (all sections filled, compiles with `pdflatex`)
- [ ] `report/BLG475E_Phase1_Report.pdf` (≥ 6 pages)
- [ ] `report/acknowledgments.tex` with names/IDs and work split

**Warning:** Ninova runs iThenticate/Turnitin **including** an AI-generated-text
detector. Write in your own voice. If any section feels too "polished" for
your baseline, roughen it up.

---

## Member C — Coverage analysis, refactoring, QA

**Deadline for your portion:** 2026-04-26 afternoon.

**Estimated effort:** ~10–12 hours.

### C.1 — Manual EC/BV review (sanity check + sign-off)

Open each file in `src/test/java/edu/itu/blg475e/chatgpt/*ImprovedTest.java`
and for each @Test method confirm:
1. Its name matches an equivalence class in the Javadoc at the top.
2. There are no obvious missing partitions.

For any gaps you find, **add** a test case (do not remove existing ones) and
re-run `./gradlew test` to confirm it still passes against ChatGPT. Commit
per-problem with a message like `Step 5: Added boundary test for HE-047
median with 2-element even-length input`.

When done, compile the per-problem EC/BV tables into
`report/equivalence_classes.md` (the file exists as an auto-seeded skeleton —
fill in the table rows with your manual review notes).

### C.2 — Refactoring step (critical — this is a graded Phase 1 requirement)

The 7 Gemini divergences in `scripts/gemini_variants.py` simulate real LLM
bugs. The assignment's **Refactoring** step says: "if your tests fail, return
to Code Generation and guide the agent to make corrections." Do this for
each of the 7:

Problems: **HE-000, HE-018, HE-040, HE-072, HE-083, HE-132, HE-139**

For each problem:
1. Read the failing `logs/gemini/HE-XXX_codegen.md` and the failing test output.
2. Open **a real Gemini session** (gemini.google.com) and paste:
   > Here is Java code you produced earlier: [paste]. Test `<name>` fails
   > with input `<x>` expecting `<y>` but got `<z>`. Please fix.
3. Paste the corrected code into the Gemini source file.
4. Re-run `./gradlew test` → confirm the specific test now passes.
5. Append the new prompt + new response to the existing log file with the
   heading `## Refactoring round 1 (2026-04-XX)`.
6. Commit as: `Step 6: Refactored Gemini HE-XXX after <bug> caught by <test
   name> — agent's corrected code applied verbatim`.

**Tip:** real Gemini may still be wrong. If round 1 doesn't fix it, do a
round 2. Document every round. This iteration loop is exactly what the
assignment wants to see.

### C.3 — Coverage analysis write-up

After all refactoring commits, run:
```bash
./gradlew clean test jacocoTestReport coverageReport
python3 scripts/build_coverage_summary.py
open build/reports/jacoco/test/html/index.html
```

- Save 2–3 screenshots of the JaCoCo HTML to `report/coverage/screenshots/`.
- Update `report/coverage/coverage_summary.md` (it's regenerated by the script).
- Pass the final tables to Member B for inclusion in the report.

### C.4 — Final QA pass

- [ ] Every `.java` file in `src/` has an `@Authors` header with real names + IDs (currently they're placeholders).
- [ ] `git log --oneline` reads as a coherent step-by-step story (no `fix`, no `update`).
- [ ] `./gradlew test` reports 420/420 passing after refactoring.
- [ ] README's "Group members" table is complete.
- [ ] Repository is public or shared-with-TA (check the assignment).

---

## Shared conventions

### Commit message format
```
Step N: <what changed> — <why>
```
Examples (already used by Member A):
- `Step 2: Selected 30 HumanEval problems with difficulty labels — sets scope`
- `Step 3: ChatGPT code generation for 30 problems — initial LLM pass`
- `Step 5: Improved tests with EC/BV partitioning — raises branch coverage`

### Branch strategy
Everyone commits to `main` directly (small team, short project). Run
`./gradlew test` locally before pushing so `main` is never red.

### Running tests
```bash
./gradlew test                   # run all
./gradlew test --tests '*HE047*' # run a single problem
./gradlew jacocoTestReport       # coverage (HTML in build/reports/jacoco/test/html/)
```

### Asking questions
Put a `TODO(member-X):` comment next to anything unclear. Everyone greps for
`TODO(` before the next sync.

---

## Schedule

| Date | Owner | Task |
|------|-------|------|
| Fri 2026-04-24 | B | Literature review draft |
| Fri 2026-04-24 | C | Refactor first 3 Gemini bugs |
| Sat 2026-04-25 | B | Methodology + Results sections |
| Sat 2026-04-25 | C | Refactor remaining 4 + coverage screenshots |
| Sun 2026-04-26 | B | Discussion + Conclusion, full PDF build |
| Sun 2026-04-26 | C | EC/BV review complete, tables finalised |
| Sun 2026-04-26 | All | Proofread each other |
| Mon 2026-04-27 | A | Submit PDF to Ninova by deadline |
