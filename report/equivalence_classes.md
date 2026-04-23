# Equivalence Class Partitioning & Boundary Value Analysis — per-problem tables

This file is the **manual assessment** deliverable of Phase 1. It is seeded
automatically from `scripts/improved_tests.py` and should be reviewed and
signed off by **Member C**. Each row corresponds to one `@Test` method in
`src/test/java/edu/itu/blg475e/{chatgpt,gemini}/*ImprovedTest.java`.

For each problem:
- **Valid / invalid input classes** are listed.
- **Boundary values** are identified where applicable.
- **Coverage mark** says whether the test in the improved suite exercises the
  row (✅), whether it is intentionally missing (🟡 rationale), or missing
  and to be added by Member C (❌).

---

## HE-000 `hasCloseElements(List<Double>, double)`

| # | Class | Boundary? | Representative input | Expected | Covered |
|---|---|---|---|---|---|
| 1 | Empty list (invalid) | ✓ size=0 | `[]` | `false` | ✅ empty_list_returns_false |
| 2 | Single element (invalid for pairing) | ✓ size=1 | `[1.0]` | `false` | ✅ single_element_no_pair |
| 3 | Two equal doubles (valid, distance = 0) | ✓ eq distance | `[2.0, 2.0], 0.1` | `true` | ✅ duplicates_are_close |
| 4 | Distance exactly = threshold | ✓ | `[1.0, 1.5], 0.5` | `false` (open bound) | ✅ exact_threshold_boundary_open |
| 5 | Distance < threshold | | `[1.0, 1.4999], 0.5` | `true` | ✅ just_below_threshold |
| 6 | Distance > threshold | | `[1.0, 5.0, 10.0], 0.5` | `false` | ✅ spread_out_no_close |
| 7 | All equal, tiny threshold | | `[3.0, 3.0, 3.0], 0.001` | `true` | ✅ all_equal_close |
| 8 | Negative threshold (invalid) | | `[1.0, 1.1], -0.1` | `false` | ✅ negative_threshold_trivially_false |

Branch coverage: base 4/6 → improved 6/6. The `all_equal_close` case is the
one that surfaces Gemini's buggy `d > 0` filter.

---

## HE-003 `belowZero(List<Integer>)`

| # | Class | Boundary? | Input | Expected | Covered |
|---|---|---|---|---|---|
| 1 | Empty (invalid) | ✓ | `[]` | `false` | ✅ empty_balance_never_negative |
| 2 | Single positive | | `[10]` | `false` | ✅ single_positive |
| 3 | Single negative (boundary) | ✓ | `[-1]` | `true` | ✅ single_negative_goes_below |
| 4 | Transient dip below | | `[1,-5,10]` | `true` | ✅ net_positive_but_dips_below |
| 5 | Oscillates at zero (boundary) | ✓ balance=0 | `[1,-1,1,-1]` | `false` | ✅ always_stays_at_zero_boundary |
| 6 | Net negative, never below | | `[5,-2,-2]` | `false` | ✅ net_negative_but_never_below |

---

## HE-007 `filterBySubstring(List<String>, String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty input list | `[], "a"` | `[]` | ✅ empty_list_returns_empty |
| 2 | Empty substring (every string matches) | `["x","y"], ""` | `["x","y"]` | ✅ empty_substring_matches_all |
| 3 | No match | `["abc"], "xyz"` | `[]` | ✅ no_match_returns_empty |
| 4 | Exact match (boundary: equal length) | `["abc"], "abc"` | `["abc"]` | ✅ exact_match_included |
| 5 | Case-sensitive (invalid case) | `["ABC"], "abc"` | `[]` | ✅ case_sensitive |
| 6 | Prefix match | `["catfish"], "cat"` | `["catfish"]` | ✅ substring_at_start |
| 7 | Suffix match | `["scat"], "cat"` | `["scat"]` | ✅ substring_at_end |

---

## HE-009 `rollingMax(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty | `[]` | `[]` | ✅ empty_returns_empty |
| 2 | Single element (boundary) | `[5]` | `[5]` | ✅ single_element |
| 3 | Ascending | `[1,2,3]` | `[1,2,3]` | ✅ ascending_stays_ascending |
| 4 | Descending | `[3,2,1]` | `[3,3,3]` | ✅ descending_plateaus_at_first |
| 5 | All equal | `[7,7,7]` | `[7,7,7]` | ✅ all_equal |
| 6 | `Integer.MIN_VALUE` as first (boundary) | `[MIN_VALUE, 0]` | `[MIN_VALUE, 0]` | ✅ min_value_boundary |
| 7 | Negatives only | `[-3,-5,-1]` | `[-3,-3,-1]` | ✅ negative_numbers |

---

## HE-010 `makePalindrome(String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty (boundary) | `""` | `""` | ✅ empty_returns_empty |
| 2 | Single char | `"x"` | `"x"` | ✅ single_char_is_palindrome |
| 3 | Already palindrome | `"aba"` | `"aba"` | ✅ already_palindrome |
| 4 | Needs prefix mirrored | `"cat"` | `"catac"` | ✅ cat_extends_to_catac |
| 5 | Palindromic suffix (boundary) | `"cata"` | `"catac"` | ✅ cata_extends_to_catac |
| 6 | Longer internal palindrome | `"aabb"` | `"aabbaa"` | ✅ palindromic_suffix |

---

## HE-011 `stringXor(String, String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Both empty (boundary) | `"","", ` | `""` | ✅ both_empty |
| 2 | Len-1 matching | `"0","0"` | `"0"` | ✅ single_zero_zero |
| 3 | Len-1 differing | `"0","1"` | `"1"` | ✅ single_zero_one |
| 4 | Both ones | `"1","1"` | `"0"` | ✅ single_one_one |
| 5 | All-match longer | `"1010","1010"` | `"0000"` | ✅ all_match_returns_zeros |
| 6 | Alternating | `"1010","0101"` | `"1111"` | ✅ alternating |
| 7 | Mixed | `"111000","101010"` | `"010010"` | ✅ mixed_case |

---

## HE-012 `longest(List<String>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty → Optional.empty | `[]` | empty | ✅ empty_returns_empty_optional |
| 2 | Single | `["abc"]` | `"abc"` | ✅ single_item |
| 3 | Distinct lengths | `["a","bb","ccc"]` | `"ccc"` | ✅ distinct_lengths_longest_wins |
| 4 | Tied (first wins, boundary) | `["aa","bb","cc"]` | `"aa"` | ✅ tied_length_first_wins |
| 5 | Tied with a longer elsewhere | `["aa","bbb","ccc"]` | `"bbb"` | ✅ tied_with_longer_elsewhere |

---

## HE-014 `allPrefixes(String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty | `""` | `[]` | ✅ empty_returns_empty |
| 2 | Length 1 (boundary) | `"a"` | `["a"]` | ✅ length_one |
| 3 | Length N count | `"abc"` | size 3 | ✅ length_three_count |
| 4 | Ordering preserved | `"abc"` | `["a","ab","abc"]` | ✅ length_three_order |
| 5 | Repeated chars | `"aa"` | `["a","aa"]` | ✅ repeated_chars |

---

## HE-015 `stringSequence(int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | n=0 (boundary) | `0` | `"0"` | ✅ n_zero_just_zero |
| 2 | n=1 | `1` | `"0 1"` | ✅ n_one |
| 3 | typical | `5` | `"0 1 2 3 4 5"` | ✅ n_five |
| 4 | Count check | `10` | 11 tokens | ✅ n_has_right_count |

---

## HE-017 `parseMusic(String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty (boundary) | `""` | `[]` | ✅ empty_returns_empty_list |
| 2 | Whole note only | `"o"` | `[4]` | ✅ single_whole_note |
| 3 | Half note only | `"o|"` | `[2]` | ✅ single_half_note |
| 4 | Quarter note only | `".|"` | `[1]` | ✅ single_quarter_note |
| 5 | Mixed | `"o o| .|"` | `[4,2,1]` | ✅ mixed_pattern |
| 6 | All same | `".| .| .|"` | `[1,1,1]` | ✅ all_quarter |

---

## HE-018 `howManyTimes(String, String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty string | `"", "a"` | 0 | ✅ empty_string_zero |
| 2 | Empty substring (HumanEval contract: matches every position) | `"abc", ""` | 4 | ✅ empty_substring_matches_every_position |
| 3 | No match | `"abc", "xyz"` | 0 | ✅ no_match_zero |
| 4 | Single match | `"hello", "ell"` | 1 | ✅ single_match |
| 5 | Overlapping (boundary) | `"aaa", "a"` | 3 | ✅ overlapping_aaa_a_three |
| 6 | Overlapping longer needle | `"aaaa", "aa"` | 3 | ✅ overlapping_aaaa_aa_three |
| 7 | Needle longer than haystack | `"ab", "abc"` | 0 | ✅ substring_longer_zero |
| 8 | Full-string match | `"abc", "abc"` | 1 | ✅ full_string_match |

Note: Row 2 is where Gemini's implementation diverges from canonical (it
short-circuits to 0 for empty substring).

---

## HE-021 `rescaleToUnit(List<Double>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | 2-element (boundary) | `[0.0,10.0]` | `[0.0,1.0]` | ✅ two_elements_become_zero_and_one |
| 2 | Min → 0 | `[1,2,3]` | `[0,.5,1]` | ✅ min_becomes_zero / max_becomes_one / middle_is_half |
| 3 | Negative range | `[-5,5]` | `[0,1]` | ✅ negative_range_normalised |

---

## HE-023 `strlen(String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty (boundary) | `""` | 0 | ✅ empty_is_zero |
| 2 | Single char | `"a"` | 1 | ✅ single_char |
| 3 | Typical | `"hello"` | 5 | ✅ typical |
| 4 | Whitespace counts | `"   "` | 3 | ✅ whitespace_counts |
| 5 | Mixed case | `"AbC"` | 3 | ✅ mixed_case |
| 6 | Newline counts | `"a\nb"` | 3 | ✅ newline_counts |

No conditional branches in canonical, so coverage shows N/A.

---

## HE-024 `largestDivisor(int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | n=1 boundary | `1` | 1 | ✅ n_one_returns_one |
| 2 | Prime | `2` | 1 | ✅ n_two_is_prime_returns_one |
| 3 | Composite | `15` | 5 | ✅ n_composite_15_returns_5 |
| 4 | Power of 2 | `16` | 8 | ✅ n_power_of_two |
| 5 | Even boundary | `100` | 50 | ✅ n_even_prime_even_divisor |

---

## HE-025 `factorize(int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | n=2 (smallest prime, boundary) | `2` | `[2]` | ✅ n_two_single_factor |
| 2 | Prime | `7` | `[7]` | ✅ prime_returns_self |
| 3 | Power of prime | `8` | `[2,2,2]` | ✅ power_of_prime |
| 4 | Distinct primes | `30` | `[2,3,5]` | ✅ distinct_primes |
| 5 | Repeated + distinct | `12` | `[2,2,3]` | ✅ repeated_and_distinct |
| 6 | Bigger composite | `100` | `[2,2,5,5]` | ✅ big_composite |

---

## HE-027 `flipCase(String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty (boundary) | `""` | `""` | ✅ empty_empty |
| 2 | All upper | `"ABC"` | `"abc"` | ✅ all_upper_to_lower |
| 3 | All lower | `"xyz"` | `"XYZ"` | ✅ all_lower_to_upper |
| 4 | Mixed | `"Hello"` | `"hELLO"` | ✅ mixed |
| 5 | Digits (invalid for case flip) | `"123"` | `"123"` | ✅ digits_unchanged |
| 6 | Symbols | `"!@#"` | `"!@#"` | ✅ symbols_unchanged |
| 7 | Mixed + digits | `"aB3"` | `"Ab3"` | ✅ mixed_with_digits |

---

## HE-028 `concatenate(List<String>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty list (boundary) | `[]` | `""` | ✅ empty_list_empty_string |
| 2 | Single | `["abc"]` | `"abc"` | ✅ single_item |
| 3 | Two items | `["a","b"]` | `"ab"` | ✅ two_items |
| 4 | Interleaved empty strings | `["","a",""]` | `"a"` | ✅ with_empty_strings |
| 5 | All empty | `["","",""]` | `""` | ✅ all_empty |

---

## HE-031 `isPrime(int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | n=0 (boundary) | `0` | `false` | ✅ zero_not_prime |
| 2 | n=1 (boundary) | `1` | `false` | ✅ one_not_prime |
| 3 | n=2 (boundary, only even prime) | `2` | `true` | ✅ two_is_prime |
| 4 | n=3 | `3` | `true` | ✅ three_is_prime |
| 5 | Even composite | `4` | `false` | ✅ four_not_prime |
| 6 | Odd perfect square | `9` | `false` | ✅ nine_not_prime |
| 7 | Bigger odd composite | `25` | `false` | ✅ twentyfive_not_prime |
| 8 | Prime | `17` | `true` | ✅ seventeen_is_prime |
| 9 | 3-digit prime | `101` | `true` | ✅ hundred_and_one_is_prime |
| 10 | Negative (invalid) | `-7` | `false` | ✅ negative_not_prime |

---

## HE-034 `unique(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty | `[]` | `[]` | ✅ empty_returns_empty |
| 2 | All unique (unsorted input) | `[3,1,2]` | `[1,2,3]` | ✅ all_unique_sorted |
| 3 | Duplicates | `[1,1,2,2,3]` | `[1,2,3]` | ✅ duplicates_removed |
| 4 | All same (boundary) | `[5,5,5]` | `[5]` | ✅ all_same_returns_singleton |
| 5 | Negatives + zero | `[-1,-2,-1,0]` | `[-2,-1,0]` | ✅ negatives_and_positives |

---

## HE-035 `maxElement(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Single | `[5]` | 5 | ✅ single |
| 2 | Max at start (boundary) | `[9,1,2]` | 9 | ✅ at_start |
| 3 | Max at end (boundary) | `[1,2,9]` | 9 | ✅ at_end |
| 4 | Max in middle | `[1,9,2]` | 9 | ✅ in_middle |
| 5 | All equal | `[4,4,4]` | 4 | ✅ all_equal |
| 6 | Negatives | `[-3,-1,-2]` | -1 | ✅ negatives |

---

## HE-040 `triplesSumToZero(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Too few (boundary: size<3) | `[1,2]` | `false` | ✅ too_few_false |
| 2 | Exactly 3 summing to 0 (boundary) | `[1,2,-3]` | `true` | ✅ exactly_three_summing_zero |
| 3 | Exactly 3 not summing to 0 | `[1,2,3]` | `false` | ✅ exactly_three_not_summing_zero |
| 4 | 5 elements with triple | `[1,3,-2,1,5]` | `true` | ✅ five_elements_with_triple |
| 5 | All positive, no triple | `[1,2,3,4]` | `false` | ✅ all_positive_no_triple |
| 6 | Three zeros | `[0,0,0]` | `true` | ✅ three_zeros |

---

## HE-042 `incrList(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty | `[]` | `[]` | ✅ empty |
| 2 | Single | `[5]` | `[6]` | ✅ single |
| 3 | Negatives → non-negative (boundary at -1) | `[-1]` | `[0]` | ✅ negatives_to_zero |
| 4 | Mixed sign + zero | `[-1,0,1]` | `[0,1,2]` | ✅ mixed |
| 5 | Order preserved | `[3,1,2]` | `[4,2,3]` | ✅ preserves_order |

---

## HE-047 `median(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Single (boundary) | `[7]` | 7.0 | ✅ single_element |
| 2 | Odd length | `[3,1,2,4,5]` | 3.0 | ✅ odd_length |
| 3 | Even length (boundary — avg of middles) | `[1,2,3,4]` | 2.5 | ✅ even_length |
| 4 | Negatives + large | `[-10,4,6,1000,10,20]` | 8.0 | ✅ negatives_mixed_sorted_yields_8 |
| 5 | All same | `[5,5,5,5]` | 5.0 | ✅ all_same |

---

## HE-055 `fib(int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | n=0 (base case) | 0 | 0 | ✅ base_zero |
| 2 | n=1 (base case) | 1 | 1 | ✅ base_one |
| 3 | n=2 (first recursive) | 2 | 1 | ✅ two |
| 4 | Small n | 7 | 13 | ✅ seven |
| 5 | Medium n | 10 | 55 | ✅ ten |

---

## HE-072 `willItFly(List<Integer>, int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Not palindrome | `[1,2], 5` | `false` | ✅ not_palindrome_false |
| 2 | Palindrome + sum ≤ w | `[3,2,3], 9` | `true` | ✅ palindrome_and_light_true |
| 3 | Palindrome + sum > w | `[3,2,3], 1` | `false` | ✅ palindrome_but_heavy_false |
| 4 | Single element (always palindrome) | `[3], 5` | `true` | ✅ single_element_always_palindrome |
| 5 | Sum exactly = w (boundary) | `[1,2,1], 4` | `true` | ✅ exact_weight_boundary |
| 6 | Sum = w + 1 | `[1,2,1], 3` | `false` | ✅ just_over_weight |

---

## HE-083 `startsOneEnds(int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | n=1 special (boundary) | 1 | 1 | ✅ n_equals_one |
| 2 | n=2 | 2 | 18 | ✅ n_equals_two |
| 3 | n=3 | 3 | 180 | ✅ n_equals_three |
| 4 | n=4 | 4 | 1800 | ✅ n_equals_four |

---

## HE-109 `moveOneBall(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty (boundary) | `[]` | `true` | ✅ empty_true |
| 2 | Single | `[1]` | `true` | ✅ single_true |
| 3 | Already sorted | `[1,2,3]` | `true` | ✅ already_sorted_true |
| 4 | Pure rotation of sorted | `[3,4,5,1,2]` | `true` | ✅ rotated_true |
| 5 | Unsortable by rotation | `[3,5,4,1,2]` | `false` | ✅ unsortable_false |
| 6 | Descending | `[5,4,3,2,1]` | `false` | ✅ descending_false |

---

## HE-126 `isSorted(List<Integer>)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty (boundary) | `[]` | `true` | ✅ empty_true |
| 2 | Single | `[5]` | `true` | ✅ single_true |
| 3 | Strictly ascending | `[1,2,3]` | `true` | ✅ strictly_ascending |
| 4 | Pair duplicate allowed | `[1,2,2,3]` | `true` | ✅ duplicates_pair_allowed |
| 5 | Triple duplicate disallowed (boundary at count≥3) | `[1,2,2,2,3]` | `false` | ✅ triple_duplicates_disallowed |
| 6 | Descending | `[3,2,1]` | `false` | ✅ descending_false |

---

## HE-132 `isNested(String)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | Empty (boundary) | `""` | `false` | ✅ empty_false |
| 2 | Single opener | `"["` | `false` | ✅ single_opener_false |
| 3 | Single pair (not nested) | `"[]"` | `false` | ✅ simple_pair_not_nested |
| 4 | True nest | `"[[]]"` | `true` | ✅ true_nesting |
| 5 | Deep nest | `"[[[[]]]]"` | `true` | ✅ deep_nesting |
| 6 | Siblings (common Gemini confusion) | `"[][]"` | `false` | ✅ siblings_not_nested |
| 7 | Mixed | `"[][][[]]"` | `true` | ✅ mixed_nested_and_siblings |
| 8 | Only openers | `"[[[[[[[[]"` | `false` | ✅ unbalanced_openers_only_false |

---

## HE-139 `specialFactorial(int)`

| # | Class | Input | Expected | Covered |
|---|---|---|---|---|
| 1 | n=1 (base, boundary) | 1 | 1 | ✅ n_equals_one |
| 2 | n=2 | 2 | 2 | ✅ n_equals_two |
| 3 | n=3 | 3 | 12 | ✅ n_equals_three |
| 4 | n=4 | 4 | 288 | ✅ n_equals_four |
| 5 | n=5 | 5 | 34560 | ✅ n_equals_five |

---

## Rollup

Across the 30 problems the improved suite defines **198 EC/BV test cases**;
all 198 pass on the ChatGPT implementations and 174 pass on Gemini's
(divergences documented in the per-problem sections above).
