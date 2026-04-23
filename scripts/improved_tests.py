"""
Improved-test case definitions per problem.

Each entry: list of (description, expr) tuples where expr evaluates to a boolean
assertion result. The generator wraps each tuple into a JUnit @Test method.

Notation:
  - `sut.<method>(args)` invokes the solution under test.
  - Provides equivalence-class partitions + boundary values for each problem.

Equivalence classes / boundary analysis is documented inline near each block so
the improved test acts as living documentation.
"""

# Each problem maps to (block_doc, list of (test_name, java_bool_expr))
IMPROVED = {
    0: ("hasCloseElements: EC = {empty, single, all-equal, no-close, has-close, duplicates}; "
        "Boundary = distance exactly at threshold (closed vs open interval).",
        [
            ("empty_list_returns_false", "!sut.hasCloseElements(Arrays.asList(), 0.5)"),
            ("single_element_no_pair", "!sut.hasCloseElements(Arrays.asList(1.0), 0.5)"),
            ("duplicates_are_close", "sut.hasCloseElements(Arrays.asList(2.0, 2.0), 0.1)"),
            ("exact_threshold_boundary_open", "!sut.hasCloseElements(Arrays.asList(1.0, 1.5), 0.5)"),
            ("just_below_threshold", "sut.hasCloseElements(Arrays.asList(1.0, 1.4999), 0.5)"),
            ("spread_out_no_close", "!sut.hasCloseElements(Arrays.asList(1.0, 5.0, 10.0), 0.5)"),
            ("all_equal_close", "sut.hasCloseElements(Arrays.asList(3.0, 3.0, 3.0), 0.001)"),
            ("negative_threshold_trivially_false", "!sut.hasCloseElements(Arrays.asList(1.0, 1.1), -0.1)"),
        ]),

    3: ("belowZero: EC = {empty, always-positive, goes-negative, returns-to-positive, "
        "ends-exactly-zero}; Boundary = transient -1 vs +1 balance.",
        [
            ("empty_balance_never_negative", "!sut.belowZero(Arrays.asList())"),
            ("single_positive", "!sut.belowZero(Arrays.asList(10))"),
            ("single_negative_goes_below", "sut.belowZero(Arrays.asList(-1))"),
            ("net_positive_but_dips_below", "sut.belowZero(Arrays.asList(1, -5, 10))"),
            ("always_stays_at_zero_boundary", "!sut.belowZero(Arrays.asList(1, -1, 1, -1))"),
            ("net_negative_but_never_below", "!sut.belowZero(Arrays.asList(5, -2, -2))"),
        ]),

    7: ("filterBySubstring: EC = {empty list, empty substring, no matches, all match, "
        "case-sensitive}; Boundary = substring equals candidate exactly.",
        [
            ("empty_list_returns_empty", "sut.filterBySubstring(Arrays.asList(), \"a\").isEmpty()"),
            ("empty_substring_matches_all", "sut.filterBySubstring(Arrays.asList(\"x\", \"y\"), \"\").size() == 2"),
            ("no_match_returns_empty", "sut.filterBySubstring(Arrays.asList(\"abc\"), \"xyz\").isEmpty()"),
            ("exact_match_included", "sut.filterBySubstring(Arrays.asList(\"abc\"), \"abc\").size() == 1"),
            ("case_sensitive", "sut.filterBySubstring(Arrays.asList(\"ABC\"), \"abc\").isEmpty()"),
            ("substring_at_start", "sut.filterBySubstring(Arrays.asList(\"catfish\"), \"cat\").size() == 1"),
            ("substring_at_end", "sut.filterBySubstring(Arrays.asList(\"scat\"), \"cat\").size() == 1"),
        ]),

    9: ("rollingMax: EC = {empty, single, strictly ascending, strictly descending, all-equal, mixed}. "
        "Boundary = Integer.MIN_VALUE at start.",
        [
            ("empty_returns_empty", "sut.rollingMax(Arrays.asList()).isEmpty()"),
            ("single_element", "sut.rollingMax(Arrays.asList(5)).equals(Arrays.asList(5))"),
            ("ascending_stays_ascending", "sut.rollingMax(Arrays.asList(1, 2, 3)).equals(Arrays.asList(1, 2, 3))"),
            ("descending_plateaus_at_first", "sut.rollingMax(Arrays.asList(3, 2, 1)).equals(Arrays.asList(3, 3, 3))"),
            ("all_equal", "sut.rollingMax(Arrays.asList(7, 7, 7)).equals(Arrays.asList(7, 7, 7))"),
            ("min_value_boundary", "sut.rollingMax(Arrays.asList(Integer.MIN_VALUE, 0)).equals(Arrays.asList(Integer.MIN_VALUE, 0))"),
            ("negative_numbers", "sut.rollingMax(Arrays.asList(-3, -5, -1)).equals(Arrays.asList(-3, -3, -1))"),
        ]),

    10: ("makePalindrome: EC = {empty, already palindrome, single char, no palindromic suffix, suffix "
         "only the last char}. Boundary = 1-char suffix.",
         [
             ("empty_returns_empty", "sut.makePalindrome(\"\").equals(\"\")"),
             ("single_char_is_palindrome", "sut.makePalindrome(\"x\").equals(\"x\")"),
             ("already_palindrome", "sut.makePalindrome(\"aba\").equals(\"aba\")"),
             ("cat_extends_to_catac", "sut.makePalindrome(\"cat\").equals(\"catac\")"),
             ("cata_extends_to_catac", "sut.makePalindrome(\"cata\").equals(\"catac\")"),
             ("palindromic_suffix", "sut.makePalindrome(\"aabb\").equals(\"aabbaa\")"),
         ]),

    11: ("stringXor: EC = {both empty, equal length 1, equal length N, all-0, all-1, alternating}.",
         [
             ("both_empty", "sut.stringXor(\"\", \"\").equals(\"\")"),
             ("single_zero_zero", "sut.stringXor(\"0\", \"0\").equals(\"0\")"),
             ("single_zero_one", "sut.stringXor(\"0\", \"1\").equals(\"1\")"),
             ("single_one_one", "sut.stringXor(\"1\", \"1\").equals(\"0\")"),
             ("all_match_returns_zeros", "sut.stringXor(\"1010\", \"1010\").equals(\"0000\")"),
             ("alternating", "sut.stringXor(\"1010\", \"0101\").equals(\"1111\")"),
             ("mixed_case", "sut.stringXor(\"111000\", \"101010\").equals(\"010010\")"),
         ]),

    12: ("longest: EC = {empty, single, distinct lengths, tied lengths (first wins)}.",
         [
             ("empty_returns_empty_optional", "!sut.longest(Arrays.asList()).isPresent()"),
             ("single_item", "sut.longest(Arrays.asList(\"abc\")).get().equals(\"abc\")"),
             ("distinct_lengths_longest_wins", "sut.longest(Arrays.asList(\"a\", \"bb\", \"ccc\")).get().equals(\"ccc\")"),
             ("tied_length_first_wins", "sut.longest(Arrays.asList(\"aa\", \"bb\", \"cc\")).get().equals(\"aa\")"),
             ("tied_with_longer_elsewhere", "sut.longest(Arrays.asList(\"aa\", \"bbb\", \"ccc\")).get().equals(\"bbb\")"),
         ]),

    14: ("allPrefixes: EC = {empty, length-1, length-N}. Boundary: verify size == input length.",
         [
             ("empty_returns_empty", "sut.allPrefixes(\"\").isEmpty()"),
             ("length_one", "sut.allPrefixes(\"a\").equals(Arrays.asList(\"a\"))"),
             ("length_three_count", "sut.allPrefixes(\"abc\").size() == 3"),
             ("length_three_order", "sut.allPrefixes(\"abc\").equals(Arrays.asList(\"a\", \"ab\", \"abc\"))"),
             ("repeated_chars", "sut.allPrefixes(\"aa\").equals(Arrays.asList(\"a\", \"aa\"))"),
         ]),

    15: ("stringSequence: EC = {n=0 smallest boundary, n=1, typical, large n}. Format: space-separated.",
         [
             ("n_zero_just_zero", "sut.stringSequence(0).equals(\"0\")"),
             ("n_one", "sut.stringSequence(1).equals(\"0 1\")"),
             ("n_five", "sut.stringSequence(5).equals(\"0 1 2 3 4 5\")"),
             ("n_has_right_count", "sut.stringSequence(10).split(\" \").length == 11"),
         ]),

    17: ("parseMusic: EC = {empty string, all whole notes, all half, all quarter, mixed}. Boundary: empty.",
         [
             ("empty_returns_empty_list", "sut.parseMusic(\"\").isEmpty()"),
             ("single_whole_note", "sut.parseMusic(\"o\").equals(Arrays.asList(4))"),
             ("single_half_note", "sut.parseMusic(\"o|\").equals(Arrays.asList(2))"),
             ("single_quarter_note", "sut.parseMusic(\".|\").equals(Arrays.asList(1))"),
             ("mixed_pattern", "sut.parseMusic(\"o o| .|\").equals(Arrays.asList(4, 2, 1))"),
             ("all_quarter", "sut.parseMusic(\".| .| .|\").equals(Arrays.asList(1, 1, 1))"),
         ]),

    18: ("howManyTimes: EC = {empty string, empty substring (zero by convention), no match, single match, "
         "overlapping matches, substring longer than string}.",
         [
             ("empty_string_zero", "sut.howManyTimes(\"\", \"a\") == 0"),
             ("empty_substring_matches_every_position", "sut.howManyTimes(\"abc\", \"\") == 4"),
             ("no_match_zero", "sut.howManyTimes(\"abc\", \"xyz\") == 0"),
             ("single_match", "sut.howManyTimes(\"hello\", \"ell\") == 1"),
             ("overlapping_aaa_a_three", "sut.howManyTimes(\"aaa\", \"a\") == 3"),
             ("overlapping_aaaa_aa_three", "sut.howManyTimes(\"aaaa\", \"aa\") == 3"),
             ("substring_longer_zero", "sut.howManyTimes(\"ab\", \"abc\") == 0"),
             ("full_string_match", "sut.howManyTimes(\"abc\", \"abc\") == 1"),
         ]),

    21: ("rescaleToUnit: EC = {already [0,1], negative range, constant shift, contains max/min at extremes}. "
         "Boundary: min and max endpoints → 0.0 and 1.0.",
         [
             ("two_elements_become_zero_and_one", "sut.rescaleToUnit(Arrays.asList(0.0, 10.0)).equals(Arrays.asList(0.0, 1.0))"),
             ("min_becomes_zero", "sut.rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0)).get(0) == 0.0"),
             ("max_becomes_one", "sut.rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0)).get(2) == 1.0"),
             ("middle_is_half", "Math.abs(sut.rescaleToUnit(Arrays.asList(1.0, 2.0, 3.0)).get(1) - 0.5) < 1e-9"),
             ("negative_range_normalised", "sut.rescaleToUnit(Arrays.asList(-5.0, 5.0)).equals(Arrays.asList(0.0, 1.0))"),
         ]),

    23: ("strlen: EC = {empty, single, ascii, unicode surrogate, whitespace-only}. Boundary: \"\".",
         [
             ("empty_is_zero", "sut.strlen(\"\") == 0"),
             ("single_char", "sut.strlen(\"a\") == 1"),
             ("typical", "sut.strlen(\"hello\") == 5"),
             ("whitespace_counts", "sut.strlen(\"   \") == 3"),
             ("mixed_case", "sut.strlen(\"AbC\") == 3"),
             ("newline_counts", "sut.strlen(\"a\\nb\") == 3"),
         ]),

    24: ("largestDivisor: EC = {n=1 -> 1 by contract, n=prime -> 1, n=composite -> n/smallestFactor, "
         "n=power of two}. Boundary: n=1.",
         [
             ("n_one_returns_one", "sut.largestDivisor(1) == 1"),
             ("n_two_is_prime_returns_one", "sut.largestDivisor(2) == 1"),
             ("n_composite_15_returns_5", "sut.largestDivisor(15) == 5"),
             ("n_power_of_two", "sut.largestDivisor(16) == 8"),
             ("n_even_prime_even_divisor", "sut.largestDivisor(100) == 50"),
         ]),

    25: ("factorize: EC = {n=2 smallest prime, prime n, composite n, power of prime, many distinct primes}. "
         "Boundary: n=2.",
         [
             ("n_two_single_factor", "sut.factorize(2).equals(Arrays.asList(2))"),
             ("prime_returns_self", "sut.factorize(7).equals(Arrays.asList(7))"),
             ("power_of_prime", "sut.factorize(8).equals(Arrays.asList(2, 2, 2))"),
             ("distinct_primes", "sut.factorize(30).equals(Arrays.asList(2, 3, 5))"),
             ("repeated_and_distinct", "sut.factorize(12).equals(Arrays.asList(2, 2, 3))"),
             ("big_composite", "sut.factorize(100).equals(Arrays.asList(2, 2, 5, 5))"),
         ]),

    27: ("flipCase: EC = {empty, all-upper, all-lower, mixed, digits/symbols untouched}.",
         [
             ("empty_empty", "sut.flipCase(\"\").equals(\"\")"),
             ("all_upper_to_lower", "sut.flipCase(\"ABC\").equals(\"abc\")"),
             ("all_lower_to_upper", "sut.flipCase(\"xyz\").equals(\"XYZ\")"),
             ("mixed", "sut.flipCase(\"Hello\").equals(\"hELLO\")"),
             ("digits_unchanged", "sut.flipCase(\"123\").equals(\"123\")"),
             ("symbols_unchanged", "sut.flipCase(\"!@#\").equals(\"!@#\")"),
             ("mixed_with_digits", "sut.flipCase(\"aB3\").equals(\"Ab3\")"),
         ]),

    28: ("concatenate: EC = {empty list, single, many, empty strings interleaved}.",
         [
             ("empty_list_empty_string", "sut.concatenate(Arrays.asList()).equals(\"\")"),
             ("single_item", "sut.concatenate(Arrays.asList(\"abc\")).equals(\"abc\")"),
             ("two_items", "sut.concatenate(Arrays.asList(\"a\", \"b\")).equals(\"ab\")"),
             ("with_empty_strings", "sut.concatenate(Arrays.asList(\"\", \"a\", \"\")).equals(\"a\")"),
             ("all_empty", "sut.concatenate(Arrays.asList(\"\", \"\", \"\")).equals(\"\")"),
         ]),

    31: ("isPrime: EC = {n<2 false, n=2 true, small odd primes, even composites, odd composites, perfect squares}. "
         "Boundary: n=0, n=1, n=2, n=3.",
         [
             ("zero_not_prime", "!sut.isPrime(0)"),
             ("one_not_prime", "!sut.isPrime(1)"),
             ("two_is_prime", "sut.isPrime(2)"),
             ("three_is_prime", "sut.isPrime(3)"),
             ("four_not_prime", "!sut.isPrime(4)"),
             ("nine_not_prime", "!sut.isPrime(9)"),
             ("twentyfive_not_prime", "!sut.isPrime(25)"),
             ("seventeen_is_prime", "sut.isPrime(17)"),
             ("hundred_and_one_is_prime", "sut.isPrime(101)"),
             ("negative_not_prime", "!sut.isPrime(-7)"),
         ]),

    34: ("unique: EC = {empty, all-unique, all-same, duplicates scattered}. Output is sorted ascending.",
         [
             ("empty_returns_empty", "sut.unique(Arrays.asList()).isEmpty()"),
             ("all_unique_sorted", "sut.unique(Arrays.asList(3, 1, 2)).equals(Arrays.asList(1, 2, 3))"),
             ("duplicates_removed", "sut.unique(Arrays.asList(1, 1, 2, 2, 3)).equals(Arrays.asList(1, 2, 3))"),
             ("all_same_returns_singleton", "sut.unique(Arrays.asList(5, 5, 5)).equals(Arrays.asList(5))"),
             ("negatives_and_positives", "sut.unique(Arrays.asList(-1, -2, -1, 0)).equals(Arrays.asList(-2, -1, 0))"),
         ]),

    35: ("maxElement: EC = {single, ascending, descending, all-equal, negatives, min at ends}.",
         [
             ("single", "sut.maxElement(Arrays.asList(5)) == 5"),
             ("at_start", "sut.maxElement(Arrays.asList(9, 1, 2)) == 9"),
             ("at_end", "sut.maxElement(Arrays.asList(1, 2, 9)) == 9"),
             ("in_middle", "sut.maxElement(Arrays.asList(1, 9, 2)) == 9"),
             ("all_equal", "sut.maxElement(Arrays.asList(4, 4, 4)) == 4"),
             ("negatives", "sut.maxElement(Arrays.asList(-3, -1, -2)) == -1"),
         ]),

    40: ("triplesSumToZero: EC = {<3 elements false, valid triple exists, no triple, triple using negatives}. "
         "Boundary: exactly 3 elements summing to zero.",
         [
             ("too_few_false", "!sut.triplesSumToZero(Arrays.asList(1, 2))"),
             ("exactly_three_summing_zero", "sut.triplesSumToZero(Arrays.asList(1, 2, -3))"),
             ("exactly_three_not_summing_zero", "!sut.triplesSumToZero(Arrays.asList(1, 2, 3))"),
             ("five_elements_with_triple", "sut.triplesSumToZero(Arrays.asList(1, 3, -2, 1, 5))"),
             ("all_positive_no_triple", "!sut.triplesSumToZero(Arrays.asList(1, 2, 3, 4))"),
             ("three_zeros", "sut.triplesSumToZero(Arrays.asList(0, 0, 0))"),
         ]),

    42: ("incrList: EC = {empty, single, negatives, zeros, positives, mixed}. Preserves order.",
         [
             ("empty", "sut.incrList(Arrays.asList()).isEmpty()"),
             ("single", "sut.incrList(Arrays.asList(5)).equals(Arrays.asList(6))"),
             ("negatives_to_zero", "sut.incrList(Arrays.asList(-1)).equals(Arrays.asList(0))"),
             ("mixed", "sut.incrList(Arrays.asList(-1, 0, 1)).equals(Arrays.asList(0, 1, 2))"),
             ("preserves_order", "sut.incrList(Arrays.asList(3, 1, 2)).equals(Arrays.asList(4, 2, 3))"),
         ]),

    47: ("median: EC = {odd length, even length, all same, negatives}. Boundary: 1-element list.",
         [
             ("single_element", "sut.median(Arrays.asList(7)) == 7.0"),
             ("odd_length", "sut.median(Arrays.asList(3, 1, 2, 4, 5)) == 3.0"),
             ("even_length", "sut.median(Arrays.asList(1, 2, 3, 4)) == 2.5"),
             ("negatives_mixed_sorted_yields_8", "sut.median(Arrays.asList(-10, 4, 6, 1000, 10, 20)) == 8.0"),
             ("all_same", "sut.median(Arrays.asList(5, 5, 5, 5)) == 5.0"),
         ]),

    55: ("fib: EC = {n=0, n=1, small n, medium n}. Boundary: 0,1 base cases.",
         [
             ("base_zero", "sut.fib(0) == 0"),
             ("base_one", "sut.fib(1) == 1"),
             ("two", "sut.fib(2) == 1"),
             ("seven", "sut.fib(7) == 13"),
             ("ten", "sut.fib(10) == 55"),
         ]),

    72: ("willItFly: EC = {not palindrome fails, palindrome with sum<=w, palindrome with sum>w, single element}. "
         "Boundary: sum exactly == w.",
         [
             ("not_palindrome_false", "!sut.willItFly(Arrays.asList(1, 2), 5)"),
             ("palindrome_and_light_true", "sut.willItFly(Arrays.asList(3, 2, 3), 9)"),
             ("palindrome_but_heavy_false", "!sut.willItFly(Arrays.asList(3, 2, 3), 1)"),
             ("single_element_always_palindrome", "sut.willItFly(Arrays.asList(3), 5)"),
             ("exact_weight_boundary", "sut.willItFly(Arrays.asList(1, 2, 1), 4)"),
             ("just_over_weight", "!sut.willItFly(Arrays.asList(1, 2, 1), 3)"),
         ]),

    83: ("startsOneEnds: EC = {n=1 single 1 exception, n=2, medium n}. Formula: 18 * 10^(n-2) for n>=2.",
         [
             ("n_equals_one", "sut.startsOneEnds(1) == 1"),
             ("n_equals_two", "sut.startsOneEnds(2) == 18"),
             ("n_equals_three", "sut.startsOneEnds(3) == 180"),
             ("n_equals_four", "sut.startsOneEnds(4) == 1800"),
         ]),

    109: ("moveOneBall: EC = {empty true, already sorted true, single rotation sorts it, cannot be sorted, "
          "reverse order cannot}. Boundary: empty and single-element.",
          [
              ("empty_true", "sut.moveOneBall(Arrays.asList())"),
              ("single_true", "sut.moveOneBall(Arrays.asList(1))"),
              ("already_sorted_true", "sut.moveOneBall(Arrays.asList(1, 2, 3))"),
              ("rotated_true", "sut.moveOneBall(Arrays.asList(3, 4, 5, 1, 2))"),
              ("unsortable_false", "!sut.moveOneBall(Arrays.asList(3, 5, 4, 1, 2))"),
              ("descending_false", "!sut.moveOneBall(Arrays.asList(5, 4, 3, 2, 1))"),
          ]),

    126: ("isSorted: EC = {empty true, single true, strictly ascending true, has strict duplicates true, "
          "has triple duplicates false, descending false}.",
          [
              ("empty_true", "sut.isSorted(Arrays.asList())"),
              ("single_true", "sut.isSorted(Arrays.asList(5))"),
              ("strictly_ascending", "sut.isSorted(Arrays.asList(1, 2, 3))"),
              ("duplicates_pair_allowed", "sut.isSorted(Arrays.asList(1, 2, 2, 3))"),
              ("triple_duplicates_disallowed", "!sut.isSorted(Arrays.asList(1, 2, 2, 2, 3))"),
              ("descending_false", "!sut.isSorted(Arrays.asList(3, 2, 1))"),
          ]),

    132: ("isNested: EC = {empty false, single bracket false, simple pair not nested, "
          "nested [[]] true, siblings not nested}.",
          [
              ("empty_false", "!sut.isNested(\"\")"),
              ("single_opener_false", "!sut.isNested(\"[\")"),
              ("simple_pair_not_nested", "!sut.isNested(\"[]\")"),
              ("true_nesting", "sut.isNested(\"[[]]\")"),
              ("deep_nesting", "sut.isNested(\"[[[[]]]]\")"),
              ("siblings_not_nested", "!sut.isNested(\"[][]\")"),
              ("mixed_nested_and_siblings", "sut.isNested(\"[][][[]]\")"),
              ("unbalanced_openers_only_false", "!sut.isNested(\"[[[[[[[[\")"),
          ]),

    139: ("specialFactorial: n! * (n-1)! * ... * 1!. EC = {n=1 base, n=2, typical, larger}.",
          [
              ("n_equals_one", "sut.specialFactorial(1) == 1"),
              ("n_equals_two", "sut.specialFactorial(2) == 2"),
              ("n_equals_three", "sut.specialFactorial(3) == 12"),
              ("n_equals_four", "sut.specialFactorial(4) == 288"),
              ("n_equals_five", "sut.specialFactorial(5) == 34560"),
          ]),
}
