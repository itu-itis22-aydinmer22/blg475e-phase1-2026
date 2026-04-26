/* @Authors
* Student Names: Oğuz Eren Kacar, Mert Aydın, Mehmet Enes Tekgöz
* Student IDs: 150200018, 150220722, 150210089
*/

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Boolean> correct = Arrays.asList(
                Objects.equals(s.makePalindrome(""), ""),
                Objects.equals(s.makePalindrome("x"), "x"),
                Objects.equals(s.makePalindrome("xyz"), "xyzyx"),
                Objects.equals(s.makePalindrome("xyx"), "xyx"),
                Objects.equals(s.makePalindrome("jerry"), "jerryrrej")
        );
        if (correct.contains(false)) {
            throw new AssertionError();
        }
    }
}