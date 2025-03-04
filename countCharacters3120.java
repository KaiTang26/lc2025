import java.util.HashSet;
import java.util.Set;

public class countCharacters3120 {

    public int numberOfSpecialChars(String word) {
        int count = 0;

        Set<Character> charSet = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!charSet.contains(c)) {
                charSet.add(c);
            } else {
                continue;
            }

            if (Character.isLowerCase(c) && charSet.contains(Character.toUpperCase(c))) {
                count++;
            }

            if (Character.isUpperCase(c) && charSet.contains(Character.toLowerCase(c))) {
                count++;
            }
        }

        return count;

        
    }

    public int numberOfSpecialChars2(String word) {
        // Create separate sets for lowercase and uppercase characters
        Set<Character> lowercase = new HashSet<>();
        Set<Character> uppercase = new HashSet<>();
        
        // Populate the sets
        for (char c : word.toCharArray()) {
            if (Character.isLowerCase(c)) {
                lowercase.add(c);
            } else if (Character.isUpperCase(c)) {
                uppercase.add(c);
            }
        }
        
        // Count special characters
        int count = 0;
        for (char c : lowercase) {
            // For each lowercase letter, check if its uppercase version exists
            if (uppercase.contains(Character.toUpperCase(c))) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        // Test cases
        String[] testCases = {
            "aaAbcBC",  // Expected: 3
            "abc",      // Expected: 0
            "abBCab"    // Expected: 1
        };
        
        countCharacters3120 solution = new countCharacters3120();
        for (String test : testCases) {
            System.out.println("Input: \"" + test + "\" -> Output: " + 
                              solution.numberOfSpecialChars(test));
        }
    }
}
