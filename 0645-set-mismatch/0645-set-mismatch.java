class Solution {
    public int[] findErrorNums(int[] nums) {
         int n = nums.length;
        int xorSum = 0;

        // Step 1: Compute the XOR of all elements in the array and numbers from 1 to n
        for (int num : nums) {
            xorSum ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xorSum ^= i;
        }

        // Step 2: Find a set bit (rightmost set bit)
        int setBit = xorSum & -xorSum;

        // Step 3: Divide numbers into two groups and compute XOR for each group
        int xorGroup1 = 0, xorGroup2 = 0;
        for (int num : nums) {
            if ((num & setBit) != 0) {
                xorGroup1 ^= num;
            } else {
                xorGroup2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) {
                xorGroup1 ^= i;
            } else {
                xorGroup2 ^= i;
            }
        }

        // Step 4: Determine which is the duplicate and which is the missing number
        for (int num : nums) {
            if (num == xorGroup1) {
                return new int[]{xorGroup1, xorGroup2};
            }
        }
        return new int[]{xorGroup2, xorGroup1};
    }
}