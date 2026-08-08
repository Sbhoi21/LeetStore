class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] suffix = new int[n + 1];

        int j = m - 1;

        // suffix[i] = how many ending chars of word2 can be matched
        // using word1[i...n-1]
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int idx = 0; // pointer for word2
        boolean changed = false; // whether mismatch is already used

        for (int i = 0; i < n && idx < m; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(idx);

            if (c1 == c2) {
                ans[idx] = i;
                idx++;
            } else if (!changed) {
                int remaining = m - idx - 1;

                // If we use mismatch at current index,
                // remaining characters must match exactly later.
                if (suffix[i + 1] >= remaining) {
                    ans[idx] = i;
                    idx++;
                    changed = true;
                }
            }
        }

        if (idx == m) {
            return ans;
        }

        return new int[0];
    }
}