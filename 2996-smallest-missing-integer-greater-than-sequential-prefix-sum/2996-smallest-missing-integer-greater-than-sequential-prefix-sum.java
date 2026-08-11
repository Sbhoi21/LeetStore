class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
                i++;
                continue;
            }
            break;
        }

        while (true) {
            boolean found = false;
            for (int n : nums) {
                if (n == sum) {
                    found = true;
                }
            }
            if (!found) return sum;
            sum++;

        }
    }
}