class Solution {
public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int n = s.length();
        int i = 0;

        while (i < n) {
            // Skip spaces
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }
            if (i >= n) break;

            // Find the end of the word
            int j = i;
            while (j < n && s.charAt(j) != ' ') {
                j++;
            }

            // Reverse the word and append to result
            for (int k = j - 1; k >= i; k--) {
                result.append(s.charAt(k));
            }
            result.append(' ');

            // Move to the next word
            i = j;
        }

        // Remove trailing space if exists
        if (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.toString();
    }
}