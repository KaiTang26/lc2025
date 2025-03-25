package DFS;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning131 {

    public static void main(String[] args) {

        String s = "aab";

        PalindromePartitioning131 p = new PalindromePartitioning131();

        System.out.print(p.partition(s).toString());

    }

    public List<List<String>> partition(String s) {

        List<List<String>> results = new ArrayList<>();
        if (s == null) {
            return results;
        }

        helper(s, 0, new ArrayList<>(), results);

        return results;
    }

    private void helper(String s, int startIndex, List<String> subset, List<List<String>> results) {

        if (startIndex == s.length()) {
            results.add(new ArrayList<>(subset));
            return;
        }

        for (int i = startIndex; i < s.length(); i++) {

            String subString = s.substring(startIndex, i + 1);

            if (!isPalindrome(subString)) {
                continue;
            }

            subset.add(subString);

            helper(s, i + 1, subset, results);

            subset.remove(subset.size() - 1);

        }

    }

    private boolean isPalindrome(String subString) {

        int start = 0;
        int end = subString.length() - 1;

        while (start >= 0 && end < subString.length() && start <= end) {

            System.out.println(start);
            System.out.println(end);
            System.out.println("*************");

            char sC = subString.charAt(start);
            char eC = subString.charAt(end);

            if (sC != eC) {
                return false;
            } else {
                start++;
                end--;
            }

        }

        return true;

    }

}
