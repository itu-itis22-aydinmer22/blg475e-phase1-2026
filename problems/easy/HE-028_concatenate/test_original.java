/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.concatenate(new ArrayList<>(List.of())), ""),
                Objects.equals(s.concatenate(new ArrayList<>(Arrays.asList("x", "y", "z"))), "xyz"),
                Objects.equals(s.concatenate(new ArrayList<>(Arrays.asList("x", "y", "z", "w", "k"))), "xyzwk")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}