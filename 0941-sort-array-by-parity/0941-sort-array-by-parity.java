class Solution {
    public int[] sortArrayByParity(int[] nums) {
                int j = 0; // Slow pointer
        for (int i = 0; i < nums.length; i++) { // Fast pointer
            if (nums[i] % 2 == 0) {
                // Swap
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        return nums;
    }
}