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
        for (int i = n - 1; i >= 0; i--) {
            result[n - i -1] = xorSum ^ ((1 << maximumBit) - 1);
            xorSum ^= nums[i];
        }

        return result;
    }
}