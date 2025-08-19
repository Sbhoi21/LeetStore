class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
                int n = nums.length;
        int[] result = new int[n];
        int xorSum = 0;

        // Calculate the total XOR of the array
        for (int num : nums) {
            xorSum ^= num;
        }

        // Calculate the maximum XOR for each query
        for (int i = 0; i < n; i++) {
            result[i] = xorSum ^ ((1 << maximumBit) - 1);
            xorSum ^= nums[n - i -1];
        }

        return result;
    }
}