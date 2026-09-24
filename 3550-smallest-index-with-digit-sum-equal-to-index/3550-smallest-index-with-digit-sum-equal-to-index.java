class Solution {
    public int smallestIndex(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int sum = n % 10;
            while (n / 10 != 0) {
                n = n / 10;
                sum += n % 10;
            }

            if (sum == i) {
                return i;
            }

        }

        return -1;
    }

}