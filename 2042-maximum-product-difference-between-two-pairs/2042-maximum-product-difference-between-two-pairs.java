class Solution {
    public int maxProductDifference(int[] nums) {
                java.util.Arrays.sort(nums);

        // Calculate the product of the two largest numbers
        int maxProduct = nums[nums.length - 1] * nums[nums.length - 2];

        // Calculate the product of the two smallest numbers
        int minProduct = nums[0] * nums[1];

        // Return the difference between the two products
        return maxProduct - minProduct;
    }
}