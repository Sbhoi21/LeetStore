class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxAns = 0;
        int ans = 0;
        for (int i : nums) {
            if (i == 1)
                ans++;
            else
                ans = 0;
            maxAns = Math.max(maxAns, ans);
        }
        return maxAns;
    }
}