class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] arr = new boolean[101];
        for (int num : nums) {
            arr[num] = true;
        }
        for (int i = k; i <= 100; i = i + k) {
            if (!arr[i]) {
                return i;
            }
        }
        return ((100 / k) + 1) * k;
    }
}