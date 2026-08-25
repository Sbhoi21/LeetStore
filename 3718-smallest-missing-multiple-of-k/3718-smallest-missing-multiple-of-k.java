class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] arr = new boolean[101];
        for (int num : nums) {
            if (num % k == 0 && num / k <= 100) {
                arr[num / k] = true;
            }
        }
        for (int i = 1; i <= 100; i++) {
            if (!arr[i]) {
                return i * k;
            }
        }
        return k * 101;
    }
}