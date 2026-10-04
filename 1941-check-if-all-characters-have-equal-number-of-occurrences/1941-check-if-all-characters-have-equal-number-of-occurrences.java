class Solution {
    public boolean areOccurrencesEqual(String s) {

        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        int c = arr[s.charAt(0) - 'a'];
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0 && c != arr[i]) return false; 
        }
        return true;
    }
}