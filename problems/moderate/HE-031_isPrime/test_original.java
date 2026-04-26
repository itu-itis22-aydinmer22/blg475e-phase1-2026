/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                !s.isPrime(6),
                s.isPrime(101),
                s.isPrime(11),
                s.isPrime(13441),
                s.isPrime(61),
                !s.isPrime(4),
                !s.isPrime(1),
                s.isPrime(5),
                s.isPrime(11),
                s.isPrime(17),
                !s.isPrime(5 * 17),
                !s.isPrime(11 * 7),
                !s.isPrime(13441 * 19)
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}