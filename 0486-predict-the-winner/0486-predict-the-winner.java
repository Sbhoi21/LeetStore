class Solution {
    public boolean predictTheWinner(int[] nums) {
        int[][] dp = new int[21][21];
        return solve(nums, 0, nums.length - 1, dp) >= 0;
    }

    int solve(int[] nums, int i, int j, int[][] dp) {

        if (i == j)
            return nums[i];

        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        int left = nums[i] - solve(nums, i+1, j, dp);
        int right = nums[j] - solve(nums, i, j-1, dp);

        dp[i][j] = Math.max(left, right);
        return dp[i][j];
    }

}