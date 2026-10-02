class Solution {
    public int balancedStringSplit(String s) {

        int i = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                i++;
            } else {
                i--;
            }
            if (i == 0) {
                ans++;
            }
        }
        return ans;

    }
}