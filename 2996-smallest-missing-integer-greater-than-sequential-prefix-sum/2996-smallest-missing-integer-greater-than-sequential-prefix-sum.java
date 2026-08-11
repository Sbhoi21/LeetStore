class Solution {
    public int missingInteger(int[] nums) {
        int sum = 0;
        int sequence = 0;
        Set set = new HashSet<Integer>();
        for (int n : nums)
            set.add(n);

        int i = 0;
        while (i < nums.length) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
                i++;
                continue;
            }
            break;
        }

        while (true) {
            if (!set.contains(sum)) {
                return sum;
            }
            sum++;
        }
    }
}