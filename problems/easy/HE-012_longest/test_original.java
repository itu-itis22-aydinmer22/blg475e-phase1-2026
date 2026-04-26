/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.longest(new ArrayList<>(List.of())).isEmpty(),
                Objects.equals(s.longest(new ArrayList<>(Arrays.asList("x", "y", "z"))).get(), "x"),
                Objects.equals(s.longest(new ArrayList<>(Arrays.asList("x", "yyy", "zzzz", "www", "kkkk", "abc"))).get(), "zzzz")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}