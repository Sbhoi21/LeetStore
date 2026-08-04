class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        int i1 = 0, i2 = 0;
        while (i1 < n) {
            ans[i2++] = nums[i1];
            ans[i2] = nums[i1 + n];
            i2++;
            i1++;
        }
        return ans;
    }
}