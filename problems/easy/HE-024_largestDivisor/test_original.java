/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.largestDivisor(3) == 1,
                s.largestDivisor(7) == 1,
                s.largestDivisor(10) == 5,
                s.largestDivisor(100) == 50,
                s.largestDivisor(49) == 7
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}