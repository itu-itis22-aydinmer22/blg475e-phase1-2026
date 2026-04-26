/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                s.specialFactorial(4) == 288,
                s.specialFactorial(5) == 34560,
                s.specialFactorial(7) == 125411328000L,
                s.specialFactorial(1) == 1
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}