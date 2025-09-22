class Solution {
    public String sortString(String s) {
                int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        boolean ascending = true;

        while (result.length() < s.length()) {
            if (ascending) {
                for (int i = 0; i < 26; i++) {
                    if (charCount[i] > 0) {
                        result.append((char) (i + 'a'));
                        charCount[i]--;
                    }
                }
            } else {
                for (int i = 25; i >= 0; i--) {
                    if (charCount[i] > 0) {
                        result.append((char) (i + 'a'));
                        charCount[i]--;
                    }
                }
            }
            ascending = !ascending;
        }

        return result.toString();
    }
}