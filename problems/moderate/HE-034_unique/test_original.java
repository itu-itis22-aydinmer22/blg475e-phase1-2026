/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.unique(new ArrayList<>(Arrays.asList(5, 3, 5, 2, 3, 3, 9, 0, 123))).equals(Arrays.asList(0, 2, 3, 5, 9, 123))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}