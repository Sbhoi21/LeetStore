class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[][] last = new int[n + 1][2];
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (last[val][0] != 0) {
                ans = Math.min(ans, 2 * (i - last[val][0] +1));
            }

            // shift last two indices
            last[val][0] = last[val][1];
            last[val][1] = i+1;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}