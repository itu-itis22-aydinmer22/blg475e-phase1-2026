/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.filterBySubstring(new ArrayList<>(List.of()), "john").equals(List.of()),
                s.filterBySubstring(new ArrayList<>(Arrays.asList("xxx", "asd", "xxy", "john doe", "xxxAAA", "xxx")), "xxx").equals(Arrays.asList("xxx", "xxxAAA", "xxx")),
                s.filterBySubstring(new ArrayList<>(Arrays.asList("xxx", "asd", "aaaxxy", "john doe", "xxxAAA", "xxx")), "xx").equals(Arrays.asList("xxx", "aaaxxy", "xxxAAA", "xxx")),
                s.filterBySubstring(new ArrayList<>(Arrays.asList("grunt", "trumpet", "prune", "gruesome")), "run").equals(Arrays.asList("grunt", "prune"))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}