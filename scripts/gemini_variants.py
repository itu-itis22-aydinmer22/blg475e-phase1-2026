"""
Alternative Gemini-style implementations for the 30 selected HumanEval problems.

Design philosophy:
- Gemini tends to prefer Java 8+ Streams and functional style.
- Gemini sometimes produces off-by-one errors or mishandles edge cases,
  especially in recursion/boundary conditions.
- Some solutions are intentionally the SAME as canonical (correct).
- A subset (~6-8) have realistic bugs that real LLMs often produce:
  * HE-010 isPalindrome: Gemini often forgets empty string edge
  * HE-040 triplesSumToZero: off-by-one boundary
  * HE-072 willItFly: missing balanced check
  * HE-083 startsOneEnds: wrong formula
  * HE-109 moveOneBall: incorrect rotation check
  * HE-132 isNested: wrong pairing logic
  * HE-139 specialFactorial: off-by-one accumulation

This simulates real-world LLM output divergence and gives the test suite
something meaningful to find during comparison.

The dict maps task index -> body of the method (between { and }).
If an index is missing, fall back to the canonical solution.
"""

GEMINI_BODIES = {
    0: """        return numbers.stream()
                .flatMap(a -> numbers.stream().map(b -> Math.abs(a - b)))
                .filter(d -> d > 0)
                .anyMatch(d -> d < threshold);""",

    3: """        int balance = 0;
        for (Integer op : operations) {
            balance += op;
            if (balance < 0) {
                return true;
            }
        }
        return false;""",

    7: """        List<String> result = new ArrayList<>();
        for (String s : strings) {
            if (s.contains(substring)) result.add(s);
        }
        return result;""",

    9: """        List<Integer> result = new ArrayList<>();
        int currentMax = Integer.MIN_VALUE;
        for (int n : numbers) {
            if (n > currentMax) currentMax = n;
            result.add(currentMax);
        }
        return result;""",

    # HE-010 makePalindrome: Gemini uses stream style but has an off-by-one on the empty-string guard
    10: """        if (string == null || string.isEmpty()) return string;
        int i;
        for (i = 0; i < string.length(); i++) {
            if (isPalindrome(string.substring(i))) break;
        }
        return string + new StringBuilder(string.substring(0, i)).reverse().toString();""",

    11: """        StringBuilder result = new StringBuilder();
        for (int i = 0; i < a.length(); i++) {
            result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
        }
        return result.toString();""",

    12: """        if (strings.isEmpty()) return Optional.empty();
        return strings.stream().max(Comparator.comparingInt(String::length));""",

    14: """        List<String> prefixes = new ArrayList<>();
        for (int i = 1; i <= string.length(); i++) {
            prefixes.add(string.substring(0, i));
        }
        return prefixes;""",

    15: """        return java.util.stream.IntStream.rangeClosed(0, n)
                .mapToObj(Integer::toString)
                .collect(java.util.stream.Collectors.joining(\" \"));""",

    17: """        List<Integer> out = new ArrayList<>();
        if (string.isEmpty()) return out;
        for (String tok : string.split(\" \")) {
            switch (tok) {
                case \"o\": out.add(4); break;
                case \"o|\": out.add(2); break;
                case \".|\": out.add(1); break;
            }
        }
        return out;""",

    18: """        if (substring.isEmpty()) return 0;
        int count = 0;
        for (int i = 0; i <= string.length() - substring.length(); i++) {
            if (string.startsWith(substring, i)) count++;
        }
        return count;""",

    21: """        double min = Collections.min(numbers);
        double max = Collections.max(numbers);
        double range = max - min;
        return numbers.stream().map(n -> (n - min) / range).collect(java.util.stream.Collectors.toList());""",

    23: """        return string.length();""",

    24: """        for (int i = n - 1; i > 0; i--) {
            if (n % i == 0) return i;
        }
        return 1;""",

    25: """        List<Integer> factors = new ArrayList<>();
        int x = n;
        int d = 2;
        while (x > 1) {
            while (x % d == 0) {
                factors.add(d);
                x /= d;
            }
            d++;
        }
        return factors;""",

    27: """        StringBuilder sb = new StringBuilder();
        for (char c : string.toCharArray()) {
            if (Character.isUpperCase(c)) sb.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c)) sb.append(Character.toUpperCase(c));
            else sb.append(c);
        }
        return sb.toString();""",

    28: """        return String.join(\"\", strings);""",

    31: """        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;""",

    34: """        return new ArrayList<>(new java.util.TreeSet<>(l));""",

    35: """        return Collections.max(l);""",

    # HE-040 triplesSumToZero: Gemini bug — uses < instead of <= or misses i,j,k distinct
    40: """        for (int i = 0; i < l.size(); i++) {
            for (int j = i + 1; j < l.size(); j++) {
                for (int k = j + 1; k < l.size() - 1; k++) {
                    if (l.get(i) + l.get(j) + l.get(k) == 0) return true;
                }
            }
        }
        return false;""",

    42: """        return l.stream().map(x -> x + 1).collect(java.util.stream.Collectors.toList());""",

    47: """        List<Integer> sorted = new ArrayList<>(l);
        Collections.sort(sorted);
        int n = sorted.size();
        if (n % 2 == 1) return (double) sorted.get(n / 2);
        return (sorted.get(n / 2 - 1) + sorted.get(n / 2)) / 2.0;""",

    55: """        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);""",

    # HE-072 willItFly: Gemini bug — forgets palindrome check
    72: """        int sum = 0;
        for (int x : q) sum += x;
        return sum <= w;""",

    # HE-083 startsOneEnds: Gemini bug — uses wrong formula (off-by-one exponent)
    83: """        if (n == 1) return 1;
        return (int) Math.pow(10, n - 1);""",

    # HE-109 moveOneBall: Gemini bug — always returns true for non-empty
    109: """        if (arr.isEmpty()) return true;
        int minVal = Collections.min(arr);
        int idx = arr.indexOf(minVal);
        for (int i = 0; i < arr.size() - 1; i++) {
            int cur = arr.get((idx + i) % arr.size());
            int nxt = arr.get((idx + i + 1) % arr.size());
            if (cur > nxt) return false;
        }
        return true;""",

    126: """        for (int i = 0; i < lst.size() - 1; i++) {
            if (lst.get(i) > lst.get(i + 1)) return false;
        }
        Map<Integer, Integer> counts = new HashMap<>();
        for (int x : lst) counts.merge(x, 1, Integer::sum);
        for (int c : counts.values()) if (c > 2) return false;
        return true;""",

    # HE-132 isNested: Gemini bug — counts brackets instead of checking nesting
    132: """        int open = 0, close = 0;
        for (char c : string.toCharArray()) {
            if (c == '[') open++;
            else if (c == ']') close++;
        }
        return open > 1 && close > 1;""",

    # HE-139 specialFactorial: off-by-one
    139: """        long result = 1;
        for (int i = 1; i < n; i++) {
            long fact = 1;
            for (int j = 1; j <= i; j++) fact *= j;
            result *= fact;
        }
        return result;""",
}


# These are the "buggy" ones we expect tests to catch
GEMINI_BUGGY = {10, 40, 72, 83, 109, 132, 139}
