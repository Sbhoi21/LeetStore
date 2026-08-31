class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 1;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minI = 0, maxI = 0;
        for (int i = 0; i < n; i++) {
            if (min > nums[i]) {
                min = nums[i];
                minI = i + 1;
            }
            if (max < nums[i]) {
                max = nums[i];
                maxI = i + 1;
            }
        }

        int r1 = n - minI + 1;
        int r2 = n - maxI + 1;

        if (minI < r1 && maxI < r2) {
            return Math.max(minI, maxI);
        }
        if (minI >= r1 && maxI >= r2) {
            return Math.max(r1, r2);
        }

        System.out.println("l1:  " + minI + "   l2:  " + maxI + "   r1: " + r1 + "  r2:  " + r2);

        if (minI < maxI) {
            return Math.min(minI + r2, Math.min(maxI, r1));
        } else {
            return Math.min(maxI + r1, Math.min(minI, r2));
        }
    }
}