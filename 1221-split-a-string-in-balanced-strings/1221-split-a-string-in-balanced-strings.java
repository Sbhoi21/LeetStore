class Solution {
    public int balancedStringSplit(String s) {

        char[] arr = new char[s.length()];
        char cs = 'A';
        int i = 0;
        int ans = 0;
        for (char c : s.toCharArray()) {
            if (i == 0)
                cs = c;
            if (c == cs) {
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