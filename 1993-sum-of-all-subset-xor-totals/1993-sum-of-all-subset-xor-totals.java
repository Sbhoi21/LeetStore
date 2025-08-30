class Solution {
    public int subsetXORSum(int[] arr) {
        int n = arr.length;
        int totalSubsets = 1 << n; // 2^n subsets
        int totalXorSum = 0;

        for (int subsetMask = 0; subsetMask < totalSubsets; subsetMask++) {
            int currentXor = 0;
            for (int j = 0; j < n; j++) {
                if ((subsetMask & (1 << j)) != 0) {
                    currentXor ^= arr[j];
                }
            }
            totalXorSum += currentXor;
        }

        return totalXorSum;
    }
}