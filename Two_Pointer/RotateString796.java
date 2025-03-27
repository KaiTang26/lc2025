package Two_Pointer;

public class RotateString796 {

    public boolean rotateString(String s, String goal) {

        if (s.equals(goal)) {
            return true;
        }

        for (int offset = 0; offset < s.length(); offset++) {

            if (offset < s.length()) {
                String firstPart = s.substring(0, offset);
                String secondPart = s.substring(offset);

                String reversedFirstPart = new StringBuilder(firstPart).reverse().toString();

                String reversedSecondPart = new StringBuilder(secondPart).reverse().toString();

                String rolatedS = new StringBuilder(reversedFirstPart + reversedSecondPart).reverse().toString();

                if (rolatedS.equals(goal)) {
                    return true;
                }

            }

        }

        return false;

    }

}
