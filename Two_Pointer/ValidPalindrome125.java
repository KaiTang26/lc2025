package Two_Pointer;

public class ValidPalindrome125 {

    public static void main(String[] args) {
        ValidPalindrome125 v = new ValidPalindrome125();

        System.out.println(v.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start < s.length() && end > 0 && start < end) {

            while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start))) {

                start++;
            }

            while (end > 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (start < s.length() && end > 0
                    && Character.toLowerCase(s.charAt(end)) != Character.toLowerCase(s.charAt(start))) {
                return false;
            } else {
                start++;
                end--;
            }

        }

        return true;

    }

    private boolean isAlphaChar(char c) {

        return Character.isLetterOrDigit(c);

    }

}
