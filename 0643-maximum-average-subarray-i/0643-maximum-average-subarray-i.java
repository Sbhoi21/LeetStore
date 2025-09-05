class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        double maxSum = 0;
        // Calculate the sum of the first 'k' elements
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        double currentSum = maxSum;
        // Use sliding window to find the maximum sum of any subarray of size 'k'
        for (int i = k; i < nums.length; i++) {
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k; // Return the maximum average
    }
}