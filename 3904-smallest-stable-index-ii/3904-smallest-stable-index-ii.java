class Solution {
    public int firstStableIndex(int[] nums, int k) {

        // int n = nums.length;
        // int[] min = new int[n];
        // int[] max = new int[n];
        // int minNo = nums[n - 1], maxNo = nums[0];
        // for (int i = 0; i < n; i++) {
        //     maxNo = Math.max(nums[i], maxNo);
        //     max[i] = maxNo;
        //     minNo = Math.min(nums[n - i - 1], minNo);
        //     min[n - i - 1] = minNo;
        // }

        // for (int i = 0; i < n; i++) {

        //     if (max[i] - min[i] <= k) {
        //         return i;
        //     }

        // }

        // return -1;

        int n = nums.length;
        int[] min = new int[n];
        int minNo = nums[n - 1], maxNo = nums[0];
        for (int i = n - 1; i >= 0; i--) {
            minNo = Math.min(nums[i], minNo);
            min[i] = minNo;
        }

        for (int i = 0; i < n; i++) {
            maxNo = Math.max(nums[i], maxNo);
            if (maxNo - min[i] <= k) {
                return i;
            }

        }

        return -1;

    }
}