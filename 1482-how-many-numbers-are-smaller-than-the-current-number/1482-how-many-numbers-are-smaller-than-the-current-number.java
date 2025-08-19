class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
                int n = nums.length;
        int[] result = new int[n];
        int[] count = new int[101]; // Since nums[i] is in the range [0, 100]

        // Count occurrences of each number
        for (int num : nums) {
            count[num]++;
        }

        // Calculate the prefix sum to find how many numbers are smaller
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // Fill the result array
        for (int i = 0; i < n; i++) {
            result[i] = nums[i] == 0 ? 0 : count[nums[i] - 1];
        }

        return result;
    }
}