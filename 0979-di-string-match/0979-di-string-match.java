class Solution {
    public int[] diStringMatch(String s) {
            int n = s.length();
        int[] result = new int[n + 1];
        int low = 0, high = n;

        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'I') {
                result[i] = low++;
            } else {
                result[i] = high--;
            }
        }
        result[n] = low; // or high, both are same here
        return result;
    }
}