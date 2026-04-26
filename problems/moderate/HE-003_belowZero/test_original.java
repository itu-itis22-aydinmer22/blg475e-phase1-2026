/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.belowZero(new ArrayList<>(Arrays.asList())),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -3, 1, 2, -3))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, 2, -4, 5, 6))),
                !s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -4))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -1, 2, -2, 5, -5, 4, -5))),
                s.belowZero(new ArrayList<>(Arrays.asList(1, -2, 2, -2, 5, -5, 4, -4)))
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}