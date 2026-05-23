class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        boolean check = false;
        for (int i =1; i< n; i++) {
            if (nums[i -1] > nums[i]) {
                if (check) return false;
                check = true;
            }
        }
        if (check && nums[0] < nums[n-1]) return false;
        return true;

    }
}