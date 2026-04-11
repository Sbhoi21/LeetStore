class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[][] last = new int[n + 1][2];
        int[] count = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            last[i][0] = -1;
            last[i][1] = -1;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int val = nums[i];

            if (count[val] >= 2) {
                ans = Math.min(ans, 2 * (i - last[val][0]));
            }

            // shift last two indices
            last[val][0] = last[val][1];
            last[val][1] = i;
            count[val]++;
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}