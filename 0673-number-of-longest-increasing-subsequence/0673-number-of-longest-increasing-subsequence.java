class Solution {
    public int findNumberOfLIS(int[] nums) {
                if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = 1; // Each element is a subsequence of length 1
            count[i] = 1; // Each element has one way to form a subsequence

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; // Reset count to count[j]
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j]; // Add the number of ways
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLength) {
                totalCount += count[i];
            }
        }

        return totalCount;
    }
}