/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.flipCase(""), ""),
                Objects.equals(s.flipCase("Hello!"), "hELLO!"),
                Objects.equals(s.flipCase("These violent delights have violent ends"), "tHESE VIOLENT DELIGHTS HAVE VIOLENT ENDS")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}