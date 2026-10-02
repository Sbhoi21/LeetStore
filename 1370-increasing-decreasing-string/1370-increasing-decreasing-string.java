class Solution {
    public String sortString(String s) {

        char[] arr = s.toCharArray();
        int[] freq = new int[26];
        char[] ans = new char[arr.length];
        for (char c : arr) {
            freq[c - 'a']++;
        }

        int i = 0;
        while (i < arr.length) {
            for (int j = 0; j < 26; j++) {
                if (freq[j] > 0) {
                    ans[i++] = (char) ('a' + j);
                    freq[j]--;
                }
            }

            for (int j = 25; j >= 0; j--) {
                if (freq[j] > 0) {
                    ans[i++] = (char) ('a' + j);
                    freq[j]--;
                }
            }
        }
        return new String(ans);
    }
}